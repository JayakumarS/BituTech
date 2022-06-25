package com.bitutech.billofmaterial;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillOfMaterialServiceImpl implements BillOfMaterialService {
	@Autowired
	BillOfMaterialDao billOfMaterialDao;

	@Override
	public BillOfMaterialResultBean save(BillOfMaterialHdrObjBean bean) throws Exception {
		return billOfMaterialDao.save(bean);
	}

	@Override
	public BillOfMaterialResultBean getList() throws Exception {
		// TODO Auto-generated method stub
		return billOfMaterialDao.getList();
	}
	@Override
	public BillOfMaterialResultBean getWorkOrderList() throws Exception {
		// TODO Auto-generated method stub
		return billOfMaterialDao.getWorkOrderList();
	}

//	@Override
//	public BillOfMaterialResultBean getBomNumber() throws Exception {
//		// TODO Auto-generated method stub
//		return billOfMaterialDao.getBomNumber();
//	}

	@Override
	public BillOfMaterialResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return billOfMaterialDao.edit(bean);
	}

	@Override
	public BillOfMaterialResultBean update(BillOfMaterialHdrObjBean bean) throws Exception {
		// TODO Auto-generated method stub
		return billOfMaterialDao.update(bean);
	}

	@Override
	public BillOfMaterialResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return billOfMaterialDao.delete(bean);
	}

	@Override
	public BillOfMaterialResultBean getFetchCustomerBOM(String customer) throws Exception {
		// TODO Auto-generated method stub
		return billOfMaterialDao.getFetchCustomerBOM(customer);
	}

	


	
}
