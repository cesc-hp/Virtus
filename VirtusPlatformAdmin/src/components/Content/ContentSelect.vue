<template>
  <div class="row full-width justify-center q-pt-none">
    <div
      class="col-xs-12 col-sm-12 col-md-12 col-lg-11"
      v-if="content.typeContent === 'TYPE_VIDEO'"
    >
      <div class="float-right">
        <q-btn
          round
          size="sm"
          color="primary"
          icon="fas fa-times"
          @click="dialogDelet = true"
        />
      </div>
      <VideoContent :content="content"></VideoContent>
    </div>
    <div
      class="col-xs-10 col-sm-10 col-md-10 col-lg-9 q-mx-xs"
      v-else-if="content.typeContent === 'TYPE_FOTO'"
    >
      <div class="float-right">
        <q-btn
          round
          size="sm"
          color="primary"
          icon="fas fa-times"
          @click="dialogDelet = true"
        />
      </div>
      <ImgContent :content="content"></ImgContent>
    </div>
    <div
      class="col-xs-12 col-sm-12 col-md-12 col-lg-11"
      v-else-if="content.typeContent === 'TYPE_TEXT'"
    >
      <div class="float-right">
        <q-btn
          round
          size="sm"
          color="primary"
          icon="fas fa-times"
          @click="dialogDelet = true"
        />
      </div>
      <TextContent :content="content"></TextContent>
    </div>
    <q-dialog v-model="dialogDelet">
      <DialogDel @deleted="deletedContent" />
    </q-dialog>
  </div>
</template>

<script>
import VideoContent from "../Content/VideoContent";
import ImgContent from "../Content/ImgContent";
import TextContent from "../Content/TextContent";
import DialogDel from "../Dialog/DialogDel";

export default {
  name: "ContentSelect",
  components: {
    VideoContent,
    ImgContent,
    TextContent,
    DialogDel,
  },
  props: {
    content: {
      type: Object,
      required: true,
    },
  },

  data() {
    return {
      dialogDelet: false,
    };
  },
  methods: {
    deletedContent() {
      this.$emit("deletedcont", this.content.id, this.content.typeContent);
    },
  },
};
</script>
