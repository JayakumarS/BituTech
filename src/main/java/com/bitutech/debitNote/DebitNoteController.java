package com.bitutech.debitNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.countrymaster.CountryMasterResultBean;



@RestController
@RequestMapping("/api/auth/app/debitNote")
public class DebitNoteController {
	
	@Autowired
	DebitNoteService debitNoteService;
	
	@RequestMapping(value="/save")
	public DebitNoteResultBean save(@RequestBody DebitNoteBean bean) {
		DebitNoteResultBean objbean = new DebitNoteResultBean();
		try {
			objbean = debitNoteService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	@RequestMapping(value = "/getList")
   	public DebitNoteResultBean getDebitNoteList() throws Exception {
		DebitNoteResultBean objResultBean = new DebitNoteResultBean();
		objResultBean.setDebitNoteDetails(debitNoteService.getDebitNoteList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value="/edit")
	public DebitNoteResultBean edit(@RequestParam("debitNote") String debitNote) {
		DebitNoteResultBean objbean = new DebitNoteResultBean();
		try {
			objbean = debitNoteService.edit(debitNote);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	

}
