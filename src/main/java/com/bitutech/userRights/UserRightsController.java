package com.bitutech.userRights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/app/userRights")
public class UserRightsController {
	@Autowired
	UserRightsService userRightsService;
	

	


	
	

	@RequestMapping(value = "/getUserList")
   	public UserRightsResultBean getSalesOrderList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setUserList(userRightsService.getuserList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	@RequestMapping(value = "/getCompanyList")
   	public UserRightsResultBean getCompanyList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setCompanyList(userRightsService.getCompanyList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/getModuleList")
   	public UserRightsResultBean getModuleList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setModuleList(userRightsService.getModuleList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	@RequestMapping(value = "/getuserFormList")
   	public UserRightsResultBean getuserFormList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setUserFormList(userRightsService.getuserFormList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/getPropertyList")
   	public UserRightsResultBean getPropertyList() throws Exception {
		UserRightsResultBean objResultBean = new UserRightsResultBean();
		
		objResultBean.setPropertyList(userRightsService.getPropertyList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	@GetMapping(value = "/getuserpermissions")
	public @ResponseBody UserRightsResultBean getUserPermissions(@RequestParam String userId,
			@RequestParam String companyCode, @RequestParam String moduleCode)
			throws Exception {
		UserRightsResultBean objUserMasterResultBean = new UserRightsResultBean();
		
		
		objUserMasterResultBean.setlFormMasterBean(userRightsService.getFormMasterListByCompanyUser(userId, companyCode, moduleCode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}
	

}
