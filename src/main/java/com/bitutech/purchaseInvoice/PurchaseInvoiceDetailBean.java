package com.bitutech.purchaseInvoice;

public class PurchaseInvoiceDetailBean {
	
	private String detailItem;
	private String detailQuantity;
	private String detailUnitPrice;
	private String detailTaxAmount;
	private double detailAmount;
	
	
	private String detailCharges;
	private String detailShortDetails;
	private Integer detailSecondRowAmount;
	
	
	public String getDetailItem() {
		return detailItem;
	}
	
	public void setDetailItem(String detailItem) {
		this.detailItem = detailItem;
	}
	
	public String getDetailQuantity() {
		return detailQuantity;
	}
	
	public void setDetailQuantity(String detailQuantity) {
		this.detailQuantity = detailQuantity;
	}
	
	public String getDetailUnitPrice() {
		return detailUnitPrice;
	}
	
	public void setDetailUnitPrice(String detailUnitPrice) {
		this.detailUnitPrice = detailUnitPrice;
	}
	
	public String getDetailTaxAmount() {
		return detailTaxAmount;
	}
	
	public void setDetailTaxAmount(String detailTaxAmount) {
		this.detailTaxAmount = detailTaxAmount;
	}
	
	public double getDetailAmount() {
		return detailAmount;
	}
	
	public void setDetailAmount(double detailAmount) {
		this.detailAmount = detailAmount;
	}
	
	public String getDetailCharges() {
		return detailCharges;
	}
	
	public void setDetailCharges(String detailCharges) {
		this.detailCharges = detailCharges;
	}
	
	public String getDetailShortDetails() {
		return detailShortDetails;
	}
	
	public void setDetailShortDetails(String detailShortDetails) {
		this.detailShortDetails = detailShortDetails;
	}
	
	public Integer getDetailSecondRowAmount() {
		return detailSecondRowAmount;
	}
	
	public void setDetailSecondRowAmount(Integer detailSecondRowAmount) {
		this.detailSecondRowAmount = detailSecondRowAmount;
	}
	

}
