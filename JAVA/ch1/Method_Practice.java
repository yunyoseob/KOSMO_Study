package a.b.c.ch1;
// 자바에서 경로를 a폴더 안에 b폴더 안에 c폴더 안에 ch1폴더안으로 지정한다.

public class Method_Practice{
// Method_Practice라는 클래스를 만들어준다.
// 이 구역이 전역변수

	public static void aMethod(int i){
		// 함수란 하나의 기능을 수행하는 일련의 코드입니다. (기능을 모아두는 곳)
		// 자바와 같은 객체지향 언어에서는 이를 메소드(method)라고 부릅니다.
		// public static void 순으로 접근 제한자 키워드
		// -> 수정자 키워드 -> 리턴형 순으로 선언해야 줍니다.
		// public이라는 접근 제한자를 사용한 이유는
		// 나중에 import 할 수 있게 허락해주기 위함입니다.
		// static이라는 수정자 키워드를 사용한 이유는 
		// 메모리에 초기화 하여 할당해주기 위함입니다.
		// return 값이 없기 때문에 void라는 리턴형 키워드를 적어준다.
		// void는 비어 있다는 의미로 '반환할 값이 없다'는 뜻의 예약어 입니다.
		// 함수의 이름은 aMethod로 해주고,
		// 함수에 들어갈 매개변수(parameter)는 int i로 해준다.
		// int를 붙이는 이유는 i의 자료형이 int형이라고 정해주기 위함이다.
		int ii=i;
		// ii라는 변수를 int로 정해준뒤, 대입연산자(=)를 통해 int형인 i를 대입해준다.
		System.out.println("aMethod() 함수 블럭 안에서 출력 >>> : " + ii);
	} // end of aMethod function ({}안에 있는 변수가 지역변수)
	
	
	public static void main(String args[]){
		Method_Practice.aMethod(100);
		// 사용자 정의 클래스 Method_Practice 클래스 main()함수에서
		// 사용자 정의 클래스 Method_Practice에 있는 aMethod()함수를 호출한다 invoke 한다.
		// 이 때 유의해야할 점은 매개변수에 들어가는 자료형 규칙을 잘 맞춰서 입력해야한다.
		// Method_Practice.aMethod(100)는 
		// Method_Practice라는 클래스 안에 aMethod 메소드에 값을
		// 넣겠다라는 의미입니다.
	} // end of main function

} // end of Method_Practice class