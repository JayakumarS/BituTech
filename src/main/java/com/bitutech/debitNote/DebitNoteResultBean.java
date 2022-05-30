package com.bitutech.debitNote;

import java.util.List;

public class DebitNoteResultBean {
	
	private boolean Success;
	
	private List<DebitNoteBean> debitNoteDetails;
	private List<DebitNoteDetailBean> debitNoteDetailBean;
	
	private DebitNoteBean debitNoteBean;

	
	public DebitNoteBean getDebitNoteBean() {
		return debitNoteBean;
	}

	public void setDebitNoteBean(DebitNoteBean debitNoteBean) {
		this.debitNoteBean = debitNoteBean;
	}
	
	public List<DebitNoteBean> getDebitNoteDetails() {
		return debitNoteDetails;
	}

	public void setDebitNoteDetails(List<DebitNoteBean> debitNoteDetails) {
		this.debitNoteDetails = debitNoteDetails;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<DebitNoteDetailBean> getDebitNoteDetailBean() {
		return debitNoteDetailBean;
	}

	public void setDebitNoteDetailBean(List<DebitNoteDetailBean> debitNoteDetailBean) {
		this.debitNoteDetailBean = debitNoteDetailBean;
	}

}
