<template>
  <div class="contact_us">
    <div style="background-color: #000000ad !important;">
      <div class="row" id="id_news">
        <div class="col-md-12 col-lg-12 col-xs-12 col-sm-12">
          <h5 class="text-center text-white">
            Contact Us
            <br />
            <span
              class="text-center text-grey text-h6"
            >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
          </h5>
        </div>
      </div>
      <div class="row text-center flex flex-center q-pb-lg">
        <div class="col-md-6 col-lg-6 col-sx-12 col-sm-12 q-gutter-lg q-px-xl q-pb-none q-ma-none">
          <q-input bg-color="white" outlined label="Your Name *">
            <template v-slot:append>
              <q-icon name="event" :style="'color:' + theme_color" />
            </template>
          </q-input>
          <q-input bg-color="white" outlined label="Your Email *">
            <template v-slot:append>
              <q-icon name="event" :style="'color:' + theme_color" />
            </template>
          </q-input>
          <q-input bg-color="white" outlined label="Your Phone *">
            <template v-slot:append>
              <q-icon name="event" :style="'color:' + theme_color" />
            </template>
          </q-input>
        </div>
        <div class="col-md-6 col-lg-6 col-sx-12 col-sm-12 q-gutter-lg q-px-xl q-pb-none q-ma-none">
          <q-input class type="textarea" bg-color="white" outlined label="Your Message *">
            <template v-slot:append>
              <q-icon name="event" :style="'color:' + theme_color" />
            </template>
          </q-input>
        </div>
      </div>
      <div class="row flex flex-center text-center q-pb-xl q-mt-md">
        <div class="col-md-12 col-lg-12 col-sx-12 col-sm-12">
          <q-btn
            size="lg"
            :style="'background:'+ theme_color +'; color: white'"
            label="Send Message"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ContactForm",
  data() {
    return {};
  },
};
</script>
