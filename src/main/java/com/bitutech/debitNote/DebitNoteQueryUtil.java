package com.bitutech.debitNote;

public class DebitNoteQueryUtil {

	public static final String INSERT_DEBITNOTE_HDR = "Insert into debitnote_hdr (debitnote_no,debitnote_date,quotation_no,debitnote_narration,\n"
			+ "debitnote_account_head,debitnote_currency,debitnote_invoice_no,debitnote_exchange_rate,created_by,\n"
			+ "created_date) values (:debitNoteNo,to_date(:debitNoteDate,'YYYY-MM-DD'),:debitInvoiceDate,:debitNarration,\n"
			+ ":debitVendorCustomerName,:debitCurrency,:debitInvoiceNumber,:debitExchangeRate,'E0001',now()) returning debitnote_no as debitNoteNo";
	public static final String getDebitNoteList = "select debitnote_no as debitNoteNo,debitnote_date as debitNoteDate,quotation_no as debitInvoiceDate,\n"
			+ "debitnote_narration as debitNarration,debitnote_account_head as debitVendorCustomerName,\n"
			+ "debitnote_currency as debitCurrency,debitnote_invoice_no as debitInvoiceNumber,debitnote_exchange_rate \n"
			+ "as debitExchangeRate from debitnote_hdr";
	public static final String SELECT_DEBITNOTE_HDR = "select debitnote_no as debitNoteNo,debitnote_date as debitNoteDate,quotation_no as debitInvoiceDate,debitnote_narration as debitNarration,debitnote_account_head as debitVendorCustomerName,debitnote_currency as debitCurrency,debitnote_invoice_no as debitInvoiceNumber,debitnote_exchange_rate as debitExchangeRate from debitnote_hdr where debitnote_no=?";
	public static String GetDebitNoteNo = "select * from fn_generate_reference_no('debitnote_hdr','debitnote_no','DB',4)";
	public static String INSERT_DEBIT_NOTE_DTL = "Insert into debitnote_dtl (debitnote_no,debitnote_account_head,sub_account_code,debitnote_narration,\n"
			+ "debitnote_amount,debitnote_amountusd,debitnote_slno)values (:debitNoteNo,:debitAccountHead,:debitSubAccount,\n"
			+ ":debitNarrationDtl,:debitBcAmt,:debitTcAmt,'0001')";
	public static String SELECT_DEBITNOTE_DTL_LIST = "select debitnote_no as debitNoteNo,debitnote_account_head as debitAccountHead,sub_account_code as debitSubAccount,debitnote_narration as debitNarrationDtl,debitnote_amount as debitBcAmt,debitnote_amountusd as debitTcAmt from debitnote_dtl where debitnote_no=?";

}
