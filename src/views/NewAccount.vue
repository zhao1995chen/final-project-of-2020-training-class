<template>
  <!-- <div class="xiao-container"> -->
  <div class="NewAccount">
    <div>
      <div class="formBox">
        <img src="../assets/account.jpg" style="width:100%;">
			</div>
			<form action="#" method="post" class="formBox">
				<div class="box">
					<span class="xiao-require">*</span>
					<label for="username">建立帳號</label>
					<div class="xiao-input">
						<input type="text" id="username" name="username" placeholder="請输入帳號" />
					</div>
				</div>

				<div class="box">
					<span class="xiao-require">*</span>
					<label for="userPassword">設定密碼</label>
					<div class="xiao-input">
						<input type="password" id="userPassword" name="userPassword" placeholder="請输入密碼" />
					</div>
				</div>

				<div class="box">
					<span class="xiao-require">*</span>
					<label for="userEmail">驗證信箱</label>
					<div class="xiao-input">
						<input type="text" id="userEmail" name="userEmail" placeholder="請输入您的信箱帳號，如：123@gmail.com" />
					</div>
				</div>

				<div class="box-goLogin">
					<button class="btn" @click="$router.push('/success')">加入會員</button>
    				<button class="btn" @click="$router.push('/')">返回首頁</button>
				</div>

			</form>
    </div>
  </div>
</template>

<script>
// 如果要含資料輸入或輸出 就是需要變數
// html上面的 {{...}} v-xx="..." 或者 :class="..." :style="..." 也是屬於動態資料
// 整段script都需要使用
export default {
  name: 'NewAccount',
  //宣告這個檔案裡面所使用到的變數
  data() {
    return {
      accountDataInit:{
        newaccount:'',
        newpassword:'',
        newemail:'',
      },
      accountData:{}
    }
  },
  // 生命週期
  created(){
    this.resetInput();
  },
  // 方法宣告
  methods:{
    // 重製輸入框方法
    resetInput(){
	  this.accountData = JSON.parse(JSON.stringify(this.accountDataInit));
	//  ini_set("display_errors","On");
    //  $account = $_POST['mail'];
    //  $password = $_POST['password'];
    //  $member = $_POST['name'];
    //  require_once "../../method/connect.php";
    //  $insert = $connect -> prepare("INSERT INTO member(account,password,member,phone,addr)
    //    VALUES(?,?,?,?,?)");
    //  $insert -> execute(array($account,$password,$member,$phone,$addr));
    // header("location:../?sig_suc=註冊成功");
    }
  }
}
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
  /* border-radius: 15px; */
  height: 30px;
  width: 320px;
  font-size:15px;
}
.NewAccount .btn{
  background-color:gold;
  border-radius: 12px;
  color:black;
  width: 100px;
  height: 40px;
  font-size: 20px;
  margin-left : 20px;
}
.xiao-container{
  display: flex;
  align-items: center;
  height: 100vh;
}

</style>
