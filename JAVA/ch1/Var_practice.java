package a.b.c.ch1;

public class Var_practice{
	void charMethod(){
		// public이라는 접근 제한자 키워드가 없고
		// static이라는 수정자 키워드가 없다
		// void라는 리턴형 키워드를 사용했기 때문에
		// return 값이 없으며 method 앞에 int나 string을 써주지 않아도 된다.
		System.out.println("Var_practice.charMethod() 시작 \n");
		char c1='A';
		System.out.println("c1 >>> :"+c1);
		// 이렇게 출력하면 아마 A가 나올 것이다.
		int c2=(int)c1;
		// 공식문서를 보면 java.lang.Integer 안에
		// static String이 들어가있다.
		// java.lang은 패키지인데, 내장되어 있기 때문에
		// 패키지를 굳이 앞에 쓰지 않고 생략해도 된다.
		// Integer는 java.lang 뒤에 있는 클래스 이름이다.
		// java.lang.Integer를 Name Space라고 부른다.
		System.out.println("int(c1) >>> :"+c2);

		// toBinaryString(int i)는 2진법
		String s_1=Integer.toBinaryString(c2);
		System.out.println("Integer.toBinaryString(c2) 결과 >>> :"+s_1);
		// 1000001로 결과가 출력된다.
		String s_2=Integer.toHexString(c2);
		System.out.println("Integer.toHexStrring(c2) 결과 >>>"+s_2);
		// 41
		String s_3=Integer.toOctalString(c2);
		System.out.println("Integer.toOctalStrring(c2) 결과 >>>"+s_3);
		// 65
		System.out.println("(int)c1 >>> :"+c2);	
		// 65

		System.out.println("\n 각 진법들이 똑같은 숫자를 의미하는지 확인하기 \n");
		int n_1=Integer.parseInt(s_1, 2);
		System.out.println("바꾸기 이전 : "+s_1+" Binary -> Octal >>>"+n_1+'\n');
		int n_2=Integer.parseInt(s_2, 16);
		System.out.println("바꾸기 이전 : "+s_2+" Hex -> Octal >>>"+n_2+'\n');
		// Integer.parseInt(String s, 진수)
		// String 타입의 변수를 Int 형으로 바꾸어줌.
		// n_1과 n_2를 int 형으로 선언해준 이유는, Integer.parseInt()의 매개변수가 String 타입으로
		// 받은 뒤, int로 저장해야하기 때문이다.
		// 공식문서를 보면 static int로 Modifier and Type가 저장되어 있음.

		int n_3=Integer.parseInt(s_3, 8);
		String ss_1=Character.toString((char) n_1); 
		String ss_2=Character.toString((char) n_2);
		String ss_3=Character.toString((char) n_3);
		// Character.toString은 
		// String이 있고, 참조변수 만들어야 하는 애
		// toString()으로 받는다.
		// static String이 있다. 참조변수 만들지 않아도 되는 애
		// toString(char c)로 받는다.
		// 나는 두 번째거를 썻는데, 
		// api를 보면, Returns a String object
		// representing the specified char.이라고 적혀있다.
		// 즉, String 객체를 반환하는 패키지의 클래스인 것이다.

		System.out.println(" Binary -> Octal -> String >>>"+ss_1+'\n');
		System.out.println(" Hex -> Octal -> String >>>"+ss_2+'\n');
		System.out.println(" Octal -> String >>>"+ss_3+'\n');
	} // end of charMethod method

	public static void main(String args[]){
		System.out.println("나는 main 함수 입니다. \n");
		Var_practice abc=new Var_practice();
		System.out.println("참조변수 주소 값(abc) :"+abc);
		System.out.println("Integer.toBinaryString(c2) 결과랑 c1 결과 A랑 비교해보기");
		abc.charMethod();
	} // end of main method

} // end of Var_practice class