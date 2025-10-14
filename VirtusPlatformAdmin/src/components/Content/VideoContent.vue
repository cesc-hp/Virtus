<template>
  <div class="items-center">
    <div class="q-pa-md">
      <div class="text-h6 q-pt-md gt-sm">
        {{ video.name }}
      </div>
      <div class="q-pb-lg">
        <q-media-player type="video" :sources="sources" />
      </div>
    </div>
  </div>
</template>

<script>
import { contentQueries } from "../../graphql/content";

export default {
  name: "VideoContent",
  props: {
    content: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      baseUrl: "http://localhost:8000/assets",
      video: {
        id: null,
        url: "",
        name: "",
      },
      sources: [
        {
          src: "",
          type: "video/mp4",
        },
      ],
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: contentQueries.videoById,
        variables: {
          id: this.content.idType,
        },
      })
      .then((data) => {
        this.video.id = data.data.videoById.id;
        this.video.url = data.data.videoById.url;
        this.video.name = data.data.videoById.name;
        this.sources[0].src = this.baseUrl + this.video.url;
      });
  },
};
</script>
