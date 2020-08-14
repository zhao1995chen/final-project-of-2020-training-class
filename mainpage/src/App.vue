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
import ShopItems from './assets/json/Items.json';

const axios = require('axios');

export default {
  name: 'App',
  data: () => ({
    postOffices: [],
    shopItems: [],
    OSMap: {},
  }),
  async created() {
    this.postOffices = await this.getPostOffices();
    // eslint-disable-next-line
    console.log(2);
    // eslint-disable-next-line
    console.log(this.postOffices);
    await this.initMap();
    await this.getShopItems();
    await this.addMarkers();
  },
  methods: {
    getPostOffices() {
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
          return response.data.data.postoffices;
        })
        .catch((error) => {
          // eslint-disable-next-line
          console.log(error);
        });
    },
    initMap() {
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
    },
    addMarkers() {
      this.postOffices.forEach((po) => {
        L.marker([po.latitude, po.longitude], {
          icon: new L.Icon({
            iconUrl: shop,
            iconSize: [75, 75],
          }),
        }).bindPopup(`
          <p><strong style="font-size: 20px;">${po.name}</strong></p>
          ${this.showShop()}
          <div class="d-flex justify-content-center">
            <button class="btn btn-primary">購買</button>
          </div>
          `).addTo(this.OSMap);
      });
    },
    randomLocation() {
      const randomIndex = Math.floor(Math.random() * this.postOffices.length + 1);
      const randomLocation = this.postOffices[randomIndex];
      this.OSMap.flyTo(new L.LatLng(randomLocation.latitude, randomLocation.longitude));
    },
    getShopItems() {
      this.shopItems = Object.keys(ShopItems).map((key) => ShopItems[key]);
      console.log(this.shopItems);
    },
    showShop() {
      let shopList = '';
      this.shopItems.forEach((item) => {
        shopList += `
        <div class="d-flex row">
            <div class="itemContent col-3"><img src="assets/image/game/png/game(${item.iid}).png" width="50" height="50"></div>
            <div class="itemContent col-3"><p style="font-size: 1rem;">${item.name}</p></div>
            <div class="itemContent col-6 d-flex justify-content-center">
              <button class="col-4 btn btn-outline-secondary">-</button>
              <span class="col-4 align-self-center text-center">0</span>
              <button class="col-4 btn btn-outline-secondary">+</button>
            </div>
          </div>
        </div>`;
      });
      return shopList;
    },
  },
};
</script>

<style lang="scss">
@import 'bootstrap/scss/bootstrap';

h1, h2, h3, h4, h5, h6, p, button {
  font-family: '微軟正黑體';
  text-align: center;
}

#map {
  height: 100vh;
  position: relative;
}

.itemContent {
  display: inline-block;
  margin: auto;
}

.leaflet-popup-content {
  width: 350px;
}
</style>
