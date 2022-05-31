package com.bitutech.customerInvoice;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitutech.common.Selectivity;

@Service
public class CustomerInvoiceServiceImpl implements CustomerInvoiceService {
	@Autowired
	CustomerInvoiceDao customerInvoiceDao;

	@Override
	public CustomerInvoiceResultBean save(CustomerInvoiceBean bean) throws Exception {
		return customerInvoiceDao.save(bean);
	}

	@Override
	public List<CustomerInvoiceBean> getCustomerInvoiceList() throws Exception {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getCustomerInvoiceList();
	}

//	@Override
//	public List<SalesQuoteBean> getUomcateList() throws Exception {
//		// TODO Auto-generated method stub
//		return uomDao.getUomcateList();
//	}
	
	@Override
	public CustomerInvoiceResultBean edit(String token) throws Exception {
		// TODO Auto-generated method stub
		return  customerInvoiceDao.edit(token);
	}

	@Override
	public CustomerInvoiceResultBean update( CustomerInvoiceBean bean) throws Exception {
		// TODO Auto-generated method stub
		return customerInvoiceDao.update(bean);
	}
	
	@Override
	public CustomerInvoiceResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return customerInvoiceDao.delete(bean);
	}

	@Override
	public List<Selectivity> getCustomer() {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getCustomer();
	}

	@Override
	public List<Selectivity> getCurrencyList() {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getCurrencyList();
	}

	@Override
	public CustomerInvoiceResultBean getInvoiceNo() {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getInvoiceNo();
	}

	@Override
	public List<Selectivity> getSalesOrderDtl() {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getSalesOrderDtl();
	}

	@Override
	public CustomerInvoiceResultBean getItemDtls(String salesOrderNo) {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getItemDtls(salesOrderNo);
	}

	@Override
	public List<Selectivity> getItemDropDown() {
		// TODO Auto-generated method stub
		return customerInvoiceDao.getItemDropDown();
	}


	


	
}