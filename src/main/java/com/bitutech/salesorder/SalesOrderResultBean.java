package com.bitutech.salesorder;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;
import com.bitutech.workorder.WorkOrderDtlBean;
import com.bitutech.workorder.WorkOrderHdrObjBean;

public class SalesOrderResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<SalesOrderBean> salesOrderDetails;
    private List<SalesOrderBean> itemList;
    private List<SalesOrderBean> customerList;
	
	private List<SalesOrderdtlBean> salesOrderdtlBean;
	
  
	 public List<SalesOrderBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<SalesOrderBean> customerList) {
		this.customerList = customerList;
	}

	public List<SalesOrderdtlBean> getSalesOrderdtlBean() {
		return salesOrderdtlBean;
	}

	public void setSalesOrderdtlBean(List<SalesOrderdtlBean> salesOrderdtlBean) {
		this.salesOrderdtlBean = salesOrderdtlBean;
	}

	public List<SalesOrderBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<SalesOrderBean> itemList) {
		this.itemList = itemList;
	}

	private SalesOrderBean salesOrderBean;
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<SalesOrderBean> getSalesOrderDetails() {
		return salesOrderDetails;
	}

	public void setSalesOrderDetails(List<SalesOrderBean> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

//	public List<SalesOrderBean> getSalesOrderList() {
//		return salesOrderList;
//	}
//
//	public void setSalesOrderList(List<SalesOrderBean> salesOrderList) {
//		this.salesOrderList = salesOrderList;
//	}

	public SalesOrderBean getSalesOrderBean() {
		return salesOrderBean;
	}

	public void setSalesOrderBean(SalesOrderBean salesOrderBean) {
		this.salesOrderBean = salesOrderBean;
	}


	

	


	
	
}
