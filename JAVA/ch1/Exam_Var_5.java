package a.b.c.ch1;

/*
1. ���ڿ�		������ �迭
	�ڹٿ����� String Ŭ������ ���ڿ��� �ٷ��.
	String Ŭ������ char�� �迭�̴�. 
2. �迭 
	�����͸� ������(������ sequence, index, ÷��)���� ������ ���� �� 
*/
public class Exam_Var_5 {


	public void stringTest(){
		
		/*
		1. ���ڿ��� �ٷ�� Ŭ���� String �����ϰ�
		2. String Ŭ������ �������� str �����ϰ�
		3. = : ���Կ����� �����ϰ�
		4. "abc" ���ڿ��� str ������ ������ �Ѵ�. 
		*/
		String str = "abc";
		System.out.println("str >>> : " + str);

		// public char charAt(int index)
		char ch0 = str.charAt(0);
		char ch1 = str.charAt(1);
		char ch2 = str.charAt(2);
		
		// abc �� ���� �������ε� ������ �� ���� ������ ���� �ʴ´�.
		//char ch3 = str.charAt(3);

		System.out.println("ch0 >>> : " + ch0);
		System.out.println("ch1 >>> : " + ch1);
		System.out.println("ch2 >>> : " + ch2);

		// abc �� ���� �������ε� ������ �� ���� ������ ���� �ʰ�
		// ������ �� ������ �߻��ȴ�.
		// System.out.println("ch3 >>> : " + ch3);

		String str2 = "�ڰǿ�";
		System.out.println("str2 >>> : " + str2);
		char ch20 = str2.charAt(0);
		char ch21 = str2.charAt(1);
		char ch22 = str2.charAt(2);
		System.out.println("ch20 >>> : " + ch20);
		System.out.println("ch21 >>> : " + ch21);
		System.out.println("ch22 >>> : " + ch22);
	}		

	public static void main(String args[]) {

		new Exam_Var_5().stringTest();
	} // end of mai()
} // end of Exam_Var_5 