package a.b.c.com.kosmo.common;

import java.text.DecimalFormat;

public class NumUtil {
	
	public static String comma(String s) {	
		int iS = Integer.parseInt(s);
		return new DecimalFormat("###,###").format(iS);
	}
	
	public static void main(String args[]) {		
		System.out.println(NumUtil.comma("5000"));
	}
	
}
