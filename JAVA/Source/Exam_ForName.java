package a.b.c.ch5;

import java.lang.reflect.Method;

public class Exam_ForName {

	public void classForName() throws ClassNotFoundException, 
	                                  InstantiationException, 
	                                  IllegalAccessException{
		
		// public static Class<?> forName(String className) throws ClassNotFoundException
		// a.b.c.ch5.Exam_Invoke 
		Class cl = Class.forName("a.b.c.ch5.Exam_Invoke");
		System.out.println("cl >>> : " + cl);
		// public T newInstance() throws InstantiationException, IllegalAccessException
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
	}
	
	public static void main(String[] args)  throws ClassNotFoundException, 
													InstantiationException, 
													IllegalAccessException{
		// TODO Auto-generated method stub
		new Exam_ForName().classForName();
	}
}
