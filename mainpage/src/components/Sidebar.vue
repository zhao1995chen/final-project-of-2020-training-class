<template>
  <div class="sidebar">
    <img v-bind:src="'assets/image/game/png/game(' + img + ').png'"
    :key="img" v-for="img in imgs" width="70" height="70" style="margin: 15px">
  </div>
</template>

<script>
export default {
  name: 'Sidebar',
  props: {
    uid: Number,
  },
  data: () => ({
    userInfos: [],
    imgs: [26, 43, 25, 39],
  }),
  created() {

  },
};
</script>

<style lang="scss">
@import 'bootstrap/scss/bootstrap';

.sidebar {
  position: relative;
  height: 100vh;
  width: 100px;
  background-color: rgba($color: #000000, $alpha: 0.7);
  float: left;
}
</style>
