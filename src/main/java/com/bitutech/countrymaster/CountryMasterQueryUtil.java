package com.bitutech.countrymaster;

public class CountryMasterQueryUtil {

	public static final String INSERT_COUNTRY_MASTER = "INSERT into country (country_code,country_name,currency_code,country_two_code,is_active,created_by,created_dt) "
			+ "values (:countryCode,:countryName,:currency,:clientType,:isActive,'E0001',now())";
	public static final String getCountryList = "select country_code as countryCode,country_name as countryName,currency_code as currency,country_two_code as clientType,is_active as isActive from country";
	public static final String getCurrencyList = "select currency_code as id,currency_name as text from currency";
	
	public static final String UPDATE_COUNTRY_MASTER ="update country set country_code=:countryCode,country_name=:countryName,currency_code=:currency,country_two_code=:clientType,is_active=:isActive where country_code=:countryCode ";
	public static final String SELECT_COUNTRY_MASTER = "select  country_code as countryCode,country_name as countryName,currency_code as currency,country_two_code as clientType,is_active as isActive from country where country_code = ? ";
	public static final String DELETE_COUNTRY =" Delete from country where country_code = ?";
	//public static final String SELECT_COUNTRY_MASTER = "select country_code as countryCode, country_name as countryName,currency_code as currency,is_active as isActive from country where country_code=?";

}
