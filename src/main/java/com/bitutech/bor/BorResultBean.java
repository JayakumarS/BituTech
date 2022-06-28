package com.bitutech.bor;

import java.io.Serializable;
import java.util.List;

import com.bitutech.boo.BillOfOperationBean;
import com.bitutech.boo.BooDetailBean;
import com.bitutech.core.util.BasicResultBean;
import com.bitutech.core.util.DropDownList;

public class BorResultBean extends BasicResultBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<BorBean> borDetails;
	
	private List<BorDetailBean> BorDetailBean;
		
	private List<DropDownList> booNo;
	
	public List<DropDownList> getBooNo() {
		return booNo;
	}

	public void setBooNo(List<DropDownList> booNo) {
		this.booNo = booNo;
	}

	private BorBean borBean;
	
	private String booNumber;
	private String borNo;
	
	public String getBorNo() {
		return borNo;
	}

	public void setBorNo(String borNo) {
		this.borNo = borNo;
	}

	public boolean isSuccess() {
		return Success;
	}

	public List<BorBean> getBorDetails() {
		return borDetails;
	}

	public List<BorDetailBean> getBorDetailBean() {
		return BorDetailBean;
	}

	

	public BorBean getBorBean() {
		return borBean;
	}

	public String getBooNumber() {
		return booNumber;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public void setBorDetails(List<BorBean> borDetails) {
		this.borDetails = borDetails;
	}

	public void setBorDetailBean(List<BorDetailBean> borDetailBean) {
		BorDetailBean = borDetailBean;
	}



	public void setBorBean(BorBean borBean) {
		this.borBean = borBean;
	}

	public void setBooNumber(String booNumber) {
		this.booNumber = booNumber;
	}
	

}
