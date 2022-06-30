package com.bitutech.salesCallReport;

public class SalesCallReportQueryUtil {

	public static final String getList="";
	public static final String getByYearList = "select customer_type as customerType, salescall_hdr_id as salesCallHdrId, co.customer_name as customer,type_of_call as typeOfCall,\n"
			+ " assign_to as assignTo, person_met as personMet, to_char(created_date,'YYYY-MM-DD') as\n"
			+ " visitDate from salescall_hdr sh left join customer co on co.customer_code = sh.customer \n"
			+ " where to_char(sh.visit_date,'yyyy') = ? and salescall_hdr_id=?";
	public static final String getByQuarterList = "select customer_type as customerType, salescall_hdr_id as salesCallHdrId, co.customer_name as customer,type_of_call as typeOfCall,\n"
			+ " assign_to as assignTo, person_met as personMet, to_char(created_date,'YYYY-MM-DD') as\n"
			+ " visitDate from salescall_hdr sh left join customer co on co.customer_code = sh.customer \n"
			+ "WHERE to_char(sh.visit_date,'yyyy') = ? and  SUBSTR(to_char(sh.visit_date,'yyyy-MM'), 1, 7) >= ? and   SUBSTR(to_char(sh.visit_date,'yyyy-MM'), 1, 7) <= ? and salescall_hdr_id=?";
	public static final String getByMonthList = "select customer_type as customerType, salescall_hdr_id as salesCallHdrId, co.customer_name as customer,type_of_call as typeOfCall,\n"
			+ " assign_to as assignTo, person_met as personMet, to_char(created_date,'YYYY-MM-DD') as\n"
			+ " visitDate from salescall_hdr sh left join customer co on co.customer_code = sh.customer \n"
			+ "where SUBSTR(to_char(sh.visit_date,'yyyy-MM'), 1, 7) =? and salescall_hdr_id=?";
	public static final String getByWeekList = "select customer_type as customerType, salescall_hdr_id as salesCallHdrId, co.customer_name as customer,type_of_call as typeOfCall,\n"
			+ " assign_to as assignTo, person_met as personMet, to_char(created_date,'YYYY-MM-DD') as\n"
			+ " visitDate from salescall_hdr sh left join customer co on co.customer_code = sh.customer \n"
			+ "where extract (week from sh.visit_date)::int = ?  and to_char(sh.visit_date,'yyyy') = ? and salescall_hdr_id=?";
	public static final String getByDateList = "select customer_type as customerType, salescall_hdr_id as salesCallHdrId, co.customer_name as customer,type_of_call as typeOfCall,\n"
			+ " assign_to as assignTo, person_met as personMet, to_char(created_date,'YYYY-MM-DD') as\n"
			+ " visitDate from salescall_hdr sh left join customer co on co.customer_code = sh.customer \n"
			+ "where \n"
			+ "visit_date  between to_date(?,'yyyy-MM-dd') and to_date(?,'yyyy-MM-dd') and salescall_hdr_id=?";
	public static final String GET_SALES_PERSON_LIST = "select salescall_hdr_id as id ,Person_met as text from salescall_hdr ";

}
