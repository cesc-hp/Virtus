<template>
  <q-layout view="lHh Lpr lFf">
    <HeaderComponent />
    <q-page-container>
      <router-view />
    </q-page-container>
    <FooterComponent />
  </q-layout>
</template>

<script>
import { mapMutations } from "vuex";
import HeaderComponent from "src/components/Header/HeaderComponent.vue";
import FooterComponent from "src/components/Footer/FooterComponent.vue";

export default {
  components: { HeaderComponent, FooterComponent },
  name: "MainLayout",
  data() {
    return {};
  }
};
</script>
