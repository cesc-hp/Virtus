<template>
  <q-page>
    <div class="row justify-center items-center">
      <div class="col-xs-11 col-sm-11 col-md-7 col-lg-8 column items-center">
        <div class="row column items-center">
          <div class="col-5 full-width">
            <p
              class="text-h5 text-secondary q-pr-lg"
              style="border-bottom: 3px solid red"
            >
              {{ $t("General.welcome") }}
              <br />
              <!-- Esto viene del back -->
              <a class="text-h3 text-secondar">PELAYO</a>
            </p>
          </div>
        </div>
        <div class="row justify-center q-my-md">
          <div class="col-sm-10 col-xs-10 col-md-6">
            <p class="text-h6 text-secondary text-center">
              {{ $t("Register.welcomeNote") }}
            </p>
          </div>
        </div>
        <!-- CARDS DE INICIO -->
        <span v-for="card in [1, 2]" :key="card">
          <WelcomeCard class="q-px-sm" />
        </span>
        <div>
          <p class="text-h6 text-secondary text-center">
            {{ $t("Register.welcomeRedy") }}
          </p>
        </div>
        <div class="q-mb-md">
          <q-btn
            color="secondary"
            :label="$t('Btn.goToContent')"
            @click="$router.push({ name: 'adminView' })"
          />
        </div>
      </div>
      <q-page-sticky position="bottom-left" class="gt-sm" :offset="[20, 20]">
        <q-btn
          color="secondary"
          :label="$t('Btn.principalPage')"
          @click="$router.push({ name: 'login' })"
          icon-right="fas fa-home"
          size="md"
        />
      </q-page-sticky>
    </div>
  </q-page>
</template>

<script>
import WelcomeCard from "src/components/Welcome/WelcomeCard";

export default {
  components: {
    WelcomeCard,
  },

  data() {
    return {};
  },
  methods: {
    onSubmit() {
      this.$router.push({ name: "profile" });
    },
  },
};
</script>
