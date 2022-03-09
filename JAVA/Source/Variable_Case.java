package a.b.c.ch4;

/*
함수 안에 있는 변수 : 지역변수
클래스 안에 있는 변수 : 멤버변수

변수 : 데이터를 담는 상자 

기초자료형은 변수에 리터럴(값)을 담느다. 
참조자료형은 변수에 주소값을 담는다.
	참조자료형에서 값을 가르키려면 주소값을 사용해서 가르켜야 한다.
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Variable_Case {

	public void varialbeCaseTest( int i
		                         ,String s
								 ,int iv[]
		                         ,ArrayList aList
		                         ,Date d
		                         ,Calendar c
								 ,VariableVO vo){

		System.out.println("varialbeCaseTest() ::: i >>> : " + i);
		System.out.println("varialbeCaseTest() ::: s >>> : " + s);
		System.out.println("varialbeCaseTest() ::: iv >>> : " + iv);
		System.out.println("varialbeCaseTest() ::: aList >>> : " + aList);
		System.out.println("varialbeCaseTest() ::: d >>> : " + d);
		System.out.println("varialbeCaseTest() ::: c >>> : " + c);
		System.out.println("varialbeCaseTest() ::: vo >>> : " + vo);		
	}

	public ArrayList varialbeCaseTest_1(ArrayList aList){

		if (aList !=null && aList.size() > 0){

			for (int i=0; i < aList.size(); i++) {
				System.out.println("varialbeCaseTest_1() ::: aList.get(" + i + ") >>> : " 
									+ aList.get(i));
			}
		}
	
		return aList;
	}


	public static void main(String args[]) {
		/*
		1. 지역변수
		2. 기초자료형
		3. 리터럴(값) : 정수, 실수, 논리
		*/
		int i = 0;

		/*
		1. 지역변수
		2. 참조자료형
		3. 주소값 : 객체를 가르키는 위치 값 : 패키지명.클래스이름@16진수값
		4. 참조자료형은 값(리터럴)을 직접 가르키지 않고 
		   주소값을 통해서 가르켜야 한다. 
		*/
		String s = "abc";
		int iv[] = new int[]{1, 2, 3};
		ArrayList aList = new ArrayList();
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		VariableVO vo = new VariableVO();

		System.out.println("main() ::: i >>> : " + i);
		System.out.println("main() ::: s >>> : " + s);
		System.out.println("main() ::: iv >>> : " + iv);
		System.out.println("main() ::: aList >>> : " + aList);
		System.out.println("main() ::: d >>> : " + d);
		System.out.println("main() ::: c >>> : " + c);
		System.out.println("main() ::: vo >>> : " + vo);

		Variable_Case vc = new Variable_Case();
		
		vc.varialbeCaseTest(i, s, iv, aList, d, c, vo); 

		ArrayList aList_1 = new ArrayList();
		aList_1.add(i);
		aList_1.add(s);
		aList_1.add(iv);
		aList_1.add(aList);
		aList_1.add(d);
		aList_1.add(c);
		aList_1.add(vo);
		
		ArrayList aList_2 = vc.varialbeCaseTest_1(aList_1);

		if (aList_2 !=null && aList_2.size() > 0){

			for (int n=0; n < aList_2.size(); n++) {
				System.out.println("main() ::: aList_2.get(" + n + ") >>> : " 
									+ aList_2.get(n));
			}
		}
	}
}

class VariableVO{

	String s;
	int i;
}