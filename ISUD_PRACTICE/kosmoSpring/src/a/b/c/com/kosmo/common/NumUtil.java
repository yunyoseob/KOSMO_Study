package a.b.c.com.kosmo.common;

import java.text.DecimalFormat;

public class NumUtil {
	
	public static String comma(String s) {	
		int iS = Integer.parseInt(s);
		return new DecimalFormat("###,###").format(iS);
	}
	
	public static String comma_replace(String s) {
		
		String ss = "";
		int is = s.indexOf(',');		
		
		if (is != -1) {
			System.out.println("is >>> : " + is);
			ss = s.replace(",","");
		}else {
			ss = s;
		}
		return ss;
	}
	
	public static void main(String args[]) {		
		//System.out.println(NumUtil.comma("5000"));
		System.out.println(NumUtil.comma_replace("5000"));
		System.out.println(NumUtil.comma_replace("5,000"));
	}
	
}
