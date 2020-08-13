<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head lang="en">
	<meta charset="UTF-8">
	<title>綠界金流串接測試</title>
</head>
<body>
<form id="allPayAPIForm" action="https://payment-stage.ecPay.com.tw/Cashier/AioCheckOut/V5" method="post">
<input type="hidden" name="MerchantID" value="2000132">
<input type="hidden" name="TotalAmount" value="100">
<input type="hidden" name="InvoiceMark" value="N">
<input type="hidden" name="PaymentType" value="aio">
<input type="hidden" name="CheckMacValue" value="3E8DCAA50EEBDF3312783DBDF87FA171ED55631F42463DD57F7F9AA4B61A0974">
<input type="hidden" name="NeedExtraPaidInfo" value="N">
<input type="hidden" name="EncryptType" value="1">
<input type="hidden" name="TradeDesc" value="test Description">
<input type="hidden" name="ChoosePayment" value="WebATM">
<input type="hidden" name="ReturnURL" value="http://localhost">
<input type="hidden" name="ItemName" value="Test Item">
<input type="hidden" name="MerchantTradeNo" value="testCompany00asd44">
<input type="hidden" name="MerchantTradeDate" value="2017/01/01 08:05:08">
<script language="JavaScript">
allPayAPIForm.submit()
</script>
</form>

</body>

</html>