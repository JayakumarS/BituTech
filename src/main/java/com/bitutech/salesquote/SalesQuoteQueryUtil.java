package com.bitutech.salesquote;

public class SalesQuoteQueryUtil {
	
//	public static final String SELECT_SALES_COUNT = "select count(*) from sales_quote_hdr";
	public static final String INSERT_SALES_QUOTE_HDR = "INSERT into sales_quote_hdr (customer_code,valid_from,valid_till,terms_n_conditions,currency,exp_date_of_delivery,created_by,created_dt,sales_quote_no,modified_by,total) "
			+ " values(:customer,to_date(:validFrom,'YYYY-MM-DD'),to_date(:validTo,'YYYY-MM-DD'),:termCondition,:currency,to_date(:expectedDate,'YYYY-MM-DD'),'E0001',now(),:countValue,:modifiedBy,:total) RETURNING sales_quote_no as countValue";
	public static final String GETCOUNT = "select * From fn_generate_reference_no('sales_quote_hdr', 'sales_quote_no', 'S', '4')";
	public static final String getSalesQuoteList = "select sales_quote_no as salesQuoteNo, c.customer_name as customer,to_char(valid_from,'DD-MM-YYYY') as validFrom,\n"
			+ "to_char(valid_till,'DD-MM-YYYY') as validTo,terms_n_conditions as termCondition,s.currency as currency,to_char(exp_date_of_delivery,'DD-MM-YYYY') as expectedDate,\n"
			+ "sales_quote_no as countValue from sales_quote_hdr s\n"
			+ "inner join customer c on c.customer_code = s.customer_code";
//	public static final String getUomcategoryList = "select uomcategory_code as id,uomcategory_name as text from uom_category";
	public static final String SELECT_SALES_QUOTE_HDR = "select customer_code as customer,to_char(valid_from,'YYYY-MM-DD') as validFrom,to_char(valid_till,'YYYY-MM-DD') as validTo,terms_n_conditions as termCondition,currency as currency, to_char(exp_date_of_delivery,'YYYY-MM-DD') as expectedDate,total as total from sales_quote_hdr where sales_quote_no=?";
	public static final String UPDATE_SALES_QUOTE_HDR = "update sales_quote_hdr set customer_code=?,valid_from=to_date(?,'YYYY-MM-DD'),valid_till=to_date(?,'YYYY-MM-DD'),terms_n_conditions=?,currency=?,exp_date_of_delivery=to_date(?,'YYYY-MM-DD'),total=? where sales_quote_no=? Returning sales_quote_no as countValue";
	public static final String DELETE_SALES_QUOTE_HDR = "delete from sales_quote_hdr where sales_quote_no = ?";
	public static final String INSERT_SALES_QUOTE_DTL = "INSERT into sales_quote_dtl(sales_quote_no,item_id,uom_id,qty,quot_price,created_by,created_dt,rate)" + " values(:countValue,:item,:uomId,:qty,:price,'E0001',now(),:rate)";
	public static final String SELECT_SALES_QUOTE_DTL = "select sales_quote_no as countValue,item_id as item,uom_id as uomId,qty as qty,quot_price as price,rate as rate from sales_quote_dtl where sales_quote_no=?";
	public static final String DELETE_SALES_ORDER_HDR = "delete from sales_order_hdr where sales_quote_no=?";
	public static final String DELETE_SALES_QUOTE_DTL = "delete from sales_quote_dtl where sales_quote_no=?";
	public static final String GET_SALES_ORDER_LIST = "select customer_code as id ,sales_quote_no as text from sales_quote_hdr";
}
