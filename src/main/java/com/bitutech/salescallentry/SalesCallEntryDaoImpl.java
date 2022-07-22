package com.bitutech.salescallentry;

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
public class SalesCallEntryDaoImpl implements SalesCallEntryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public SalesCallEntryResultBean save(SalesCallEntryBean bean) throws Exception {
		SalesCallEntryResultBean resultBean = new SalesCallEntryResultBean();
		try {
			Map<String, Object> salesCallEntryMap = new HashMap<String, Object>();
			
			salesCallEntryMap.put("objective", bean.getObjective());
			salesCallEntryMap.put("commodity", bean.getCommodity());
			salesCallEntryMap.put("date", bean.getDate());
			salesCallEntryMap.put("nextCallDate", bean.getNextCallDate());
			salesCallEntryMap.put("status", bean.getStatus());
			salesCallEntryMap.put("conditionSupport", bean.getConditionSupport());
			salesCallEntryMap.put("reasonSupport", bean.getReasonSupport());
			salesCallEntryMap.put("reasonNotSupport", bean.getReasonNotSupport());
			salesCallEntryMap.put("remarks", bean.getRemarks());
			
			salesCallEntryMap.put("customer", bean.getCustomer());
			salesCallEntryMap.put("customerType", bean.getCustomerType());
			salesCallEntryMap.put("typeOfCall", bean.getTypeOfCall());
			salesCallEntryMap.put("emailId", bean.getEmailId());
			salesCallEntryMap.put("personMet", bean.getPersonMet());
			salesCallEntryMap.put("assignTo", bean.getAssignTo());
			salesCallEntryMap.put("visitDate", bean.getVisitDate());
			salesCallEntryMap.put("modeOfContact", bean.getModeOfContact());
			salesCallEntryMap.put("designation", bean.getDesignation());
//			String salesCallHdrId =  jdbcTemplate.queryForObject(SalesEntryMasterQueryUtil.GETSALESCALLHDRID, String.class);
//			salesCallEntryMap.put("salesCallHdrId", salesCallHdrId);
			  
			Integer salesCallHdrId = namedParameterJdbcTemplate.queryForObject(SalesEntryMasterQueryUtil.INSERT_SALESENTRY_HDR,salesCallEntryMap,Integer.class);

			  if(salesCallHdrId != null) {
					 
				     if(bean.getSalescallEntryDetailBean().size()>0) {
				             
				    	 for(SalescallEntryDetailBean SalescallEntryDetailBean: bean.getSalescallEntryDetailBean() )
		    {
				    		 Map<String, Object> salesCallEntryDtlMap = new HashMap<String, Object>();
			salesCallEntryDtlMap.put("salesCallHdrId", salesCallHdrId);
			salesCallEntryDtlMap.put("objective", SalescallEntryDetailBean.getObjective());
			salesCallEntryDtlMap.put("commodity", SalescallEntryDetailBean.getCommodity());
			salesCallEntryDtlMap.put("date", SalescallEntryDetailBean.getDate());
			salesCallEntryDtlMap.put("nextCallDate", SalescallEntryDetailBean.getNextCallDate());
			salesCallEntryDtlMap.put("status", SalescallEntryDetailBean.getStatus());
			salesCallEntryDtlMap.put("conditionSupport", SalescallEntryDetailBean.getConditionSupport());
			salesCallEntryDtlMap.put("reasonSupport", SalescallEntryDetailBean.getReasonSupport());
			salesCallEntryDtlMap.put("reasonNotSupport", SalescallEntryDetailBean.getReasonNotSupport());
			salesCallEntryDtlMap.put("remarks", SalescallEntryDetailBean.getRemarks());

			  namedParameterJdbcTemplate.update(SalesEntryMasterQueryUtil.INSERT_SALESENTRY_DTL,salesCallEntryDtlMap);
			  
			         }
			      }
			     }
			
			
			resultBean.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
		
	}

	@Override
	public List<SalesCallEntryBean> getList() throws Exception {
		// TODO Auto-generated method stub
		List<SalesCallEntryBean> salesCallEntryBeanList = new ArrayList<SalesCallEntryBean>();
		try {
			salesCallEntryBeanList = jdbcTemplate.query(SalesEntryMasterQueryUtil.getList, new BeanPropertyRowMapper<SalesCallEntryBean>(SalesCallEntryBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesCallEntryBeanList;
	}
//edit
	@Override
	public SalesCallEntryResultBean edit(Integer bean) throws Exception {
		SalesCallEntryResultBean resultBean = new SalesCallEntryResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setSalesCallEntryBean(jdbcTemplate.queryForObject(SalesEntryMasterQueryUtil.SELECT_SALESENTRY_HDR,new Object[] { bean }, new BeanPropertyRowMapper<SalesCallEntryBean>(SalesCallEntryBean.class)));
			
			List<SalescallEntryDetailBean> salescallEntryDetailBean = jdbcTemplate.query(SalesEntryMasterQueryUtil.SELECT_SALESENTRY_DTL,new Object[] { bean },new BeanPropertyRowMapper<SalescallEntryDetailBean>(SalescallEntryDetailBean.class));	
			  resultBean.setSalescallEntryDetailBean(salescallEntryDetailBean);		
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
	public SalesCallEntryResultBean update(SalesCallEntryBean bean) throws Exception {
		SalesCallEntryResultBean resultBean = new SalesCallEntryResultBean();
		try {
			Map<String, Object> salesCallEntryMap = new HashMap<String, Object>();
			
			salesCallEntryMap.put("customer", bean.getCustomer());
			salesCallEntryMap.put("customerType", bean.getCustomerType());
			salesCallEntryMap.put("typeOfCall", bean.getTypeOfCall());
			salesCallEntryMap.put("emailId", bean.getEmailId());
			salesCallEntryMap.put("personMet", bean.getPersonMet());
			salesCallEntryMap.put("assignTo", bean.getAssignTo());
			salesCallEntryMap.put("visitDate", bean.getVisitDate());
			salesCallEntryMap.put("modeOfContact", bean.getModeOfContact());
			salesCallEntryMap.put("designation", bean.getDesignation());
			salesCallEntryMap.put("salesCallHdrId",bean.getSalesCallHdrId());
			Integer salesCallHdrIdNo = bean.getSalesCallHdrId();

			namedParameterJdbcTemplate.update(SalesEntryMasterQueryUtil.UPDATE_SALESENTRY_HDR,salesCallEntryMap);
			
			if(bean.getSalescallEntryDetailBean().size()>0) {
					 
				  jdbcTemplate.update(SalesEntryMasterQueryUtil.DELETE_SALESENTRY_DTL,bean.getSalesCallHdrId());
				

					
			             
			    	for(SalescallEntryDetailBean SalescallEntryDetailBean: bean.getSalescallEntryDetailBean() ){
			    	
				    		Map<String, Object> salesCallEntryDtlMap = new HashMap<String, Object>();
				 			salesCallEntryDtlMap.put("salesCallHdrId", salesCallHdrIdNo);
				 			salesCallEntryDtlMap.put("objective", SalescallEntryDetailBean.getObjective());
				 			salesCallEntryDtlMap.put("commodity", SalescallEntryDetailBean.getCommodity());
				 			salesCallEntryDtlMap.put("date", SalescallEntryDetailBean.getDate());
				 			salesCallEntryDtlMap.put("nextCallDate", SalescallEntryDetailBean.getNextCallDate());
				 			salesCallEntryDtlMap.put("status", SalescallEntryDetailBean.getStatus());
				 			salesCallEntryDtlMap.put("conditionSupport", SalescallEntryDetailBean.getConditionSupport());
				 			salesCallEntryDtlMap.put("reasonSupport", SalescallEntryDetailBean.getReasonSupport());
				 			salesCallEntryDtlMap.put("reasonNotSupport", SalescallEntryDetailBean.getReasonNotSupport());
				 			salesCallEntryDtlMap.put("remarks", SalescallEntryDetailBean.getRemarks());
				  
							  namedParameterJdbcTemplate.update(SalesEntryMasterQueryUtil.INSERT_SALESENTRY_DTL,salesCallEntryDtlMap);
			    } 
			    
			    }
			resultBean.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public SalesCallEntryResultBean delete(Integer salesCallHdrId) throws Exception {
		SalesCallEntryResultBean resultBean = new SalesCallEntryResultBean();
		resultBean.setSuccess(false);
		try {
			if(salesCallHdrId!=null) {
				jdbcTemplate.update(SalesEntryMasterQueryUtil.DELETE_SALESENTRY_HDR,salesCallHdrId);
				jdbcTemplate.update(SalesEntryMasterQueryUtil.DELETE_SALESENTRY_DTL,salesCallHdrId);
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

}
