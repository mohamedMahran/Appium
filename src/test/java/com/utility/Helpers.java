package com.utility;

import java.util.concurrent.TimeUnit;

import com.setup.base;

public  class Helpers extends base {
	public static void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}
