package com.bitutech.salesquote;

import java.util.List;

import com.bitutech.salesorder.SalesOrderBean;

public interface SalesQuoteService {

	SalesQuoteResultBean save(SalesQuoteBean bean) throws Exception;
	
	SalesQuoteResultBean edit(String token) throws Exception;
	
	SalesQuoteResultBean update(SalesQuoteBean bean) throws Exception;
	
	SalesQuoteResultBean delete(String bean) throws Exception;

	public List<SalesQuoteBean> getSalesQuoteList() throws Exception;

	List<SalesOrderBean> getSalesOrderListService() throws Exception;

//	public List<SalesQuoteBean> getUomcateList() throws Exception;

}