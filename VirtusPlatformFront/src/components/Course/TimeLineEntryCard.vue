<template>
  <q-timeline-entry icon="fa fa-times">
    <div
      class="row bg-grey-1 items-center"
      style="border-top-left-radius: 10px; border-bottom-left-radius: 10px"
    >
      <div class="col-xs-12 col-sm-2">
        <q-img
          style="border-top-left-radius: 10px; border-bottom-left-radius: 10px"
          ratio="2"
          src="../../assets/imagen/team_15.jpg"
        />
      </div>
      <div class="col q-ml-md col-xs-12 col-sm-auto">
        <!-- TODO: Viene del back -->
        <p
          class="col text-h6 text-secondary text-weight-bolder q-my-none float-left"
          style="font-family: Lovato"
        >
          LECCIONES
        </p>
      </div>
      <q-space></q-space>

      <div class="col-xs-6 col-sm-auto" :style="alingBtn">
        <q-btn
          flat
          color="secondary"
          :label="$t('Btn.share')"
          icon="fa fa-share-alt"
          :size="buttonSize"
        />
      </div>
      <div class="col-xs-6 col-sm-auto" :style="alingBtn">
        <q-btn
          flat
          color="secondary"
          :label="$t('Btn.forum')"
          icon="fa fa-comment-alt"
          :size="buttonSize"
          @click="$router.push({ name: 'content' })"
        />
      </div>
    </div>
  </q-timeline-entry>
</template>

<script>
export default {
  name: "TimeLineEntryCard",
  data() {
    return {};
  },
  computed: {
    buttonSize() {
      return this.$q.screen.xs ? "sm" : "md";
    },
    alingBtn() {
      return this.$q.screen.xs ? "text-align:center;" : "text-align:end;";
    },
  },
};
</script>
