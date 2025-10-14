<template>
  <q-toolbar
    class="flex flex-center text-white"
    style="background-color: #1c1b21;"
    :style="'border-top: 2px solid '+ theme_color"
  >
    <div class="q-pa-sm q-gutter-sm">
      <q-btn
        round
        type="a"
        href="https://twitter.com/mayank91193"
        :style="'background:'+ theme_color +'; color: white !important;'"
        icon="fab fa-twitter"
      />
      <q-btn
        round
        type="a"
        href="https://github.com/mayank091193/vue-quasar-company-profile-website"
        :style="'background:'+ theme_color +'; color: white !important;'"
        icon="fab fa-github"
      />
      <q-btn
        round
        type="a"
        href="mailto:mayank091193@gmail.com"
        :style="'background:'+ theme_color +'; color: white !important;'"
        icon="email"
      />
      <q-btn
        round
        type="a"
        href="https://github.com/sponsors/mayank091193"
        :style="'background:'+ theme_color +'; color: white !important;'"
        glossy
        text-color="black"
        icon="fas fa-heart"
      />
    </div>
  </q-toolbar>
</template>

<script>
export default {
  name: "SocialNetworks",
  data() {
    return {};
  },
};
</script>
