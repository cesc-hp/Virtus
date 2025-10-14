<template>
  <div class="my-card items-center q-pa-md bg-white">
    <div>
      <p v-if="edit == false" class="text-h6 text-secondary">
        {{ $t("CardLesson.newLesson") }}
      </p>
      <p v-else class="text-h6 text-secondary">{{ $t("CardLesson.editLesson") }}</p>
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
                  (lesson.filesImages = '')
              "
            />
          </div>
        </q-img>
      </div>

      <q-card-section class="q-pt-md q-pa-none">
        <div class="items-center">
          <q-input
            dense
            class="text-h6 text-secondary q-mb-sm"
            square
            filled
            v-model="lesson.title"
            :label="$t('InputForms.title')"
            ref="title"
            :rules="[(val) => !!val || $t('SmsValidate.fieldEmpty')]"
          />
        </div>
      </q-card-section>

      <q-card-actions align="right" class="text-primary">
        <q-btn flat :label="$t('Btn.cancel')" @click="closeDialog" />
        <q-btn
          v-if="edit == false"
          flat
          :label="$t('Btn.insert')"
          @click="insertLesson"
        />
        <q-btn v-else flat :label="$t('Btn.update')" @click="updateLesson" />
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
  name: "NewModuleCard",
  components: {
    DialogUp,
  },
  props: {
    lessonEdit: {
      type: Object,
    },
    edit: {
      type: Boolean,
      required: true,
    },
  },

  mounted() {
    if (this.edit) {
      if (this.lessonEdit.id != "") {
        this.id = this.lessonEdit.id;
      }
      if (this.lessonEdit.title != "") {
        this.lesson.title = this.lessonEdit.title;
      }
      if (this.lessonEdit.img != null) {
        this.imgUrl = this.baseUrl + this.lessonEdit.img.url;
        this.isEmptyImg = false;
      }
    }
    if (this.imgUrl == "") {
      this.imgUrl = require("../../assets/imagen/img_not_found.png");
    }
  },

  data() {
    return {
      id: null,
      baseUrl: "http://localhost:8000/assets",
      imgUrl: "",
      lesson: {
        filesImages: "",
        title: "",
      },
      openDia: false,
      typeFile: "",
      close: true,
      isEmptyImg: true,
    };
  },

  methods: {
    insertLesson() {
      if (this.formValidate()) {
        this.$emit("insertlesson", this.lesson, this.close);
      }
    },
    closeDialog() {
      this.$emit("closedialog");
    },
    updateLesson() {
      if (this.formValidate()) {
        this.$emit("updatelesson", this.lesson, this.id, this.close);
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
          this.lesson.filesImages = data.data.newImg.id;
          this.imgUrl = this.baseUrl + data.data.newImg.url;
        })
        .catch((error) => {
          this.error = error;
        });
    },
    formValidate() {
      this.$refs.title.validate();
      if (this.$refs.title.hasError) {
        this.formHasError = true;
        return false;
      } else {
        this.close = false;
        return true;
      }
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
