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
import ConvenientStores from './assets/7-11 chainStores.json';
import shop1 from './assets/image/location/png/location(24).png';

export default {
  name: 'App',
  data: () => ({
    postOffices: [],
    convenientStores: [],
    OSMap: {},
  }),
  computed: {
    postoffices() {
      return this.postOffices;
    },
    convenientstores() {
      return this.convenientStores;
    },
  },
  watch: {
    postoffices() {
      this.updateMap();
    },
    convenientstores() {
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
            iconSize: [35, 35],
          }),
        }).bindPopup(<p><strong style="font-size: 20px;">${po.name}</strong></p>).addTo(this.OSMap);
      });
      this.convenientStores.forEach((cs) => {
        L.marker([cs.latitude, cs.longitude], {
          icon: new L.Icon({
            iconUrl: shop1,
            iconSize: [35, 35],
          }),
        }).addTo(this.OSMap).bindPopup(<p><strong style="font-size: 20px;">${cs.name}</strong></p>);
      });
    },
  },

  created() {
    // eslint-disable-next-line
    console.log(PostOffices);
    this.postOffices = Object.keys(PostOffices).map((key) => PostOffices[key]);

    // eslint-disable-next-line
    console.log(ConvenientStores);
    this.convenientStores = Object.keys(ConvenientStores).map((key) => ConvenientStores[key]);
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

#map {
  height: 100vh;
  position: relative;
}
</style>
