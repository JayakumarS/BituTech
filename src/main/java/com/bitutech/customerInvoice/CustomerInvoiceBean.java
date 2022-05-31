package com.bitutech.customerInvoice;
import java.util.List;

public class CustomerInvoiceBean {
	
	public String invoiceNo;
	public String bulkInvoiceNo;
	public String InvoiceDate;
	public String Company;
	public String CompanyCode;
	public String BlRelated;
	public String CustomerName;
	public String customerCode;
	public String MloCode;
	public String MloName;
	public String Subject;
	public String CurrencyName;
	public String CurrencyCode;
	public String exchangeRate;
	public String Voyage;
	public String VesselCode;
	public String deliveryNo;
	public String consignmentNo;
	public String deliveryId;
	public String consignmentId;
	public String spifRefNo;
	public String consignee;
	public String VesselName;
	public String ServiceCode;
	public String ServiceName;
	public int Unit20;
	public int Unit40;
	private String pol;
	private String pod;
	public String sailingDate;
	public String bl;
	private String baseCompany;
	private String payerAddress;
	private String  deliveryGoodDescription;
	private String subGroupCode;
	private String blNo;
	private String dispatchNo;
	private String filePath;
	private String fileName;
	private String userRemark;
	private String customer;
	private int amount;
	private String currency;
	private String  salesOrderNo;
	private String  custInvoiceNo;
	private String custInvoiceDate;
	private List<CustomerInvoiceDetailBean> customerInvoiceDetailBean;
	
	
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSalesOrderNo() {
		return salesOrderNo;
	}
	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}
	public String getCustInvoiceNo() {
		return custInvoiceNo;
	}
	public void setCustInvoiceNo(String custInvoiceNo) {
		this.custInvoiceNo = custInvoiceNo;
	}
	public String getCustInvoiceDate() {
		return custInvoiceDate;
	}
	public void setCustInvoiceDate(String custInvoiceDate) {
		this.custInvoiceDate = custInvoiceDate;
	}
	public List<CustomerInvoiceDetailBean> getCustomerInvoiceDetailBean() {
		return customerInvoiceDetailBean;
	}
	public void setCustomerInvoiceDetailBean(List<CustomerInvoiceDetailBean> customerInvoiceDetailBean) {
		this.customerInvoiceDetailBean = customerInvoiceDetailBean;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getBulkInvoiceNo() {
		return bulkInvoiceNo;
	}
	public void setBulkInvoiceNo(String bulkInvoiceNo) {
		this.bulkInvoiceNo = bulkInvoiceNo;
	}
	public String getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getCompanyCode() {
		return CompanyCode;
	}
	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}
	public String getBlRelated() {
		return BlRelated;
	}
	public void setBlRelated(String blRelated) {
		BlRelated = blRelated;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getMloCode() {
		return MloCode;
	}
	public void setMloCode(String mloCode) {
		MloCode = mloCode;
	}
	public String getMloName() {
		return MloName;
	}
	public void setMloName(String mloName) {
		MloName = mloName;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getCurrencyName() {
		return CurrencyName;
	}
	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}
	public String getCurrencyCode() {
		return CurrencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getVoyage() {
		return Voyage;
	}
	public void setVoyage(String voyage) {
		Voyage = voyage;
	}
	public String getVesselCode() {
		return VesselCode;
	}
	public void setVesselCode(String vesselCode) {
		VesselCode = vesselCode;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getConsignmentNo() {
		return consignmentNo;
	}
	public void setConsignmentNo(String consignmentNo) {
		this.consignmentNo = consignmentNo;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getConsignmentId() {
		return consignmentId;
	}
	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}
	public String getSpifRefNo() {
		return spifRefNo;
	}
	public void setSpifRefNo(String spifRefNo) {
		this.spifRefNo = spifRefNo;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getVesselName() {
		return VesselName;
	}
	public void setVesselName(String vesselName) {
		VesselName = vesselName;
	}
	public String getServiceCode() {
		return ServiceCode;
	}
	public void setServiceCode(String serviceCode) {
		ServiceCode = serviceCode;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public int getUnit20() {
		return Unit20;
	}
	public void setUnit20(int unit20) {
		Unit20 = unit20;
	}
	public int getUnit40() {
		return Unit40;
	}
	public void setUnit40(int unit40) {
		Unit40 = unit40;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getPod() {
		return pod;
	}
	public void setPod(String pod) {
		this.pod = pod;
	}
	public String getSailingDate() {
		return sailingDate;
	}
	public void setSailingDate(String sailingDate) {
		this.sailingDate = sailingDate;
	}
	public String getBl() {
		return bl;
	}
	public void setBl(String bl) {
		this.bl = bl;
	}
	public String getBaseCompany() {
		return baseCompany;
	}
	public void setBaseCompany(String baseCompany) {
		this.baseCompany = baseCompany;
	}
	public String getPayerAddress() {
		return payerAddress;
	}
	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}
	public String getDeliveryGoodDescription() {
		return deliveryGoodDescription;
	}
	public void setDeliveryGoodDescription(String deliveryGoodDescription) {
		this.deliveryGoodDescription = deliveryGoodDescription;
	}
	public String getSubGroupCode() {
		return subGroupCode;
	}
	public void setSubGroupCode(String subGroupCode) {
		this.subGroupCode = subGroupCode;
	}
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getDispatchNo() {
		return dispatchNo;
	}
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}
	
	
	
	
}
