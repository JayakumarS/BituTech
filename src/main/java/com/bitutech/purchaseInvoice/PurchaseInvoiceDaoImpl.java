package com.bitutech.purchaseInvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.common.QRCode;
import org.springframework.beans.factory.annotation.Value;


@Repository
public class PurchaseInvoiceDaoImpl implements PurchaseInvoiceDao{

	@Value("${qrcode.files.path}")
	private String qrPath;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Override
	public PurchaseInvoiceResultBean save(PurchaseInvoiceBean bean) throws Exception {
		// TODO Auto-generated method stub
		PurchaseInvoiceResultBean resultBean = new PurchaseInvoiceResultBean();
		resultBean.setSuccess(false);
		try {
			Map<String, Object> purchaseInvoiceMap = new HashMap<String, Object>();
			
			String purchaseInvoiceNumber =  jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.GetPurchaseInvoiceNo, 
					String.class);
			
			purchaseInvoiceMap.put("purchaseInvoiceNo",purchaseInvoiceNumber);
			purchaseInvoiceMap.put("invoiceDate",bean.getInvoiceDate());
			purchaseInvoiceMap.put("companyName", bean.getCompanyName());
			purchaseInvoiceMap.put("manualInvoiceNo", bean.getManualInvoiceNo());
			purchaseInvoiceMap.put("quotation", bean.getQuotation());
			purchaseInvoiceMap.put("currency",bean.getCurrency());
			purchaseInvoiceMap.put("dueDate", bean.getDueDate());
			purchaseInvoiceMap.put("customer", bean.getCustomer());
			purchaseInvoiceMap.put("exchangeRate",bean.getExchangeRate());
			purchaseInvoiceMap.put("type", bean.getType());
			purchaseInvoiceMap.put("narration", bean.getNarration());
			
			String purchaseInvoiceHdr = namedParameterJdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.INSERT_PURCHASE_INVOICE,purchaseInvoiceMap,String.class);
			
			if(purchaseInvoiceHdr != null) {
				if(bean.getPurchaseInvoiceDetailBean().size()>0) {
					for(PurchaseInvoiceDetailBean purchaseInvoiceDetailBean:bean.getPurchaseInvoiceDetailBean())
					{
						Map<String, Object> purchaseInvoiceDtlMap = new HashMap<String, Object>();
						
						purchaseInvoiceDtlMap.put("purchaseInvoiceNo",purchaseInvoiceNumber);
						purchaseInvoiceDtlMap.put("detailItem",purchaseInvoiceDetailBean.getDetailItem());
						purchaseInvoiceDtlMap.put("detailQuantity", purchaseInvoiceDetailBean.getDetailQuantity());
						purchaseInvoiceDtlMap.put("detailUnitPrice", purchaseInvoiceDetailBean.getDetailUnitPrice());
						purchaseInvoiceDtlMap.put("detailTaxAmount", purchaseInvoiceDetailBean.getDetailTaxAmount());
						purchaseInvoiceDtlMap.put("detailAmount",purchaseInvoiceDetailBean.getDetailAmount());
						purchaseInvoiceDtlMap.put("detailCharges", purchaseInvoiceDetailBean.getDetailCharges());
						purchaseInvoiceDtlMap.put("detailShortDetails", purchaseInvoiceDetailBean.getDetailShortDetails());
						purchaseInvoiceDtlMap.put("detailSecondRowAmount",purchaseInvoiceDetailBean.getDetailSecondRowAmount());
					
						namedParameterJdbcTemplate.update(PurchaseInvoiceQueryUtil.INSERT_PURCHASE_INVOICE_DTL,purchaseInvoiceDtlMap);
					
					}
				}
			}
			
			// QR Code
			
			String QRData = "Purchase Invoice No : "+purchaseInvoiceNumber+" Company Name : "+bean.getCompanyName()+" Quotation : "+bean.getQuotation()+" Due Date : "+bean.getDueDate() ;
		
			
			try {
				String qrCodePath = QRCode.createQR(QRData,purchaseInvoiceNumber,qrPath);
				
				// For saving the file into Database
				jdbcTemplate.update(
						"UPDATE purchase_invoice_hdr SET modified_by=? WHERE invoice_no=?",
						new Object[] { qrCodePath,purchaseInvoiceNumber});

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public List<PurchaseInvoiceBean> getPurchaseInvoiceList() throws Exception {
		// TODO Auto-generated method stub
		PurchaseInvoiceResultBean resultBean = new PurchaseInvoiceResultBean();
		List<PurchaseInvoiceBean> objPurchaseBean = new ArrayList<PurchaseInvoiceBean>();
		try {
			objPurchaseBean = jdbcTemplate.query(PurchaseInvoiceQueryUtil.SELECT_PURCHASE_INVOICE, new BeanPropertyRowMapper<PurchaseInvoiceBean>(PurchaseInvoiceBean.class));
			
			  resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objPurchaseBean;
	}

	@Override
	public PurchaseInvoiceResultBean edit(String purchaseValue) throws Exception {
		// TODO Auto-generated method stub
		PurchaseInvoiceResultBean resultBean = new PurchaseInvoiceResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setPurchaseInvoiceBean(jdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.getPurchaseInvoiceList,new Object[] { purchaseValue }, new BeanPropertyRowMapper<PurchaseInvoiceBean>(PurchaseInvoiceBean.class)));
		
			List<PurchaseInvoiceDetailBean> creditNoteDetailBean = jdbcTemplate.query(PurchaseInvoiceQueryUtil.SELECT_PURCHASE_INVOICE_DTL,new Object[] { purchaseValue },new BeanPropertyRowMapper<PurchaseInvoiceDetailBean>(PurchaseInvoiceDetailBean.class));	
			  resultBean.setPurchaseInvoiceDetailBean(creditNoteDetailBean);		
			  resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
		
	}

	@Override
	public PurchaseInvoiceResultBean update(PurchaseInvoiceBean bean) throws Exception {
		// TODO Auto-generated method stub
		PurchaseInvoiceResultBean resultBean = new PurchaseInvoiceResultBean();
		try {
			Map<String, Object> purchaseInvoiceMap = new HashMap<String, Object>();
		
			purchaseInvoiceMap.put("invoiceDate",bean.getInvoiceDate());
			purchaseInvoiceMap.put("companyName", bean.getCompanyName());
			purchaseInvoiceMap.put("manualInvoiceNo", bean.getManualInvoiceNo());
			purchaseInvoiceMap.put("quotation", bean.getQuotation());
			purchaseInvoiceMap.put("currency",bean.getCurrency());
			purchaseInvoiceMap.put("dueDate", bean.getDueDate());
			purchaseInvoiceMap.put("customer", bean.getCustomer());
			purchaseInvoiceMap.put("exchangeRate",bean.getExchangeRate());
			purchaseInvoiceMap.put("type", bean.getType());
			purchaseInvoiceMap.put("narration", bean.getNarration());
			
			String creditNodeHrd = namedParameterJdbcTemplate.queryForObject(PurchaseInvoiceQueryUtil.UPDATE_PURCHASE_INVOICE,purchaseInvoiceMap,String.class);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public PurchaseInvoiceResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		PurchaseInvoiceResultBean resultBean = new PurchaseInvoiceResultBean();
		try {
			if(bean!=null) {
				jdbcTemplate.update(PurchaseInvoiceQueryUtil.DELETE_PURCHASE_INVOICE,bean);
				
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;	
	}

}
