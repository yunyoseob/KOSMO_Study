package a.b.c.ch1;


public class ClassTest_practice{
	// 멤버 변수
	int iVal;
	
	// 스태틱 변수, 클래스 변수
	// static 키워드가 붙은 변수는
	// 실행할 때 자바 버철머신(JVM)이 해당 변수에 값을 초기화 해준다.
	static int iValStatic;

	// void : 리턴값이 없다 : return 키워드를 사용할 수 없다.
	public static void main(String args[]){
		System.out.println("main()함수는 콘솔 어플리케이션 시작점이다.");
		System.out.println("함수 블럭안에서는 인터프리트 방식으로 수행된다.");

		// 함수 블럭 내부에서 선언한 지역 변수이다.
		// 지역 변수는 사용하기 전에 무조건 초기화가 되어 있어야 한다.
		int i=10;
		System.out.println("i>>>:"+i);

		// static 변수 호출하기
		//System.out.println("iValStatic >>> :"+iVal);
		// 멤버변수에서 iVal을 int 형으로 선언시 static을 하지 않았기 때문에
		// 오류가 난다. (메모리에 올리지 않았음.)
		
		// static 키워드가 붙지 않은 iVal 멤버 변수 사용법
		// iVal 멤버변수를 메모리에 올려야 한다.
		ClassTest_practice ec=new ClassTest_practice();
		System.out.println("ClassTest_practice 사용자 정의 클래스의 변수(참조변수) ec >>> : \n"+ec);
		System.out.println("ec.iVal >>> : "+ec.iVal);

		ClassTest_practice ec_1=new ClassTest_practice();
		System.out.println("ClassTest_practice 사용자 정의 클래스의 변수(참조변수) ec >>> : \n"+ec_1);
		System.out.println("ec.iVal >>> : "+ec_1.iVal);
		//System.out.println("ClassTest_practice 사용자 정의 클래스의 변수(참조변수) ec >>> : \n"+ec_1.iValStatic);
	} // end of main

} // end of class

/*
iVal을 static하지 않았을 때 생기는 오류
ClassTest_practice.java:24: error: non-static variable iVal cannot be referenced from a static context
                System.out.println("iValStatic >>> :"+iVal);
1 error
*/

/*
메모리의 구조는 크게 코드영역, 데이터영역, 스택영역, 힙영역이있다.

코드영역은 실행할 프로그램의 코드가 저장되는 영역

데이터영역은 전역 변수와 정적(static) 변수가 저장되는 영역

스택(stack)영역은 함수의 호출과 관계되는 지역변수와 매개변수가 저장되는 영역

힙영역은 사용자가 직접 관리할 수 있는 메모리 영역. 사용자에 의매 메모리 공간이 동적으로 할당되고 해제됨.

쉽게 말하면 Class_Test_practice에서 static을 통해
main 함수를 메모리에 할당을 했는데, 

int iVal의 경우 할당을 하지 않았는데 println으로 출력을 시도하니까

메모리에서 값이 없기때문에 출력이 되지 않는다.

그러나, ClassTest_practice ec=new ClassTest_practice();

명령어를 통해, main함수의 스택영역 내에서 객체를 생성하면 객체 자체가 따로 메모리에 할당이 되서

해당 객체에서 iVal 출력이 가능해지는 것이다.
*/

/*
좀 더 구체적으로 얘기하면 만약 class내에서
static int iVal; 을 한다면
main() 함수와 함께 static이 되기 때문에,
클래스 변수(스태틱 변수)인 static int iVal이
지역 변수에서 사용이 가능해진다는 것이다.

객체를 생성해서 돌아가는 이유는
ClassTest_practice ec=new ClassTest_practice();
명령어를 통해 대입연산자로 new 키워드를 선언해줌으로써,
main 함수의 스택영역에서
ClassTest_practice@15db9742 라는 주소로
객체를 생성한 다음 출력해주었기 때문에
ec.iVal이 출력이 가능해지는 것이다.

다른 예시로 만약
ClassTest_practice ec_1=new ClassTest_practice();
명령어를 통해 대입연산자로 new 키워드를 선언해주면,
main 함수의 스택영역에서 
ClassTest_practice@6d06d69c 라는 주소로
객체를 생성한 다음 출력해줄 수 있다.

이 때 유의해야 하는 사항은 앞에서 생성한 객체와 ec1이라는 이름으로 만든 객체의 주소는
서로 다르다. 즉, ec랑 ec_1 저장자체가 다르게 된다는 것이다.

가령, ec라는 객체를 생성한 후에
ec_1의 주소에서 출력을 시도하면

ClassTest_practice.java:34: error: cannot find symbol
                System.out.println("ClassTest_practice 사용자 정의 클래스의 변수(참조변수) ec >>> : \n"+ec_1);
                                                                                         ^
  symbol:   variable ec_1
  location: class ClassTest_practice
1 error

이라는 오류가 출력된다.

*/

/*
마지막으로

System.out.println("ClassTest_practice 사용자 정의 클래스의 변수(참조변수) ec >>> : \n"+ec_1.iValStatic);

이전에 static을 이미 한 변수를 새로 만든 객체에서 출력하는 것은 나중에 프로그래밍을 할 때, 문제가 생길 수 있으므로
하면 안 된다.
*/