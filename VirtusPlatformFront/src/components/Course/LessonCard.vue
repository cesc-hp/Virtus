<template>
  <div class="col-12 items-center q-py-md q-px-sm">
    <q-card flat>
      <q-card-section class="q-pa-none cursor-pointer">
        <div
          style="border-radius: 5px"
          class="row justify-between items-center bg-grey-1 q-pa-sm"
          @click="expanded = !expanded"
        >
          <div class="col-auto">
            <q-icon
              color="grey"
              size="xs"
              :name="expanded ? 'fas fa-arrow-up' : 'fas fa-arrow-down'"
              left
            />
          </div>
          <!-- TODO:Esto viene del back -->
          <div class="col row items-center justify-between text-h6 text-secondary">
            <span>Lesson</span>
            <div class="text-caption text-secondary col-auto">6/7 micro-learnings</div>
          </div>
          <div class="col-auto">
            <q-icon right name="fas fa-circle" color="grey" />
          </div>
        </div>
      </q-card-section>
      <q-slide-transition>
        <div v-show="expanded">
          <q-timeline class="q-pl-sm" color="secondary">
            <TimeLineEntryCard v-for="timeEntry in [1, 2, 3]" :key="timeEntry" />
          </q-timeline>
        </div>
      </q-slide-transition>
    </q-card>
  </div>
</template>

<script>
import TimeLineEntryCard from "../../components/Course/TimeLineEntryCard";

export default {
  components: {
    TimeLineEntryCard,
  },
  name: "LessonCard",
  data() {
    return {
      expanded: false,
    };
  },
};
</script>

<style>
.q-timeline__dot {
  transform: translateY(40%);
}
</style>
