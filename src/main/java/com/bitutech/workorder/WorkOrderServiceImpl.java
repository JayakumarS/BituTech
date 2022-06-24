package com.bitutech.workorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitutech.core.util.DropDownList;
import com.bitutech.salesorder.SalesOrderResultBean;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
	@Autowired
	WorkOrderDao workOrderDao;

	@Override
	public WorkOrderResultBean save(WorkOrderHdrObjBean bean) throws Exception {
		return workOrderDao.save(bean);
	}

	@Override
	public List<WorkOrderHdrObjBean> getWorkOrderList() throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.getWorkOrderList();
	}

//	@Override
//	public WorkOrderResultBean getWorkOrderNumber() throws Exception {
//		// TODO Auto-generated method stub
//		return workOrderDao.getWorkOrderNumber();
//	}

	@Override
	public WorkOrderResultBean getSalesOrderNoList() throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.getSalesOrderNoList();
	}

	@Override
	public WorkOrderResultBean getUomList() throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.getUomList();
	}

	@Override
	public WorkOrderResultBean getItemList() throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.getItemList();
	}

	@Override
	public WorkOrderResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.edit(bean);
	}

	@Override
	public WorkOrderResultBean update(WorkOrderHdrObjBean bean) throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.update(bean);
	}

	@Override
	public WorkOrderResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.delete(bean);
	}
	
	@Override
	public WorkOrderResultBean getFetchCustomerWorkOrder(String customer) throws Exception {
		// TODO Auto-generated method stub
		return workOrderDao.getFetchCustomerWorkOrder(customer);
	}


	


	
}
