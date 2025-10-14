<template>
  <transition
    appear
    enter-active-class="animated slideInDown"
    leave-active-class="animated slideOutUp"
  >
    <q-header elevated class="text-black bg-white">
      <q-toolbar class="q-py-sm">
        <!-- LOGO Y NOMBRE -->
        <div class="row window-width items-center justify-between">
          <div class="col-auto">
            <q-toolbar-title>
              <div
                class="row items-center"
                style="cursor: pointer"
                @click="$router.push({ name: 'welcome' })"
              >
                <q-img
                  src="../../../public/icons/Virtus_simbolo.png"
                  transition="fade"
                  spinner-color="black"
                  width="50px"
                  height="50px"
                />
                <div class="col-auto self-center">
                  <h5 class="text-h5 text-secondary q-my-sm">VIRTUS</h5>
                </div>
              </div>
            </q-toolbar-title>
          </div>
          <q-space />
          <!-- LINKS VISTA DESKTOP -->
          <div class="row justify-end items-center gt-sm">
            <q-tabs inline-label no-caps>
              <div class="column fit justify-center" v-for="(link, i) in links" :key="i">
                <div v-if="link.type == 'q-tab'">
                  <q-route-tab
                    exact
                    :to="{ name: link.routeName }"
                    :name="link.title"
                    :label="link.title"
                  />
                </div>
                <div v-else-if="link.type == 'q-drop'" class="fit">
                  <q-btn-dropdown
                    dropdown-icon="fa fa-chevron-down"
                    class="fit"
                    auto-close
                    stretch
                    flat
                    no-caps
                    :label="link.titleDrop"
                  >
                    <q-list>
                      <q-item
                        v-for="(linkDrop, i) in link.linksDrop"
                        :key="i"
                        :to="{ name: linkDrop.routeName }"
                        clickable
                        :label="linkDrop.titleDown"
                      >
                        <q-item-section>{{ linkDrop.titleDown }}</q-item-section>
                      </q-item>
                    </q-list>
                  </q-btn-dropdown>
                </div>
              </div>
            </q-tabs>
          </div>
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
              cursor-none
              class="self-end"
              size="50px"
              style="cursor: pointer"
              @click="$router.push({ name: 'profile' })"
            >
              <img :src="img.src" />
            </q-avatar>
          </div>
          <!-- LINKS VISTA MOVIL -->
          <div class="col-auto lt-md">
            <MenuMovil :links="links" />
          </div>
        </div>
      </q-toolbar>
    </q-header>
  </transition>
</template>

<script>
import MenuMovil from "components/Menu/MenuMovil";
export default {
  name: "HeaderComponent",
  components: {
    MenuMovil,
  },
  props: {
    menuBtnAction: {
      type: Function,
      default: () => {},
    },
  },
  data() {
    return {
      img: {
        src: require("../../assets/imagen/team_1.jpg"),
      },
      lang: this.$i18n.locale,
      langOptions: [
        { value: "es", label: "Español" },
        { value: "en-us", label: "English" },
      ],
    };
  },

  computed: {
    links() {
      return [
        {
          type: "q-tab",
          title: this.$t("General.home"),
          routeName: "welcome",
        },
        {
          type: "q-tab",
          title: this.$t("CardCourse.course"),
          routeName: "adminView",
        },
        {
          type: "q-drop",
          titleDrop: this.$t("General.library"),
          linksDrop: [
            {
              titleDown: this.$t("General.video"),
              routeName: "galleryVideo",
            },
            {
              titleDown: this.$t("General.img"),
              routeName: "galleryPhoto",
            },
          ],
        },
        {
          type: "q-tab",
          title: this.$t("General.events"),
          routeName: "welcome",
        },
        {
          type: "q-tab",
          title: this.$t("Btn.forum"),
          routeName: "welcome",
        },
        {
          type: "q-tab",
          title: this.$t("General.blog"),
          routeName: "welcome",
        },
      ];
    },
  },
  watch: {
    lang(lang) {
      this.$i18n.locale = lang;
    },
  },
};
</script>
