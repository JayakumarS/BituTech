package com.bitutech.salesorder;

import java.util.List;

import com.bitutech.salesquote.SalesQuoteResultBean;



public interface SalesOrderDao {

	SalesOrderResultBean save(SalesOrderBean bean) throws Exception;
	
	SalesOrderResultBean edit(String token) throws Exception;
	
	SalesOrderResultBean update(SalesOrderBean bean) throws Exception;
	
	SalesOrderResultBean delete(String bean) throws Exception;

	List<SalesOrderBean> getSalesOrderList() throws Exception;

	List<SalesOrderBean> getItemNameList() throws Exception;

	List<SalesOrderBean> getCustomerList() throws Exception;

	List<SalesOrderBean> getSalesOrderListService() throws Exception;

	SalesOrderResultBean getfetchSalesQuote(String bean) throws Exception;

}
