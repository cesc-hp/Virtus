<template>
  <q-page class="row justify-center">
    <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 column items-center">
      <div class="row justify-start full-width">
        <div class="row full-width justify-star q-pl-md">
          <!-- TODO: Menu de navegacion add to i18n -->
          <h4
            class="col text-h4 text-secondary text-weight-bolder q-my-md float-left"
            style="font-family: Lovato"
          >
            Administración
          </h4>
        </div>
        <div class="row full-width justify-star q-pl-md">
          <q-breadcrumbs>
            <q-breadcrumbs-el icon="fas fa-home" to="/adminView" />
            <q-breadcrumbs-el label="Administración" to="/adminView/module" />
            <q-breadcrumbs-el label="Modulo1" to="/adminView/lesson" />
            <q-breadcrumbs-el label="Lesson" />
          </q-breadcrumbs>
        </div>
        <div
          class="row full-width full-height justify-center items-center text-h4 text-secondary q-pt-xl q-mt-lg"
          v-if="contents.length === 0"
        >
          {{ $t("General.contToLess") }}
        </div>
        <div class="row full-width justify-center">
          <ContentSelect v-for="content in contents" :key="content.id" :content="content">
          </ContentSelect>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
import ContentSelect from "../../components/Content/ContentSelect";

export default {
  components: {
    ContentSelect,
  },

  data() {
    return {
      textAdd: false,
      text: "",
      contents: [],
    };
  },

  methods: {},
};
</script>
