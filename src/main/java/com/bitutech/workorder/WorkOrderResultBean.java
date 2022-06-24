package com.bitutech.workorder;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;
import com.bitutech.core.util.DropDownList;

public class WorkOrderResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<WorkOrderHdrObjBean> workOrderDetails;
	
	private List<WorkOrderHdrObjBean> salesQuoteNo;
	
	private List<WorkOrderDtlBean> WorkOrderDtlBean;
	
	private WorkOrderHdrObjBean workOrderHdrObjBean;
	
	private String workOrderNumber;
	
	private List<DropDownList> workOrderNoList;
	
	private List<DropDownList> uomList;
	
	private List<DropDownList> itemList;
	
	
	public List<DropDownList> getItemList() {
		return itemList;
	}

	public void setItemList(List<DropDownList> itemList) {
		this.itemList = itemList;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<WorkOrderHdrObjBean> getWorkOrderDetails() {
		return workOrderDetails;
	}

	public void setWorkOrderDetails(List<WorkOrderHdrObjBean> workOrderDetails) {
		this.workOrderDetails = workOrderDetails;
	}

	public List<DropDownList> getWorkOrderNoList() {
		return workOrderNoList;
	}

	public void setWorkOrderNoList(List<DropDownList> workOrderNoList) {
		this.workOrderNoList = workOrderNoList;
	}

	public List<DropDownList> getUomList() {
		return uomList;
	}

	public void setUomList(List<DropDownList> uomList) {
		this.uomList = uomList;
	}

	public WorkOrderHdrObjBean getWorkOrderHdrObjBean() {
		return workOrderHdrObjBean;
	}

	public void setWorkOrderHdrObjBean(WorkOrderHdrObjBean workOrderHdrObjBean) {
		this.workOrderHdrObjBean = workOrderHdrObjBean;
	}

	public List<WorkOrderDtlBean> getWorkOrderDtlBean() {
		return WorkOrderDtlBean;
	}

	public void setWorkOrderDtlBean(List<WorkOrderDtlBean> workOrderDtlBean) {
		WorkOrderDtlBean = workOrderDtlBean;
	}

	public List<WorkOrderHdrObjBean> getSalesQuoteNo() {
		return salesQuoteNo;
	}

	public void setSalesQuoteNo(List<WorkOrderHdrObjBean> salesQuoteNo) {
		this.salesQuoteNo = salesQuoteNo;
	}
	
}
