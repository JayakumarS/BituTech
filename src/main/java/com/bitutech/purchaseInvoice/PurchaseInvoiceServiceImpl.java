package com.bitutech.purchaseInvoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService{
	@Autowired
	PurchaseInvoiceDao purchaseInvoiceDao;

	@Override
	public PurchaseInvoiceResultBean save(PurchaseInvoiceBean bean) throws Exception {
		// TODO Auto-generated method stub
		return purchaseInvoiceDao.save(bean);
	}

	@Override
	public List<PurchaseInvoiceBean> getPurchaseInvoiceList() throws Exception {
		// TODO Auto-generated method stub
		return purchaseInvoiceDao.getPurchaseInvoiceList();
	}

	@Override
	public PurchaseInvoiceResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return purchaseInvoiceDao.edit(bean);
	}

	@Override
	public PurchaseInvoiceResultBean update(PurchaseInvoiceBean bean) throws Exception {
		// TODO Auto-generated method stub
		return purchaseInvoiceDao.update(bean);
	}

	@Override
	public PurchaseInvoiceResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return purchaseInvoiceDao.delete(bean);
	}
	
	
}
