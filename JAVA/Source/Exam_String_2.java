package a.b.c.ch1;

/*
1. ASCII(American Standard Code for Information Interchange)
	ASCII�� ������ ���ڿ� ���ڵ��̴�.
	7 bit�� �����Ǿ� ������, ��� ���� ����, ����, Ư������, ��ȣ �� 128�� ���ڸ� ǥ���� �� �ִ�.

2. ANSI(American National Standard Institute)
	ANSI�� 8bit�� �����Ǿ� ������ 256���� ���ڸ� ǥ���� �� �ִ�.
	ANSI�� �� 7bit�� ASCII�� �����ϰ�, �ڿ� 1bit�� �̿��Ͽ� �ٸ� ����� ���ڸ� ǥ���Ѵ�.
*/

public class Exam_String_2 {

	public void stringTest() {
		System.out.println("Exam_String_2.stringTest() �Լ� ���� >>> : ");
		System.out.println("String Ŭ�������� ���ڿ� ���� �����̼��� ����Ѵ�.");

		// ��Ʈ�� Ŭ������ �ʱ�ȭ �ϴ� �溡
		String str0 = ""; // ���ڿ��� �ʱ�ȭ �ϴ� ���
		String str1 = null; // null �� �ʱ�ȭ �ϴ� ��� : default ��
							// �����Ͱ� ���ٴ� �ǹ��̹Ƿ� �����͸� �ʱ�ȭ(������ ��) �ؼ� ����ؾ��Ѵ�.
		String str2 = " ab c  ";

		// public int length()		
		System.out.println("str0.length() ���ڿ� ���̸� ���ϴ� �Լ� >>> : " + str0.length());
		int str0Length = str0.length();
		System.out.println("str2Length ���ڿ� ���̸� ���ϴ� �Լ� >>> : " + str0Length);		
		System.out.println("str2.length() ���ڿ� ���̸� ���ϴ� �Լ� >>> : " + str2.length());
		int str2Length = str2.length();
		System.out.println("str2Length ���ڿ� ���̸� ���ϴ� �Լ� >>> : " + str2Length);

		// System.out.println("str1.length() ���ڿ� ���̸� ���ϴ� �Լ� >>> : " + str1.length());
		/*
		Exception in thread "main" java.lang.NullPointerException
        at a.b.c.ch1.Exam_String_2.stringTest(Exam_String_2.java:22)
        at a.b.c.ch1.Exam_String_2.main(Exam_String_2.java:29
		*/

		System.out.println("str0 >>> : " + str0);
		System.out.println("str1 >>> : " + str1);
		System.out.println("str2 >>> : " + str2);

		// System.out.println("str0.charAt(0) >>> : " + str0.charAt(0));
		/*
		Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        at java.lang.String.charAt(String.java:658)
        at a.b.c.ch1.Exam_String_2.stringTest(Exam_String_2.java:34)
        at a.b.c.ch1.Exam_String_2.main(Exam_String_2.java:41)		
		*/
		// System.out.println("str1.charAt(0) >>> : " + str1.charAt(0));
		/*
		Exception in thread "main" java.lang.NullPointerException
        at a.b.c.ch1.Exam_String_2.stringTest(Exam_String_2.java:41)
        at a.b.c.ch1.Exam_String_2.main(Exam_String_2.java:47)		
		*/
		System.out.println("str2.charAt(0) >>> : " + str2.charAt(0));
		System.out.println("(int)str2.charAt(0) >>> : " + (int)str2.charAt(0));
		// public static String toHexString(int i)
		System.out.println("Integer.toHexString(str2.charAt(0)) >>> : " 
							+ Integer.toHexString(str2.charAt(0)));
		System.out.println("Integer.toHexString(str2.charAt(1)) >>> : " 
									+ Integer.toHexString(str2.charAt(1)));
		System.out.println("Integer.toHexString(str2.charAt(2)) >>> : " 
									+ Integer.toHexString(str2.charAt(2)));
		System.out.println("Integer.toHexString(str2.charAt(3)) >>> : " 
									+ Integer.toHexString(str2.charAt(3)));
		System.out.println("Integer.toHexString(str2.charAt(4)) >>> : " 
									+ Integer.toHexString(str2.charAt(4)));
		System.out.println("Integer.toHexString(str2.charAt(5)) >>> : " 
									+ Integer.toHexString(str2.charAt(5)));
		System.out.println("Integer.toHexString(str2.charAt(6)) >>> : " 
									+ Integer.toHexString(str2.charAt(6)));	
	}

	public static void main(String args[]) {
		
		new Exam_String_2().stringTest();
	}
}