package com.bitutech.creditNote;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;

public class CreditNoteResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<CreditNoteBean> creditNoteDetails;
	private List<CreditNoteDetailBean> creditNoteDetailBean;
	
	private CreditNoteBean creditNoteBean;
	
	private String creditNoteNumber;

	public List<CreditNoteBean> getCreditNoteDetails() {
		return creditNoteDetails;
	}

	public void setCreditNoteDetails(List<CreditNoteBean> creditNoteDetails) {
		this.creditNoteDetails = creditNoteDetails;
	}

	public CreditNoteBean getCreditNoteBean() {
		return creditNoteBean;
	}

	public void setCreditNoteBean(CreditNoteBean creditNoteBean) {
		this.creditNoteBean = creditNoteBean;
	}

	public String getCreditNoteNumber() {
		return creditNoteNumber;
	}

	public void setCreditNoteNumber(String creditNoteNumber) {
		this.creditNoteNumber = creditNoteNumber;
	}

	public List<CreditNoteDetailBean> getCreditNoteDetailBean() {
		return creditNoteDetailBean;
	}

	public void setCreditNoteDetailBean(List<CreditNoteDetailBean> creditNoteDetailBean) {
		this.creditNoteDetailBean = creditNoteDetailBean;
	}

}
