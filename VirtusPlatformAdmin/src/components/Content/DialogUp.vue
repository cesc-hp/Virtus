<template>
  <div class="items-center full-width">
    <q-card v-if="typeFile != 'TYPE_TEXT'" class="q-pa-md">
      <q-card-section class="q-pa-none q-pb-sm">
        <div v-if="typeFile == 'TYPE_VIDEO'" class="text-subtitle1">
          {{ $t("General.video") }}
        </div>
        <div v-else class="text-subtitle1">
          {{ $t("General.img") }}
        </div>
        <div class="text-caption text-grey">
          <q-uploader
            class="full-width"
            @added="loadFile"
            :accept="typeFileAcc()"
            :factory="emitUpload"
          />
        </div>
      </q-card-section>
      <q-card-section v-if="typeFile == 'TYPE_VIDEO'" class="q-pt-md q-pa-none">
        <div class="items-center">
          <q-input
            dense
            ref="name"
            class="text-h6 text-secondary q-mb-sm"
            square
            filled
            v-model="elemnt.title"
            :label="$t('InputForms.title')"
          />
        </div>
      </q-card-section>
      <q-card-section class="q-pa-none q-pb-sm">
        <div class="text-subtitle1">
          {{ $t("CardCourse.description") }}
        </div>
        <div class="text-caption text-grey">
          <q-input dense filled v-model="elemnt.description" type="textarea" />
        </div>
      </q-card-section>
      <q-card-actions align="right" class="text-primary">
        <q-btn flat :label="$t('Btn.cancel')" v-close-popup />
      </q-card-actions>
    </q-card>
    <!-- card para agregar text -->
    <q-card v-else>
      <q-card-section>
        <div class="text-h6">{{ $t("InputForms.text") }}</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        <div>
          <q-editor
            v-model="text"
            :definitions="{
              left: { icon: 'fa fa-align-left' },
              center: { icon: 'fa fa-align-center' },
              right: { icon: 'fa fa-align-right' },
              justify: { icon: 'fa fa-align-justify' },
              bold: { icon: 'fa fa-bold' },
              italic: { icon: 'fa fa-italic' },
              underline: { icon: 'fa fa-underline' },
              strike: { icon: 'fa fa-strikethrough' },
              undo: { icon: 'fa fa-undo' },
              redo: { icon: 'fa fa-redo' },
            }"
            min-height="6rem"
          />
        </div>
      </q-card-section>

      <q-card-actions align="right" class="text-primary">
        <q-btn flat :label="$t('Btn.cancel')" v-close-popup />
        <q-btn flat :label="$t('Btn.addText')" @click="emitUpload" />
      </q-card-actions>
    </q-card>
  </div>
</template>

<script>
export default {
  name: "DialogUp",
  props: {
    typeFile: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      elemnt: {
        file: null,
        title: "",
        description: "",
      },

      text: "",
      close: true,
    };
  },
  methods: {
    typeFileAcc() {
      switch (this.typeFile) {
        case "TYPE_FOTO":
          return "image/*";
        case "TYPE_VIDEO":
          return "video/*";
        default:
          break;
      }
    },

    emitUpload() {
      if (this.typeFile == "TYPE_TEXT") {
        if (this.text == "") {
          this.$q.notify({
            position: "center",
            message: this.$t("SmsValidate.smsAddText"),
            color: "negative",
            icon: "report_problem",
            timeout: 30,
          });
        } else {
          this.close = false;
          console.log(this.text + " " + this.typeFile + " " + this.close);
          this.$emit("emitupload", this.text, this.typeFile, this.close);
        }
      } else {
        if (this.elemnt.file == null) {
          this.$q.notify({
            position: "center",
            message: this.$t("SmsValidate.smsAddFile"),
            color: "negative",
            icon: "report_problem",
            timeout: 500,
          });
        } else {
          this.close = false;
          this.$emit("emitupload", this.elemnt, this.typeFile, this.close);
        }
      }
    },
    async loadFile(files) {
      this.elemnt.file = files[0];
    },
  },
};
</script>
