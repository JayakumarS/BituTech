package com.bitutech.purchaserequest;

import java.io.Serializable;
import java.util.List;
import com.bitutech.core.util.BasicResultBean;
import com.bitutech.core.util.DropDownList;


public class PurchaseRequestResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<PurchaseRequestBean> purchaseRequestDetails;
//	private List<PurchaseRequestBean> uomCategoryList;
	private List<PurchaseRequestDtlBean> purchaseRequestDtlBean;
    private List<DropDownList> requisitionNoList;
	private String requisitionNo;
	private PurchaseRequestBean purchaseRequestBean;
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<PurchaseRequestBean> getPurchaseRequestDetails() {
		return purchaseRequestDetails;
	}

	public void setPurchaseRequestDetails(List<PurchaseRequestBean> purchaseRequestDetails) {
		this.purchaseRequestDetails = purchaseRequestDetails;
	}

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public List<DropDownList> getRequisitionNoList() {
		return requisitionNoList;
	}

//	public void setRequisitionNoList(List<DropDownList> requisitionNoList) {
//		this.requisitionNoList = requisitionNoList;
//	}
//	public List<PurchaseRequestBean> getUomCategoryList() {
//		return uomCategoryList;
//	}
//
//	public void setUomCategoryList(List<PurchaseRequestBean> uomCategoryList) {
//		this.uomCategoryList = uomCategoryList;
//	}
	public List<PurchaseRequestDtlBean> getPurchaseRequestDtlBean() {
		return purchaseRequestDtlBean;
	}

	public void setPurchaseRequestDtlBean(List<PurchaseRequestDtlBean> purchaseRequestDtlBean) {
		this.purchaseRequestDtlBean = purchaseRequestDtlBean;
	}
	public PurchaseRequestBean getPurchaseRequestBean() {
		return purchaseRequestBean;
	}

	public void setPurchaseRequestBean(PurchaseRequestBean purchaseRequestBean) {
		this.purchaseRequestBean = purchaseRequestBean;
	}

}
