package com.bitutech.creditNote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitutech.boo.BillOfOperationResultBean;

@RestController
@RequestMapping("/api/auth/app/creditNote")
public class CreditNoteController {

	@Autowired
	CreditNoteService creditNoteService;
	
	@RequestMapping(value="/save")
	public CreditNoteResultBean save(@RequestBody CreditNoteBean bean) {
		CreditNoteResultBean objbean = new CreditNoteResultBean();
		try {
			objbean = creditNoteService.save(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objbean;
	}
	
	@RequestMapping(value="/getList")
	public CreditNoteResultBean getCreditNoteList() throws Exception {
		CreditNoteResultBean objResultBean = new CreditNoteResultBean();
		objResultBean.setCreditNoteDetails(creditNoteService.getCreditNoteList());
		objResultBean.setSuccess(true);
		return objResultBean;
	}
	
//	@RequestMapping(value = "/getCreditNoteNo")
//	public CreditNoteResultBean getCreditNoteNo() throws Exception{
//		CreditNoteResultBean objResultBean = new CreditNoteResultBean();
//		objResultBean = creditNoteService.getCreditNoteNo();
//		objResultBean.setSuccess(true);
//		return objResultBean;
//	}
	
	@RequestMapping(value="/edit")
	public CreditNoteResultBean edit(@RequestParam("creditNote") String creditNote) {
		CreditNoteResultBean objResultBean = new CreditNoteResultBean();
		try {
			objResultBean = creditNoteService.edit(creditNote);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
}
