package com.bitutech.creditNote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class CreditNoteDaoImpl implements CreditNoteDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public CreditNoteResultBean save(CreditNoteBean bean) throws Exception {
		// TODO Auto-generated method stub
		CreditNoteResultBean resultBean = new CreditNoteResultBean();
		resultBean.setSuccess(false);
		try {
			Map<String, Object> creditNoteMasterMap = new HashMap<String, Object>();
			
			String creditNoteNumber =  jdbcTemplate.queryForObject(CreditNoteQueryUtil.GetCreditNoteNo, 
					String.class);
			
			creditNoteMasterMap.put("creditNoteNo",creditNoteNumber);
			creditNoteMasterMap.put("creditNoteDate",bean.getCreditNoteDate());
			creditNoteMasterMap.put("creditInvoiceDate", bean.getCreditInvoiceDate());
			creditNoteMasterMap.put("creditNarration", bean.getCreditNarration());
			creditNoteMasterMap.put("creditVendorCustomerName", bean.getCreditVendorCustomerName());
			creditNoteMasterMap.put("creditCurrency",bean.getCreditCurrency());
			creditNoteMasterMap.put("creditInvoiceNumber", bean.getCreditInvoiceNumber());
			creditNoteMasterMap.put("creditExchangeRate", bean.getCreditExchangeRate());
			
			String creditNodeHrd = namedParameterJdbcTemplate.queryForObject(CreditNoteQueryUtil.INSERT_CREDIT_NOTE,creditNoteMasterMap,String.class);
			
			 if(creditNodeHrd != null) {
				 
			     if(bean.getCreditNoteDetailBean().size()>0) {
			             
			    	 for(CreditNoteDetailBean creditNoteDetailBean: bean.getCreditNoteDetailBean() )
	    {
			 Map<String, Object> creditNoteDtlMap = new HashMap<String, Object>();
			    creditNoteDtlMap.put("creditNoteNo", creditNoteNumber);
			    creditNoteDtlMap.put("accountHead", creditNoteDetailBean.getAccountHead());
			    creditNoteDtlMap.put("subAccount", creditNoteDetailBean.getSubAccount());
			    creditNoteDtlMap.put("narrationDtl", creditNoteDetailBean.getNarrationDtl());
			    creditNoteDtlMap.put("bcAmt", creditNoteDetailBean.getBcAmt());
			    creditNoteDtlMap.put("tcAmt", creditNoteDetailBean.getTcAmt());
		

		  namedParameterJdbcTemplate.update(CreditNoteQueryUtil.INSERT_CREDIT_NOTE_DTL,creditNoteDtlMap);
		  
		         }
		      }
		     }
			 
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public List<CreditNoteBean> getCreditNoteList() throws Exception {
		// TODO Auto-generated method stub
		CreditNoteResultBean resultBean = new CreditNoteResultBean();
		List<CreditNoteBean> objCreditNoteBean = new ArrayList<CreditNoteBean>();
		try {
			objCreditNoteBean = jdbcTemplate.query(CreditNoteQueryUtil.SELECT_CREDIT_NOTE, new BeanPropertyRowMapper<CreditNoteBean>(CreditNoteBean.class));
		
			List<CreditNoteDetailBean> creditNoteDetailBean = jdbcTemplate.query(CreditNoteQueryUtil.SELECT_CREDITNOTE_DTL_LIST,new Object[] { },new BeanPropertyRowMapper<CreditNoteDetailBean>(CreditNoteDetailBean.class));	
			  resultBean.setCreditNoteDetailBean(creditNoteDetailBean);		
			  resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objCreditNoteBean;
	}

	@Override
	public CreditNoteResultBean edit(String creditNote) throws Exception {
		// TODO Auto-generated method stub
		CreditNoteResultBean resultBean = new CreditNoteResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setCreditNoteBean(jdbcTemplate.queryForObject(CreditNoteQueryUtil.getCreditNoteList,new Object[] { creditNote }, new BeanPropertyRowMapper<CreditNoteBean>(CreditNoteBean.class)));
		
			List<CreditNoteDetailBean> creditNoteDetailBean = jdbcTemplate.query(CreditNoteQueryUtil.SELECT_CREDITNOTE_DTL,new Object[] { creditNote },new BeanPropertyRowMapper<CreditNoteDetailBean>(CreditNoteDetailBean.class));	
			  resultBean.setCreditNoteDetailBean(creditNoteDetailBean);		
			  resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

//	@Override
//	public CreditNoteResultBean getCreditNoteNo() throws Exception {
//		// TODO Auto-generated method stub
//		CreditNoteResultBean resultBean = new CreditNoteResultBean();
//		String creditNote = jdbcTemplate.queryForObject(CreditNoteQueryUtil.GetCreditNoteNo,String.class);
//		resultBean.setCreditNoteNumber(creditNote);
//		return resultBean;
//	}

}
