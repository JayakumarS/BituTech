package com.bitutech.bor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth/app/bor")
public class BorController {

	@Autowired
	BorService borService;
	
	@RequestMapping(value="/save")
	public BorResultBean save(@RequestBody BorBean bean) {
		BorResultBean objbean = new BorResultBean();
		try {
			objbean = borService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public BorResultBean getBooList() throws Exception {
		BorResultBean objResultBean = new BorResultBean();
		objResultBean.setBorDetails(borService.getBooList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
//	@RequestMapping(value = "/getBorNo")
//	public BorResultBean getBorNo() throws Exception{
//		BorResultBean objResultBean = new BorResultBean();
//		objResultBean = borService.getBorNo();
//		objResultBean.setSuccess(true);
//		return objResultBean;
//	}
	
	@RequestMapping(value = "/getBooNo")
	public BorResultBean getBooNo() throws Exception {
		return borService.getBooNo();
	}
	
	@GetMapping(value="/edit")
	public BorResultBean edit(@RequestParam("bor") String bor) {
		BorResultBean objResultBean = new BorResultBean();
		try {
			objResultBean = borService.edit(bor);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/update")
	public BorResultBean update(@RequestBody BorBean bean) {
		BorResultBean objResultBean = new BorResultBean();
		try {
			objResultBean = borService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/delete")
	public BorResultBean delete(@RequestParam("bor") String bor) {
		BorResultBean objResultBean = new BorResultBean();
		try {
			objResultBean = borService.delete(bor);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objResultBean;
	}
	
}
