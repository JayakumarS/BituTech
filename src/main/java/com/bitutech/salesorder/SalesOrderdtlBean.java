package com.bitutech.salesorder;

public class SalesOrderdtlBean {

	private Integer item;
	private Integer uomId;
	private Integer rate;
	private Integer qty;
	private Integer price;
	private String salesOrderNo;
	private String createdBy;
	private Integer id;
	private String text;
	private String salesQuoteNo;
	


	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSalesOrderNo() {
		return salesOrderNo;
	}

	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSalesQuoteNo() {
		return salesQuoteNo;
	}

	public void setSalesQuoteNo(String salesQuoteNo) {
		this.salesQuoteNo = salesQuoteNo;
	}

}
