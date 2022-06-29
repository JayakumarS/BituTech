package com.bitutech.salesquote;

import java.util.List;

public class SalesQuoteBean {
	
	private String customer;
	private String validFrom;
	private String validTo;
	private String termCondition;
	private String currency;
	private String expectedDate;
	private String id;
	private String text;
	private String countValue;
	private String salesQuoteNo;
	private Integer total;
	private List<SalesQuoteDetailBean> salesQuoteDetailBean;
	public List<SalesQuoteDetailBean> dataArray;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getSalesQuoteNo() {
		return salesQuoteNo;
	}
	public void setSalesQuoteNo(String salesQuoteNo) {
		this.salesQuoteNo = salesQuoteNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public String getTermCondition() {
		return termCondition;
	}
	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}
	public String getCountValue() {
		return countValue;
	}
	public void setCountValue(String countValue) {
		this.countValue = countValue;
	}
	

	public List<SalesQuoteDetailBean> getSalesQuoteDetailBean() {
		return salesQuoteDetailBean;
	}
	public void setSalesQuoteDetailBean(List<SalesQuoteDetailBean> salesQuoteDetailBean) {
		this.salesQuoteDetailBean = salesQuoteDetailBean;
	}
	
	
	
	
	
}
