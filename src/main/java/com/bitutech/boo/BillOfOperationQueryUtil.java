package com.bitutech.boo;

public class BillOfOperationQueryUtil {
	
	public static final String INSERT_BILL_OF_OPERATION = "INSERT INTO bill_of_operation (boo_no,bom_ref_no,product_name,opn_date)values(?,?,?,to_date(?,'YYYY-MM-DD')) Returning boo_no as booNo";
	
	public static final String INSERT_BILL_OF_OPERATION_DETAIL = "INSERT INTO bill_of_operation_detail (boo_no,process_seq_no,process_name,apporox_time,approx_cost,remarks)values(:booNo,:processSeqNo,:processName,:approxTime,:approxCost,:processRemarks)";
	
	public static final String getBooList = "select boo_no as booNo,bom_ref_no as bomRef,it.item_name as productName,to_char(opn_date,'DD/MM/YY') as date,id as idNo from bill_of_operation bo left join item it on it.item_id = bo.product_name::Integer";
	
	public static final String GetBooNo = "select * from fn_generate_reference_no('bill_of_operation','boo_no','BOO',4)";
	
	public static final String SELECT_BILL_OF_OPERATION = "select id as idNo,boo_no as booNo,bom_ref_no as bomRef,product_name as productName,opn_date as date from bill_of_operation where boo_no=?";
	
	public static final String UPDATE_BILL_OF_OPERATION = "update bill_of_operation set boo_no=?, bom_ref_no=?,product_name=?,opn_date= to_date(?,'YYYY-MM-DD') where boo_no=? Returning boo_no as booNo";
	
	public static final String DELETE_BILL_OF_OPERATION = "delete from bill_of_operation where boo_no=?";

	public static final String SELECT_BILL_OF_OPERATION_DTL = "select process_seq_no as processSeqNo,process_name as processName,apporox_time as approxTime,approx_cost as approxCost,remarks as processRemarks from  bill_of_operation_detail where boo_no = ?";

	public static final String DELETE_BOO_DTL = "delete from bill_of_operation_detail where boo_no = ? ";
	
	public static String getBooNoList = "select bom_no as id,bom_no as text from bom_hdr ";
	
}
		