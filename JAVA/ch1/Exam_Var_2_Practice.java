package a.b.c.ch1;

// 함수 안에서 사용하는 변수의 유효 범위
// 함수에서 선언하는 변수는  
// {} 중괄호 블럭에서 선언하고 {} 중괄호 블럭에서 사용해야 한다. 
public class Exam_Var_2_Practice {

	// 메인 함수 콘솔 어플리케이션의 시작점이다. 
	public static void main(String args[]) {
		System.out.println("Exam_Var_2.main() 함수 시작");
		System.out.println("인터프르트 방식으로 수행 된다. ");
		System.out.println("main() 함수 블럭 왼쪽 부터 오른쪽 80컬럼 기준으로 수행된다.");

		// 변수를 선언하고 초기화 했다.
		// 선언한 변수명 i 의 유효 범위는(사용할 수 있는 범위)
		// i 선언한 하위 라인부터 main 함수 블럭이 끝난 라인까지 유효하다.

		// error 유형 1
		//System.out.println(">>> : "+i);
		// i가 뭔지 선언도 안해주고 프린트하니까 에러가 날 수 밖에 없다.
		// 자바는 함수 블록 내에서 인터프리터방식이므로, 선언 후, 출력해줘야 돌아감.
		
		int i = 10;

		System.out.println(">>> : " + i);
		
		// 블럭을 선언 했다.
		{
			int ii = 1000;
			System.out.println(">>> : " + ii);
			System.out.println("{} 안에서 i는 >>> : " + i);
			// 여기서, i는 해당 블록 대비 전역변수이다. 따라서 출력이 가능함.
			
			// error 유형 2
			//int i = 111;
			// 이미 전역변수에서 i를 선언했기 때문에, i를 또 선언하는것이 불가
			i=111;
			// int 선언을 해주지 않으면, 전역변수에서 i를 int형이라고 선언해주고
			// 대입연산자를 통해 int형 타입의 데이터를 집어넣어줬기 때문에,
			// update는 가능하다.
			// 출력하면 111으로 나옴.
			
			// error 유형 3
			// k=12;
			// k가 뭔지 선언을 해주지 않고, k=12라고 하면, JAVA는 못 알아들음.

			int k=12;

		}
		
		// error 유형 4
		//System.out.println(">>> : "+ii);
		// ii는 현재 블록 기준으로 지역변수이다. 지역변수는 전역변수로 나올 수 없다.
		// 경기도 지역화폐를 가지고 부산에서 결제하면 안 되지만, 원화를 가지고
		// 경기도, 부산 어디든 결제가 되는 원리랑 같음.

		System.out.println("change i >>> : "+i);
		// int i 선언을 전역변수에서 해주고, 지역변수에서 "int i=" 이 아니라,
		// "i="이라고 하면 전역변수에서도 출력이 되긴 한다.
		
		// error 유형 5
		// System.out.println("makge k>>> : "+k);
		// k를 여기 블록보다 지역변수인 곳에서 선언했기 때문에, 전역변수로 나오지 못 함.
		

	} // end of main()
} // end of Exam_Var_2 class