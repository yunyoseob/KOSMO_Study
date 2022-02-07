package a.b.c.ch1;

public class Array_practice{
	/*
	String은 char의 집합이자 배열
	배열이란 데이터를 순차적(index)으로 관리하는 객체
	배열 연산자 [] 대괄호
	배열 종류 : 1차원 배열, 2차원 배열, ... 가변 배열
	1차원 배열 3가지 출력방법
	데이터형 참조변수[] 배열연산자 = new 데이터형 [배열이 들어갈 공간] 배열연산자;
	데이터형 참조변수[] = new 데이터형[]{};
	데이터형 참조변수[]={};
	*/

	public void array_test(){
		// 1번째 방법
		char cArray[]={'v','e','l','o','g'};
		// char 데이터 타입 배열 만들기
		// [] 형식이 아니라 {} 형식으로 한 다음
		// cArray[n]을 호출하면 n 인덱스에 해당하는 value가 출력된다.
		System.out.println("cArray[0] : >>> "+cArray[0]+"\n");
		System.out.println("cArray[1] : >>> "+cArray[1]+"\n");
		System.out.println("cArray[2] : >>> "+cArray[2]+"\n");
		System.out.println("cArray[3] : >>> "+cArray[3]+"\n");
		System.out.println("cArray[4] : >>> "+cArray[4]+"\n");
		// 배열에서 인덱싱할 때는 []을 사용한다.
		
		// 2번째 방법
		String velog=new String(cArray);
		// cArray 배열을 String 객체로 선언 []이 아닌 ()으로 쓴다.
		System.out.println("velog.charAt(0) : >>> "+velog.charAt(0)+"\n");
		System.out.println("velog.charAt(1) : >>> "+velog.charAt(1)+"\n");
		System.out.println("velog.charAt(2) : >>> "+velog.charAt(2)+"\n");
		System.out.println("velog.charAt(3) : >>> "+velog.charAt(3)+"\n");
		System.out.println("velog.charAt(4) : >>> "+velog.charAt(4)+"\n");
		// velog는 String 변수 이므로, charAt(int)를 통해
		// 출력한다. 
		// String에서 인덱싱 할 때는 ()를 사용한다.
		
		// 3번째 방법
		String velog_2=new String("velog");
		// String안에 배열을 집어넣는게 아니라 velog라는 글자 자체를 집어 넣는다.
		System.out.println("velog_2.charAt(0) : >>> "+velog_2.charAt(0)+"\n");
		System.out.println("velog_2.charAt(1) : >>> "+velog_2.charAt(1)+"\n");
		System.out.println("velog_2.charAt(2) : >>> "+velog_2.charAt(2)+"\n");
		System.out.println("velog_2.charAt(3) : >>> "+velog_2.charAt(3)+"\n");
		System.out.println("velog_2.charAt(4) : >>> "+velog_2.charAt(4)+"\n");
		
		// 4번째 방법
		String velog_3="velog";
		// new String이 아닌 글자 자체를 String 변수로 할당하는 방법
		System.out.println("velog_3.charAt(0) : >>> "+velog_3.charAt(0)+"\n");
		System.out.println("velog_3.charAt(1) : >>> "+velog_3.charAt(1)+"\n");
		System.out.println("velog_3.charAt(2) : >>> "+velog_3.charAt(2)+"\n");
		System.out.println("velog_3.charAt(3) : >>> "+velog_3.charAt(3)+"\n");
		System.out.println("velog_3.charAt(4) : >>> "+velog_3.charAt(4)+"\n");
	} // end of array_test method
	public static void main(String args[]){
		// 함수가 static 수정자 키워드가 없으므로 객체를 생성하여 출력
		new Array_practice().array_test();
		
	} // end of main method
} // end of Array_practice class