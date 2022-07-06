package com.bitutech.userRights;

import java.util.List;

public interface UserRightsService {


	
	public List<UserRightsBean> getuserList() throws Exception;
	
	public List<UserRightsBean>getCompanyList() throws Exception;
	
	public List<UserRightsBean>getModuleList() throws Exception;
	
	public List<UserRightsBean>getuserFormList() throws Exception;
	
	public List<UserRightsBean>getPropertyList() throws Exception;
	
	
	List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws Exception;
	



}