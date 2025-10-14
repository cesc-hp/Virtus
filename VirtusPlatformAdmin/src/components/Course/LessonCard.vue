<template>
  <div class="col-xs-12 col-sm-4 col-md-4 col-lg-2 items-center q-pa-sm">
    <q-card bordered style="border: 0px" flat>
      <div v-if="lesson.img !== null">
        <q-img :src="baseUrl + lesson.img.url" />
      </div>
      <div v-else>
        <q-img :src="require('../../assets/imagen/img_not_found.png')" />
      </div>
      <q-btn
        fab-mini
        size="md"
        color="primary"
        icon="fas fa-times"
        class="absolute-top-right q-mr-sm q-mt-sm"
        @click="dialogDelet = true"
      />
      <q-card-section class="q-px-sm q-py-xs">
        <div class="row items-center">
          <p class="col text-h6 text-secondary q-mb-none ellipsis">{{ lesson.title }}</p>
        </div>
        <!-- TODO: Add to i18n -->
        <div class="text-caption text-grey">7 micro-learnings</div>
      </q-card-section>

      <q-separator />
      <q-card-section class="q-py-sm q-px-none">
        <div class="row full-width">
          <div class="col-6 q-pa-xs">
            <q-btn
              class="full-width"
              outline
              color="secondary"
              @click="$router.push({ name: 'content', params: { idLesson: lesson.id } })"
              :label="$t('Btn.content')"
            />
          </div>
          <div class="col-6 q-pa-xs">
            <q-btn
              class="full-width"
              color="secondary"
              :label="$t('Btn.edit')"
              @click="openEditL"
            />
          </div>
        </div>
      </q-card-section>
    </q-card>
    <q-dialog v-model="dialogDelet">
      <DialogDel @deleted="deleteLesson" />
    </q-dialog>
  </div>
</template>

<script>
import DialogDel from "../Dialog/DialogDel";

export default {
  name: "LessonCard",
  components: {
    DialogDel,
  },
  props: {
    lesson: {
      type: Object,
      requider: true,
    },
  },

  data() {
    return {
      dialogDelet: false,
      baseUrl: "http://localhost:8000/assets",
    };
  },

  methods: {
    deleteLesson() {
      this.$emit("deletedlesson", this.lesson.id);
    },

    openEditL() {
      this.$emit("openEdit", this.lesson);
    },
  },
};
</script>
