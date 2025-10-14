<template>
  <div class="fit">
    <q-list>
      <q-item v-ripple>
        <q-input label="Buscar..." class="full-width" />
      </q-item>
    </q-list>

    <q-scroll-area style="height: 400px">
      <q-list separator>
        <q-item class="row" v-for="file in files" :key="file.id" clickable v-ripple>
          <q-item-section class="col-auto" side @click="videoSelect(file)">
            <q-icon size="xs" name="fa fa-play" color="secondary" />
          </q-item-section>
          <p
            class="col text-h6 text-secondary q-mb-none ellipsis"
            @click="videoSelect(file)"
          >
            {{ file.title }}
          </p>
          <q-item-section v-if="select == false" class="col-auto q-px-sm" side>
            <q-icon
              size="xs"
              name="fas fa-edit"
              @click="(dialogEdit = true), (fileEdit = file)"
              color="secondary"
            />
          </q-item-section>
          <q-item-section v-if="select == false" class="col-auto q-pr-xs" side>
            <q-icon
              size="xs"
              name="fas fa-trash"
              @click="(dialogDelet = true), (fileDel = file)"
              color="primary"
            />
          </q-item-section>
        </q-item>
      </q-list>
    </q-scroll-area>
    <q-dialog v-model="dialogEdit">
      <DialogEditVideo
        :fileEdit="fileEdit"
        @closedialog="dialogEdit = false"
        @updatevideo="updateVideo"
      />
    </q-dialog>
    <q-dialog v-model="dialogDelet">
      <DialogDel @deleted="deletedFile()" />
    </q-dialog>
  </div>
</template>

<script>
import DialogDel from "../Dialog/DialogDel";
import DialogEditVideo from "../Dialog/DialogEditVideo";
import { contentMutations } from "../../graphql/content";

export default {
  name: "VideoList",
  components: {
    DialogDel,
    DialogEditVideo,
  },
  props: {
    files: {
      type: Array,
      required: true,
    },
    select: {
      type: Boolean,
    },
  },
  data() {
    return {
      dialogDelet: false,
      dialogEdit: false,
      fileDel: null,
      fileEdit: null,
    };
  },
  methods: {
    videoSelect(file) {
      this.$emit("videoselect", file);
    },
    updateVideo(file, id) {
      console.log(file + " " + id);
      this.dialogEdit = false;
      this.$apollo
        .mutate({
          mutation: contentMutations.updateVideo,
          variables: {
            id: id,
            title: file.title,
            description: file.description,
          },
          update: (store, { data: { updateVideo } }) => {
            this.files.find((vid) => {
              if (vid.id === id) {
                vid.title = updateVideo.title;
                vid.description = updateVideo.description;
              }
            });
          },
        })
        .catch((error) => {
          this.error = error;
        });
    },
    deletedFile() {
      this.$emit("deletedfile", this.fileDel);
    },
  },
};
</script>
