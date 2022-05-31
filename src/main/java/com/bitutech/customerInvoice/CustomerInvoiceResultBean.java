package com.bitutech.customerInvoice;

import java.io.Serializable;
import java.util.List;

import com.bitutech.common.Selectivity;
import com.bitutech.core.util.BasicResultBean;

public class CustomerInvoiceResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<CustomerInvoiceBean> lCustomerInvoiceBean;
	private  CustomerInvoiceBean customerInvoiceBean;
	private List<Selectivity> CustList;
	private List<Selectivity> currencyList;
	private String invoiceNo;
	private List<CustomerInvoiceDetailBean> customerInvoiceDetailBean;
	
	public List<Selectivity> getCurrencyList() {
		return currencyList;
	}

	public List<CustomerInvoiceDetailBean> getCustomerInvoiceDetailBean() {
		return customerInvoiceDetailBean;
	}

	public void setCustomerInvoiceDetailBean(List<CustomerInvoiceDetailBean> customerInvoiceDetailBean) {
		this.customerInvoiceDetailBean = customerInvoiceDetailBean;
	}

	public void setCurrencyList(List<Selectivity> currencyList) {
		this.currencyList = currencyList;
	}
	

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public boolean isSuccess() {
		return Success;
	}

	public CustomerInvoiceBean getCustomerInvoiceBean() {
		return customerInvoiceBean;
	}

	public void setCustomerInvoiceBean(CustomerInvoiceBean customerInvoiceBean) {
		this.customerInvoiceBean = customerInvoiceBean;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<CustomerInvoiceBean> getlCustomerInvoiceBean() {
		return lCustomerInvoiceBean;
	}

	public void setlCustomerInvoiceBean(List<CustomerInvoiceBean> lCustomerInvoiceBean) {
		this.lCustomerInvoiceBean = lCustomerInvoiceBean;
	}

	public List<Selectivity> getCustList() {
		return CustList;
	}

	public void setCustList(List<Selectivity> custList) {
		CustList = custList;
	}
 
	
	
}
