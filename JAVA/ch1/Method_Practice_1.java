package a.b.c.d.ch1;

public class Method_Practice_1{
	public static void aM(){
		System.out.println("aM() method 함수");
	}

	public static void bM(){
		System.out.println("bM() method 함수");
	}

	public static void cM(){
		System.out.print("cM() method 함수");
	}

	public static void dM(){
		System.out.print("저는 dM함수입니다. aM,bM,cM 함수 전부 불러오겠습니다.");
		System.out.print("aM,bM,cM 함수 전부 호출");
		System.out.print("\n");
		aM();
		System.out.print("\n");
		bM();
		System.out.print("\n");
		cM();
	}

	public static void main(String args[]){
		System.out.println("1. 첫 번째 라인에서 Mehod_Practice_1 클래스 블럭에 있는 main() 함수 시작 >>> : ");
		// java 콘솔 어플리케이션은 main 함수부터 시작
		// main 함수의 위치는 정말 아무런 상관이 없음.
		// 그러나 맨 아래 쓰는 것이 국룰이다.
		System.out.print("\n");
		System.out.println("2. aM함수 호출");
		Method_Practice_1.aM();
		System.out.print("\n");
		System.out.println("3. cM함수 호출");
		Method_Practice_1.cM();
		// bM이 cM보다 위에 있지만, 호출을 cM을 먼저하면, cM이 먼저 출력된다.
		// 유의해야 할 점은 컴파일과정에서가 아니라 실제 실행과정에서 main -> 호출 순으로 출력되는 것이다.
		System.out.println("\n");
		System.out.println("4. aM,bM,cM 전부 호출");
		Method_Practice_1.dM();
		// dM 함수 내에서 aM(), bM(), cM() 함수순으로 다시 호출하여 출력
	}
}