package a.b.c.test.xml;


import java.util.ArrayList;

public class TestClass {
	
	public void test(){
		System.out.println("a.b.c.test.xml.TestClass클래스에 있는 test() 메소드 입니다.");			
		System.out.println("Hello >>>>>>>>>> ");
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("신익현");
		aList.add("강민");
		aList.add("손준성");
		aList.add("박건원");
		aList.add("김별");
		aList.add("성연재");
		for (int i=0; i < aList.size(); i++) {
			System.out.println(">>> : " + aList.get(i));
		}
	}
	
	public static void main(String args[]){
		TestClass tc = new TestClass();
		tc.test();
		
	}
}

