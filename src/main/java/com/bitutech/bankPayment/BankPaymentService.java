package com.bitutech.bankPayment;

import java.util.List;

public interface BankPaymentService {
 
BankPaymentResultBean save(BankPaymentBean bean) throws Exception;
	
	BankPaymentResultBean edit(String voucherNo) throws Exception;
	
	//BankPaymentResultBean update(BankPaymentBean bean) throws Exception;
	
	BankPaymentResultBean delete(String bean) throws Exception;

	public List<BankPaymentBean> getList() throws Exception;

	BankPaymentResultBean getVoucherNo()throws Exception;

	BankPaymentResultBean getVoucherNoList()throws Exception;

	




}
