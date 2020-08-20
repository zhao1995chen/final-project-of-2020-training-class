
<template>
	<el-card class="box-card">
		<ul class="msg-box">
			<li>
				<h4>我要儲值</h4>
			</li>
			<li>
				<h4 style="margin-bottom: 15px;">儲值金額</h4>
				<el-radio-group v-model="amountVal" @change="amountChange">
					<el-radio border :label="''+ 100">鑽石100</el-radio>
					<el-radio border :label="''+ 500">鑽石500</el-radio>
					<el-radio border :label="''+ 1000">鑽石1000</el-radio>
				<el-radio border :label="''">自行輸入金額</el-radio>
				</el-radio-group>
			</li>
			<li>
				<h4 style="margin-bottom: 15px;">儲值方式</h4>
				<el-radio-group v-model="rechargeParams.paymentType" @change="paymentTypeChange">
					<el-radio border :label="''+ 0">街口支付</el-radio>
					<el-radio border :label="''+ 1">LinePay</el-radio>
				</el-radio-group>
			</li>
			<li>
				<h4 style="margin-bottom: 15px;">儲值金額</h4>
				<el-input :disabled="disabled" clearable v-model="rechargeParams.totalAmt" placeholder="請輸入金額" style="width: 150px;"></el-input>
			</li>
		</ul>
		<div style="text-align: center; margin-top: 30px;">
			<el-button type="primary" @click="surePay">確認付款</el-button>
		</div>
	</el-card>
</template>
 
<script>
	export default {
		data() {
			return {
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
		methods: {
			//儲值金額
			amountChange(val) {
				this.rechargeParams.totalAmt = val;
				if (val == '') {
					this.disabled = false
				} else {
					this.disabled = true
				}
			},
	// 		//支付方式
	// 		paymentTypeChange(val) {
	// 			this.rechargeParams.paymentType = val
	// 		},
	// 		//確認支付
	// 		async surePay() {
	// 			if (this.rechargeParams.totalAmt == '') {
	// 				this.$message.warning('请输入金额');
	// 				return;
	// 			}
	// 			const res = await this.$http.post('orderInfo/createOrderInfo', this.rechargeParams)
	// 			const {
	// 				code,
	// 				msg,
	// 				result
	// 			} = res.data
	// 			if (code === '200') {
	// 				//支付方式跳轉
	// 				if (this.rechargeParams.paymentType == '0') {
	// 					this.$message.success('微信支付');
	// 					this.wechatPay(result);
	// 				} else if (this.rechargeParams.paymentType == '1') {
	// 					this.$message.success('支付宝支付')
	// 					const payDiv = document.getElementById('payDiv');
	// 					if (payDiv) {
	// 						document.body.removeChild(payDiv);
	// 					}
	// 					const div = document.createElement('div');
	// 					div.id = 'payDiv';
	// 					div.innerHTML = result;
	// 					document.body.appendChild(div);
	// 					document.getElementById('payDiv').getElementsByTagName('form')[0].submit();
	// 				} else if (this.rechargeParams.paymentType == '2') {
	// 					this.$message.success('餘額支付成功');
	// 					this.$router.push({
	// 						name: 'order'
	// 					})
	// 				} else {
	// 					this.$message.success('活動支付')
	// 				}
	// 			} else if (code === 401) {
	// 				this.$message.error(msg)
	// 				this.$router.push({
	// 					name: 'login'
	// 				})
	// 			} else {
	// 				this.$message.error(msg)
	// 			}
	// 		},
	// 		//微信支付
	// 		wechatPay(result) {
	// 			if (result) {
	// 				const orderParams = JSON.parse(result);
	// 				sessionStorage.qrurl = orderParams.qrurl;
	// 				sessionStorage.amt = orderParams.amt;
	// 				sessionStorage.returnUrl = orderParams.returnUrl;
	// 				sessionStorage.order_id = orderParams.order_id;
	// 				this.$router.push({
	// 					name: 'wechatPay'
	// 				})
	// 			}
	// 		}
	}
 }
</script>
 
<style scoped>
	.msg-box > li {
		list-style: none;
		border-bottom: 1px solid #c5c5c5;
		padding: 20px 10px;
	}
</style>