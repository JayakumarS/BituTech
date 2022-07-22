package com.bitutech.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Value("${file.upload.drugCustomerUpload}")
	private String drugCustomerUpload;
	
	@Value("${file.upload.drugCustomerUploadServerPath}")
	private String drugCustomerUploadServerPath;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("CustomerDrugUpload/**").addResourceLocations("file:///root/drug_upload/");
		registry.addResourceHandler(drugCustomerUploadServerPath+"/**").addResourceLocations("file://"+drugCustomerUpload);
	}
	
}
