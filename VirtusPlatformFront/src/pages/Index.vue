<template>
  <q-layout view="lHh lpr lFf">
    <q-header
      class="q-py-sm"
      style="background-color: #1c1b21;"
      :style="'border-bottom: 2px solid ' + theme_color"
      reveal
    >
      <q-toolbar>
        <span
          :style="'font-size: 35px;color:' + theme_color"
          class="my-font text-h6 q-mr-md"
          >Virtus</span
        >
        <q-space></q-space>
        <q-tabs v-model="selected_tab" shrink>
          <q-tab
            :style="[
              selected_tab == 't_0' ? { backgroundColor: theme_color } : {}
            ]"
            class="q-mr-sm q-py-xs custom_tab"
            @click="scrollToElement('id_home')"
            style="min-height:auto !important;color: white"
            label="Home"
          />
          <q-tab
            :style="[
              selected_tab == 't_1' ? { backgroundColor: theme_color } : {}
            ]"
            class="q-mr-sm q-py-xs custom_tab"
            @click="scrollToElement('id_about')"
            style="min-height:auto !important;color: white"
            label="Sobre Nosotros"
          />
          <q-tab
            :style="[
              selected_tab == 't_2' ? { backgroundColor: theme_color } : {}
            ]"
            class="q-mr-sm q-py-xs custom_tab"
            @click="scrollToElement('id_formation')"
            style="min-height:auto !important;color: white"
            label="Formación presencial"
          />
          <q-tab
            :style="[
              selected_tab == 't_3' ? { backgroundColor: theme_color } : {}
            ]"
            class="q-mr-sm q-py-xs custom_tab"
            @click="scrollToElement('id_travel')"
            style="min-height:auto !important;color: white"
            label="Historical Travel"
          />
          <q-tab
            :style="[
              selected_tab == 't_4' ? { backgroundColor: theme_color } : {}
            ]"
            class="q-mr-sm q-py-xs custom_tab"
            @click="scrollToElement('id_contact')"
            style="min-height:auto !important;color: white"
            label="Contacto"
          />
          <q-tab
            :style="[
              selected_tab == 't_4' ? { backgroundColor: theme_color } : {}
            ]"
            class="q-mr-sm q-py-xs custom_tab"
            @click="$router.push({ name: 'login' })"
            style="min-height:auto !important;color: white"
            label="Login"
          />
        </q-tabs>
      </q-toolbar>
    </q-header>
    <!-- poner como referencia el mismo nombre del componente -->

    <q-page-container style="padding-top: 0px">
      <q-page>
        <Home ref="Home" id="id_home" />

        <AboutUs ref="AboutUs" id="id_about" />

        <PresentialFormation ref="PresentialFormation" id="id_formation" />

        <HistoricalTravel ref="HistoricalTravel" id="id_travel" />

        <Contact ref="Contact" id="id_contact" />
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script>
import { scroll } from "quasar";
const { getScrollTarget, setScrollPosition } = scroll;

import Home from "./Home";
import AboutUs from "./AboutUs";
import PresentialFormation from "./PresentialFormation";
import HistoricalTravel from "./HistoricalTravel";
import Contact from "./Contact";

export default {
  name: "PageIndex",
  components: {
    Home,
    AboutUs,
    PresentialFormation,
    HistoricalTravel,
    Contact
  },
  data() {
    return {
      selected_tab: "t_0",
      bg_color: "rgb(0, 163, 82)",
      theme_color: "rgb(0, 163, 82)",
      background_style: "background-color:rgba(0, 163, 82, 0.7);"
    };
  },

  methods: {
    scrollToElement(id) {
      let el = document.getElementById(id);
      const target = getScrollTarget(el);
      const offset = el.offsetTop + 3;
      const duration = 900;
      setScrollPosition(target, offset, duration);
    },
    changeBgColor() {
      this.theme_color = this.bg_color;
      this.background_style =
        "background-color:" + this.bg_color.split(")")[0] + ",0.7)";
    }
  }
};
</script>
