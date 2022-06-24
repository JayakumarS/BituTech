package com.bitutech.workorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.boo.BillOfOperationBean;
import com.bitutech.boo.BillOfOperationResultBean;
import com.bitutech.core.util.CustomException;
import com.bitutech.salesorder.SalesOrderResultBean;

@RestController
@RequestMapping("/api/auth/app/workOrder")
public class WorkOrderController {
	@Autowired
	WorkOrderService workOrderService;
	
	@RequestMapping(value="/save")
	public WorkOrderResultBean save(@RequestBody WorkOrderHdrObjBean bean) {
		WorkOrderResultBean objbean = new WorkOrderResultBean();
		try {
			objbean = workOrderService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public WorkOrderResultBean getWorkOrderList() throws Exception {
		WorkOrderResultBean objResultBean = new WorkOrderResultBean();
		objResultBean.setWorkOrderDetails(workOrderService.getWorkOrderList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}

	
//	@RequestMapping(value = "/getWorkOrderNumber")
//   	public WorkOrderResultBean getWorkOrderNumber() throws Exception {
//		WorkOrderResultBean objResultBean = new WorkOrderResultBean();
//		objResultBean = workOrderService.getWorkOrderNumber();
//		objResultBean.setSuccess(true);
//   		return objResultBean;
//   	}
	
	@RequestMapping(value = "/getSalesOrderNoList")
   	public WorkOrderResultBean getSalesOrderNoList() throws Exception {
   		return workOrderService.getSalesOrderNoList();
   	}
	
	@RequestMapping(value = "/getUomList")
   	public WorkOrderResultBean getUomList() throws Exception {
   		return workOrderService.getUomList();
   	}
	
	@RequestMapping(value = "/getItemList")
   	public WorkOrderResultBean getItemList() throws Exception {
   		return workOrderService.getItemList();
   	}
	
	@GetMapping(value="edit")
	public WorkOrderResultBean edit(@RequestParam("workOrder") String workOrder) {
		WorkOrderResultBean objResultBean = new WorkOrderResultBean();
		try {
			objResultBean = workOrderService.edit(workOrder);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/update")
	public WorkOrderResultBean update(@RequestBody WorkOrderHdrObjBean bean) {
		WorkOrderResultBean objResultBean = new WorkOrderResultBean();
		try {
			objResultBean = workOrderService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@GetMapping(value="delete")
	public WorkOrderResultBean delete(@RequestParam("workOrder") String workOrder) {
		WorkOrderResultBean objResultBean = new WorkOrderResultBean();
		try {
			objResultBean = workOrderService.delete(workOrder);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@GetMapping(value="/getFetchCustomerWorkOrder")
	public WorkOrderResultBean getFetchCustomerWorkOrder(@RequestParam("workOrder") String salesQuote) {
		
//		Integer value= Integer.parseInt(salesQuote);
		
		WorkOrderResultBean objResultBean = new WorkOrderResultBean();
		try {
			objResultBean = workOrderService.getFetchCustomerWorkOrder(salesQuote);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
}
