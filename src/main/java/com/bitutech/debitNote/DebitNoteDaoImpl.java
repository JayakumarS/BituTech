package com.bitutech.debitNote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.creditNote.CreditNoteDetailBean;
import com.bitutech.creditNote.CreditNoteQueryUtil;


@Repository
public class DebitNoteDaoImpl implements DebitNoteDao{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public DebitNoteResultBean save(DebitNoteBean bean) throws Exception {
		// TODO Auto-generated method stub
		DebitNoteResultBean resultBean = new DebitNoteResultBean();
		try {
			Map<String, Object> debitNoteMap = new HashMap<String, Object>();
			
			String debitNoteNumber =  jdbcTemplate.queryForObject(DebitNoteQueryUtil.GetDebitNoteNo, 
					String.class);
			
			debitNoteMap.put("debitNoteNo", debitNoteNumber);
			debitNoteMap.put("debitNoteDate", bean.getDebitNoteDate());
			debitNoteMap.put("debitInvoiceDate", bean.getDebitInvoiceDate());
			debitNoteMap.put("debitNarration", bean.getDebitNarration());
			debitNoteMap.put("debitVendorCustomerName", bean.getDebitVendorCustomerName());
			debitNoteMap.put("debitCurrency", bean.getDebitCurrency());
			debitNoteMap.put("debitInvoiceNumber", bean.getDebitInvoiceNumber());
			debitNoteMap.put("debitExchangeRate", bean.getDebitExchangeRate());
			debitNoteMap.put("debitTotalTcAmt", bean.getDebitTotalTcAmt());
			debitNoteMap.put("debitTotalBcAmt", bean.getDebitTotalBcAmt());
			String debitNoteHdr=namedParameterJdbcTemplate.queryForObject(DebitNoteQueryUtil.INSERT_DEBITNOTE_HDR,debitNoteMap,String.class);
		   
			if(debitNoteHdr != null) {
				if(bean.getDebitNoteDetailBean().size()>0) {
					for(DebitNoteDetailBean debitNoteDetailBean: bean.getDebitNoteDetailBean())
					{
						 Map<String, Object> debitNoteDtlMap = new HashMap<String, Object>();
						 debitNoteDtlMap.put("debitNoteNo", debitNoteNumber);
						 debitNoteDtlMap.put("debitAccountHead", debitNoteDetailBean.getDebitAccountHead());
						 debitNoteDtlMap.put("debitSubAccount", debitNoteDetailBean.getDebitSubAccount());
						 debitNoteDtlMap.put("debitNarrationDtl", debitNoteDetailBean.getDebitNarrationDtl());
						 debitNoteDtlMap.put("debitBcAmt", debitNoteDetailBean.getDebitBcAmt());
						 debitNoteDtlMap.put("debitTcAmt", debitNoteDetailBean.getDebitTcAmt());
						 
						 namedParameterJdbcTemplate.update(DebitNoteQueryUtil.INSERT_DEBIT_NOTE_DTL,debitNoteDtlMap);
						 
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
	public List<DebitNoteBean> getDebitNoteList() throws Exception {
		// TODO Auto-generated method stub
		List<DebitNoteBean> objDebitNoteBean = new ArrayList<DebitNoteBean>();
		try {
			objDebitNoteBean = jdbcTemplate.query(DebitNoteQueryUtil.getDebitNoteList, new BeanPropertyRowMapper<DebitNoteBean>(DebitNoteBean.class));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objDebitNoteBean;
	}

	@Override
	public DebitNoteResultBean edit(String debitNote) throws Exception {
		// TODO Auto-generated method stub
		DebitNoteResultBean resultBean = new DebitNoteResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDebitNoteBean(jdbcTemplate.queryForObject(DebitNoteQueryUtil.SELECT_DEBITNOTE_HDR,new Object[] { debitNote }, new BeanPropertyRowMapper<DebitNoteBean>(DebitNoteBean.class)));
			List<DebitNoteDetailBean> debitNoteDetailBean = jdbcTemplate.query(DebitNoteQueryUtil.SELECT_DEBITNOTE_DTL_LIST,new Object[] { debitNote },new BeanPropertyRowMapper<DebitNoteDetailBean>(DebitNoteDetailBean.class));	
			  resultBean.setDebitNoteDetailBean(debitNoteDetailBean);		
			  resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

}
