package a.b.c.d.ch1;

public class Method_Practice_1{
	public static void aM(){
		System.out.println("aM() method �Լ�");
	}

	public static void bM(){
		System.out.println("bM() method �Լ�");
	}

	public static void cM(){
		System.out.print("cM() method �Լ�");
	}

	public static void dM(){
		System.out.print("���� dM�Լ��Դϴ�. aM,bM,cM �Լ� ���� �ҷ����ڽ��ϴ�.");
		System.out.print("aM,bM,cM �Լ� ���� ȣ��");
		System.out.print("\n");
		aM();
		System.out.print("\n");
		bM();
		System.out.print("\n");
		cM();
	}

	public static void main(String args[]){
		System.out.println("1. ù ��° ���ο��� Mehod_Practice_1 Ŭ���� ���� �ִ� main() �Լ� ���� >>> : ");
		// java �ܼ� ���ø����̼��� main �Լ����� ����
		// main �Լ��� ��ġ�� ���� �ƹ��� ����� ����.
		// �׷��� �� �Ʒ� ���� ���� �����̴�.
		System.out.print("\n");
		System.out.println("2. aM�Լ� ȣ��");
		Method_Practice_1.aM();
		System.out.print("\n");
		System.out.println("3. cM�Լ� ȣ��");
		Method_Practice_1.cM();
		// bM�� cM���� ���� ������, ȣ���� cM�� �����ϸ�, cM�� ���� ��µȴ�.
		// �����ؾ� �� ���� �����ϰ��������� �ƴ϶� ���� ����������� main -> ȣ�� ������ ��µǴ� ���̴�.
		System.out.println("\n");
		System.out.println("4. aM,bM,cM ���� ȣ��");
		Method_Practice_1.dM();
		// dM �Լ� ������ aM(), bM(), cM() �Լ������� �ٽ� ȣ���Ͽ� ���
	}
}