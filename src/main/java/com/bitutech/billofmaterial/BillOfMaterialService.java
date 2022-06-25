package com.bitutech.billofmaterial;


public interface BillOfMaterialService {

	BillOfMaterialResultBean save(BillOfMaterialHdrObjBean bean) throws Exception;

	BillOfMaterialResultBean getList() throws Exception;
	
	BillOfMaterialResultBean edit(String bean) throws Exception;
	
	BillOfMaterialResultBean update(BillOfMaterialHdrObjBean bean) throws Exception;
	
	BillOfMaterialResultBean delete(String bean) throws Exception;
	
	BillOfMaterialResultBean getWorkOrderList() throws Exception;

	BillOfMaterialResultBean getFetchCustomerBOM(String salesQuote) throws Exception;
	
//	BillOfMaterialResultBean getBomNumber() throws Exception;
	
	
}