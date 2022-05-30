package com.bitutech.debitNote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitNoteServiceImpl implements DebitNoteService{

	@Autowired
	DebitNoteDao debitNoteDao;
	
	@Override
	public DebitNoteResultBean save(DebitNoteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return debitNoteDao.save(bean);
	}

	@Override
	public List<DebitNoteBean> getDebitNoteList() throws Exception {
		// TODO Auto-generated method stub
		return debitNoteDao.getDebitNoteList();
	}

	@Override
	public DebitNoteResultBean edit(String debitNote) throws Exception {
		// TODO Auto-generated method stub
		return debitNoteDao.edit(debitNote);
	}

}
