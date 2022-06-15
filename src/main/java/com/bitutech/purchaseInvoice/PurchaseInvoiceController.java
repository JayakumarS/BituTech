package com.bitutech.purchaseInvoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/purchaseInvoice")
public class PurchaseInvoiceController {
	@Autowired
	PurchaseInvoiceService purchaseInvoiceService;

	
	@RequestMapping(value="/save")
	public PurchaseInvoiceResultBean save(@RequestBody PurchaseInvoiceBean bean) {
		PurchaseInvoiceResultBean objbean = new PurchaseInvoiceResultBean();
		try {
			objbean = purchaseInvoiceService.save(bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public PurchaseInvoiceResultBean getPurchaseInvoiceList() throws Exception {
		PurchaseInvoiceResultBean objResultBean = new PurchaseInvoiceResultBean();
		objResultBean.setPurchaseInvoiceDetails(purchaseInvoiceService.getPurchaseInvoiceList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@GetMapping(value="/edit")
	public PurchaseInvoiceResultBean edit(@RequestParam("purchase") String purchase) {
		PurchaseInvoiceResultBean objResultBean = new PurchaseInvoiceResultBean();
		try {
			objResultBean = purchaseInvoiceService.edit(purchase);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/update")
	public PurchaseInvoiceResultBean update(@RequestBody PurchaseInvoiceBean bean) {
		PurchaseInvoiceResultBean objResultBean = new PurchaseInvoiceResultBean();
		try {
			objResultBean = purchaseInvoiceService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@GetMapping(value="/delete")
	public PurchaseInvoiceResultBean delete(@RequestParam("purchase") String purchase) {
		PurchaseInvoiceResultBean objResultBean = new PurchaseInvoiceResultBean();
		try {
			objResultBean = purchaseInvoiceService.delete(purchase);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
}
