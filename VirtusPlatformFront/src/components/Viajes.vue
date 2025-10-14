<template>
  <div>
    <div class="row">
      <div class="col-md-12 col-lg-12 col-xs-12 col-sm-12">
        <h5 class="text-center">
          Próximos Viajes
          <br />
          <span class="text-center text-grey text-h6"
            >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span
          >
        </h5>
      </div>
    </div>
    <div class="row text-center" style="padding-bottom: 99px">
      <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
        <div style="line-height:0">
          <span v-for="index in 6" :key="index">
            <q-flashcard :no-hover="hover" :style="style">
              <q-flashcard-section transition="nudge-in" :active="active">
                <img
                  src="../assets/imagen/team_15.jpg"
                  width="340"
                  height="263"
                />
              </q-flashcard-section>
              <q-flashcard-section
                transition="fade-in"
                class="fit"
                :active="active"
              >
                <div class="fit"></div>
                <q-flashcard-section
                  transition="drop-down"
                  class="text-center my-header"
                  :active="active"
                  >Profile Title</q-flashcard-section
                >
                <q-flashcard-section
                  transition="slide-up-in"
                  class="my-text"
                  :active="active"
                  >For beautiful eyes, look for the good in others; for
                  beautiful lips, speak only words of kindness; and for poise,
                  walk with the knowledge that you are never
                  alone.</q-flashcard-section
                >
                <q-flashcard-section
                  transition="fade-in"
                  class="fit flex justify-center items-end q-pb-lg"
                  :active="active"
                >
                  <q-btn
                    class="q-mr-md"
                    :style="'color:' + theme_color"
                    style="background-color:white"
                    round
                    icon="card_giftcard"
                  />
                  <q-btn
                    :style="'color:' + theme_color"
                    style="background-color:white"
                    round
                    icon="link"
                  />
                </q-flashcard-section>
              </q-flashcard-section>
            </q-flashcard>
            <br v-if="index == 3" />
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { QFlashcard, QFlashcardSection } from "@quasar/quasar-ui-qflashcard";

export default {
  name: "Viajes",
  components: {
    QFlashcard,
    QFlashcardSection
  },
  data() {
    return {
      hover: false,
      active: false,
      theme_color: "rgb(0, 163, 82)"
    };
  },
  computed: {
    style() {
      return {
        width: "340px",
        height: "263px",
        backgroundImage: `url('https://raw.githubusercontent.com/quasarframework/quasar-ui-qflashcard/dev/demo/src/statics/bgimg.jpg')`, // eslint-disable-line
        textAlign: "center",
        boxShadow: "1px 1px 2px #e6e6e6",
        display: "inline-block"
      };
    },
    team_style() {
      return {
        width: "260px",
        height: "263px",
        backgroundImage: `url('https://raw.githubusercontent.com/quasarframework/quasar-ui-qflashcard/dev/demo/src/statics/bgimg.jpg')`, // eslint-disable-line
        textAlign: "center",
        boxShadow: "1px 1px 2px #e6e6e6",
        display: "inline-block"
      };
    }
  }
};
</script>
