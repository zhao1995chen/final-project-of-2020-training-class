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
import shop from './assets/image/location/png/location(13).png';
import shop2 from './assets/image/location/png/location(6).png';

const axios = require('axios');

export default {
  name: 'App',
  data: () => ({
    postOffices: [],
    convenientStores: [],
    OSMap: {},
  }),
  async created() {
    await this.getSpots();
    // eslint-disable-next-line
    console.log(2);
    // eslint-disable-next-line
    console.log(this.postOffices);
    // eslint-disable-next-line
    console.log(this.convenientStores);
    await this.initMap();
    await this.addMarkers();
  },
  methods: {
    getTime() {
      const d = new Date();
      const h = d.getHours();
      const m = d.getMinutes();
      const s = d.getSeconds();
      return `${h}:${m}:${s}`;
    },
    getSpots() {
      return axios({
        method: 'get',
        baseURL: 'http://localhost:8088/mapGameLogin',
        url: 'game/getAllMapSpot',
        'Content-Type': 'application/json',
      })
        .then((response) => {
          // eslint-disable-next-line
          console.log(1);
          // eslint-disable-next-line
          console.log(response.data.data.postoffices);
          // eslint-disable-next-line
          console.log(response.data.data.sevens);
          this.postOffices = response.data.data.postoffices;
          this.convenientStores = response.data.data.sevens;
        })
        .catch((error) => {
          // eslint-disable-next-line
          console.log(error);
        });
    },
    initMap() {
      console.log(`map start ${this.getTime()}`);
      this.OSMap = L.map('map', {
        center: [25.041956, 121.508791],
        zoom: 15,
      });

      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.OSMap.flyTo(new L.LatLng(position.coords.latitude, position.coords.longitude));
        }, this.randomLocation());
      } else {
        this.randomLocation();
      }

      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 15,
        minZoom: 15,
      }).addTo(this.OSMap);
      console.log(`map end ${this.getTime()}`);
    },
    addMarkers() {
      console.log(`marker start ${this.getTime()}`);
      this.postOffices.forEach((po) => {
        L.marker([po.latitude, po.longitude], {
          icon: new L.Icon({
            iconUrl: shop,
            iconSize: [75, 75],
          }),
        }).addTo(this.OSMap);
      });
      this.convenientStores.forEach((cs) => {
        L.marker([cs.longitude, cs.latitude], {
          icon: new L.Icon({
            iconUrl: shop2,
            iconSize: [75, 75],
          }),
        }).addTo(this.OSMap);
      });
      console.log(`marker end ${this.getTime()}`);
    },
    randomLocation() {
      const randomIndex = Math.floor(Math.random() * this.postOffices.length + 1);
      const randomLocation = this.postOffices[randomIndex];
      this.OSMap.flyTo(new L.LatLng(randomLocation.latitude, randomLocation.longitude));
    },
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
