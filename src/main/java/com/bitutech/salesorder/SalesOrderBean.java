package com.bitutech.salesorder;

import java.util.List;

public class SalesOrderBean {
	
	private String customer;
	private String validFrom;
	private String validTo;
	private String currency;
	private String termCondition;
	private String deliveryDate;
	private String id;
	private String text;
	private String countValue;
	private String salesOrderNo;
	private String salesQuoteNo;
	private String expectedDate;
	private Integer total;
	
	private String email;
	
	private boolean isSuccess;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	private List<SalesOrderdtlBean> salesOrderdtlBean;
	
	

	public String getSalesOrderNo() {
		return salesOrderNo;
	}
	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}
	public List<SalesOrderdtlBean> getSalesOrderdtlBean() {
		return salesOrderdtlBean;
	}
	public void setSalesOrderdtlBean(List<SalesOrderdtlBean> salesOrderdtlBean) {
		this.salesOrderdtlBean = salesOrderdtlBean;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getCountValue() {
		return countValue;
	}
	public void setCountValue(String countValue) {
		this.countValue = countValue;
	}
	public String getSalesQuoteNo() {
		return salesQuoteNo;
	}
	public void setSalesQuoteNo(String salesQuoteNo) {
		this.salesQuoteNo = salesQuoteNo;
	}
	public String getTermCondition() {
		return termCondition;
	}
	public void setTermCondition(String termCondition) {
		this.termCondition = termCondition;
	}
	public String getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
