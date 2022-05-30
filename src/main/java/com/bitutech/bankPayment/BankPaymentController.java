package com.bitutech.bankPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/api/auth/app/bankPayment")
	public class BankPaymentController {
		@Autowired
		BankPaymentService bankPaymentService;
		
		@RequestMapping(value="/save")
		public BankPaymentResultBean save(@RequestBody BankPaymentBean bean) {
			BankPaymentResultBean objbean = new BankPaymentResultBean();
			try {
				objbean = bankPaymentService.save(bean);
			}catch(Exception e){
				e.printStackTrace();	
			}
			return objbean;
			
		}
		
		@RequestMapping(value = "/getList")
	   	public BankPaymentResultBean getList() throws Exception {
			BankPaymentResultBean objResultBean = new BankPaymentResultBean();
			objResultBean.setBankPaymentDetails(bankPaymentService.getList());
			objResultBean.setSuccess(true);
	   		return objResultBean;
	   	}
		@RequestMapping(value = "/getVoucherNo")
		public BankPaymentResultBean getVoucherNo() throws Exception{
			BankPaymentResultBean objResultBean = new BankPaymentResultBean();
			objResultBean = bankPaymentService.getVoucherNo();
			objResultBean.setSuccess(true);
			return objResultBean;
		}
		
		@RequestMapping(value = "/getVoucherNoList")
		public BankPaymentResultBean getVoucherNoList() throws Exception {
			return bankPaymentService.getVoucherNoList();
		}
		//edit
		@GetMapping(value="/edit")
		public BankPaymentResultBean edit(@RequestParam("voucherNo") String voucherNo) {
			
			BankPaymentResultBean objResultBean = new BankPaymentResultBean();
			try {
				objResultBean = bankPaymentService.edit(voucherNo);
				
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			return objResultBean;
		}
//		
//		@RequestMapping(value = "/update")
//		public BankPaymentResultBean update(@RequestBody BankPaymentBean bean) {
//			BankPaymentResultBean objResultBean = new BankPaymentResultBean();
//			try {
//				objResultBean = bankPaymentService.update(bean);
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//			return objResultBean;
//
//		
//		}
		@RequestMapping(value = "/delete")
		public BankPaymentResultBean delete(@RequestParam("voucherNo") String voucherNo) {
			BankPaymentResultBean objResultBean = new BankPaymentResultBean();
			try {
				objResultBean = bankPaymentService.delete(voucherNo);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return objResultBean;
		}
		
		
	   	}

