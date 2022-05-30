package com.bitutech.debitNote;

public class DebitNoteDetailBean {
    
    private String debitAccountHead;
	private String debitSubAccount;
	private String debitNarrationDtl;
	private Double debitBcAmt;
	private Double debitTcAmt;
	
	
	public String getDebitAccountHead() {
		return debitAccountHead;
	}
	public void setDebitAccountHead(String debitAccountHead) {
		this.debitAccountHead = debitAccountHead;
	}
	public String getDebitSubAccount() {
		return debitSubAccount;
	}
	public void setDebitSubAccount(String debitSubAccount) {
		this.debitSubAccount = debitSubAccount;
	}
	
	public Double getDebitBcAmt() {
		return debitBcAmt;
	}
	public void setDebitBcAmt(Double debitBcAmt) {
		this.debitBcAmt = debitBcAmt;
	}
	public Double getDebitTcAmt() {
		return debitTcAmt;
	}
	public void setDebitTcAmt(Double debitTcAmt) {
		this.debitTcAmt = debitTcAmt;
	}
	public String getDebitNarrationDtl() {
		return debitNarrationDtl;
	}
	public void setDebitNarrationDtl(String debitNarrationDtl) {
		this.debitNarrationDtl = debitNarrationDtl;
	}	

}
