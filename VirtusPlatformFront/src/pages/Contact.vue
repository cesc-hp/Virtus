<template>
  <div>
    <ContactForm class="clasd" />
    <SocialNetworks />
    <!-- <NewsLetter /> -->
  </div>
</template>

<script>
import ContactForm from "components/Contact/ContactForm";
import SocialNetworks from "components/Contact/SocialNetworks";
import NewsLetter from "components/Contact/NewsLetter";
export default {
  name: "Contact",
  components: {
    ContactForm,
    SocialNetworks,
    // NewsLetter,
  },
};
</script>

<style>
.clasd {
  margin-top: 20px;
}
</style>
