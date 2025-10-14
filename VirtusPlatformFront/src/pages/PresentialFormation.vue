<template>
  <div>
    <Description title="Presential Formation Title" description="Presential Formation Description" />
    <Micromasters />
    <Teachers />
    <Testimonials />
  </div>
</template>

<script>
import Description from "components/Description";
import Teachers from "components/Teachers";
import Testimonials from "components/Testimonials";
import Micromasters from "components/Micromasters";

export default {
  name: "PresentialFormation",
  components: {
    Description,
    Teachers,
    Testimonials,
    Micromasters,
  },
};
</script>
