package com.bitutech.salesorder;

public class SalesOrderQueryUtil {

	public static final String INSERT_SALES_ORDER_HDR= "INSERT into sales_order_hdr (customer_code,terms_n_conditions,currency,exp_date_of_delivery,created_by,created_dt,sales_order_no,sales_quote_no,modified_by) "
			+ " values(:customer,:termCondition,:currency,to_date(:deliveryDate,'dd/mm/yyyy'),'E0001',now(),:countValue,:salesQuoteNo,:modifiedBy) RETURNING sales_order_no as salesOrderNo";
	public static final String GETCOUNT = "select * From fn_generate_reference_no('sales_order_hdr', 'sales_order_no','S','4')";
	public static final String getSalesOrderList = "select sales_order_no as countValue, c.customer_name as customer,terms_n_conditions as termCondition,s.currency as currency,to_char(exp_date_of_delivery,'YYYY-MM-DD') as deliveryDate,sales_order_no as countValue from sales_order_hdr s\n"
			+ "inner join customer c on c.customer_code = s.customer_code";
	public static final String SELECT_SALES_ORDER_HDR = "select customer_code as customer, terms_n_conditions as termCondition,currency as currency, to_char(exp_date_of_delivery,'YYYY-MM-DD') as deliveryDate,sales_quote_no as salesQuoteNo from sales_order_hdr where sales_order_no=?";
	public static final String UPDATE_SALES_ORDER_HDR = "update sales_order_hdr set customer_code=:customer,sales_quote_no=:salesQuoteNo, terms_n_conditions=:termCondition,currency=:currency,exp_date_of_delivery=to_date(:deliveryDate,'YYYY-MM-DD') where sales_order_no=:countValue Returning sales_order_no as salesOrderNo";
	public static final String DELETE_SALES_ORDER_HDR = "delete from sales_order_hdr where sales_order_no = ?";
	public static final String Insert_salesOder_Dtl = "INSERT INTO sales_order_dtl (sales_order_no,item_id,uom_id,qty,quot_price,created_by,created_dt) values "
			+ "(:salesOrderNo,:item,:uomId,:qty,:price,:createdBy,now())";
	public static final String GET_ITEM_NAME_LIST = "select item_id as id ,item_name as text from item";
	public static final String SELECT_SALES_ORDER_DTL = "select qty as qty,quot_price as price,item_id as item,uom_id as uomId from sales_order_dtl where sales_order_no = ? ";
 	public static final String DELETE_workorder_hdr = "delete from workorder_hdr where sales_order_no = ? ";
	public static final String DELETE_SALESORDER_DTL = "delete from sales_order_dtl where sales_order_no = ?";
	public static final String GET_COSTOMER_LIST = "select customer_code as id ,customer_name as text from customer ";
	public static final String GET_SALES_ORDER_LIST = "select sales_quote_no as id ,sales_quote_no as text from sales_quote_hdr";
	public static final String SELECT_SALES_QUOTE_HDR = "select customer_code as customer,to_char(valid_from,'YYYY-MM-DD') as validFrom,to_char(valid_till,'YYYY-MM-DD') as validTo,sales_quote_no as salesQuoteNo,terms_n_conditions as termCondition,currency as currency, to_char(exp_date_of_delivery,'YYYY-MM-DD') as expectedDate from sales_quote_hdr where sales_quote_no=?";
	public static final String SELECT_SALES_QUOTE = "select customer_code as customer,sales_quote_no as salesQuoteNo from sales_quote_hdr where customer_code=?";
	public static String SELECT_SALES_QUOTE_DTL= "select sales_quote_no as salesQuoteNo,item_id as item,qty as qty ,quot_price as price from sales_quote_dtl where sales_quote_no=?";

}
