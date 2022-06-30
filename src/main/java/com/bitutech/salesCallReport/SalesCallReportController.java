package com.bitutech.salesCallReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.salescallentry.SalesCallEntryBean;
import com.bitutech.salescallentry.SalesCallEntryResultBean;
import com.bitutech.salesorder.SalesOrderResultBean;


@RestController
@RequestMapping(value = "/api/auth/app/salesCallReport")
public class SalesCallReportController {
	@Autowired
	SalesCallReportService salesCallReportService;
	
	@RequestMapping(value = "/getList")
	public SalesCallReportResultBean save(@RequestBody SalesCallReportBean bean) {
		SalesCallReportResultBean objbean = new SalesCallReportResultBean();
		try {
			objbean = salesCallReportService.save(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return objbean;
		
	}
	
	//customer down method
			@RequestMapping(value = "/getsalesPersonList")
		   	public SalesCallReportResultBean getsalesPersonList() throws Exception {
				SalesCallReportResultBean objResultBean = new SalesCallReportResultBean();
				objResultBean.setSalesPersonDetails(salesCallReportService.getsalesPersonList());
				objResultBean.setSuccess(true);
		   		return objResultBean;
		   	}
	
//	@RequestMapping(value = "/getList")
//   	public SalesCallReportResultBean getList() throws Exception {
//		SalesCallReportResultBean objResultBean = new SalesCallReportResultBean();
//		objResultBean.setSalesCallReportDetails(salesCallReportService.getList());
//		objResultBean.setSuccess(true);
//   		return objResultBean;
//   	}
}
