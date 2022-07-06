package com.bitutech.userRights;

public class UserRightsQueryUtil {



	public static final String getUomList = "select uom_id as id,uom as text from uom";

	public static final String getItemList = "select item_id as id,item_name as text from item";
	
	public static final String getUserList = "SELECT  concat(reference_id, concat(' - ',user_id)) as text,reference_id as id  FROM auth.app_user where reference_id is not null ";
	
	public static final String getCompanyList = "SELECT  concat(company_code, concat(' - ',company_name)) as text,company_code as id  FROM company where company_code is not null";
	
	public static final String getModuleList = "SELECT MODULE_CODE, MODULE_NAME, MODULE_CODE AS id, MODULE_NAME as text, DISPLAY_ORDER, IMAGE_ICON_URL FROM auth.module WHERE MODULE_CODE != 'M0000'";
	
	public static final String getuserFormList = "SELECT  concat(form_code, concat(' - ',form_name)) as text,form_code as id  FROM auth.form where form_code is not null ";
	
	public static final String getPropertyList = "SELECT PROPERTY_CODE,PROPERTY_NAME FROM auth.PROPERTY ORDER BY DISPLAY_ORDER ASC ";
	
	
	public static final String GET_COMPANY_USER_ID ="SELECT COMPANY_USER_ID FROM COMPANY_user WHERE  COMPANY_CODE = ? AND USER_ID = ?";
	
	
	public static String FORM_PROPERTY_LIST_FROM_USER_RIGHTS = "SELECT FORM_PROPERTY_ID FROM auth.USER_RIGHTS WHERE COMPANY_USER_ID =?";
	
	
	public static final String FORM_CODE_LIST_FROM_USER_RIGHTS = "SELECT FORM_CODE FROM auth.FORM_PROPERTY WHERE FORM_PROPERTY_ID IN(SELECT FORM_PROPERTY_ID FROM auth.USER_RIGHTS WHERE COMPANY_USER_ID =? )";
	
	
	public static String GET_FORM_MASTER_PARENT_LIST = " SELECT  FORM_CODE,FORM_NAME, DISPLAY_ORDER, IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT, FORM_URL,IS_PARENT FROM auth.form  WHERE MODULE_CODE IN (?)  AND IS_PARENT = ? and IS_ACTIVE='Y'  ORDER BY FORM_CODE ASC";
	
	
	public static String GET_PROPERTY_MASTER_LIST = "SELECT PROPERTY_CODE,PROPERTY_NAME FROM auth.PROPERTY ORDER BY DISPLAY_ORDER ASC";
	
	
	public static final String GET_FORM_MASTER_PARENT_LIST_BASE = "SELECT FORM_CODE,FORM_NAME, DISPLAY_ORDER,\r\n"
			+ "			IMAGE_ICON_URL, MODULE_CODE,FORM_CODE_PARENT,FORM_URL,\r\n"
			+ "			 IS_PARENT FROM auth.form where MODULE_CODE IN (?) and FORM_CODE \r\n"
			+ "			in(SELECT distinct FORM_CODE_PARENT\r\n"
			+ "			 FROM auth.form fm inner join auth.FORM_PROPERTY fp on fm.FORM_CODE=fp.FORM_CODE\r\n"
			+ "			 inner join auth.user_rights ur on ur.FORM_PROPERTY_ID=fp.FORM_PROPERTY_ID\r\n"
			+ "			 inner join company_user cu on cu.company_user_id=ur.company_user_id where cu.is_primary=1) and IS_ACTIVE='Y'";
	
	
	public static final String sCheckEmployeeCompny = "select count(company_code) as ct from COMPANY_USER where company_code = ? and user_id = ?";
	
	public static final String parentCode = "Y";
	
	public static final String childCode = "N";
	
	public static String GET_FORM_MASTER_CHILD_LIST = "SELECT   FORM_CODE,FORM_NAME,DISPLAY_ORDER,IMAGE_ICON_URL,MODULE_CODE,FORM_CODE_PARENT,FORM_URL, IS_PARENT  FROM auth.form  WHERE MODULE_CODE = ?  AND FORM_CODE_PARENT = ? AND IS_PARENT = ? and IS_ACTIVE='Y'  ORDER BY DISPLAY_ORDER ASC";
	
	
	public static String GET_FORM_PROPERTY_LIST = "SELECT FORM_PROPERTY_ID,fp.FORM_CODE,fp.PROPERTY_CODE FROM auth.form_property fp inner join auth.form f on f.form_Code = fp.form_code and IS_ACTIVE='Y' WHERE fp.FORM_CODE = ? ORDER BY PROPERTY_CODE ASC";
}
