<template>
  <q-page class="row justify-center bg-grey-3">
    <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10 column items-center">
      <div class="row justify-between full-width">
        <CourseCard v-for="card in [1, 2, 3, 4]" :key="card" />
      </div>
    </div>
  </q-page>
</template>

<script>
import CourseCard from "../../components/Course/CourseCard";

export default {
  components: {
    CourseCard
  },

  data() {
    return {
      prompt: false
    };
  },
  methods: {
    onSubmit() {
      this.$router.push({ name: "profile" });
    }
  }
};
</script>
