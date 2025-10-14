<template>
  <q-layout view="hHh lpR fFf">
    <q-page class="row justify-center items-center">
      <q-page-container class="full-width">
        <router-view />
      </q-page-container>
    </q-page>
  </q-layout>
</template>

<script>
export default {
  data() {
    return {
      left: true,
      tab: "course",
      toolbar: false
    };
  }
};
</script>
