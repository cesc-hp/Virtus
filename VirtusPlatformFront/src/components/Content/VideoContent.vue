<template>
  <div class="items-center">
    <div class="text-h5 q-pt-md">{{ content.name }}</div>
    <div class="q-pb-lg">
      <q-video
        :ratio="2"
        src="https://www.youtube.com/embed/k3_tw44QsZQ?rel=0"
      />
    </div>
  </div>
</template>

<script>
export default {
  name: "VideoContent",
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
