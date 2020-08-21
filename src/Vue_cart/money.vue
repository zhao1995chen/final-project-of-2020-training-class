<template>
	<div class="box-card">
		<div>
      <img src="../assets/Deposit.jpg">
    </div>
		<ul class="msg-box">
			<li>
				<h4>沒鑽石買寶物啦~~快來儲值一下，小夥伴們需要你///</h4>
			</li>
				<h4>訂單編號: <el-input :disabled="true" clearable v-model="this.form.number" placeholder="訂單編號" style="width: 150px;">
				</el-input></h4>
				<li>
					<h4 style="margin-bottom: 20px;">儲值金額</h4>
					<el-radio-group v-model="amountVal" @change="amountChange">
						<el-radio border :label="''+ 100"><img width="20" src="../assets/money/game(28).png" alt=""> 鑽石100</el-radio>
						<el-radio border :label="''+ 500"><img width="20" src="../assets/money/game(28).png" alt=""> 鑽石500</el-radio>
						<el-radio border :label="''+ 1000"><img width="20" src="../assets/money/game(28).png" alt=""> 鑽石1000</el-radio>
						<el-radio border :label="''"><img width="20" src="../assets/money/game(28).png" alt=""> 自行輸入金額</el-radio>
					</el-radio-group>
				</li>
				<li>
					<h4 style="margin-bottom: 20px;">儲值方式</h4>
					<el-radio-group v-model="rechargeParams.paymentType" @change="paymentTypeChange">
						<el-radio border :label="''+ 0"><img width="20" src="../assets/money/th.jpg" alt=""> 街口支付</el-radio>
						<el-radio border :label="''+ 1"><img width="20" src="../assets/money/line.jpg" alt=""> LinePay</el-radio>
						<el-radio border :label="''+ 2"><img width="20" src="../assets/money/ECPay.png" alt=""> ECPay</el-radio>
					</el-radio-group>
				</li>
				<li>
					<h4 style="margin-bottom: 20px;"><img width="20" src="../assets/money/game(3).png" alt="">儲值金額</h4>
					<el-input :disabled="disabled" clearable v-model="rechargeParams.totalAmt" placeholder="請輸入金額" style="width: 150px;"></el-input>
				</li>
				<li>
					<div style="text-align: center; margin-top: 30px;">
						<el-button type="primary" @click="finishPay">確認付款</el-button>
					</div>
				</li>
			</ul>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				form:{
					number:0
				},
				amountVal: '',
				disabled: false,
				//充值参数
				rechargeParams: {
					"totalAmt": '', //金额
					"paymentType": "0", //支付方式[0:街口支付,1:LinePay,2:餘額,3:活動]
          			"transType": "0" //交易類型[0:儲值,1:消費]
				}
			}
		},
created () {
  // 调用获取当前日期的方法加四位随机数  赋值表单中的项目编号
  this.form.number = this.getProjectNum() + Math.floor(Math.random() * 10000)
},
methods: {
	// 获取当前日期的方法
	getProjectNum () {
      const projectTime = new Date() // 當前標準時間
      const Year = projectTime.getFullYear() // 獲取当前年份
      const Month = projectTime.getMonth() + 1
      const Day = projectTime.getDate()
      var CurrentDate = Year
      if (Month >= 10) { // 判断月份和日是否大于10或者小于10
        CurrentDate += Month
      } else {
        CurrentDate += '0' + Month
      }
      if (Day >= 10) {
        CurrentDate += Day
      } else {
        CurrentDate += '0' + Day
      }
      return CurrentDate
	},
	//儲值金額
			amountChange(val) {
				this.rechargeParams.totalAmt = val;
				if (val == '') {
					this.disabled = false
				} else {
					this.disabled = true
				}
			},
			//支付方式
			paymentTypeChange(val) {
				this.rechargeParams.paymentType = val
			},
			//確認支付
			async surePay() {
				if (this.rechargeParams.totalAmt == '') {
					this.$message.warning('請輸入金額');
					return;
				}
				const res = await this.$http.post('orderInfo/createOrderInfo', this.rechargeParams)
				const {
					code,
					msg,
					result
				} = res.data
				if (code === '200') {
					//支付方式跳轉
					if (this.rechargeParams.paymentType == '0') {
						this.$message.success('微信支付');
						this.wechatPay(result);
					} else if (this.rechargeParams.paymentType == '1') {
						this.$message.success('支付宝支付')
						const payDiv = document.getElementById('payDiv');
						if (payDiv) {
							document.body.removeChild(payDiv);
						}
						const div = document.createElement('div');
						div.id = 'payDiv';
						div.innerHTML = result;
						document.body.appendChild(div);
						document.getElementById('payDiv').getElementsByTagName('form')[0].submit();
					} else if (this.rechargeParams.paymentType == '2') {
						this.$message.success('餘額支付成功');
							name: 'order'
					} else {
						this.$message.success('活動支付')
					}
				} else if (code === 401) {
					this.$message.error(msg)
					this.$router.push({
						name: 'login'
					})
				} else {
					this.$message.error(msg)
				}
			},
			//微信支付
			wechatPay(result) {
				if (result) {
					const orderParams = JSON.parse(result);
					sessionStorage.qrurl = orderParams.qrurl;
					sessionStorage.amt = orderParams.amt;
					sessionStorage.returnUrl = orderParams.returnUrl;
					sessionStorage.order_id = orderParams.order_id;
					this.$router.push({
					name: 'wechatPay'
					})
				}
			},
			//finishPay
			finishPay(result) {
				if (result) {
					const orderParams = JSON.parse(result);
					sessionStorage.qrurl = orderParams.qrurl;
					sessionStorage.amt = orderParams.amt;
					sessionStorage.returnUrl = orderParams.returnUrl;
					sessionStorage.order_id = orderParams.order_id;
					this.$router.push({
					name: 'wechatPay'
					})
				}
			}
	}
}
</script>

<style scoped>
.box-card{
  font-family: arial,"Microsoft JhengHei","微軟正黑體",sans-serif !important;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 90vw;
  height: 90vh;
}
.msg-box > li{
	list-style: none;
	border-bottom: 1px solid #c5c5c5;
	padding: 20px 10px;
}
.msg-box > li:last-child{
	border-bottom: none;
	padding:  0;
}
.msg-box{
  position: absolute;
    margin: 0px -50px -45px 0px;
    transform: translate3d(-25px, 45px, 0px);
}

</style>
