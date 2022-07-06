package com.bitutech.formProperty;

import java.util.ArrayList;
import java.util.List;

public class FormPropertyBean {
	
	private String form_code;
	private String formname;
	private String formcodeparent;
	private String formurl;
	private String displayorder;
	private String menuorder;
	private String iconName;
	private List<FormPropertyBean> subMenuList;
	
	private int formPropertyId;
	private String formCode;
	private String propertyCode;
	private boolean isEnabled;
	private boolean isAvailable;
	private String formName;
	private String id;
	private String text;
	
	private List<FormPropertyBean> lFormPropertyBean = new ArrayList<FormPropertyBean>();
	
	public String getPropertyCode() {
		return propertyCode;
	}
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
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
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public List<FormPropertyBean> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<FormPropertyBean> subMenuList) {
		this.subMenuList = subMenuList;
	}
	public String getForm_code() {
		return form_code;
	}
	public void setForm_code(String form_code) {
		this.form_code = form_code;
	}
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public String getFormcodeparent() {
		return formcodeparent;
	}
	public void setFormcodeparent(String formcodeparent) {
		this.formcodeparent = formcodeparent;
	}
	public String getFormurl() {
		return formurl;
	}
	public void setFormurl(String formurl) {
		this.formurl = formurl;
	}
	public String getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(String displayorder) {
		this.displayorder = displayorder;
	}
	public String getMenuorder() {
		return menuorder;
	}
	public void setMenuorder(String menuorder) {
		this.menuorder = menuorder;
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
	public List<FormPropertyBean> getlFormPropertyBean() {
		return lFormPropertyBean;
	}
	public void setlFormPropertyBean(List<FormPropertyBean> lFormPropertyBean) {
		this.lFormPropertyBean = lFormPropertyBean;
	}
	public void setFormPropertyBean(FormPropertyBean formPropertyBean) {
		this.lFormPropertyBean.add(formPropertyBean);
	}
	
	
	
}
