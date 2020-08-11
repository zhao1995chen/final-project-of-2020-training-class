<template>
  <div id="app">
    <div class="row no-gutters">
      <!-- 顯示地圖和站點 -->
      <div class="col">
        <div id="map"></div>
      </div>
    </div>
  </div>
</template>

<script>
import L from 'leaflet';
import PostOffices from './assets/OpenData_PostOffice-filter.json';
import shop from './assets/image/location/png/location(13).png';

export default {
  name: 'App',
  data: () => ({
    postOffices: [],
    OSMap: {},
  }),
  computed: {
    postoffices() {
      return this.postOffices;
    },
  },
  watch: {
    postoffices() {
      this.updateMap();
    },
  },
  methods: {
    updateMap() {
      // add markers
      this.postOffices.forEach((po) => {
        L.marker([po.latitude, po.longitude], {
          icon: new L.Icon({
            iconUrl: shop,
            iconSize: [75, 75],
          }),
        }).bindPopup(`<p><strong style="font-size: 20px;">${po.name}</strong></p>`).addTo(this.OSMap);
      });
    },
  },
  created() {
    // eslint-disable-next-line
    console.log(PostOffices);
    this.postOffices = Object.keys(PostOffices).map((key) => PostOffices[key]);
  },
  mounted() {
    this.OSMap = L.map('map', {
      center: [25.041956, 121.508791],
      zoom: 18,
    });

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
      maxZoom: 18,
    }).addTo(this.OSMap);
  },
};
</script>

<style lang="scss">
@import 'bootstrap/scss/bootstrap';

h1, h2, h3, h4, h5, h6, p {
  font-family: '微軟正黑體';
}

#map {
  height: 100vh;
  position: relative;
}
</style>
