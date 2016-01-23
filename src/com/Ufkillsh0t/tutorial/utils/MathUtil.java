package com.Ufkillsh0t.tutorial.utils;

public class MathUtil {

	public static boolean isNumber(String number) {
		try{
			Integer.parseInt(number);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
