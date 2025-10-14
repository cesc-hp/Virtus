import { contentQueries } from "../../graphql/content/index";

export const GalleryGetAllImg = {
  data() {
    return {
      files: [],
      fileXCreated: [
        {
          created: "",
          imgXCreat: []
        }
      ]
    };
  },
  methods: {
    getAllImg() {
      this.$apollo
        .query({
          query: contentQueries.getAllImg,
          variables: {
            filter: null
          }
        })
        .then(data => {
          if (
            data.data.getAllImg.content.length != 0 &&
            this.fileXCreated[0].imgXCreat.length == 0
          ) {
            this.files = data.data.getAllImg.content;
            this.fileXCreated[0].created = this.files[0].created;
            this.fileXCreated[0].imgXCreat[0] = this.files[0];
            var existCreat = true;
            let x = 1;
            let y = 0;

            while (x < this.files.length) {
              while (y < this.fileXCreated.length) {
                if (this.fileXCreated[y].created == this.files[x].created) {
                  console.log(this.files[x].created);
                  this.fileXCreated[y].imgXCreat.push(this.files[x]);
                  existCreat = true;
                  break;
                } else {
                  existCreat = false;
                }
                y++;
              }
              y = 0;
              if (existCreat == false) {
                var parCreatImg = {
                  created: this.files[x].created,
                  imgXCreat: [this.files[x]]
                };
                this.fileXCreated.push(parCreatImg);
                existCreat = true;
              }
              x++;
            }
          }
        });
    }
  }
};
