package com.bitutech.currencyMaster;

public class CurrencyMasterQueryUtil {

	public static final String INSERT_CURRENCY_MASTER = "INSERT into currency (currency_code,currency_name,currency_conver_from,currency_conver_to,currency_fraction,currency_default,is_book_currency,is_actvie,created_by,created_dt) values (:currencyCode,:currencyName,:fromcurrency,:toCurrency,\n"
			+ ":fractionPart,:defaultValue,:bookCurrency,:isActive,'E0001',now())";
	public static final String getCurrencyList = "select currency_code as currencyCode,currency_name as currencyName from currency";
	public static final String UPDATE_CURRENCY_MASTER = " update currency set currency_name=:currencyName,currency_conver_from=:fromcurrency,currency_conver_to=:toCurrency,currency_fraction=:fractionPart,currency_default=:defaultValue,is_book_currency=:bookCurrency,is_actvie=:isActive where currency_code=:currencyCode ";
	public static final String SELECT_CURRENCY_MASTER  = "select currency_code as currencyCode,currency_name as currencyName,currency_conver_from as fromcurrency,currency_conver_to as toCurrency, currency_fraction as fractionPart,currency_default as defaultValue,is_book_currency as bookCurrency,is_actvie as isActive from currency where currency_code = ?";
	public static final String DELETE_CURRENCY_MASTER = "delete from currency where currency_code=?";
	

}
