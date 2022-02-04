package a.b.c.ch1;

public class ClassTest_practice_2{
	// ��� ����
	byte bVal;
	char cVal;
	short sVal;
	int iVal;
	long lVal;

	float fVal;
	double dVal;
	boolean boolVal;
	String strVal;

	public static void main(String args[]){
		/*
		1. ClassTest_practice_2 Ŭ������ ����Ϸ���
		�� ���� ClassTest_practice_2�� �ν��Ͻ� instance �ؾ� �Ѵ�.
		2. instance(�ν��Ͻ�): Ŭ������ �޸𸮿� �ø��� ���� :
		���� ��ǥ���� ������ new Ű���� ������
		3. new Ű����(������)�� �ν��Ͻ� �ϴ¹��(�޸𸮿� �ø��� ���)
		3-1. ����Ϸ��� �ϴ� Ŭ����(��Ʈ�� Ŭ���� rt.jar�� �ִ� Ŭ����,
		����� ���� Ŭ����)�� Ŭ���� �̸����� �����Ѵ�.
		3-2. �������� reference variable�� �����Ѵ�.
		3-3. = ���� ������ ����
		3-4. Ŭ���� �̸� �� () �Ұ�ȣ�� �ٿ��� �����ڸ� �����.
		===================
		�����ڰ� �޸𸮿� �ö󰡸� (�ν��Ͻ� �Ǹ�)
		�ش� Ŭ������ �ִ� ��������� ����Ʈ ������ �ʱ�ȭ �Ѵ�.
		===================
		Ŭ�����̸� �������� = new Ŭ�����̸�();
		Ŭ�����̸�() <- �����ڶ�� �Ѵ�. �� �����ڰ� �ش� Ŭ���� ���ο�
					  ������ ��������� ����Ʈ ������ �ʱ�ȭ �Ѵ�.		
		*/
		int iVal=101;
		long lVal=123456789l;

		ClassTest_practice_2 ec=new ClassTest_practice_2();
		System.out.println("ec �������� �ּҰ� >>> : "+ec);
		// ���� ������� ��ü ec �ּҰ��� ����Ѵ�.
		System.out.println("ec bVal >>> : " + ec.bVal);
		// ���� ������� ��ü ec �� bool ������ ����Ѵ�.
		System.out.println("ec cVal >>> : " + ec.cVal);
		// ���� ������� ��ü ec�� char ������ ����Ѵ�.
		System.out.println("ec sVal >>> : " + ec.sVal);
		// ���� ������� ��ü ec�� short ������ ����Ѵ�.
		System.out.println("ec iVal >>> : " + ec.iVal);
		// ���� ������� ��ü ec�� int ������ ����Ѵ�.
		// ���������� iVal=101�� ��µ��� �ʰ�, ��������� iVal�� ��µȴ�.
		System.out.println("ec lVal >>> : " + ec.lVal);
		// ���� ������� ��ü ec�� long ������ ����Ѵ�.
		// ���������� lVal=123456789l�� ��µ��� �ʰ�, ��������� lVal�� ��µȴ�.
		System.out.println("ec fVal >>> : " + ec.fVal);
		// ���� ������� ��ü ec�� float ������ ����Ѵ�.
		System.out.println("ec dVal >>> : " + ec.dVal);
		// ���� ������� ��ü ec�� double ������ ����Ѵ�.
		System.out.println("ec boolVal >>> : " + ec.boolVal);
		// ���� ������� ��ü ec�� boolean ������ ����Ѵ�.
		System.out.println("ec strVal >>> : " + ec.strVal);
		// ���� ������� ��ü ec�� String ������ ����Ѵ�.
		// String ������ �����ڷ����� �ƴ϶�, �����ڷ����� ���Ѵ�.
	} // end of main method
} // end of ClassTest_practice_2 class