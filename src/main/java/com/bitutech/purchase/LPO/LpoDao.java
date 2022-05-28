package com.bitutech.purchase.LPO;

import java.util.List;

public interface LpoDao {

	LpoResultBean save(LpoBean bean) throws Exception;
	
	LpoResultBean edit(Integer purchaseOrderId) throws Exception;

	LpoResultBean update(LpoBean bean) throws Exception;

	LpoResultBean delete(Integer purchaseOrderId) throws Exception;

	List<LpoBean> getAllList() throws Exception;

	LpoResultBean getPoNo() throws Exception;

	LpoResultBean getPoNoList() throws Exception;
	
	LpoResultBean getVendorAddress(int vendorId);

	LpoResultBean getRequisition(String requisitionNo);
}
