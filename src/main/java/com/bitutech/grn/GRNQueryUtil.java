package com.bitutech.grn;

public class GRNQueryUtil {

	public static final String GRN_REQUISITION = "select purchase_requisition_id as id,concat(requisition_number,'-',pr_request_number) as text,to_char(requisition_date,'YYYY-MM-DD') poRequisitionDate from purchase_requisition where purchase_requisition_id in (select purchase_requisition_id from purchase_quote_detail where purchase_quote_detail_id in (select distinct podtl.purchase_quote_detail_id from purchase_order_detail podtl where podtl.purchase_order_id =?))";
	
	public static final String GRN_REQ_DTL = "select po.purchase_requisition_id poId,po.requisition_number poNo ,to_char(requisition_date,'YYYY-MM-DD') poDate,pod.item_id dtlItemId, coalesce(pod.quantity,0) dtlQty,itm.item_code dtlItemCode,itm.item_name dtlItemName,itm.item_description dtlItemDesc,coalesce(itm.uom,0) dtlUom from purchase_requisition po inner join purchase_requisition_detail pod on po.purchase_requisition_id = pod.purchase_requisition_id left join item itm on pod.item_id = itm.item_id where po.purchase_requisition_id in (select distinct purchase_requisition_id from purchase_quote_detail where purchase_quote_detail_id in (select distinct podtl.purchase_quote_detail_id from purchase_order_detail podtl where podtl.purchase_order_id =?))";

	public static final String GET_PO_LIST = "select purchase_order_id as id, po.location_id as locId,purchase_order_no as text,  "
			+ "value poType, coalesce(en.entity_id, 0),po.company_id companyId, "
			+ "location_name as dstLocName,coalesce(freight,0) poFreight,remarks_othercharges as remarksforother, "
			+ "COALESCE(freight,0) as freight,COALESCE(other_charges,0) as otherCharges "
			+ "from purchase_order po  "
			+ "left join def_table def on def.def_table_id = po.purchase_type  "
			+ "left join entity en on  en.supplier_acct_code = po.vendor_id  "
			+ "left join location using(location_id) "
			+ "where po_status in (?, ?)  order by purchase_order_id desc";//po.location_id as locId,

	public static final String GET_PO_DTL_LIST = "select coalesce(convertedQtyNew,0) as convertedQtyNew,coalesce(convertedQtyNew,0) as conqty, "
			+ "case when coalesce(balanceconvertedQtyNew,0)= 0 then coalesce(pod.purchase_qty,0) "
			+ "else coalesce(balanceconvertedQtyNew,0) end as balanceconvertedQtyNew, "
			+ "pod.purchase_order_detail_id dtlPODtlId,pod.cost_center as costcenter,pod.cost_center as costcenter,  "
			+ "po.purchase_order_id poId,po.purchase_order_no poNo ,to_char(po.purchase_date,'YYYY-MM-DD') poDate, "
			+ "pod.item_id dtlItemId, coalesce(pod.quantity,0) dtlQty,coalesce(pod.unit_price,0) dtlPrice,  "
			+ "itm.item_code dtlItemCode,itm.item_name dtlItemName,pqd.item_description dtlItemDesc,  "
			+ "case when quality_check is null then false  else quality_check end qualityCheck, "
			+ "coalesce(pod.discount,0) dtlDisc,coalesce(pod.tax_Amount,0) dtlTax,coalesce(pqd.vendor_uom,0) dtlUom, "
			+ "coalesce(pod.quantity,0) receivedQty, coalesce((coalesce(pod.quantity,0)-coalesce(grnQty.qty,0)),0) pendingQty, "
			+ "pod.quantity as originalConvertedQty,coalesce(pqd.purchase_quantity,0) as purReqQuantity, "
			+ "coalesce(pqd.quantity,0) as vendorQuantity , "
			+ "pred.purchase_requisition_detail_id as reqDetailId,  0 as batchNoExist,coalesce(pod.discount,0) discountAmount, "
			+ "coalesce(pod.tax_cgst,0) as taxCGST, coalesce(pod.tax_sgst,0) as taxSGST, coalesce(pod.tax_igst,0) as taxIGST, "
			+ "coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent, coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent, "
			+ "coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent ,coalesce(pod.discount_type,0) as discountType , "
			+ "coalesce(pod.discount_percent,0) as discountPercentage, coalesce(pod.purchase_uom,0)::text as purchaseUOM, "
			+ "coalesce(pod.purchase_qty,0) as purchaseQty , "
			+ "(select uom from uom where uom_id = pod.purchase_uom limit 1)  as purchaseUOMName, "
			+ "case when null_or_empty(pod.vendor_uom::text) = false then coalesce(pod.vendor_uom,0) else  coalesce(pqd.vendor_uom) end "
			+ "as vendorUOM, coalesce(pod.quantity,0) as vendorQty ,  "
			+ "(select uom from uom where uom_id = case when null_or_empty(pod.vendor_uom::text) = false then coalesce(pod.vendor_uom,0) "
			+ " else  coalesce(pqd.vendor_uom,0) end  limit 1)  as vendorUOMName "
			+ " from purchase_order po "
			+ " inner join purchase_order_detail pod on po.purchase_order_id = pod.purchase_order_id  "
			+ " inner join item itm on pod.item_id = itm.item_id "
			+ " left join item_category itc on itm.item_category = itc.item_category_id  "
			+ " left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id  "
			+ " left join purchase_requisition prd on prd.purchase_requisition_id = pqd.purchase_requisition_id  "
			+ " left join purchase_requisition_detail pred  on pred.purchase_requisition_id = prd .purchase_requisition_id  "
			+ " left join (select  grn.item_id, grn.qty,pd.purchase_order_id,grn.purchase_order_detail_id, "
			+ "			coalesce(convertedQtyNew,0) as convertedQtyNew,coalesce(balanceconvertedQtyNew,0) as balanceconvertedQtyNew "
			+ "			from (select item_id,sum(quantity) qty,purchase_order_detail_id,sum(coalesce(converted_quantity_new,0))  "
			+ "				  as convertedQtyNew,sum(coalesce(converted_balance_quantity_new,0)) balanceconvertedQtyNew from grn_detail  "
			+ "				  group by item_id,purchase_order_detail_id having purchase_order_detail_id in  "
			+ "				  (select purchase_order_detail_id from purchase_order_detail where purchase_order_id = ?)) "
			+ "			grn left join purchase_order_detail pd on grn.purchase_order_detail_id = pd.purchase_order_detail_id)  "
			+ "			grnQty on grnQty.purchase_order_detail_id = pod.purchase_order_detail_id "
			+ "			where pred.Item_id = pqd.item_id and po.purchase_order_id = ? "
			+ "			order by pod.purchase_order_detail_id asc";

	public static final String GET_CONSIGNMENT_TRANSFER_DETAILS = "select coalesce(purchase_type,0)purchasetype,coalesce(consignment_transfer_id,0)consignmentTransferId from purchase_order where purchase_order_id=?";

	public static final String GET_PO_COUNT_IN_GRN = "select  count(*)  from grn  where purchase_order_id  = ?";

	public static final String GET_FREIGHT_OTHER_IN_GRN = "select COALESCE(sum(freight),0) as freight,COALESCE(sum(other_charges),0) as other_charges from grn  where purchase_order_id  = ?";

	public static final String GRN_LOC_LIST = "select location_id as id,location_name as text from location";

	public static final String GET_VENDOR_ADDRESS = "select coalesce(vendor_location,0) vendorLoc,street as address from entity left join address on address.address_id = entity.address_id where is_vendor = true and entity_id=?";

	public static final String GET_VENDOR_LIST = "select entity_id as id,entity_name as text,entity_id vendorId,entity_name vendorName,supplier_acct_code vendorCode from entity where is_vendor = true order by entity_name";

	public static final String GRN_AUTO_GENERATE = "SELECT CASE WHEN MAX(grn_number) IS NULL  THEN 'GRN0001' ELSE rpad(MAX(grn_number),3,'GRN')|| lpad(cast(cast((SUBSTRING(MAX(grn_number),4)) as int)+1  as text),4,'0') END FROM grn";

	public static final String SAVE_GRN_HDR = "INSERT INTO grn(grn_number, grn_date, purchase_order_id, purchase_requisition_id,entity_id, vendor_delivery_order_no, vendor_delivery_order_date, "
			+ " vendor_invoice_no, vendor_invoice_date, delivery_method, mode_of_transport,location_id,dest_location_id,company_id,invoice_due_date,description,freight ,other_charges,created_by, created_on) VALUES (?, TO_DATE(?,'DD-MM-YY'), ?, ?, ?,?, TO_DATE(?,'DD-MM-YY'), ?, TO_DATE(?,'DD-MM-YY'), ?, ?,?,?,?,TO_DATE(?,'DD-MM-YY'),?,?,?,?,now()) returning grn_id";

	public static final String GET_PO_CNT_IN_GRN = "select count(*) from grn where purchase_order_id = ?";

	public static final String SAVE_GRN_DTL = "INSERT INTO grn_detail(grn_id, item_id,cost_center, quantity, pending_qty,converted_quantity,purchase_order_detail_id,converted_quantity_new,converted_quantity_flag,converted_balance_quantity_new) VALUES (?,?,?,?,?,?,?,?,?,?) returning grn_detail_id";

	public static final String GET_PO_DTL_QTY = "select count(*) from grn_detail where purchase_order_detail_id = ?";

	public static final String UPDATE_PO_DTL_STATUS = "update purchase_order_detail set po_status =? where purchase_order_detail_id =?";

	public static final String GET_PO_STATUS = "select min(po_status) from purchase_order_detail where purchase_order_id =?";

	public static final String GET_PO_MAX_STATUS = "select max(po_status) from purchase_order_detail where purchase_order_id =?";

	public static final String UPDATE_PO_STATUS = "update purchase_order set po_status =? where purchase_order_id =?";

	public static final String CHECK_QC_FOR_ITEM = "select case when quality_check is null then false else quality_check end as qualityCheck from item_category ic inner join item it on ic.item_category_id = it.item_category where item_id = ?";

//	public static final String GET_QC_LOCATION ="select coalesce(qc_location_id,0) qcLocation from grn where grn_number =?";

	public static final String INVENTORY_EXISTS = "select count(*)  from inventory where location_id=? and item_id=?";

	public static final String GRN_LIST = "select grn_number grnCode,to_char(grn_date,'YYYY-MM-DD') grnDate,entity_name vendorName,purchase_order_no poNo,pr.requisition_number poRequisition,g.purchase_order_id poId,coalesce(po.purchase_type ,0) as purchaseType, (select emp_name from employee where emp_id = g.created_by limit 1) as preparedBy from grn g left join entity en on g.entity_id = en.entity_id left join purchase_order po on g.purchase_order_id = po.purchase_order_id left join purchase_requisition pr using (purchase_requisition_id) order by grn_number desc";

	public static final String MAX_INVENTORY = "select max(inventory_id) from inventory where location_id=? and item_id=?" ;

	public static final String GET_GRN_DTL = "select grn_id grnId, grn.grn_detail_id grnDtlId,grn.cost_center as costcenter,grn.item_id dtlItemId, "
			+ "coalesce(grn.quantity,0) dtlQty,coalesce(grn.pending_qty,0) pendingQty,coalesce(grn.quantity,0) dtlQty, "
			+ "coalesce(grn.pending_qty,0) pendingQty,grn.purchase_order_detail_id dtlPODtlId,coalesce(pqd.quantity,0) vendorQuantity, "
			+ "coalesce(pqd.purchase_quantity,0) purchaseQuantity, coalesce(pod.unit_price,0) dtlPrice,itm.item_code dtlItemCode, "
			+ "itm.item_name dtlItemName,pqd.item_description dtlItemDesc, "
			+ "case when quality_check is null then false else quality_check end qualityCheck, "
			+ "coalesce(itm.uom,0) dtlUom,coalesce(sample_qty,0) sampleQty, "
			+ "coalesce(qc_status,0) qcStatus,qc_remarks qcRemarks,coalesce(status,0) dtlStatus,qc_status as status, "
			+ "coalesce(grn.converted_quantity_new,0) convertedQty ,coalesce(pod.discount,0) discountAmount, "
			+ "coalesce(pod.tax_cgst,0) as taxCGST,coalesce(pod.tax_sgst,0) as taxSGST,coalesce(pod.tax_igst,0) as taxIGST, "
			+ "coalesce(pod.tax_cgst_percent,0) as taxCGSTinPercent,coalesce(pod.tax_sgst_percent,0) as taxSGSTinPercent, "
			+ "coalesce(pod.tax_igst_percent,0) as taxIGSTinPercent,coalesce(pod.discount_type,0) as discountType, "
			+ "coalesce(pod.discount_percent,0) as discountPercentage  , "
			+ "coalesce(grn.converted_quantity_new,0) as cnvtQty  from grn_detail grn "
			+ "left join purchase_order_detail pod on grn.purchase_order_detail_id = pod.purchase_order_detail_id "
			+ "left join purchase_quote_detail pqd on pqd.purchase_quote_detail_id = pod.purchase_quote_detail_id "
			+ "left join item itm on grn.item_id = itm.item_id "
			+ "left  join item_category itc on itm.item_category = itc.item_category_id "
			+ "where grn_id=(select grn_id from grn where grn_number = ?) order by grn.grn_detail_id";

	public static final String GET_GRN_HDR = "select grn_id grnId,grn_number grnCode,coalesce(grn.company_id,'') companyId,  "
			+ "to_char(grn_date,'YYYY-MM-DD') grnDate, grn.purchase_order_id as poId,po.purchase_order_no poNo,  "
			+ "CASE WHEN po_amendment IS NULL THEN '' ELSE po_amendment END  as poAmendNo, "
			+ "grn.purchase_requisition_id poRequisitionId, pr.requisition_number as poRequisition, en.entity_id  vendorId, en.entity_name vendorName ,vendor_delivery_order_no delOrderNo,  "
			+ "to_char(vendor_delivery_order_date,'YYYY-MM-DD') delOrderDate, vendor_invoice_no invoiceNo,  "
			+ "to_char(vendor_invoice_date,'YYYY-MM-DD') invoiceDate, grn.delivery_method deliveryMthd,  "
			+ "mode_of_transport transMode,grn.location_id locId,loc.location_name locName,  "
			+ "coalesce(grn.dest_location_id,0) dstLocId,dloc.location_name dstLocName, def.value poType,  "
			+ "coalesce(grn_status,0) grnStatus,to_char(invoice_due_date,'YYYY-MM-DD')  as dueDate , "
			+ "remarks_othercharges as remarksforother,COALESCE(po.freight,0) as freight,COALESCE(po.other_charges,0) as otherCharges, "
			+ "company_name as entity, (select entity_name from entity where entity_id= grn.entity_id) as vendorName, "
			+ "(select concat(address.street) as address from entity "
			+ " left join location on location.location_id = entity.vendor_location "
			+ " left join address on address.address_id = entity.address_id "
			+ " where entity_id=(select entity_id from entity where  entity_id=grn.entity_id limit 1))  "
			+ " as address  , (select contact_mobile from entity where entity_id=grn.entity_id) as vendorPhone,   "
			+ " (select emp_name from employee where emp_id = grn.created_by ), "
			+ " COALESCE(grn.freight,0) as grnfreight ,COALESCE(grn.other_charges,0) as grnOtherCharnge from grn grn  "
			+ "inner join purchase_order po on po.purchase_order_id = grn.purchase_order_id  left join purchase_requisition pr using (purchase_requisition_id) "
			+ "inner join location loc on loc.location_id = grn.location_id "
			+ "inner join location dloc on dloc.location_id = grn.dest_location_id "
			+ " left join def_table def on def.def_table_id = po.purchase_type  "
			+ "inner join entity en on grn.entity_id = en.entity_id "
			+ "inner join company c on c.company_code = grn.company_id  where grn.grn_number = ?";

	public static final String PO_SCHEDULE = "select ds.purchase_delivery_schedule_id scheduleId,ds.item_id scheduleItemId,itm.item_code scheduleItemCode,itm.item_name scheduleItemName,ds.item_qty scheduleQty,coalesce(ds.pending_qty,0) as scheduleItemQty,coalesce(ds.item_qty,0) - coalesce(ds.pending_qty,0) as scheduleReceivedQty,coalesce(ds.pending_qty,0) schedulePendingQty,to_char(ds.delivery_date,'YYYY-MM-DD') scheduleItemDate from purchase_order_delivery_schedule ds left join item itm on ds.item_id = itm.item_id where ds.purchase_order_detail_id = ? ";

	public static final String UPDATE_PO_SCHEDULE_STATUS = "update purchase_order_delivery_schedule set pending_qty=? where purchase_delivery_schedule_id =?";

	public static final String GET_ITEM_ATTRIBUTES = "select batch_no itemBatch,mrp itemMrp,expiry_date itemExpDate,manufacture_details itemManufacture from item_grn_attribute where item_id = ?";

	public static final String SAVE_GRN_BATCH_DTL = "INSERT INTO grn_batch_detail(grn_detail_id, item_id, batch_no, batch_qty, manufacturer, mrp_price,converted_quantity) VALUES (?, ?, ?, ?,?, ?,?)";

	public static final String GET_GRN_BATCH_DTL = "select grn.item_id batchItemId ,itm.item_code as batchItemCode,itm.item_name batchItemName,grn.batch_no lotNo,grn.batch_qty batchQty,to_char(grn.expiry_date,'YYYY-MM-DD') expiryDate,grn.manufacturer manufactureDef,grn.mrp_price mrp,grnd.qc_status status from grn_batch_detail grn left join item itm on grn.item_id = itm.item_id left join grn_detail grnd on grnd.grn_detail_id = grn.grn_detail_id where grn.grn_detail_id =?";

	public static final String DELETE_GRN_BATCH_DTL = "delete from grn_batch_detail where grn_detail_id = ?";

	public static final String COUNT_GRN_BATCH_DTL = "select count(*) from grn_batch_detail where grn_detail_id = ?";

	public static String SAVE_STOCK_LEDGER_BATCH = "INSERT INTO stock_ledger_detail(stock_ledger_id, item_id, batch_no, batch_qty, expiry_date, manufacturer, mrp_price, source_location_id,destination_location_id,destination_qty,source_qty) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	public static String SAVE_STOCK_LEDGER_NEW = "INSERT INTO stock_ledger( inventory_id, source_location_id, destination_location_id, source_qty, destination_qty, doc_date,doc_type,doc_ref) VALUES( ?, ?, ?,?,?,TO_DATE(?,'DD-MM-YY'),?,?) returning stock_ledger_id";

	public static String SAVE_INVENTORY = "INSERT INTO inventory( inventory_date, location_id, item_id,quantity_available) VALUES( TO_DATE(?,'DD-MM-YY'), ?, ?, ?)";

	public static String UPDATE_INVENTORY = "update inventory set inventory_date=TO_DATE(?,'DD-MM-YY'), quantity_available=? where item_id=? and location_id=? ";

	public static String INVENTORY_HAND_QUANTITY = "select CASE WHEN sum(quantity_available) IS NULL  THEN 0 ELSE sum(quantity_available) END  from inventory where location_id=? and item_id=? ";
		

}