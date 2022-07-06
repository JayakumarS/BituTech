package com.bitutech.userRights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;
import com.bitutech.core.util.DropDownList;

public class UserRightsResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	
	
	private List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
	
	private List<UserRightsBean> FormMasterBean;
	
	private List<UserRightsBean> userList;
	
	private List<UserRightsBean> companyList;
	
	private List<UserRightsBean> moduleList;
	
	private List<UserRightsBean> userFormList;
	
	private List<UserRightsBean> PropertyList;
	
	


	
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	
	

	public List<UserRightsBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserRightsBean> userList) {
		this.userList = userList;
	}

	public List<UserRightsBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<UserRightsBean> companyList) {
		this.companyList = companyList;
	}

	public List<UserRightsBean> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<UserRightsBean> moduleList) {
		this.moduleList = moduleList;
	}

	public List<UserRightsBean> getUserFormList() {
		return userFormList;
	}

	public void setUserFormList(List<UserRightsBean> userFormList) {
		this.userFormList = userFormList;
	}

	public List<FormMasterBean> getlFormMasterBean() {
		return lFormMasterBean;
	}

	public void setlFormMasterBean(List<FormMasterBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
	}

	public List<UserRightsBean> getFormMasterBean() {
		return FormMasterBean;
	}

	public void setFormMasterBean(List<UserRightsBean> formMasterBean) {
		FormMasterBean = formMasterBean;
	}

	public List<UserRightsBean> getPropertyList() {
		return PropertyList;
	}

	public void setPropertyList(List<UserRightsBean> propertyList) {
		PropertyList = propertyList;
	}





	
	
}
