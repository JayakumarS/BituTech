package com.bitutech.customerMaster;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;

public class CustomerMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private CustomerMasterBean customerMasterBean;
	
	private List<CustomerMasterBean> customerMasterDetails;
	
	private String fileName;
	private String filePath;
	
	public final CustomerMasterBean getCustomerMasterBean() {
		return customerMasterBean;
	}

	public final void setCustomerMasterBean(CustomerMasterBean customerMasterBean) {
		this.customerMasterBean = customerMasterBean;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<CustomerMasterBean> getCustomerMasterDetails() {
		return customerMasterDetails;
	}

	public void setCustomerMasterDetails(List<CustomerMasterBean> customerMasterDetails) {
		this.customerMasterDetails = customerMasterDetails;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	

	
	
}
