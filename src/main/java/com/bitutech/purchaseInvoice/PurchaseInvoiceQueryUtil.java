package com.bitutech.purchaseInvoice;

public class PurchaseInvoiceQueryUtil {

	public static final String DELETE_PURCHASE_INVOICE = "Insert into purchase_invoice_hdr (invoice_no,invoice_dt,supplier,partyinvoice_no,created_by,currency,due_dt,company_code,ex_rate,payment_status,description,created_dt) values (:purchaseInvoiceNo,to_date(:invoiceDate,'YYYY-MM-DD'),:companyName,:manualInvoiceNo,:quotation,:currency,to_date(:dueDate,'YYYY-MM-DD'),:customer,:narration,now())";
	public static final String UPDATE_PURCHASE_INVOICE = null;
	public static final String getPurchaseInvoiceList="select invoice_dt as invoiceDate,supplier as companyName,partyinvoice_no as manualInvoiceNo,created_by as quotation,currency as currency,due_dt as dueDate,company_code as customer,ex_rate as exchangeRate,payment_status as type,description as narration from purchase_invoice_hdr where invoice_no = ?";
	public static final String SELECT_PURCHASE_INVOICE = "select invoice_no as purchaseInvoiceNo,invoice_dt as invoiceDate,supplier as companyName,partyinvoice_no as manualInvoiceNo from purchase_invoice_hdr";
	public static final String INSERT_PURCHASE_INVOICE = "Insert into purchase_invoice_hdr (invoice_no,invoice_dt,supplier,partyinvoice_no,created_by,currency,due_dt,company_code,ex_rate,payment_status,description,created_dt,amount) values (:purchaseInvoiceNo,to_date(:invoiceDate,'YYYY-MM-DD'),:companyName,:manualInvoiceNo,:quotation,:currency,to_date(:dueDate,'YYYY-MM-DD'),:customer,:exchangeRate,:type,:narration,now(),'1') returning invoice_no as purchaseInvoiceNo";
	public static final String GetPurchaseInvoiceNo = "select * from fn_generate_reference_no('purchase_invoice_hdr','invoice_no','PI',4)";
	public static final String INSERT_PURCHASE_INVOICE_DTL = "Insert into purchase_invoice_dtl (purchase_inv_no,subgroup_code,employee,location,customer,amount,charge_code,sht_details,cost_center,sl_no) values (:purchaseInvoiceNo,:detailItem,:detailQuantity,:detailUnitPrice,:detailTaxAmount,:detailAmount,:detailCharges,:detailShortDetails,:detailSecondRowAmount,'1')";
	public static final String SELECT_PURCHASE_INVOICE_DTL = "select purchase_inv_no as purchaseInvoiceNo,subgroup_code as detailItem,employee as detailQuantity,location as detailUnitPrice,customer as detailTaxAmount,amount as detailAmount,charge_code as detailCharges,sht_details as detailShortDetails,cost_center as detailSecondRowAmount from purchase_invoice_dtl where purchase_inv_no=?";

}
