package com.bitutech.debitNote;

import java.util.List;

public class DebitNoteBean {
	
	private String debitNoteNo;
	private String debitNoteDate;
	private String debitInvoiceDate;
	private String debitNarration;
	private String debitVendorCustomerName;
	private String debitCurrency;
	private String debitInvoiceNumber;
	private Double debitExchangeRate;
	private String debitTotalTcAmt;
	private String debitTotalBcAmt;
	private List<DebitNoteDetailBean> debitNoteDetailBean;
	
	
	public String getDebitNoteDate() {
		return debitNoteDate;
	}
	public void setDebitNoteDate(String debitNoteDate) {
		this.debitNoteDate = debitNoteDate;
	}
	public String getDebitInvoiceDate() {
		return debitInvoiceDate;
	}
	public void setDebitInvoiceDate(String debitInvoiceDate) {
		this.debitInvoiceDate = debitInvoiceDate;
	}
	public String getDebitNarration() {
		return debitNarration;
	}
	public void setDebitNarration(String debitNarration) {
		this.debitNarration = debitNarration;
	}
	public String getDebitVendorCustomerName() {
		return debitVendorCustomerName;
	}
	public void setDebitVendorCustomerName(String debitVendorCustomerName) {
		this.debitVendorCustomerName = debitVendorCustomerName;
	}
	public String getDebitCurrency() {
		return debitCurrency;
	}
	public void setDebitCurrency(String debitCurrency) {
		this.debitCurrency = debitCurrency;
	}
	public String getDebitInvoiceNumber() {
		return debitInvoiceNumber;
	}
	public void setDebitInvoiceNumber(String debitInvoiceNumber) {
		this.debitInvoiceNumber = debitInvoiceNumber;
	}
	public String getDebitTotalTcAmt() {
		return debitTotalTcAmt;
	}
	public void setDebitTotalTcAmt(String debitTotalTcAmt) {
		this.debitTotalTcAmt = debitTotalTcAmt;
	}
	public String getDebitTotalBcAmt() {
		return debitTotalBcAmt;
	}
	public void setDebitTotalBcAmt(String debitTotalBcAmt) {
		this.debitTotalBcAmt = debitTotalBcAmt;
	}
	public String getDebitNoteNo() {
		return debitNoteNo;
	}
	public void setDebitNoteNo(String debitNoteNo) {
		this.debitNoteNo = debitNoteNo;
	}
	public Double getDebitExchangeRate() {
		return debitExchangeRate;
	}
	public void setDebitExchangeRate(Double debitExchangeRate) {
		this.debitExchangeRate = debitExchangeRate;
	}
	public List<DebitNoteDetailBean> getDebitNoteDetailBean() {
		return debitNoteDetailBean;
	}
	public void setDebitNoteDetailBean(List<DebitNoteDetailBean> debitNoteDetailBean) {
		this.debitNoteDetailBean = debitNoteDetailBean;
	}
	

	
	
	
	
	

}
