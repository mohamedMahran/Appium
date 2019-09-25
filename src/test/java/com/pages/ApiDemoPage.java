package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.setup.base;


public class ApiDemoPage{
	
	@FindBy(xpath="//android.widget.TextView[@text='Preference']")
	private WebElement _prefrencesButton;
	
	
	
	public ApiDemoPage()
	{
		if (base.driver != null) {
			PageFactory.initElements(base.driver, this);
		} else {
			try {
				throw new Exception("Driver doesn't instintiated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ClickOnPrefrencesButton()
	{
		_prefrencesButton.click();
	}
}
