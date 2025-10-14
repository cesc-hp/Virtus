<template>
  <!--Dialog Menu Mobil-->
  <div>
    <q-btn round color="secondary" icon="fas fa-bars" @click="toolbar = true" />
    <q-dialog v-model="toolbar" transition-hide="scale" transition-show="scale">
      <div class="column no-box-shadow full-width items-center">
        <div class="row" v-for="(link, i) in links" :key="i">
          <div v-if="link.type === 'q-tab'">
            <q-btn
              size="xl"
              flat
              outline
              rounded
              style="font-family: Lovato"
              class="text-white"
              :label="link.title"
              :to="{ name: link.routeName }"
            />
          </div>
          <div v-else-if="link.type === 'q-drop'">
            <q-btn
              v-for="(linkDrop, i) in link.linksDrop"
              :key="i"
              size="xl"
              flat
              outline
              rounded
              style="font-family: Lovato"
              class="text-white row"
              :label="linkDrop.titleDown"
              :to="{ name: linkDrop.routeName }"
            />
          </div>
        </div>
      </div>
    </q-dialog>
  </div>
</template>

<script>
export default {
  name: "MenuMobil",
  props: {
    links: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      toolbar: false
    };
  }
};
</script>

<style>
.q-dialog__backdrop {
  background: rgba(0, 0, 0, 0.8);
}
</style>
