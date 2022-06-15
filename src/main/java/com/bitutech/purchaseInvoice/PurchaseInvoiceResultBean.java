package com.bitutech.purchaseInvoice;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;

public class PurchaseInvoiceResultBean extends BasicResultBean implements Serializable {

private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<PurchaseInvoiceBean> purchaseInvoiceDetails;
	private List<PurchaseInvoiceDetailBean> purchaseInvoiceDetailBean;
	
	private PurchaseInvoiceBean purchaseInvoiceBean;
	
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public PurchaseInvoiceBean getPurchaseInvoiceBean() {
		return purchaseInvoiceBean;
	}

	public void setPurchaseInvoiceBean(PurchaseInvoiceBean purchaseInvoiceBean) {
		this.purchaseInvoiceBean = purchaseInvoiceBean;
	}

	public List<PurchaseInvoiceBean> getPurchaseInvoiceDetails() {
		return purchaseInvoiceDetails;
	}

	public void setPurchaseInvoiceDetails(List<PurchaseInvoiceBean> purchaseInvoiceDetails) {
		this.purchaseInvoiceDetails = purchaseInvoiceDetails;
	}

	public List<PurchaseInvoiceDetailBean> getPurchaseInvoiceDetailBean() {
		return purchaseInvoiceDetailBean;
	}

	public void setPurchaseInvoiceDetailBean(List<PurchaseInvoiceDetailBean> purchaseInvoiceDetailBean) {
		this.purchaseInvoiceDetailBean = purchaseInvoiceDetailBean;
	}


	

}
