package a.b.c.ch1;

// String Ŭ���� : ���ڿ��� �ٷ�� Ŭ���� : char �迭�̴�. ������ �迭�̴�.

// �迭 : �����͸� ������(index, ÷��)���� �����ϴ� ��ü 
// �迭 ������ [] ���ȣ braket ����� 
// �迭 ���� : 1���� �迭, 2���� �迭.... ���� �迭
// 1���� �迭 : 
// �������� ��������[] �迭������ = new ��������[�迭�� �� ����] �迭������;
// �������� ��������[] = new ��������[]{};
// �������� ��������[] = {};

public class Exam_String {

	public void arrayTest() {
		System.out.println("Exam_String.arrayTest() �Լ� ���� >>> : ");

		// char(��) ������Ÿ���� �迭�̴�.
		char cArray[] = {'a', 'b', 'c'};
		System.out.println("cArray >>> : " + cArray);
		System.out.println("cArray[0] >>> : " + cArray[0]);
		System.out.println("cArray[1] >>> : " + cArray[1]);
		System.out.println("cArray[2] >>> : " + cArray[2]);

		// String Ŭ����(���ڿ� Ŭ����)�� �ν��Ͻ� �ߴ�.
		String str = new String(cArray);
		System.out.println("str >>> : " + str);
		System.out.println("str.charAt(0) >>> : " + str.charAt(0));
		System.out.println("str.charAt(1) >>> : " + str.charAt(1));
		System.out.println("str.charAt(2) >>> : " + str.charAt(2));

		// String Ŭ����(���ڿ� Ŭ����)�� �ν��Ͻ� �ߴ�.
		String str1 = new String("abc");
		System.out.println("str1 >>> : " + str1);
		System.out.println("str1.charAt(0) >>> : " + str1.charAt(0));
		System.out.println("str1.charAt(1) >>> : " + str1.charAt(1));
		System.out.println("str1.charAt(2) >>> : " + str1.charAt(2));

		//===========================================================
		// �̰͸� ����ϸ� �ȴ�.
		String str2 = "abc";
		System.out.println("str2 >>> : " + str2);
		System.out.println("str2.charAt(0) >>> : " + str2.charAt(0));
		System.out.println("str2.charAt(1) >>> : " + str2.charAt(1));
		System.out.println("str2.charAt(2) >>> : " + str2.charAt(2));
		//===========================================================
	}

	public static void main(String args[]) {
		
		new Exam_String().arrayTest();
	}
}