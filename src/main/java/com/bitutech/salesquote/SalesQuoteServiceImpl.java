package com.bitutech.salesquote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SalesQuoteServiceImpl implements SalesQuoteService {
	@Autowired
	SalesQuoteDao salesQuoteDao;

	@Override
	public SalesQuoteResultBean save(SalesQuoteBean bean) throws Exception {
		return salesQuoteDao.save(bean);
	}

	@Override
	public List<SalesQuoteBean> getSalesQuoteList() throws Exception {
		// TODO Auto-generated method stub
		return salesQuoteDao.getSalesQuoteList();
	}

//	@Override
//	public List<SalesQuoteBean> getUomcateList() throws Exception {
//		// TODO Auto-generated method stub
//		return uomDao.getUomcateList();
//	}
	
	@Override
	public SalesQuoteResultBean edit(String token) throws Exception {
		// TODO Auto-generated method stub
		return  salesQuoteDao.edit(token);
	}

	@Override
	public SalesQuoteResultBean update( SalesQuoteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return salesQuoteDao.update(bean);
	}
	
	@Override
	public SalesQuoteResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return salesQuoteDao.delete(bean);
	}


	


	
}
