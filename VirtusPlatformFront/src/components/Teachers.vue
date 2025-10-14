<template>
  <div>
    <div class="row" id="id_team">
      <div class="col-md-12 col-lg-12 col-xs-12 col-sm-12">
        <h5 class="text-center">
          Nuestros Profesores
          <br />
          <span
            class="text-center text-grey text-h6"
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
        </h5>
      </div>
    </div>
    <div class="row text-center flex flex-center">
      <div
        class="col-md-12 col-lg-12 col-sx-12 col-sm-12 q-px-xl"
        style="width:100%;overflow:auto;"
      >
        <q-carousel
          v-model="team_slide"
          transition-prev="slide-right"
          transition-next="slide-left"
          swipeable
          animated
          infinite
          control-color="primary"
          navigation
          navigation-icon="far fa-circle"
          navigation-active-icon="far fa-dot-circle"
          padding
          height="300px"
          class="rounded-borders"
        >
          <q-carousel-slide v-for="val in [1,2,3]" :key="val" :name="val" class="column no-wrap">
            <div class="row fit justify-center items-center q-gutter-xs q-col-gutter no-wrap">
              <span v-for="teacher in teachers" :key="teacher.email">
                <TeacherCard :teacher="teacher" />
              </span>
            </div>
          </q-carousel-slide>
        </q-carousel>
      </div>
    </div>
  </div>
</template>

<script>
import TeacherCard from "./TeacherCard";

export default {
  name: "Teachers",
  components: {
    TeacherCard,
  },
  props: {
    title: {
      type: String,
      required: true,
    },
    teachers: {
      type: Array,
      default: () => [
        {
          name: "Teacher one",
          position: "Principal",
          email: "t1@mail.com",
        },
        {
          name: "Teacher two",
          position: "Alternative",
          email: "t2@mail.com",
        },
        {
          name: "Teacher three",
          position: "Alternative",
          email: "t3@mail.com",
        },
        {
          name: "Teacher four",
          position: "Alternative",
          email: "t4@mail.com",
        },
      ],
    },
  },
  data() {
    return {
      team_slide: 1,
    };
  },
};
</script>
