package com.bitutech.mainDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth/app/mainDashboard")
public class MainDashboardController {
	@Autowired
	private MainDashboardService mainDashboardService;
	
	@RequestMapping("/getCustomerCount")
	public  @ResponseBody MainDashboardResultBean getCustomerCount()  throws Exception {
		MainDashboardResultBean customerCount = new MainDashboardResultBean();
    // try {
    	 customerCount = mainDashboardService.getCustomerCount();
//     }catch(Exception e) {
//	  throw new CustomException();
//     }
		return customerCount;
	}

}
