package com.bitutech.bankPayment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bitutech.core.util.DropDownList;

	@Repository
	public class BankPaymentDaoIpml implements BankPaymentDao {
		
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		@Autowired
		NamedParameterJdbcTemplate namedParameterJdbcTemplate;

		@Override
		public BankPaymentResultBean save(BankPaymentBean bean) throws Exception {
			BankPaymentResultBean resultBean = new BankPaymentResultBean();
			try {
				Map<String, Object> BankPaymentMap = new HashMap<String, Object>();
				BankPaymentMap.put("voucherNo", bean.getVoucherNo());
				BankPaymentMap.put("paymentDate", bean.getPaymentDate());
				BankPaymentMap.put("paymentType", bean.getPaymentType());
				BankPaymentMap.put("cashAcct", bean.getCashAcct());
	 			BankPaymentMap.put("amount", bean.getAmount());
	 			BankPaymentMap.put("narration", bean.getNarration());
				BankPaymentMap.put("paidTo", bean.getPaidTo());
				BankPaymentMap.put("companyName", bean.getCompanyName());
				BankPaymentMap.put("costcenter", bean.getCostcenter());
				
//				BankPaymentMap.put("chequeDate", bean.getChequeDate());
				BankPaymentMap.put("currency", bean.getCurrency());
//				//BankPaymentMap.put("modifiedBy","E0001");
//	 			BankPaymentMap.put("project", bean.getProject());
//	 			BankPaymentMap.put("totalAmt", bean.getTotalAmt());
				
				String voucherNo = namedParameterJdbcTemplate.queryForObject(BankPaymentQueryUtil.INSERT__BANK_PAYMENT_HDR,BankPaymentMap,String.class);
	 			
				if(!voucherNo.isEmpty()) {
					if(bean.getBankPaymentDetailBean().size()>0) {
						for(BankPaymentDetailBean BankPaymentDetailBean:bean.getBankPaymentDetailBean()) {
							Map<String, Object> dtlMap = new HashMap<>();
							dtlMap.put("voucherNo",voucherNo);
							dtlMap.put("accountName",BankPaymentDetailBean.getAccountName());
							dtlMap.put("currency",BankPaymentDetailBean.getCurrency());
							dtlMap.put("subAccountCode",BankPaymentDetailBean.getSubAccountCode());
							dtlMap.put("shortDetails",BankPaymentDetailBean.getShortDetails());
//							dtlMap.put("amount",BankPaymentDetailBean.getAmount());
//							dtlMap.put("createdBy","E0001");
							
							namedParameterJdbcTemplate.update(BankPaymentQueryUtil.INSERT__BANK_PAYMENT_Dtl,dtlMap);
					
						}
					}
				}
			   resultBean.setSuccess(true);
			      }catch(Exception e) {
				      e.printStackTrace();
				       resultBean.setSuccess(false);
			      }
			
			return resultBean;
		}

		@Override
		public List<BankPaymentBean> getList() throws Exception {
			List<BankPaymentBean> BankPaymentBean = new ArrayList<BankPaymentBean>();
			try {
				BankPaymentBean = jdbcTemplate.query(BankPaymentQueryUtil.getBankPaymentList, new BeanPropertyRowMapper<BankPaymentBean>(BankPaymentBean.class));
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return BankPaymentBean;
		}

		
		//edit
		@Override
		public BankPaymentResultBean edit(String voucherNo) throws Exception {
			BankPaymentResultBean resultBean = new BankPaymentResultBean();
			resultBean.setSuccess(false);
			try {
				resultBean.setBankPaymentBean(jdbcTemplate.queryForObject(BankPaymentQueryUtil.SELECT__BANK_PAYMENT_HDR,new Object[] { voucherNo }, new BeanPropertyRowMapper<BankPaymentBean>(BankPaymentBean.class)));
				resultBean.setBankPaymentDetailBean(jdbcTemplate.query(BankPaymentQueryUtil.SELECT__BANK_PAYMENT_DTL,new Object[] { voucherNo }, new BeanPropertyRowMapper<BankPaymentDetailBean>(BankPaymentDetailBean.class)));
				resultBean.setSuccess(true);
			}
			catch(Exception e) {          
				e.printStackTrace();
				resultBean.setSuccess(false);
			}
			return resultBean;
		}
		
		//update
//		@Override
//		public BankPaymentResultBean update(BankPaymentBean bean) throws Exception {
//			BankPaymentResultBean resultBean = new BankPaymentResultBean();
//			try {
//	    		Map<String, Object> BankPaymentMap = new HashMap<String, Object>();
//	    
//	    		BankPaymentMap.put("voucherNo", bean.getVoucherNo());
//				BankPaymentMap.put("paymentDate", bean.getPaymentDate());
//				BankPaymentMap.put("PaymentType", bean.getPaymentType());
//				BankPaymentMap.put("cashAcct", bean.getCashAcct());
//	 			BankPaymentMap.put("amount", bean.getAmount());
//	 			BankPaymentMap.put("narration", bean.getNarration());
//				BankPaymentMap.put("paidTo", bean.getPaidTo());
//				BankPaymentMap.put("companyName", bean.getCompanyName());
//				BankPaymentMap.put("costcenter", bean.getCostcenter());
//				
////				BankPaymentMap.put("chequeDate", bean.getChequeDate());
//				BankPaymentMap.put("currency", bean.getCurrency());
////				//BankPaymentMap.put("modifiedBy","E0001");
////	 			BankPaymentMap.put("project", bean.getProject());
////	 			BankPaymentMap.put("totalAmt", bean.getTotalAmt());
//				
//				String voucherNo = namedParameterJdbcTemplate.queryForObject(BankPaymentQueryUtil.UPDATE__BANK_PAYMENT_HDR,BankPaymentMap,String.class);
//				
//				if(bean.getBankPaymentDetailBean().size()>0) {
//					
//					jdbcTemplate.update(BankPaymentQueryUtil.DELETE_BANK_PAYMENT,voucherNo);
//					//jdbcTemplate.update(BankPaymentQueryUtil.DELETE__BANK_PAYMENT_DTL,salesOrder);
//
//					
//						for(BankPaymentDetailBean BankPaymentDetailBean:bean.getBankPaymentDetailBean()) {
//							Map<String, Object> dtlMap = new HashMap<>();
//							
//							dtlMap.put("accountName",BankPaymentDetailBean.getAccountName());
//							dtlMap.put("subAccountCode",BankPaymentDetailBean.getSubAccountCode());
//							dtlMap.put("shortDetails",BankPaymentDetailBean.getShortDetails());
//							dtlMap.put("currency",BankPaymentDetailBean.getCurrency());
//							dtlMap.put("amount",BankPaymentDetailBean.getAmount());
//							dtlMap.put("createdBy","E0001");
//							
//							namedParameterJdbcTemplate.update(BankPaymentQueryUtil.INSERT__BANK_PAYMENT_Dtl,dtlMap);
//							
//						}
//					
//				}
//				resultBean.setSuccess(true);
//				
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//			return resultBean;
//		}
//		
		@Override
		public BankPaymentResultBean delete(String voucherNo) throws Exception {
			BankPaymentResultBean resultBean = new BankPaymentResultBean();
			try {
				if(voucherNo!=null) {
					 
					jdbcTemplate.update(BankPaymentQueryUtil.DELETE_BANK_PAYMENT,voucherNo);
					//jdbcTemplate.update(BankPaymentQueryUtil.DELETE_SALES_ORDER_HDR,countValue);
				}
				resultBean.setSuccess(true);
			}
			catch(Exception e) {
				e.printStackTrace();
				resultBean.setSuccess(false);
			}	
			return resultBean;
		}

		@Override
		public BankPaymentResultBean getVoucherNo() throws Exception {
			// TODO Auto-generated method stub
			BankPaymentResultBean resultBean = new BankPaymentResultBean();
			String voucherNo = jdbcTemplate.queryForObject(BankPaymentQueryUtil.getVoucherNo,String.class);
			resultBean.setVoucherNo(voucherNo);
			return resultBean;
		}

		@Override
		public BankPaymentResultBean getVoucherNoList() throws Exception {
			// TODO Auto-generated method stub
			List<DropDownList> voucherNoList = new ArrayList<>();
			BankPaymentResultBean resultBean = new BankPaymentResultBean();
			try {
				voucherNoList = jdbcTemplate.query(BankPaymentQueryUtil.getVoucherNoList,new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
				resultBean.setVoucherNoList(voucherNoList);
				resultBean.setSuccess(true);
			}
			catch(Exception e) {
				e.printStackTrace();
				resultBean.setSuccess(false);
			}
			return resultBean;
		}

}
