package a.b.c.ch1;
// �ڹٿ��� ��θ� a���� �ȿ� b���� �ȿ� c���� �ȿ� ch1���������� �����Ѵ�.

public class Method_Practice{
// Method_Practice��� Ŭ������ ������ش�.
// �� ������ ��������

	public static void aMethod(int i){
		// �Լ��� �ϳ��� ����� �����ϴ� �Ϸ��� �ڵ��Դϴ�. (����� ��Ƶδ� ��)
		// �ڹٿ� ���� ��ü���� ������ �̸� �޼ҵ�(method)��� �θ��ϴ�.
		// public static void ������ ���� ������ Ű����
		// -> ������ Ű���� -> ������ ������ �����ؾ� �ݴϴ�.
		// public�̶�� ���� �����ڸ� ����� ������
		// ���߿� import �� �� �ְ� ������ֱ� �����Դϴ�.
		// static�̶�� ������ Ű���带 ����� ������ 
		// �޸𸮿� �ʱ�ȭ �Ͽ� �Ҵ����ֱ� �����Դϴ�.
		// return ���� ���� ������ void��� ������ Ű���带 �����ش�.
		// void�� ��� �ִٴ� �ǹ̷� '��ȯ�� ���� ����'�� ���� ����� �Դϴ�.
		// �Լ��� �̸��� aMethod�� ���ְ�,
		// �Լ��� �� �Ű�����(parameter)�� int i�� ���ش�.
		// int�� ���̴� ������ i�� �ڷ����� int���̶�� �����ֱ� �����̴�.
		int ii=i;
		// ii��� ������ int�� �����ص�, ���Կ�����(=)�� ���� int���� i�� �������ش�.
		System.out.println("aMethod() �Լ� �� �ȿ��� ��� >>> : " + ii);
	} // end of aMethod function ({}�ȿ� �ִ� ������ ��������)
	
	
	public static void main(String args[]){
		Method_Practice.aMethod(100);
		// ����� ���� Ŭ���� Method_Practice Ŭ���� main()�Լ�����
		// ����� ���� Ŭ���� Method_Practice�� �ִ� aMethod()�Լ��� ȣ���Ѵ� invoke �Ѵ�.
		// �� �� �����ؾ��� ���� �Ű������� ���� �ڷ��� ��Ģ�� �� ���缭 �Է��ؾ��Ѵ�.
		// Method_Practice.aMethod(100)�� 
		// Method_Practice��� Ŭ���� �ȿ� aMethod �޼ҵ忡 ����
		// �ְڴٶ�� �ǹ��Դϴ�.
	} // end of main function

} // end of Method_Practice class