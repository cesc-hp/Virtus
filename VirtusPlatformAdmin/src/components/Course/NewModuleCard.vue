<template>
  <div class="my-card items-center q-pa-md bg-white">
    <div>
      <p v-if="edit == false" class="text-h6 text-secondary">
        {{ $t("CardModule.newModule") }}
      </p>
      <p v-else class="text-h6 text-secondary">{{ $t("CardModule.editModule") }}</p>
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
                  (module.filesImages = '')
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
            v-model="module.title"
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
          @click="insertModule"
        />
        <q-btn v-else flat :label="$t('Btn.update')" @click="updateModule" />
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
    moduleEdit: {
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
      module: {
        filesImages: "",
        title: "",
      },
      openDia: false,
      typeFile: "",
      close: true,
      isEmptyImg: true,
    };
  },

  mounted() {
    if (this.edit) {
      if (this.moduleEdit.id != "") {
        this.id = this.moduleEdit.id;
      }
      if (this.moduleEdit.title != "") {
        this.module.title = this.moduleEdit.title;
      }
      if (this.moduleEdit.img != null) {
        this.imgUrl = this.baseUrl + this.moduleEdit.img.url;
        this.isEmptyImg = false;
      }
    }
    if (this.imgUrl == "") {
      this.imgUrl = require("../../assets/imagen/img_not_found.png");
    }
  },

  methods: {
    insertModule() {
      if (this.formValidate()) {
        this.$emit("insertmodule", this.module, this.close);
      }
    },
    closeDialog() {
      this.$emit("closedialog");
    },
    updateModule() {
      if (this.formValidate()) {
        this.$emit("updatemodule", this.module, this.id, this.close);
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
          this.module.filesImages = data.data.newImg.id;
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
