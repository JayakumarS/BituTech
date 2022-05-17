package com.bitutech.salesorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitutech.salesquote.SalesQuoteBean;
import com.bitutech.salesquote.SalesQuoteResultBean;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {
	@Autowired
	SalesOrderDao salesOrderDao;

	@Override
	public SalesOrderResultBean save(SalesOrderBean bean) throws Exception {
		return salesOrderDao.save(bean);
	}

	@Override
	public List<SalesOrderBean> getSalesOrderList() throws Exception {
		// TODO Auto-generated method stub
		return salesOrderDao.getSalesOrderList();
	}

	@Override
	public List<SalesOrderBean> getItemNameList() throws Exception {
		// TODO Auto-generated method stub
		return salesOrderDao.getItemNameList();
	}
	@Override
	public SalesOrderResultBean edit(String token) throws Exception {
		// TODO Auto-generated method stub
		return  salesOrderDao.edit(token);
	}

	@Override
	public SalesOrderResultBean update( SalesOrderBean bean) throws Exception {
		// TODO Auto-generated method stub
		return salesOrderDao.update(bean);
	}
	
	@Override
	public SalesOrderResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return salesOrderDao.delete(bean);
	}

	@Override
	public List<SalesOrderBean> getCustomerList() throws Exception {
		// TODO Auto-generated method stub
		return salesOrderDao.getCustomerList();
	}


	


	
}
