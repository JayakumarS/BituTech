package com.bitutech.purchaserequest;

public class PurchaseRequestQueryUtil {
//PR HDR
	public static final String INSERT_PURCHASE_REQUISITION = "INSERT into purchase_requisition (requisition_number,company_code,request_type,requisition_date,source_location,remarks,destination_location,requested_by,pr_request_number,costcenter,created_by,created_date) "
			+ " values(:requisitionNo,:company,:requestType,to_date(:requestDate,'YYYY-MM-DD'),:sourceLocation,:jobTitle,:destinationLocation,:requestedBy,:prReqNo,:costCenter,'E0001',now()) Returning purchase_requisition_id as requisitionId";
	public static final String getPurchaseRequestList = "select remarks as jobTitle, purchase_requisition_id as requisitionId,requisition_number as requisitionNo,company_code as company,request_type as requestType,to_char(requisition_date,'DD/MM/YY') as requestDate, source_location as sourceLocation,destination_location as destinationLocation,requested_by as requestedBy,pr_request_number as prReqNo,costcenter as costCenter from purchase_requisition  ";
//	public static final String getUomcategoryList = "select uomcategory_codes as id,uomcategory_name as text from uom_category";
	public static final String SELECT_PURCHASE_REQUISITION = "select requisition_number as requisitionNo,remarks as jobTitle,purchase_requisition_id as requisitionId,company_code as company, request_type as requestType,to_char(requisition_date,'YYYY-MM-DD') as  requestDate, source_location as sourceLocation,destination_location as destinationLocation,requested_by as requestedBy,pr_request_number as prReqNo,costcenter as costCenter from purchase_requisition where purchase_requisition_id=?";
	public static final String UPDATE_PURCHASE_REQUISITION = "update purchase_requisition set company_code=:company,requisition_number=:requisitionNo,pr_request_number=:prReqNo,remarks=:jobTitle,request_type=:requestType,requisition_date= to_date(:requestDate,'YYYY-MM-DD'),source_location=:sourceLocation,requested_by=:requestedBy,destination_location=:destinationLocation,costcenter=:costCenter where purchase_requisition_id=:requisitionId ";
	public static final String DELETE_PURCHASE_REQUISITION = "delete from purchase_requisition where purchase_requisition_id=?";

	public static final String getRequisitionNoList =  "select requisition_number as id,requisition_number as text from purchase_requisition ";
	
	public static final String getRequisitionNo = "select replace(concat('PR',to_char(coalesce(max(replace(requisition_number, 'PR','')::int),\n"
			+ "0)+1, '0000')), ' ','') from purchase_requisition";
	
	// PR detail
	public static final String INSERT_PURCHASE_REQUISITION_DETAIL ="INSERT into purchase_requisition_detail (purchase_requisition_id,item_id,item_desc,pending_quantity,quantity,altuom,altqty,edd,created_by,created_date) "
			+ " values(:requisitionId,:itemId,:itemDesc,:pendingQuantity,:quantity,:altuom,:altqty,to_date(:edd,'YYYY-MM-DD'),'E0001',now())";
	public static final String SELECT_PURCHASE_REQUISITION_DTL = "select purchase_requisition_id as requisitionId,item_id as itemId,item_desc as itemDesc,pending_quantity as pendingQuantity,quantity as quantity,altuom as altuom,altqty as altqty,to_char(edd,'DD/MM/YY') as edd from purchase_requisition_detail where purchase_requisition_id=?";
	public static final String DELETE_PURCHASE_REQUISITION_DETAIL = "delete from purchase_requisition_detail where purchase_requisition_id=?";

	
}
