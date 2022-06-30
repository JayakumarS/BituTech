package com.bitutech.salesCallReport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.salescallentry.SalesCallEntryBean;
import com.bitutech.salescallentry.SalesEntryMasterQueryUtil;
import com.bitutech.salesorder.SalesOrderBean;
import com.bitutech.salesorder.SalesOrderQueryUtil;

@Repository
public class SalesCallReportDaoImpl implements SalesCallReportDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<SalesCallReportBean> getList() throws Exception {
		// TODO Auto-generated method stub
		List<SalesCallReportBean> salesCallReportBeanList = new ArrayList<SalesCallReportBean>();
		try {
			salesCallReportBeanList = jdbcTemplate.query(SalesCallReportQueryUtil.getList, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesCallReportBeanList;
	}

	@Override
	public SalesCallReportResultBean save(SalesCallReportBean bean) throws Exception {
		// TODO Auto-generated method stub
		String yearAndMonth = (bean.getYear() +"-"+bean.getMonth());
		bean.setYearMonth(yearAndMonth);
		SalesCallReportResultBean resultBean = new SalesCallReportResultBean();
		List<SalesCallReportBean> byYearQuery = new ArrayList<SalesCallReportBean>();
		List<SalesCallReportBean> byQuarterQuery = new ArrayList<SalesCallReportBean>();
		List<SalesCallReportBean> byMonthQuery = new ArrayList<SalesCallReportBean>();
		List<SalesCallReportBean> byWeekQuery = new ArrayList<SalesCallReportBean>();
		List<SalesCallReportBean> byDateQuery = new ArrayList<SalesCallReportBean>();
		
		if(bean.getOptions().equals("byYear")) {
			byDateQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByYearList,new Object[] {bean.getYear(),Integer.parseInt(bean.getSalesPerson())},new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
			resultBean.setSalesCallReportDetails(byDateQuery);
		}
		
		else if(bean.getOptions().equals("byQuarter")) {
			
			if(bean.getQuarter().equals("01")) {
				String ch ="01";
				String stMonthYr = "";
				String edMonthYr = "";
				switch(ch){
				
				case "01":{
					stMonthYr=bean.getYear()+"-01";
					edMonthYr=bean.getYear()+"-03";
					break;
				}
				}
				byQuarterQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByQuarterList,new Object[] {bean.getYear(),stMonthYr,edMonthYr,Integer.parseInt(bean.getSalesPerson())}, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
				resultBean.setSalesCallReportDetails(byQuarterQuery);
			}
			else if(bean.getQuarter().equals("02")) {
				String ch ="02";
				String stMonthYr = "";
				String edMonthYr = "";
				switch(ch){
				
				case "02":{
					stMonthYr=bean.getYear()+"-04";
					edMonthYr=bean.getYear()+"-06";
					break;
				}
				}
				byQuarterQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByQuarterList,new Object[] {bean.getYear(),stMonthYr,edMonthYr,Integer.parseInt(bean.getSalesPerson())}, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
				resultBean.setSalesCallReportDetails(byQuarterQuery);
			}
			else if(bean.getQuarter().equals("03")) {
				String ch ="03";
				String stMonthYr = "";
				String edMonthYr = "";
				switch(ch){
				
				case "03":{
					stMonthYr=bean.getYear()+"-07";
					edMonthYr=bean.getYear()+"-09";
					break;
				}
				}
				byQuarterQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByQuarterList,new Object[] {bean.getYear(),stMonthYr,edMonthYr,Integer.parseInt(bean.getSalesPerson())}, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
				resultBean.setSalesCallReportDetails(byQuarterQuery);
			}
			else if(bean.getQuarter().equals("04")) {
				String ch ="04";
				String stMonthYr = "";
				String edMonthYr = "";
				switch(ch){
				
				case "04":{
					stMonthYr=bean.getYear()+"-10";
					edMonthYr=bean.getYear()+"-12";
					break;
				}
				}
				byQuarterQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByQuarterList,new Object[] {bean.getYear(),stMonthYr,edMonthYr,Integer.parseInt(bean.getSalesPerson())}, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
				resultBean.setSalesCallReportDetails(byQuarterQuery);
			}
			
		}
		
		
		else if(bean.getOptions().equals("byMonth")) {
			byMonthQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByMonthList,new Object[] {yearAndMonth,Integer.parseInt(bean.getSalesPerson())},new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
			resultBean.setSalesCallReportDetails(byMonthQuery);
		}
		else if(bean.getOptions().equals("byWeek")) {
			byWeekQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByWeekList,new Object[] {Integer.parseInt(bean.getWeek()),bean.getYear(),Integer.parseInt(bean.getSalesPerson())}, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
			resultBean.setSalesCallReportDetails(byWeekQuery);
		}
		else if(bean.getOptions().equals("byDate")) {
			byDateQuery = jdbcTemplate.query(SalesCallReportQueryUtil.getByDateList,new Object[] {bean.getFromDate(),bean.getToDate(),Integer.parseInt(bean.getSalesPerson())}, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
			resultBean.setSalesCallReportDetails(byDateQuery);
		}
		
		
		return resultBean;
	}

	@Override
	public List<SalesCallReportBean> getsalesPersonList() throws Exception {
		// TODO Auto-generated method stub
		List<SalesCallReportBean> salesOrderBean = new ArrayList<SalesCallReportBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesCallReportQueryUtil.GET_SALES_PERSON_LIST, new BeanPropertyRowMapper<SalesCallReportBean>(SalesCallReportBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}
}
