	package com.tests;
	
	import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
	import static io.appium.java_client.touch.TapOptions.tapOptions;
	import static io.appium.java_client.touch.offset.ElementOption.element;
	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;
	
	import java.net.MalformedURLException;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;
	
	import com.pages.ApiDemoPage;
	import com.setup.base;
	
	import io.appium.java_client.TouchAction;
	
	public class tests extends base {
	
		@Test
		public void TestBasics() throws MalformedURLException {
			try {
				// Xpath id class name , android automator
				// tagname[attribute='value']
				// Automating app UI Using Xpaths and text attributes
				// driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
				ApiDemoPage ApiDemo = new ApiDemoPage();
	
				ApiDemo.ClickOnPrefrencesButton();
	
				driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
				// Appium API's for UI interaction By id
				driver.findElement(By.id("android:id/checkbox")).click();
				// Appium API's for UI interaction by xpath with a specific index
				driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
				// Appium API's for UI interaction by Class Name
				driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
				// Handling Mutiple similar objects of Apps with indexes
				driver.findElementsByClassName("android.widget.Button").get(1).click();
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
				driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
				// AndroidUIAutomator usage in identifying objects of Apps
				// Validate clickable feature for all options
				// Specifies the elements in the layout hierarchy for tests to
				// target, filtered by properties such as text value,
				// content-description,
				// class name, and state information. You can also target an element
				// by its location in a layout hierarchy.
				assertEquals(((Object) driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size()),
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
				driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
				// Invoked Tap action
				TouchAction t = new TouchAction(driver);
				WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
				t.tap(tapOptions().withElement(element(expandList))).perform();
				// Invoked long press
				// t.tap(tapOptions().withElement(element(expandList)).withPosition(positionOption)
				driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
				WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
	
				t.longPress(longPressOptions().withElement(element(pn)).withDuration(Duration.ofSeconds(2))).release()
						.perform();
				Thread.sleep(2000);
				assertTrue(driver.findElementById("android:id/title").isDisplayed());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	
		}
	
		@Test
		public void TestSwipDemo() {
			driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
			driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
			driver.findElementByXPath("//*[@content-desc='9']").click();
			TouchAction t = new TouchAction(driver);
			// long press // on element //2 sec // move to another and you release
			WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
			WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
			t.longPress(longPressOptions().withElement(element(first)).withDuration(Duration.ofSeconds(2)))
					.moveTo(element(second)).release().perform();
	
		}
	
		@Test
		public void TestScrollingDemo() {
			driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
			// Appium is not supported any method fast scrolling
			// executing android code by using findElementByAndroidUIAutomator
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"ScrollBars\"));");
		}
	
		@Test
		public void TestDragAndDrop() {
			driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
			TouchAction t = new TouchAction(driver);
			// longpresssource/move(destination)//release
			WebElement source = driver.findElementsByClassName("android.view.View").get(0);
			WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
			// t.longPress(longPressOptions().withElement(element(source)).withDuration(Duration.ofSeconds(5))).moveTo(element(destination)).release().perform();
			t.longPress(element(source)).moveTo(element(destination)).release().perform();
	
		}
	
	}
