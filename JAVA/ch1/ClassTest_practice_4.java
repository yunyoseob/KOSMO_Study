package a.b.c.ch1;

public class ClassTest_practice_4{
	public static int aMethod(){
		System.out.println("저는 aMethod 함수 입니다. 이제 스택 영역에서 작업할거니까 건들지 마세요. \n");
		// aMethod 시작
		System.out.println("1 더하기 2를 해보도록 하겠습니다. \n");
		int x=1;
		// 변수 x를 int라는 상자에 넣고 대입연산자를 통해 1을 대입합니다.
		int y=2;
		// 변수 y를 int라는 상자에 넣고 대입연산자를 통해 2를 대입합니다.
		int xy=x+y;
		// 변수 xy를 int라는 상자에 넣고 이전에 만들어 놓은 x와 y를 합칩니다.
		System.out.println(x+" 더하기 "+y+" 는 "+xy+" 입니다. aMethod 할 일 끝!! \n");
		return xy;
		// 더한 값을 return 합니다.
	} // end of aMethod method
	public int bMethod(){
		System.out.println("저는 bMethod 함수 입니다. aMethod 호출!! \n");
		//int z=ClassTest_practice_4.aMethod();
		// aMethod 이 놈이 static이 없어서 받을 수가 없음
		// aMethod에 static 추가해주고 다시 실행해주기

		int z=ClassTest_practice_4.aMethod();
		System.out.println("저는 꿀빨러라 aMethod한테 일시키고 결과만 가지고 왔어요. \n");
		return z;
	} // end of bMethod method
	public static void main(String args[]){
		System.out.println("저는 main 함수입니다. 이제부터 사용자 정의 함수를 받아 출력해볼게요. \n");
		System.out.println("사용자 정의 함수 bMethod가 static을 빼먹었네요. 할 수 없이 객체를 만들어보도록 하겠습니다. \n");
		ClassTest_practice_4 ec= new ClassTest_practice_4();
		// new 키워드로 객체 생성해주기
		System.out.println("객체 주소 : >>>"+ec);
		System.out.println("aMethod의 값을 출력해보도록 하겠습니다. \n");
		int a=ClassTest_practice_4.aMethod();
		System.out.println("main 함수 : aMethod야 고생했다. \n");
		int b=ec.bMethod();
		System.out.println("main 함수 : bMehtod도 고생했다. \n");
		System.out.println("\n main 함수 할 일 끝!!");
	}// end of main method

} // end of ClassTest_practice_4 class