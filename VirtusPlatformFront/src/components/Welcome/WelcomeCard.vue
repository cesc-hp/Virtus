<template>
  <div class="row justify-center full-width">
    <q-card
      bordered
      style="border: 2px solid #1b1464; border-radius: 30px"
      flat
      class="shadow-0 fit q-mb-lg"
    >
      <q-card-section class="q-pa-sm">
        <div>
          <!-- TODO: Esto viene del back -->
          <p class="text-h6 text-secondary text-left q-mb-sm q-ml-md">
            MÓDULO DE INTRODUCCIÓN
          </p>
        </div>
        <div class="row">
          <div class="col self-center">
            <p class="text-secondary q-mb-sm q-mx-md" style="text-align: justify">
              Descripción: Te contamos el por qué de esta formación, que sentido tiene
              hacerla, que estructura lógica planteamos, y que metodología se va a seguir
              a lo largo del recorrido.
            </p>
          </div>
          <div class="col-2 column self-center items-center q-px-sm gt-sm">
            <q-btn
              color="secondary"
              :label="$t('Btn.see')"
              @click="$router.push({ name: 'login' })"
            />
          </div>
        </div>
        <div class="row q-ml-sm">
          <div class="row q-pr-sm">
            <div class="column">
              <q-icon class="q-ml-sm" size="sm" name="fas fa-clock" />
            </div>
            <div class="column q-ml-sm">
              <p class="text-h8 text-secondary q-mb-sm">12 {{ $t("Subtitles.min") }}</p>
            </div>
          </div>
          <div class="row">
            <div class="column">
              <q-icon class="q-ml-sm" size="sm" name="fas fa-film" />
            </div>
            <div class="column q-ml-sm">
              <p class="text-h8 text-secondary q-mb-sm">3 {{ $t("Subtitles.pills") }}</p>
            </div>
          </div>
        </div>
        <div class="q-pl-md q-pr-sm q-pb-sm full-width lt-md">
          <q-btn
            class="full-width"
            color="secondary"
            :label="$t('Btn.see')"
            @click="$router.push({ name: 'login' })"
          />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  name: "WelcomeCard",
};
</script>
