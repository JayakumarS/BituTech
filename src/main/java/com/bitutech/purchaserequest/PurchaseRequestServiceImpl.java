package com.bitutech.purchaserequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
	@Autowired
	PurchaseRequestDao purchaseRequestDao;
	
	@Override
	public PurchaseRequestResultBean save(PurchaseRequestBean bean) throws Exception {
		return purchaseRequestDao.save(bean);
	}
	
	@Override
	public List<PurchaseRequestBean> getPurchaseRequestList() throws Exception {
		// TODO Auto-generated method stub
				return purchaseRequestDao.getPurchaseRequestList();
				
			
	}
	@Override
	public PurchaseRequestResultBean getRequisitionNo() throws Exception {
		// TODO Auto-generated method stub
		return purchaseRequestDao.getRequisitionNo();
	}

//	@Override
//	public PurchaseRequestResultBean getRequisitionNoList() throws Exception {
//		// TODO Auto-generated method stub
//		return purchaseRequestDao.getRequisitionNoList();
//	}
	
//	@Override
//	public List<PurchaseRequestBean> getUomcategoryList() throws Exception {
//		// TODO Auto-generated method stub
//				return purchaseRequestDao.getPurchaseRequestList();
//	}
	
	@Override
	public PurchaseRequestResultBean edit(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return  purchaseRequestDao.edit(bean);
	}

	@Override
	public PurchaseRequestResultBean update( PurchaseRequestBean bean) throws Exception {
		// TODO Auto-generated method stub
		return purchaseRequestDao.update(bean);
	}

	@Override
	public PurchaseRequestResultBean delete(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return purchaseRequestDao.delete(bean);
	}


}
