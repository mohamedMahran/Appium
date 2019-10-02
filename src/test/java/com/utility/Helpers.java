package com.utility;

import java.util.concurrent.TimeUnit;

import com.setup.baseApiDemo;

public  class Helpers extends baseApiDemo {
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
}
