package com.bitutech.purchaserequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class PurchaseRequestDaoImpl  implements PurchaseRequestDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public PurchaseRequestResultBean save(PurchaseRequestBean bean) throws Exception {
		PurchaseRequestResultBean resultBean = new PurchaseRequestResultBean();
		try {
			Map<String, Object> purchaseRequestMap = new HashMap<String, Object>();
			purchaseRequestMap.put("requisitionNo",bean.getRequisitionNo());
			purchaseRequestMap.put("company",bean.getCompany());
			purchaseRequestMap.put("requestType",bean.getRequestType());
			purchaseRequestMap.put("requestDate",bean.getRequestDate());
			purchaseRequestMap.put("destinationLocation",bean.getDestinationLocation());
			purchaseRequestMap.put("jobTitle", bean.getJobTitle());
	        purchaseRequestMap.put("requestedBy", bean.getRequestedBy());
			purchaseRequestMap.put("prReqNo",bean.getPrReqNo());
			purchaseRequestMap.put("sourceLocation", bean.getSourceLocation());
			purchaseRequestMap.put("costCenter", bean.getCostCenter());
			purchaseRequestMap.put("costCenter", bean.getCostCenter());
			purchaseRequestMap.put("requisitionId", bean.getRequisitionId());
			
		Integer requisitionId = namedParameterJdbcTemplate.queryForObject(PurchaseRequestQueryUtil.INSERT_PURCHASE_REQUISITION,purchaseRequestMap, Integer.class);
		
			if(requisitionId!= null) {
				if(bean.getPurchaseRequestDtlBean().size()>0) {
					for(PurchaseRequestDtlBean purchaseRequestDtlBean: bean.getPurchaseRequestDtlBean() ) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("requisitionId",requisitionId);
						dtlMap.put("itemId",purchaseRequestDtlBean.getItemId());
						dtlMap.put("itemDesc",purchaseRequestDtlBean.getItemDesc());
						dtlMap.put("pendingQuantity",purchaseRequestDtlBean.getPendingQuantity());
						dtlMap.put("quantity",purchaseRequestDtlBean.getQuantity());
						dtlMap.put("altuom",purchaseRequestDtlBean.getAltuom());
						dtlMap.put("altqty",purchaseRequestDtlBean.getAltqty());
						dtlMap.put("edd",purchaseRequestDtlBean.getEdd());
						
						
						namedParameterJdbcTemplate.update(PurchaseRequestQueryUtil.INSERT_PURCHASE_REQUISITION_DETAIL,dtlMap);
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
	public List<PurchaseRequestBean> getPurchaseRequestList() throws Exception {
		List<PurchaseRequestBean> purchaseRequestBean = new ArrayList<PurchaseRequestBean>();
		try {
			purchaseRequestBean = jdbcTemplate.query(PurchaseRequestQueryUtil.getPurchaseRequestList, new BeanPropertyRowMapper<PurchaseRequestBean>(PurchaseRequestBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return purchaseRequestBean;
	}

	
//	@Override
//	public List<PurchaseRequestBean> getUomcateList() throws Exception {
//		List<PurchaseRequestBean> objUomMasterBean = new ArrayList<PurchaseRequestBean>();
//		try {
//			objUomMasterBean = jdbcTemplate.query(PurchaseRequestQueryUtil.getUomcategoryList, new BeanPropertyRowMapper<PurchaseRequestBean>(PurchaseRequestBean.class));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return objUomMasterBean;
//	}
	
	//edit
		@Override
		public PurchaseRequestResultBean edit(Integer bean) throws Exception {
			PurchaseRequestResultBean resultBean = new PurchaseRequestResultBean();
			resultBean.setSuccess(false);
			try {
				resultBean.setPurchaseRequestBean(jdbcTemplate.queryForObject(PurchaseRequestQueryUtil.SELECT_PURCHASE_REQUISITION,new Object[] { bean }, new BeanPropertyRowMapper<PurchaseRequestBean>(PurchaseRequestBean.class)));
				List<PurchaseRequestDtlBean> purchaseRequestDtlBean = jdbcTemplate.query(PurchaseRequestQueryUtil.SELECT_PURCHASE_REQUISITION_DTL,new Object[] { bean },new BeanPropertyRowMapper<PurchaseRequestDtlBean>(PurchaseRequestDtlBean.class));	
				  resultBean.setPurchaseRequestDtlBean(purchaseRequestDtlBean);
				resultBean.setSuccess(true);
			}
			catch(Exception e) {          
				e.printStackTrace();
				resultBean.setSuccess(false);
			}
			return resultBean;
		}

		//update
		@Override
		public PurchaseRequestResultBean update(PurchaseRequestBean bean) throws Exception {
			Integer id = bean.getRequisitionId();
			PurchaseRequestResultBean resultBean = new PurchaseRequestResultBean();
			try {
				Map<String, Object> purchaseRequestMap = new HashMap<String, Object>();
				purchaseRequestMap.put("requisitionId",bean.getRequisitionId());
				purchaseRequestMap.put("requisitionNo",bean.getRequisitionNo());
				purchaseRequestMap.put("company",bean.getCompany());
				purchaseRequestMap.put("requestType",bean.getRequestType());
				purchaseRequestMap.put("requestDate",bean.getRequestDate());
				purchaseRequestMap.put("destinationLocation",bean.getDestinationLocation());
				purchaseRequestMap.put("jobTitle", bean.getJobTitle());
		        purchaseRequestMap.put("requestedBy", bean.getRequestedBy());
				purchaseRequestMap.put("prReqNo",bean.getPrReqNo());
				purchaseRequestMap.put("sourceLocation", bean.getSourceLocation());
				purchaseRequestMap.put("costCenter", bean.getCostCenter());
				purchaseRequestMap.put("costCenter", bean.getCostCenter());
				purchaseRequestMap.put("requisitionId", bean.getRequisitionId());
				

				namedParameterJdbcTemplate.update(PurchaseRequestQueryUtil.UPDATE_PURCHASE_REQUISITION,purchaseRequestMap);
				
				if(bean.getPurchaseRequestDtlBean().size()>0) {
					jdbcTemplate.update(PurchaseRequestQueryUtil.DELETE_PURCHASE_REQUISITION_DETAIL,bean.getRequisitionId());	 
				
					for(PurchaseRequestDtlBean purchaseRequestDtlBean: bean.getPurchaseRequestDtlBean() ) {
				    		Map<String, Object> dtlMap = new HashMap<>();
							dtlMap.put("requisitionId",id);
							dtlMap.put("itemId",purchaseRequestDtlBean.getItemId());
							dtlMap.put("itemDesc",purchaseRequestDtlBean.getItemDesc());
							dtlMap.put("pendingQuantity",purchaseRequestDtlBean.getPendingQuantity());
							dtlMap.put("quantity",purchaseRequestDtlBean.getQuantity());
							dtlMap.put("altuom",purchaseRequestDtlBean.getAltuom());
							dtlMap.put("altqty",purchaseRequestDtlBean.getAltqty());
							dtlMap.put("edd",purchaseRequestDtlBean.getEdd());
							
							
							namedParameterJdbcTemplate.update(PurchaseRequestQueryUtil.INSERT_PURCHASE_REQUISITION_DETAIL,dtlMap);
				    } 
				    
				    }

				resultBean.setSuccess(true);
			}
			catch(Exception e){
				e.printStackTrace();
				resultBean.setSuccess(false);
			}
			
			return resultBean;
		}

		
		//delete
		@Override
		public PurchaseRequestResultBean delete(Integer requisitionId) throws Exception {
			PurchaseRequestResultBean resultBean = new PurchaseRequestResultBean();
			try {
				if(requisitionId!=null) {
					jdbcTemplate.update(PurchaseRequestQueryUtil.DELETE_PURCHASE_REQUISITION,requisitionId);
					jdbcTemplate.update(PurchaseRequestQueryUtil.DELETE_PURCHASE_REQUISITION_DETAIL,requisitionId);
				}
				resultBean.setSuccess(true);
			}
			catch(Exception e) {
				e.printStackTrace();
				resultBean.setSuccess(false);
			}	
			return resultBean;	}

		@Override
		public PurchaseRequestResultBean getRequisitionNo() throws Exception {
			// TODO Auto-generated method stub
			PurchaseRequestResultBean resultBean = new PurchaseRequestResultBean();
			String requisitionNo = jdbcTemplate.queryForObject(PurchaseRequestQueryUtil.getRequisitionNo,String.class);
			resultBean.setRequisitionNo(requisitionNo);
			return resultBean;
		}

//		@Override
//		public PurchaseRequestResultBean getRequisitionNoList() throws Exception {
//			// TODO Auto-generated method stub
//			List<DropDownList> requisitionNoList = new ArrayList<>();
//			PurchaseRequestResultBean resultBean = new PurchaseRequestResultBean();
//			try {
//				requisitionNoList = jdbcTemplate.update(PurchaseRequestQueryUtil.getRequisitionNoList,new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
//				resultBean.setRequisitionNoList(requisitionNoList);
//				resultBean.setSuccess(true);
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//				resultBean.setSuccess(false);
//			}
//			return resultBean;
//		}


}
