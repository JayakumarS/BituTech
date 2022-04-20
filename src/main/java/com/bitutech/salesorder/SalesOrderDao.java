package com.bitutech.salesorder;

import java.util.List;



public interface SalesOrderDao {

	SalesOrderResultBean save(SalesOrderBean bean) throws Exception;
	
	SalesOrderResultBean edit(String token) throws Exception;
	
	SalesOrderResultBean update(SalesOrderBean bean) throws Exception;
	
	SalesOrderResultBean delete(String bean) throws Exception;

	List<SalesOrderBean> getSalesOrderList() throws Exception;

//	List<SalesOrderBean> getUomcateList() throws Exception;

}
