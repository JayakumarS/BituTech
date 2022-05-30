package com.bitutech.bankPayment;

public class BankPaymentQueryUtil {

	public static final String DELETE_BANK_PAYMENT = null;
	public static final String INSERT__BANK_PAYMENT_Dtl ="INSERT INTO cashbank_pay_dtl (voucher_no,acct_head,currency,sub_account_code,short_detail)values(:voucherNo,:accountName,:currency,:subAccountCode,:shortDetails)";
	//public static final String UPDATE__BANK_PAYMENT_HDR = "update cashbank_pay_hdr set voucher_dt=to_date(:paymentDate,'YYYY-MM-DD'),payment_type=:paymentType,bank_acct=:cashAcct,exchange_rate=:amount,narration=:narration,paid_to=:paidTo,company_code=:companyName,cost_center=:costcenter  where voucher_no=:voucherNo";
	public static final String SELECT__BANK_PAYMENT_HDR = "select voucher_no as voucherNo,to_char(voucher_dt,'DD-MM-YYYY') as paymentDate,payment_type as paymentType,bank_acct as cashAcct,exchange_rate as amount,narration as narration,paid_to as paidTo,company_code as companyName,cost_center as costcenter from cashbank_pay_hdr where voucher_no=?";
	public static final String SELECT__BANK_PAYMENT_DTL = "select voucher_no as voucherNo,currency as currency,sub_account_code as subAccountCode,short_detail as shortDetails from cashbank_pay_dtl where voucher_no=? ";
	public static final String INSERT__BANK_PAYMENT_HDR ="INSERT INTO cashbank_pay_hdr (voucher_no,voucher_dt,payment_type,bank_acct,exchange_rate,narration,created_by,created_dt,paid_to,company_code,cost_center)values(:voucherNo,to_date(:paymentDate,'YYYY-MM-DD'),:paymentType,:cashAcct,:amount,:narration,'E0001',now(),:paidTo,:companyName,:costcenter) RETURNING voucher_no as voucherNo";
	public static final String getVoucherNo = "select * from fn_generate_reference_no('cashbank_pay_hdr','voucher_no','VN',4)";
	public static final String getVoucherNoList ="select voucher_no as id,voucher_no as text from cashbank_pay_hdr ";
	public static String getBankPaymentList="select voucher_no as voucherNo,to_char(voucher_dt,'DD-MM-YYYY') as paymentDate,payment_type as paymentType,bank_acct as cashAcct,exchange_rate as amount,narration as narration,paid_to as paidTo,company_code as companyName,cost_center as costcenter from cashbank_pay_hdr";

}
