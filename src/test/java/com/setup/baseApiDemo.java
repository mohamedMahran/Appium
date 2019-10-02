package com.setup;

import java.io.File;
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

public class baseApiDemo {
	

	 Properties prop = new Properties();
	 InputStream input ;
	 public static AndroidDriver<AndroidElement>  driver;
	
	@BeforeMethod
	public  void Initilize() throws MalformedURLException
	{
		// TODO Auto-generated method stub
	 try {
		 
		 File appDir = new File("src");
		 File app = new File(appDir, "ApiDemos-debug.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		ReadPropertyFile rpf = new ReadPropertyFile();
		String device= rpf.ReadProperty();
		 if(device.equals("emulator"))
				 {
			 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator-5554");
			 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			 capabilities.setCapability("newCommandTimeout", 1200);
			 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		 
				 }
		 else if (device.equals("real"))
		 {
			 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LC566YH06083");
			 capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			 capabilities.setCapability("newCommandTimeout", 1200);
			 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 }
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//return driver;
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

