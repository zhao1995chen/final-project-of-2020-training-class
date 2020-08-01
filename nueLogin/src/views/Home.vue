<template>
  <div class="home">

   <div>
     <label for="account">帳號：</label>
     <input name="account" type="text" v-model="loginData.account">
   </div>
   <div>
     <label for="account">密碼：</label>
     <input name="account" type="text" v-model="loginData.password">
   </div>
     <div>
      <button @click="resetInput">清除</button>
      <button @click="login">登入</button>
      <button @click="signin">註冊</button>
   </div>
   <div v-if="loginData.account != ''&& loginData.password !=''">
     <p>帳號 ： {{loginData.account}}</p>
     <p>密碼 ： {{loginData.password}}</p>
   </div>
   </div>
</template>

<script>
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
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
      if(this.loginData.password == ''){
        alert('請輸入密碼!');
        return;
      }
      //  輸入api
      this.$router.push('/about')
      alert('登入');
    },
    resetInput(){
      this.loginData = JSON.parse(JSON.stringify(this.loginInit));
    }
  }
}
</script>
<style scoped>
.home{
  background: url('../assets/bg.jpg') no-repeat center center fixed; 
     background-size: cover;
     min-height: 700px;
     padding-top: 5%;
}
</style>
