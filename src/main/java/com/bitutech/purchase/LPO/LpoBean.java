package com.bitutech.purchase.LPO;


import java.util.List;



public class LpoBean {
	private Integer purchaseOrderId;
	private Integer purchaseReqNo;
	private String organizationName;
	private String poNo;
	private String requestType;
	private String poDate;
	private String woType;
	private Integer purchaseType;
	private Integer purchaseFor;
	private Integer vendorId;
	private Integer destinationLocation;
	private Integer advance;
	private String currency;
	private String costCenter;
	private String termsConditions;
	private String remarks;
	private Integer paymentTerms;
	private String vendorAddress;
	private String vendorCity;
	private String  vendorState;
     private Integer vendorZip;
     private String vendorCountry;
     private String  destinationAddress;
     private String destinationCity;
     private String destinationState;
     private Integer  destinationZip;
     private String destinationCountry;
     private Double subTotal;
 	 private Integer discount;
 	 private Double cgst;
 	 private Double sgst;
 	 private Double igst;
 	 private Double freight;
     private Double freightTaxPercent;
     private Double freightTotal;
     private Double otherCharges;
     private String remarksOtherCharges;
     private Double total;
	
	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public Integer getPurchaseReqNo() {
		return purchaseReqNo;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	
	public String getRequestType() {
		return requestType;
	}
	
	public String getPoDate() {
		return poDate;
	}
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}
	public String getWoType() {
		return woType;
	}
	public Integer getPurchaseType() {
		return purchaseType;
	}
	public Integer getPurchaseFor() {
		return purchaseFor;
	}
	
	public Integer getDestinationLocation() {
		return destinationLocation;
	}
	public Integer getAdvance() {
		return advance;
	}
	public String getCurrency() {
		return currency;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public String getTermsConditions() {
		return termsConditions;
	}
	public String getRemarks() {
		return remarks;
	}
	public Integer getPaymentTerms() {
		return paymentTerms;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public String getVendorState() {
		return vendorState;
	}
	public Integer getVendorZip() {
		return vendorZip;
	}
	public String getVendorCountry() {
		return vendorCountry;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public String getDestinationState() {
		return destinationState;
	}
	public Integer getDestinationZip() {
		return destinationZip;
	}
	public String getDestinationCountry() {
		return destinationCountry;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public Integer getDiscount() {
		return discount;
	}
	public Double getCgst() {
		return cgst;
	}
	public Double getSgst() {
		return sgst;
	}
	
	public Double getFreight() {
		return freight;
	}
	public Double getFreightTaxPercent() {
		return freightTaxPercent;
	}
	public Double getFreightTotal() {
		return freightTotal;
	}
	public Double getOtherCharges() {
		return otherCharges;
	}
	public String getRemarksOtherCharges() {
		return remarksOtherCharges;
	}
	public Double getTotal() {
		return total;
	}
	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public void setPurchaseReqNo(Integer purchaseReqNo) {
		this.purchaseReqNo = purchaseReqNo;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public void setWoType(String woType) {
		this.woType = woType;
	}
	public void setPurchaseType(Integer purchaseType) {
		this.purchaseType = purchaseType;
	}
	public void setPurchaseFor(Integer purchaseFor) {
		this.purchaseFor = purchaseFor;
	}
	
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public void setDestinationLocation(Integer destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public void setAdvance(Integer advance) {
		this.advance = advance;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setPaymentTerms(Integer paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}
	public void setVendorZip(Integer vendorZip) {
		this.vendorZip = vendorZip;
	}
	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public void setDestinationState(String destinationState) {
		this.destinationState = destinationState;
	}
	public void setDestinationZip(Integer destinationZip) {
		this.destinationZip = destinationZip;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}
	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}
	
	public Double getIgst() {
		return igst;
	}
	public void setIgst(Double igst) {
		this.igst = igst;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public void setFreightTaxPercent(Double freightTaxPercent) {
		this.freightTaxPercent = freightTaxPercent;
	}
	public void setFreightTotal(Double freightTotal) {
		this.freightTotal = freightTotal;
	}
	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}
	public void setRemarksOtherCharges(String remarksOtherCharges) {
		this.remarksOtherCharges = remarksOtherCharges;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	private List<LpoDtlBeanOne> lpoDtlBeanOne;
	
	
	
	public List<LpoDtlBeanOne> getLpoDtlBeanOne() {
		return lpoDtlBeanOne;
	}
	public void setLpoDtlBeanOne(List<LpoDtlBeanOne> lpoDtlBeanOne) {
		this.lpoDtlBeanOne = lpoDtlBeanOne;
	}
	


}
