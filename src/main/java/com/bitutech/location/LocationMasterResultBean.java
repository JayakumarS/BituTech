package com.bitutech.location;

import java.io.Serializable;
import java.util.List;

import com.bitutech.core.util.BasicResultBean;
 

public class LocationMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<LocationMasterBean> locationMasterDetails;
	private LocationMasterBean locationMasterBean;
	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<LocationMasterBean> getLocationMasterDetails() {
		return locationMasterDetails;
	}

	
	public void setLocationMasterDetails(List<LocationMasterBean> locationMasterDetails) {
		this.locationMasterDetails = locationMasterDetails;
	}

	/*
	 * public void setLocationMasterDetails(List<LocationMasterBean>
	 * locationMasterDetails) { this.locationMasterDetails = locationMasterDetails;
	 * }
	 */
	public LocationMasterBean getLocationMasterBean() {
		return locationMasterBean;
	}

	public void setLocationMasterBean(LocationMasterBean locationMasterBean) {
		this.locationMasterBean = locationMasterBean;
	}
	
	
}
