package com.bitutech.customerMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitutech.common.FileUploadUtill;
import com.bitutech.countrymaster.CountryMasterResultBean;


@RestController
@RequestMapping("/api/auth/app/customerMaster")
public class CustomerMasterController {
	@Autowired
	CustomerMasterService customerMasterService;
	
	@Value("${file.upload.drugCustomerUpload}")
	private String drugCustomerUpload;
	
	@Value("${file.upload.drugCustomerUploadServerPath}")
	private String drugCustomerUploadServerPath;
	
	@RequestMapping(value="/save")
	public CustomerMasterResultBean save(@RequestBody CustomerMasterBean bean) {
		CustomerMasterResultBean objbean = new CustomerMasterResultBean();
		try {
			objbean = customerMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public CustomerMasterResultBean getCustomerList() throws Exception {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		objResultBean.setCustomerMasterDetails(customerMasterService.getCustomerList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public CustomerMasterResultBean edit(@RequestParam("customer") String customer) throws Exception {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		try {
			objResultBean = customerMasterService.edit(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public CustomerMasterResultBean update(@RequestBody CustomerMasterBean bean) {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		try {
			objResultBean = customerMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public CustomerMasterResultBean delete(@RequestParam("customer") String customer) {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		try {
			objResultBean = customerMasterService.delete(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	

	// File Upload
	
	@RequestMapping(value = "/uploadFile")
	public @ResponseBody CustomerMasterResultBean uploadFile(@RequestParam MultipartFile file,@RequestParam("fileName") String fileName) {
		CustomerMasterResultBean resultBean = new CustomerMasterResultBean();
		String filePath = "";
		if (!fileName.isEmpty()) {
			try {	
				filePath = FileUploadUtill.uploadFileHandlerWithOutRandom(file, drugCustomerUpload, drugCustomerUploadServerPath, fileName);
				resultBean.setFileName(fileName);
				resultBean.setFilePath(filePath);
				resultBean.setSuccess(true);
			} catch (Exception e) {
				resultBean.setSuccess(false);
				resultBean.setMessage(e.getMessage());
			}
		} else {
			resultBean.setSuccess(false);
			resultBean
					.setMessage("You failed to upload " + fileName + " because the file was empty.");
		}
		return resultBean;
	}

}
