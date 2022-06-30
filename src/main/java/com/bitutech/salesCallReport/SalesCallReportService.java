package com.bitutech.salesCallReport;

import java.util.List;

public interface SalesCallReportService {

//	public List<SalesCallReportBean> getList() throws Exception;

	public SalesCallReportResultBean save(SalesCallReportBean bean) throws Exception;

	public List<SalesCallReportBean> getsalesPersonList() throws Exception;
	

}
