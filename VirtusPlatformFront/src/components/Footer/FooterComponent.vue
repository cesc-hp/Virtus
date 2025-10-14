<template>
  <q-footer class="text-black bg-white" v-model="footer">
    <!-- CHAT INTERACTIVO -->
    <InteractiveChatComponent />
    <div class="row justify-center" :class="{ 'q-py-sm q-gutter-sm': !isMobile }">
      <!-- PROGRESO -->
      <q-card v-if="!isMobile" flat class="col-8 bg-grey-1 q-pa-xs">
        <q-card-section horizontal class="row justify-around">
          <!-- % Y ÚLTIMA ACTIVIDAD -->
          <div class="col-auto column justify-center">
            <span>{{ percent }}% {{ $t("General.percentComplet") }} </span>
            <span>{{ $t("General.lastActivity") }} {{ lastActivity }}</span>
          </div>
          <!-- BARRA DE PROGRESO -->
          <div class="col-4 column justify-center">
            <q-linear-progress :value="progress" rounded color="primary" />
          </div>
        </q-card-section>
      </q-card>
      <!-- BOTÓN DE SIGUIENTE CLASE -->
      <div :class="{ 'col-auto column justify-center': !isMobile, fit: isMobile }">
        <q-btn
          class="full-height"
          :class="{ fit: isMobile }"
          color="primary"
          :label="$t('General.goNextLesson')"
        />
      </div>
    </div>
  </q-footer>
</template>

<script>
import InteractiveChatComponent from "./InteractiveChatComponent.vue";

export default {
  name: "FooterComponent",
  components: { InteractiveChatComponent },
  data() {
    return {
      footer: true,
      percent: 8,
      lastActivity: "5 de oct de 2020 1:17", // instalar moment.js para trabajo con fechas
    };
  },
  computed: {
    progress() {
      return this.percent / 100;
    },
    isMobile() {
      return this.$q.screen.lt.md;
    },
  },
};
</script>
