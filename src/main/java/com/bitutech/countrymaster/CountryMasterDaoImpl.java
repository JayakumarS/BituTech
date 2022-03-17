package com.bitutech.countrymaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CountryMasterDaoImpl implements CountryMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public CountryMasterBean save(CountryMasterBean bean) throws Exception {
		CountryMasterBean customerMasterBean = new CountryMasterBean();
		try {
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
		    customerMasterMap.put("country", customerMasterBean.getCountry());
		    customerMasterMap.put("city", customerMasterBean.getCity());
		    customerMasterMap.put("territory", customerMasterBean.getTerritory());
		    customerMasterMap.put("salesPerson", customerMasterBean.getSalesPerson());
		    customerMasterMap.put("addressOfCus", customerMasterBean.getAddressOfCus());
		    customerMasterMap.put("business", customerMasterBean.getBusiness());
		    customerMasterMap.put("stp", customerMasterBean.getStp());
		    customerMasterMap.put("organisationName", customerMasterBean.getOrganisationName());
		    customerMasterMap.put("zipCode", customerMasterBean.getZipCode());
		    customerMasterMap.put("shortName", customerMasterBean.getShortName());
		    customerMasterMap.put("cusWebsite", customerMasterBean.getCusWebsite());
		    customerMasterMap.put("companyRegn", customerMasterBean.getCompanyRegn());
		    customerMasterMap.put("keyName", customerMasterBean.getKeyName());
		    
		    customerMasterMap.put("keyNumber", customerMasterBean.getKeyNumber());
		    customerMasterMap.put("transactionGST", customerMasterBean.getTransactionGST());
		    customerMasterMap.put("vatNumber", customerMasterBean.getVatNumber());
		    customerMasterMap.put("panNumber", customerMasterBean.getPanNumber());
		    
		    customerMasterMap.put("paymentCenter", customerMasterBean.getPaymentCenter());
		    customerMasterMap.put("creditLimit", customerMasterBean.getCreditLimit());
		    customerMasterMap.put("creditUsd", customerMasterBean.getCreditUsd());
		    customerMasterMap.put("creditDays", customerMasterBean.getCreditDays());
		    customerMasterMap.put("keymail", customerMasterBean.getKeymail());
		    
		    customerMasterMap.put("notificationMail", customerMasterBean.getNotificationMail());
		    customerMasterMap.put("invoiceMail", customerMasterBean.getInvoiceMail());
		    customerMasterMap.put("creditAgreement", customerMasterBean.getCreditAgreement());
		    customerMasterMap.put("kycDoc", customerMasterBean.getKycDoc());
		    customerMasterMap.put("exemptionDoc", customerMasterBean.getExemptionDoc());
		    customerMasterMap.put("nonGstDoc", customerMasterBean.getNonGstDoc());
		    customerMasterMap.put("name", customerMasterBean.getName());
		    customerMasterMap.put("designation", customerMasterBean.getDesignation());
		    customerMasterMap.put("department", customerMasterBean.getDepartment());
		    
		    customerMasterMap.put("phoneno", customerMasterBean.getPhoneno());
		    customerMasterMap.put("landline", customerMasterBean.getLandline());
		    customerMasterMap.put("email", customerMasterBean.getEmail());
		    
		   jdbcTemplate.update(CountryMasterQueryUtil.INSERT_CUSTOMER_MASTER,customerMasterMap);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return customerMasterBean;
	}

	@Override
	public List<CountryMasterBean> getCustomerList() throws Exception {
		List<CountryMasterBean> objCustomerMasterBean = new ArrayList<CountryMasterBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(CountryMasterQueryUtil.getCustomerList, new BeanPropertyRowMapper<CountryMasterBean>(CountryMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}


}
