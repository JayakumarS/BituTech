package com.bitutech.purchaseInvoice;

import java.util.List;

public interface PurchaseInvoiceService {

	PurchaseInvoiceResultBean save(PurchaseInvoiceBean bean) throws Exception;

	List<PurchaseInvoiceBean> getPurchaseInvoiceList() throws Exception;

	PurchaseInvoiceResultBean edit(String purchase) throws Exception;

	PurchaseInvoiceResultBean update(PurchaseInvoiceBean bean) throws Exception;

	PurchaseInvoiceResultBean delete(String purchase) throws Exception;



}
