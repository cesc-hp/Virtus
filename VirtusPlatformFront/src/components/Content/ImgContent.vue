<template>
  <div class="items-center">
    <div class="q-pa-md">
      <div class="text-h6 q-pt-md">
        {{ content.name }}
      </div>
      <q-img :src="content.url" :ratio="2" native-context-menu> </q-img>
    </div>
  </div>
</template>

<script>
export default {
  name: "ImgContent",
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
