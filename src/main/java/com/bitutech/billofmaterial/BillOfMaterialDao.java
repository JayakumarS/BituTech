package com.bitutech.billofmaterial;


public interface BillOfMaterialDao {

	BillOfMaterialResultBean save(BillOfMaterialHdrObjBean bean) throws Exception;

	BillOfMaterialResultBean getList() throws Exception;
	
	BillOfMaterialResultBean edit(String bean) throws Exception;
	
	BillOfMaterialResultBean update(BillOfMaterialHdrObjBean bean)throws Exception;
	
	BillOfMaterialResultBean delete(String Bean) throws Exception;
	 
	BillOfMaterialResultBean getWorkOrderList() throws Exception;

	BillOfMaterialResultBean getFetchCustomerBOM(String customer) throws Exception;
	
//	BillOfMaterialResultBean getBomNumber() throws Exception;
	
}
