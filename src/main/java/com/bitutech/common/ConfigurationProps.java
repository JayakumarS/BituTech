package com.bitutech.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationProps {

	public static String invoiceFilesPath;


	@Value("${invoice.files.absolutePath}")
	public void setInvoiceFilesPath(String invoiceFilesPath) {
		ConfigurationProps.invoiceFilesPath = invoiceFilesPath;
	}

	
}
