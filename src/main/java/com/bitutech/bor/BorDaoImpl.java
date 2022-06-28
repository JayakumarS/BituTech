package com.bitutech.bor;

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
public class BorDaoImpl implements BorDao{
	 
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// save
	@Override
	
	public BorResultBean save(BorBean Bean) throws Exception {
		BorResultBean resultBean = new BorResultBean();
		resultBean.setSuccess(false);
		try {
			
			String borNo1 = jdbcTemplate.queryForObject(BorQueryUtil.GetborNo,String.class);
			   
			//Integer idNo = jdbcTemplate.queryForObject(BorQueryUtil.INSERT_BILL_OF_OPERATION,new BeanPropertyRowMapper<Integer>(Integer.class), new Object[]
		//{ Bean.getborNo(),Bean.getBomRef(),Bean.getProductName(),Bean.getDate()},Integer.class);
			String borNo = jdbcTemplate.queryForObject(BorQueryUtil.INSERT_BOR_HDR, new Object[] {borNo1 , Bean.getBooNo(),Bean.getProductName(),Bean.getDate()}, String.class);
		if(!borNo.isEmpty()) {
			if(Bean.getBorDetailBean().size()>0) {
				for(BorDetailBean borDetailBean: Bean.getBorDetailBean() ) {
					Map<String, Object> dtlMap = new HashMap<>();
					dtlMap.put("borNo",borNo);
					dtlMap.put("resourseName",borDetailBean.getResourseName());
					dtlMap.put("percentageOfAllocate",borDetailBean.getPercentageOfAllocate());
					dtlMap.put("noOfDays",borDetailBean.getNoOfDays());
					dtlMap.put("cost",borDetailBean.getCost());
					
					namedParameterJdbcTemplate.update(BorQueryUtil.INSERT_BOR_DETAIL,dtlMap);
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
	public List<BorBean> getBooList() throws Exception {
		List<BorBean> objCustomerMasterBean = new ArrayList<BorBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(BorQueryUtil.getBorList, new BeanPropertyRowMapper<BorBean>(BorBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	//edit
	@Override
	public BorResultBean edit(String bean) throws Exception {
		BorResultBean resultBean = new BorResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setBorBean(jdbcTemplate.queryForObject(BorQueryUtil.SELECT_BOR_HDR,new Object[] { bean }, new BeanPropertyRowMapper<BorBean>(BorBean.class)));
			resultBean.setBorDetailBean(jdbcTemplate.query(BorQueryUtil.SELECT_BOR_DTL,new Object[] { bean }, new BeanPropertyRowMapper<BorDetailBean>(BorDetailBean.class)));
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
	public BorResultBean update(BorBean Bean) throws Exception {
		BorResultBean resultBean = new BorResultBean();
		try {
			
			jdbcTemplate.queryForObject(BorQueryUtil.UPDATE_BOR_HDR,new BeanPropertyRowMapper<BorBean>(BorBean.class), new Object[]
					{ Bean.getBorNo(),Bean.getBooNo(),Bean.getProductName(),Bean.getDate(), Bean.getBorNo()});
			
			
			String borNo = 	Bean.getBorNo();
			
			if(Bean.getBorDetailBean().size()>0) { 
				
				jdbcTemplate.update(BorQueryUtil.DELETE_BOR_DTL,borNo);
				
				for(BorDetailBean borDetailBean: Bean.getBorDetailBean() ) {
					Map<String, Object> dtlMap = new HashMap<>();
				
					dtlMap.put("borNo",borNo);
					dtlMap.put("resourseName",borDetailBean.getResourseName());
					dtlMap.put("percentageOfAllocate",borDetailBean.getPercentageOfAllocate());
					dtlMap.put("noOfDays",borDetailBean.getNoOfDays());
					dtlMap.put("cost",borDetailBean.getCost());
					namedParameterJdbcTemplate.update(BorQueryUtil.INSERT_BOR_DETAIL,dtlMap);
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
	public BorResultBean delete(String borNo) throws Exception {
		BorResultBean resultBean = new BorResultBean();
		try {
			if(borNo!=null) {
				jdbcTemplate.update(BorQueryUtil.DELETE_BOR,borNo);
				jdbcTemplate.update(BorQueryUtil.DELETE_BOR_DTL,borNo);
				
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;	
		}

//	@Override
//	public BorResultBean getBorNo() throws Exception {
//		// TODO Auto-generated method stub
//		BorResultBean resultBean = new BorResultBean();
//		String borNo = jdbcTemplate.queryForObject(BorQueryUtil.GetborNo,String.class);
//		resultBean.setBorNo(borNo);
//		return resultBean;
//	}

	@Override
	public BorResultBean getBooNo() throws Exception {
		// TODO Auto-generated method stub
		List<DropDownList> booNo = new ArrayList<>();
		BorResultBean resultBean = new BorResultBean();
		try {
			booNo = jdbcTemplate.query(BorQueryUtil.getbooNoList,new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
			resultBean.setBooNo(booNo);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}


}
