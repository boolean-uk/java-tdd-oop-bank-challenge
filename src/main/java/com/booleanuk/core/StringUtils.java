package com.booleanuk.core;

public class StringUtils {
	public static String leftAlignStringWithPadding(String s, int pad){
		return String.format("%" + pad + "s", s);
	}
	public static String rightAlignStringWithPadding(String s, int pad){
		return String.format("%-" + pad + "s", s);
	}
	public static String centerAlignStringWithPadding(String s, int pad){
		String str = String.format("%" + ((pad + s.length())/2) + "s", s); // center
		return rightAlignStringWithPadding(str, pad); // return with padding on both sides

	}
}
