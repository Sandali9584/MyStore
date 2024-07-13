package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	
	String path="C:\\Users\\USER\\eclipse-workspace\\MyStore\\Configuration\\config.properties";
	
	public ReadConfig() {
		
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		
		if(value!=null)
			return value;
		else {
			throw new RuntimeException("Url not specified in config file");
		}
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else {
			throw new RuntimeException("Browser not specified in config file");
		}
}
		
}
