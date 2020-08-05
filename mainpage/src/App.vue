<template>
  <div id="app">
    <div class="row no-gutters">
      <!-- 選擇地區 -->
      <div class="toolbox col-sm-3 p-2 bg-white">
        <div class="form-group d-flex">
          <label for="city" class="col-form-label mr-2 text-right">縣市</label>
          <div class="flex-fill">
            <select id="city" class="form-control" v-model="select.city">
              <!-- 製作下拉選單 -->
              <option :value="city.name"
              :key="city.name" v-for="city in Districts">
                {{ city.name }}
              </option>
            </select>
          </div>
        </div>
        <div class="form-group d-flex">
          <label for="dist" class="col-form-label mr-2 text-right">地區</label>
          <div class="flex-fill">
            <select id="dist" class="form-control" v-model="select.district">
              <!-- 製作下拉選單 -->
              <option :value="district.name" :key="district.name"
              v-for="district in Districts.find((city) => city.name === select.city).districts">
                {{ district.name }}
              </option>
            </select>
          </div>
        </div>
      </div>

      <!-- 顯示地圖和站點 -->
      <div class="col-sm-9">
        <div id="map"></div>
      </div>
    </div>
  </div>
</template>

<script>
import L from 'leaflet';
import Districts from './assets/Districts.json';
import PostOffices from './assets/OpenData_PostOffice-filter.json';

export default {
  name: 'App',
  data: () => ({
    Districts,
    select: {
      city: '台北市',
      district: '中正區',
    },
    postOffices: [],
    OSMap: {},
  }),
  computed: {
    postoffices() {
      return this.postOffices
        .filter((po) => (po.city === this.select.city) && (po.district === this.select.district));
    },
  },
  watch: {
    postoffices() {
      this.updateMap();
    },
  },
  methods: {
    updateMap() {
      // remove markers
      this.OSMap.eachLayer((layer) => {
        if (layer instanceof L.Marker) {
          this.OSMap.removeLayer(layer);
        }
      });

      // add markers
      this.postoffices.forEach((po) => {
        L.marker([po.latitude, po.longitude]).addTo(this.OSMap);
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

#map {
  height: 100vh;
  position: relative;
}
</style>
