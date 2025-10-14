<template>
  <q-page class="row items-center justify-center">
    <GalleryStructure :file="file"></GalleryStructure>
  </q-page>
</template>

<script>
import GalleryStructure from "../../components/Gallery/GalleryStructure";

export default {
  components: {
    GalleryStructure
  },
  data() {
    return {
      file: {
        type: "img",
        arrFile: Array(9)
          .fill(null)
          .map((_, i) => "https://picsum.photos/id/" + i + "/500/300")
      }
    };
  }
};
</script>
