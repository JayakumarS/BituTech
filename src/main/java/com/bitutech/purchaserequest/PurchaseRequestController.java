package com.bitutech.purchaserequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/app/purchaseRequest")
public class PurchaseRequestController {
	@Autowired
	PurchaseRequestService purchaseRequestService;
	
	@RequestMapping(value="/save")
	public PurchaseRequestResultBean save(@RequestBody PurchaseRequestBean bean) {
		PurchaseRequestResultBean objbean = new PurchaseRequestResultBean();
		try {
			objbean = purchaseRequestService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public PurchaseRequestResultBean getPurchaseRequestList() throws Exception {
		PurchaseRequestResultBean objResultBean = new PurchaseRequestResultBean();
		objResultBean.setPurchaseRequestDetails(purchaseRequestService.getPurchaseRequestList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}

//	@RequestMapping(value = "/getRequisitionNo")
//	public PurchaseRequestResultBean getRequisitionNo() throws Exception{
//		PurchaseRequestResultBean objResultBean = new PurchaseRequestResultBean();
//		objResultBean = purchaseRequestService.getRequisitionNo();
//		objResultBean.setSuccess(true);
//		return objResultBean;
//	}
	
//	@RequestMapping(value = "/getRequisitionNoList")
//	public PurchaseRequestResultBean getRequisitionNoList() throws Exception {
//		return purchaseRequestService.getRequisitionNoList();
//	}
	//@RequestMapping(value = "/getUomCategory")
 // 	public PurchaseRequestResultBean getUomcateList() throws Exception {
//		PurchaseRequestResultBean objResultBean = new PurchaseRequestResultBean();
//		objResultBean.setUomCategoryList(purchaseRequestService.getUomcategoryList());
//		objResultBean.setSuccess(true);
//   		return objResultBean;
//   	}
	
	@GetMapping(value="/edit")
	public PurchaseRequestResultBean edit(@RequestParam("purchaseRequest") String purchaseRequest) {
		
		Integer value= Integer.parseInt(purchaseRequest);
		
		PurchaseRequestResultBean objResultBean = new PurchaseRequestResultBean();
		try {
			objResultBean = purchaseRequestService.edit(value);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/update")
	public PurchaseRequestResultBean update(@RequestBody PurchaseRequestBean bean) {
		PurchaseRequestResultBean objResultBean = new PurchaseRequestResultBean();
		try {
			objResultBean = purchaseRequestService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;

	
	}
	
	@RequestMapping(value = "/delete")
	public PurchaseRequestResultBean delete(@RequestParam("purchaseRequest") Integer purchaseRequest) {
		PurchaseRequestResultBean objResultBean = new PurchaseRequestResultBean();
		try {
			objResultBean = purchaseRequestService.delete(purchaseRequest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
}
