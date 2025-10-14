<template>
  <div
    class="items-center q-pa-sm row"
    :class="{
      'col-auto': $q.screen.gt.sm,
      'col-xs-12 justify-center': $q.screen.lt.md
    }"
  >
    <q-card class="bg-grey-1 custom-card" flat>
      <!-- IMAGEN DE HEADER -->
      <!-- 330x160px -->
      <q-img height="10rem" :src="module.headerImg">
        <q-badge
          color="light-blue-2"
          text-color="grey-9"
          class="q-pa-sm"
          transparent
        >
          <q-icon left name="fas fa-circle" color="green" />
          <div>{{ $t("General.inProgress") }}</div>
        </q-badge>
      </q-img>
      <q-card-section class="q-pa-sm">
        <div class="row items-center">
          <!-- TÍTULO -->
          <p class="col text-h6 text-secondary q-mb-none">{{ module.title }}</p>
        </div>
      </q-card-section>
      <q-separator />
      <q-card-actions>
        <!-- BOTÓN VER TODO -->
        <div class="row full-width">
          <div class="col-6 q-pa-xs">
            <q-btn
              class="fit"
              outline
              color="secondary"
              @click="$router.push({ name: 'lesson' })"
              :label="$t('Btn.seeAll')"
            />
          </div>
          <div class="col-6 q-pa-xs">
            <!-- BOTÓN PRÓXIMA CLASE -->
            <q-btn
              class="fit"
              color="secondary"
              :label="$t('Btn.nextLesson')"
              @click="$router.push({ name: 'lesson' })"
            />
          </div>
        </div>
      </q-card-actions>
      <q-separator />
      <q-card-section class="q-pa-sm q-pt-md">
        <div class="row items-center justify-center">
          <!-- CANTIDAD DE CLASES VISTAS -->
          <div class="col-auto text-caption text-grey q-pr-sm">
            <p class="q-mb-none">1/{{ module.lessons }}</p>
          </div>
          <q-linear-progress
            class="col"
            rounded
            size="md"
            :value="progress1"
            color="secondary"
          />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  name: "ModuleCard",
  props: {
    module: {
      type: Object,
      default: () => {
        return {
          headerImg: require("src/assets/imagen/team_15.jpg"),
          title: "Module",
          lessons: 11
        };
      }
    }
  },
  data() {
    return {
      progress1: 0.3
    };
  },

  computed: {
    progressLabel1() {
      return (this.progress1 * 100).toFixed(2) + "%";
    }
  }
};
</script>
