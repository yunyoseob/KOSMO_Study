package a.b.c.ch1;

/*
ASCII( /?��ski/, �ƽ�Ű)
�̱�������ȯǥ�غ�ȣ(����: American Standard Code for Information Interchange), 

�ڹٿ����� ASCII �ڵ带 �����ڷ��� char �� ǥ���Ѵ�. 
���ڸ� char�� ǥ���Ѵ�.
*/

// char = Character ���� �ǹ�
// �����ڷ����� wrapper Ŭ������ �����ϻ�

// char �ڷ��� �����ϱ� 
// Ŭ���� �ڿ� = ���� + �Լ� 
// ����� ���� Ŭ���� Exam_Var_4_1 �� �ڿ� = ���� + �Լ� (charMethod(), main())

// �ڹٿ��� Ŭ������ �ִ� �ڿ��� �޸𸮿� �ø��� ���
// 1. static Ű���� <-- �����ϼ��� 
// 2. new Ű����  ������ 
public class Exam_Var_4_1 {

	void charMethod() {
		System.out.println("�����ڷ��� char �� Wrapper Ŭ���� Character");
		System.out.println("char 2byte(�������� 16bit, ���ڸ� �ٷ�� ������ ������ ���� �� ����.)");

		// BYTES, MAX_VALUE, MIN_VALEU, SIZE �ֿܼ� ����ϱ� 
		// public static final int	BYTES	
		// int charBytes = java.lang.Character.BYTES;
		int charBytes = Character.BYTES;
		// public static final char MAX_VALUE
		// char charMaxValue = java.lang.Character.MAX_VALUE;
		char charMaxValue = Character.MAX_VALUE;
		// public static final char MIN_VALUE	l
		// char charMinValue = java.lang.Character.MIN_VALUE;
		char charMinValue = Character.MIN_VALUE;
		// public static final int	SIZE
		// int charSize = java.lang.Character.SIZE;
		int charSize = Character.SIZE;

		System.out.println("charBytes >>> : " + charBytes);
		System.out.println("charMaxValue >>> : " + charMaxValue);
		System.out.println("charMinValue >>> : " + charMinValue);
		System.out.println("charSize >>> : " + charSize);

		int charMaxValue_1 = Character.MAX_VALUE;
		int charMinValue_1 = Character.MIN_VALUE;
		System.out.println("charMaxValue_1 >>> : " + charMaxValue_1);
		System.out.println("charMinValue_1 >>> : " + charMinValue_1);


		char charMin = '\u0000'; // �����ڵ�
		char charMax = '\uFFFF'; // �����ڵ� 
		System.out.println("charMin >>> : " + charMin);
		System.out.println("charMax >>> : " + charMax);

		char charinitialization  = ' '; // char ������ Ÿ���� �� ���ڿ�, �̱� �����̼����� �ʱ�ȭ �Ѵ�.
		System.out.println("charinitialization >>> : " + charinitialization);

	}

	public static void main(String args[]) {

		// �޸𸮿� �ø��� ��� : Ŭ���� ��ü�� �ø���. : �ڹٿ����� Ŭ������ �ּ� �����̴�. 
		// Ŭ������ �޸𸮿� �ø��� ��� : �ν��Ͻ� : instance
		// Ŭ�����̸� �������� = new Ŭ�����̸�()
		Exam_Var_4_1 ev4 = new Exam_Var_4_1();
		System.out.println("ev4 �������� : �ּҰ� >>> : " + ev4);
		// System.out.println("ev4.charMethod() >>> : " + ev4.charMethod());
		ev4.charMethod();

		// new Exam_Var_4_1().charMethod();

	} // end of mai()
} // end of Exam_Var_4_1 