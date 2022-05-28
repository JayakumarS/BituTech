package com.bitutech.purchase.LPO;

public class LpoDtlBeanOne {
	private Integer purchaseOrderId;
	private String requisitionNo;
	private Integer itemId;
	private String itemDescription;
	private String edd;
	private Integer purchaseUOM;
	private Double purchaseQty;
	private Integer vendorUOM;
	private Double vendorQty;
	private Double availableQty;
	private Double unitPrice;
	private Integer oldUnitPrice;
	private Integer price;
	private Double discount;
	private Integer discountType;
	private Double discountPercent;
	private String costCenter;
	private Integer netPrice;
	private Double taxCGST;
	private Double taxSGST;
	private Double taxIGST;
	private Double taxCGSTinPercent;
	private Double taxSGSTinPercent;
	private Double taxIGSTinPercent;
	private Double finalTotal;
	
	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}
	
	
	public String getItemDescription() {
		return itemDescription;
	}
	public String getEdd() {
		return edd;
	}
	public Integer getPurchaseUOM() {
		return purchaseUOM;
	}
	public Double getPurchaseQty() {
		return purchaseQty;
	}
	public Integer getVendorUOM() {
		return vendorUOM;
	}
	public Double getVendorQty() {
		return vendorQty;
	}
	public Double getAvailableQty() {
		return availableQty;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public Integer getOldUnitPrice() {
		return oldUnitPrice;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getDiscountType() {
		return discountType;
	}
	public Double getDiscountPercent() {
		return discountPercent;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public Integer getNetPrice() {
		return netPrice;
	}
	
	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	
	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public void setEdd(String edd) {
		this.edd = edd;
	}
	public void setPurchaseUOM(Integer purchaseUOM) {
		this.purchaseUOM = purchaseUOM;
	}
	public void setPurchaseQty(Double purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
	public void setVendorUOM(Integer vendorUOM) {
		this.vendorUOM = vendorUOM;
	}
	public void setVendorQty(Double vendorQty) {
		this.vendorQty = vendorQty;
	}
	public void setAvailableQty(Double availableQty) {
		this.availableQty = availableQty;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setOldUnitPrice(Integer oldUnitPrice) {
		this.oldUnitPrice = oldUnitPrice;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}
	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public void setNetPrice(Integer netPrice) {
		this.netPrice = netPrice;
	}
	
	
	public Double getTaxIGST() {
		return taxIGST;
	}

	public void setTaxIGST(Double taxIGST) {
		this.taxIGST = taxIGST;
	}

	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTaxCGST() {
		return taxCGST;
	}

	public Double getTaxSGST() {
		return taxSGST;
	}

	public Double getTaxIGSTinPercent() {
		return taxIGSTinPercent;
	}

	public Double getFinalTotal() {
		return finalTotal;
	}

	public void setTaxCGST(Double taxCGST) {
		this.taxCGST = taxCGST;
	}

	public void setTaxSGST(Double taxSGST) {
		this.taxSGST = taxSGST;
	}

	public void setTaxIGSTinPercent(Double taxIGSTinPercent) {
		this.taxIGSTinPercent = taxIGSTinPercent;
	}

	public void setFinalTotal(Double finalTotal) {
		this.finalTotal = finalTotal;
	}

	public Double getTaxCGSTinPercent() {
		return taxCGSTinPercent;
	}

	public Double getTaxSGSTinPercent() {
		return taxSGSTinPercent;
	}

	public void setTaxCGSTinPercent(Double taxCGSTinPercent) {
		this.taxCGSTinPercent = taxCGSTinPercent;
	}

	public void setTaxSGSTinPercent(Double taxSGSTinPercent) {
		this.taxSGSTinPercent = taxSGSTinPercent;
	}

	
}
