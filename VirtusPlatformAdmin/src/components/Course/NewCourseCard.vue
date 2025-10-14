<template>
  <div class="items-center q-pa-md bg-white">
    <div>
      <p v-if="edit == false" class="text-h6 text-secondary">
        {{ $t("CardCourse.newCourse") }}
      </p>
      <p v-else class="text-h6 text-secondary">{{ $t("CardCourse.editCourse") }}</p>
    </div>
    <q-card bordered style="border: 0px" flat>
      <div class="column items-center">
        <q-img
          class="rounded-borders"
          style="height: 110px; max-width: 170px"
          :src="imgUrl"
        >
          <div class="absolute-top-right" v-if="isEmptyImg == true">
            <q-btn
              fab-mini
              size="md"
              color="secondary"
              icon="fas fa-upload"
              class="q-mr-sm q-mt-sm"
              @click="openDialogo('TYPE_FOTO')"
            />
          </div>
          <div v-else class="absolute-top-right">
            <q-btn
              fab-mini
              size="md"
              color="primary"
              icon="fas fa-times"
              class="absolute-top-right q-mr-sm q-mt-sm"
              @click="
                (imgUrl = require('../../assets/imagen/img_not_found.png')),
                  (isEmptyImg = true),
                  (course.filesImages = '')
              "
            />
          </div>
        </q-img>
      </div>

      <q-card-section class="q-pt-md q-pa-none">
        <div class="items-center">
          <q-input
            dense
            ref="name"
            class="text-h6 text-secondary q-mb-sm"
            square
            filled
            v-model="course.textName"
            :label="$t('InputForms.title')"
            :rules="[(val) => !!val || $t('SmsValidate.fieldEmpty')]"
          />
        </div>
        <div class="row items-center text-caption text-grey">
          <q-icon name="fas fa-calendar-alt" class="q-pr-xs" />
          <!-- TODO: Add to i18n -->
          Termina en 5 meses
        </div>
      </q-card-section>
      <q-card-section class="q-pa-none q-pb-sm">
        <div class="text-subtitle1">
          {{ $t("CardCourse.description") }}
        </div>
        <div class="text-caption text-grey">
          <q-input
            dense
            ref="description"
            v-model="course.textDescript"
            filled
            type="textarea"
            :rules="[(val) => !!val || $t('SmsValidate.fieldEmpty')]"
          />
        </div>
      </q-card-section>
      <q-separator />
      <q-card-actions align="right" class="text-primary">
        <q-btn flat :label="$t('Btn.cancel')" @click="closeDialog" />
        <q-btn
          v-if="edit == false"
          flat
          :label="$t('Btn.insert')"
          @click="insertCourse"
        />
        <q-btn v-else flat :label="$t('Btn.update')" @click="updateCourse" />
      </q-card-actions>
    </q-card>
    <q-dialog v-model="openDia">
      <DialogUp :typeFile="typeFile" @emitupload="emitUpload"></DialogUp>
    </q-dialog>
  </div>
</template>

<script>
import DialogUp from "../../components/Content/DialogUp";
import { contentMutations } from "../../graphql/content";

export default {
  name: "NewCourseCard",
  components: {
    DialogUp,
  },
  props: {
    courseEdit: {
      type: Object,
    },
    edit: {
      type: Boolean,
      required: true,
    },
  },

  data() {
    return {
      id: null,
      baseUrl: "http://localhost:8000/assets",
      imgUrl: "",
      course: {
        filesImages: "",
        textName: "",
        textDescript: "",
      },
      openDia: false,
      typeFile: "",
      close: true,
      isEmptyImg: true,
    };
  },

  mounted() {
    if (this.edit) {
      if (this.courseEdit.id != "") {
        this.id = this.courseEdit.id;
      }
      if (this.courseEdit.name != "") {
        this.course.textName = this.courseEdit.name;
      }
      if (this.courseEdit.description != "") {
        this.course.textDescript = this.courseEdit.description;
      }
      if (this.courseEdit.img != null) {
        this.imgUrl = this.baseUrl + this.courseEdit.img.url;
        this.isEmptyImg = false;
      }
    }
    if (this.imgUrl == "") {
      this.imgUrl = require("../../assets/imagen/img_not_found.png");
    }
  },

  methods: {
    insertCourse() {
      if (this.formValidate()) {
        this.$emit(
          "insertcourse",
          this.course.filesImages,
          this.course.textName,
          this.course.textDescript,
          this.close
        );
      }
    },
    updateCourse() {
      if (this.formValidate()) {
        this.$emit("updatecourse", this.course, this.id, this.close);
      }
    },
    openDialogo(type) {
      this.typeFile = type;
      this.openDia = true;
    },
    emitUpload(elemnt, type, close) {
      if (!close) {
        this.openDia = false;
      }
      this.$apollo
        .mutate({
          mutation: contentMutations.newImg,
          variables: {
            file: elemnt.file,
            description: elemnt.description,
          },
        })
        .then((data) => {
          this.isEmptyImg = false;
          this.course.filesImages = data.data.newImg.id;
          this.imgUrl = this.baseUrl + data.data.newImg.url;
        })
        .catch((error) => {
          this.error = error;
        });
    },
    formValidate() {
      this.$refs.name.validate();
      this.$refs.description.validate();
      if (this.$refs.name.hasError || this.$refs.description.hasError) {
        this.formHasError = true;
        return false;
      } else {
        this.close = false;
        return true;
      }
    },
    closeDialog() {
      this.$emit("closedialog");
    },
  },
};
</script>

<style scoped>
.q-img__content > div {
  padding: 0px;
  background: none;
}
</style>
