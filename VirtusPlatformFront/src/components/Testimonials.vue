<template>
  <div class="testimony-parallax q-mt-md">
    <div class="testimony-bg">
      <q-carousel
        v-model="review_slide"
        swipeable
        animated
        infinite
        autoplay
        arrows
        prev-icon="fas fa-chevron-left"
        next-icon="fas fa-chevron-right"
        navigation
        navigation-icon="far fa-circle"
        navigation-active-icon="far fa-dot-circle"
        padding
        navigation-position="bottom"
        class="text-white full-height bg-transparent"
        height="2000rem"
      >
        <q-carousel-slide
          :name="testimony.name"
          class="row no-wrap items-center q-pa-none"
          v-for="testimony in testimonials"
          :key="testimony.name"
        >
          <div class="column col-auto">
            <q-img
              class="testimony-img self-center"
              :src="testimony.img"
              width="5rem"
              height="5rem"
            />
            <div class="q-mt-md text-h6 text-center">
              <span class="testimony-span">{{ testimony.name }}</span
              ><br /><span class="text-overline">Organization Founder</span>
            </div>
          </div>
          <div class="col">
            <div class="text-h6 text-center">{{ testimony.text }}</div>
          </div>
        </q-carousel-slide>
      </q-carousel>
    </div>
  </div>
</template>

<script>
export default {
  name: "Testimonials",
  data() {
    return {
      review_slide: "style",
      testimonials: [
        {
          img: require("../assets/imagen/team_15.jpg"),
          name: "John Doe",
          text:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do"
        },
        {
          img: require("../assets/imagen/team_15.jpg"),
          name: "Jane Doe",
          text: "eiusmod tempor incididunt ut"
        },
        {
          img: require("../assets/imagen/team_15.jpg"),
          name: "Chris Doe",
          text: "labore et dolore magna aliqua."
        }
      ]
    };
  }
};
</script>
