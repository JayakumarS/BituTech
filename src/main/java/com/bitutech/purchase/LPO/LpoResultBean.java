package com.bitutech.purchase.LPO;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;
import com.bitutech.core.util.DropDownList;


public class LpoResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;

	public List<LpoBean> lpoDetails;
	private List<LpoDtlBeanOne> lpoDtlBeanOne;
	private List<LpoDetailBeanTwo> lpoDetailBeanTwo;
	private LpoBean lpoBean;
	private String poNo;
	private List<DropDownList> poNoList;
	private List<LpoBean> lVendorAddressDtl;
	private List<LpoDtlBeanOne> lRequisitionDtl;
	private List<LpoDtlBeanOne> lRequisitionList;
	
	public List<LpoDtlBeanOne> getlRequisitionList() {
		return lRequisitionList;
	}

	public void setlRequisitionList(List<LpoDtlBeanOne> lRequisitionList) {
		this.lRequisitionList = lRequisitionList;
	}

	public List<LpoBean> getlVendorAddressDtl() {
		return lVendorAddressDtl;
	}

	public List<LpoDtlBeanOne> getlRequisitionDtl() {
		return lRequisitionDtl;
	}

	public void setlRequisitionDtl(List<LpoDtlBeanOne> lRequisitionDtl) {
		this.lRequisitionDtl = lRequisitionDtl;
	}

	public void setlVendorAddressDtl(List<LpoBean> lVendorAddressDtl) {
		this.lVendorAddressDtl = lVendorAddressDtl;
	}

	public List<DropDownList> getPoNoList() {
		return poNoList;
	}

	public void setPoNoList(List<DropDownList> poNoList) {
		this.poNoList = poNoList;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public List<LpoBean> getLpoDetails() {
		return lpoDetails;
	}

	public void setLpoDetails(List<LpoBean> lpoDetails) {
		this.lpoDetails = lpoDetails;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public LpoBean getLpoBean() {
		return lpoBean;
	}

	public void setLpoBean(LpoBean lpoBean) {
		this.lpoBean = lpoBean;
	}

	public List<LpoDtlBeanOne> getLpoDtlBeanOne() {
		return lpoDtlBeanOne;
	}

	public List<LpoDetailBeanTwo> getLpoDetailBeanTwo() {
		return lpoDetailBeanTwo;
	}

	public void setLpoDtlBeanOne(List<LpoDtlBeanOne> lpoDtlBeanOne) {
		this.lpoDtlBeanOne = lpoDtlBeanOne;
	}

	public void setLpoDetailBeanTwo(List<LpoDetailBeanTwo> lpoDetailBeanTwo) {
		this.lpoDetailBeanTwo = lpoDetailBeanTwo;
	}

	
	

}
