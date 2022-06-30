package com.bitutech.salesCallReport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesCallReportServiceImpl implements  SalesCallReportService{

	@Autowired
	SalesCallReportDao salesCallReportDao;
	
//	@Override
//	public List<SalesCallReportBean> getList() throws Exception {
//		// TODO Auto-generated method stub
//		return salesCallReportDao.getList();
//	}

	@Override
	public SalesCallReportResultBean save(SalesCallReportBean bean) throws Exception {
		// TODO Auto-generated method stub
		return salesCallReportDao.save(bean);
	}

	@Override
	public List<SalesCallReportBean> getsalesPersonList() throws Exception {
		// TODO Auto-generated method stub
		return salesCallReportDao.getsalesPersonList();
	}

}
