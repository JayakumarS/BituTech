package com.bitutech.userRights;

import java.util.List;

import com.bitutech.core.util.CustomException;
import com.bitutech.core.util.DropDownList;

public interface UserRightsDao {


 List<UserRightsBean> getuserList() throws Exception;

 List<UserRightsBean> getCompanyList() throws Exception;
 
 List<UserRightsBean> getuserFormList() throws Exception;
 
 
 List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws CustomException;
 
 
 List<UserRightsBean> getModuleList() throws Exception;
 
 List<UserRightsBean>  getPropertyList() throws Exception;
 
 
 		
}
