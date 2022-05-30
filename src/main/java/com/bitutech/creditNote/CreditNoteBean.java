package com.bitutech.creditNote;

import java.util.List;

public class CreditNoteBean {
	
	private String creditNoteNo;
	private String creditNoteDate;
	private String creditInvoiceDate;
	private String creditNarration;
	private String creditVendorCustomerName;
	private String creditCurrency;
	private String creditInvoiceNumber;
	private Double creditExchangeRate;
	private String creditTotalTcAmt;
	private String creditTotalBcAmt;
	private String creditCompany;
	private List<CreditNoteDetailBean> creditNoteDetailBean;
	
	
	public String getCreditNoteDate() {
		return creditNoteDate;
	}
	public void setCreditNoteDate(String creditNoteDate) {
		this.creditNoteDate = creditNoteDate;
	}
	public String getCreditInvoiceDate() {
		return creditInvoiceDate;
	}
	public void setCreditInvoiceDate(String creditInvoiceDate) {
		this.creditInvoiceDate = creditInvoiceDate;
	}
	public String getCreditNarration() {
		return creditNarration;
	}
	public void setCreditNarration(String creditNarration) {
		this.creditNarration = creditNarration;
	}
	public String getCreditVendorCustomerName() {
		return creditVendorCustomerName;
	}
	public void setCreditVendorCustomerName(String creditVendorCustomerName) {
		this.creditVendorCustomerName = creditVendorCustomerName;
	}
	public String getCreditCurrency() {
		return creditCurrency;
	}
	public void setCreditCurrency(String creditCurrency) {
		this.creditCurrency = creditCurrency;
	}
	public String getCreditInvoiceNumber() {
		return creditInvoiceNumber;
	}
	public void setCreditInvoiceNumber(String creditInvoiceNumber) {
		this.creditInvoiceNumber = creditInvoiceNumber;
	}
	
	public String getCreditTotalTcAmt() {
		return creditTotalTcAmt;
	}
	public void setCreditTotalTcAmt(String creditTotalTcAmt) {
		this.creditTotalTcAmt = creditTotalTcAmt;
	}
	public String getCreditTotalBcAmt() {
		return creditTotalBcAmt;
	}
	public void setCreditTotalBcAmt(String creditTotalBcAmt) {
		this.creditTotalBcAmt = creditTotalBcAmt;
	}
	public Double getCreditExchangeRate() {
		return creditExchangeRate;
	}
	public void setCreditExchangeRate(Double creditExchangeRate) {
		this.creditExchangeRate = creditExchangeRate;
	}
	public String getCreditCompany() {
		return creditCompany;
	}
	public void setCreditCompany(String creditCompany) {
		this.creditCompany = creditCompany;
	}
	public String getCreditNoteNo() {
		return creditNoteNo;
	}
	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}
	public List<CreditNoteDetailBean> getCreditNoteDetailBean() {
		return creditNoteDetailBean;
	}
	public void setCreditNoteDetailBean(List<CreditNoteDetailBean> creditNoteDetailBean) {
		this.creditNoteDetailBean = creditNoteDetailBean;
	}
	
}
