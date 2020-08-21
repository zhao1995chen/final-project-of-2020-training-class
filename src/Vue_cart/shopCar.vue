<template>
  <div v-loading="loading" class="flexbox">
    <div>
      <img src="../assets/role/role.jpg">
    </div>
    <div class="panel">
      <div class="submitbox">
				</div>
      <span v-for="item in dataList" :key="item.id" class="panel-number">
        <img width="100" :src="item.imgUrl">
        <div>
          {{item.name}}
        </div>
        <div>
          {{item.number}}
        </div>
          <el-button type="ghost" size="madin">選擇</el-button>
      </span>
    </div>
  </div>
</template>

<script>
import api from './../service/user-service'
export default {
  data() {
    return {
      loading:false,
      dataList:[],
    }
  },
  created() {
    this.getDataListNotApi();
  },
  methods: {
    getDataList(){
        this.loading = true;
        api.getUser().then(response => {
          if (response.status == 200) {
            this.dataList = [];
            return;
          }
          this.$message.error("登入異常");
        })
        .catch(err => {
          console.log(err);
          this.$message.error("系統異常");
        }).finally(() => {
          this.loading = false;
        })
    },
    getDataListNotApi(){
      this.dataList = [
        {
          name:'Monsters',
          number:'A',
          imgUrl:require('../assets/role/monsters2(31).png'),
        },
        {
          name:'Monsters',
          number:'B',
          imgUrl:require('../assets/role/monsters2(53).png'),
        },
        {
          name:'Monsters',
          number:'C',
          imgUrl:require('../assets/role/monsters2(80).png'),
        },
     
        {
          name:'superHero',
          number:'D',
          imgUrl:require('../assets/role/superhero(9).png'),
        },
        {
          name:'superHero',
          number:'E',
          imgUrl:require('../assets/role/superhero(25).png'),
        },
        {
          name:'superHero',
          number:'F',
          imgUrl:require('../assets/role/superhero(28).png'),
        },
      ];
    }
  },

}
</script>

<style scoped>
  .panel-number {
    font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
    width: 210px;
    border: 1px solid cadetblue;
    padding: 10px;
    margin: 5px;
    display: inline-block;
    transition:All 0.5s ease;
    cursor: pointer;
  }
  .panel-number:hover{
    font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
      transform:scale(1.1);
  }
  .panel{
    width: 70%;
  }
  .flexbox{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 90vw;
  height: 90vh;
}
</style>
