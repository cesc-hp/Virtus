<template>
  <q-page class="row justify-center bg-grey-3">
    <div class="col-xs-12 col-sm-11 col-md-11 col-lg-11 column items-center justify-star">
      <div class="row full-width justify-star q-pl-md q-mt-md">
        <q-breadcrumbs>
          <q-breadcrumbs-el icon="fas fa-home" :to="{ name: 'course' }" />
          <q-breadcrumbs-el :label="courseName" :to="{ name: 'module' }" />
          <q-breadcrumbs-el :label="moudleName" />
        </q-breadcrumbs>
      </div>
      <div class="row full-width justify-star q-pl-md q-pt-md">
        <h6
          class="col text-subtitle1 text-secondary text-weight-bolder q-my-none float-left"
          style="font-family: Lovato"
        >
          {{ $t("General.lesson") }}
        </h6>
      </div>
      <div
        class="row full-width justify-center items-center text-h4 text-secondary q-pt-xl q-mt-lg"
        v-if="lessonList.length === 0"
      >
        {{ $t("CardLesson.addLessToMod") }}
      </div>
      <div class="row full-width justify-start q-px-sm">
        <LessonCard
          v-for="lesson in lessonList"
          :key="lesson.id"
          :lesson="lesson"
          @deletedlesson="deletedLesson"
          @openEdit="openDialg"
        />
      </div>
    </div>

    <q-page-sticky position="bottom-right" :offset="[18, 18]">
      <q-btn fab icon="fas fa-plus" @click="prompt = true" color="secondary" />
    </q-page-sticky>

    <q-dialog v-model="prompt" persistent>
      <NewLessonCard
        @insertlesson="insertLesson"
        @updatelesson="updateLesson"
        @closedialog="closeDialog"
        :edit="edit"
        :lessonEdit="lessonEdit"
      />
    </q-dialog>
  </q-page>
</template>

<script>
import LessonCard from "../../components/Course/LessonCard";
import NewLessonCard from "../../components/Course/NewLessonCard";
import { queries } from "../../graphql/course";
import { moduleQueries } from "../../graphql/modules";
import { lessonMutations, lessonQueries } from "../../graphql/lesson";

export default {
  components: {
    LessonCard,
    NewLessonCard,
  },

  data() {
    return {
      prompt: false,
      edit: false,
      routeIdMod: this.$route.params.idModule,
      courseName: "",
      moudleName: "",
      lessonList: Array,
      lessonEdit: {
        id: null,
        title: "",
        img: "",
      },
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: moduleQueries.lessByModId,
        variables: {
          id: this.routeIdMod,
        },
      })
      .then((data) => {
        this.lessonList = data.data.moduleById.lessons;
        this.moudleName = data.data.moduleById.title;
        this.courseName = data.data.moduleById.course.name;
      });
  },

  methods: {
    insertLesson(lesson, close) {
      if (!close) {
        this.prompt = false;
      }
      this.$apollo
        .mutate({
          mutation: lessonMutations.newLesson,
          variables: {
            title: lesson.title,
            idImg: lesson.filesImages,
            moduleId: this.routeIdMod,
          },
          update: (store, { data: { newLesson } }) => {
            this.lessonList.push(newLesson);
          },
        })
        .catch((error) => {
          this.error = error;
        });
    },

    deletedLesson(id) {
      this.$apollo.mutate({
        mutation: lessonMutations.deleteLesson,
        variables: {
          id: id,
        },
        update: (store, { data: { deleteLesson } }) => {
          let pos;
          this.lessonList.forEach(function (elemento, indice) {
            if (elemento.id === id) {
              pos = indice;
            }
          });
          this.lessonList.splice(pos, 1);
        },
      });
    },
    updateLesson(lesson, id, close) {
      if (!close) {
        this.prompt = false;
      }
      this.$apollo
        .mutate({
          mutation: lessonMutations.updateLesson,
          variables: {
            id: id,
            title: lesson.title,
            idImg: lesson.filesImages,
          },
          update: (store, { data: { updateLesson } }) => {
            this.lessonList.find((less) => {
              if (less.id === id) {
                less.title = updateLesson.title;
                less.img = updateLesson.img;
              }
            });
          },
        })
        .catch((error) => {
          this.error = error;
        });
      this.edit = false;
    },
    openDialg(lesson) {
      this.lessonEdit.id = lesson.id;
      this.lessonEdit.title = lesson.title;
      this.lessonEdit.img = lesson.img;
      this.edit = true;
      this.prompt = true;
    },
    closeDialog() {
      this.prompt = false;
      this.edit = false;
    },
  },
};
</script>
