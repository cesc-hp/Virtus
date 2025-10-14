<template>
  <q-flashcard :no-hover="hover" :style="team_style">
    <q-flashcard-section
      transition="['nudge-out', 'fade-out']"
      :active="active"
    >
      <img src="../assets/imagen/team_15.jpg" width="260" height="263" />
    </q-flashcard-section>
    <q-flashcard-section transition="fade-in" class="fit" :active="active">
      <div class="fit" :style="background_style"></div>
      <q-flashcard-section
        transition="shake-down"
        class="text-center team-header"
        :active="active"
        >{{ teacher.name }}</q-flashcard-section
      >
      <q-flashcard-section
        transition="spin-in"
        class="team-text"
        :active="active"
        >{{ teacher.position }}</q-flashcard-section
      >
      <q-flashcard-section
        style="padding-bottom: 50px"
        transition="slide-up-in"
        class="fit flex justify-center items-end"
        :active="active"
      >
        <q-btn
          class="q-mr-md"
          :style="'color:' + theme_color"
          style="background-color:white"
          round
          icon="fa-camera"
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
</template>

<script>
import { QFlashcard, QFlashcardSection } from "@quasar/quasar-ui-qflashcard";

export default {
  name: "TeacherCard",
  components: {
    QFlashcard,
    QFlashcardSection
  },
  props: {
    teacher: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      hover: false,
      active: false,
      theme_color: "rgb(0, 163, 82)",
      background_style: "background-color:rgba(0, 163, 82, 0.7);"
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
