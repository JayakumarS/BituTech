package com.bitutech.bor;

public class BorQueryUtil {

	public static final String getBorList = "select bor_no as borNo,boo_no as booNo,it.item_name as productName,to_char(opn_date,'DD/MM/YY') as date,id as idNo from bor_hdr bor left join item it on it.item_id = bor.product_name::Integer";
	public static final String GetborNo =  "select * from fn_generate_reference_no('bor_hdr','bor_no','BOR',4)";
	public static final String getbooNoList = "select boo_no as id,boo_no as text from bill_of_operation ";
    //BOR HDR
    public static final String INSERT_BOR_HDR = "INSERT INTO bor_hdr (bor_no,boo_no,product_name,opn_date)values(?,?,?,to_date(?,'YYYY-MM-DD')) Returning bor_no as borNo";
	public static final String SELECT_BOR_HDR = "select bor_no as borNo,boo_no as booNo,product_name as productName,opn_date as date from bor_hdr where bor_no=?";
	public static final String UPDATE_BOR_HDR = "update bor_hdr set bor_no=?, boo_no=?,product_name=?,opn_date= to_date(?,'YYYY-MM-DD') where bor_no=? Returning bor_no as borNo";
	public static final String DELETE_BOR =  "delete from bor_hdr where bor_no=?";
	//BOR DETAIL
	public static final String INSERT_BOR_DETAIL = "insert into bor_dtl (bor_no,resource_name,percentage_of_allocate,no_of_day,cost)values(:borNo,:resourseName,:percentageOfAllocate,:noOfDays,:cost)";
	public static final String SELECT_BOR_DTL ="select bor_no as borNo,resource_name as resourseName,percentage_of_allocate as percentageOfAllocate,no_of_day as noOfDays ,cost as cost from bor_dtl where bor_no=?";
	public static final String DELETE_BOR_DTL ="delete from bor_dtl where bor_no=?";

}
