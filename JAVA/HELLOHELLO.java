package a.b.c.d.ch1;

public class HELLOHELLO{
	static byte b;
	// ���� ���� �������ϸ� default ���� ����.
	// byte�� default == 0
	static void aM(){
		System.out.println("aM() �Լ�");
	} // aM() �Լ� ��� �ݱ�

	public static void main(String args[]){
		System.out.println("�ȳ��ϼ��� �ݰ����� ���־�� �ٽ� ������");
		System.out.println("b >>> :"+HELLOHELLO.b);
		// class + dot������ + �����Ѱ�
		// HELLOHELLO �տ� package �� �ٿ��ִ� ����
		// java package.�����̸����� �̹� ���Ա� ������
		// Ŭ������ Ŭ���� ���� �ִ� ���� �Է����ָ� ��.
		// ����, a.b.c.d.HELLOHELLO.b �̷��� �� �ʿ䰡 ����.
		System.out.println("b >>> �̰͵� �Ǵµ� �̰� ������� ���� :"+b);

		HELLOHELLO.aM();
		// class�� dot�����ڿ� �ȿ� �ִ� �Լ�
	} // main() �Լ� ��� �ݱ�
} // HELLOHELLO Ŭ���� ��� �ݱ�