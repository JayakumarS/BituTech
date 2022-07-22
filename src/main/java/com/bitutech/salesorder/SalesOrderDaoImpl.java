package com.bitutech.salesorder;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.bitutech.common.CommonUtil;
import com.bitutech.common.ConfigurationProps;
import com.bitutech.common.Email;
import com.bitutech.common.MailUtility;
import com.lowagie.text.Anchor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Image;




@Repository
public class SalesOrderDaoImpl implements SalesOrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Override
	public SalesOrderResultBean save(SalesOrderBean bean) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		try {
			Map<String, Object> salesOrderMap = new HashMap<String, Object>();
		    
			salesOrderMap.put("customer", bean.getCustomer());
			salesOrderMap.put("validFrom", bean.getValidFrom());
			salesOrderMap.put("validTo", bean.getValidTo());
			salesOrderMap.put("currency", bean.getCurrency());
			salesOrderMap.put("deliveryDate", bean.getDeliveryDate());
			salesOrderMap.put("id", bean.getId());
			salesOrderMap.put("termCondition", bean.getTermCondition());
			salesOrderMap.put("total", bean.getTotal());
			salesOrderMap.put("salesQuoteNo", bean.getSalesQuoteNo());

			salesOrderMap.put("modifiedBy","E0001");
			String countValue =  jdbcTemplate.queryForObject(SalesOrderQueryUtil.GETCOUNT, String.class);
			salesOrderMap.put("countValue", countValue);
			
			String salesorderno = namedParameterJdbcTemplate.queryForObject(SalesOrderQueryUtil.INSERT_SALES_ORDER_HDR,salesOrderMap,String.class);
			
			
			if(!salesorderno.isEmpty()) {
				if(bean.getSalesOrderdtlBean().size()>0) {
					for(SalesOrderdtlBean salesOrderdtlBean:bean.getSalesOrderdtlBean()) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("salesOrderNo",salesorderno);
						dtlMap.put("item",salesOrderdtlBean.getItem());
						dtlMap.put("uomId",salesOrderdtlBean.getUomId());
						dtlMap.put("rate",salesOrderdtlBean.getRate());
						dtlMap.put("qty",salesOrderdtlBean.getQty());
						dtlMap.put("price",salesOrderdtlBean.getPrice());
						dtlMap.put("createdBy","E0001");
						namedParameterJdbcTemplate.update(SalesOrderQueryUtil.Insert_salesOder_Dtl,dtlMap);
						
					}
				}
			}
		   resultBean.setSuccess(true);
		      }catch(Exception e) {
			      e.printStackTrace();
			       resultBean.setSuccess(false);
		      }
		
		return resultBean;
	}

	@Override
	public List<SalesOrderBean> getSalesOrderList() throws Exception {
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.getSalesOrderList, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
//			if (visitRequest.getType().equals("visitor")) {
//				requestMail(visitStartTime, talentId, visitorMessage,messagesubject,messageName, mailIdReq,lastInstertedRow.getId());
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}

	@Override
	public List<SalesOrderBean> getItemNameList() throws Exception {
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.GET_ITEM_NAME_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}
	//edit
	@Override
	public SalesOrderResultBean edit(String bean) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setSalesOrderBean(jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_ORDER_HDR,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class)));
			resultBean.setSalesOrderdtlBean(jdbcTemplate.query(SalesOrderQueryUtil.SELECT_SALES_ORDER_DTL,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderdtlBean>(SalesOrderdtlBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {          
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	//update
	@Override
	public SalesOrderResultBean update(SalesOrderBean bean) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		try {
    		Map<String, Object> salesOrderMap = new HashMap<String, Object>();
		    
			salesOrderMap.put("customer", bean.getCustomer());
			salesOrderMap.put("validFrom", bean.getValidFrom());
			salesOrderMap.put("validTo", bean.getValidTo());
			salesOrderMap.put("currency", bean.getCurrency());
			salesOrderMap.put("deliveryDate", bean.getDeliveryDate());
			salesOrderMap.put("id", bean.getId());
			salesOrderMap.put("salesQuoteNo", bean.getSalesQuoteNo());
			salesOrderMap.put("termCondition", bean.getTermCondition());
			salesOrderMap.put("total", bean.getTotal());

			salesOrderMap.put("modifiedBy","E0001");
 			salesOrderMap.put("countValue", bean.getCountValue());
			String salesOrder =  bean.getCountValue();
			String itemID = namedParameterJdbcTemplate.queryForObject(SalesOrderQueryUtil.UPDATE_SALES_ORDER_HDR,salesOrderMap,String.class);
			
			if(bean.getSalesOrderdtlBean().size()>0) {
				
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_workorder_hdr,salesOrder);
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALESORDER_DTL,salesOrder);

				
					for(SalesOrderdtlBean salesOrderdtlBean:bean.getSalesOrderdtlBean()) {
						Map<String, Object> dtlMap = new HashMap<>();
						dtlMap.put("salesOrderNo",salesOrder);
						dtlMap.put("item",salesOrderdtlBean.getItem());
						dtlMap.put("uomId",salesOrderdtlBean.getUomId());
						dtlMap.put("rate",salesOrderdtlBean.getRate());
						dtlMap.put("qty",salesOrderdtlBean.getQty());
						dtlMap.put("price",salesOrderdtlBean.getPrice());
						dtlMap.put("createdBy","E0001");
						namedParameterJdbcTemplate.update(SalesOrderQueryUtil.Insert_salesOder_Dtl,dtlMap);
						
					}
				
			}
			resultBean.setSuccess(true);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@Override
	public SalesOrderResultBean delete(String countValue) throws Exception {
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		try {
			if(countValue!=null) {
				 
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_workorder_hdr,countValue);
				jdbcTemplate.update(SalesOrderQueryUtil.DELETE_SALES_ORDER_HDR,countValue);
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public List<SalesOrderBean> getCustomerList() throws Exception {
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.GET_COSTOMER_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}

	@Override
	public List<SalesOrderBean> getSalesOrderListService() {
		// TODO Auto-generated method stub
		List<SalesOrderBean> salesOrderBean = new ArrayList<SalesOrderBean>();
		try {
			salesOrderBean = jdbcTemplate.query(SalesOrderQueryUtil.GET_SALES_ORDER_LIST, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesOrderBean;
	}
	
	
	@Override
	public SalesOrderResultBean mail(String code) throws Exception {
		// TODO Auto-generated method stub
		SalesOrderBean bean = new SalesOrderBean();
		String path = "";
		bean = jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_QUOTE_HDR,new Object[] { code }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));
//		sendMail(bean, path);
		Email email = null;
		String visitStartTime = "";
		String invoiceValue = "12345";
		String compLoc = code;
		String selectedDropDown = "Vivek";
		String messageName = bean.getSalesQuoteNo();
		String fromAddress = "vijay@paragondynamics.in";
		email = new Email();
		String[] email1 = {"cvivek7080@gmail.com"};
		email.setToEmailAddress(email1);
		email.setFromEmailAddress(fromAddress);
		int seq = 1;
		
		visitStartTime = bean.getSalesOrderNo();
		
		String talentId = "Vivek";
		String visitorMessage = bean.getSalesQuoteNo();
		String messagesubject = "vijay@paragondynamics.in";
		email = new Email();
		String mailIdReq = "cvivek7080@gmail.com";
	 	
		
		
		requestMail(visitStartTime, talentId, visitorMessage,messagesubject,messageName, mailIdReq);
	//	ApprovedMail(bean,compLoc);
		
		
		
		return null;
	}

	

	@Override
	public SalesOrderResultBean getfetchSalesQuote(String bean) throws Exception {
		// TODO Auto-generated method stub
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setSalesOrderBean(jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_QUOTE_HDR,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class)));
			List<SalesOrderdtlBean> salesOrderdtlBean = jdbcTemplate.query(SalesOrderQueryUtil.SELECT_SALES_QUOTE_DTL,new Object[] { bean },new BeanPropertyRowMapper<SalesOrderdtlBean>(SalesOrderdtlBean.class));	
			resultBean.setSalesOrderdtlBean(salesOrderdtlBean);		
			resultBean.setSuccess(true);
		}
		catch(Exception e) {          
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public SalesOrderResultBean getfetchCustomer(String customer) {
		// TODO Auto-generated method stub
		SalesOrderResultBean resultBean = new SalesOrderResultBean();
		resultBean.setSuccess(false);
		try {
			//resultBean.setSalesOrderBean(jdbcTemplate.queryForObject(SalesOrderQueryUtil.SELECT_SALES_QUOTE,new Object[] { bean }, new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class)));
			List<SalesOrderBean> salesOrderdtlBean = jdbcTemplate.query(SalesOrderQueryUtil.SELECT_SALES_QUOTE,new Object[] { customer },new BeanPropertyRowMapper<SalesOrderBean>(SalesOrderBean.class));	
			resultBean.setSalesQuoteNoDetailsList(salesOrderdtlBean);		
			resultBean.setSuccess(true);
		}
		catch(Exception e) {          
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	
	
	
	
	
	private SalesOrderBean printInvoice(String invoiceValue, String compLoc, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String requestMail(String visitStartTime, String hostTalentId, String hostMessage, String messageName, String messagesubject, String mailId)
			throws Exception {
		Email email = new Email();
		StringBuffer sb = new StringBuffer();
		String path = "";
		email.setFromEmailAddress("info@talentchek.com");
		//mailId = "kathiravan@paragondynamics.in";
		String toMailAddress = mailId;
		String[] toEmailIds = toMailAddress.split(",");
		email.setToEmailAddress(toEmailIds);
		String logoImage = "https://visitorchek.com/assets/images/vc_logo_1.png";
		//String logoIdmage = "http://183.82.246.243/assets/images/vc_logo_1.png";
		//sb.append("<img style='width:86px;height:50px;' src="+logoImage+">");

 		sb.append("<!DOCTYPE html>\r\n");
		sb.append(
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">");

		sb.append("<head>\r\n");
		sb.append("<meta charset=\"UTF-8\">");

		sb.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
		sb.append("<meta name=\"x-apple-disable-message-reformatting\">");

		sb.append("<style>");
		sb.append(" table, td, div, h1, p {font-family: Arial, sans-serif;}\r\n");
		
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<body style=\"margin:0;padding:0;word-spacing:normal;\">");
		sb.append(
				"<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">");

		sb.append("<tr>");
		sb.append("<td align=\"center\" style=\"padding:0;\">");
		sb.append(
				"<table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">");

		sb.append("<tr>");
		sb.append(
				"<td align=\"center\" style=\"padding:40px 0 30px 0;background: linear-gradient(to right,#ee7724,#d8363a,#dd3675,#b44593);\">");
		sb.append(
				"<img src=\"https://visitorchek.com/assets/images/vc_logo_1.png\" alt=\"\" width=\"200\" style=\"height:auto;display:block;width: 145px;\" />");
		sb.append("</td>");
		sb.append("</tr>");

		sb.append("<tr>");
		sb.append("<td style=\"padding:36px 14px 7px 23px;\">");
		sb.append(
				"<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">");

		sb.append("<tr>");
		sb.append("<td style=\"padding:0 0 36px 0;color:#153643; font-weight:600px;\">");
		sb.append("<h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Dear "+messagesubject+"</h1>");
		sb.append("<a href=\"https://portal.talentchek.com/tc/userprofile?tfid="+hostTalentId+"\"target=\"_blank\">"+messageName+" </a>" +hostMessage + ".");
		sb.append("</td>");
		sb.append("</tr>");

		sb.append("<tr>");

		sb.append("<td style=\"padding:0;\">");
		sb.append(
				"<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">");

		sb.append("<tr>");

		sb.append("<td>");
//		sb.append("<p style=\"margin:0;\"><a href=\"http://183.82.246.243/accept/3\" target=\"_blank\" style=\"background: #2bde28; margin-left: 100px;text-decoration: none; padding: 10px 45px; color: #ffffff; box-shadow: #D6D6E7 0 0 0 1.5px inset, rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;box-shadow: rgba(45, 35, 66, 0.4) 0 4px 8px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;\r\n"
//				+ "  transform: translateY(-2px); border-radius: 4px; display:inline-block; mso-padding-alt:0;text-underline-color:#ff3884\"><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%;mso-text-raise:20pt\">&nbsp;</i><![endif]--><span style=\"mso-text-raise:10pt;font-weight:bold;\">Accept</span><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%\">&nbsp;</i><![endif]--></a></p>");
//		sb.append("</td>");
		
		//sb.append("<p style=\"margin:0;\"><a href=\"http://visitorchek.com/accept/"+id+"/"+mailId+"/A\" target=\"_blank\" style=\"background: #2bde28; margin-left: 100px;text-decoration: none; padding: 10px 45px; color: #ffffff; box-shadow: #D6D6E7 0 0 0 1.5px inset, rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;box-shadow: rgba(45, 35, 66, 0.4) 0 4px 8px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;\r\n"
	//			+ "  transform: translateY(-2px); border-radius: 4px; display:inline-block; mso-padding-alt:0;text-underline-color:#ff3884\"><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%;mso-text-raise:20pt\">&nbsp;</i><![endif]--><span style=\"mso-text-raise:10pt;font-weight:bold;\">Accept</span><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%\">&nbsp;</i><![endif]--></a></p>");
		sb.append("</td>");

		sb.append("<td style=\"width:20px;padding:0;font-size:0;line-height:0;\">&nbsp;</td>");

		sb.append("<td style=\"width:260px;padding:0;vertical-align:top;color:#153643;\">");
//		sb.append("\n\n<a href=\"http://183.82.246.243/accept\"><button><span>Accept</span></button></a>\n\n<br>");
		//sb.append("<p style=\"margin:0;\"><a href=\"http://visitorchek.com/accept/"+id+"/"+mailId+"/R\" target=\"_blank\" style=\"background: #ff3526; text-decoration: none; padding: 10px 45px; color: #ffffff; box-shadow: #D6D6E7 0 0 0 1.5px inset, rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;box-shadow: rgba(45, 35, 66, 0.4) 0 4px 8px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;\r\n"
		//		+ "  transform: translateY(-2px); border-radius: 4px; display:inline-block; mso-padding-alt:0;text-underline-color:#ff3884\"><!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%;mso-text-raise:20pt\">&nbsp;</i><![endif]--><span style=\"mso-text-raise:10pt;font-weight:bold;\">Reject<!--[if mso]><i style=\"letter-spacing: 25px;mso-font-width:-100%\">&nbsp;</i><![endif]--></a></p>");
		sb.append("</td>");

		sb.append("</tr>");

		sb.append("</table>");
		
		sb.append("<tr>");
		sb.append("<td style=\"padding:0 0 36px 0;color:#153643; font-weight:600px;\">");
		//sb.append("<h4  style=\"font-size:15px;margin:0 0 20px 0;margin-top:25px;font-family:Arial,sans-serif;\"><a href=\"https://portal.talentchek.com/tc/userprofile?tfid="+talentId+"\"target=\"_blank\">Click here to view profile </a> </h4>");
		sb.append("\n<h4   style=\"font-size:15px;margin:0 0 20px 0;margin-top:25px;font-family:Arial,sans-serif;\">For better tracking and meeting tracker&nbsp;<a href=\"https://play.google.com/store/apps/details?id=com.paragondynamics.visitorchek\"target=\"_blank\">click here</a>&nbsp;to download </h4>\n\n<br>");
		sb.append("Best Regards," + "\n\n<br><br>");
		sb.append("Team VisitorChek");
		
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</td>");
		sb.append("</tr>");

		sb.append("</table>");
		sb.append("</td>");
		sb.append("</tr>");

		sb.append("<tr>");

		sb.append("<td style=\"padding:30px;background: linear-gradient(to right,#ee7724,#d8363a,#dd3675,#b44593);\">");
		sb.append(
				"<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">");

		sb.append("<tr>");

		sb.append("<td style=\"padding:0;width:50%;\" align=\"left\">");
		sb.append("<p style=\"margin:0;font-size:14px;line-height:16px;font-family:Arial,sans-serif;color:#ffffff;\">");
		sb.append("www.visitorchek.com");
		sb.append("</p>");
		sb.append("</td>");

		sb.append("<td style=\"padding:0;width:50%;\" align=\"right\">");
		sb.append("<table role=\"presentation\" style=\"border-collapse:collapse;border:0;border-spacing:0;\">");
		sb.append("<tr>");
		sb.append("<td style=\"padding:0 0 0 10px;width:38px;\">");
		sb.append(
				"<a href=\"https://www.instagram.com/talent_chek/?hl=en\" target=\"_blank\" style=\"color:#ffffff;\"><img src=\"https://cdn.exclaimer.com/Handbook%20Images/instagram-icon_32x32.png?_ga=2.38239331.1532690189.1651820489-1066359684.1651820489\" alt=\"Instagram\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>");
		sb.append("</td>");

		sb.append("<td style=\"padding:0 0 0 10px;width:38px;\">");
		sb.append(
				"<a href=\"https://www.facebook.com/Talent-Chek-107162598448547/\" target=\"_blank\" style=\"color:#ffffff;\"><img src=\"https://cdn.exclaimer.com/Handbook%20Images/facebook-icon_64x64.png?_ga=2.70652368.1532690189.1651820489-1066359684.1651820489\" alt=\"Facebook\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</td>");

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</td>");
		sb.append("</tr>");

		sb.append("</table>");
		sb.append("</td>");

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</body>");
		sb.append("</html>");

//		sb.append("Dear Sir" + "/" + "Madam <br><br>");
//		sb.append(message + ".");
//		sb.append("<br>");
//		sb.append("<br>");
////		sb.append("\n\n<a href=\"http://183.82.246.243/accept\">Click here to Accept</a>\n\n<br>");
//		sb.append("\n\n<a href=\"http://183.82.246.243/accept\"><button>Accept</button></a>\n\n<br>");
//		sb.append("<button type=\"button\" class=\"btn btn-success\">Reject</button>\r\n");
//
//		sb.append("<br>");
//		sb.append("Please find the Talent Chek credentials below.<br>");
//		sb.append("<br>");
//		sb.append("\n\n<a href=\"https://portal.talentchek.com/tc/login\">Click here to Register</a>\n\n<br>");
//		sb.append("<br>");
//
//		sb.append("Best Regards," + "\n\n<br>");
//		sb.append("IT Support" + "\n\n<br>");

		email.setBodyHtml(sb.toString());

		
		email.setSubject(" "+messageName+" has requested to meet you on - " );
		String pdfPath= AttachSavePDf("");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
				MailUtility.sendMailwithPDF(email, pdfPath);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		return path;
	}
	
	

	private String AttachSavePDf(String certificatecount)
			throws IOException,  ParseException {
	
		String filePath = "/home/paragon/Documents/sample.pdf";
		return filePath;
}
//		String rootPath = "";
//		File dir = new File(rootPath + File.separator);
//		if (!dir.exists())
//			dir.mkdirs();
//		String filePath = "";
//		try {
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			LocalDateTime now = LocalDateTime.now(); 
//			
//			String EmailID = "cvivek7080@gmail.com";
//	         String Email1 = "cvivek7080@gmail.com";
//	         String Email2 = "cvivek7080@gmail.com";
//	         String RequestSDC = transferOfRegistration.getCurrency();
//	         String Name = transferOfRegistration.getCurrency();
//	         String TransSDC = transferOfRegistration.getCurrency();
//	         String NocDate = transferOfRegistration.getCurrency();
//	         String RegistrationNo = transferOfRegistration.getCurrency();
//	         String RequestSDCHindi =transferOfRegistration.getCurrency(); 
//	         String TransSDCHindi = transferOfRegistration.getCurrency();
//			filePath = dir.getAbsolutePath() + File.separator + transferOfRegistration.getCurrency() + "_"
//					+ transferOfRegistration.getCurrency() + ".pdf";
//			Document doc  = new Document();
//			doc.setMargins(75, 75, 0, 0);
//			 
//			//Create OutputStream instance.
//			OutputStream outputStream = 
//				new FileOutputStream(new File(filePath));
//		 
//		   //Create PDFWriter instance.
//		   PdfWriter.getInstance(doc, outputStream);
//		 
//		    //Open the document.
//		    doc.open();
//			
//		    //adding signature image in NOC
//            Image tifheader = Image.getInstance("" + "/DCILetterHead.png");
//            tifheader.scalePercent(40,40);  
//          //  tifheader.setAbsolutePosition((rect.getLeft() + rect.getRight()) / 2 - 45, rect.getTop() - 50);
//            tifheader.setAlignment(Element.ALIGN_CENTER); 
//            doc.add(tifheader);
//            
//		//	String fontpath = System.Web.HttpContext.Current.Server.MapPath(@"~/fonts/");
//            BaseFont bf = BaseFont.createFont( "/opt/HindiFont/k010.TTF", BaseFont.IDENTITY_H, true);
//            //doc.addh
//            //Hindi
//            //BaseFont bf = BaseFont.CreateFont(Environment.GetEnvironmentVariable("windir") + @"\fonts\Mangal.TTF", BaseFont.IDENTITY_H, false);
//            Font fon = new Font(bf, 14,  Font.BOLD);
//            // Font fon = new Font(Font.FontFamily.HELVETICA, 12, 1);
//            Paragraph phd = new Paragraph("nar fpfdRld vfèkfu;e] 1948 dh èkkjk 46, ds rgr LFkkukarj.k iathdj.k ds fy, vukifÙk çek.k i=", fon);
//            phd.setAlignment (Element.ALIGN_CENTER);
//            doc.add(phd);
//            Font fon1 = new Font(bf, 12,  Font.NORMAL);
//            Font fon2 = new Font(bf, 12,  Font.BOLD);
//
//            //English
////            Font font = new Font(Font.FontFamily.HELVETICA, 10, 1);
//            Paragraph phead = new Paragraph("NO OBJECTION CERTIFICATE FOR TRANSFER OF REGISTRATION U/S 46A OF THE DENTISTS ACT, 1948");
//            phead.setAlignment( Element.ALIGN_CENTER);
//            doc.add(phead);
//            Font font1 = new Font(Font.BOLD, 10, Font.BOLD);
//            Font font2 = new Font(Font.DEFAULTSIZE,8, Font.NORMAL);
//           // #endregion
//            
//            
//            
//           // #region Number
//            Paragraph prLic = new Paragraph("la-MhÃ&105&fofoèk-A&2021@" + certificatecount + "                                              ", fon1);
//            Chunk c1 = new Chunk("fnukad % ", fon1);
//            Chunk c2 = new Chunk(dtf.format(now), font2);
//            Phrase phdate = new Phrase();
//            phdate.add(c1);
//            phdate.add(c2);
//
//            prLic.add(phdate);
//            prLic.setAlignment(Element.ALIGN_JUSTIFIED);
//            prLic.setSpacingBefore(2);
//            doc.add(prLic);
//           // #endregion
//            // I para of NOC
//           // #region Par1Hindi
//            Paragraph par1 = new Paragraph();
//            par1.setAlignment (Element.ALIGN_JUSTIFIED);
//            par1.setSpacingBefore(2);  
//            Phrase phr1 = new Phrase();
//
//            Chunk ch3 = new Chunk(RequestSDCHindi + " ", fon2);
//            phr1.add(ch3);
//            Chunk ch4 = new Chunk("ds jftLVªkj dks vius jftLVj ds Hkkx&, esa"+" ", fon1);
//            phr1.add(ch4);
//            //Chunk ch5 = new Chunk("is hereby directed to register ", font2);
//            //phr1.Add(ch5);
//            Chunk ch5 = new Chunk("M‚" + " ", fon1);
//            phr1.add(ch5);
//            Chunk ch6 = new Chunk(Name + " ", font1);
//            phr1.add(ch6);
//            Chunk ch7 = new Chunk("dks] ;fn og iathdj.k ds ;ksX; gS] iath—r djus dk funsZ'k fn;k tkrk gS] vkSj" + " ", fon1);
//            phr1.add(ch7);
//            Chunk ch8 = new Chunk(TransSDCHindi + " ", fon2);
//            phr1.add(ch8);
//            Chunk ch9 = new Chunk("ds jftLVªkj dks funsZ'k fn;k tkrk gS fd" + " ", fon1);
//            phr1.add(ch9);
//            Chunk ch10 = new Chunk(RequestSDCHindi + " ", fon2);
//            phr1.add(ch10);
//            String quote = "\"";
//            Chunk ch11 = new Chunk("ds lkFk iathdj.k dh iqf" + quote + "V gksus ij] vius jftLVj esa ls iathdj.k la[;k ", fon1);
//            phr1.add(ch11);
//            //Chunk ch12 = new Chunk(NocDate + " ", font1);
//            //phr1.Add(ch12);
//            //Chunk ch13 = new Chunk("of ", font2);
//            //phr1.Add(ch13);
//            //Chunk ch14 = new Chunk(TransSDC + " ", font1);
//            //phr1.Add(ch14);
//            //Chunk ch15 = new Chunk("holding registration No. ", font2);
//            //phr1.Add(ch15);
//            Chunk ch12 = new Chunk(RegistrationNo + " ", font1);
//            phr1.add(ch12);
//            Chunk ch13 = new Chunk("ds uke dks gVk ns A ", fon1);
//            phr1.add(ch13);
//            Chunk ch14 = new Chunk("", fon2);
//            phr1.add(ch14);
//            par1.add(phr1);
//           // #endregion
//            
//           // #region par1english
//            Paragraph pr1 = new Paragraph();
//            pr1.setAlignment(Element.ALIGN_JUSTIFIED);
//            pr1.setSpacingBefore(10);  
//            Phrase ph1 = new Phrase();
//
//            Chunk c3 = new Chunk("The Registrar of ", font2);
//            ph1.add(c3);
//            Chunk c4 = new Chunk(RequestSDC + " ", font1);
//            ph1.add(c4);
//            Chunk c5 = new Chunk("is hereby directed to register ", font2);
//            ph1.add(c5);
//            Chunk c6 = new Chunk("Dr. " + Name + " ", font1);
//            ph1.add(c6);
//            Chunk c7 = new Chunk("in Part-A of its Register, if the he/she otherwise eligible for registration and the Registrar of ", font2);
//            ph1.add(c7);
//            Chunk c8 = new Chunk(TransSDC + " ", font1);
//            ph1.add(c8);
//            Chunk c9 = new Chunk("is directed to delete his/her name from its Register Holding Registration No ", font2);
//            ph1.add(c9);
//            Chunk c10 = new Chunk(RegistrationNo + " ", font1);
//            ph1.add(c10);
//            Chunk c11 = new Chunk("upon confirmation of his/her Registration with ", font2);
//            ph1.add(c11);
//            Chunk c12 = new Chunk(RequestSDC + " ", font1);
//            ph1.add(c12);
//            Chunk c13 = new Chunk(".", font2);
//            ph1.add(c13);
//            pr1.add(ph1);
//          //  #endregion
//            
//            
//            // II para of NOC
//           // #region par2Hindi
//            Paragraph par2 = new Paragraph();
//            par2.setAlignment (Element.ALIGN_JUSTIFIED);
//            par2.setSpacingBefore(10);  
//            Phrase phr2 = new Phrase();
//            Chunk ch18 = new Chunk(";g vukifÙk çek.k&i= dsoy N% eghus rd gh ekU; gS vkSj bls dsoy ", fon1);
//            phr2.add(ch18);
//            Chunk ch19 = new Chunk("M‚" + " ", fon1);
//            phr2.add(ch19);
//            Chunk ch20 = new Chunk(Name + " ", font1);
//            phr2.add(ch20);
//            Chunk ch21 = new Chunk("dks" + " ", fon1);
//            phr2.add(ch21);
//            Chunk ch22 = new Chunk(TransSDCHindi + " ", fon2);
//            phr2.add(ch22);
//            String quotes = "\"";
//            Chunk ch23 = new Chunk("ls çkIr vukifÙk çek.k&i= ds vkèkkj ij] fcuk fdUgh rF;ksa vkSj nLrkost+ks dh lR;rk tkap ds] Hkkjrh; nar ifj" + quotes + "kn }kjk tkjh fd;k tk jgk gS A ", fon1);
//            phr2.add(ch23);
//            Chunk ch24 = new Chunk(RequestSDCHindi + " ", fon2);
//            phr2.add(ch24);
//            Chunk ch25 = new Chunk("iathdj.k ls igys bls HkyhHkk¡fr lqfuf'pr djsaA", fon1);
//            phr2.add(ch25);
//            par2.add(phr2);
//         //   #endregion
//          //  #region par2english
//            Paragraph pr2 = new Paragraph();
//            pr2.setAlignment( Element.ALIGN_JUSTIFIED);
//            pr2.setSpacingBefore(10);  
//            Phrase ph2 = new Phrase();
//            Chunk c18 = new Chunk("This NOC is valid only for a period of six months or has been issued by DCI in respect of ", font2);
//            ph2.add(c18);
//            Chunk c19 = new Chunk("Dr. " + Name + " ", font1);
//            ph2.add(c19);
//            Chunk c20 = new Chunk("only on the basis of the NOC received from ", font2);
//            ph2.add(c20);
//            Chunk c21 = new Chunk(TransSDC + " ", font1);
//            ph2.add(c21);
//            Chunk c22 = new Chunk("without ascertaining any veracity of facts and documents. ", font2);
//            ph2.add(c22);
//            Chunk c23 = new Chunk(RequestSDC + " ", font1);
//            ph2.add(c23);
//            Chunk c24 = new Chunk("shall ensure the same before registration.", font2);
//            ph2.add(c24);
//            pr2.add(ph2);
//           // #endregion
//
//            //para III of NOCParagraph pr3 = new Paragraph();
//          //  #region par3hindi
//            Paragraph par3 = new Paragraph();
//            par3.setAlignment (Element.ALIGN_JUSTIFIED);
//            par3.setSpacingBefore(10); 
//            Phrase phr3 = new Phrase();
//            Chunk ch26 = new Chunk("M‚- ", fon1);
//            phr3.add(ch26);
//            Chunk ch27 = new Chunk(Name + " ", font1);
//            phr3.add(ch27);
//            Chunk ch28 = new Chunk("dks funsZ'k fn;k tkrk gS fd vkxs dh vko';d dk;Zokgh ds fy," + " ", fon1);
//            phr3.add(ch28);
//            Chunk ch29 = new Chunk(RequestSDCHindi + " ", fon2);
//            phr3.add(ch29);
//            Chunk ch30 = new Chunk("ls laidZ djsa", fon1);
//            phr3.add(ch30);
//            par3.add(phr3);
//          //  #endregion
//
//          //  #region par3English
//            Paragraph pr3 = new Paragraph();
//            pr3.setAlignment(Element.ALIGN_JUSTIFIED);
//            pr3.setSpacingBefore(10);  
//            Phrase ph3 = new Phrase();
//            Chunk c25 = new Chunk("Dr. " + Name + " ", font1);
//            ph3.add(c25);
//            Chunk c26 = new Chunk("is hereby directed to approach to the ", font2);
//            ph3.add(c26);
//            Chunk c27 = new Chunk(RequestSDC + " ", font1);
//            ph3.add(c27);
//            Chunk c28 = new Chunk("for further necessary action.", font2);
//            ph3.add(c28);
//            pr3.add(ph3);
//           // #endregion
//
//            //adding above para in document
//            doc.add(par1);
//            doc.add(pr1);
//            doc.add(par2);
//            doc.add(pr2);
//            doc.add(par3);
//            doc.add(pr3);
//
//            //adding signature image in NOC
//            Image tif = Image.getInstance("" + "/Digital_sign.png");
//             tif.scalePercent(20f);
//             tif.setAlignment(Element.ALIGN_RIGHT);
//            //tif.setAbsolutePosition(350f, 215f);
//            doc.add(tif);
//
//            //hindi
//            Paragraph par4 = new Paragraph("lwpukFkZ vkSj vko';d dk;Zokgh gsrq çfrfyfi", fon1);
//            par4.setAlignment(Element.ALIGN_LEFT);
//            par4.setSpacingBefore(20); 
//            //english
//            Paragraph pr4 = new Paragraph("Copy for information and necessary action to:-", font2);
//             pr4.setAlignment ( Element.ALIGN_LEFT);
//            pr4.setSpacingBefore(2); 
//
//
//            Paragraph pr5 = new Paragraph();
//             pr5.setAlignment(Element.ALIGN_LEFT);
//            pr5.setSpacingBefore(2); 
//            Phrase ph4 = new Phrase();
//            Chunk ch31 = new Chunk("1- jftLVªkj", fon1);
//            Chunk chunk6 = new Chunk(":", font1);
//            Chunk ch32 = new Chunk(RequestSDCHindi + "", fon2);
//            Chunk chunk = new Chunk("/", font1);
//            Chunk c29 = new Chunk("Registrar:", font2);
//            Chunk c30 = new Chunk(RequestSDC + "", font1);
//            ph4.add(ch31);
//            ph4.add(chunk6);
//            ph4.add(ch32);
//            ph4.add(chunk);
//            ph4.add(c29);
//            ph4.add(c30);
//            pr5.add(ph4);
//
//
//            Paragraph pr6 = new Paragraph();
//            pr6.setAlignment(Element.ALIGN_LEFT);
//            Phrase ph5 = new Phrase();
//            Chunk c31 = new Chunk("   Ã&esy", fon1);
//            Chunk chunk1 = new Chunk(":", font1);
//            Chunk c32 = new Chunk(Email2, font1);
//            ph5.add(c31);
//            ph5.add(chunk1);
//            ph5.add(c32);
//            pr6.add(ph5);
//
//
//
//            Paragraph pr7 = new Paragraph();
//             pr7.setAlignment(Element.ALIGN_LEFT);
//            pr7.setSpacingBefore(2);
//            Phrase ph6 = new Phrase();
//            Chunk ch33 = new Chunk("2- jftLVªkj", fon1);
//            Chunk chunk7 = new Chunk(":", font1);
//            Chunk ch34 = new Chunk(TransSDCHindi + "", fon2);
//            Chunk chunk3 = new Chunk("/", font1);
//            Chunk c33 = new Chunk("Registrar: ", font2);
//            Chunk c34 = new Chunk(TransSDC , font1);
//            ph6.add(ch33);
//            ph6.add(chunk7);
//            ph6.add(ch34);
//            ph6.add(chunk3);
//            ph6.add(c33);
//            ph6.add(c34);
//            pr7.add(ph6);
//
//            Paragraph pr8 = new Paragraph();
//            pr8.setAlignment(Element.ALIGN_LEFT);
//            Phrase ph7 = new Phrase();
//            Chunk c35 = new Chunk("   Ã&esy", fon1);
//            Chunk chunk2 = new Chunk(":", font1);
//            Chunk c36 = new Chunk(Email1, font1);
//            ph7.add(c35);
//            ph7.add(chunk2);
//            ph7.add(c36);
//            pr8.add(ph7);
//
//
//
//            Paragraph pr9 = new Paragraph("", font2);
//             pr9.setAlignment(Element.ALIGN_LEFT);
//            pr9.setSpacingBefore(2);
//            pr8.setAlignment(Element.ALIGN_LEFT);
//            Phrase ph8 = new Phrase();
//            Chunk c37 = new Chunk("3- M‚DVj", fon1);
//            ph8.add(c37);
//            Chunk chunk5 = new Chunk("/", font2);
//            ph8.add(chunk5);
//            Chunk c38 = new Chunk("DR.", font2);
//            ph8.add(c38);
//            Chunk c39 = new Chunk(Name, font2);
//            ph8.add(c39);
//            pr9.add(ph8);
//
//
//
//            Paragraph pr10 = new Paragraph();
//            pr10.setAlignment(Element.ALIGN_LEFT);
//
//            Phrase ph10 = new Phrase();
//            Chunk c40 = new Chunk("   Ã&esy", fon1);
//            Chunk chunk4 = new Chunk(":", font1);
//            Chunk c41 = new Chunk(EmailID, font1);
//            ph10.add(c40);
//            ph10.add(chunk4);
//            ph10.add(c41);
//            pr10.add(ph10);
//
//            doc.add(par4);
//            doc.add(pr4);
//            doc.add(pr5);
//            doc.add(pr6);
//            doc.add(pr7);
//            doc.add(pr8);
//            doc.add(pr9);
//            doc.add(pr10);
//            
//            Image tiffooter = Image.getInstance("" + "/DCILetterFooter.png");
//            tiffooter.scalePercent(40,40); 
//            tiffooter.setSpacingBefore(40);
//            tiffooter.setAlignment(Element.ALIGN_CENTER);            
//            doc.add(tiffooter);
//            
//            doc.close();
//            outputStream.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return filePath;
//	}
	
	
	


}
