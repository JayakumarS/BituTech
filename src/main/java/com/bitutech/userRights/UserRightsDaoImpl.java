package com.bitutech.userRights;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.core.util.CustomException;
import com.bitutech.core.util.DropDownList;
import com.bitutech.formProperty.FormPropertyBean;

@Repository
public class UserRightsDaoImpl implements UserRightsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	



	

	@Override
	public List<UserRightsBean> getuserList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getUserList, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userRightsBean;
	}
	
	
	@Override
	public List<UserRightsBean> getCompanyList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getCompanyList, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userRightsBean;
	}
	

	@Override
	public List<UserRightsBean> getModuleList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getModuleList, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userRightsBean;
	}
	
	
	
	@Override
	public List<UserRightsBean> getPropertyList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getPropertyList, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userRightsBean;
	}
	
	

	@Override
	public List<UserRightsBean> getuserFormList() throws Exception {
		List<UserRightsBean> userRightsBean = new ArrayList<UserRightsBean>();
		try {
			userRightsBean = jdbcTemplate.query(UserRightsQueryUtil.getuserFormList, new BeanPropertyRowMapper<UserRightsBean>(UserRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userRightsBean;
	}
	
	
	@Override
	public List<FormMasterBean> getFormMasterListByCompanyUser(String userId, String companyCode, String moduleCode)
			throws CustomException {
		Integer companyUserId = getCompanyUserId(companyCode, userId);
		List<Integer> lFormPropertyIdActive = getlFormPropIdByCompUser(companyUserId);
		List<String> lFormCodeActive = getlFormCodeByCompUser(companyUserId);

		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		List<PropertyMasterBean> lPropertyMasterBean = getPropertyMasterBeanList();
		try {

			int value = jdbcTemplate.queryForObject(UserRightsQueryUtil.sCheckEmployeeCompny, Integer.class,
					companyCode, userId);
			if (value > 0) {
				System.out.println("Base Company");
				for (FormMasterBean formMasterBean : getFormMasterListByModuleCode(moduleCode, "", true)) {
					lFormMasterBean.add(formMasterBean );
					for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCode(moduleCode,
							formMasterBean.getFormCode(), false)) {
						Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
								formMasterBeanChild.getFormCode());
						for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
							if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
								FormPropertyBean formPropertyBean = mFormPropertyBean
										.get(propertyMasterBean.getPropertyCode());
								formPropertyBean.setEnabled(
										lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
						
							} else {
								FormPropertyBean formPropertyBean = new FormPropertyBean();
								formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
								formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
								formPropertyBean.setFormPropertyId(0);
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							}
						}
						
						lFormMasterBean.add(formMasterBeanChild);
					}
				}
			} else {
				System.out.println("Other Company");
				for (FormMasterBean formMasterBean : getFormMasterListByModuleCodeBase(moduleCode, "", true)) {
					
					lFormMasterBean.add(formMasterBean);
					for (FormMasterBean formMasterBeanChild : getFormMasterListByModuleCodeBase(moduleCode,
							formMasterBean.getFormCode(), false)) {
						Map<String, FormPropertyBean> mFormPropertyBean = getFormPropertyBeanMapByFormCode(
								formMasterBeanChild.getFormCode());
						for (PropertyMasterBean propertyMasterBean : lPropertyMasterBean) {
							if (mFormPropertyBean.containsKey(propertyMasterBean.getPropertyCode())) {
								FormPropertyBean formPropertyBean = mFormPropertyBean
										.get(propertyMasterBean.getPropertyCode());
								formPropertyBean.setEnabled(
										lFormPropertyIdActive.contains(formPropertyBean.getFormPropertyId()));
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							} else {
								FormPropertyBean formPropertyBean = new FormPropertyBean();
								formPropertyBean.setFormCode(formMasterBeanChild.getFormCode());
								formPropertyBean.setPropertyCode(propertyMasterBean.getPropertyCode());
								formPropertyBean.setFormPropertyId(0);
								formMasterBeanChild.setFormPropertyBean(formPropertyBean);
							}
						}

						lFormMasterBean.add(formMasterBeanChild);
					}
				}
			}
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
		return lFormMasterBean;
	}
	
	
	public List<PropertyMasterBean> getPropertyMasterBeanList() throws CustomException {
		List<PropertyMasterBean> lPropertyMasterBean = new ArrayList<PropertyMasterBean>();
		try {
			lPropertyMasterBean = jdbcTemplate.query(UserRightsQueryUtil.GET_PROPERTY_MASTER_LIST,
					new BeanPropertyRowMapper<PropertyMasterBean>(PropertyMasterBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lPropertyMasterBean;
	}

	public int getCompanyUserId(String companyCode, String userId) throws CustomException {
		String companyUserId = "";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_COMPANY_USER_ID,
				new Object[] { companyCode, userId });
		
		companyUserId = companyUserId.equals("") ? "0" : companyUserId;
		return Integer.parseInt(companyUserId);
	}
	
	
	
	public List<Integer> getlFormPropIdByCompUser(int companyUserId) throws CustomException {
		List<Integer> formPropertyIdList = new ArrayList<Integer>();

		try {
			formPropertyIdList = jdbcTemplate.query(UserRightsQueryUtil.FORM_PROPERTY_LIST_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getInt(1);
						}
					});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return formPropertyIdList;
	}
	
	

	public List<String> getlFormCodeByCompUser(int companyUserId) throws CustomException {

		List<String> formCodeList = new ArrayList<String>();

		try {
			formCodeList = jdbcTemplate.query(UserRightsQueryUtil.FORM_CODE_LIST_FROM_USER_RIGHTS,
					new Object[] { companyUserId }, new RowMapper<String>() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString(1);
						}
					});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return formCodeList;
	}
	
	
	public List<FormMasterBean> getFormMasterListByModuleCode(String moduleCode, String formCode, boolean isParent)
			throws CustomException {
		List<Map<String, Object>> lRow = new ArrayList<>();
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		if (isParent) {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_PARENT_LIST,
					new Object[] { moduleCode, UserRightsQueryUtil.parentCode });
		} else {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_CHILD_LIST,
					new Object[] { moduleCode, formCode, UserRightsQueryUtil.childCode });
		}
		for (Map<String, Object> row : lRow) {
			FormMasterBean formMasterBean = new FormMasterBean();
			formMasterBean.setFormCode((String) row.get("FORM_CODE"));
			formMasterBean.setFormName((String) row.get("FORM_NAME"));
			formMasterBean.setDisplayOrder(Integer.valueOf(String.valueOf(row.get("DISPLAY_ORDER"))));
			formMasterBean.setImageIconUrl((String) row.get("IMAGE_ICON_URL"));
			formMasterBean.setModuleCode((String) row.get("MODULE_CODE"));
			formMasterBean.setFormCodeParent((String) row.get("FORM_CODE_PARENT"));
			formMasterBean.setFormUrl((String) row.get("FORM_URL"));
			formMasterBean.setIsParent((String) row.get("IS_PARENT"));
			lFormMasterBean.add(formMasterBean);
		}
		return lFormMasterBean;
	}
	
	
	public Map<String, FormPropertyBean> getFormPropertyBeanMapByFormCode(String formCode) {
		Map<String, FormPropertyBean> mFormPropertyBean = new HashMap<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_PROPERTY_LIST,
					new Object[] { formCode });
			for (Map<String, Object> row : rows) {
				FormPropertyBean objFormPropertyBean = new FormPropertyBean();
				
				
				objFormPropertyBean.setFormPropertyId(Integer.valueOf(String.valueOf(row.get("FORM_PROPERTY_ID"))));
				objFormPropertyBean.setFormCode((String) row.get("FORM_CODE"));
				objFormPropertyBean.setPropertyCode((String) row.get("PROPERTY_CODE"));
				objFormPropertyBean.setAvailable(true);
				mFormPropertyBean.put(objFormPropertyBean.getPropertyCode(), objFormPropertyBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mFormPropertyBean;
	}
	
	
	
	public List<FormMasterBean> getFormMasterListByModuleCodeBase(String moduleCode, String formCode, boolean isParent)
			throws CustomException {
		List<Map<String, Object>> lRow = new ArrayList<>();
		List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
		if (isParent) {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_PARENT_LIST_BASE,
					new Object[] { moduleCode });
		} else {
			lRow = jdbcTemplate.queryForList(UserRightsQueryUtil.GET_FORM_MASTER_CHILD_LIST,
					new Object[] { moduleCode, formCode, UserRightsQueryUtil.childCode });
		}
		for (Map<String, Object> row : lRow) {
			FormMasterBean formMasterBean = new FormMasterBean();
			formMasterBean.setFormCode((String) row.get("FORM_CODE"));
			formMasterBean.setFormName((String) row.get("FORM_NAME"));
			formMasterBean.setDisplayOrder(Integer.valueOf(String.valueOf(row.get("DISPLAY_ORDER"))));
			formMasterBean.setImageIconUrl((String) row.get("IMAGE_ICON_URL"));
			formMasterBean.setModuleCode((String) row.get("MODULE_CODE"));
			formMasterBean.setFormCodeParent((String) row.get("FORM_CODE_PARENT"));
			formMasterBean.setFormUrl((String) row.get("FORM_URL"));
			formMasterBean.setIsParent((String) row.get("IS_PARENT"));
			lFormMasterBean.add(formMasterBean);
		}
		return lFormMasterBean;
	}


}
