<template>
  <q-page class="row justify-center bg-grey-3">
    <div class="col-xs-11 col-sm-11 col-md-11 col-lg-11 column items-center">
      <div class="row justify-start full-width q-pl-md q-mt-md">
        <div class="row full-width justify-star">
          <q-breadcrumbs>
            <q-breadcrumbs-el icon="fas fa-home" :to="{ name: 'course' }" />
            <q-breadcrumbs-el :label="courseName" :to="{ name: 'module' }" />
            <q-breadcrumbs-el :label="moudleName" :to="{ name: 'lesson' }" />
            <q-breadcrumbs-el :label="lessonName" />
          </q-breadcrumbs>
        </div>
        <div
          class="row full-width justify-center items-center text-h4 text-secondary q-pt-xl q-mt-lg"
          v-if="contentsList.length === 0"
        >
          {{ $t("General.addContToLess") }}
        </div>
        <div class="row full-width justify-center">
          <ContentSelect
            v-for="content in contentsList"
            :key="content.id"
            :content="content"
            @deletedcont="deletedCont"
          >
          </ContentSelect>
        </div>
      </div>
    </div>
    <!--Button float for add contents-->
    <q-page-sticky position="bottom-right" :offset="[15, 15]">
      <q-fab
        vertical-actions-align="right"
        color="secondary"
        active-icon="fas fa-times"
        icon="fas fa-plus"
        direction="up"
      >
        <q-fab-action
          label-position="left"
          color="primary"
          @click="openDialogo('TYPE_VIDEO')"
          icon="fas fa-video"
          :label="$t('General.video')"
        />
        <q-fab-action
          label-position="left"
          color="primary"
          @click="openDialogo('TYPE_FOTO')"
          icon="fas fa-camera"
          :label="$t('General.img')"
        />
        <q-fab-action
          label-position="left"
          color="primary"
          @click="openDialogo('TYPE_TEXT')"
          icon="fas fa-marker"
          :label="$t('General.text')"
        />
      </q-fab>
    </q-page-sticky>
    <!--Dialog for upload content-->
    <q-dialog style="width: 700px; max-width: 80vw" v-model="isOpenSelect">
      <q-card style="min-height: 400px" class="full-width q-ma-md">
        <q-tabs
          v-model="tab"
          dense
          class="text-grey bg-grey-3"
          active-color="secondary"
          indicator-color="secondary"
          align="justify"
          narrow-indicator
        >
          <q-tab name="home" label="Home" />
          <q-tab name="repo" label="Biblioteca" />
        </q-tabs>

        <q-separator />

        <q-tab-panels v-model="tab" animated>
          <q-tab-panel name="home" class="q-pa-none">
            <DialogUp :typeFile="typeFile" @emitupload="emitUpload"></DialogUp>
          </q-tab-panel>

          <q-tab-panel name="repo">
            <!-- Upload Video -->
            <div v-if="typeFile == 'TYPE_VIDEO'">
              <div
                v-if="listVideos.length == 0"
                class="text-h4 text-secondary text-center"
              >
                No hay videos en el repo
              </div>
              <VideoList
                v-else
                :select="true"
                :files="listVideos"
                @videoselect="videoSelect"
              />
            </div>
            <!-- Upload Img -->
            <div v-if="typeFile == 'TYPE_FOTO'">
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
                :select="true"
                @imgselect="imgSelect"
              ></ImgList>
            </div>
          </q-tab-panel>
        </q-tab-panels>
      </q-card>
    </q-dialog>
    <q-dialog persistent v-model="openDia">
      <DialogUp :typeFile="typeFile" @emitupload="emitUpload"></DialogUp>
    </q-dialog>
  </q-page>
</template>

<script>
import ContentSelect from "../../components/Content/ContentSelect";
import { lessonQueries } from "../../graphql/lesson";
import DialogUp from "../../components/Content/DialogUp";
import { contentMutations, contentQueries } from "../../graphql/content";
import VideoList from "../../components/Gallery/VideoList";
import ImgList from "../../components/Gallery/ImgList";
import { FileService } from "../../mixins/fileService";
import { GalleryGetAllImg } from "../../mixins/gallery/galleryGetAllImg";

export default {
  mixins: [FileService, GalleryGetAllImg],
  components: {
    ContentSelect,
    DialogUp,
    VideoList,
    ImgList,
  },

  data() {
    return {
      tab: "home",
      openDia: false,
      isOpenSelect: false,
      typeFile: "",
      contents: Object,
      routeIdLess: this.$route.params.idLesson,
      courseName: "",
      moudleName: "",
      lessonName: "",
      contentsList: Array,
      listVideos: [],
      listImg: [],
      fileXCreated: [
        {
          created: "",
          imgXCreat: [],
        },
      ],
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: lessonQueries.contOfModId,
        variables: {
          id: this.routeIdLess,
        },
      })
      .then((data) => {
        this.contentsList = data.data.lessonById.contents;
        this.courseName = data.data.lessonById.module.course.name;
        this.moudleName = data.data.lessonById.module.title;
        this.lessonName = data.data.lessonById.title;
      });
  },

  methods: {
    emitUpload(elemnt, type, close) {
      if (!close) {
        this.openDia = false;
        this.isOpenSelect = false;
      }
      switch (type) {
        case "TYPE_FOTO":
          this.$apollo
            .mutate({
              mutation: contentMutations.newImg,
              variables: {
                file: elemnt.file,
                description: elemnt.description,
              },
              update: (store, { data: { newImg } }) => {
                this.newCont(newImg.id, type);
              },
            })
            .catch((error) => {
              this.error = error;
            });
          break;
        case "TYPE_VIDEO":
          this.$apollo
            .mutate({
              mutation: contentMutations.newVideo,
              variables: {
                file: elemnt.file,
                title: elemnt.title,
                description: elemnt.description,
              },
              update: (store, { data: { newVideo } }) => {
                this.newCont(newVideo.id, type);
              },
            })
            .catch((error) => {
              this.error = error;
            });
          break;
        case "TYPE_TEXT":
          this.$apollo
            .mutate({
              mutation: contentMutations.newText,
              variables: {
                text: elemnt,
              },
              update: (store, { data: { newText } }) => {
                this.newCont(newText.id, type);
              },
            })
            .catch((error) => {
              this.error = error;
            });
          break;
      }
    },

    deletedCont(id, type) {
      this.$apollo.mutate({
        mutation: contentMutations.deleteContent,
        variables: {
          id: id,
        },
        update: (store, { data: { deleteContent } }) => {
          let pos;
          let typeId;
          this.contentsList.forEach(function (elemento, indice) {
            if (elemento.id === id) {
              pos = indice;
              typeId = elemento.idType;
            }
          });
          this.contentsList.splice(pos, 1);
          if (type === "TYPE_TEXT") {
            this.$apollo.mutate({
              mutation: contentMutations.deleteText,
              variables: {
                id: typeId,
              },
            });
          }
        },
      });
    },

    videoSelect(file) {
      console.log(file);
      this.newCont(file.id, this.typeFile);
      this.isOpenSelect = false;
    },
    imgSelect(id) {
      console.log(id);
      this.newCont(id, this.typeFile);
      this.isOpenSelect = false;
    },
    // Refactorizar este codigo en js para las llamadas al API y simplificar codigo repetitivo
    openDialogo(type) {
      this.typeFile = type;
      if (type == "TYPE_TEXT") {
        this.openDia = true;
      } else if (type == "TYPE_VIDEO") {
        this.isOpenSelect = true;
        this.$apollo
          .query({
            query: contentQueries.getAllVideo,
          })
          .then((data) => {
            this.listVideos = data.data.getAllVideo;
            console.log(this.listVideos);
          });
      } else if (type == "TYPE_FOTO") {
        this.isOpenSelect = true;
        this.getAllImg();
      }
    },
  },
};
</script>
