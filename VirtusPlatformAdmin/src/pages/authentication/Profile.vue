<template>
  <q-page class="row justify-center items-center">
    <div class="col-md-12 column items-center">
      <div class="full-width">
        <q-form @submit="onSubmit">
          <q-card flat class="shadow-0 fit">
            <q-card-section class="q-gutter-sm">
              <div class="row items-center q-mt-md">
                <div :class="labelClass" class="text-right">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.ProfilePicture") }}
                  </a>
                </div>
                <div :class="inputClass" class="row">
                  <div class="col-4 q-pr-sm">
                    <q-img
                      src="../../assets/imagen/not_img_profile.png"
                      style="border-radius: 100px"
                    />
                  </div>
                  <div class="col-8 self-end">
                    <div class="row">
                      <div class="self-center">
                        <a class="text-h7 stack-label text-secondary">
                          {{ $t("InputForms.photoNote") }}
                        </a>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-6 self-center">
                        <q-btn
                          dense
                          unelevated
                          color="secondary"
                          size="sm"
                          :label="$t('Btn.photoUp')"
                          type=""
                        />
                      </div>
                      <div class="col-6 self-center">
                        <q-btn
                          dense
                          unelevated
                          color="secondary"
                          size="sm"
                          :label="$t('Btn.delete')"
                          type=""
                        />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row justify-start items-center">
                <div :class="labelClass">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.name") }}
                  </a>
                </div>
                <div :class="inputClass">
                  <q-input
                    class="full-width"
                    dense
                    color="secondary"
                    outlined
                    v-model="form.name"
                    type="text"
                    :placeholder="$t('InputForms.name')"
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
                </div>
              </div>
              <div class="row justify-start items-center">
                <div :class="labelClass">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.lastName") }}
                  </a>
                </div>
                <div :class="inputClass">
                  <q-input
                    class="full-width"
                    dense
                    color="secondary"
                    outlined
                    v-model="form.lastName"
                    type="text"
                    :placeholder="$t('InputForms.lastName')"
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
                </div>
              </div>
              <div class="row justify-start items-center">
                <div :class="labelClass">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.email") }}
                  </a>
                </div>
                <div :class="inputClass">
                  <q-input
                    class="full-width"
                    dense
                    color="secondary"
                    outlined
                    v-model="form.email"
                    type="email"
                    :placeholder="$t('InputForms.email')"
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
                </div>
              </div>
              <div class="row justify-start items-center">
                <div :class="labelClass">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.birthdate") }}
                  </a>
                </div>
                <div :class="inputClass">
                  <q-input
                    class="full-width"
                    dense
                    color="secondary"
                    outlined
                    v-model="form.date"
                    type="date"
                  >
                    <template v-if="form.date" v-slot:append>
                      <q-icon
                        color="primary"
                        name="fas fa-eraser"
                        @click.stop="form.date = null"
                        class="cursor-pointer"
                      />
                    </template>
                  </q-input>
                </div>
              </div>
              <div class="row justify-start items-center">
                <div :class="labelClass">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.password") }}
                  </a>
                </div>
                <div :class="inputClass">
                  <q-input
                    class="full-width"
                    dense
                    color="secondary"
                    outlined
                    v-model="form.password"
                    type="password"
                    :placeholder="$t('InputForms.password')"
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
                </div>
                <div class="q-pl-sm self-center whiteSpace gt-sm">
                  <q-btn
                    dense
                    unelevated
                    color="secondary"
                    size="md"
                    class="full-width"
                    :label="$t('Btn.changePass')"
                    type=""
                  />
                </div>
              </div>
              <div class="row justify-start items-center">
                <div :class="labelClass">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("InputForms.city") }}
                  </a>
                </div>
                <div :class="inputClass">
                  <q-input
                    class="full-width"
                    dense
                    color="secondary"
                    outlined
                    v-model="form.city"
                    type="text"
                    :placeholder="$t('InputForms.city')"
                  >
                    <template v-if="form.city" v-slot:append>
                      <q-icon
                        color="primary"
                        name="fas fa-eraser"
                        @click.stop="form.city = null"
                        class="cursor-pointer"
                      />
                    </template>
                  </q-input>
                </div>
              </div>
              <div class="row justify-center items-center q-mt-md gt-sm">
                <div class="text-right">
                  <a class="text-h6 text-secondary q-mr-md">
                    {{ $t("Register.SynchroSocial") }}
                  </a>
                </div>
              </div>
              <div class="row justify-center items-center q-mt-md">
                <div :class="inputClass" class="column">
                  <div class="q-pa-sm q-gutter-xl">
                    <q-btn
                      round
                      type="a"
                      href="https://linkedin.com/"
                      icon="fab fa-linkedin"
                    />
                    <q-btn
                      round
                      type="a"
                      href="https://google.com/"
                      icon="fab fa-google"
                    />
                  </div>
                </div>
              </div>
              <div class="row items-center q-mt-lg gt-sm">
                <div class="col-3 column items-end" />
                <div class="col-6 items-center column">
                  <q-linear-progress size="lg" :value="progress1" color="secondary">
                    <div class="absolute-full flex flex-center"></div>
                  </q-linear-progress>
                  <q-badge
                    class="q-mt-sm"
                    color="white"
                    text-color="secondary"
                    :label="progressLabel1"
                  />
                </div>
                <div class="col-3 column items-start"></div>
              </div>
            </q-card-section>
          </q-card>
        </q-form>
      </div>
    </div>
    <!-- Estos iconos solo aparecen el la vista de movil para cancelar o guardar -->
    <q-page-sticky position="top-right" :offset="[20, 20]">
      <q-icon
        class="q-ml-sm"
        size="md"
        name="fas fa-save"
        @click="$router.push({ name: 'home' })"
      />
    </q-page-sticky>
  </q-page>
</template>

<script>
export default {
  name: "Profile",
  data() {
    return {
      drawerState: true,
      rememberMe: true,
      labelClass: "col-4 column items-end gt-sm",
      inputClass:
        "col-4 col-xs-12 col-sm-12 col-md-4 col-lg-4 full-widht self-center items-center",
      form: {
        username: "",
        email: "",
        password: "",
      },
      progress1: 0.5699,
    };
  },
  computed: {
    progressLabel1() {
      return (this.progress1 * 100).toFixed(2) + "% " + this.$t("General.completed");
    },
  },
  methods: {
    onSubmit() {
      this.$router.push({ name: "profile" });
    },
  },
};
</script>
