<template>
  <div class="items-center">
    <div class="q-pa-md">
      <div class="text-h6 q-pt-md gt-sm">
        {{ img.name }}
      </div>
      <div>
        <q-img :src="img.url" spinner-color="white" />
      </div>
    </div>
  </div>
</template>

<script>
import { contentQueries } from "../../graphql/content";

export default {
  name: "ImgContent",
  props: {
    content: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      baseUrl: "http://localhost:8000/assets",
      img: {
        id: null,
        url: "",
        name: "",
      },
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: contentQueries.imgById,
        variables: {
          id: this.content.idType,
        },
      })
      .then((data) => {
        this.img.id = data.data.imgById.id;
        this.img.url = this.baseUrl + data.data.imgById.url;
        this.img.name = data.data.imgById.name;
      });
  },
};
</script>
