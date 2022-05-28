package com.bitutech.purchase.LPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.core.util.DropDownList;

@Repository
public class LpoDaoImpl implements LpoDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public LpoResultBean save(LpoBean bean) throws Exception {
		LpoResultBean resultBean = new LpoResultBean();
		try {
			Map<String, Object> lopMap = new HashMap<String, Object>();
			
		      lopMap.put("purchaseReqNo", bean.getPurchaseReqNo());
			lopMap.put("organizationName", bean.getOrganizationName());
			lopMap.put("poNo", bean.getPoNo());
			lopMap.put("requestType", bean.getRequestType());
			lopMap.put("poDate", bean.getPoDate());
			lopMap.put("woType", bean.getWoType());
			lopMap.put("purchaseType", bean.getPurchaseType());
			lopMap.put("purchaseFor", bean.getPurchaseFor());
			lopMap.put("vendorId", bean.getVendorId());
			lopMap.put("destinationLocation", bean.getDestinationLocation());
			lopMap.put("advance", bean.getAdvance());
			lopMap.put("currency", bean.getCurrency());
			lopMap.put("costCenter", bean.getCostCenter());
			lopMap.put("termsConditions", bean.getTermsConditions());
			lopMap.put("remarks", bean.getRemarks());
			lopMap.put("paymentTerms", bean.getPaymentTerms());
			lopMap.put("vendorAddress", bean.getVendorAddress());
			lopMap.put("vendorCity", bean.getVendorCity());
			lopMap.put("vendorState", bean.getVendorState()); 
			lopMap.put("vendorZip", bean.getVendorZip());
			lopMap.put("vendorCountry", bean.getVendorCountry());
			lopMap.put("destinationAddress", bean.getDestinationAddress());
			lopMap.put("destinationCity", bean.getDestinationCity());
			lopMap.put("destinationState", bean.getDestinationState());
			lopMap.put("destinationZip", bean.getDestinationZip());
			lopMap.put("destinationCountry", bean.getDestinationCountry()); 
			lopMap.put("subTotal", bean.getSubTotal());	    		
	   		 lopMap.put("discount", bean.getDiscount());
	   		 lopMap.put("cgst", bean.getCgst());
	   		 lopMap.put("sgst", bean.getSgst());
	   		 lopMap.put("igst", bean.getIgst());
	   		 lopMap.put("freight", bean.getFreight());
	   		 lopMap.put("freightTaxPercent", bean.getFreightTaxPercent());
	   		 lopMap.put("freightTotal", bean.getFreightTotal());
	   		 lopMap.put("otherCharges", bean.getOtherCharges());
	   		 lopMap.put("remarksOtherCharges", bean.getRemarksOtherCharges());
			 lopMap.put("total",bean.getTotal());
				  
			//	namedParameterJdbcTemplate.update(LpoQueryUtil.INSERT_LPO_HDR,lopMap);

			  
			Integer purchaseOrderId = namedParameterJdbcTemplate.queryForObject(LpoQueryUtil.INSERT_LPO_HDR,lopMap,Integer.class);

			  if(purchaseOrderId != null) {
					 
				     if(bean.getLpoDtlBeanOne().size()>0) {
				             
				    	 for(LpoDtlBeanOne lpoDtlBeanOne: bean.getLpoDtlBeanOne() )
		    {
				    		 Map<String, Object> lpoDtlOneMap = new HashMap<String, Object>();
				    		 		
			lpoDtlOneMap.put("purchaseOrderId",purchaseOrderId);	 
			lpoDtlOneMap.put("requisitionNo", lpoDtlBeanOne.getRequisitionNo());	    		
			lpoDtlOneMap.put("itemId", lpoDtlBeanOne.getItemId());
			lpoDtlOneMap.put("itemDescription", lpoDtlBeanOne.getItemDescription());
			lpoDtlOneMap.put("edd", lpoDtlBeanOne.getEdd());
			lpoDtlOneMap.put("purchaseUOM", lpoDtlBeanOne.getPurchaseUOM());
			lpoDtlOneMap.put("purchaseQty", lpoDtlBeanOne.getPurchaseQty());
			lpoDtlOneMap.put("vendorUOM", lpoDtlBeanOne.getVendorUOM());
			lpoDtlOneMap.put("vendorQty", lpoDtlBeanOne.getVendorQty());
			lpoDtlOneMap.put("availableQty", lpoDtlBeanOne.getAvailableQty());
			lpoDtlOneMap.put("unitPrice", lpoDtlBeanOne.getNetPrice());
			lpoDtlOneMap.put("oldUnitPrice",lpoDtlBeanOne.getOldUnitPrice());
			lpoDtlOneMap.put("price", lpoDtlBeanOne.getPrice());
			lpoDtlOneMap.put("discount", lpoDtlBeanOne.getDiscount());
			lpoDtlOneMap.put("discountType", lpoDtlBeanOne.getDiscountType());
			lpoDtlOneMap.put("discountPercent", lpoDtlBeanOne.getDiscountPercent());
			lpoDtlOneMap.put("netPrice", lpoDtlBeanOne.getNetPrice());
			lpoDtlOneMap.put("taxCGST", lpoDtlBeanOne.getTaxCGST());
			lpoDtlOneMap.put("taxSGST", lpoDtlBeanOne.getTaxSGST());
			lpoDtlOneMap.put("taxIGST", lpoDtlBeanOne.getTaxIGST());
			lpoDtlOneMap.put("taxCGSTinPercent", lpoDtlBeanOne.getTaxCGSTinPercent());
			lpoDtlOneMap.put("taxSGSTinPercent", lpoDtlBeanOne.getTaxSGSTinPercent());
			lpoDtlOneMap.put("taxIGSTinPercent", lpoDtlBeanOne.getTaxIGSTinPercent());
			lpoDtlOneMap.put("finalTotal", lpoDtlBeanOne.getFinalTotal());

			  namedParameterJdbcTemplate.update(LpoQueryUtil.INSERT_LPO_DTL_ONE,lpoDtlOneMap);
			  
			         }
			      }
			     }
			
			resultBean.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
		
	}
	//po no
	@Override
	public LpoResultBean getPoNo() throws Exception {
		// TODO Auto-generated method stub
		LpoResultBean resultBean = new LpoResultBean();
		String PoNo = jdbcTemplate.queryForObject(LpoQueryUtil.GET_PO_NO,String.class);
		resultBean.setPoNo(PoNo);
		return resultBean;
	}

	@Override
	public List<LpoBean> getAllList() throws Exception {
		// TODO Auto-generated method stub
		LpoResultBean resultBean = new LpoResultBean();
		List<LpoBean> salesCallEntryBeanList = new ArrayList<LpoBean>();
		try {
			salesCallEntryBeanList = jdbcTemplate.query(LpoQueryUtil.getList, new BeanPropertyRowMapper<LpoBean>(LpoBean.class));
			resultBean.setLpoDetails(salesCallEntryBeanList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return salesCallEntryBeanList;
	}
//edit
	@Override
	public LpoResultBean edit(Integer bean) throws Exception {
		LpoResultBean resultBean = new LpoResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setLpoBean(jdbcTemplate.queryForObject(LpoQueryUtil.SELECT_LPO_HDR,new Object[] { bean }, new BeanPropertyRowMapper<LpoBean>(LpoBean.class)));
			
			List<LpoDtlBeanOne> lpoDtlBeanOne = jdbcTemplate.query(LpoQueryUtil.SELECT_LPO_DTL_ONE,new Object[] { bean },new BeanPropertyRowMapper<LpoDtlBeanOne>(LpoDtlBeanOne.class));	
			  resultBean.setLpoDtlBeanOne(lpoDtlBeanOne);		
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
	public LpoResultBean update(LpoBean bean) throws Exception {
		LpoResultBean resultBean = new LpoResultBean();
		try {
			Map<String, Object> lopMap = new HashMap<String, Object>();
			
			lopMap.put("purchaseOrderId", bean.getPurchaseOrderId());
			lopMap.put("purchaseReqNo", bean.getPurchaseReqNo());
			lopMap.put("organizationName", bean.getOrganizationName());
			lopMap.put("poNo", bean.getPoNo());
			lopMap.put("requestType", bean.getRequestType());
			lopMap.put("poDate", bean.getPoDate());
			lopMap.put("woType", bean.getWoType());
			lopMap.put("purchaseType", bean.getPurchaseType());
			lopMap.put("purchaseFor", bean.getPurchaseFor());
			lopMap.put("vendorId", bean.getVendorId());
			lopMap.put("destinationLocation", bean.getDestinationLocation());
			lopMap.put("advance", bean.getAdvance());
			lopMap.put("currency", bean.getCurrency());
			lopMap.put("costCenter", bean.getCostCenter());
			lopMap.put("termsConditions", bean.getTermsConditions());
			lopMap.put("remarks", bean.getRemarks());
			lopMap.put("paymentTerms", bean.getPaymentTerms());
			lopMap.put("vendorAddress", bean.getVendorAddress());
			lopMap.put("vendorCity", bean.getVendorCity());
			lopMap.put("vendorState", bean.getVendorState()); 
			lopMap.put("vendorZip", bean.getVendorZip());
			lopMap.put("vendorCountry", bean.getVendorCountry());
			lopMap.put("destinationAddress", bean.getDestinationAddress());
			lopMap.put("destinationCity", bean.getDestinationCity());
			lopMap.put("destinationState", bean.getDestinationState());
			lopMap.put("destinationZip", bean.getDestinationZip());
			lopMap.put("destinationCountry", bean.getDestinationCountry()); 
			lopMap.put("subTotal", bean.getSubTotal());	    		
	   		 lopMap.put("discount", bean.getDiscount());
	   		 lopMap.put("cgst", bean.getCgst());
	   		 lopMap.put("sgst", bean.getSgst());
	   		 lopMap.put("igst", bean.getIgst());
	   		 lopMap.put("freight", bean.getFreight());
	   		 lopMap.put("freightTaxPercent", bean.getFreightTaxPercent());
	   		 lopMap.put("freightTotal", bean.getFreightTotal());
	   		 lopMap.put("otherCharges", bean.getOtherCharges());
	   		 lopMap.put("remarksOtherCharges", bean.getRemarksOtherCharges());
				lopMap.put("total",bean.getTotal());

			namedParameterJdbcTemplate.update(LpoQueryUtil.UPDATE_LPO_HDR,lopMap);
			
			if(bean.getLpoDtlBeanOne().size()>0) {
				jdbcTemplate.update(LpoQueryUtil.DELETE_LPO_DTL_ONE,bean.getPurchaseOrderId());	 
				
			    	for(LpoDtlBeanOne lpoDtlBeanOne: bean.getLpoDtlBeanOne() ){
			    	
				    		 Map<String, Object> lpoDtlOneMap = new HashMap<String, Object>();
				    		 lpoDtlOneMap.put("requisitionNo", lpoDtlBeanOne.getPurchaseOrderId());	 
				    		 lpoDtlOneMap.put("requisitionNo", lpoDtlBeanOne.getRequisitionNo());	    		
				    		 lpoDtlOneMap.put("itemId", lpoDtlBeanOne.getItemId());
				 			lpoDtlOneMap.put("itemDescription", lpoDtlBeanOne.getItemDescription());
				 			lpoDtlOneMap.put("edd", lpoDtlBeanOne.getEdd());
				 			lpoDtlOneMap.put("purchaseUOM", lpoDtlBeanOne.getPurchaseUOM());
				 			lpoDtlOneMap.put("purchaseQty", lpoDtlBeanOne.getPurchaseQty());
				 			lpoDtlOneMap.put("vendorUOM", lpoDtlBeanOne.getVendorUOM());
				 			lpoDtlOneMap.put("vendorQty", lpoDtlBeanOne.getVendorQty());
				 			lpoDtlOneMap.put("availableQty", lpoDtlBeanOne.getAvailableQty());
				 			lpoDtlOneMap.put("unitPrice", lpoDtlBeanOne.getNetPrice());
				 			lpoDtlOneMap.put("oldUnitPrice",lpoDtlBeanOne.getOldUnitPrice());
				 			lpoDtlOneMap.put("price", lpoDtlBeanOne.getPrice());
				 			lpoDtlOneMap.put("discount", lpoDtlBeanOne.getDiscount());
				 			lpoDtlOneMap.put("discountType", lpoDtlBeanOne.getDiscountType());
				 			lpoDtlOneMap.put("discountPercent", lpoDtlBeanOne.getDiscountPercent());
				 			lpoDtlOneMap.put("netPrice", lpoDtlBeanOne.getNetPrice());
				 			lpoDtlOneMap.put("taxCGST", lpoDtlBeanOne.getTaxCGST());
							lpoDtlOneMap.put("taxSGST", lpoDtlBeanOne.getTaxSGST());
							lpoDtlOneMap.put("taxIGST", lpoDtlBeanOne.getTaxIGST());
							lpoDtlOneMap.put("taxCGSTinPercent", lpoDtlBeanOne.getTaxCGSTinPercent());
							lpoDtlOneMap.put("taxSGSTinPercent", lpoDtlBeanOne.getTaxSGSTinPercent());
							lpoDtlOneMap.put("taxIGSTinPercent", lpoDtlBeanOne.getTaxIGSTinPercent());
							lpoDtlOneMap.put("finalTotal", lpoDtlBeanOne.getFinalTotal());

				  
							  namedParameterJdbcTemplate.update(LpoQueryUtil.INSERT_LPO_DTL_ONE,lpoDtlOneMap);
			    } 
			    
			    }

			resultBean.setSuccess(true);
		}
		catch(Exception e){
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public LpoResultBean delete(Integer purchaseOrderId) throws Exception {
		LpoResultBean resultBean = new LpoResultBean();
		resultBean.setSuccess(false);
		try {
			if(purchaseOrderId!=null) {
				jdbcTemplate.update(LpoQueryUtil.DELETE_LPO_HDR,purchaseOrderId);
				jdbcTemplate.update(LpoQueryUtil.DELETE_LPO_DTL_ONE,purchaseOrderId);
				//jdbcTemplate.update(LpoQueryUtil.DELETE_GRN_DTL,purchaseOrderId);
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}
	//po no list
	@Override
	public LpoResultBean getPoNoList() throws Exception {
		// TODO Auto-generated method stub
		List<DropDownList> poNoList = new ArrayList<>();
		LpoResultBean resultBean = new LpoResultBean();
		try {
			poNoList = jdbcTemplate.query(LpoQueryUtil.GET_PO_NO_LIST,new BeanPropertyRowMapper<DropDownList>(DropDownList.class));
			resultBean.setPoNoList(poNoList);
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public LpoResultBean getVendorAddress(int vendorId) {
		// TODO Auto-generated method stub
		LpoResultBean bean = new LpoResultBean();
		try {
			List<LpoBean> lPoGrnBean = jdbcTemplate.query(LpoQueryUtil.GET_VENDOR_ADDRESS, new Object[] { vendorId }, new BeanPropertyRowMapper<>(LpoBean.class));
			bean.setlVendorAddressDtl(lPoGrnBean);
			//getPOListForVendor(vendorId, bean, jdbcTemplate);
		} catch (DataAccessException e) {
			//LOGGER.error("Error in List", e);
		}
		return bean;
	}
	@Override
	public LpoResultBean getRequisition(String requisitionNo) {
		// TODO Auto-generated method stub
		LpoResultBean bean = new LpoResultBean();
		try {
			List<LpoDtlBeanOne> lPoGrnBean = jdbcTemplate.query(LpoQueryUtil.REQUISITION, new Object[] { requisitionNo }, new BeanPropertyRowMapper<>(LpoDtlBeanOne.class));
			bean.setlRequisitionList(lPoGrnBean);
			//bean.setlRequisitionDtl(getRequisitionList(requisitionNo));
		} catch (DataAccessException e) {
			//LOGGER.error("Error in List", e);
		}
		return bean;
	}

}
