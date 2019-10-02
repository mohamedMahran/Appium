package com.utility;

public class CommonFunctions {
	
	public static double getAmount(String value )
	{
			value=value.substring(1);
		    double amountValue=Double.parseDouble(value);
		   
		    return amountValue;
	}

}
