package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public String ReadProperty() throws IOException
	{
		Properties prop=new Properties();
		String localDir = System.getProperty("user.dir");
		FileInputStream ip= new FileInputStream(localDir + "\\config.properties");
		prop.load(ip);
		return prop.getProperty("device");
		
	}
}
