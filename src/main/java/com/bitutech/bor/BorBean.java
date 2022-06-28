package com.bitutech.bor;

import java.util.List;

import com.bitutech.boo.BooDetailBean;

public class BorBean {
	private String borNo;
	private String booNo;
	
	private String productName;
	private String date;
	private Integer idNo;
	private List<BorDetailBean> borDetailBean;
	
	
	public String getBorNo() {
		return borNo;
	}

	public void setBorNo(String borNo) {
		this.borNo = borNo;
	}

	public String getBooNo() {
		return booNo;
	}
	
	public String getProductName() {
		return productName;
	}
	public String getDate() {
		return date;
	}
	public Integer getIdNo() {
		return idNo;
	}
	public List<BorDetailBean> getBorDetailBean() {
		return borDetailBean;
	}
	public void setBooNo(String booNo) {
		this.booNo = booNo;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}
	public void setBorDetailBean(List<BorDetailBean> borDetailBean) {
		this.borDetailBean = borDetailBean;
	}
	

}
