package com.bitutech.salesquote;

public class SalesQuoteDetailBean {
	
	private String salesQuoteNo;
	private String countValue;
	private Integer item;
	private Integer uomId;
	private Integer rate;
	private Integer qty;
	private Integer price;
	
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

}
