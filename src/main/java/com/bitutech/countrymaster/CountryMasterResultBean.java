package com.bitutech.countrymaster;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;
 

public class CountryMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<CountryMasterBean> countryMasterDetails;

	private List<CountryMasterBean> currencyList;	
	private CountryMasterBean countryMasterBean;
	
	
	public CountryMasterBean getCountryMasterBean() {
		return countryMasterBean;
	}

	public void setCountryMasterBean(CountryMasterBean countryMasterBean) {
		this.countryMasterBean = countryMasterBean;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<CountryMasterBean> getCountryMasterDetails() {
		return countryMasterDetails;
	}

	public void setCountryMasterDetails(List<CountryMasterBean> countryMasterDetails) {
		this.countryMasterDetails = countryMasterDetails;
	}

	public List<CountryMasterBean> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<CountryMasterBean> currencyList) {
		this.currencyList = currencyList;
		
	}
	public void setCurrencyMasterDetails(List<CountryMasterBean> countryMasterDetails) {
		this.countryMasterDetails = countryMasterDetails;
	}

	

	
	

	

	
	
}
