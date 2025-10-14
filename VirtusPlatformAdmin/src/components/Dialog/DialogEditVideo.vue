<template>
  <q-card class="q-pa-md">
    <div>
      <p class="text-h6 text-secondary q-mb-sm">
        {{ $t("General.videoEdit") }}
      </p>
    </div>

    <q-card-section class="q-pa-none">
      <div class="items-center">
        <q-input
          dense
          ref="name"
          class="text-h6 text-secondary q-mb-none"
          square
          filled
          v-model="file.title"
          :label="$t('InputForms.title')"
          :rules="[(val) => !!val || $t('SmsValidate.fieldEmpty')]"
        />
      </div>
    </q-card-section>
    <q-card-section class="q-pa-none">
      <div class="text-subtitle1">
        {{ $t("CardCourse.description") }}
      </div>
      <div class="text-caption text-grey">
        <q-input
          dense
          ref="description"
          v-model="file.description"
          filled
          type="textarea"
          :rules="[(val) => !!val || $t('SmsValidate.fieldEmpty')]"
        />
      </div>
    </q-card-section>
    <q-separator />
    <q-card-actions align="right" class="text-primary">
      <q-btn flat :label="$t('Btn.cancel')" @click="closeDialog" />
      <q-btn flat :label="$t('Btn.update')" @click="updateVideo" />
    </q-card-actions>
  </q-card>
</template>

<script>
export default {
  name: "DialogEditVideo",
  props: {
    fileEdit: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      file: {
        title: "",
        description: "",
      },
    };
  },
  mounted() {
    this.file.title = this.fileEdit.title;
    this.file.description = this.fileEdit.description;
  },
  methods: {
    updateVideo() {
      if (this.formValidate()) {
        this.$emit("updatevideo", this.file, this.fileEdit.id);
      }
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
