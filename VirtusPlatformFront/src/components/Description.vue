<template>
  <div>
    <h5 class="text-center">
      <div>{{title}}</div>
      <br />
      <span class="text-center text-grey text-h6">
        <div>
          {{description}}
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt. Lorem ipsum dolor sit amet, consectetur
            adipiscing elit, sed do eiusmod tempor incididunt. Lorem ipsum dolor
            sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.
          </p>
        </div>
      </span>
    </h5>
  </div>
</template>

<script>
export default {
  name: "Description",
  props: {
    title: {
      type: String,
      required: true,
    },
    description: {
      type: String,
      required: true,
    },
  },
  data() {
    return {};
  },
};
</script>
