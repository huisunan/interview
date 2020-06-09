<template>
  <div id="app">
    <nav-bar/>
    <router-view/>
  </div>
</template>

<style lang="scss">

</style>
<script>
  import NavBar from "@/components/NavBar";
  export default {
    components: {NavBar}
  }
</script>
