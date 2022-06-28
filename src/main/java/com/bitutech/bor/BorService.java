package com.bitutech.bor;

import java.util.List;

public interface BorService {
	BorResultBean save(BorBean bean) throws Exception;

	BorResultBean edit(String bean) throws Exception;
	
//	BorResultBean getBorNo() throws Exception;

	BorResultBean getBooNo() throws Exception;
	
	BorResultBean update(BorBean bean) throws Exception;

	BorResultBean delete(String billOfOperation) throws Exception;

	public List<BorBean> getBooList() throws Exception;

}
