<template>
  <div>
    <Description title="Historical Travel Title" description="Historical Travel Description" />
    <Viajes title="Our teachers" />
    <Teachers title="Our teachers" />
    <Testimonials title="My Testimonio" />
  </div>
</template>

<script>
import Description from "components/Description";
import Teachers from "components/Teachers";
import Testimonials from "components/Testimonials";
import Viajes from "components/Viajes";

export default {
  name: "HistoricalTravel",
  components: {
    Description,
    Teachers,
    Testimonials,
    Viajes
  },
};
</script>
