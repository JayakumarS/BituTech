package com.bitutech.billofmaterial;

import java.util.List;

public class BillOfMaterialHdrObjBean {
	
	private String customer;
	private String bomNo;
	private String workorderNo;
	private String booNo;
	private String date;
	private Integer id;
	private String text;
	private List<BillOfMaterialDtlObjBean> billOfMaterialDtlObjBean;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getBooNo() {
		return booNo;
	}
	public void setBooNo(String booNo) {
		this.booNo = booNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getWorkorderNo() {
		return workorderNo;
	}
	public void setWorkorderNo(String workorderNo) {
		this.workorderNo = workorderNo;
	}
	
	public String getBomNo() {
		return bomNo;
	}
	public void setBomNo(String bomNo) {
		this.bomNo = bomNo;
	}
	
	public List<BillOfMaterialDtlObjBean> getBillOfMaterialDtlObjBean() {
		return billOfMaterialDtlObjBean;
	}
	public void setBillOfMaterialDtlObjBean(List<BillOfMaterialDtlObjBean> billOfMaterialDtlObjBean) {
		this.billOfMaterialDtlObjBean = billOfMaterialDtlObjBean;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	
}
