package com.bitutech.salesCallReport;

import java.util.List;

public interface SalesCallReportDao {

	List<SalesCallReportBean> getList() throws Exception;

	SalesCallReportResultBean save(SalesCallReportBean bean) throws Exception;

	List<SalesCallReportBean> getsalesPersonList() throws Exception;

}
