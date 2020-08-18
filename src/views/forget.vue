<template>
  <div class="forget-pass">
		<div class="forgetBox">
				<img class="image" src="../assets/forget.jpg">
		</div>
		<form action="javascript:void(0);" method="post" class="forgetBox">
			<div class="box">
				<span class="xiao-require">*</span>
				<label for="username">會員帳號</label>
				<div class="xiao-input">
					<input v-model="inputData.account" type="text" id="username" name="username" placeholder="請输入帳號" />
				</div>
			</div>
			<div class="box">
				<span class="xiao-require">*</span>
				<label for="userEmail">會員信箱</label>
				<div class="xiao-input">
					<input v-model="inputData.userEmail" type="text" id="userEmail" name="userEmail" placeholder="請输入您註冊的信箱帳號，如：123@gmail.com" />
				</div>
			</div>
			<div class="submitbox">
				<button class="new" @click="sendNewPassword">發送新密碼</button>
			</div>
		</form>
	</div>
</template>
<script>
export default {
  name: 'forget',
  data() {
      return {
        initInput:{
          account:'',
          userEmail:'',
          newPassword:'',
        },
        inputData:{}
      }
    },
  created(){
    this.forgetInput();
  },
  methods:{
    forgetInput(){
      this.inputData = JSON.parse(JSON.stringify(this.initInput));
    },
    sendNewPassword(){
			this.$router.push('/Resetpass')
			// alert('send new password');
    }
  }
}
</script>
<style scoped>
.forget-pass{
  display: flex;
  align-items: center;
  height: 100vh;
}
.forgetBox{
    display: inline-block;
    vertical-align: middle;
}

.image{
  width: 80%;
  height: auto;
}
.forget-passbox{
	margin:25px;
}
.forget-pass input{
  height: 30px;
  width: 330px;
  font-size:15px;
  margin:15px;
}
.forget-pass button{
  background-color:blueviolet;
  border-radius: 12px;
  color: aliceblue;
  width: 100px;
  height: 50px;
  font-size: 15px;
  margin-left : px;
}
.box{
	margin:25px;
}
</style>
