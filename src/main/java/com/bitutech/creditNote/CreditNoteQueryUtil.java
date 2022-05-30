package com.bitutech.creditNote;

public class CreditNoteQueryUtil {

	public static final String INSERT_CREDIT_NOTE = "Insert into creditnote_hdr (creditnote_no,creditnote_date,quotation_no,creditnote_narration,creditnote_account_head,creditnote_currency,creditnote_invoice_no,creditnote_exchange_rate,created_by,created_date) values \n"
			+ "(:creditNoteNo,to_date(:creditNoteDate,'YYYY-MM-DD'),:creditInvoiceDate,:creditNarration,:creditVendorCustomerName,:creditCurrency,:creditInvoiceNumber,:creditExchangeRate,'E0001',now()) returning creditnote_no as creditNoteNo\n";
	public static String INSERT_CREDIT_NOTE_DTL="Insert into creditnote_dtl (creditnote_no,creditnote_account_head,sub_account_code,creditnote_narration,creditnote_amount,creditnote_amountusd,creditnote_slno) \n"
			+ "values (:creditNoteNo,:accountHead,:subAccount,:narrationDtl,:bcAmt,:tcAmt,'0001')";
	public static final String SELECT_CREDIT_NOTE = "select creditnote_no as creditNoteNo,creditnote_date as creditNoteDate,quotation_no as creditInvoiceDate,creditnote_narration as creditNarration,creditnote_account_head as \n"
			+ "creditVendorCustomerName,creditnote_currency as creditCurrency,creditnote_invoice_no as creditInvoiceNumber,creditnote_exchange_rate as \n"
			+ "creditExchangeRate from creditnote_hdr ";
	public static String getCreditNoteList = "select creditnote_no as creditNoteNo,creditnote_date as creditNoteDate,quotation_no as creditInvoiceDate,creditnote_narration as creditNarration,creditnote_account_head as \n"
			+ "creditVendorCustomerName,creditnote_currency as creditCurrency,creditnote_invoice_no as creditInvoiceNumber,creditnote_exchange_rate as \n"
			+ "creditExchangeRate from creditnote_hdr where creditnote_no = ?";
	public static String GetCreditNoteNo="select * from fn_generate_reference_no('creditnote_hdr','creditnote_no','CR',4)";
	public static String SELECT_CREDITNOTE_DTL="select creditnote_no as creditNoteNo,creditnote_account_head as accountHead,sub_account_code as subAccount,\n"
			+ "creditnote_narration as narrationDtl,creditnote_amount as bcAmt,creditnote_amountusd as tcAmt from creditnote_dtl \n"
			+ "where creditnote_no=?";
	public static String SELECT_CREDITNOTE_DTL_LIST="select creditnote_no as creditNoteNo,creditnote_account_head as accountHead,sub_account_code as subAccount,creditnote_narration as narrationDtl,creditnote_amount as bcAmt,creditnote_amountusd as tcAmt from creditnote_dtl";
	

}
