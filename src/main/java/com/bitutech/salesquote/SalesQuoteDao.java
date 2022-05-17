package com.bitutech.salesquote;

import java.util.List;



public interface SalesQuoteDao {

	SalesQuoteResultBean save(SalesQuoteBean bean) throws Exception;
	
	SalesQuoteResultBean edit(String token) throws Exception;
	
	SalesQuoteResultBean update(SalesQuoteBean bean) throws Exception;
	
	SalesQuoteResultBean delete(String bean) throws Exception;


	List<SalesQuoteBean> getSalesQuoteList() throws Exception;

//	List<SalesQuoteBean> getUomcateList() throws Exception;

}
