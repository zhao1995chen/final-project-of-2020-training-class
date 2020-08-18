<template>
  <div class="Reset-pass">
    <div>
      <div class="respass">
        <img src="../assets/resetpassword.jpg" style="width:100%;">
      </div>
      <div class="respass">
        <div class="box">
          <div class="reset-input">
          <span class="xiao-require">*</span>
          <label for="account">會員帳號：</label>
            <input v-model="inputData.account" type="text" id="username" name="username" placeholder="請輸入帳號" />
          </div>
        </div>
        <div class="box">
          <span class="xiao-require">*</span>
          <label for="newpass">設定密碼：</label>
          <input v-model="inputData.password" name="newpass" type="text" placeholder="請設定新密碼" />
        </div>
        <div class="box">
          <div class="reset-input">
            <span class="xiao-require">*</span>
            <label for="newpass">確認密碼：</label>
            <input v-model="inputData.newPassword" type="text" id="userPass" name="userPass" placeholder="請再輸入一次密碼" />
          </div>
        </div>
        <div class="finishPass">
          <button class="pass" @click="ResetpassHandle">設定完成</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Resetpass',
  data() {
      return {
        initResetInput:{
          account:'',
          password:'',
          newPassword:'',
        },
        inputData:{}
      }
    },
  created(){
    this.resetInput();
  },
  methods:{
    resetInput(){
      this.inputData = JSON.parse(JSON.stringify(this.initResetInput));
    },
    ResetpassHandle(){
      this.$router.push('/')
    }
  }
}
</script>
<style scoped>
.Reset-pass{
  display: flex;
  align-items: center;
  height: 100vh;
}
.image{
  width: 80%;
  height: auto;
}

.Reset-pass input{
  height: 30px;
  width: 300px;
  font-size:15px;
  margin:15px;
}
.Reset-pass button{
  background-color:darkturquoise;
  border-radius: 12px;
  color: aliceblue;
  width: 100px;
  height: 50px;
  font-size: 15px;
  margin-left : px;
}
.respass{
  display: inline-block;
  vertical-align: middle;
}
.respass input{
  /* border-radius: 15px; */
  height: 30px;
  width: 320px;
  font-size:15px;
}
.box{
	margin:25px;
}
</style>
