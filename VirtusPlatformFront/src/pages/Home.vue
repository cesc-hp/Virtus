<template>
  <div>
    <!-- <div>
      <q-img src="../assets/parallax2.jpg">
        <div class="title text-h1">VIRTUS</div>
        <div class="text-subtitle1">Aca va la imagen 3d</div>
      </q-img>
    </div> -->

    <div class="view-content row">
      <div class="col-md-6 col-lg-6 col-xs-12 col-sm-12">
        <q-card
          class="q-pa-sm flex flex-center text-center box-shadow"
          style="margin: 40px;"
        >
          <q-card-section>
            <div class="text-h6">Video Virtus</div>
          </q-card-section>
          <q-card-section class="q-pt-none">
            <q-video src="https://www.youtube.com/embed/k3_tw44QsZQ?rel=0" />
          </q-card-section>
        </q-card>
      </div>

      <div class="col-md-6 col-lg-6 col-xs-12 col-sm-12">
        <q-card
          class="q-pa-sm flex flex-center text-center box-shadow"
          style="margin: 40px;"
        >
          <q-card-section>
            <div class="text-h6">Agenda</div>
          </q-card-section>
          <q-card-section class="q-pt-none">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur
            adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor
            sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt.
          </q-card-section>
        </q-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {};
  }
};
</script>
