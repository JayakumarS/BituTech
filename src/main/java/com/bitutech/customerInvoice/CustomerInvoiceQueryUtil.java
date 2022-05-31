package com.bitutech.customerInvoice;

public class CustomerInvoiceQueryUtil {
	
//	public static final String SELECT_SALES_COUNT = "select count(*) from sales_quote_hdr";
	public static final String INSERT_customer_invoice_hdr = "INSERT into customer_invoice_hdr (invoice_no,invoice_dt,customer,currency,sales_order_no,amount,created_by,created_dt) "
			+ " values(:CustInvoiceNo,to_date(:CustInvoiceDate,'YYYY-MM-DD'), :customer,:currency,:amount,:amount,'E0001',now())";
	public static final String GETCOUNT = "select * From fn_generate_reference_no('sales_quote_hdr', 'sales_quote_no', 'S', '4')";
	public static final String getSalesQuoteList = "select customer_code as customer,to_char(valid_from,'YYYY-MM-DD') as validFrom,to_char(valid_till,'YYYY-MM-DD') as validTo,terms_n_conditions as termCondition,currency as currency,to_char(exp_date_of_delivery,'YYYY-MM-DD') as expectedDate,sales_quote_no as countValue from sales_quote_hdr";
//	public static final String getUomcategoryList = "select uomcategory_code as id,uomcategory_name as text from uom_category";
	public static final String SELECT_SALES_QUOTE_HDR = "select customer_code as customer,to_char(valid_from,'YYYY-MM-DD') as validFrom,to_char(valid_till,'YYYY-MM-DD') as validTo,terms_n_conditions as termCondition,currency as currency, to_char(exp_date_of_delivery,'YYYY-MM-DD') as expectedDate from sales_quote_hdr where sales_quote_no=?";
	public static final String UPDATE_SALES_QUOTE_HDR = "update sales_quote_hdr set customer_code=?,valid_from=to_date(?,'YYYY-MM-DD'),valid_till=to_date(?,'YYYY-MM-DD'),terms_n_conditions=?,currency=?,exp_date_of_delivery=to_date(?,'YYYY-MM-DD') where sales_quote_no=? Returning sales_quote_no as countValue";
	public static final String DELETE_SALES_QUOTE_HDR = "delete from sales_quote_hdr where sales_quote_no = ?";
	public static final String getCustDtls="select customer_code as id,customer_name as text from customer order by customer_name asc";
	public static final String getCurrencyDtls="select currency_code as id,currency_name as text from currency order by currency_name asc";
	public static final String getInvoiceNo="select CASE WHEN MAX(INVOICE_NO) IS NULL THEN 'INV000001' ELSE 'INV'||lpad(max(replace(INVOICE_NO,'INV','')::int+1)::text,6,'0') END AS invoiceNo   FROM customer_invoice_hdr WHERE length(invoice_no) = 9 and invoice_no not like '%A%'";
	public static final String getSalesOrderList="select sales_order_no as id,sales_order_no as text from sales_order_hdr  order by sales_order_no asc";
	public static final String GET_ITEM_DTLS=" select item_id as itemId ,qty,quot_price as quotePrice from sales_order_dtl where sales_order_no =? ";
	public static final String GET_ITEM="select item_id as id,item_name as text from item  order by item_name asc";
	public static final String getCustomerInvoice="select ci.invoice_no as custInvoiceNo,to_char(ci.invoice_dt,'YYYY-MM-DD')  as custInvoiceDate,(select customer_name from customer where customer_code= ci.customer) as customer ,ci.currency  ,sales_order_no as salesOrderNo,ci.amount as amount from customer_invoice_hdr  ci";
	public static final String INSERT_customer_invoice_dtl = "INSERT into customer_invoice_dtl (invoice_no,item_id,quote_price,qty) "
	+ " values(:CustInvoiceNo, :itemId,:QuotePrice,:Qty)";

 }
