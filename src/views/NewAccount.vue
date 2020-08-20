<template>
  <div class="NewAccount" v-loading="loading">
    <div>
      <div class="formBox">
        <img src="../assets/account.jpg" style="width:100%;">
			</div>
			<div class="formBox">
				<div class="box">
					<span class="xiao-require">*</span>
					<label for="username">建立帳號</label>
					<div class="xiao-input">
						<input type="text" id="username" name="username" placeholder="請输入帳號" v-model="accountData.username"/>
					</div>
				</div>

				<div class="box">
					<span class="xiao-require">*</span>
					<label for="userPassword">設定密碼</label>
					<div class="xiao-input">
						<input type="password" id="password" name="password" placeholder="請输入密碼" v-model="accountData.password"/>
					</div>
				</div>

				<div class="box">
					<span class="xiao-require">*</span>
					<label for="userEmail">驗證信箱</label>
					<div class="xiao-input">
						<input type="text" id="email" name="email" placeholder="請输入您的信箱帳號，如：123@gmail.com" v-model="accountData.email"/>
					</div>
				</div>

				<div class="box-goLogin">
					<button class="btn" @click="register">加入會員</button>
    				<button class="btn" @click="$router.push('/')">返回首頁</button>
				</div>
      </div>
    </div>
  </div>
</template>

<script>
// 如果要含資料輸入或輸出 就是需要變數
// html上面的 {{...}} v-xx="..." 或者 :class="..." :style="..." 也是屬於動態資料
// 整段script都需要使用
import api from './../service/user-service'
export default {
  name: 'NewAccount',
  //宣告這個檔案裡面所使用到的變數
  data: () => ({
      loading:false,
      accountDataInit: {
        username: "",
        password: "",
        email: "",
      },
      accountData: {},
  }),
  // 生命週期
  created() {
    this.resetInput();
  },
  // 方法宣告
  methods: {
    registe() {
      console.log(this.accountData);
    },
    register() {
      console.log(this.accountData);
      if (this.accountData.username == "") {
        this.$message.error("請輸入帳號!");
        return;
      }
      if (this.accountData.password == "") {
        this.$message.error("請輸入密碼!");
        return;
      }
      if (this.accountData.email == "") {
        this.$message.error("請輸入信箱!");
        return;
      }
       this.loading = true;
      api.getUser().then(response => {
        if (response.status == 200) {
          this.$message.success("登入成功，準備進入遊戲!");
          this.$router.push('/success');
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
    login() {
      this.$router.push("/Login");
    },
    // 重製輸入框方法
    resetInput() {
      this.accountData = JSON.parse(JSON.stringify(this.accountDataInit));
    },
  },
};
</script>
<style scoped>
.formBox{
  display: inline-block;
  vertical-align: middle;
}
.box{
	margin:25px;
}
.formBox input{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  /* border-radius: 15px; */
  height: 30px;
  width: 330px;
  font-size:15px;
  margin:15px;
}
.NewAccount .btn{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  background-color:gold;
  border-radius: 12px;
  color:black;
  width: 120px;
  height: 80px;
  font-size: 20px;
  margin-left : 30px;
}
.NewAccount {
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  font-size: 20px;
  display: flex;
  align-items: center;
  height: 100vh;
}

</style>
