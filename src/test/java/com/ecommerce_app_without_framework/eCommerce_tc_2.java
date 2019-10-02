package com.ecommerce_app_without_framework;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.setup.base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;



public class eCommerce_tc_2 extends base{
	@Test
	public void FillTheFormDetailsAndVerifyToastMessageDisplayedForWrongInputs() throws MalformedURLException {
			
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

	     driver.hideKeyboard();

	     driver.findElement(By.xpath("//*[@text='Female']")).click();

	     driver.findElement(By.id("android:id/text1")).click();

	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	     // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

	     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     
	     String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	     
	     System.out.println(toastMessage);
	     //name attribute  for toast message will have content 
	     Assert.assertEquals("Please enter your name",toastMessage);
	     

		}

}
