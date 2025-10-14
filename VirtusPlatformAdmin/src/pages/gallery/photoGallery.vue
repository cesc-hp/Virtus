<template>
  <q-page
    class="row justify-center bg-grey-3"
    :class="{ 'content-start': fileXCreated[0].created != '' }"
  >
    <div
      v-if="fileXCreated[0].created === ''"
      class="items-center text-center col self-center text-h4 text-secondary"
    >
      {{ $t("Gallery.notImg") }}
    </div>
    <ImgList
      v-else
      v-for="x in fileXCreated"
      :key="x.id"
      :files="x.imgXCreat"
      :created="x.created"
      @deletedimg="deletedImg"
    ></ImgList>
    <q-page-sticky position="bottom-right" :offset="[18, 18]">
      <q-btn fab icon="fas fa-plus" @click="openDialogo('TYPE_FOTO')" color="secondary" />
    </q-page-sticky>
    <q-dialog persistent v-model="openDia">
      <DialogUp :typeFile="typeFile" @emitupload="emitUpload"></DialogUp>
    </q-dialog>
  </q-page>
</template>

<script>
import { morph } from "quasar";
import { contentMutations, contentQueries } from "../../graphql/content";
import ImgList from "../../components/Gallery/ImgList";
import DialogUp from "../../components/Content/DialogUp";
import { GalleryGetAllImg } from "../../mixins/gallery/galleryGetAllImg";

export default {
  mixins: [GalleryGetAllImg],
  components: {
    DialogUp,
    ImgList,
  },
  data() {
    return {
      openDia: false,
      typeFile: "",
      filter: {
        key: "",
        value: "",
      },
    };
  },

  mounted() {
    this.getAllImg();
  },

  methods: {
    openDialogo(type) {
      this.typeFile = type;
      this.openDia = true;
    },
    emitUpload(elemnt, type, close) {
      if (!close) {
        this.openDia = false;
      }
      this.$apollo
        .mutate({
          mutation: contentMutations.newImg,
          variables: {
            file: elemnt.file,
            description: elemnt.description,
          },
        })
        .then((data) => {
          console.log(this.fileXCreated);
          if (this.fileXCreated[0].created == "") {
            this.fileXCreated[0].created = data.data.newImg.created;
            this.fileXCreated[0].imgXCreat[0] = data.data.newImg;
          } else {
            let y = 0;
            var existCreat = true;
            while (y < this.fileXCreated.length) {
              if (this.fileXCreated[y].created == data.data.newImg.created) {
                this.fileXCreated[y].imgXCreat.push(data.data.newImg);
                existCreat = true;
                break;
              } else {
                existCreat = false;
              }
              y++;
            }
            if (existCreat == false) {
              var parCreatImg = {
                created: data.data.newImg.created,
                imgXCreat: [data.data.newImg],
              };
              this.fileXCreated.push(parCreatImg);
            }
          }
        })
        .catch((error) => {
          this.error = error;
        });
    },

    deletedImg(img) {
      this.$apollo.mutate({
        mutation: contentMutations.deleteImg,
        variables: {
          id: img.id,
        },
        update: (store, { data: { deleteImg } }) => {
          if (deleteImg == true) {
            let filePos = null;
            let pos = null;
            this.fileXCreated.forEach(function (elemento, x) {
              if (elemento.created === img.created) {
                elemento.imgXCreat.forEach(function (element, y) {
                  if (element.id === img.id) {
                    pos = y;
                  }
                });
                elemento.imgXCreat.splice(pos, 1);

                if (elemento.imgXCreat.length == 0) {
                  console.log(elemento.imgXCreat.length == 0);
                  elemento.created = "";
                  filePos = x;
                }
              }
            });
            if (filePos != null) {
              if (this.fileXCreated.length > 1) {
                this.fileXCreated.splice(filePos, 1);
              } else {
                this.fileXCreated[filePos].created = "";
              }
            }
          }
        },
      });
    },
  },
};
</script>
