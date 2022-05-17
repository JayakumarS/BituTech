package com.bitutech.purchaserequest;

import java.util.List;

public class PurchaseRequestBean {
	
	private String company;
	private String requisitionNo;
	private Integer requestType;
	private String requestDate;
	private Integer requisitionId;
	private Integer sourceLocation;
	private Integer destinationLocation;
	private String jobTitle;
	private String requestedBy;
	private String prReqNo;
	private String costCenter;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Integer getRequestType() {
		return requestType;
	}
	public void setRequestType(Integer requestType) {
		this.requestType = requestType;
	}
	public Integer getSourceLocation() {
		return sourceLocation;
	}
	public void setSourceLocation(Integer sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	public Integer getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(Integer destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobtitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public String getPrReqNo() {
		return prReqNo;
	}
	public void setPrReqNo(String prReqNo) {
		this.prReqNo = prReqNo;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getRequisitionNo() {
		return requisitionNo;
	}
	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}
	public Integer getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(Integer requisitionId) {
		this.requisitionId = requisitionId;
	}

private List<PurchaseRequestDtlBean> purchaseRequestDtlBean;

public List<PurchaseRequestDtlBean> getPurchaseRequestDtlBean() {
	return purchaseRequestDtlBean;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public void setPurchaseRequestDtlBean(List<PurchaseRequestDtlBean> purchaseRequestDtlBean) {
	this.purchaseRequestDtlBean = purchaseRequestDtlBean;
}
}
