package com.bitutech.customerInvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.common.Selectivity;

@Repository
public class CustomerInvoiceDaoImpl implements CustomerInvoiceDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public CustomerInvoiceResultBean save(CustomerInvoiceBean bean) throws Exception {
		CustomerInvoiceResultBean resultBean = new CustomerInvoiceResultBean();
		
		try {
			
			
			
			Map<String, Object> CustomerInvoiceMap = new HashMap<String, Object>();
		    
			CustomerInvoiceMap.put("CustInvoiceNo", bean.getCustInvoiceNo());
			CustomerInvoiceMap.put("CustInvoiceDate", bean.getCustInvoiceDate());
			CustomerInvoiceMap.put("customer", bean.getCustomer()); 
			CustomerInvoiceMap.put("amount", bean.getAmount());
			CustomerInvoiceMap.put("currency", bean.getCurrency());
			CustomerInvoiceMap.put("SalesOrderNo", bean.getSalesOrderNo()); 

			
			namedParameterJdbcTemplate.update(CustomerInvoiceQueryUtil.INSERT_customer_invoice_hdr,CustomerInvoiceMap);
			
			for(CustomerInvoiceDetailBean detailBean : bean.getCustomerInvoiceDetailBean()) {
				
				Map<String, Object> CustomerInvoiceDtlMap = new HashMap<String, Object>();
				CustomerInvoiceDtlMap.put("CustInvoiceNo", bean.getCustInvoiceNo());
				CustomerInvoiceDtlMap.put("itemId", detailBean.getItemId());
				CustomerInvoiceDtlMap.put("Qty", detailBean.getQty()); 
				CustomerInvoiceDtlMap.put("QuotePrice", detailBean.getQuotePrice()); 
				
				namedParameterJdbcTemplate.update(CustomerInvoiceQueryUtil.INSERT_customer_invoice_dtl,CustomerInvoiceDtlMap);

			}
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<CustomerInvoiceBean> getCustomerInvoiceList() throws Exception {
		List<CustomerInvoiceBean> salesQuoteBean = new ArrayList<CustomerInvoiceBean>();
		try {
			salesQuoteBean = jdbcTemplate.query(CustomerInvoiceQueryUtil.getCustomerInvoice, new BeanPropertyRowMapper<CustomerInvoiceBean>(CustomerInvoiceBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesQuoteBean;
	}

//	@Override
//	public List<SalesQuoteBean> getUomcateList() throws Exception {
//		List<SalesQuoteBean> salesOrderBean = new ArrayList<SalesQuoteBean>();
//		try {
//			salesOrderBean = jdbcTemplate.query(SalesQuoteQueryUtil.getUomcategoryList, new BeanPropertyRowMapper<SalesQuoteBean>(SalesQuoteBean.class));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return salesOrderBean;
//	}
	//edit
			@Override
			public CustomerInvoiceResultBean edit(String bean) throws Exception {
				CustomerInvoiceResultBean resultBean = new CustomerInvoiceResultBean();
				resultBean.setSuccess(false);
				try {
					resultBean.setCustomerInvoiceBean(jdbcTemplate.queryForObject(CustomerInvoiceQueryUtil.SELECT_SALES_QUOTE_HDR,new Object[] { bean }, new BeanPropertyRowMapper<CustomerInvoiceBean>(CustomerInvoiceBean.class)));
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
			public CustomerInvoiceResultBean update(CustomerInvoiceBean Bean) throws Exception {
				CustomerInvoiceResultBean resultBean = new CustomerInvoiceResultBean();
				try {
//					
////				
//					jdbcTemplate.queryForObject(CustomerInvoiceQueryUtil.UPDATE_SALES_QUOTE_HDR,new BeanPropertyRowMapper<CustomerInvoiceBean>(CustomerInvoiceBean.class), new Object[]
//							{ Bean.getCustomer(),Bean.getValidFrom(),Bean.getValidTo(),Bean.getTermCondition(),Bean.getCurrency(),Bean.getExpectedDate(),Bean.getCountValue()});
//						
					resultBean.setSuccess(true);
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return resultBean;
			}
			
			@Override
			public CustomerInvoiceResultBean delete(String countValue) throws Exception {
				CustomerInvoiceResultBean resultBean = new CustomerInvoiceResultBean();
				try {
					if(countValue!=null) {
						jdbcTemplate.update(CustomerInvoiceQueryUtil.DELETE_SALES_QUOTE_HDR,countValue);
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
			public List<Selectivity> getCustomer() {
				List<Selectivity>  getCustomerList = new ArrayList<Selectivity>();
 				try {
 					getCustomerList = jdbcTemplate.query(CustomerInvoiceQueryUtil.getCustDtls, new BeanPropertyRowMapper<Selectivity>(Selectivity.class));

  				}
				catch(Exception e) {          
					e.printStackTrace();
 				}
				return getCustomerList;
			}

			@Override
			public List<Selectivity> getCurrencyList() {
				List<Selectivity>  getCurrency = new ArrayList<Selectivity>();
 				try {
 					getCurrency = jdbcTemplate.query(CustomerInvoiceQueryUtil.getCurrencyDtls, new BeanPropertyRowMapper<Selectivity>(Selectivity.class));

  				}
				catch(Exception e) {          
					e.printStackTrace();
 				}
				return getCurrency;
			}

			@Override
			public CustomerInvoiceResultBean getInvoiceNo() {
				CustomerInvoiceResultBean resultBean = new CustomerInvoiceResultBean();
				resultBean.setSuccess(false);
				try {
					resultBean.setCustomerInvoiceBean(jdbcTemplate.queryForObject(CustomerInvoiceQueryUtil.getInvoiceNo,new Object[] {  }, new BeanPropertyRowMapper<CustomerInvoiceBean>(CustomerInvoiceBean.class)));
					resultBean.setSuccess(true);
				}
				catch(Exception e) {          
					e.printStackTrace();
					resultBean.setSuccess(false);
				}
				return resultBean;
			}

			@Override
			public List<Selectivity>  getSalesOrderDtl() {
				List<Selectivity>  getSalesOrderDtlList = new ArrayList<Selectivity>();
 				try {
 					getSalesOrderDtlList = jdbcTemplate.query(CustomerInvoiceQueryUtil.getSalesOrderList, new BeanPropertyRowMapper<Selectivity>(Selectivity.class));

  				}
				catch(Exception e) {          
					e.printStackTrace();
 				}
				return getSalesOrderDtlList;
			}

			@Override
			public CustomerInvoiceResultBean getItemDtls(String salesOrderNo) {
				CustomerInvoiceResultBean resultBean = new CustomerInvoiceResultBean();
				resultBean.setSuccess(false);
				try {
					resultBean.setCustomerInvoiceDetailBean(jdbcTemplate.query(CustomerInvoiceQueryUtil.GET_ITEM_DTLS, new BeanPropertyRowMapper<CustomerInvoiceDetailBean>(CustomerInvoiceDetailBean.class),salesOrderNo));
					resultBean.setSuccess(true);
				}
				catch(Exception e) {          
					e.printStackTrace();
					resultBean.setSuccess(false);
				}
				return resultBean;
			}

			@Override
			public List<Selectivity> getItemDropDown() {
				List<Selectivity>  getSalesOrderDtlList = new ArrayList<Selectivity>();
 				try {
 					getSalesOrderDtlList = jdbcTemplate.query(CustomerInvoiceQueryUtil.GET_ITEM, new BeanPropertyRowMapper<Selectivity>(Selectivity.class));

  				}
				catch(Exception e) {          
					e.printStackTrace();
 				}
				return getSalesOrderDtlList;
			}
}
