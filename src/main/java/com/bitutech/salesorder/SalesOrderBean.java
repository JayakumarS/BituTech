package com.bitutech.salesorder;

import java.util.List;

import com.bitutech.billofmaterial.BillOfMaterialDtlObjBean;

public class SalesOrderBean {
	
	private String customer;
	private String validFrom;
	private String validTo;
	private String currency;
	private String deliveryDate;
	private String id;
	private String text;
	private String countValue;
	private String salesOrderNo;
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
	
	
	
	
	
}
