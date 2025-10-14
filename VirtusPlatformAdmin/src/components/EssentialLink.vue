<template>
  <q-expansion-item
    :label="title"
    v-if="children.length !== 0"
    :icon="icon"
    expand-icon="fas fa-chevron-down"
  >
    <q-list>
      <q-item
        clickable
        :to="item.link"
        v-for="(item, index) of children"
        :key="index"
        v-ripple
        active-class="drawer-active-link"
        exact
      >
        <q-item-section class="q-pl-xl">
          <q-item-label class="q-pl-lg text-weight-medium">
            {{ item.title }}
          </q-item-label>
        </q-item-section>
      </q-item>
    </q-list>
  </q-expansion-item>
  <q-item
    clickable
    :to="link"
    v-ripple
    active-class="drawer-active-link"
    exact
    v-else
  >
    <q-item-section v-if="icon" avatar>
      <q-icon :name="icon" />
    </q-item-section>

    <q-item-section>
      <q-item-label>{{ title }}</q-item-label>
      <q-item-label caption>
        {{ caption }}
      </q-item-label>
    </q-item-section>
  </q-item>
</template>

<script>
export default {
  name: "EssentialLink",
  props: {
    title: {
      type: String,
      required: true
    },
    caption: {
      type: String,
      default: ""
    },
    link: {
      type: [Object, String],
      default: "#"
    },
    icon: {
      type: String,
      default: ""
    },
    children: {
      type: Array,
      default: () => []
    }
  }
};
</script>
