<template>
  <div class="items-center">
    <div class="q-pa-md">
      <div
        class="text-h5 q-pt-md text-secondary text-center"
        v-html="content.text"
      ></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TextContent",
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
