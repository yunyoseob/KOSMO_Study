package a.b.c.ch1;

/*
1. ���ڿ�(������ �迭)
	�ڹٿ����� String Ŭ������ ���ڿ��� �ٷ��.
	String Ŭ������ char�� �迭�̴�.

2. �迭
	�����͸� ������(������ sequence, index, ÷��)���� ������ ���� ��
*/
	
public class Var_practice_4{
	public void stringTest(){
		String str="yunyoseob";
		System.out.print("str >>> : "+str+"\n");

		char ch0=str.charAt(0);
		char ch1=str.charAt(1);
		char ch2=str.charAt(2);
		// public char charAt(int index)
		// String�̶�� ���ڿ�����
		// char�� �� ���ڸ�
		// ��� �ϴ� ��

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
		String str_2="���伷";
		System.out.print("�ѱ� str >>> :"+str_2+"\n");

		char ch0_1=str_2.charAt(0);
		char ch1_1=str_2.charAt(1);
		char ch2_1=str_2.charAt(2);

		System.out.println("�ѱ� str_2.charAt(0) (char) >>> : "+ch0_1+"\n");
		System.out.println("�ѱ� str_2.charAt(1) (char) >>> : "+ch1_1+"\n");
		System.out.println("�ѱ� str_2.charAt(2) (char) >>> : "+ch2_1+"\n");
	} // end of koreanstringTest method

	public static void main(String args[]){
		new Var_practice_4().stringTest();
		new Var_practice_4().koreanstringTest();
	} // end of main method

} // end of Var_practice_4