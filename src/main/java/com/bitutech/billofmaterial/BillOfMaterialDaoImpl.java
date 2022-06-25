package com.bitutech.billofmaterial;

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
import com.bitutech.salesorder.SalesOrderQueryUtil;
import com.bitutech.workorder.WorkOrderHdrObjBean;
import com.bitutech.workorder.WorkOrderQueryUtil;
import com.bitutech.workorder.WorkOrderResultBean;

@Repository
public class BillOfMaterialDaoImpl implements BillOfMaterialDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public BillOfMaterialResultBean save(BillOfMaterialHdrObjBean bean) throws Exception {
		BillOfMaterialResultBean resultBean = new BillOfMaterialResultBean();
		try {
			Map<String, Object> bomMap = new HashMap<>();
			String bomNumber =  jdbcTemplate.queryForObject(BillOfMaterialQueryUtil.GetBooNumber, String.class);

			bomMap.put("customer",bean.getCustomer());
			bomMap.put("workorderNo",bean.getWorkorderNo());
			bomMap.put("bomNo",bomNumber);
			String bomNo = namedParameterJdbcTemplate.queryForObject(BillOfMaterialQueryUtil.Insert_Bom_Hdr,bomMap,String.class);
			
			if(!bomNo.isEmpty()) {
				if(bean.getBillOfMaterialDtlObjBean().size()>0) {
					for(BillOfMaterialDtlObjBean billOfMaterialDtlObjBean:bean.getBillOfMaterialDtlObjBean()) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("bomNo",bomNo);
						dtlMap.put("itemId",billOfMaterialDtlObjBean.getItemId());
						dtlMap.put("uomId",billOfMaterialDtlObjBean.getUomId());
						dtlMap.put("quantity",billOfMaterialDtlObjBean.getQuantity());
						dtlMap.put("availability",billOfMaterialDtlObjBean.getAvailability());
						dtlMap.put("createdBy","E0001");
						namedParameterJdbcTemplate.update(BillOfMaterialQueryUtil.Insert_Bom_Dtl,dtlMap);
						
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
	public BillOfMaterialResultBean getList() throws Exception {
		List<BillOfMaterialHdrObjBean> objMasterBean = new ArrayList<>();
		BillOfMaterialResultBean bomResultBean = new BillOfMaterialResultBean();
		bomResultBean.setSuccess(false);
		try {
			objMasterBean = jdbcTemplate.query(BillOfMaterialQueryUtil.getList, new BeanPropertyRowMapper<BillOfMaterialHdrObjBean>(BillOfMaterialHdrObjBean.class));
			bomResultBean.setBomDetails(objMasterBean);
			bomResultBean.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			bomResultBean.setSuccess(false);
		}
		return bomResultBean;
	}

	@Override
	public BillOfMaterialResultBean getWorkOrderList() throws Exception {
		// TODO Auto-generated method stub
		List<DropDownList> workOrderList = new ArrayList<>();
		BillOfMaterialResultBean bomResultBean = new BillOfMaterialResultBean();
		bomResultBean.setSuccess(false);
		try {
			workOrderList = jdbcTemplate.query(BillOfMaterialQueryUtil.getWorkOrderList, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
			bomResultBean.setWorkOrderNoList(workOrderList);
			bomResultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			bomResultBean.setSuccess(false);
		}
		return bomResultBean;
	}

//	@Override
//	public BillOfMaterialResultBean getBomNumber() throws Exception {
//		// TODO Auto-generated method stub
//		BillOfMaterialResultBean bomResultBean = new BillOfMaterialResultBean();
//		bomResultBean.setSuccess(false);
//		try {
//			String bomNumber =  jdbcTemplate.queryForObject(BillOfMaterialQueryUtil.GetWorderNumber, String.class);
//			bomResultBean.setBomNumber(bomNumber);
//			bomResultBean.setSuccess(true);
//		}catch(Exception e) {
//			e.printStackTrace();
//			bomResultBean.setSuccess(false);
//		}
//		return bomResultBean;
//	}

	@Override
	public BillOfMaterialResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		BillOfMaterialResultBean resultBean = new BillOfMaterialResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setBillOfMaterialHdrObjBean(jdbcTemplate.queryForObject(BillOfMaterialQueryUtil.SELECT_Bom_Hdr,new Object[] { bean }, new BeanPropertyRowMapper<BillOfMaterialHdrObjBean>(BillOfMaterialHdrObjBean.class)));
			resultBean.setBillOfMaterialDtlObjBean(jdbcTemplate.query(BillOfMaterialQueryUtil.SELECT_Bom_dtl,new Object[] { bean }, new BeanPropertyRowMapper<BillOfMaterialDtlObjBean>(BillOfMaterialDtlObjBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public BillOfMaterialResultBean update(BillOfMaterialHdrObjBean bean) throws Exception {
		// TODO Auto-generated method stub
		BillOfMaterialResultBean resultBean = new BillOfMaterialResultBean();
		try {
			Map<String, Object> bomMap = new HashMap<>();
			bomMap.put("customer",bean.getCustomer());
 			bomMap.put("bomNo",bean.getBomNo());
			bomMap.put("workorderNo",bean.getWorkorderNo());
			bomMap.put("bomNo",bean.getBomNo());
			String bomNo = bean.getBomNo();
			namedParameterJdbcTemplate.queryForObject(BillOfMaterialQueryUtil.Update_Bom_Hdr,bomMap,String.class);
			
 				if(bean.getBillOfMaterialDtlObjBean().size()>0) {
 					
					jdbcTemplate.update(BillOfMaterialQueryUtil.DELETE_BOM_DTL,bomNo);
					
					for(BillOfMaterialDtlObjBean billOfMaterialDtlObjBean:bean.getBillOfMaterialDtlObjBean()) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("bomNo",bomNo);
						dtlMap.put("itemId",billOfMaterialDtlObjBean.getItemId());
						dtlMap.put("uomId",billOfMaterialDtlObjBean.getUomId());
						dtlMap.put("quantity",billOfMaterialDtlObjBean.getQuantity());
						dtlMap.put("availability",billOfMaterialDtlObjBean.getAvailability());
						dtlMap.put("createdBy","E0001");
						namedParameterJdbcTemplate.update(BillOfMaterialQueryUtil.Insert_Bom_Dtl,dtlMap);
						
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
	public BillOfMaterialResultBean delete(String bomNo) throws Exception {
		// TODO Auto-generated method stub
		BillOfMaterialResultBean resultBean = new BillOfMaterialResultBean();
		try {
			if(bomNo!=null) {
				jdbcTemplate.update(BillOfMaterialQueryUtil.DELETE_BOM_HDR,bomNo);
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public BillOfMaterialResultBean getFetchCustomerBOM(String customer) throws Exception {
		// TODO Auto-generated method stub
		BillOfMaterialResultBean resultBean = new BillOfMaterialResultBean();
		resultBean.setSuccess(false);
		try {
			//resultBean.setSalesOrderBean(jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_QUOTE,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class)));
			List<BillOfMaterialHdrObjBean> bomBean = jdbcTemplate.query(BillOfMaterialQueryUtil.SELECT_Bill_Of_Material,new Object[] { customer },new BeanPropertyRowMapper<BillOfMaterialHdrObjBean>(BillOfMaterialHdrObjBean.class));	
			resultBean.setCustomerListDetails(bomBean);		
			resultBean.setSuccess(true);
		}
		catch(Exception e) {          
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


}
