package com.bitutech.creditNote;

import java.util.List;

public interface CreditNoteDao {

	CreditNoteResultBean save(CreditNoteBean bean) throws Exception;

	List<CreditNoteBean> getCreditNoteList() throws Exception;

	CreditNoteResultBean edit(String creditNote) throws Exception;

//	CreditNoteResultBean getCreditNoteNo() throws Exception;

}
