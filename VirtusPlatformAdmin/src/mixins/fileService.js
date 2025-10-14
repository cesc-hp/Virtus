import { contentMutations } from "../graphql/content/index";

export const FileService = {
  data() {
    return {};
  },
  methods: {
    newCont(id, type) {
      console.log("entre al metodo" + id + " " + type);

      this.$apollo
        .mutate({
          mutation: contentMutations.newContent,
          variables: {
            typeContent: type,
            idType: id,
            description: "sdsd",
            lessonId: this.routeIdLess
          }
        })
        .then(data => {
          this.contentsList.push(data.data.newContent);
        });
    }
  }
};
