package com.bitutech.customerInvoice;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.common.Selectivity;


@RestController
@RequestMapping("/api/auth/app/customerInvoice")
public class CustomerInvoiceController {
	@Autowired
	CustomerInvoiceService customerInvoiceService;
	
	@RequestMapping(value="/save")
	public CustomerInvoiceResultBean save(@RequestBody CustomerInvoiceBean bean) {
		CustomerInvoiceResultBean objbean = new CustomerInvoiceResultBean();
		try {
			objbean = customerInvoiceService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public CustomerInvoiceResultBean getSalesQuoteList() throws Exception {
		CustomerInvoiceResultBean objResultBean = new CustomerInvoiceResultBean();
		objResultBean.setlCustomerInvoiceBean(customerInvoiceService.getCustomerInvoiceList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/getCustomer")
   	public CustomerInvoiceResultBean getCustomer() throws Exception {
		CustomerInvoiceResultBean customerInvoiceResultBean = new CustomerInvoiceResultBean();
		List<Selectivity>  selectivityBean = new ArrayList<Selectivity>();
		selectivityBean= customerInvoiceService.getCustomer();
		customerInvoiceResultBean.setCustList(selectivityBean);
     return customerInvoiceResultBean;
   	}
	
	@RequestMapping(value = "/getCurrencyList")
   	public CustomerInvoiceResultBean getCurrencyList() throws Exception {
		CustomerInvoiceResultBean customerInvoiceResultBean = new CustomerInvoiceResultBean();
		List<Selectivity>  selectivityBean = new ArrayList<Selectivity>();
		selectivityBean= customerInvoiceService.getCurrencyList();
		customerInvoiceResultBean.setCurrencyList(selectivityBean);
     return customerInvoiceResultBean;
   	}
	
	//drop down method
//	@RequestMapping(value = "/getUomCategory")
//   	public SalesQuoteResultBean getUomcateList() throws Exception {
//		SalesQuoteResultBean objResultBean = new SalesQuoteResultBean();
//		objResultBean.setSalesQuoteList(salesQuoteService.getUomcateList());
//		objResultBean.setSuccess(true);
//   		return objResultBean;
//   	}
	
	@GetMapping(value="/edit")
	public CustomerInvoiceResultBean edit(@RequestParam("salesQuote") String salesQuote) {
		
//		Integer value= Integer.parseInt(salesQuote);
		
		CustomerInvoiceResultBean objResultBean = new CustomerInvoiceResultBean();
		try {
			objResultBean = customerInvoiceService.edit(salesQuote);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	@GetMapping(value="/getInvoiceSeqNo")
	public CustomerInvoiceResultBean getInvoiceNo() {
		
//		Integer value= Integer.parseInt(salesQuote);
		
		CustomerInvoiceResultBean objResultBean = new CustomerInvoiceResultBean();
		try {
			objResultBean = customerInvoiceService.getInvoiceNo();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	@GetMapping(value="/getSalesOrderList")
	public List<Selectivity> getSalesOrderDtl() {
 		
		List<Selectivity>  objResultBean = new ArrayList<Selectivity>();
		try {
			objResultBean = customerInvoiceService.getSalesOrderDtl();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	@GetMapping(value="/getItemList")
	public CustomerInvoiceResultBean getItemDtls(@RequestParam("SalesOrderNo") String SalesOrderNo) {
		
//		Integer value= Integer.parseInt(salesQuote);
		
		CustomerInvoiceResultBean objResultBean = new CustomerInvoiceResultBean();
		try {
			objResultBean = customerInvoiceService.getItemDtls(SalesOrderNo);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	@GetMapping(value="/getItemDropDown")
	public List<Selectivity> getItemDtls() {
 		
		List<Selectivity>  objResultBean = new ArrayList<Selectivity>();
		try {
			objResultBean = customerInvoiceService.getItemDropDown();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	
	@RequestMapping(value = "/update")
	public CustomerInvoiceResultBean update(@RequestBody CustomerInvoiceBean bean) {
		CustomerInvoiceResultBean objResultBean = new CustomerInvoiceResultBean();
		try {
			objResultBean = customerInvoiceService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;

	
	}
	@RequestMapping(value = "/delete")
	public CustomerInvoiceResultBean delete(@RequestParam("salesQuote") String salesQuote) {
		CustomerInvoiceResultBean objResultBean = new CustomerInvoiceResultBean();
		try {
			objResultBean = customerInvoiceService.delete(salesQuote);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
}
