package com.bitutech.uom;

public class UomQueryUtil {

	public static final String INSERT_UOM = "INSERT into uom (uom,uom_description,uom_category_code,created_by,created_date) "
			+ " values(:unitMeasure,:description,:uomCategory,'E0001',now())";
	public static final String getUomList = "select uom_id as ID, uom as unitMeasure,uom_category_code as uomCategory,uom_description as description from uom";
	public static final String getUomcategoryList = "select uomcategory_code as id,uomcategory_name as text from uom_category";
	public static final String UPDATE_UOM= "update uom set uom=?,uom_category_code=?,uom_description=? where uom_id=?";
	public static final String DELETE_UOM = "delete from uom where uom_id=?";
	public static final String SELECT_UOM = "select uom as unitMeasure,uom_category_code as uomCategory,uom_description as description from uom where uom_id=?";


}
