package com.bitutech.purchaseInvoice;

import java.util.List;

public class PurchaseInvoiceBean {
    
    private String invoiceDate;
	private String companyName;
	private String manualInvoiceNo;
	private String quotation;
	private String currency;
	private String dueDate;
	private String customer;
	private double exchangeRate;
	private String type;
	private String narration;
	private String totalFirstRow;
	private String totalSecondRow;
	private String grandTotal;
	private String purchaseInvoiceNo;
	private List<PurchaseInvoiceDetailBean> purchaseInvoiceDetailBean;
	
	
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getManualInvoiceNo() {
		return manualInvoiceNo;
	}
	public void setManualInvoiceNo(String manualInvoiceNo) {
		this.manualInvoiceNo = manualInvoiceNo;
	}
	public String getQuotation() {
		return quotation;
	}
	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public String getTotalFirstRow() {
		return totalFirstRow;
	}
	public void setTotalFirstRow(String totalFirstRow) {
		this.totalFirstRow = totalFirstRow;
	}
	public String getTotalSecondRow() {
		return totalSecondRow;
	}
	public void setTotalSecondRow(String totalSecondRow) {
		this.totalSecondRow = totalSecondRow;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getPurchaseInvoiceNo() {
		return purchaseInvoiceNo;
	}
	public void setPurchaseInvoiceNo(String purchaseInvoiceNo) {
		this.purchaseInvoiceNo = purchaseInvoiceNo;
	}
	public List<PurchaseInvoiceDetailBean> getPurchaseInvoiceDetailBean() {
		return purchaseInvoiceDetailBean;
	}
	public void setPurchaseInvoiceDetailBean(List<PurchaseInvoiceDetailBean> purchaseInvoiceDetailBean) {
		this.purchaseInvoiceDetailBean = purchaseInvoiceDetailBean;
	}
	
	
}
