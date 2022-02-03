package a.b.c.d.ch1;


public class Method_Practice_2{
	static int aM(){
	// public을 쓰지 않았기 때문에, default 키워드가 적용
	// a.b.c.d.ch1 패키지(폴더) 내에서만 사용가능
	// return 값이 존재하므로, void를 쓰지 않음.
	// 유의해야 할 사항, aM() 매개변수의 데이터 타입과
	// return에서 a+b의 데이터 타입이 같아야 오류가 나지 않음.
	// static 옆의 int와 return에서 데이터 타입이 같아야 한다는 얘기임.
		System.out.println("a.b.c.d.ch1.Method_Practice_2의 aM함수 \n");
		
		int a=1;
		// a를 int라는 변수로 지정해주고 1을 대입해줌.
		int b=2;
		// b를 int라는 변수로 지정해주고 2를 대입해줌.

		return a+b;
	}
	static void bM(){
	// public을 쓰지 않았기 때문에, default 키워드가 적용
	// a.b.c.d.ch1 패키지(폴더) 내에서만 사용가능
	// return 값이 없기 때문에, void를 씀.
		System.out.println("a.b.c.d.ch1.Method_Practice_2의 bM함수 \n");
	}

	static int cM(){
		int sum=Method_Practice_2.aM();
		// aM함수에서 값을 받아온다음 
		int c=3;
		// cM 함수 내에서 c를 int로 지정하고, 3을 대입해보기

		return sum+c;
		// 출력해보기
	}

	static int dM(){
		int sum_3=Method_Practice_2.cM();
		int d=4;
		int e=5;

		return sum_3+d+e;
	}

	static int eM(){
		int sum_5=Method_Practice_2.dM();
		int f=6;
		int g=7;
		int h=8;
		int i=9;
		int j=10;

		return sum_5+f+g+h+i+j;

	}

	public static void main(String args[]){
		System.out.println("a.b.c.d.ch1.Method_Practice_2의 main함수 \n");
		System.out.println("bM 함수 출력 \n");
		Method_Practice_2.bM();
		int sum=Method_Practice_2.aM();
		System.out.println("Method_Practice_2 클래스에 있는 aM 함수값 도출 \n");
		System.out.println("int sum="+sum+"\n");
		System.out.println("Method_Practice_2 클래스에 있는 cM 함수값 도출 \n");
		int sum_2=Method_Practice_2.cM();
		System.out.println("int sum_2="+sum_2+"\n");
		int sum_4=Method_Practice_2.dM();
		System.out.println("1부터 5까지의 합 : "+sum_4+"\n");
		int sum_6=Method_Practice_2.eM();
		System.out.println("1부터 10까지의 합 : "+sum_6+"\n");
	}
}//end of Mehod_Practice_2 class