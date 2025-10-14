<template>
  <div>
    <div class="row">
      <div class="col-md-12 col-lg-12 col-xs-12 col-sm-12">
        <h5 class="text-center">
          Sobre Nosotros
          <br />
          <span class="text-center text-grey text-h6"
            >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span
          >
        </h5>
      </div>
    </div>
    <!-- Mision y Vision -->
    <div class="row text-center flex flex-center" style="padding-bottom: 40px">
      <div
        class="col-md-10 col-lg-12 col-sx-12 col-sm-12 q-gutter-md flex flex-center"
      >
        <div class="col-md-6 col-lg-6 col-xs-12 col-sm-12">
          <q-card
            @mouseover="hoverOver(1)"
            @mouseout="hoverOutTimeout(1)"
            style="border: none;"
            class="my-card text-center box-shadow"
            flat
            bordered
          >
            <q-img src="../assets/imagen/team_15.jpg" />

            <q-card-section>
              <div class="text-overline text-orange-9">Overline</div>
              <div
                :class="about_heading_1"
                :style="'color: ' + about_heading_color_1"
                class="about_heading_1 text-h6 q-mt-sm q-mb-xs"
              >
                Misión Virtus
              </div>
              <div class="text-caption text-grey-9">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </div>
            </q-card-section>
          </q-card>
        </div>
        <div class="col-md-6 col-lg-6 col-xs-12 col-sm-12">
          <q-card
            @mouseover="hoverOver(2)"
            @mouseout="hoverOutTimeout(2)"
            style="border: none;"
            class="my-card text-center box-shadow"
            flat
            bordered
          >
            <q-img src="../assets/imagen/team_15.jpg" />

            <q-card-section>
              <div class="text-overline text-orange-9">Overline</div>
              <div
                :class="about_heading_2"
                :style="'color: ' + about_heading_color_2"
                class="about_heading_2 text-h6 q-mt-sm q-mb-xs"
              >
                Visión Virtus
              </div>
              <div class="text-caption text-grey-9">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
              </div>
            </q-card-section>
          </q-card>
        </div>
      </div>
    </div>
    <!-- Nuestros Profesores -->
    <div class="quote" id="id_testimonial">
      <div style="background-color: #000000ad !important;">
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
          class="text-white full-height bg-transparent q-mx-xl"
        >
          <q-carousel-slide
            style="padding-bottom: 140px"
            name="style"
            class="column no-wrap flex-center"
          >
            <h5 class="text-center">Nuestro Equipo</h5>
            <img
              :style="
                'margin-top:100px;border-radius:5px;border: 4px solid ' +
                  theme_color
              "
              src="../assets/imagen/team_1.jpg"
              width="150"
              height="150"
            />
            <div class="q-mt-md text-h6 text-center">
              <span :style="'color:' + theme_color">John Doe</span>
              <br />
              <span class="text-overline">Organization Founder</span>
            </div>
            <div class="q-mt-md text-h6 text-center">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut
              <br />labore et dolore magna aliqua.
            </div>
          </q-carousel-slide>
          <q-carousel-slide
            style="padding-bottom: 140px"
            name="tv"
            class="column no-wrap flex-center"
          >
            <h5 class="text-center">Nuestro Equipo</h5>
            <img
              :style="
                'margin-top:100px;border-radius:5px;border: 4px solid ' +
                  theme_color
              "
              src="../assets/imagen/team_2.jpg"
              width="150"
              height="150"
            />
            <div class="q-mt-md text-h6 text-center">
              <span :style="'color:' + theme_color">John Doe</span>
              <br />
              <span class="text-overline">Lead Developer</span>
            </div>
            <div class="q-mt-md text-h6 text-center">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut
              <br />labore et dolore magna aliqua.
            </div>
          </q-carousel-slide>
          <q-carousel-slide
            style="padding-bottom: 140px"
            name="layers"
            class="column no-wrap flex-center"
          >
            <h5 class="text-center">Nuestro Equipo</h5>
            <img
              :style="
                'margin-top:100px;border-radius:5px;border: 4px solid ' +
                  theme_color
              "
              src="../assets/imagen/team_3.jpg"
              width="150"
              height="150"
            />
            <div class="q-mt-md text-h6 text-center">
              <span :style="'color:' + theme_color">John Doe</span>
              <br />
              <span class="text-overline">Product Owner</span>
            </div>
            <div class="q-mt-md text-h6 text-center">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut
              <br />labore et dolore magna aliqua.
            </div>
          </q-carousel-slide>
        </q-carousel>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutUs",
  data() {
    return {
      review_slide: "style",
      theme_color: "rgb(0, 163, 82)",
      background_style: "background-color:rgba(0, 163, 82, 0.7);",
      about_heading_1: [],
      about_heading_2: [],
      about_heading_color_1: "#424242",
      about_heading_color_2: "#424242"
    };
  },
  methods: {
    hoverOver: function(index) {
      this["about_heading_color_" + index] = this.theme_color;
      this["about_heading_" + index] = ["animated", "bounceIn"];
    },
    hoverOutTimeout: function(index) {
      this["about_heading_color_" + index] = "#424242";
      setTimeout(() => {
        this["about_heading_" + index] = [];
      }, 1000);
    }
  }
};
</script>
