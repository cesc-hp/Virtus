<template>
  <!-- <div> -->
  <q-page-sticky position="bottom-right" :offset="[15, 10]">
    <q-card
      v-morph:card:ichat:500.hideFromClone="morphGroupModel"
      class="q-ma-md bg-primary text-white"
      style="width: 300px; border-bottom-left-radius: 2em"
    >
      <!-- TODO: Esto viene del back -->
      <q-card-section class="text-h6"> New user </q-card-section>

      <q-card-section class="text-subtitle1">
        Please fill the details for a new user.
      </q-card-section>

      <q-card-actions align="right">
        <q-btn flat label="Next" />
        <q-btn flat label="Close" @click="nextMorph" />
      </q-card-actions>
    </q-card>
    <div class="relative-position">
      <div class="absolute-bottom-right">
        <q-btn
          fab
          icon="fab fa-whatsapp"
          color="positive"
          @click="nextMorph"
          v-morph:btn:ichat:300="morphGroupModel"
        />
      </div>
    </div>
  </q-page-sticky>
</template>

<script>
const nextMorphStep = {
  btn: "card",
  card: "btn",
};
export default {
  name: "InteractiveChatComponent",
  data() {
    return {
      morphGroupModel: "btn",
    };
  },

  methods: {
    nextMorph() {
      this.morphGroupModel = nextMorphStep[this.morphGroupModel];
    },
  },
};
</script>
