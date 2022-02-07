package a.b.c.ch1;

/*
1. 문자열(문자의 배열)
	자바에서는 String 클래스로 문자열을 다룬다.
	String 클래스는 char의 배열이다.

2. 배열
	데이터를 순차적(시퀀스 sequence, index, 첨자)으로 나열해 놓은 것
*/
	
public class Var_practice_4{
	public void stringTest(){
		String str="yunyoseob";
		System.out.print("str >>> : "+str+"\n");

		char ch0=str.charAt(0);
		char ch1=str.charAt(1);
		char ch2=str.charAt(2);
		// public char charAt(int index)
		// String이라는 문자열에서
		// char인 각 문자를
		// 출력 하는 것

		char ch3=str.charAt(3);
		char ch4=str.charAt(4);
		char ch5=str.charAt(5);

		char ch6=str.charAt(6);
		char ch7=str.charAt(7);
		char ch8=str.charAt(8);
		
		System.out.println("str.charAt(0) (char) >>> : "+ch0+"\n");
		System.out.println("str.charAt(1) (char) >>> : "+ch1+"\n");
		System.out.println("str.charAt(2) (char) >>> : "+ch2+"\n");
		System.out.println("str.charAt(3) (char) >>> : "+ch3+"\n");
		System.out.println("str.charAt(4) (char) >>> : "+ch4+"\n");
		System.out.println("str.charAt(5) (char) >>> : "+ch5+"\n");
		System.out.println("str.charAt(6) (char) >>> : "+ch6+"\n");
		System.out.println("str.charAt(7) (char) >>> : "+ch7+"\n");
		System.out.println("str.charAt(8) (char) >>> : "+ch8+"\n");

	} // end of stringTest method

	public void koreanstringTest(){
		String str_2="윤요섭";
		System.out.print("한글 str >>> :"+str_2+"\n");

		char ch0_1=str_2.charAt(0);
		char ch1_1=str_2.charAt(1);
		char ch2_1=str_2.charAt(2);

		System.out.println("한글 str_2.charAt(0) (char) >>> : "+ch0_1+"\n");
		System.out.println("한글 str_2.charAt(1) (char) >>> : "+ch1_1+"\n");
		System.out.println("한글 str_2.charAt(2) (char) >>> : "+ch2_1+"\n");
	} // end of koreanstringTest method

	public static void main(String args[]){
		new Var_practice_4().stringTest();
		new Var_practice_4().koreanstringTest();
	} // end of main method

} // end of Var_practice_4