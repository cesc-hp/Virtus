<template>
  <q-layout class="bg-login" view="hHh lpr fFf">
    <q-page-container>
      <q-page class="row justify-center items-center">
        <!-- CARD DE INICIO -->
        <q-card class="login-card q-pt-none" flat>
          <q-card-section class="q-py-none q-mx-lg">
            <div class="flex flex-center">
              <div class="row justify-center items-center">
                <q-img
                  class="q-mr-sm"
                  src="../assets/Virtus_simbolo.png"
                  width="90"
                  height="90"
                />
                <h3 class="text-h3 text-secondary q-my-md" style="font-family: Lovato">
                  VIRTUS
                </h3>
              </div>
            </div>
          </q-card-section>
          <!-- MUESTRA LAS PÁGINAS -->
          <router-view />
          <!-- COPYRIGHT Y VERSIÓN -->
          <q-card-section class="q-pb-none justify-center">
            <div class="column justify-center">
              <div class="text-caption flex flex-center">
                <span class="text-center" v-html="$t('login.copyright')" />
              </div>
              <div class="text-caption flex flex-center">
                <span>Versión: {{ version }}</span>
              </div>
            </div>
          </q-card-section>
        </q-card>
        <q-page-sticky position="bottom-right" :offset="[30, 20]">
          <div class="column items-center">
            <q-btn fab icon="fab fa-whatsapp" color="positive" />
            <p class="text-h8 text-positive gt-sm" style="margin-bottom: 0px">
              {{ $t("Register.wathsappHelp") }}
            </p>
          </div>
        </q-page-sticky>
        <q-page-sticky position="bottom-left" :offset="[30, 20]">
          <q-btn
            icon="fas fa-angle-left"
            color="secondary"
            label="Web"
            @click="$router.push('/')"
          />
        </q-page-sticky>
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script>
import { Platform } from "quasar";

export default {
  name: "LoginLayout",
  computed: {
    version() {
      return process.env.version;
    },
  },
};
</script>

<style scoped></style>
