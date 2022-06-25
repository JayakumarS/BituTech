package com.bitutech.boo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.billofmaterial.BillOfMaterialQueryUtil;
import com.bitutech.core.util.DropDownList;


@Repository
public class BillOfOperationDaoImpl implements BillOfOperationDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// save
	@Override
	public BillOfOperationResultBean save(BillOfOperationBean Bean) throws Exception {
		BillOfOperationResultBean resultBean = new BillOfOperationResultBean();
		resultBean.setSuccess(false);
		try {
			   
			//Integer idNo = jdbcTemplate.queryForObject(BillOfOperationQueryUtil.INSERT_BILL_OF_OPERATION,new BeanPropertyRowMapper<Integer>(Integer.class), new Object[]
		//{ Bean.getBooNo(),Bean.getBomRef(),Bean.getProductName(),Bean.getDate()},Integer.class);
			String booNo = jdbcTemplate.queryForObject(BillOfOperationQueryUtil.INSERT_BILL_OF_OPERATION, new Object[] { Bean.getBooNo(),Bean.getBomRef(),Bean.getProductName(),Bean.getDate()}, String.class);
		if(!booNo.isEmpty()) {
			if(Bean.getBooDetailBean().size()>0) {
				for(BooDetailBean booDetailBean: Bean.getBooDetailBean() ) {
					Map<String, Object> dtlMap = new HashMap<>();
					dtlMap.put("booNo",booNo);
					dtlMap.put("processSeqNo",booDetailBean.getProcessSeqNo());
					dtlMap.put("processName",booDetailBean.getProcessName());
					dtlMap.put("approxTime",booDetailBean.getApproxTime());
					dtlMap.put("approxCost",booDetailBean.getApproxCost());
					dtlMap.put("processRemarks",booDetailBean.getProcessRemarks());
					namedParameterJdbcTemplate.update(BillOfOperationQueryUtil.INSERT_BILL_OF_OPERATION_DETAIL,dtlMap);
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
	public List<BillOfOperationBean> getBooList() throws Exception {
		List<BillOfOperationBean> objCustomerMasterBean = new ArrayList<BillOfOperationBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(BillOfOperationQueryUtil.getBooList, new BeanPropertyRowMapper<BillOfOperationBean>(BillOfOperationBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	//edit
	@Override
	public BillOfOperationResultBean edit(String bean) throws Exception {
		BillOfOperationResultBean resultBean = new BillOfOperationResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setBillOfOperationBean(jdbcTemplate.queryForObject(BillOfOperationQueryUtil.SELECT_BILL_OF_OPERATION,new Object[] { bean }, new BeanPropertyRowMapper<BillOfOperationBean>(BillOfOperationBean.class)));
			resultBean.setBooDetailBean(jdbcTemplate.query(BillOfOperationQueryUtil.SELECT_BILL_OF_OPERATION_DTL,new Object[] { bean }, new BeanPropertyRowMapper<BooDetailBean>(BooDetailBean.class)));
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
	public BillOfOperationResultBean update(BillOfOperationBean Bean) throws Exception {
		BillOfOperationResultBean resultBean = new BillOfOperationResultBean();
		try {
		
			jdbcTemplate.queryForObject(BillOfOperationQueryUtil.UPDATE_BILL_OF_OPERATION,new BeanPropertyRowMapper<BillOfOperationBean>(BillOfOperationBean.class), new Object[]
					{Bean.getBooNo(), Bean.getBomRef(),Bean.getProductName(),Bean.getDate(),Bean.getBooNo()});
			String booNo = 	Bean.getBooNo();
			if(Bean.getBooDetailBean().size()>0) { 
				
				jdbcTemplate.update(BillOfOperationQueryUtil.DELETE_BOO_DTL,booNo);
				
				for(BooDetailBean booDetailBean: Bean.getBooDetailBean() ) {
					Map<String, Object> dtlMap = new HashMap<>();
					dtlMap.put("booNo",booNo);
					dtlMap.put("processSeqNo",booDetailBean.getProcessSeqNo());
					dtlMap.put("processName",booDetailBean.getProcessName());
					dtlMap.put("approxTime",booDetailBean.getApproxTime());
					dtlMap.put("approxCost",booDetailBean.getApproxCost());
					dtlMap.put("processRemarks",booDetailBean.getProcessRemarks());
					namedParameterJdbcTemplate.update(BillOfOperationQueryUtil.INSERT_BILL_OF_OPERATION_DETAIL,dtlMap);
				}
			}
			
			
			resultBean.setSuccess(true);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	//delete
	@Override
	public BillOfOperationResultBean delete(String booNo) throws Exception {
		BillOfOperationResultBean resultBean = new BillOfOperationResultBean();
		try {
			if(booNo!=null) {
				jdbcTemplate.update(BillOfOperationQueryUtil.DELETE_BILL_OF_OPERATION,booNo);
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
	public BillOfOperationResultBean getBooNo() throws Exception {
		// TODO Auto-generated method stub
		BillOfOperationResultBean resultBean = new BillOfOperationResultBean();
		String booNo = jdbcTemplate.queryForObject(BillOfOperationQueryUtil.GetBooNo,String.class);
		resultBean.setBooNumber(booNo);
		return resultBean;
	}

	@Override
	public BillOfOperationResultBean getBooNoList() throws Exception {
		// TODO Auto-generated method stub
		List<DropDownList> booNoList = new ArrayList<>();
		BillOfOperationResultBean resultBean = new BillOfOperationResultBean();
		try {
			booNoList = jdbcTemplate.query(BillOfOperationQueryUtil.getBooNoList,new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
			resultBean.setBillOfOperationList(booNoList);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


}
