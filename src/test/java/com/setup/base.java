package com.setup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.utility.ReadPropertyFile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	
	 Properties prop = new Properties();
	 InputStream input ;
	 public static AndroidDriver<AndroidElement>  driver;
	
	
	public  AndroidDriver<AndroidElement> capabilities(String device)  throws MalformedURLException
	{
	 try {
		 
		 File appDir = new File("src");
		 //File app = new File(appDir, "ApiDemos-debug.apk");
		 File app = new File(appDir, "General-Store.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		 if(device.equals("emulator"))
				 {
			 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
			 capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			 capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			 //capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
			 //capabilities.setCapability("appActivity", ".NexusLauncherActivity");
			 capabilities.setCapability("autoGrantPermissions", true);
				 }
		 else if (device.equals("real"))
		 {
			 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LC566YH06083");
		 }
		 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		 //capabilities.setCapability("newCommandTimeout", 1200);
		 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		
		 
	 	} 
	 catch (Exception e) 
	 	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	 	}
	return driver;
	}
	public String ReadProperty() throws IOException
	{
		 ReadPropertyFile rpf = new ReadPropertyFile();
		 String device= rpf.ReadProperty();
		 return device;
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		String device = ReadProperty();
		capabilities(device);
	}
	
	
	@AfterMethod
	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

