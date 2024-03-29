	package com.tests_with_framework;
	import org.testng.annotations.Test;
	import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
	import static io.appium.java_client.touch.TapOptions.tapOptions;
	import static io.appium.java_client.touch.offset.ElementOption.element;
	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;
	import java.net.MalformedURLException;
	import java.time.Duration;
    import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebElement;
	import com.pages.ApiDemoPage;
import com.setup.baseApiDemo;
import com.utility.Helpers;
	import io.appium.java_client.TouchAction;
	
	public class basics extends baseApiDemo {
		@Test
		public void TestBasics() throws MalformedURLException {
			try {
				
				ApiDemoPage ApiDemo = new ApiDemoPage();
				Helpers.implicitWait();
				ApiDemo.ClickOnPrefrencesButton();
				Thread.sleep(500);
				ApiDemo.ClickOnPrefrenceDependenciesButton();
				Helpers.implicitWait();
				ApiDemo.SelectWifiCheckBox();
				Helpers.implicitWait();
				ApiDemo.ClickOnWifiSettings();
				Helpers.implicitWait();
				ApiDemo.TypeTextInTheWifiTextBox("Hello");
				Helpers.implicitWait();
				ApiDemo.ClickOnOkButtonInWifiSettings(1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	
		@Test
		public void TestUsingUiautomatorTest() {
			try {
				
				ApiDemoPage ApiDemo = new ApiDemoPage();
				ApiDemo.ClickOnViewButton();
				Thread.sleep(500);
				int countOfButtons=(int) driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
				assertEquals(countOfButtons,
						14);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	
		@Test
		public void TestGestures() throws MalformedURLException, InterruptedException {
			try {
				ApiDemoPage ApiDemo = new ApiDemoPage();
				ApiDemo.ClickOnViewButton();
				// Invoked Tap action
				@SuppressWarnings("rawtypes")
				TouchAction t = new TouchAction(driver);
				Helpers.implicitWait();
				WebElement expandList = ApiDemo.ExpandableList;
				Helpers.implicitWait();
				t.tap(tapOptions().withElement(element(expandList))).perform();
				// Invoked long press
				// t.tap(tapOptions().withElement(element(expandList)).withPosition(positionOption)
				Helpers.implicitWait();
				ApiDemo.ClickOnCustomAdapter();
				Thread.sleep(500);
				WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
				Helpers.implicitWait();
				t.longPress(longPressOptions().withElement(element(pn)).withDuration(Duration.ofSeconds(2))).release()
						.perform();
				Helpers.implicitWait();
				assertTrue(driver.findElementById("android:id/title").isDisplayed());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	
		}
	
		@Test(enabled=true)
		public void TestSwipDemo() throws InterruptedException {
			try
			{
				ApiDemoPage ApiDemo = new ApiDemoPage();
				ApiDemo.ClickOnViewButton();
				ApiDemo.ClickOnDataWidget();
				ApiDemo.ClickOnInlineButton();
				driver.findElementByXPath("//*[@content-desc='9']").click();	
				@SuppressWarnings("rawtypes")
				TouchAction t = new TouchAction(driver);
				WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
				WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
				t.longPress(longPressOptions().withElement(element(first)).withDuration(Duration.ofSeconds(2)))
						.moveTo(element(second)).release().perform();
			}
			catch (StaleElementReferenceException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}	
		}
		@Test
		public void TestScrollingDemo() {
			ApiDemoPage ApiDemo = new ApiDemoPage();
			ApiDemo.ClickOnViewButton();			
			Helpers.implicitWait();
			ApiDemo.scrollToBars();
		}
	
		@Test
		public void TestDragAndDrop() throws InterruptedException {
			try
			{
				@SuppressWarnings("rawtypes")
				TouchAction t = new TouchAction(driver);
				ApiDemoPage ApiDemo = new ApiDemoPage();
				ApiDemo.ClickOnViewButton();				
				ApiDemo.DragAndDrop();
				Thread.sleep(500);
				WebElement source=ApiDemo.GetBall(1);					
				WebElement destination = ApiDemo.GetBall(2);
				t.longPress(element(source)).moveTo(element(destination)).release().perform();
				//t.longPress(longPressOptions().withElement(element(source)).withDuration(Duration.ofSeconds(5))).moveTo(element(destination)).release().perform();
			}
			catch (StaleElementReferenceException e) {
				
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
	
	}