package com.ecommerce_app_without_framework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.setup.base;
import com.utility.Helpers;

import io.appium.java_client.TouchAction;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class eCommerce_tc_4 extends base{
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
	     
	     int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	   
	     double sum=0;
	     
	     for(int i =0 ; i <count; i++ )
	     {
	    	 String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
	    	 double amount= Helpers.getAmount(amount1);
	    	 sum+=amount;
	     }
	   System.out.println(sum + "sum of the products" );
	   
	   String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	   
	   total=total.substring(1);
	   
	   double totalValue=Double.parseDouble(total);
	   
	   System.out.println(totalValue + "total value products" );
	   
	   Assert.assertEquals(sum, totalValue);
	   
	   WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
	   
	   TouchAction t = new TouchAction(driver);
		
	   t.tap(tapOptions().withElement(element(checkbox))).perform();
	   
	   WebElement tc=driver.findElement(By.xpath("//android.widget.TextView[@text='Please read our terms of conditions']"));
	   
	   t.longPress(longPressOptions().withElement(element(tc)).withDuration(Duration.ofSeconds(2))).release()
		.perform();
	   
	   driver.findElement(By.id("android:id/button1")).click();
	   
	   driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	   

		
	}

}
