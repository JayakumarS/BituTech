package com.bitutech.purchaserequest;

import java.util.List;

public interface PurchaseRequestDao {

	PurchaseRequestResultBean save(PurchaseRequestBean bean) throws Exception;
	
	PurchaseRequestResultBean edit(Integer bean) throws Exception;

	PurchaseRequestResultBean update(PurchaseRequestBean bean) throws Exception;

	PurchaseRequestResultBean delete(Integer bean) throws Exception;

	List<PurchaseRequestBean> getPurchaseRequestList() throws Exception;

//	PurchaseRequestResultBean getRequisitionNo() throws Exception;

	//PurchaseRequestResultBean getRequisitionNoList() throws Exception;

//	List<PurchaseRequestBean> getUomcateList() throws Exception;

	

}
