package com.bitutech.bankPayment;

public class BankPaymentDetailBean {
	private String voucherNo;
	private String accountName;
	private String subAccountCode;
	private String currency;
	private Double amount;
    
   private String shortDetails;

public String getVoucherNo() {
	return voucherNo;
}

public String getAccountName() {
	return accountName;
}

public String getSubAccountCode() {
	return subAccountCode;
}

public String getCurrency() {
	return currency;
}

public Double getAmount() {
	return amount;
}

public String getShortDetails() {
	return shortDetails;
}

public void setVoucherNo(String voucherNo) {
	this.voucherNo = voucherNo;
}

public void setAccountName(String accountName) {
	this.accountName = accountName;
}

public void setSubAccountCode(String subAccountCode) {
	this.subAccountCode = subAccountCode;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

public void setShortDetails(String shortDetails) {
	this.shortDetails = shortDetails;
}


   
}
