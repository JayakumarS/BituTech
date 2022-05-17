package com.bitutech.salesquote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth/app/saleQuote")
public class SalesQuoteController {
	@Autowired
	SalesQuoteService salesQuoteService;
	
	@RequestMapping(value="/save")
	public SalesQuoteResultBean save(@RequestBody SalesQuoteBean bean) {
		SalesQuoteResultBean objbean = new SalesQuoteResultBean();
		try {
			objbean = salesQuoteService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public SalesQuoteResultBean getSalesQuoteList() throws Exception {
		SalesQuoteResultBean objResultBean = new SalesQuoteResultBean();
		objResultBean.setSalesQuoteDetails(salesQuoteService.getSalesQuoteList());
		objResultBean.setSuccess(true);
   		return objResultBean;
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
	public SalesQuoteResultBean edit(@RequestParam("salesQuote") String salesQuote) {
		
//		Integer value= Integer.parseInt(salesQuote);
		
		SalesQuoteResultBean objResultBean = new SalesQuoteResultBean();
		try {
			objResultBean = salesQuoteService.edit(salesQuote);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/update")
	public SalesQuoteResultBean update(@RequestBody SalesQuoteBean bean) {
		SalesQuoteResultBean objResultBean = new SalesQuoteResultBean();
		try {
			objResultBean = salesQuoteService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;

	
	}
	@RequestMapping(value = "/delete")
	public SalesQuoteResultBean delete(@RequestParam("salesQuote") String salesQuote) {
		SalesQuoteResultBean objResultBean = new SalesQuoteResultBean();
		try {
			objResultBean = salesQuoteService.delete(salesQuote);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
}
