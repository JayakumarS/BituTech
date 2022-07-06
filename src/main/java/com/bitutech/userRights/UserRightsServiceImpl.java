package com.bitutech.userRights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRightsServiceImpl implements UserRightsService {
	@Autowired
	UserRightsDao userRightsDao;

	
   @Override
	public List<UserRightsBean> getuserList() throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getuserList();
	}

   @Override
  	public List<UserRightsBean> getCompanyList() throws Exception {
  		// TODO Auto-generated method stub
  		return userRightsDao.getCompanyList();
  	}
   
   
   @Override
 	public List<UserRightsBean> getModuleList() throws Exception {
 		// TODO Auto-generated method stub
 		return userRightsDao.getModuleList();
 	}
   

   
   @Override
	public List<UserRightsBean> getPropertyList() throws Exception {
		// TODO Auto-generated method stub
		return userRightsDao.getPropertyList();
	}
   
   @Override
 	public List<UserRightsBean> getuserFormList() throws Exception {
 		// TODO Auto-generated method stub
 		return userRightsDao.getuserFormList();
 	}
	
   
   @Override
	public List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws Exception {
		return userRightsDao.getFormMasterListByCompanyUser(userId, companyCode, moduleCode);
	}


	
}
