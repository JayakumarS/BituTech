package com.bitutech.debitNote;

import java.util.List;

public interface DebitNoteDao {

	DebitNoteResultBean save(DebitNoteBean bean) throws Exception;

	List<DebitNoteBean> getDebitNoteList() throws Exception;

	DebitNoteResultBean edit(String debitNote) throws Exception;

}
