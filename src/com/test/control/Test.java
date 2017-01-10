package com.test.control;

public class Test {

	public static String getIframe(){
		String check = "";
		String str = "<iframe src=\"http://www.w3schools.com\"></ifame>";
		if ("A".equals(check)) {
			System.out.println("Test");
			str = "<iframe src=\"http://www.w3schools.com\"></ifame>";			
		}

		if ("B".equals(check)) {
			System.out.println("Test");
			str = "<iframe src=\"http://yahoo.com.tw\"></ifame>";			
		}
		
		return str;
	}	
}
