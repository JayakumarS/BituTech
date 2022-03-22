package com.bitutech.uom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.core.util.CustomException;

@RestController
@RequestMapping("/api/auth/app/uomCategory")
public class UomController {
	@Autowired
	UomService uomService;
	
	@RequestMapping(value="/save")
	public UomResultBean save(@RequestBody UomBean bean) {
		UomResultBean objbean = new UomResultBean();
		try {
			objbean = uomService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public UomResultBean getUomList() throws Exception {
		UomResultBean objResultBean = new UomResultBean();
		objResultBean.setUomDetails(uomService.getUomList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}

}