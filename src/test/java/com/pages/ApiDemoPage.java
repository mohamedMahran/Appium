package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.setup.base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ApiDemoPage{
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	private MobileElement _prefrencesButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	private MobileElement _prefrenceDependencies;
	
	@AndroidFindBy(id="android:id/checkbox")
	private MobileElement _wifiCheckBox;
	
	@AndroidFindBy(uiAutomator = "text(\"2. Inline\")")
	private MobileElement _inline;
	
	@AndroidFindBy(uiAutomator = "text(\"Views\")")
	private MobileElement _view;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"ScrollBars\"));")
	private MobileElement _scrollToBars;
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement _wifiSettingTextBox;
	
	@AndroidFindBy(className ="android.widget.Button")
	private List <MobileElement> _wifiSettingsButtons;
	
	@AndroidFindBy(xpath ="//android.widget.RelativeLayout")
	private List <MobileElement> _WifiSetting;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Drag and Drop']")
	private MobileElement _DragAndDrop;
	
	@AndroidFindBy(className ="android.view.View")
	private List<MobileElement> _dragDot;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Date Widgets']")
	private MobileElement _dataWidget;

	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Expandable Lists']")
	public MobileElement ExpandableList;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='1. Custom Adapter']")
	private MobileElement _customAdapter;
	
	
	
	public ApiDemoPage()
	{
		if (base.driver != null) {
			PageFactory.initElements(new AppiumFieldDecorator(base.driver),this);
		} else {
			try {
				throw new Exception("Driver doesn't instintiated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void ClickOnCustomAdapter()
	{
		_customAdapter.click();
	}
	public void ClickOnDataWidget()
	{
		_dataWidget.click();
	}
	public WebElement GetBall(int index)
	{
		
		return _dragDot.get(index);
		
	}
	public void DragAndDrop()
	{
		_DragAndDrop.click();
	}
	public void ClickOnViewButton()
	{
		_view.click();
	}
	public void ClickOnInlineButton()
	{
		_inline.click();
	}
	public void ClickOnPrefrencesButton()
	{
		_prefrencesButton.click();
	}
	public void ClickOnPrefrenceDependenciesButton()
	{
		_prefrenceDependencies.click();
	}
	public void SelectWifiCheckBox()
	{
		_wifiCheckBox.click();
	}
	
	public void TypeTextInTheWifiTextBox(String text)
	{
		_wifiSettingTextBox.sendKeys(text);
	}
	public void ClickOnOkButtonInWifiSettings(int index)
	{
		_wifiSettingsButtons.get(index).click();
	}
	public void ClickOnWifiSettings()
	{
		//base.driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		_WifiSetting.get(1).click();
		
	}
	public void scrollToBars()
	{
		_scrollToBars.click();
	}
}
