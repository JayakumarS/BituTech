package com.bitutech.countrymaster;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CountryMasterServiceImpl implements CountryMasterService {
	
	CountryMasterDao customerMasterDao;

	@Override
	public CountryMasterBean save(CountryMasterBean bean) throws Exception {
		return customerMasterDao.save(bean);
	}

	@Override
	public List<CountryMasterBean> getCustomerList() throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.getCustomerList();
	}

	


	
}