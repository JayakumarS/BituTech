package com.bitutech.creditNote;

import java.util.List;

public interface CreditNoteService {

	CreditNoteResultBean save(CreditNoteBean bean) throws Exception;

	public List<CreditNoteBean> getCreditNoteList() throws Exception;

	CreditNoteResultBean edit(String creditNote) throws Exception;

//	CreditNoteResultBean getCreditNoteNo() throws Exception;
	
	

}
