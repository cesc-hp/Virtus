<template>
  <div class="col-xs-12 col-sm-6 col-md-4 col-lg-2 items-center q-pa-sm">
    <q-card flat>
      <div v-if="course.img !== null">
        <q-img :ratio="16 / 9" :src="baseUrl + course.img.url" />
      </div>
      <div v-else>
        <q-img :src="require('../../assets/imagen/img_not_found.png')" />
      </div>

      <q-btn
        fab-mini
        size="md"
        color="primary"
        icon="fas fa-times"
        class="absolute-top-right q-mr-sm q-mt-sm"
        @click="dialogDelet = true"
      />
      <div class="q-pa-sm">
        <q-card-section class="q-pa-none">
          <div class="row items-center">
            <p class="col text-h6 text-secondary q-mb-none ellipsis">
              {{ course.name }}
            </p>
          </div>
          <div class="text-caption text-grey">
            <q-icon name="fas fa-calendar-alt" />
            <!-- TODO: Add to i18n -->
            Termina en 5 meses
          </div>
        </q-card-section>
        <q-card-section class="q-pa-none q-pt-xs">
          <div class="text-subtitle1">
            {{ $t("CardCourse.description") }}
          </div>
          <div
            class="text-caption text-grey ellipsis-3-lines text-justify height-descript"
          >
            {{ course.description }}
          </div>
        </q-card-section>
      </div>
      <q-separator />
      <q-card-actions>
        <div class="row full-width">
          <div class="col-6 q-pa-xs">
            <q-btn
              class="full-width"
              outline
              color="secondary"
              @click="$router.push({ name: 'module', params: { idCourse: course.id } })"
              :label="$t('General.module')"
            />
          </div>
          <div class="col-6 q-pa-xs">
            <q-btn
              class="full-width"
              color="secondary"
              :label="$t('Btn.edit')"
              @click="openEditC"
            />
          </div>
        </div>
      </q-card-actions>
      <q-separator />
    </q-card>
    <q-dialog v-model="dialogDelet">
      <DialogDel @deleted="deleteCourse" />
    </q-dialog>
  </div>
</template>

<script>
import { queries, mutations } from "../../graphql/course";
import DialogDel from "../Dialog/DialogDel";

export default {
  name: "CourseCard",
  components: {
    DialogDel,
  },
  props: {
    course: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      dialogDelet: false,
      baseUrl: "http://localhost:8000/assets",
    };
  },
  methods: {
    deleteCourse() {
      this.$emit("deletedcourse", this.course.id);
    },
    openEditC() {
      this.$emit("openEdit", this.course);
    },
  },
};
</script>
