package com.bitutech.salesCallReport;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;

public class SalesCallReportResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public List<SalesCallReportBean> salesCallReportDetails;
	public List<SalesCallReportBean> salesPersonDetails;
	
	public List<SalesCallReportBean> getSalesPersonDetails() {
		return salesPersonDetails;
	}

	public void setSalesPersonDetails(List<SalesCallReportBean> salesPersonDetails) {
		this.salesPersonDetails = salesPersonDetails;
	}

	public boolean isSuccess() {
		return success;
	}

	public List<SalesCallReportBean> getSalesCallReportDetails() {
		return salesCallReportDetails;
	}

	public void setSalesCallReportDetails(List<SalesCallReportBean> salesCallReportDetails) {
		this.salesCallReportDetails = salesCallReportDetails;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean success;

}
