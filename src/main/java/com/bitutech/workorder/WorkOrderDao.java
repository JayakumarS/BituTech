package com.bitutech.workorder;

import java.util.List;

import com.bitutech.core.util.DropDownList;
import com.bitutech.salesorder.SalesOrderResultBean;

public interface WorkOrderDao {

	WorkOrderResultBean save(WorkOrderHdrObjBean bean) throws Exception;

	List<WorkOrderHdrObjBean> getWorkOrderList() throws Exception;
	
//	WorkOrderResultBean getWorkOrderNumber() throws Exception;
	
	WorkOrderResultBean getSalesOrderNoList() throws Exception;
	
	WorkOrderResultBean getUomList() throws Exception;
	
	WorkOrderResultBean getItemList() throws Exception;
	
	WorkOrderResultBean edit(String bean) throws Exception;

	WorkOrderResultBean update(WorkOrderHdrObjBean bean) throws Exception;

	WorkOrderResultBean delete(String bean) throws Exception;

	WorkOrderResultBean getFetchCustomerWorkOrder(String customer) throws Exception;

}
