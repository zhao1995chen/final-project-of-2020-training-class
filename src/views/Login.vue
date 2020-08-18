<template>
  <div class="testHome">
    <div>
      <img src="../assets/login.jpg">
    </div>
    <div class="btnBlocks">
      <div class="acclogin">
        <label for="account">帳號：</label>
        <input name="account" type="text" v-model="loginData.account">
        <label for="account">密碼：</label>
        <input name="account" type="text" v-model="loginData.password">
        <div class="logBlocks">
          <button class="log" @click="login">登入</button>
          <button class="log" @click="forgetPassword">忘記密碼</button>
        </div>
      </div>
    </div>
   </div>
</template>

<script>
export default {
  name: 'Login',
    data() {
       return {
           loginInit:{
           account:'',
           password:'',
         },
         loginData:{}
       }
     },
     created(){
       this.resetInput();
     },
     methods:{
       login(){
      console.log(this.loginData);
      if(this.loginData.account == ''){
        alert('請輸入帳號!');
        return;
      }
      else if(this.loginData.password == ''){
        alert('請輸入密碼!');
        return;
      }
      alert('登入');
    },
    resetInput(){
      this.loginData = JSON.parse(JSON.stringify(this.loginInit));
    },
    forgetPassword(){
      this.$router.push('/Forget')
    }
  }
}
</script>
<style scoped>
.testHome{
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100vw;
  height: 100vh;
}
.btnBlocks{
  position: absolute;
  margin: 0px -50px -15px 0px;
  transform: translate3d(500px, -155px, 0px);
}
.logBlocks{
  width: 340px;
}
.acclogin{
  position: absolute;
  right: 400px;
  width: 120px;
  height: 80px;
  font-size: 30px;
  margin-left : 30px;
}

.testHome .log{
  background-color:orangered;
  border-radius: 12px;
  color:aliceblue;
  width: 120px;
  height: 80px;
  font-size: 20px;
  margin-left : 30px;
}
.acclogin input{
  margin:25px;
  /* border-radius: 15px; */
  height: 30px;
  width: 320px;
  font-size:20px;
}
</style>
