package com.bitutech.workorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.boo.BillOfOperationQueryUtil;
import com.bitutech.core.util.DropDownList;
import com.bitutech.creditNote.CreditNoteQueryUtil;
import com.bitutech.salesorder.SalesOrderBean;
import com.bitutech.salesorder.SalesOrderQueryUtil;
import com.bitutech.salesorder.SalesOrderResultBean;

@Repository
public class WorkOrderDaoImpl implements WorkOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public WorkOrderResultBean save(WorkOrderHdrObjBean bean) throws Exception {
		WorkOrderResultBean resultBean = new WorkOrderResultBean();
		resultBean.setSuccess(false);
		try {
			Map<String, Object> workOrderMap = new HashMap<String, Object>();
			
			String worderNumber =  jdbcTemplate.queryForObject(WorkOrderQueryUtil.GetWorderNumber, 
					String.class);
			
			workOrderMap.put("customer",bean.getCustomer());
			workOrderMap.put("workorderNo",worderNumber);
			workOrderMap.put("workorderDate",bean.getWorkorderDate());
			workOrderMap.put("salesOrderNo",bean.getSalesOrderNo());
		    
			String workorderNo = namedParameterJdbcTemplate.queryForObject(WorkOrderQueryUtil.INSERT_WORKORDER_HDR,workOrderMap,String.class);
			
			if(!workorderNo.isEmpty()) {
				if(bean.getWorkOrderDtlData().size()>0) {
					for(WorkOrderDtlBean workOrderDtlBean: bean.getWorkOrderDtlData() ) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("workorderNo",workorderNo);
						dtlMap.put("itemId",workOrderDtlBean.getItemId());
						dtlMap.put("quantity",workOrderDtlBean.getQuantity());
						dtlMap.put("uomId",workOrderDtlBean.getUomId());
						dtlMap.put("deliveryDate",workOrderDtlBean.getDeliveryDate());
						dtlMap.put("remarks",workOrderDtlBean.getRemarks());
						namedParameterJdbcTemplate.update(WorkOrderQueryUtil.INSERT_WORKORDER_DTL,dtlMap);
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
	public List<WorkOrderHdrObjBean> getWorkOrderList() throws Exception {
		List<WorkOrderHdrObjBean> objLocationMasterBean = new ArrayList<WorkOrderHdrObjBean>();
		try {
			objLocationMasterBean = jdbcTemplate.query(WorkOrderQueryUtil.getWorkOrderList, new BeanPropertyRowMapper<WorkOrderHdrObjBean>(WorkOrderHdrObjBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objLocationMasterBean;
	}

//	@Override
//	public WorkOrderResultBean getWorkOrderNumber() throws Exception {
//		// TODO Auto-generated method stub
//		WorkOrderResultBean workOrderResultBean = new WorkOrderResultBean();
//		String workOrderNumber =  jdbcTemplate.queryForObject(WorkOrderQueryUtil.GetWorderNumber, String.class);
//		workOrderResultBean.setWorkOrderNumber(workOrderNumber);
//		return workOrderResultBean;
//	}

	@Override
	public WorkOrderResultBean getSalesOrderNoList() throws Exception {
		// TODO Auto-generated method stub
		List<DropDownList> salesOrderNoList = new ArrayList<>();
		WorkOrderResultBean workOrderResultBean = new WorkOrderResultBean();
		try {
			salesOrderNoList = jdbcTemplate.query(WorkOrderQueryUtil.getSalesOrderNoList, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
			workOrderResultBean.setWorkOrderNoList(salesOrderNoList);
			workOrderResultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			workOrderResultBean.setSuccess(false);
		}
		return workOrderResultBean;
	}

	@Override
	public WorkOrderResultBean getUomList() throws Exception {
		// TODO Auto-generated method stub
		WorkOrderResultBean workOrderResultBean = new WorkOrderResultBean();
		workOrderResultBean.setSuccess(false);
		try {
			workOrderResultBean.setUomList(jdbcTemplate.query(WorkOrderQueryUtil.getUomList, new BeanPropertyRowMapper<DropDownList>(DropDownList.class)));
			workOrderResultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			workOrderResultBean.setSuccess(false);
		}
		return workOrderResultBean;
	}

	@Override
	public WorkOrderResultBean getItemList() throws Exception {
		// TODO Auto-generated method stub
		WorkOrderResultBean workOrderResultBean = new WorkOrderResultBean();
		workOrderResultBean.setSuccess(false);
		try {
			workOrderResultBean.setItemList(jdbcTemplate.query(WorkOrderQueryUtil.getItemList, new BeanPropertyRowMapper<DropDownList>(DropDownList.class)));
			workOrderResultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			workOrderResultBean.setSuccess(false);
		}
		return workOrderResultBean;
	}

	@Override
	public WorkOrderResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		WorkOrderResultBean resultBean = new WorkOrderResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setWorkOrderHdrObjBean(jdbcTemplate.queryForObject(WorkOrderQueryUtil.SELECT_WORKORDER_HDR,new Object[] { bean }, new BeanPropertyRowMapper<WorkOrderHdrObjBean>(WorkOrderHdrObjBean.class)));
			resultBean.setWorkOrderDtlBean(jdbcTemplate.query(WorkOrderQueryUtil.SELECT_WORKORDER_DTL,new Object[] { bean }, new BeanPropertyRowMapper<WorkOrderDtlBean>(WorkOrderDtlBean.class)));
			
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public WorkOrderResultBean update(WorkOrderHdrObjBean Bean) throws Exception {
		// TODO Auto-generated method stub
		WorkOrderResultBean resultBean = new WorkOrderResultBean();
		try {
			jdbcTemplate.queryForObject(WorkOrderQueryUtil.UPDATE_WORKORDER_HDR,new BeanPropertyRowMapper<WorkOrderHdrObjBean>(WorkOrderHdrObjBean.class),new Object[]
					{ Bean.getCustomer(), Bean.getWorkorderDate(),Bean.getSalesOrderNo(),Bean.getWorkorderNo()});
			
			if(Bean.getWorkOrderDtlData().size()>0) {
				jdbcTemplate.update(WorkOrderQueryUtil.DELETE_WORKORDER_DTL,Bean.getWorkorderNo());
				
				
				for(WorkOrderDtlBean workOrderDtlBean: Bean.getWorkOrderDtlData() ) {
					Map<String, Object> dtlMap = new HashMap<>();
					dtlMap.put("workorderNo",Bean.getWorkorderNo());
					dtlMap.put("itemId",workOrderDtlBean.getItemId());
					dtlMap.put("quantity",workOrderDtlBean.getQuantity());
					dtlMap.put("uomId",workOrderDtlBean.getUomId());
					dtlMap.put("deliveryDateObj",workOrderDtlBean.getDeliveryDateObj());
					dtlMap.put("remarks",workOrderDtlBean.getRemarks());
					namedParameterJdbcTemplate.update(WorkOrderQueryUtil.INSERT_WORKORDER_DTL,dtlMap);
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
	public WorkOrderResultBean delete(String workorderNo) throws Exception {
		WorkOrderResultBean resultBean = new WorkOrderResultBean();
		try {
			if(workorderNo!=null) {
				jdbcTemplate.update(WorkOrderQueryUtil.DELETE_BOM_HDR,workorderNo);
				//jdbcTemplate.update(WorkOrderQueryUtil.DELETE_BOM_DTL,workorderNo);
				jdbcTemplate.update(WorkOrderQueryUtil.DELETE_WORKORDER_DTL,workorderNo);
				jdbcTemplate.update(WorkOrderQueryUtil.DELETE_WORKORDER_HDR,workorderNo);
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
	public WorkOrderResultBean getFetchCustomerWorkOrder(String customer) throws Exception {
		// TODO Auto-generated method stub
		WorkOrderResultBean resultBean = new WorkOrderResultBean();
		resultBean.setSuccess(false);
		try {
			//resultBean.setSalesOrderBean(jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_QUOTE,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class)));
			List<WorkOrderHdrObjBean> salesOrderdtlBean = jdbcTemplate.query(WorkOrderQueryUtil.SELECT_SALES_QUOTE,new Object[] { customer },new BeanPropertyRowMapper<WorkOrderHdrObjBean>(WorkOrderHdrObjBean.class));	
			resultBean.setSalesQuoteNo(salesOrderdtlBean);		
			resultBean.setSuccess(true);
		}
		catch(Exception e) {          
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


}
