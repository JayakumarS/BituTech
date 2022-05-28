package com.bitutech.purchase.LPO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LpoServiceImpl implements LpoService {
	@Autowired
	LpoDao lpoDao;

	@Override
	public LpoResultBean save(LpoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.save(bean);
	}
	@Override
	public LpoResultBean getPoNo() throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.getPoNo();
	}
	@Override
	public LpoResultBean getPoNoList() throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.getPoNoList();
	}

	@Override
	public LpoResultBean getVendorAddress(int vendorId) {
		// TODO Auto-generated method stub
		return lpoDao.getVendorAddress(vendorId);
	}
	@Override
	public LpoResultBean getRequisition(String requisitionNo) {
		// TODO Auto-generated method stub
		return lpoDao.getRequisition(requisitionNo);
	}

	@Override
	public List<LpoBean> getAllList() throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.getAllList();
	}

	@Override
	public LpoResultBean edit(Integer purchaseOrderId) throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.edit(purchaseOrderId);
	}

	@Override
	public LpoResultBean update(LpoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.update(bean);
	}

	@Override
	public LpoResultBean delete(Integer purchaseOrderId) throws Exception {
		// TODO Auto-generated method stub
		return lpoDao.delete(purchaseOrderId);
	}

}
