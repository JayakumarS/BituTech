package com.bitutech.bor;

import java.util.List;

public interface BorDao {
	
	BorResultBean save(BorBean bean) throws Exception;

//	BorResultBean getBorNo() throws Exception;

	BorResultBean getBooNo() throws Exception;

	BorResultBean edit(String bean) throws Exception;

	BorResultBean update(BorBean bean) throws Exception;

	BorResultBean delete(String bean) throws Exception;

	List<BorBean> getBooList() throws Exception;


}
