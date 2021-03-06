package com.bitutech.countrymaster;

import java.util.List;



public interface CountryMasterService {

	CountryMasterResultBean save(CountryMasterBean bean) throws Exception;

	public List<CountryMasterBean> getCountryList() throws Exception;

	public List<CountryMasterBean> getCurrencyList() throws Exception;
	CountryMasterResultBean edit(String countryCode) throws Exception;

	CountryMasterResultBean update(CountryMasterBean countryCode) throws Exception;

	public CountryMasterResultBean deleteCountryDtl(String countryCode) throws Exception;

	CountryMasterResultBean getCode(String countryMaster) throws Exception;

}