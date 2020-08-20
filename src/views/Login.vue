<template>
  <div class="testHome" v-loading="loading">
    <div>
      <img src="../assets/login.jpg">
    </div>
    <div class="btnBlocks">
      <div class="acclogin">
        <label for="account">帳號：</label>
        <input name="account" type="text" v-model="loginData.account">
        <label for="account">密碼：</label>
        <input type="password" name="password" v-model="loginData.password">
        <div class="logBlocks">
          <button class="log" @click="login">登入</button>
          <button class="log" @click="forgetPassword">忘記密碼</button>
        </div>
      </div>
    </div>
   </div>
</template>

<script>
import api from './../service/user-service'
import util from './../common/utils'
export default {
  name: 'Login',
  data: () => ({
    loading:false,
    loginInit: {
      account: "",
      password: "",
    },
    loginData: {},
  }),
  created() {
    this.loginData = JSON.parse(JSON.stringify(this.loginInit));
  },
  methods: {
    login() {
      console.log(this.loginData);
      if (this.loginData.account == "") {
        this.$message.error("請輸入帳號!");
        return;
      }
      if (this.loginData.password == "") {
        this.$message.error("請輸入密碼!");
        return;
      }
      this.loading = true;
      api.getUser().then(response => {
        if (response.status == 200) {
          this.$message.success("登入成功，準備進入遊戲!");
          util.setCookie("username", response.data.username, 15);
          this.loginSuccess();
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
    resetInput() {
      this.loginData = JSON.parse(JSON.stringify(this.loginInit));
    },
    loginSuccess() {
      this.$router.push("/change");
    },
    forgetPassword() {
      this.$router.push("/forget");
    },
  },
};
</script>

<style scoped>
.testHome{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
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
  width: 100px;
  height: 80px;
  font-size: 30px;
  margin-left : 30px;
}

.testHome .log{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
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
