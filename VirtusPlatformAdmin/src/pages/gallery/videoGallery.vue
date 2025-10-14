<template>
  <q-page class="row q-pa-md bg-grey-3">
    <div
      class="col-8 column self-center"
      :class="{ 'full-width': $q.screen.lt.md, 'q-pr-md': $q.screen.gt.sm }"
    >
      <div
        class="row full-width justify-center items-center text-center text-h4 text-secondary"
        v-if="sources[0].src === ''"
      >
        {{ $t("Gallery.notVideo") }}
      </div>
      <div v-else class="full-width">
        <q-media-player
          class="pointer"
          style="cursor: pointer"
          type="video"
          :sources="sources"
        />
        <div class="row q-pt-xs">
          <q-item-section class="self-center" side top>
            <q-icon name="fa fa-play" color="secondary" />
          </q-item-section>
          <q-item-section>
            <q-item-label :lines="1">{{ fileSelect.title }}</q-item-label>
            <q-item-label caption :lines="2">
              {{ fileSelect.description }}
            </q-item-label>
          </q-item-section>
        </div>
      </div>
    </div>
    <div class="col-4 column" :class="{ 'full-width q-pt-md': $q.screen.lt.md }">
      <VideoList :files="files" @videoselect="videoSelect" @deletedfile="deletedFile" />
    </div>
    <q-page-sticky position="bottom-right" :offset="[18, 18]">
      <q-btn
        fab
        icon="fas fa-plus"
        @click="openDialogo('TYPE_VIDEO')"
        color="secondary"
      />
    </q-page-sticky>
    <q-dialog persistent v-model="openDia">
      <DialogUp :typeFile="typeFile" @emitupload="emitUpload"></DialogUp>
    </q-dialog>
  </q-page>
</template>

<script>
import { contentMutations, contentQueries } from "../../graphql/content";
import DialogUp from "../../components/Content/DialogUp";
import VideoList from "../../components/Gallery/VideoList";

export default {
  components: {
    DialogUp,
    VideoList,
  },
  data() {
    return {
      baseUrl: "http://localhost:8000/assets",
      files: [],
      fileSelect: {
        title: "",
        description: "",
      },
      description:
        "Dfescription for the video Dfescription for the videoDfescription for the deo Dfescription for the videoDfescription for th",
      sources: [
        {
          src: "",
          type: "video/mp4",
        },
      ],
      openDia: false,
      typeFile: "",
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: contentQueries.getAllVideo,
      })
      .then((data) => {
        this.files = data.data.getAllVideo;
        if (this.files.length > 0) {
          this.sources[0].src = this.baseUrl + this.files[0].url;
          this.fileSelect.title = this.files[0].title;
          this.fileSelect.description = this.files[0].description;
        }
        console.log(this.files);
      });
  },

  methods: {
    videoSelect(file) {
      this.fileSelect.title = file.title;
      this.fileSelect.description = file.description;
      this.sources[0].src = this.baseUrl + file.url;
    },
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
          mutation: contentMutations.newVideo,
          variables: {
            file: elemnt.file,
            title: elemnt.title,
            description: elemnt.description,
          },
        })
        .then((data) => {
          this.files.push(data.data.newVideo);
        })
        .catch((error) => {
          this.error = error;
        });
    },
    deletedFile(file) {
      console.log(file.id);
      this.$apollo.mutate({
        mutation: contentMutations.deleteVideo,
        variables: {
          id: file.id,
        },
        update: (store, { data: { deleteVideo } }) => {
          if (deleteVideo == true) {
            let pos;
            this.files.forEach(function (elemento, indice) {
              if (elemento.id === file.id) {
                pos = indice;
              }
            });
            if (this.name == file.name) {
              this.name = "";
              this.sources[0].src = "";
            }
            this.files.splice(pos, 1);
          }
        },
      });
    },
  },
};
</script>
