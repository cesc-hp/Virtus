<template>
  <div class="row full-width justify-center q-pt-none ">
    <div class="col-8" v-if="content.type === 'video'">
      <div class="float-right">
        <q-btn round size="sm" color="primary" icon="fas fa-times" />
      </div>
      <VideoContent :content="content"></VideoContent>
    </div>
    <div class="col-7" v-else-if="content.type === 'img'">
      <div class="float-right">
        <q-btn round size="sm" color="primary" icon="fas fa-times" />
      </div>
      <ImgContent :content="content"></ImgContent>
    </div>
    <div class="col-7" v-else-if="content.type === 'text'">
      <div class="float-right">
        <q-btn round size="sm" color="primary" icon="fas fa-times" />
      </div>
      <TextContent :content="content"></TextContent>
    </div>
  </div>
</template>

<script>
import VideoContent from "../Content/VideoContent";
import ImgContent from "../Content/ImgContent";
import TextContent from "../Content/TextContent";

export default {
  name: "ContentSelect",
  components: {
    VideoContent,
    ImgContent,
    TextContent
  },
  props: {
    content: {
      type: Object,
      required: true
    }
  },

  data() {
    return {};
  }
};
</script>
