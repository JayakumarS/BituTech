package com.bitutech.purchaseInvoice;

import java.util.List;

public interface PurchaseInvoiceDao {

	PurchaseInvoiceResultBean save(PurchaseInvoiceBean bean) throws Exception;

	List<PurchaseInvoiceBean> getPurchaseInvoiceList() throws Exception;

	PurchaseInvoiceResultBean edit(String bean) throws Exception;

	PurchaseInvoiceResultBean update(PurchaseInvoiceBean bean) throws Exception;

	PurchaseInvoiceResultBean delete(String bean) throws Exception;

}
