package com.bitutech.mainDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainDashboardServiceImpl implements MainDashboardService {
	@Autowired
	MainDashboardDao mainDashboardDao;
	


	@Override
	public MainDashboardResultBean getCustomerCount() throws Exception  {
		// TODO Auto-generated method stub
		return mainDashboardDao.getCustomerCount();
	}



	
	

}
