package com.bitutech.bor;

public class BorDetailBean {
	private String borNo;
	private String resourseName;
	private Integer percentageOfAllocate;
	private Integer noOfDays;
	private Integer cost;
	
	public String getBorNo() {
		return borNo;
	}
	public void setBorNo(String borNo) {
		this.borNo = borNo;
	}
	public String getResourseName() {
		return resourseName;
	}
	public Integer getPercentageOfAllocate() {
		return percentageOfAllocate;
	}
	public Integer getNoOfDays() {
		return noOfDays;
	}
	public Integer getCost() {
		return cost;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public void setPercentageOfAllocate(Integer percentageOfAllocate) {
		this.percentageOfAllocate = percentageOfAllocate;
	}
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	 
   
}
