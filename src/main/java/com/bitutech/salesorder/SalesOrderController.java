package com.bitutech.salesorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/auth/app/saleOrder")
public class SalesOrderController {
	@Autowired
	SalesOrderService salesOrderService;
	
	@RequestMapping(value="/save")
	public SalesOrderResultBean save(@RequestBody SalesOrderBean bean) {
		SalesOrderResultBean objbean = new SalesOrderResultBean();
		try {
			objbean = salesOrderService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public SalesOrderResultBean getSalesOrderList() throws Exception {
		SalesOrderResultBean objResultBean = new SalesOrderResultBean();
		objResultBean.setSalesOrderDetails(salesOrderService.getSalesOrderList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}

	//drop down method
	@RequestMapping(value = "/itemNameList")
   	public SalesOrderResultBean getItemNameList() throws Exception {
		SalesOrderResultBean objResultBean = new SalesOrderResultBean();
		objResultBean.setItemList(salesOrderService.getItemNameList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	//customer down method
		@RequestMapping(value = "/getCustomerList")
	   	public SalesOrderResultBean getCustomerList() throws Exception {
			SalesOrderResultBean objResultBean = new SalesOrderResultBean();
			objResultBean.setCustomerList(salesOrderService.getCustomerList());
			objResultBean.setSuccess(true);
	   		return objResultBean;
	   	}
	
	@GetMapping(value="/edit")
	public SalesOrderResultBean edit(@RequestParam("salesOrder") String salesOrder) {
		
//		Integer value= Integer.parseInt(salesQuote);
		
		SalesOrderResultBean objResultBean = new SalesOrderResultBean();
		try {
			objResultBean = salesOrderService.edit(salesOrder);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/update")
	public SalesOrderResultBean update(@RequestBody SalesOrderBean bean) {
		SalesOrderResultBean objResultBean = new SalesOrderResultBean();
		try {
			objResultBean = salesOrderService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;

	
	}
	@RequestMapping(value = "/delete")
	public SalesOrderResultBean delete(@RequestParam("salesOrder") String salesOrder) {
		SalesOrderResultBean objResultBean = new SalesOrderResultBean();
		try {
			objResultBean = salesOrderService.delete(salesOrder);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
}
