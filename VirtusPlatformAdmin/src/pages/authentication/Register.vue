<template>
  <q-card-section class="row justify-center" horizontal>
    <div class="col-xs-12 col-sm-7 col-md-6">
      <div class="row justify-center items-center">
        <p class="col text-secondary q-my-md text-center q-mx-sm">
          {{ $t("Register.registerNote") }}
        </p>
      </div>
      <div class="row justify-center items-center">
        <q-form @submit="onSubmit">
          <q-card square class="shadow-0 column">
            <q-card-section
              class="row justify-center items-center full-width q-pa-md q-gutter-sm"
            >
              <q-input
                class="full-width q-px-sm"
                dense
                color="secondary"
                outlined
                v-model="form.name"
                type="text"
                :label="$t('InputForms.name')"
              >
                <template v-if="form.name" v-slot:append>
                  <q-icon
                    color="primary"
                    name="fas fa-eraser"
                    @click.stop="form.name = null"
                    class="cursor-pointer"
                  />
                </template>
              </q-input>
              <q-input
                class="full-width q-px-sm"
                dense
                color="secondary"
                outlined
                v-model="form.lastName"
                type="text"
                :label="$t('InputForms.lastName')"
              >
                <template v-if="form.lastName" v-slot:append>
                  <q-icon
                    color="primary"
                    name="fas fa-eraser"
                    @click.stop="form.lastName = null"
                    class="cursor-pointer"
                  />
                </template>
              </q-input>
              <q-input
                class="full-width q-px-sm"
                dense
                color="secondary"
                outlined
                v-model="form.email"
                type="email"
                :label="$t('InputForms.email')"
              >
                <template v-if="form.email" v-slot:append>
                  <q-icon
                    color="primary"
                    name="fas fa-eraser"
                    @click.stop="form.email = null"
                    class="cursor-pointer"
                  />
                </template>
              </q-input>
              <q-input
                class="full-width q-px-sm"
                dense
                color="secondary"
                outlined
                v-model="form.password"
                type="password"
                :label="$t('InputForms.password')"
              >
                <template v-if="form.password" v-slot:append>
                  <q-icon
                    color="primary"
                    name="fas fa-eraser"
                    @click.stop="form.password = null"
                    class="cursor-pointer"
                  />
                </template>
              </q-input>
              <q-input
                class="full-width q-px-sm"
                dense
                color="secondary"
                outlined
                v-model="form.password2"
                type="password"
                :label="$t('InputForms.passwordrepet')"
              >
                <template v-if="form.password2" v-slot:append>
                  <q-icon
                    color="primary"
                    name="fas fa-eraser"
                    @click.stop="form.password2 = null"
                    class="cursor-pointer"
                  />
                </template>
              </q-input>
            </q-card-section>
            <q-card-actions class="q-px-lg">
              <q-btn
                dense
                unelevated
                color="secondary"
                size="lg"
                class="full-width"
                :label="$t('Btn.register')"
                type="onSubmit"
              />
            </q-card-actions>
          </q-card>
        </q-form>
        <a class="text-secondary text-center q-pt-md q-px-md">
          {{ $t("Register.registerSocial") }}
        </a>
        <div class="q-pa-sm q-gutter-sm">
          <q-btn
            round
            type="a"
            href="https://linkedin.com"
            icon="fab fa-linkedin"
          />
          <q-btn
            round
            type="a"
            href="https://google.com"
            icon="fab fa-google"
          />
        </div>
      </div>
    </div>
    <q-page-sticky position="bottom-right" class="gt-sm" :offset="[30, 5]">
      <div class="column items-center">
        <q-btn fab icon="fab fa-whatsapp" color="positive" />
        <p class="text-h8 text-positive">
          {{ $t("Register.wathsappHelp") }}
        </p>
      </div>
    </q-page-sticky>
    <q-page-sticky position="bottom-left" class="gt-sm" :offset="[30, 20]">
      <q-btn
        icon="fas fa-angle-left"
        color="secondary"
        label="Web"
        @click="$router.push('/')"
      />
    </q-page-sticky>
  </q-card-section>
</template>

<script>
export default {
  name: "Register",
  data() {
    return {
      drawerState: true,
      rememberMe: true,
      form: {
        username: "",
        email: "",
        password: ""
      }
    };
  },
  methods: {
    onSubmit() {
      this.$router.push({ name: "welcome" });
    }
  }
};
</script>
