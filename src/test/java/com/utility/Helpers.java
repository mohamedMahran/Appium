package com.utility;

import java.util.concurrent.TimeUnit;

import com.setup.baseApiDemo;

public  class Helpers extends baseApiDemo {
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public static double getAmount(String value )
	{
			value=value.substring(1);
		    double amountValue=Double.parseDouble(value);
		   
		    return amountValue;
	}
}
