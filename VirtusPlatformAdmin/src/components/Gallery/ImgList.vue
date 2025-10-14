<template>
  <div
    v-if="created != ''"
    class="col-xs-12 col-sm-11 col-md-11 col-lg-11 column q-pa-md"
  >
    <div class="text-subtitle1 text-secondary">{{ files[0].created }}</div>
    <div class="row full-width q-gutter-xs scroll relative-position">
      <q-img
        v-for="file in files"
        :key="file.id"
        class="col-xs-4 col-sm-4 col-md-2 items-center q-ma-xs pointer rounded-borders"
        style="cursor: pointer"
        :src="baseUrl + file.url"
        :ratio="4 / 3"
        @click="dialogFile(true, file.id)"
      >
        <q-btn
          round
          size="sm"
          color="primary"
          icon="fas fa-times"
          class="absolute-top-right q-mr-xs q-mt-xs"
          :class="{ hidden: select == true }"
          @click.stop="(dialogDelet = true), (imgDel = file)"
        />
      </q-img>
      <div></div>
    </div>
    <q-dialog
      class="col-xs-12 col-sm-10 col-md-10 col-lg-10 column items-center full-width"
      v-model="toggle"
    >
      <q-img class="items-center q-pa-sm pointer" :src="baseUrl + urlSelect" />
    </q-dialog>
    <q-dialog v-model="dialogDelet">
      <DialogDel @deleted="deletedImg" />
    </q-dialog>
  </div>
</template>

<script>
import DialogDel from "../Dialog/DialogDel";

export default {
  components: {
    DialogDel,
  },
  name: "ImgList",
  props: {
    created: {
      type: String,
      required: true,
    },
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
      imgDel: Object,
      baseUrl: "http://localhost:8000/assets",
      toggle: false,
      urlSelect: "",
    };
  },
  methods: {
    dialogFile(state, index) {
      if (this.select == true) {
        this.$emit("imgselect", index);
      } else {
        this.toggle = state;
        this.files.map((x) => {
          if (x.id == index) {
            return (this.urlSelect = x.url);
          }
        });
      }
    },
    deletedImg() {
      this.$emit("deletedimg", this.imgDel);
    },
  },
};
</script>
