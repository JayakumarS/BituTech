package com.bitutech.billofmaterial;

public class BillOfMaterialQueryUtil {

	public static final String getList = " select workorder_no as workorderNo,to_char(created_date,'DD/MM/YYYY') as date,bom_no as bomNo from bom_hdr order by workorder_no desc";
	
	public static final String Insert_Bom_Hdr = "INSERT INTO bom_hdr (customer_code,bom_no,workorder_no,created_by,created_date) "
			+ " values (:customer,:bomNo,:workorderNo,'E0001',now()) returning bom_no as bomNo ";
	
	public static final String GetBooNumber = "select * from fn_generate_reference_no('bom_hdr','bom_no','BOM',4)";
	
	public static final String getWorkOrderList = "select workorder_no as id,workorder_no as text from workorder_hdr ";
	
	public static final String Insert_Bom_Dtl = "INSERT INTO bom_dtl (bom_no,availability,item_id,uom,quantity,created_by,created_on) "
			+ " values (:bomNo,:availability,:itemId,:uomId,:quantity,:createdBy,now()) ";

	public static final String Update_Bom_Hdr = "update bom_hdr set customer_code=:customer, bom_no=:bomNo,workorder_no=:workorderNo where bom_no=:bomNo Returning bom_no as bomNo";

	public static final String DELETE_BOM_HDR = "delete from bom_hdr where bom_no=?";

	public static final String SELECT_Bom_Hdr = "select customer_code as customer, bom_no as bomNo,workorder_no as workorderNo from bom_hdr where bom_no=?";

	public static final String SELECT_Bom_dtl = "select bd.item_id::Integer as id,it.item_name as text,bd.quantity as quantity,bd.availability as availability from bom_dtl bd left join item it on it.item_id = bd.item_id::Integer where bom_no=?";

	public static final String DELETE_BOM_DTL = "delete from bom_dtl  where bom_no=?";

	public static final String SELECT_Bill_Of_Material = "select customer_code as customer,workorder_no as workorderNo from workorder_hdr where customer_code=?";

}
