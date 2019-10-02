package com.setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseChrome {
	
		
	public  static AppiumDriver<MobileElement> setupCapabilities()  throws MalformedURLException, InterruptedException
	{
		    AppiumDriver<MobileElement> driver;			
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    
		    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
			 capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			 capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			 capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			return driver; 
	}
	

}

