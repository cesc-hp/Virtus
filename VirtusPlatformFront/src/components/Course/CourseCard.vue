<template>
  <div
    class="items-center q-pa-sm row"
    :class="{
      'col-auto': $q.screen.gt.sm,
      'col-xs-12 justify-center': $q.screen.lt.md
    }"
  >
    <q-card flat class="custom-card">
      <!-- IMAGEN DE HEADER -->
      <!-- 330x160px -->
      <q-img height="10rem" :src="course.headerImg">
        <q-badge
          color="light-blue-2"
          text-color="grey-9"
          class="q-pa-sm"
          transparent
        >
          <q-icon left name="fas fa-circle" color="green" />
          <div>{{ $t("General.active") }}</div>
        </q-badge>
      </q-img>
      <q-card-section class="q-pa-sm">
        <!-- TÍTULO -->
        <div class="row items-center">
          <p class="col text-h6 text-secondary q-mb-sm">{{ course.title }}</p>
        </div>
        <!-- DURACIÓN -->
        <div class="text-caption text-grey">
          <q-icon name="fas fa-calendar-alt" />
          {{ course.endDate }}
        </div>
      </q-card-section>
      <q-card-section class="q-px-sm q-pt-none q-pb-sm">
        <!-- TÍTULO DESCRIPCIÓN -->
        <div class="text-subtitle1">
          {{ $t("CardCourse.description") }}
        </div>
        <!-- TEXTO DESCRIPCIÓN -->
        <div class="text-caption text-grey">
          {{ course.description }}
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
              @click="$router.push({ name: 'module' })"
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
      <q-card-section class="q-px-sm q-pb-sm q-pt-none">
        <div class="row justify-center">
          <!-- LINK CLASES FAVORITAS -->
          <a class="text-subtitle q-pa-sm">
            {{ $t("CardCourse.favLesson") }}
          </a>
          <q-linear-progress
            rounded
            size="md"
            :value="progress1"
            color="secondary"
          />
          <q-badge
            class="q-pt-sm"
            color="white"
            text-color="secondary"
            :label="progressLabel1"
          />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  name: "CourseCard",
  props: {
    course: {
      type: Object,
      default: () => {
        return {
          headerImg: require("src/assets/imagen/team_15.jpg"),
          title: "Course",
          description: "Test description",
          endDate: "2021-12-31"
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

<style></style>
