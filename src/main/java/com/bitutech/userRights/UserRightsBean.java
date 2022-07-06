package com.bitutech.userRights;

import java.util.ArrayList;
import java.util.List;

public class UserRightsBean {
	
	
	private int formPropertyId;
	private String formCode;
	private boolean isEnabled;
	private boolean isAvailable;
	private String formName;
	
	private String propertyCode;
	private String propertyName;

	private String id;
	private String text;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public List<FormMasterBean> getlFormMasterBean() {
		return lFormMasterBean;
	}
	public void setlFormMasterBean(List<FormMasterBean> lFormMasterBean) {
		this.lFormMasterBean = lFormMasterBean;
	}

	

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}



	public String getPropertyCode() {
		return propertyCode;
	}
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}



	public int getFormPropertyId() {
		return formPropertyId;
	}
	public void setFormPropertyId(int formPropertyId) {
		this.formPropertyId = formPropertyId;
	}



	public String getFormCode() {
		return formCode;
	}
	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}



	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}



	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}



	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}



	private List<FormMasterBean> lFormMasterBean = new ArrayList<FormMasterBean>();
	
}