package com.bitutech.customerInvoice;

import java.util.List;

import com.bitutech.common.Selectivity;

public interface CustomerInvoiceService {

	CustomerInvoiceResultBean save(CustomerInvoiceBean bean) throws Exception;
	
	CustomerInvoiceResultBean edit(String token) throws Exception;
	
	CustomerInvoiceResultBean update(CustomerInvoiceBean bean) throws Exception;
	
	CustomerInvoiceResultBean delete(String bean) throws Exception;

	public List<CustomerInvoiceBean> getCustomerInvoiceList() throws Exception;

	List<Selectivity> getCustomer();

	List<Selectivity> getCurrencyList();

	CustomerInvoiceResultBean getInvoiceNo();

	List<Selectivity> getSalesOrderDtl();

	CustomerInvoiceResultBean getItemDtls(String salesOrderNo);

	List<Selectivity> getItemDropDown();

//	public List<SalesQuoteBean> getUomcateList() throws Exception;

}
