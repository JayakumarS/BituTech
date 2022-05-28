package com.bitutech.purchase.LPO;

public class LpoQueryUtil {

	
//LPO_HDR
	public static final String INSERT_LPO_HDR = "Insert into purchase_order (purchase_order_no,purchase_date,purchase_for,purchase_type,vendor_id,location_id,terms_condition,remarks,payment_terms,advanceamt,currency_code,cost_center_id, request_type,po_type,sub_total,total_discount,total_cgst,total_sgst,total_igst,other_charges,remarks_othercharges,freight,freight_tax,freight_amount, total_tax,created_by,created_date)" 
	+ "values (:poNo,to_date(:poDate,'YYYY-MM-DD'),:purchaseFor,:purchaseType,:vendorId,:destinationLocation,:termsConditions,:remarks,:paymentTerms,:advance,:currency,:costCenter,:requestType,:woType,:subTotal,:discount,:cgst,:sgst,:igst,:otherCharges,:remarksOtherCharges,:freight,:freightTaxPercent,:freightTotal,:total,'E0001',now()) RETURNING purchase_order_id as purchaseOrderId ";
	public static final String SELECT_LPO_HDR = "select purchase_order_id as purchaseOrderId,purchase_order_no as poNo,to_char(purchase_date,'DD-MM-YYYY') as poDate,purchase_for as purchaseFor,purchase_type as purchaseType,vendor_id as vendorId,location_id as destinationLocation,terms_condition as termsConditions,remarks as remarks,payment_terms as paymentTerms,advanceamt as advance,currency_code as currency,cost_center_id as costCenter,request_type as requestType,po_type as woType,sub_total as subTotal,total_discount as discount,total_cgst as cgst,total_sgst as sgst,total_igst as igst,other_charges as otherCharges,remarks_othercharges as remarksOtherCharges,freight as freight,freight_tax as freightTaxPercent,freight_amount as freightTotal, total_tax  as total from purchase_order where purchase_order_id=? ";

	public static final String UPDATE_LPO_HDR = "update purchase_order set purchase_order_no=:poNo,purchase_date=to_date(:poDate,'YYYY-MM-DD'),purchase_for=:purchaseFor,purchase_type=:purchaseType,vendor_id=:vendorId,location_id=:destinationLocation,terms_condition=:termsConditions,remarks=:remarks,payment_terms=:paymentTerms,advanceamt=:advance,currency_code=:currency,cost_center_id=:costCenter,request_type=:requestType,po_type=:woType,sub_total=:subTotal,total_discount=:discount,total_cgst=:cgst,total_sgst=:sgst,total_igst=:igst,other_charges=:otherCharges,remarks_othercharges=:remarksOtherCharges,freight=:freight,freight_tax=:freightTaxPercent,freight_amount=:freightTotal, total_tax=:total  where purchase_order_id=:purchaseOrderId";

	public static final String DELETE_LPO_HDR = "delete from purchase_order where purchase_order_id=?";
	
	//LPO_DTL
	public static final String INSERT_LPO_DTL_ONE = "Insert into purchase_order_detail (purchase_requisition_number,item_id,item_description, purchase_uom,purchase_qty,vendor_uom,vendor_qty,unit_price,quantity,discount,discount_type,discount_percent,tax_cgst,tax_sgst,tax_igst,tax_cgst_percent,tax_sgst_percent,tax_igst_percent,tax_amount,purchase_order_id)"
				+ "values ( :requisitionNo,:item,:itemDescription,:purchaseUOM,:purchaseQty,:vendorUOM,:vendorQty,:unitPrice,:availableQty,:discount,:discountType,:discountPercent,:taxCGST,:taxSGST,:taxIGST,:taxCGSTinPercent,:taxSGSTinPercent,:taxIGSTinPercent,:finalTotal,:purchaseOrderId)";
	
	public static final String DELETE_LPO_DTL_ONE =" delete from purchase_order_detail where purchase_order_id=?";
	
	public static final String SELECT_LPO_DTL_ONE = "select purchase_requisition_number as requisitionNo,item_id as item,item_description as itemDescription,purchase_uom as purchaseUOM,purchase_qty as purchaseQty,vendor_uom as vendorUOM,vendor_qty as vendorQty,unit_price as unitPrice,quantity as availableQty,discount as discount,discount_type as discountType,discount_percent as discountPercent,tax_cgst as taxCGST,tax_sgst as taxSGST,tax_igst as taxIGST,tax_cgst_percent as taxCGSTinPercent,tax_sgst_percent as taxSGSTinPercent,tax_igst_percent as taxIGSTinPercent,tax_amount as finalTotal,purchase_order_id  as  purchaseOrderId  from purchase_order_detail where purchase_order_id=?";
	
//	public static final String DELETE_GRN_DTL =" delete from grn_detail where purchase_order_id=?";
	
	public static final String GET_PO_NO = "select * from fn_generate_reference_no('purchase_order','purchase_order_no','PO',4)";
	public static final String GET_VENDOR_ADDRESS = "select coalesce(vendor_location,0) vendorLoc,street as address from entity left join address on address.address_id = entity.address_id where is_vendor = true and entity_id=?";
	//public static final String GET_VENDOR_ADDRESS = "select ";
	public static final String REQUISITION = "select purchase_requisition_id as id,concat(requisition_number,'-',pr_request_number) as text,to_char(requisition_date,'YYYY-MM-DD') poRequisitionDate,purchase_requisition_id as requisitionId,company_code as company, request_type as requestType,to_char(requisition_date,'DD/MM/YY') as  requestDate, source_location as sourceLocation,destination_location as destinationLocation,requested_by as requestedBy,pr_request_number as prReqNo,costcenter as costCenter from purchase_requisition where purchase_requisition_id in (select purchase_requisition_id from purchase_quote_detail where purchase_quote_detail_id in (select distinct podtl.purchase_quote_detail_id from purchase_order_detail podtl where podtl.purchase_order_id =? ))";

	public static String GET_PO_NO_LIST = "select purchase_order_no as id,purchase_order_no as text from purchase_order ";
	
	public static String getList ="select purchase_order_id as purchaseOrderId,purchase_order_no as poNo,to_char(purchase_date,'DD-MM-YYYY') as poDate,request_type as requestType,vendor_id as vendorId from purchase_order";


	

}
