package com.bitutech.bankPayment;

import java.util.List;

public class BankPaymentBean {
	private String voucherNo;
	private Integer companyName;
	private String costCenter;
	private String paymentDate;
	private String paidTo;
	private String chequeDate;
	private String paymentType;
	private Integer cashAcct;
	private Integer currency;
	private Double amount;
	private String narration;
	private String costcenter;
	private String project;
	private String totalAmt;
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getCompanyName() {
		return companyName;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public String getPaidTo() {
		return paidTo;
	}
	public String getChequeDate() {
		return chequeDate;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public Integer getCashAcct() {
		return cashAcct;
	}
	public Integer getCurrency() {
		return currency;
	}
	public Double getAmount() {
		return amount;
	}
	public String getNarration() {
		return narration;
	}
	public String getCostcenter() {
		return costcenter;
	}
	public String getProject() {
		return project;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setCompanyName(Integer companyName) {
		this.companyName = companyName;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}
	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}
	
	public void setCashAcct(Integer cashAcct) {
		this.cashAcct = cashAcct;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	private List<BankPaymentDetailBean> bankPaymentDetailBean;
	public List<BankPaymentDetailBean> getBankPaymentDetailBean() {
		return bankPaymentDetailBean;
	}
	public void setBankPaymentDetailBean(List<BankPaymentDetailBean> bankPaymentDetailBean) {
		this.bankPaymentDetailBean = bankPaymentDetailBean;
	}
	
}
