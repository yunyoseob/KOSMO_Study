package a.b.c.ch5;

import java.lang.reflect.Method;

public class Exam_ForName_1 {

	public void classForName() {
		
		try {
			Class cl = Class.forName("a.b.c.ch5.Exam_Invoke");
			System.out.println("cl >>> : " + cl);			
			Exam_Invoke ei = (Exam_Invoke)cl.newInstance();
			System.out.println("ei >>> : " + ei);
			ei.aM();
			ei.bM();
			ei.cM();
			
			// 클래스에 선언된 메소드 찾기 
			Method m[] = cl.getDeclaredMethods();
			for (int i=0; i < m.length; i++) {
				String findM = m[i].getName();
				System.out.println("m["+i+"].getName() >>> :: " + findM);
			}	
						
			Class d = Class.forName("java.util.Date");
			java.util.Date dd = (java.util.Date)d.newInstance();
			System.out.println("dd >>> : " + dd);
			
			Class aList = Class.forName("java.util.ArrayList");
			java.util.ArrayList aList_1 = (java.util.ArrayList)aList.newInstance();
			
			System.out.println("aList_1 >>> : " + aList_1);
		}catch(Exception e) {
			System.out.println("에러가 >>> : " + e);
		}
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new Exam_ForName_1().classForName();
	}
}
