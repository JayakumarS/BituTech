package com.bitutech.commodity;

import java.io.Serializable;
import java.util.List;
import com.bitutech.core.util.BasicResultBean;

public class CommodityResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	public boolean Success;
	private List<CommodityBean> commodityListDetails;
	private List<CommodityBean> classificationNameList;
	private CommodityBean commodityBean;
	
	public final CommodityBean getCommodityBean() {
		return commodityBean;
	}

	public final void setCommodityBean(CommodityBean commodityBean) {
		this.commodityBean = commodityBean;
	}
	
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<CommodityBean> getCommodityListDetails() {
		return commodityListDetails;
	}

	public void setCommodityListDetails(List<CommodityBean> commodityListDetails) {
		this.commodityListDetails = commodityListDetails;
	}
	public List<CommodityBean> getClassificationNameList() {
		return classificationNameList;
	}

	public void setClassificationNameList(List<CommodityBean> classificationNameList) {
		this.classificationNameList = classificationNameList;
	}
	
}
