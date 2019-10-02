package com.ecommerce_app_without_framework;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import com.setup.base;
import io.appium.java_client.TouchAction;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class eCommerce_tc_5 extends base{
	@Test
	public void ValidateMobileGesturesOfApp() throws MalformedURLException, InterruptedException {
			
		 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

		 	driver.hideKeyboard();

		 	driver.findElement(By.xpath("//*[@text='Female']")).click();

		 	driver.findElement(By.id("android:id/text1")).click();

		 	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	     // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

		 	driver.findElement(By.xpath("//*[@text='Argentina']")).click();

		 	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     
		 	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     
		 	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     
		 	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	     
		 	Thread.sleep(4000);
	     
		 	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
	   
	     @SuppressWarnings("rawtypes")
		 	TouchAction t = new TouchAction(driver);
		
	     	t.tap(tapOptions().withElement(element(checkbox))).perform();
	   
	     	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	     
	     	Thread.sleep(5000);
	     
	     	driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
	      
	     	System.out.println(driver.findElementsByClassName("android.widget.Button").size());

	     	driver.findElementsByClassName("android.widget.Button").get(2).click();
	     
	     	Thread.sleep(5000);
	     
	     
	     
	     
	   
	    
	 
	}

}
