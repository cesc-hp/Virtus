<template>
  <q-layout view="hHh LpR fFf">
    <!-- HEADER -->
    <transition
      appear
      enter-active-class="animated slideInDown"
      leave-active-class="animated slideOutUp"
    >
      <q-header elevated class="text-black bg-white">
        <q-toolbar class="q-py-sm">
          <!-- BOTÓN DE ABRIR Y CERRAR MENÚ -->
          <q-btn
            dense
            flat
            round
            icon="menu"
            text-color="secondary"
            @click="setVisibleDrawer"
          />
          <!-- LOGO Y NOMBRE -->
          <div class="row window-width items-center justify-between">
            <div
              class="col-auto"
              style="cursor: pointer"
              @click="$router.push({ name: 'home' })"
            >
              <q-toolbar-title>
                <div class="row items-center">
                  <q-img
                    :src="require('src/assets/Virtus_simbolo.png')"
                    transition="fade"
                    spinner-color="black"
                    width="50px"
                    height="50px"
                  />
                  <div class="col-auto self-center">
                    <h5 class="text-h5 text-secondary q-my-sm">
                      {{ $t("General.nameSite") }}
                    </h5>
                  </div>
                </div>
              </q-toolbar-title>
            </div>
            <q-space />
            <!-- INTERNACIONALIZACION -->
            <div class="col-auto gt-sm q-pl-sm">
              <q-select
                v-model="lang"
                :options="langOptions"
                label="Idioma"
                dense
                borderless
                emit-value
                map-options
                options-dense
                style="min-width: 80px"
              />
            </div>
            <!-- AVATAR DE USUARIO -->
            <div class="col-auto gt-sm q-pl-sm">
              <q-avatar
                class="self-end"
                size="50px"
                style="cursor: pointer"
                @click="$router.push({ name: 'profile' })"
              >
                <img :src="img.src" />
              </q-avatar>
            </div>
          </div>
        </q-toolbar>
      </q-header>
    </transition>

    <!-- MENÚ LATERAL -->
    <q-drawer
      ref="drawer"
      v-model="showDrawer"
      show-if-above
      :mini="miniState"
      bordered
      :width="250"
    >
      <div class="fit text-primary text-weight-bold q-pt-md">
        <div v-if="$q.screen.lt.md" class="q-pt-md text-center full-width">
          <q-avatar>
            <img :src="img.src" />
          </q-avatar>
          <!-- Nombre del user -->
          <span class="q-pl-md">Jhon Smith</span>
          <q-separator spaced />
        </div>
        <q-list>
          <q-scroll-area style="height: 85vh">
            <EssentialLink
              v-for="link in essentialLinks"
              :key="link.title"
              v-bind="link"
            />
            <q-separator spaced v-if="$q.screen.lt.md" />
          </q-scroll-area>
        </q-list>
      </div>
    </q-drawer>

    <!-- CONTENIDO -->
    <q-page-container>
      <transition appear enter-active-class="animated slideInUp">
        <router-view />
      </transition>
    </q-page-container>
  </q-layout>
</template>

<script>
import EssentialLink from "components/EssentialLink.vue";

export default {
  name: "MainLayout",
  components: {
    EssentialLink,
  },
  data() {
    return {
      img: {
        src: require("src/assets/imagen/not_img_profile.png"),
      },
      miniState: false,
      showDrawer: true,
      lang: this.$i18n.locale,
      langOptions: [
        { value: "es", label: "Español" },
        { value: "en-us", label: "English" },
      ],
    };
  },
  computed: {
    essentialLinks: function () {
      var links = [
        {
          title: this.$t("MenuTitle.courseName"),
          icon: "fas fa-tasks",
          link: { name: "course" },
        },
        {
          title: this.$t("MenuTitle.galleryName"),
          icon: "fas fa-folder",
          children: [
            {
              title: this.$t("MenuTitle.videoName"),
              icon: "fas fa-video",
              link: { name: "galleryVideo" },
            },
            {
              title: this.$t("MenuTitle.imgName"),
              link: { name: "galleryPhoto" },
            },
          ],
        },
        {
          title: this.$t("MenuTitle.profileName"),
          icon: "fas fa-user",
          link: { name: "profile" },
        },
        {
          title: this.$t("MenuTitle.signOff"),
          icon: "fas fa-power-off",
          link: { name: "login" },
        },
      ];
      return links;
    },
  },
  watch: {
    lang(lang) {
      this.$i18n.locale = lang;
    },
  },
  methods: {
    setVisibleDrawer() {
      if (!this.$q.screen.lt.md) {
        this.miniState = !this.miniState;
      } else {
        this.showDrawer = !this.showDrawer;
      }
    },
  },
};
</script>
