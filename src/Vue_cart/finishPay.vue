<template>
<!-- // 付款成功 -->
  <div>
    <div class="showTime">{{showSecond}}秒，回到首頁，請重新登入!</div>
    <div class="finishPay">
        <img class="image" src="../assets/detosit_thanks.jpg">
    </div>
  </div>
</template>
<script>
export default {
  data(){
    return{
      timeOut:null,
      second: 5,
      showSecond: 5,
    }
  },
  created(){
    this.showTime();
  },
  methods:{
    showTime(){
      if(this.timeOut == null){
        // /success
        this.timeOut = setInterval(() => {
          this.showSecond = this.showSecond -1;
          if(this.showSecond <= 0){
            this.$router.push('/')
          }
        }, 1000)
      }else{
        this.clearTime();
      }
    },
    clearTime(){
      clearInterval(this.timeOut);
      this.timeOut = null;
      this.second = 0;
      this.showSecond = 0;
    }
  },
  destroyed(){
    this.clearTime();
  }
}
</script>

<style scoped>
.finishPay{
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100vw;
  height: 100vh;
}
.showTime{
  font-size: 30px;  
  color:chartreuse;
  position: absolute;
  z-index: 1;
  margin: 0px -50px 0px 0px;
  transform: translate3d(28vw, 25vh, 0px);
}
</style>
