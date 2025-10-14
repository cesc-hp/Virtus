<template>
  <q-page class="row justify-center bg-grey-3">
    <div class="col-xs-12 col-sm-11 col-md-11 col-lg-11 column items-center justify-star">
      <div class="row full-width justify-star q-pl-md q-mt-md">
        <q-breadcrumbs>
          <q-breadcrumbs-el icon="fas fa-home" :to="{ name: 'course' }" />
          <q-breadcrumbs-el :label="courseName" />
        </q-breadcrumbs>
      </div>
      <div class="row full-width justify-star q-pl-md q-pt-md">
        <h6
          class="col text-subtitle1 text-secondary text-weight-bolder q-my-none float-left"
          style="font-family: Lovato"
        >
          {{ $t("General.module") }}
        </h6>
      </div>
      <div
        class="row full-width justify-center items-center text-h4 text-secondary q-pt-xl q-mt-lg"
        v-if="moduleList.length === 0"
      >
        {{ $t("CardModule.addModToCour") }}
      </div>
      <div class="row full-width justify-start q-px-sm">
        <ModuleCard
          v-for="module in moduleList"
          :key="module.id"
          :module="module"
          @deletedmodule="deletedCourse"
          @openEdit="openDialg"
        />
      </div>
    </div>

    <q-page-sticky position="bottom-right" :offset="[18, 18]">
      <q-btn fab icon="fas fa-plus" @click="prompt = true" color="secondary" />
    </q-page-sticky>

    <q-dialog v-model="prompt" persistent>
      <NewModuleCard
        @insertmodule="insertModule"
        @updatemodule="updateModule"
        @closedialog="closeDialog"
        :edit="edit"
        :moduleEdit="moduleEdit"
      />
    </q-dialog>
  </q-page>
</template>

<script>
import ModuleCard from "../../components/Course/ModuleCard";
import NewModuleCard from "../../components/Course/NewModuleCard";
import { moduleQueries, moduleMutations } from "../../graphql/modules";
import { queries } from "../../graphql/course";

export default {
  components: {
    ModuleCard,
    NewModuleCard,
  },

  data() {
    return {
      prompt: false,
      edit: false,
      routeIdCours: this.$route.params.idCourse,
      courseName: "",
      moduleList: Array,
      moduleEdit: {
        id: null,
        title: "",
        img: "",
      },
    };
  },

  mounted() {
    this.$apollo
      .query({
        query: queries.modsByCourId,
        variables: {
          id: this.routeIdCours,
        },
      })
      .then((data) => {
        this.moduleList = data.data.courseById.modules;
        this.courseName = data.data.courseById.name;
      });
  },

  methods: {
    insertModule(module, close) {
      if (!close) {
        this.prompt = false;
      }
      this.$apollo
        .mutate({
          mutation: moduleMutations.newModule,
          variables: {
            title: module.title,
            idImg: module.filesImages,
            courseId: this.routeIdCours,
          },
          update: (store, { data: { newModule } }) => {
            this.moduleList.push(newModule);
          },
        })
        .catch((error) => {
          this.error = error;
        });
    },
    deletedCourse(id) {
      this.$apollo.mutate({
        mutation: moduleMutations.deleteModule,
        variables: {
          id: id,
        },
        update: (store, { data: { deleteModule } }) => {
          let pos;
          this.moduleList.forEach(function (elemento, indice) {
            if (elemento.id === id) {
              pos = indice;
            }
          });
          this.moduleList.splice(pos, 1);
        },
      });
    },

    updateModule(module, id, close) {
      if (!close) {
        this.prompt = false;
      }
      this.$apollo
        .mutate({
          mutation: moduleMutations.updateModule,
          variables: {
            id: id,
            title: module.title,
            idImg: module.filesImages,
          },
          update: (store, { data: { updateModule } }) => {
            this.moduleList.find((mod) => {
              if (mod.id === id) {
                mod.title = updateModule.title;
                mod.img = updateModule.img;
              }
            });
          },
        })
        .catch((error) => {
          this.error = error;
        });
      this.edit = false;
    },
    openDialg(module) {
      this.moduleEdit.id = module.id;
      this.moduleEdit.title = module.title;
      this.moduleEdit.img = module.img;
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
