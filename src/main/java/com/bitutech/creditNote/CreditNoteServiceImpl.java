package com.bitutech.creditNote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditNoteServiceImpl implements CreditNoteService {
	@Autowired
	CreditNoteDao creditNoteDao;
	
	@Override
	public CreditNoteResultBean save(CreditNoteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return creditNoteDao.save(bean);
	}

	@Override
	public List<CreditNoteBean> getCreditNoteList() throws Exception {
		// TODO Auto-generated method stub
		return creditNoteDao.getCreditNoteList();
	}

	@Override
	public CreditNoteResultBean edit(String creditNote) throws Exception {
		// TODO Auto-generated method stub
		return creditNoteDao.edit(creditNote);
	}

//	@Override
//	public CreditNoteResultBean getCreditNoteNo() throws Exception {
//		// TODO Auto-generated method stub
//		return creditNoteDao.getCreditNoteNo();
//	}

}
