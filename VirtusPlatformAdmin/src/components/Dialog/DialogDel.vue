<template>
  <q-card>
    <q-card-section class="q-pt-md">
      {{ $t("General.DialogDeleted") }}
    </q-card-section>
    <q-card-actions align="right" class="text-primary">
      <q-btn flat :label="$t('General.deny')" v-close-popup />
      <q-btn flat :label="$t('General.confirm')" v-close-popup @click="deleted" />
    </q-card-actions>
  </q-card>
</template>

<script>
export default {
  name: "DialogDel",
  data() {
    return {};
  },
  methods: {
    deleted() {
      this.$emit("deleted");
    },
  },
};
</script>
