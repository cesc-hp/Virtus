<template>
  <q-page
    class="row justify-center bg-grey-3"
    :class="{ 'content-center': courseList.length === 0 }"
  >
    <div class="col-xs-12 col-sm-11 col-md-11 col-lg-11 column items-center">
      <div
        v-if="courseList.length === 0"
        class="items-center text-center col self-center text-h4 text-secondary"
      >
        {{ $t("CardCourse.notCourse") }}
      </div>
      <div v-else class="row justify-start full-width q-mt-md">
        <CourseCard
          v-for="course in courseList"
          :key="course.id"
          :course="course"
          @deletedcourse="deletedCourse"
          @openEdit="openDialg"
        />
      </div>
    </div>
    <q-page-sticky position="bottom-right" :offset="[18, 18]">
      <q-btn fab icon="fas fa-plus" @click="prompt = true" color="secondary" />
    </q-page-sticky>
    <q-dialog v-model="prompt" persistent>
      <NewCourseCard
        @insertcourse="insertCourse"
        @updatecourse="updateCourse"
        @closedialog="closeDialog"
        :edit="edit"
        :courseEdit="courseEdit"
      />
    </q-dialog>
  </q-page>
</template>

<script>
import CourseCard from "../../components/Course/CourseCard";
import NewCourseCard from "../../components/Course/NewCourseCard";
import { queries, mutations } from "../../graphql/course";

export default {
  components: {
    CourseCard,
    NewCourseCard,
  },

  data() {
    return {
      prompt: false,
      edit: false,
      courseList: Array,
      courseEdit: {
        id: null,
        name: "",
        description: "",
        img: "",
      },
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: queries.getAllCourse,
      })
      .then((data) => {
        this.courseList = data.data.getAllCourse;
      });
  },

  methods: {
    // -- Metodo para insertar nuevo curso --
    insertCourse(filesImages, textName, textDescript, close) {
      if (!close) {
        this.prompt = false;
      }
      this.$apollo
        .mutate({
          mutation: mutations.newCourse,
          variables: {
            name: textName,
            description: textDescript,
            idImg: filesImages,
          },
          update: (store, { data: { newCourse } }) => {
            this.courseList.push(newCourse);
          },
        })
        .catch((error) => {
          this.error = error;
        });
    },
    // -- Metodo para actualizar curso --
    updateCourse(course, id, close) {
      if (!close) {
        this.edit = false;
        this.prompt = false;
      }
      this.$apollo
        .mutate({
          mutation: mutations.updateCourse,
          variables: {
            id: id,
            name: course.textName,
            description: course.textDescript,
            idImg: course.filesImages,
          },
          update: (store, { data: { updateCourse } }) => {
            this.courseList.find((cour) => {
              if (cour.id === id) {
                cour.name = updateCourse.name;
                cour.description = updateCourse.description;
                cour.img = updateCourse.img;
              }
            });
          },
        })
        .catch((error) => {
          this.error = error;
        });
    },

    closeDialog() {
      this.prompt = false;
      this.edit = false;
    },
    // -- Metodo para eliminar curso --
    deletedCourse(id) {
      this.$apollo.mutate({
        mutation: mutations.deleteCourse,
        variables: {
          id: id,
        },
        update: (store, { data: { deleteCourse } }) => {
          const array = store.readQuery({ query: queries.getAllCourse });
          let pos;
          array.getAllCourse.forEach(function (elemento, indice) {
            if (elemento.id === id) {
              pos = indice;
            }
          });
          array.getAllCourse.splice(pos, 1);
        },
      });
    },

    openDialg(course) {
      this.courseEdit.id = course.id;
      this.courseEdit.name = course.name;
      this.courseEdit.description = course.description;
      this.courseEdit.img = course.img;
      this.edit = true;
      this.prompt = true;
    },
  },
};
</script>
