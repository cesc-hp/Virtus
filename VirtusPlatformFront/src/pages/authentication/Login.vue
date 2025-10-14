<template>
  <q-card-section class="row justify-center" horizontal>
    <div class="col-xs-12 col-sm-7 col-md-6">
      <div class="row justify-center items-center">
        <p class="col text-secondary q-my-md text-center q-mx-sm">
          {{ $t("Register.loginNote") }}
        </p>
      </div>
      <!-- FORMULARIO LOGIN -->
      <div class="row justify-center items-center">
        <q-form @submit="onSubmit">
          <q-card square class="shadow-0 column">
            <q-card-section
              class="row justify-center items-center full-width q-pa-md q-gutter-sm"
            >
              <!-- EMAIL INPUT -->
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
              <!-- PASSWORD INPUT -->
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
            </q-card-section>
            <!-- BOTÓN DE LOGIN -->
            <q-card-actions class="q-px-lg">
              <q-btn
                dense
                unelevated
                color="secondary"
                size="lg"
                class="full-width"
                :label="$t('Btn.access')"
                type="onSubmit"
              />
            </q-card-actions>
            <!-- LINK RECUPERAR CONTRASEÑA -->
            <q-card-section class="text-center q-pa-none q-mb-sm">
              <a class="text-secondary" style="cursor:pointer;">
                {{ $t("Register.passwordForgot") }}
              </a>
            </q-card-section>
          </q-card>
        </q-form>
      </div>
      <!-- BOTÓN REGISTRAR -->
      <div class="row justify-center q-mb-md q-py-sm items-center">
        <a
          class="text-h6"
          style="cursor:pointer;"
          @click="$router.push('/register')"
          >{{ $t("Btn.register") }}</a
        >
      </div>
    </div>
  </q-card-section>
</template>

<script>
export default {
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
      // return this.$store.dispatch("auth/login", this.form);
      // console.log(this.$store.state.auth.count);
      this.$router.push("/welcome");
    }
  }
};
</script>
