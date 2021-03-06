package com.bitutech.commodity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/commodity")
public class CommodityController {
	@Autowired
	CommodityService commodityService;
	//SAVE
	@RequestMapping(value="/save")
	public CommodityResultBean save(@RequestBody CommodityBean bean) {
		CommodityResultBean objbean = new CommodityResultBean();
		try {
			objbean = commodityService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	//ALL LIST
	
	@RequestMapping(value = "/getList")
   	public CommodityResultBean getCommodityList() throws Exception {
		CommodityResultBean objResultBean = new CommodityResultBean();
		objResultBean.setCommodityListDetails(commodityService.getCommodityList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	//Classification Name List drop down method
	
		@RequestMapping(value = "/classificationNameList")
	   	public CommodityResultBean getClassificationNameList() throws Exception {
			CommodityResultBean objResultBean = new CommodityResultBean();
			objResultBean.setClassificationNameList(commodityService.getClassificationNameList());
			objResultBean.setSuccess(true);
	   		return objResultBean;
	   	}
	//EDIT
	@RequestMapping(value="/edit")
	public CommodityResultBean edit(@RequestParam("commodity") String commodityCode) {
		CommodityResultBean objResultBean = new CommodityResultBean();
		try {
			objResultBean = commodityService.edit(commodityCode);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objResultBean;
		
	}
	//UPDATE
	@RequestMapping(value="/update")
	public CommodityResultBean update(@RequestBody CommodityBean bean) {
		CommodityResultBean objResultBean = new CommodityResultBean();
		try {
			objResultBean = commodityService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objResultBean;
		
	}
	//DELETE
	@RequestMapping(value="/delete")
	public CommodityResultBean delete(@RequestParam("commodityCode") String commodityCode) {
		CommodityResultBean objResultBean = new CommodityResultBean();
		try {
			objResultBean = commodityService.delete(commodityCode);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objResultBean;
		
	}

}
