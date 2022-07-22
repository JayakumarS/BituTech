package com.bitutech.salescallentry;

public class SalesEntryMasterQueryUtil {

	
	public static final String INSERT_SALESENTRY_HDR = "Insert into salescall_hdr (customer,customer_type,sales_call_number,type_of_call,person_met,assign_to,email_id,mode_of_contact,designation,visit_date,created_by,created_date)"
			+ " values (:customer,:customerType,:typeOfCall,:typeOfCall,:personMet,:assignTo,:emailId,:modeOfContact,:designation,to_date(:visitDate,'YYYY-MM-DD'),'E0001',now()) RETURNING salescall_hdr_id as  salesCallHdrId";
	
	public static final String getList = "select customer_type as customerType, salescall_hdr_id as salesCallHdrId, co.customer_name as customer,type_of_call as typeOfCall, assign_to as assignTo, person_met as personMet, to_char(created_date,'YYYY-MM-DD') as visitDate from salescall_hdr sh left join customer co on co.customer_code = sh.customer ";
//	public static final String GETSALESCALLHDRID = "select * from fn_generate_reference_no('salescall_hdr','salescall_hdr_id','SALESCALL','4')";
	public static final String SELECT_SALESENTRY_HDR = "select customer_type as customerType,salescall_hdr_id as salesCallHdrId, customer as customer,type_of_call as typeOfCall,email_id as emailID,mode_of_contact as modeOfContact,designation as designation, assign_to as assignTo, person_met as personMet, to_char(visit_date,'YYYY-MM-DD') as visitDate from salescall_hdr where salescall_hdr_id=? ";
	public static final String UPDATE_SALESENTRY_HDR = "update salescall_hdr set customer_type=:customerType, salescall_hdr_id=:salesCallHdrId, customer=:customer,type_of_call=:typeOfCall,email_id=:emailId,mode_of_contact=:modeOfContact,designation=:designation, assign_to=:assignTo, person_met=:personMet where salescall_hdr_id=:salesCallHdrId";
	public static final String DELETE_SALESENTRY_HDR = "delete from salescall_hdr where salescall_hdr_id=?";

	public static final String INSERT_SALESENTRY_DTL = "Insert into salescall_dtl_obj (salescall_hdr_id,objective,salescall_obj_date,status,next_call_date,commodity,conditions,support,not_support,remarks,created_by,created_date)"
			+ " values (:salesCallHdrId,:objective,to_date(:date,'YYYY-MM-DD'),:status,to_date(:nextCallDate,'YYYY-MM-DD'),:commodity,:conditionSupport,:reasonSupport,:reasonNotSupport,:remarks,'E0001',now())";

	public static final String DELETE_SALESENTRY_DTL = "delete from salescall_dtl_obj where salescall_hdr_id=?";

	public static final String SELECT_SALESENTRY_DTL = "select salescall_hdr_id as salesCallHdrId,objective as objective,to_char(salescall_obj_date,'YYYY-MM-DD') as date,status as status,to_char(next_call_date,'YYYY-MM-DD') as nextCallDate,commodity as commodity,conditions as conditionSupport,support as reasonSupport,not_support as reasonNotSupport,remarks as remarks from salescall_dtl_obj where salescall_hdr_id=? ";


	

}
