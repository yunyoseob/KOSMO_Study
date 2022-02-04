package a.b.c.ch1;

public class ClassTest_practice_2{
	// 멤버 변수
	byte bVal;
	char cVal;
	short sVal;
	int iVal;
	long lVal;

	float fVal;
	double dVal;
	boolean boolVal;
	String strVal;

	public static void main(String args[]){
		/*
		1. ClassTest_practice_2 클래스를 사용하려면
		맨 먼저 ClassTest_practice_2를 인스턴스 instance 해야 한다.
		2. instance(인스턴스): 클래스를 메모리에 올리는 행위 :
		가장 대표적인 연산자 new 키워드 연산자
		3. new 키워드(연산자)로 인스턴스 하는방법(메모리에 올리는 방법)
		3-1. 사용하려고 하는 클래스(빌트인 클래스 rt.jar에 있는 클래스,
		사용자 정의 클래스)를 클래스 이름으로 선언한다.
		3-2. 참조변수 reference variable을 선언한다.
		3-3. = 대입 연산자 선언
		3-4. 클래스 이름 뒤 () 소괄호를 붙여서 생성자를 만든다.
		===================
		생성자가 메모리에 올라가면 (인스턴스 되면)
		해당 클래스에 있는 멤버변수를 디폴트 값으로 초기화 한다.
		===================
		클래스이름 참조변수 = new 클래스이름();
		클래스이름() <- 생성자라고 한다. 이 생성자가 해당 클래스 내부에
					  선언한 멤버변수를 디폴트 값으로 초기화 한다.		
		*/
		int iVal=101;
		long lVal=123456789l;

		ClassTest_practice_2 ec=new ClassTest_practice_2();
		System.out.println("ec 참조변수 주소값 >>> : "+ec);
		// 새로 만들어진 객체 ec 주소값을 출력한다.
		System.out.println("ec bVal >>> : " + ec.bVal);
		// 새로 만들어진 객체 ec 의 bool 변수를 출력한다.
		System.out.println("ec cVal >>> : " + ec.cVal);
		// 새로 만들어진 객체 ec의 char 변수를 출력한다.
		System.out.println("ec sVal >>> : " + ec.sVal);
		// 새로 만들어진 객체 ec의 short 변수를 출력한다.
		System.out.println("ec iVal >>> : " + ec.iVal);
		// 새로 만들어진 객체 ec의 int 변수를 출력한다.
		// 지역변수인 iVal=101은 출력되지 않고, 멤버변수인 iVal이 출력된다.
		System.out.println("ec lVal >>> : " + ec.lVal);
		// 새로 만들어진 객체 ec의 long 변수를 출력한다.
		// 지역변수인 lVal=123456789l은 출력되지 않고, 멤버변수인 lVal이 출력된다.
		System.out.println("ec fVal >>> : " + ec.fVal);
		// 새로 만들어진 객체 ec의 float 변수를 출력한다.
		System.out.println("ec dVal >>> : " + ec.dVal);
		// 새로 만들어진 객체 ec의 double 변수를 출력한다.
		System.out.println("ec boolVal >>> : " + ec.boolVal);
		// 새로 만들어진 객체 ec의 boolean 변수를 출력한다.
		System.out.println("ec strVal >>> : " + ec.strVal);
		// 새로 만들어진 객체 ec의 String 변수를 출력한다.
		// String 변수는 기초자료형이 아니라, 참조자료형에 속한다.
	} // end of main method
} // end of ClassTest_practice_2 class