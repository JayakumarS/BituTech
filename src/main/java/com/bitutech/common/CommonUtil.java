package com.bitutech.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Encoder;

/**
* @author paragon
*
*/
public class CommonUtil {

	public static String spaceChar = " ";

	public static String underScoreChar = "_";

	public static String hypenChar = "-";

	public static String colonChar = ":";

	public static String dotChar = ".";

	public static String DB_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm";

	public static String DISPLAY_DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm";
	
	public static String DISPLAY_DATE_TIME_FORMAT_HH = "dd/MM/yyyy HH:mm";

	public static String DB_DATE_FORMAT = "yyyy-MM-dd";

	public static String DISPLAY_DATE_FORMAT = "yyyy-MM-dd";

	public static String DISPLAY_DATE_FORMAT1 = "dd/MM/yyyy";
	
	public static String DISPLAY_DATE_FORMAT2 = "MM-DD-YYYY";

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestedWithHeader = request.getHeader("X-Requested-With");
		return "XMLHttpRequest".equals(requestedWithHeader);
	}

	public static String encrypt(String plainText) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA"); // step 2
		md.update(plainText.getBytes("UTF-8")); // step 3
		byte raw[] = md.digest(); // step 4
		String encryptedText = (new BASE64Encoder()).encode(raw); // step 5
		return encryptedText; // step 6
	}

	/**
	 * dateformat <dd/MM/yyyy>
	 *
	 * @param dateString1
	 * @return
	 */
	public static String convertSqlDateFormate(String dateString1) {
		String outputString = "";
		try {
			DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
			Date date = inputFormat.parse(dateString1);
			DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
			outputString = outputFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputString;
	}

	public static java.sql.Date stringToSqlDate(String inputString, String dateFormat) {
		java.sql.Date sqlStartDate = null;
		try {
			if (StringUtils.isNotBlank(inputString) && StringUtils.isNotBlank(dateFormat)) {
				DateFormat inputFormat = new SimpleDateFormat(dateFormat);
				Date inputDate = inputFormat.parse(inputString);
				sqlStartDate = new java.sql.Date(inputDate.getTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sqlStartDate;
	}
	
	public static java.sql.Timestamp stringToSqlDateTimestamp(String inputString, String dateFormat) {
		java.sql.Timestamp sqlStartTimestamp = null;
		try {
			if (StringUtils.isNotBlank(inputString) && StringUtils.isNotBlank(dateFormat)) {
				DateFormat inputFormat = new SimpleDateFormat(dateFormat);
				Date inputDate = inputFormat.parse(inputString);
				sqlStartTimestamp = new java.sql.Timestamp(inputDate.getTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sqlStartTimestamp;
	}

	/**
	 * return Empty For Null
	 *
	 * @param inputString
	 * @return
	 */
	public static String returnEmptyForNull(String inputString) {
		String s = "";
		try{
			
		if (inputString == null || inputString == "" || inputString.equals("null") || inputString == "null") {
			s = "";
		} else {
			s = inputString;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}

	public static String returnZeroForNull(String inputString) {
		String s = "";
		try{
			
		if (inputString == null || inputString == "" || inputString.equals("null") || inputString == "null" || inputString.isEmpty()) {
			s = "0";
		} else {
			s = inputString;
		}
		}catch(Exception e){
			
		}
		return s;
	}
	
	/*********************** added By Ashok ********************/
	public static final String THIRDPARTY_VSL_NAME = "Third Party VSL";

	public static final String THIRDPARTY_VSL_CODE = "T";

	public static final String OWNED_VSL_NAME = "Owned VSL";

	public static final String OWNED_VSL_CODE = "S";

	public static final String INS_TYPE_HM_CODE = "HM";

	public static final String INS_TYPE_KNRLOH_CODE = "KNRLOH";

	public static final String INS_TYPE_AWR_CODE = "AWR";

	public static final String INS_TYPE_PI_CODE = "PI";

	public static final String INS_TYPE_CL_CODE = "CL";

	public static final String INS_TYPE_LOH_CODE = "LOH";
	
	public static final String INS_TYPE_EW_CODE = "EW";

	public static final String INS_TYPE_CLASSOT_CODE = "CLASSOT";
	
	public static final String INS_TYPE_CLASSTWO_CODE = "CLASSTWO";

	public static final String INS_TYPE_CLASST_CODE = "CLASST";

	public static final String CHARTERED_OUT = "O";

	public static final String CHARTERED_GFS = "C";

	public static final String CHARTERED_JV = "J";

	public static final String CHARTERED_OUT_NAME = "Owned - C/O";

	public static final String CHARTERED_GFS_NAME = "Chartered - GFS";

	public static final String CHARTERED_JV_NAME = "Chartered - JV";

	
	public static final String OWNERS_TRADING = "R";

	public static final String OWNERS_THIRDPARTY = "U";

	public static final String OWNERS_TRADING_NAME = "Owners Trading";

	public static final String OWNERS_THIRDPARTY_NAME = "Owners - ThirdParty";
	
	public static List<Integer> getMonthsList() {
		List<Integer> months = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			months.add(i);
		}
		return months;
	}
	
	public static List<Integer> getMonthsList5Years() {
		List<Integer> months = new ArrayList<>();
		for (int i = 1; i <= 72; i++) {
			months.add(i);
		}
		return months;
	}

	public static List<Integer> getDaysList() {
		List<Integer> days = new ArrayList<>();
		for (int i = 1; i <= 31; i++) {
			days.add(i);
		}
		return days;
	}
	
	public static List<Integer> getDaysListNew() {
		List<Integer> days = new ArrayList<>();
		for (int i = 1; i <= 200; i++) {
			days.add(i);
		}
		return days;
	}


	/**
	 * Convert amount Into Words
	 *
	 * @param amount
	 * @param curr
	 * @return
	 */
	public static String currencyInWords(double amount, String curr) {

		
		
		String return_str = "";
		// If the amount is zero then return string as 'zero'
		if (amount == 0) {
			return_str = "Zero";
		}
		double dupAmount = amount;
		long intAmount = (long) amount;

		int fils = 0;

		String amt=amount+"";
		amt=String.valueOf(truncateDecimal(amount,2))+"";

		String filsmyr="";
		String str_amount = inWords(intAmount);
		String str_fils = inWords(fils);

		String[] amtarrDec = amt.split("\\.");
		int filDec = 0;
		String filsDec ="";
		filDec = amtarrDec.length>0 ? Integer.parseInt(amtarrDec[1]):0;
		if (filDec > 0) {
			filsDec = inWords(filDec);
		}
		if(curr.equals("MYR")){
			String[] amtarr = amt.split("\\.");
			fils = amtarr.length>0 ? Integer.parseInt(amtarr[1]):0;
			int pointdigit=Integer.parseInt(amtarr[1]);
	        int b=Integer.toString(pointdigit).length();
           if(b==1){
				fils = Integer.valueOf(String.valueOf(pointdigit) + String.valueOf(0));
				 filsmyr = inWords(fils);
			}
           else{
			 filsmyr = inWords(fils);
           }
		}
		if (intAmount == 0) {

			if (fils == 0) {
				return_str = "Zero";
			} else {
				return_str = str_fils + "";
			}

		} else {
			if (fils == 0) {
				if(curr.equals("MYR")) {
					return_str = "(" + curr + str_amount + " Only)";
				} else if (curr.equals("USD")) {
					if (filDec > 0) {
						return_str = "(" + curr + str_amount + " and " + filsDec + " Cents Only)";
					} else {
						return_str = "(" + curr + str_amount + " Only)";
					}
				} else if (curr.equals("INR") || curr.equals("SLR")) {
					if (filDec > 0) {
						return_str = "(" + curr + str_amount + " and " + filsDec + " Paisa Only)";
					} else {
						return_str = "(" + curr + str_amount + " Only)";
					}
				} else if (curr.equals("AED")) {
					if (filDec > 0) {
						return_str = "(" + curr + str_amount + " and " + filsDec + " Fils Only)";
					} else {
						return_str = "(" + curr + str_amount + " Only)";
					}
				} else {
					return_str = "(" + curr + str_amount + " Only)";
				}	
			} else {
				if(curr.equals("MYR")) {
					return_str = "(" + curr + str_amount + " and Cents" + filsmyr + " Only)";
				} else if (curr.equals("USD")) {
					if (filDec > 0) {
						return_str = "(" + curr + str_amount + " and " + filsDec + " Cents Only)";
					} else {
						return_str = "(" + curr + str_amount + " Only)";
					}
				} else if (curr.equals("INR") || curr.equals("SLR")) {
					if (filDec > 0) {
						return_str = "(" + curr + str_amount + " and " + filsDec + " Paisa Only)";
					} else {
						return_str = "(" + curr + str_amount + " Only)";
					}
				} else if (curr.equals("AED")) {
					if (filDec > 0) {
						return_str = "(" + curr + str_amount + " and " + filsDec + " Fils Only)";
					} else {
						return_str = "(" + curr + str_amount + " Only)";
					}
				} else {
					return_str = "(" + curr + str_amount + " Only)";
				}
			}
		}
		return return_str;

	}

	public static String inWords(long val) {

		double ibillion = val / 1000000000;

		long billion = (long) (ibillion);

		val = val - billion * 1000000000;

		float imillion = val / 1000000;

		int million = (int) (imillion);

		val = val - million * 1000000;

		float ithousand = val / 1000;

		int thousand = (int) ithousand;

		float ihundred = (val - (thousand * 1000));

		int hundred = Math.abs((int) (ihundred));

		String return_str = convert1(hundred);

		// Check whether currency value is greater than thousand
		if (thousand != 0) {
			String str_thousand = convert1(thousand);

			if (return_str == "")
				return_str = str_thousand + " Thousand";
			else
				return_str = str_thousand + " Thousand  " + return_str;

		}

		// Check whether currency value is greater than million
		if (million != 0) {

			String str_million = convert1(million);
			if (return_str == "")
				return_str = str_million + " million";
			else
				return_str = str_million + " Million  " + return_str;

		}

		// Check whether currency value is greater than billion
		if (billion != 0) {

			String str_billion = convert1(billion);

			if (return_str == "")
				return_str = str_billion + " Billion";
			else
				return_str = str_billion + " Billion  " + return_str;

		}
		return return_str;

	}

	/**
	 * convert numbers into words
	 *
	 * @param value
	 * @return
	 */
	public static String convert1(long value) {
		float ihundred;
		int ten;
		long val;
		val = value;
		String convert = null;

		// Check if the amount is greater than hundred
		// if true append a string equalent to currency
		if (val > 99) {
			ihundred = val / 100;
			int hundred = (int) ihundred;
			val = (val - (hundred * 100));
			String str_hundred = "";

			if (hundred >= 1)
				str_hundred = convert1(hundred);

			if (val == 0)
				convert = str_hundred + " Hundred ";

			else
				convert = str_hundred + " Hundred " + convert1(val);

		} else {

			if (val > 19) {
				float iten = (val / 10);
				ten = (int) iten;
				val = (val - (ten * 10));

				// Append string equalent to currency
				switch (ten) {
				case 2:
					convert = " Twenty " + convert1(val);
					break;
				case 3:
					convert = " Thirty " + convert1(val);
					break;
				case 4:
					convert = " Fourty " + convert1(val);
					break;
				case 5:
					convert = " Fifty " + convert1(val);
					break;
				case 6:
					convert = " Sixty " + convert1(val);
					break;
				case 7:
					convert = " Seventy " + convert1(val);
					break;
				case 8:
					convert = " Eighty " + convert1(val);
					break;
				case 9:
					convert = " Ninety " + convert1(val);
					break;

				}

			} else {

				// Append string equalent to currency
				switch ((int) val) {
				case 1:
					convert = " One ";
					break;
				case 2:
					convert = " Two ";
					break;
				case 3:
					convert = " Three ";
					break;
				case 4:
					convert = " Four ";
					break;
				case 5:
					convert = " Five ";
					break;
				case 6:
					convert = " Six ";
					break;
				case 7:
					convert = " Seven ";
					break;
				case 8:
					convert = " Eight ";
					break;
				case 9:
					convert = " Nine ";
					break;
				case 10:
					convert = " Ten ";
					break;
				case 11:
					convert = " Eleven ";
					break;
				case 12:
					convert = " Twelve ";
					break;
				case 13:
					convert = " Thirteen ";
					break;
				case 14:
					convert = " Fourteen ";
					break;
				case 15:
					convert = " Fifteen ";
					break;
				case 16:
					convert = " Sixteen ";
					break;
				case 17:
					convert = " Seventeen ";
					break;
				case 18:
					convert = " Eighteen ";
					break;
				case 19:
					convert = " Nineteen ";
					break;
				default:
					convert = "";

				}

			}

		}
		return convert;

	}

	public static int convertNullToInteger(String inputString) {
		int s = 0;
		try {
			if (inputString == null || inputString.equals("null")) {
				s = 0;
			} else {
				s = Integer.parseInt(inputString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	public static String convertNullToZero(String inputString) {
		String s = "";
		try {
			if (inputString == null || inputString.equals("null")) {
				s = "0";
			} else {
				s = inputString;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String checkEmptyString(String s1) {
		if (s1 == null || s1.equalsIgnoreCase("null")) {
			return "";
		} else {
			return s1;
		}
	}

	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	public static java.sql.Timestamp getCurrentDateFromString(String dateValue) {
		Date stringToDate = null;
		java.sql.Timestamp stringtodate1 = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			stringToDate = dateFormat.parse(dateValue);
			stringtodate1 = new Timestamp(stringToDate.getTime());

		} catch (Exception ae) {

		}
		return stringtodate1;
	}

	public static List<String> getHoursList() {
		List<String> hourList = new ArrayList<String>();
		for (int i = 0; i <= 23; i++) {
			String hour = i + "";
			if (hour.length() == 1) {
				hour = "0" + hour;
			}
			hourList.add(hour);
		}
		return hourList;
	}

	public static List<String> getMinuteList() {
		List<String> minuteList = new ArrayList<String>();
		for (int i = 0; i <= 59; i++) {
			String minute = i + "";
			if (minute.length() == 1) {
				minute = "0" + minute;
			}
			minuteList.add(minute);
		}
		return minuteList;
	}

	public static List<String> getBerthNumberList() {
		List<String> berthNumberList = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			berthNumberList.add(i + "");
		}
		return berthNumberList;
	}
	/**
	 * get Current Date 
	 */
	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		if (Integer.parseInt(month) < 9) {
			month = "0" + month;
		}
		if (Integer.parseInt(day) < 9) {
			day = "0" + day;
		}

		return day + "/" + month + "/" + year;
	}
	
	public static BigDecimal truncateDecimal(double x, int numberofDecimals) {
		if (x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
		}
	}
	
	public static BigDecimal roundOffValue(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd;
	}
	
	public static boolean isValidDate(String format, String date) {
		boolean isValid = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date.trim());
		} catch (ParseException pe) {
			isValid = false;
		}
		return isValid;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	

	public static String convertNullString(String value) {
		try{if (!value.equals("null") && value != null) {
			value = value;
		} else {
			value = "0.0";
		}
	}catch(Exception e){
		return "0.0";
	}
		return value;
	}
	
	public static String convertNullEmpty(String value) {
		try{
		if (!value.equals("null") && value != null) {
			value = value;
		} else {
			value = "";
		}
		}catch(Exception e){
			return "";
		}
		return value;
	}
	
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static double round(double value, int places) {
		try {
			if (places < 0) throw new IllegalArgumentException();
		    long factor = (long) Math.pow(10, places);
		    value = value * factor;
		    long tmp = Math.round(value);
		    return (double) tmp / factor;
		} catch (NumberFormatException nfe) {
			return 0.0;
		}
	}
}

