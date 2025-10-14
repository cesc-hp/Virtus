<template>
  <div class="items-center">
    <div class="q-pa-md">
      <div class="text-h5 q-pt-md text-secondary" v-html="textView.text"></div>
    </div>
  </div>
</template>

<script>
import { contentQueries } from "../../graphql/content";

export default {
  name: "TextContent",
  props: {
    content: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      textView: {
        id: null,
        text: "",
      },
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: contentQueries.textById,
        variables: {
          id: this.content.idType,
        },
      })
      .then((data) => {
        this.textView.id = data.data.textById.id;
        this.textView.text = data.data.textById.text;
      });
  },
};
</script>
