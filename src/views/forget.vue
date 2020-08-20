<template>
  <div class="forget-pass" v-loading="loading">
		<div class="forgetBox">
				<img class="image" src="../assets/forget.jpg">
		</div>
		<div class="Box">
			<div class="Box">
				<span class="xiao-require">*</span>
				<label for="username">會員帳號</label>
				<div class="xiao-input">
					<input type="text" id="username" name="username" placeholder="請输入帳號" v-model="loginData.username"/>
					</div>
			</div>
			<div class="Box">
				<span class="xiao-require">*</span>
				<label for="email">會員信箱</label>
				<div class="xiao-input">
					<input type="text" id="email" name="email" placeholder="請输入您註冊的信箱帳號，如：123@gmail.com" v-model="loginData.email" />
					</div>
			</div>
			<div class="submitbox">
				<input id = "submit-button" type="submit" @click="Resetpass" value="發送新密碼">
				</div>
		</div>
	</div>
</template>
<script>
import api from './../service/user-service'
export default {
  name: 'forget',
  data: () => ({
    loading: false,
    loginInit: {
      username: "",
      email: "",
    },
    loginData: {},
  }),
  created() {
    this.resetInput();
  },
  methods: {
    Resetpass() {
      if (this.loginData.username == "") {
        this.$message.error("請輸入帳號!");
        return;
      } else if (this.loginData.email == "") {
        this.$message.error("請輸入信箱!");
        return;
      }
       this.loading = true;
      api.getUser().then(response => {
        if (response.status == 200) {
          this.$message.success("登入成功，準備進入遊戲!");
          // setTimeout(() => {
          // let expireDays = 1000 * 60 * 60 * 24 * 15;
          // this.loginSuccess();
          // this.$cookie.set("username", response.data.username, expireDays);
          // }, 1000);
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
      this.$router.push("/Resetpass");
    },
  },
};
</script>
<style scoped>
.forget-pass{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  font-size: 20px;
  display: flex;
  align-items: center;
  height: 100vh;
}
.forgetBox{
    display: inline-block;
    vertical-align: middle;
    	margin:25px;
}

.image{
  width: 80%;
  height: auto;
}

.forget-pass input{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  height: 30px;
  width: 330px;
  font-size:15px;
  margin:15px;
}
.submitbox input{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  background-color:blueviolet;
  border-radius: 12px;
  color: aliceblue;
  width: 120px;
  height: 80px;
  font-size: 20px;
  margin-left : 30px;
}
.box{
	margin:25px;
}
</style>
