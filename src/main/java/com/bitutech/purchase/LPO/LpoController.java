package com.bitutech.purchase.LPO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.core.util.CustomException;

@RestController
@RequestMapping(value = "/api/auth/app/LPO")
public class LpoController {
	@Autowired
	LpoService lpoService;
	
	@RequestMapping(value = "/save")
	public LpoResultBean save(@RequestBody LpoBean bean) {
		LpoResultBean objbean = new LpoResultBean();
		try {
			objbean = lpoService.save(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return objbean;
		
	}
	@RequestMapping(value = "/getPoNo")
	public LpoResultBean getPoNo() throws Exception{
		LpoResultBean objResultBean = new LpoResultBean();
		objResultBean = lpoService.getPoNo();
		objResultBean.setSuccess(true);
		return objResultBean;
	}
	
	@RequestMapping(value = "/getPoNoList")
	public LpoResultBean getPoNoList() throws Exception {
		return lpoService.getPoNoList();
	}
	@RequestMapping("/getVendorAddress")
	public @ResponseBody LpoResultBean getVendorAddress(@RequestParam("vendorId") int vendorId) throws CustomException {
		LpoResultBean sVendor = new LpoResultBean();
		try {
			sVendor = lpoService.getVendorAddress(vendorId);
		} catch (Exception e) {
			//LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}
	//get Requisition 
	@RequestMapping("/getRequisition")
	public @ResponseBody LpoResultBean getRequisition(@RequestParam("requisitionNo") String requisitionNo) throws CustomException {
		LpoResultBean sVendor = new LpoResultBean();
		try {
			sVendor = lpoService.getRequisition(requisitionNo);
		} catch (Exception e) {
			// LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVendor;
	}
	@RequestMapping(value = "/getAllList")
   	public LpoResultBean getList() throws Exception {
		LpoResultBean objResultBean = new LpoResultBean();
		objResultBean.setLpoDetails(lpoService.getAllList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public LpoResultBean edit(@RequestParam("lop") Integer lop) {
		LpoResultBean objResultBean = new LpoResultBean();
		try {
			objResultBean = lpoService.edit(lop);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
		
	}
	
	@RequestMapping(value = "/update")
	public LpoResultBean update(@RequestBody LpoBean bean) {
		LpoResultBean objbean = new LpoResultBean();
		try {
			objbean = lpoService.update(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return objbean;
		
	}
	
	@RequestMapping(value = "/delete")
	public LpoResultBean delete(@RequestParam("LPO") Integer purchaseOrderId) {
		LpoResultBean objResultBean = new LpoResultBean();
		try {
			objResultBean = lpoService.delete(purchaseOrderId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
		
	}

	
}
