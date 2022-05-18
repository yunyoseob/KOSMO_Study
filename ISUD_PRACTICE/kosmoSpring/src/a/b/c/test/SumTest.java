package a.b.c.test;

import java.util.List;
import java.util.ArrayList;

public class SumTest {

	public static String stringV() {
		
		String s[] = {"10", "20", "30"};		
		int s_Sum = 0;
		
		for(int i=0; i < s.length; i++) {		
			int iS = Integer.parseInt(s[i]);
			s_Sum += iS;
		}	
		return String.valueOf(s_Sum);
	}
	
	public static String arrayListV() {
		
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add("20");
		list.add("30");		
		int s_Sum = 0;
		
		for(int i=0; i < list.size(); i++) {			
			String listS = list.get(i);			
			int iS = Integer.parseInt(listS);
			s_Sum += iS;
		}		
		return String.valueOf(s_Sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = SumTest.stringV();
		System.out.println("s1 >>> : " + s1);
		
		String s2 = SumTest.arrayListV();
		System.out.println("s2 >>> : " + s2);		
	}
}
