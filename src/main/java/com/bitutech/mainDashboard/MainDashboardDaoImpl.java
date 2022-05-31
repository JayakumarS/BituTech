package com.bitutech.mainDashboard;



import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MainDashboardDaoImpl  implements MainDashboardDao  {
//	private final static Logger LOGGER = Logger.getLogger(MainDashboardDaoImpl.class);
	
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

		@Override
		public MainDashboardResultBean getCustomerCount() throws Exception {
			MainDashboardResultBean customerCount = new MainDashboardResultBean();
			try {
				
				Integer hd = jdbcTemplate.queryForObject(MainDashboardQueryUtil.GET_CUSTOMER_COUNT,Integer.class);
				customerCount.setCountvalue(hd);
			} catch (DataAccessException e) {
				//LOGGER.error("Error in List", e);
			}
			return customerCount;
		}
			
		}



