package com.bitutech.grn;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitutech.core.util.CustomException;

@Repository
public class GRNDaoImpl implements GRNDao {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(GRNDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public GRNResultBean getPOList() {
		// TODO Auto-generated method stub
		GRNResultBean bean = new GRNResultBean();
		try {
			//UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			// List<GRNBean> lPoGrnBean =
			// jdbcTemplate.query(GRNQueryUtil.GET_PO_LIST, new Object[] { 47,
			// 138, userDetails.getCompanyCode() }, new
			// BeanPropertyRowMapper<GRNBean>(GRNBean.class));
			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_LIST, new Object[] { 47, 138 }, new BeanPropertyRowMapper<>(GRNBean.class));

			bean.setlPurchaseOrder(lPoGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getPODtlList(int poId) {
		// TODO Auto-generated method stub
		GRNResultBean bean = new GRNResultBean();
		List<GRNPurchaseOrderBean> list = new ArrayList<>();
		List<GRNPurchaseOrderBean> consignmentBatchList = new ArrayList<>();

		try {
			List<GRNPurchaseOrderBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_PO_DTL_LIST, new Object[] { poId, poId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GRNQueryUtil.GET_CONSIGNMENT_TRANSFER_DETAILS, new Object[] { poId });

			/*
			 * for (Map row : rows) {
			 * 
			 * if ((int) row.get("purchasetype") == 45) {
			 * 
			 * int consignmentTransferNumber = (int) row.get("consignmentTransferId");
			 * 
			 * consignmentBatchList =
			 * jdbcTemplate.query(GRNQueryUtil.GET_CONSIGNEMNT_STOCK_TRANSFER_DETAIL_ID, new
			 * Object[] { consignmentTransferNumber }, new
			 * BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			 * 
			 * for (int i = 0; i < lPoGrnBean.size(); i++) { List<GRNPurchaseOrderBean>
			 * batchDetailsConsignment = new ArrayList<>(); if (consignmentBatchList !=
			 * null) { batchDetailsConsignment =
			 * jdbcTemplate.query(GRNQueryUtil.GET_CONSIGNMETN_BATCH_DETAILS, new Object[] {
			 * consignmentBatchList.get(i).getStockTransferDetailId(),
			 * lPoGrnBean.get(i).getDtlItemId() }, new
			 * BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class)); }
			 * 
			 * lPoGrnBean.get(i).setBatchDtls(batchDetailsConsignment); }
			 * 
			 * }
			 * 
			 * }
			 
			*/
			for (GRNPurchaseOrderBean grnPurchaseOrderBean : lPoGrnBean) {
				List<GRNPurchaseOrderBean> lSchGrnBean = jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] { grnPurchaseOrderBean.getDtlPODtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
				grnPurchaseOrderBean.setScheduleList(lSchGrnBean);
				list.add(grnPurchaseOrderBean);
			}

			int count = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_COUNT_IN_GRN, Integer.class, poId);
			if (count > 0) {
				List<Map<String, Object>> row = jdbcTemplate.queryForList(GRNQueryUtil.GET_FREIGHT_OTHER_IN_GRN, new Object[] { poId });

				for (Map row1 : row) {
					
					  bean.setGrnFreight(Double.parseDouble(row1.get("freight").toString()));
					  bean.setGrnOtherCharges(Double.parseDouble(row1.get("other_charges").toString()));
					 
				}
			}
			bean.setlPurchaseOrderDtl(list);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getRequisition(int poId) {
		// TODO Auto-generated method stub
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GRN_REQUISITION, new Object[] { poId }, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlRequisitionList(lPoGrnBean);
			bean.setlRequisitionDtl(getRequisitionList(poId));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}
	
	private List<GRNPurchaseOrderBean> getRequisitionList(int poId) {
		List<GRNPurchaseOrderBean> lPoGrnDtlBean = new ArrayList<>();
		try {
			lPoGrnDtlBean = jdbcTemplate.query(GRNQueryUtil.GRN_REQ_DTL, new Object[] { poId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			// throw new CustomException("");
		}
		return lPoGrnDtlBean;
	}

	@Override
	public GRNResultBean getParentLocationList() {
		// TODO Auto-generated method stub
		List<GRNBean> locationList = new ArrayList<>();
		GRNResultBean bean = new GRNResultBean();
		try {
			locationList = jdbcTemplate.query(GRNQueryUtil.GRN_LOC_LIST, new Object[] {  }, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlLocationLst(locationList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			// throw new CustomException("");
		}
		return bean;
	
	}

	@Override
	public GRNResultBean getVendorAddress(int vendorId) {
		// TODO Auto-generated method stub
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNPurchaseOrderBean> lPoGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_VENDOR_ADDRESS, new Object[] { vendorId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
			bean.setlVendorAddressDtl(lPoGrnBean);
			//getPOListForVendor(vendorId, bean, jdbcTemplate);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}

	@Override
	public GRNResultBean getVendorList() {
		// TODO Auto-generated method stub
		GRNResultBean bean = new GRNResultBean();
		try {
			List<GRNBean> lVendorGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_VENDOR_LIST, new BeanPropertyRowMapper<>(GRNBean.class));
			bean.setlVendor(lVendorGrnBean);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	
	}

	@Override
	public String grnAutoIncrementNo() {
		// TODO Auto-generated method stub
		String str = "";
		try {
			str = jdbcTemplate.queryForObject(GRNQueryUtil.GRN_AUTO_GENERATE, String.class);
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return str;
	}

	@Override
	public boolean saveGrn(GRNBean bean) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;

		try {
			bean.setGrnCode(grnAutoIncrementNo());
			int grnId = 0;
			bean.setCreatedBy("E0001");
			grnId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_GRN_HDR, new Object[] { bean.getGrnCode(), bean.getGrnDate(), bean.getPoId(), bean.getPoRequisitionId(), bean.getVendorId(), bean.getDelOrderNo(), bean.getDelOrderDate(), bean.getInvoiceNo(), bean.getInvoiceDate(), bean.getDeliveryMthd(), bean.getTransMode(), bean.getLocId(), bean.getDstLocId(), bean.getCompanyId(), bean.getDueDate(), bean.getDescription(), bean.getFreight(), bean.getOtherCharges(), bean.getCreatedBy() }, Integer.class);
			// int grnId = keyHolder.getKey().intValue();

			if (grnId > 0) {
				isSuccess = saveGrnDtl(bean, grnId);
				if (bean.getPoType().equalsIgnoreCase("Rate Contract")) {
					isSuccess = 
				updatePOSchedule(bean.getScheduleData());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	private boolean updatePOSchedule(List<GRNPurchaseOrderBean> schDtlList) throws Exception {
		boolean isSuccess = false;
		int status = 0, dtlStatus = 0, pendingQty = 0;
		try {
			for (GRNPurchaseOrderBean objBean : schDtlList) {
				if (objBean.getSelect() != null && !"".equalsIgnoreCase(objBean.getSelect())) {
					if (objBean.getSelect().equalsIgnoreCase("true")) {
						pendingQty = objBean.getSchedulePendingQty() - objBean.getScheduleItemQty();

						if (pendingQty == 0) {
							status = 139;
						} else {
							status = 138;
						}

						dtlStatus = jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_SCHEDULE_STATUS, new Object[] { pendingQty, objBean.getScheduleId() });
					}
				}

				if (dtlStatus > 0) {
					isSuccess = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}


	private boolean saveGrnDtl(GRNBean bean, int grnId) {
		// TODO Auto-generated method stub
		boolean isSuccess = false, status = true;
		double dTotalGrnAmount = 0;
		try {
			List<GRNPurchaseOrderBean> alDetailList = bean.getPoDetailData();

			int poCnt = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_CNT_IN_GRN, new Object[] { bean.getPoId() }, Integer.class);

			if (poCnt == 1)
				dTotalGrnAmount = bean.getPoFreight();

			for (GRNPurchaseOrderBean objGRNPurchaseOrderBean : alDetailList) {

				double availablePendingQty = (objGRNPurchaseOrderBean.getPendingQty() - objGRNPurchaseOrderBean.getDtlQty());
//converted qty and converted qty new - same 
				int dtlId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_GRN_DTL, new Object[] { grnId, objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getCostcenter(), objGRNPurchaseOrderBean.getDtlQty(), availablePendingQty, objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getDtlPODtlId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.isConvertedQtyFlag(), objGRNPurchaseOrderBean.getBalanceConvertedQtyNew() }, Integer.class);

				int poDtlCnt = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_DTL_QTY, new Object[] { objGRNPurchaseOrderBean.getDtlPODtlId() }, Integer.class);

				if (poDtlCnt == 1)
					
					dTotalGrnAmount += (objGRNPurchaseOrderBean.getDtlPrice() * objGRNPurchaseOrderBean.getDtlQty()) + objGRNPurchaseOrderBean.getDtlTax() - objGRNPurchaseOrderBean.getDtlDisc();
				else
					dTotalGrnAmount += objGRNPurchaseOrderBean.getDtlPrice() * objGRNPurchaseOrderBean.getDtlQty();

				if (dtlId > 0) {
					if (objGRNPurchaseOrderBean.getDtlQty() == objGRNPurchaseOrderBean.getPendingQty()) {
						jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_DTL_STATUS, new Object[] { 72, objGRNPurchaseOrderBean.getDtlPODtlId() });
						status = false;
					} else {
						jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_DTL_STATUS, new Object[] { 144, objGRNPurchaseOrderBean.getDtlPODtlId() });
					}
					objGRNPurchaseOrderBean.setBatchDetails(objGRNPurchaseOrderBean.getBatchDetails());

					if (!bean.getPoType().equalsIgnoreCase("Consignment Po")) {

						updateInventoryAndLedgerIn(bean.getGrnCode(), bean.getGrnDate(), 88, bean.getLocId(), bean.getDstLocId(), objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getBatchDetails());
						updateInventoryAndLedgerOut(bean.getGrnCode(), bean.getGrnDate(), 88, bean.getDstLocId(), bean.getLocId(), objGRNPurchaseOrderBean.getDtlItemId(), objGRNPurchaseOrderBean.getConvertedQty(), objGRNPurchaseOrderBean.getBatchDetails());
					}
					isSuccess = true;
				}

				isSuccess = saveGrnBatchDtl(objGRNPurchaseOrderBean, dtlId);
			}

			
			int minStatus = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_STATUS, new Object[] { bean.getPoId() }, Integer.class);
			int maxStatus = jdbcTemplate.queryForObject(GRNQueryUtil.GET_PO_MAX_STATUS, new Object[] { bean.getPoId() }, Integer.class);

			if (minStatus == 72 || maxStatus == 144 || minStatus == 144 || maxStatus == 72) {
				jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_STATUS, new Object[] { 138, bean.getPoId() });
			} else if (minStatus == 143 && maxStatus == 143) {
				jdbcTemplate.update(GRNQueryUtil.UPDATE_PO_STATUS, new Object[] { 139, bean.getPoId() });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	private boolean saveGrnBatchDtl(GRNPurchaseOrderBean objGRNPurchaseOrderBean, int grnDtlId) throws Exception {
		boolean isSuccess = false;
		
		int count = 0;
		try {
			List<GRNPurchaseOrderBean> alDetailList = objGRNPurchaseOrderBean.getBatchDetails();
			for (GRNPurchaseOrderBean objBean : alDetailList) {

//								
//				count = jdbcTemplate.update(GRNQueryUtil.COUNT_GRN_BATCH_DTL, new Object[] { grnDtlId});
//				
//				if (count > 0) {
//				
//					jdbcTemplate.update(GRNQueryUtil.DELETE_GRN_BATCH_DTL, new Object[] { grnDtlId});
//				}
				int dtlStatus = jdbcTemplate.update(GRNQueryUtil.SAVE_GRN_BATCH_DTL, new Object[] { grnDtlId, objBean.getBatchItemId(), objBean.getLotNo(), objBean.getBatchQty(), objBean.getManufactureDef(), objBean.getMrp(), objBean.getOriginalConvertedQty() });

				if (dtlStatus > 0) {
					isSuccess = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}


	private boolean updateInventoryAndLedgerOut(String formCode, String formDate, int type, int srclocId, int destLocId,	int itemId, double qnty, List<GRNPurchaseOrderBean> batchAttributeBeans) {
		// TODO Auto-generated method stub
		try {
			double qty = 0;
			int batchLocation = 0;
			//String transLoc = "%" + transLocation + "%";

			boolean isQc = false;

//			if (type == 123 || type == 107 || type == 147) {
//				srcLocId = getTransitLocation(transLoc, jdbcTemplate);
//
//			} else if (type == 142 || type == 161) {
//				destLocId = getTransitLocation(transLoc, jdbcTemplate) ;
//
//			} else 
//			if (type == 88) {
//				isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
//				if (isQc)
//				srclocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
//			} 
//				else if (type == 149) {
//				isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
//				if (isQc)
//					destLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
//			} else if (type == 106) {
//
//				String consLoc = "%" + consumedLocation + "%";
//
//				int consumeLocation = jdbcTemplate.queryForObject(GRNQueryUtil.GET_TRANSIT_LOCATION, new Object[] { consLoc }, Integer.class);
//
//				batchLocation = destLocId;
//
//				destLocId = consumeLocation;
//
//			}

			int inventryExst = jdbcTemplate.queryForObject(GRNQueryUtil.INVENTORY_EXISTS, new Object[] { destLocId, itemId }, Integer.class);

			if (inventryExst > 0) {
				double InventryQTY = jdbcTemplate.queryForObject(GRNQueryUtil.INVENTORY_HAND_QUANTITY, new Object[] { destLocId, itemId }, Double.class);
				qty = InventryQTY - qnty;

				jdbcTemplate.update(GRNQueryUtil.UPDATE_INVENTORY, new Object[] { formDate, qty, itemId, destLocId });
			} else {
				qty = -qnty;

				jdbcTemplate.update(GRNQueryUtil.SAVE_INVENTORY, new Object[] { formDate, destLocId, itemId, qty });
			}

			int inventoryId = jdbcTemplate.queryForObject(GRNQueryUtil.MAX_INVENTORY, new Object[] { destLocId, itemId }, Integer.class);

			int stockId = 0;
			if (type == 106) {
				Object[] params = new Object[] { inventoryId, batchLocation, null, qnty, 0, formDate, type, formCode };
				stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);
			} else {
				Object[] params = new Object[] { inventoryId, destLocId, null, qnty, 0, formDate, type, formCode };
				stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);
			}
//
			if (batchAttributeBeans != null) {
				if (batchAttributeBeans.size() > 0) {

					for (GRNPurchaseOrderBean batchAttributeBean : batchAttributeBeans) {
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

						Date exdate = null;
						if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
							exdate = df.parse(batchAttributeBean.getExpiryDate());

						}
//						if (type == 106) {//need to check the types
//							jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getBatchItemId(), batchAttributeBean.getLotNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufactureDef(), batchAttributeBean.getMrp(), batchLocation, null, 0, batchAttributeBean.getOriginalConvertedQty() });
//						} else {
							jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getBatchItemId(), batchAttributeBean.getLotNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufactureDef(), batchAttributeBean.getMrp(), destLocId, null, 0, batchAttributeBean.getOriginalConvertedQty() });
						//}

					}

				}

			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}

	private boolean updateInventoryAndLedgerIn(String formCode, String formDate, int type, int srclocId, int destLocId,int itemId, double qnty, List<GRNPurchaseOrderBean> batchAttributeBeans) {//translocation to be added
		
		try {
			double qty = 0;
			//String transLoc = "%" + transLocation + "%";
			boolean isQc = false;
//
//			if (type == 123 || type == 106 || type == 107 || type == 147) {
//				destLocId = getTransitLocation(transLoc, jdbcTemplate);
//			} else if (type == 142 || type == 161) {
//
//				srcLocId = getTransitLocation(transLoc, jdbcTemplate);
//
//			} else 
//			if (type == 88) {
//				isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
//				if (isQc)
//					destLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
//			} 
//				else if (type == 149) {
//				isQc = jdbcTemplate.queryForObject(GRNQueryUtil.CHECK_QC_FOR_ITEM, new Object[] { itemId }, Boolean.class);
//				if (isQc)
//					srcLocId = jdbcTemplate.queryForObject(GRNQueryUtil.GET_QC_LOCATION, new Object[] { formCode }, Integer.class);
//			}

			int inventryExst = jdbcTemplate.queryForObject(GRNQueryUtil.INVENTORY_EXISTS, new Object[] { destLocId, itemId }, Integer.class);

			if (inventryExst > 0) {
				double InventryQTY = jdbcTemplate.queryForObject(GRNQueryUtil.INVENTORY_HAND_QUANTITY, new Object[] { destLocId, itemId }, Double.class);

				qty = InventryQTY + qnty;

				jdbcTemplate.update(GRNQueryUtil.UPDATE_INVENTORY, new Object[] { formDate, qty, itemId, destLocId });
			} else {

				qty = qnty;
				jdbcTemplate.update(GRNQueryUtil.SAVE_INVENTORY, new Object[] { formDate, destLocId, itemId, qty });
			}

			int inventoryId = jdbcTemplate.queryForObject(GRNQueryUtil.MAX_INVENTORY, new Object[] { destLocId, itemId }, Integer.class);

			Object[] params = new Object[] { inventoryId, null, destLocId, 0, qnty, formDate, type, formCode };

			int stockId = jdbcTemplate.queryForObject(GRNQueryUtil.SAVE_STOCK_LEDGER_NEW, params, Integer.class);

			if (batchAttributeBeans != null) {

				if (batchAttributeBeans.size() > 0) {

					for (GRNPurchaseOrderBean batchAttributeBean : batchAttributeBeans) {
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						String expDate = null;
						Date exdate = null;
						if (batchAttributeBean.getExpiryDate() != null && !batchAttributeBean.getExpiryDate().isEmpty() && batchAttributeBean.getExpiryDate() != "") {
							exdate = df.parse(batchAttributeBean.getExpiryDate());

						}

						jdbcTemplate.update(GRNQueryUtil.SAVE_STOCK_LEDGER_BATCH, new Object[] { stockId, batchAttributeBean.getBatchItemId(), batchAttributeBean.getLotNo(), batchAttributeBean.getBatchQty(), exdate, batchAttributeBean.getManufactureDef(), batchAttributeBean.getMrp(), null, destLocId, batchAttributeBean.getOriginalConvertedQty(), 0 });

					}

				}
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	
		
	}

	@Override
	public List<GRNBean> getGRNMasterList() throws CustomException {
		// TODO Auto-generated method stub
	try {	
		String query = "";
		query = GRNQueryUtil.GRN_LIST;

		List<GRNBean> lGrnBean = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(GRNBean.class));
		
		return lGrnBean;
		
	} catch (DataAccessException e) {
		LOGGER.error("Error in List", e);
		throw new CustomException("");
	}
	
	
	}

	@Override
	public GRNResultBean getGrnEditData(String grnCode) {

		GRNResultBean resultBean = new GRNResultBean();
		GRNBean bean = new GRNBean();
		List<GRNPurchaseOrderBean> lDetailList = new ArrayList<>();
		try {
			bean = getGrnHeaderData(grnCode);
			lDetailList = getGrnDtlListData(grnCode);
			bean.setPoDetailData(lDetailList);
			resultBean.setEditBeanData(bean);

		} catch (Exception e) {
			LOGGER.error("Error in Get getGrnEditData List", e);
		}

		return resultBean;
	}
	
	
	private List<GRNPurchaseOrderBean> getGrnDtlListData(String grnCode) {
		List<GRNPurchaseOrderBean> dtlDataList = new ArrayList<>();
		try {
			List<GRNPurchaseOrderBean> dtlList = jdbcTemplate.query(GRNQueryUtil.GET_GRN_DTL, new Object[] { grnCode }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

			for (GRNPurchaseOrderBean grnPurchaseOrderBean : dtlList) {
				List<GRNPurchaseOrderBean> lSchGrnBean = jdbcTemplate.query(GRNQueryUtil.PO_SCHEDULE, new Object[] { grnPurchaseOrderBean.getDtlPODtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
				List<GRNPurchaseOrderBean> lBatchGrnBean = jdbcTemplate.query(GRNQueryUtil.GET_GRN_BATCH_DTL, new Object[] { grnPurchaseOrderBean.getGrnDtlId() }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));

				grnPurchaseOrderBean.setScheduleList(lSchGrnBean);
				grnPurchaseOrderBean.setBatchDetails(lBatchGrnBean);

				dtlDataList.add(grnPurchaseOrderBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get GRN Detail List", e);
		}
		return dtlDataList;
	}
	
	private GRNBean getGrnHeaderData(String grnCode) {
		GRNBean objGRNBean = new GRNBean();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(GRNQueryUtil.GET_GRN_HDR, new Object[] { grnCode });

			for (Map row : rows) {
				objGRNBean.setGrnId((int) row.get("grnId"));
				objGRNBean.setGrnCode((String) row.get("grnCode"));
				objGRNBean.setCompanyId((String) row.get("companyId"));
				objGRNBean.setGrnDate((String) row.get("grnDate"));
				objGRNBean.setPoId((int) row.get("poId"));
				objGRNBean.setPoNo((String) row.get("poNo"));
				//objGRNBean.setPoAmendNo((String) row.get("poAmendNo"));

				objGRNBean.setConTransferNo((String) row.get("conTransferNo"));
				objGRNBean.setPoRequisitionId( (int) row.get("poRequisitionId"));
				objGRNBean.setPoRequisition( (String) row.get("poRequisition"));
				objGRNBean.setVendorId((int) row.get("vendorId"));
				objGRNBean.setVendorName((String) row.get("vendorName"));
				objGRNBean.setDelOrderNo((String) row.get("delOrderNo"));
				objGRNBean.setDelOrderDate((String) row.get("delOrderDate"));
				objGRNBean.setInvoiceNo((String) row.get("invoiceNo"));
				objGRNBean.setInvoiceDate((String) row.get("invoiceDate"));
				objGRNBean.setDeliveryMthd((int) row.get("deliveryMthd"));
				objGRNBean.setTransMode((int) row.get("transMode"));
				objGRNBean.setLocId((int) row.get("locId"));
				objGRNBean.setLocName((String) row.get("locName"));
				objGRNBean.setDstLocId((int) row.get("dstLocId"));
				objGRNBean.setDstLocName((String) row.get("dstLocName"));
				objGRNBean.setPoType((String) row.get("poType"));
				objGRNBean.setGrnStatus((int) row.get("grnStatus"));
				objGRNBean.setDueDate((String) row.get("dueDate"));
				objGRNBean.setFreight((double) row.get("freight"));
				objGRNBean.setOtherCharges((double) row.get("otherCharges"));
				objGRNBean.setRemarksforother((String) row.get("remarksforother"));
				// objGRNBean.setDueDate((String) row.get("duedate"));
				objGRNBean.setEntity((String) row.get("entity"));
				objGRNBean.setVendorName((String) row.get("vendorName"));
				objGRNBean.setVendorAddress((String) row.get("address"));
				objGRNBean.setVendorPhone((String) row.get("vendorPhone"));
//				objGRNBean.setFreight(row.get("grnfreight"));
//				objGRNBean.setOtherCharges((double) row.get("grnOtherCharnge"));
				objGRNBean.setPreparedBy((String) row.get("first_name"));

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get GRN Header list", e);
		}
		return objGRNBean;
	}

	@Override
	public GRNPurchaseOrderBean getItemAttributes(int itemId) {
		// TODO Auto-generated method stub
		GRNPurchaseOrderBean bean = new GRNPurchaseOrderBean();
		try {
			bean = jdbcTemplate.queryForObject(GRNQueryUtil.GET_ITEM_ATTRIBUTES, new Object[] { itemId }, new BeanPropertyRowMapper<>(GRNPurchaseOrderBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
		}
		return bean;
	}



}