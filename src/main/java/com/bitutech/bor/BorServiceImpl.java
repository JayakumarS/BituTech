package com.bitutech.bor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BorServiceImpl implements BorService{
	
	@Autowired
	BorDao borDao;

	@Override
	public BorResultBean save(BorBean bean) throws Exception {
		return borDao.save(bean);
	}

	@Override
	public List<BorBean> getBooList() throws Exception {
		// TODO Auto-generated method stub
		return borDao.getBooList();
	}
	
//	@Override
//	public BorResultBean getBorNo() throws Exception {
//		// TODO Auto-generated method stub
//		return borDao.getBorNo();
//	}
	
	@Override
	public BorResultBean getBooNo() throws Exception {
		// TODO Auto-generated method stub
		return borDao.getBooNo();
	}

	@Override
	public BorResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return borDao.edit(bean);
	}

	@Override
	public BorResultBean update(BorBean bean) throws Exception {
		// TODO Auto-generated method stub
		return borDao.update(bean);
	}

	@Override
	public BorResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return borDao.delete(bean);
	}

	


}
