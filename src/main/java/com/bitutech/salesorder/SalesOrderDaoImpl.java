package com.bitutech.salesorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.billofmaterial.BillOfMaterialDtlObjBean;
import com.bitutech.billofmaterial.BillOfMaterialQueryUtil;
import com.bitutech.countrymaster.CountryMasterBean;
import com.bitutech.countrymaster.CountryMasterQueryUtil;
import com.bitutech.salesquote.SalesQuoteBean;
import com.bitutech.salesquote.SalesQuoteQueryUtil;
import com.bitutech.salesquote.SalesQuoteResultBean;
import com.bitutech.workorder.WorkOrderDtlBean;
import com.bitutech.workorder.WorkOrderQueryUtil;

@Repository
public class SalesOrderDaoImpl implements SalesOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public SalesOrderResultBean save(SalesOrderBean bean) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		try {
			Map<String, Object> salesOrderMap = new HashMap<String, Object>();
		    
			salesOrderMap.put("customer", bean.getCustomer());
			salesOrderMap.put("validFrom", bean.getValidFrom());
			salesOrderMap.put("validTo", bean.getValidTo());
			salesOrderMap.put("currency", bean.getCurrency());
			salesOrderMap.put("deliveryDate", bean.getDeliveryDate());
			salesOrderMap.put("id", bean.getId());
			salesOrderMap.put("text", bean.getText());
			salesOrderMap.put("modifiedBy","E0001");
			String countValue =  jdbcTemplate.queryForObject(SalesOrderQueryUtil.GETCOUNT, String.class);
			salesOrderMap.put("countValue", countValue);
			
			String salesorderno = namedParameterJdbcTemplate.queryForObject(SalesOrderQueryUtil.INSERT_SALES_ORDER_HDR,salesOrderMap,String.class);
			
			
			if(!salesorderno.isEmpty()) {
				if(bean.getSalesOrderdtlBean().size()>0) {
					for(SalesOrderdtlBean salesOrderdtlBean:bean.getSalesOrderdtlBean()) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("salesOrderNo",salesorderno);
						dtlMap.put("item",salesOrderdtlBean.getItem());
						dtlMap.put("qty",salesOrderdtlBean.getQty());
						dtlMap.put("price",salesOrderdtlBean.getPrice());
						dtlMap.put("createdBy","E0001");
						namedParameterJdbcTemplate.update(SalesOrderQueryUtil.Insert_salesOder_Dtl,dtlMap);
						
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
	public List<SalesOrderBean> getSalesOrderList() throws Exception {
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.getSalesOrderList, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}

	@Override
	public List<SalesOrderBean> getItemNameList() throws Exception {
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.GET_ITEM_NAME_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}
	//edit
	@Override
	public SalesOrderResultBean edit(String bean) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setSalesOrderBean(jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_ORDER_HDR,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class)));
			resultBean.setSalesOrderdtlBean(jdbcTemplate.query(SalesOrderQueryUtil.SELECT_SALES_ORDER_DTL,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderdtlBean>(SalesOrderdtlBean.class)));
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
	public SalesOrderResultBean update(SalesOrderBean bean) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		try {
    		Map<String, Object> salesOrderMap = new HashMap<String, Object>();
		    
			salesOrderMap.put("customer", bean.getCustomer());
			salesOrderMap.put("validFrom", bean.getValidFrom());
			salesOrderMap.put("validTo", bean.getValidTo());
			salesOrderMap.put("currency", bean.getCurrency());
			salesOrderMap.put("deliveryDate", bean.getDeliveryDate());
			salesOrderMap.put("id", bean.getId());
			salesOrderMap.put("text", bean.getText());
			salesOrderMap.put("modifiedBy","E0001");
 			salesOrderMap.put("countValue", bean.getCountValue());
			String salesOrder =  bean.getCountValue();
			String itemID = namedParameterJdbcTemplate.queryForObject(SalesOrderQueryUtil.UPDATE_SALES_ORDER_HDR,salesOrderMap,String.class);
			
			if(bean.getSalesOrderdtlBean().size()>0) {
				
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_workorder_hdr,salesOrder);
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALESORDER_DTL,salesOrder);

				
					for(SalesOrderdtlBean salesOrderdtlBean:bean.getSalesOrderdtlBean()) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("salesOrderNo",salesOrder);
						dtlMap.put("item",salesOrderdtlBean.getItem());
						dtlMap.put("qty",salesOrderdtlBean.getQty());
						dtlMap.put("price",salesOrderdtlBean.getPrice());
						dtlMap.put("createdBy","E0001");
						namedParameterJdbcTemplate.update(SalesOrderQueryUtil.Insert_salesOder_Dtl,dtlMap);
						
					}
				
			}
			resultBean.setSuccess(true);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public SalesOrderResultBean delete(String countValue) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		try {
			if(countValue!=null) {
				 
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_workorder_hdr,countValue);
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALES_ORDER_HDR,countValue);
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
	public List<SalesOrderBean> getCustomerList() throws Exception {
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.GET_COSTOMER_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}


}
