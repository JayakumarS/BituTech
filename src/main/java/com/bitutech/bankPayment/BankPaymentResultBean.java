package com.bitutech.bankPayment;

import java.io.Serializable;
import java.util.List;
import com.bitutech.core.util.BasicResultBean;
import com.bitutech.core.util.DropDownList;

public class BankPaymentResultBean  extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	public List<BankPaymentBean> bankPaymentDetails;
	private List<BankPaymentDetailBean> bankPaymentDetailBean;
	private BankPaymentBean bankPaymentBean;
	private String voucherNo;
	private List<DropDownList> voucherNoList;

	public List<DropDownList> getVoucherNoList() {
		return voucherNoList;
	}

	public void setVoucherNoList(List<DropDownList> voucherNoList) {
		this.voucherNoList = voucherNoList;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public boolean isSuccess() {
		return success;
	}

	public List<BankPaymentBean> getBankPaymentDetails() {
		return bankPaymentDetails;
	}

	public void setBankPaymentDetails(List<BankPaymentBean> bankPaymentDetails) {
		this.bankPaymentDetails = bankPaymentDetails;
	}

	public List<BankPaymentDetailBean> getBankPaymentDetailBean() {
		return bankPaymentDetailBean;
	}
	public BankPaymentBean getBankPaymentBean() {
		return bankPaymentBean;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public void setBankPaymentDetailBean(List<BankPaymentDetailBean> bankPaymentDetailBean) {
		this.bankPaymentDetailBean = bankPaymentDetailBean;
	}
	public void setBankPaymentBean(BankPaymentBean bankPaymentBean) {
		this.bankPaymentBean = bankPaymentBean;
	}
}
