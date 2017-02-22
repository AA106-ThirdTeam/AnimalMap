package com.tools.method;

public class PwCreate {

	public static  String randomPW(int count) {

		final String[] pwlist = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b",
				"c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
				"x", "y", "z" };

		String emp_Pw = "";
		for (int i = 0; i < count; i++) {
			emp_Pw += pwlist[(int) (Math.random() * pwlist.length)];
		}
		return emp_Pw;
	}

}
