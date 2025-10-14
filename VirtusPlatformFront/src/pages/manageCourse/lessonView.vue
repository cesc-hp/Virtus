<template>
  <q-page class="row justify-center">
    <div class="col-xs-12 col-sm-10 col-md-8 col-lg-8 column items-center">
      <div class="row full-width q-pl-md">
        <!-- TODO: Menu de navegacion add to i18n -->
        <h4
          class="col text-h4 text-secondary text-weight-bolder q-my-md float-left"
          style="font-family: Lovato"
        >
          Administración
        </h4>
      </div>
      <div class="row full-width q-pl-md">
        <q-breadcrumbs>
          <q-breadcrumbs-el icon="fas fa-home" :to="{ name: 'adminView' }" />
          <q-breadcrumbs-el label="Administración" :to="{ name: 'module' }" />
          <q-breadcrumbs-el label="Modulo1" />
        </q-breadcrumbs>
      </div>
      <div class="row full-width q-pl-md q-pt-xl">
        <h6
          class="col text-subtitle1 text-secondary text-weight-bolder q-my-none float-left"
          style="font-family: Lovato"
        >
          {{ $t("General.lesson") }}
        </h6>
      </div>
      <div class="row full-width justify-between">
        <LessonCard v-for="card in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]" :key="card" />
      </div>
    </div>
  </q-page>
</template>

<script>
import LessonCard from "../../components/Course/LessonCard";

export default {
  components: {
    LessonCard,
  },

  data() {
    return {
      prompt: false,
    };
  },
};
</script>
