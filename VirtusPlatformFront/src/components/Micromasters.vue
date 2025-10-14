<template>
  <div>
    <div class="row">
      <div class="col-md-12 col-lg-12 col-xs-12 col-sm-12">
        <h5 class="text-center">
          Micromasters Disponibles
          <br />
          <span
            class="text-center text-grey text-h6"
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
        </h5>
      </div>
    </div>
    <div class="row q-col-gutter-sm q-px-xl">
      <div class="col-lg-3 col-md-3 col-xs-12 col-sm-6 q-px-lg">
        <q-card>
          <q-card-section class="text-white" style="background: #ec982f">
            <div class="text-h6 text-center">FREE</div>
          </q-card-section>
          <q-card-section class="q-pa-md">
            <q-list dense padding style="border-bottom: 1px solid lightgrey;">
              <q-item>
                <span class="text-weight-bold">For small size companies</span>
              </q-item>
              <q-item>50 GB storage</q-item>
              <q-item>10 Domains</q-item>
              <q-item>15 Projects</q-item>
              <q-item>Free Deployment</q-item>
            </q-list>
          </q-card-section>
          <q-card-section class="q-pa-none" style="color: #ec982f">
            <div class="text-center">
              <span class="text-h2 text-center">$0</span>/mo
            </div>
          </q-card-section>
          <q-card-section>
            <div class="text-center q-px-lg">
              <q-btn
                size="md"
                class="full-width q-pa-xs"
                style="background: #ec982f; color: white"
                label="Choose Plan"
              />
              <br />
              <div class="q-mt-md">Terms and Conditions apply</div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-3 col-md-3 col-xs-12 col-sm-6 q-px-lg">
        <q-card>
          <q-card-section class="text-white" style="background: #f4655f">
            <div class="text-h6 text-center">STANDARD</div>
          </q-card-section>
          <q-card-section class="q-pa-md">
            <q-list dense padding style="border-bottom: 1px solid lightgrey;">
              <q-item>
                <span class="text-weight-bold">For medium companies</span>
              </q-item>
              <q-item>50 GB storage</q-item>
              <q-item>10 Domains</q-item>
              <q-item>15 Projects</q-item>
              <q-item>Free Deployment</q-item>
            </q-list>
          </q-card-section>
          <q-card-section class="q-pa-none" style="color: #f4655f">
            <div class="text-center">
              <span class="text-h2 text-center">$50</span>/mo
            </div>
          </q-card-section>
          <q-card-section>
            <div class="text-center q-px-lg">
              <q-btn
                size="md"
                class="full-width q-pa-xs"
                style="background: #f4655f; color: white"
                label="Choose Plan"
              />
              <br />
              <div class="q-mt-md">Terms and Conditions apply</div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-3 col-md-3 col-xs-12 col-sm-6 q-px-lg">
        <q-card>
          <q-card-section class="text-white q-pa-md" style="background: #8b3bbd">
            <div class="text-h6 text-center">PREMIUM</div>
          </q-card-section>
          <q-card-section class="q-pa-md">
            <q-list dense padding style="border-bottom: 1px solid lightgrey;">
              <q-item>
                <span class="text-weight-bold">For average companies</span>
              </q-item>
              <q-item>50 GB storage</q-item>
              <q-item>10 Domains</q-item>
              <q-item>15 Projects</q-item>
              <q-item>Free Deployment</q-item>
            </q-list>
          </q-card-section>
          <q-card-section class="q-pa-none" style="color: #8b3bbd">
            <div class="text-center">
              <span class="text-h2 text-center">$250</span>/mo
            </div>
          </q-card-section>
          <q-card-section>
            <div class="text-center q-px-lg">
              <q-btn
                size="md"
                class="full-width q-pa-xs"
                :style="'background: #8b3bbd; color: white'"
                label="Choose Plan"
              />
              <br />
              <div class="q-mt-md">Terms and Conditions apply</div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-3 col-md-3 col-xs-12 col-sm-6 q-px-lg">
        <q-card>
          <q-card-section class="text-white" style="background: #3b97d1">
            <div class="text-h6 text-center">PROFESSIONAL</div>
          </q-card-section>
          <q-card-section class="q-pa-md">
            <q-list dense padding style="border-bottom: 1px solid lightgrey;">
              <q-item>
                <span class="text-weight-bold">For large companies</span>
              </q-item>
              <q-item>50 GB storage</q-item>
              <q-item>10 Domains</q-item>
              <q-item>15 Projects</q-item>
              <q-item>Free Deployment</q-item>
            </q-list>
          </q-card-section>
          <q-card-section class="q-pa-none" style="color: #3b97d1">
            <div class="text-center">
              <span class="text-h2 text-center">$500</span>/mo
            </div>
          </q-card-section>
          <q-card-section>
            <div class="text-center q-px-lg">
              <q-btn
                size="md"
                class="full-width q-pa-xs"
                style="background:#3b97d1; color: white"
                label="Choose Plan"
              />
              <br />
              <div class="q-mt-md">Terms and Conditions apply</div>
            </div>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Micromasters",
  data() {
    return {};
  },
};
</script>
