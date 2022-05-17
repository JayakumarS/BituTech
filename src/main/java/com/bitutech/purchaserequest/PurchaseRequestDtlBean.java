package com.bitutech.purchaserequest;

public class PurchaseRequestDtlBean {
	private Integer requisitionId ;
    private Integer itemId ;
    private String itemDesc ;
    private Double pendingQuantity ;
    private Double quantity ;
    private Integer altuom ;
    private Double altqty ;
    private String edd ;
	public Integer getRequisitionId() {
		return requisitionId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public Double getPendingQuantity() {
		return pendingQuantity;
	}
	public Double getQuantity() {
		return quantity;
	}
	public Integer getAltuom() {
		return altuom;
	}
	public Double getAltqty() {
		return altqty;
	}
	public String getEdd() {
		return edd;
	}
	public void setRequisitionId(Integer requisitionId) {
		this.requisitionId = requisitionId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public void setPendingQuantity(Double pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public void setAltuom(Integer altuom) {
		this.altuom = altuom;
	}
	public void setAltqty(Double altqty) {
		this.altqty = altqty;
	}
	public void setEdd(String edd) {
		this.edd = edd;
	}


}
