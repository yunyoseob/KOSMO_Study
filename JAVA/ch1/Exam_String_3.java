package a.b.c.ch1;

public class Exam_String_3 {

	public void stringTest() {
		System.out.println("Exam_String_2.stringTest() �Լ� ���� >>> : ");

		/*
		1. String Ŭ���� ����
		2. String Ŭ���� ����Ϸ��� str0 ���� ����
		3. = : ���� ������ ���� : �����ʿ� �ִ� ���� ���ʿ� �ִ� ������ �����Ѵ�.
		4. "" : ���ͷ� (����) : ���ڿ�
		5. ; ���� ���� ������ 
		6. str0  ������ ���ڿ��� �����Ѵ�. 
		*/
		String str0 = ""; // ���ڿ��� �ʱ�ȭ �ϴ� ���
		//  str0 ���������� �����ؼ� ��Ʈ�����ڷ� String Ŭ������ �ִ� length() �Լ��� ȣ���ߴ�.
		//  ��� �� str0 �� ������  "" �� ���ڿ��� ���� ������ �ִ�. 
		str0.length();

		// System.out.println() �������� �ֿܼ� ����� �Ѵ�.
		System.out.println("" + str0.length());

		// str0.length() ȣ���� ��� ���� str0Length ������ �����Ѵ�. Ȱ���Ѵ�. ġȯ�Ѵ�.
		int str0Length = str0.length();
		// �� ǥ������ ����ǰ� �� �Ŀ��� str0Length ���� 0 ���� ���ԵǾ� �ִ�. 

		// System.out.println() �������� str0Length ������ ���Ե� ���� �ֿܼ� ����Ѵ�. 
		System.out.println("" + str0Length);
	}

	public static void main(String args[]) {
		
		new Exam_String_3().stringTest();
	}
}