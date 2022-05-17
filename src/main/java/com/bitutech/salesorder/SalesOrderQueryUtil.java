package com.bitutech.salesorder;

public class SalesOrderQueryUtil {

	public static final String INSERT_SALES_ORDER_HDR= "INSERT into sales_order_hdr (customer_code,terms_n_conditions,currency,exp_date_of_delivery,created_by,created_dt,sales_order_no,sales_quote_no,modified_by) "
			+ " values(:customer,:text,:currency,to_date(:deliveryDate,'YYYY-MM-DD'),'E0001',now(),:countValue,'S0002',:modifiedBy) RETURNING sales_order_no as salesOrderNo";
	public static final String GETCOUNT = "select * From fn_generate_reference_no('sales_order_hdr', 'sales_order_no','S','4')";
	public static final String getSalesOrderList = "select customer_code as customer,terms_n_conditions as text,currency as currency,to_char(exp_date_of_delivery,'YYYY-MM-DD') as deliveryDate,sales_order_no as countValue from sales_order_hdr";
	public static final String SELECT_SALES_ORDER_HDR = "select customer_code as customer, terms_n_conditions as text,currency as currency, to_char(exp_date_of_delivery,'YYYY-MM-DD') as deliveryDate from sales_order_hdr where sales_order_no=?";
	public static final String UPDATE_SALES_ORDER_HDR = "update sales_order_hdr set customer_code=:customer, terms_n_conditions=:text,currency=:currency,exp_date_of_delivery=to_date(:deliveryDate,'YYYY-MM-DD') where sales_order_no=:countValue Returning sales_order_no as salesOrderNo";
	public static final String DELETE_SALES_ORDER_HDR = "delete from sales_order_hdr where sales_order_no = ?";
	public static final String Insert_salesOder_Dtl = "INSERT INTO sales_order_dtl (sales_order_no,item_id,qty,quot_price,created_by,created_dt) values "
			+ "(:salesOrderNo,:item,:qty,:price,:createdBy,now())";
	public static final String GET_ITEM_NAME_LIST = "select item_id as id ,item_name as text from item";
	public static final String SELECT_SALES_ORDER_DTL = "select qty as qty,quot_price as price,item_id as item from sales_order_dtl where sales_order_no = ? ";
 	public static final String DELETE_workorder_hdr = "delete from workorder_hdr where sales_order_no = ? ";
	public static final String DELETE_SALESORDER_DTL = "delete from sales_order_dtl where sales_order_no = ?";
	public static final String GET_COSTOMER_LIST = "select customer_code as id ,customer_name as text from customer ";

}
