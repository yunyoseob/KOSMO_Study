package a.b.c.d.ch1;


public class Method_Practice_2{
	static int aM(){
	// public�� ���� �ʾұ� ������, default Ű���尡 ����
	// a.b.c.d.ch1 ��Ű��(����) �������� ��밡��
	// return ���� �����ϹǷ�, void�� ���� ����.
	// �����ؾ� �� ����, aM() �Ű������� ������ Ÿ�԰�
	// return���� a+b�� ������ Ÿ���� ���ƾ� ������ ���� ����.
	// static ���� int�� return���� ������ Ÿ���� ���ƾ� �Ѵٴ� �����.
		System.out.println("a.b.c.d.ch1.Method_Practice_2�� aM�Լ� \n");
		
		int a=1;
		// a�� int��� ������ �������ְ� 1�� ��������.
		int b=2;
		// b�� int��� ������ �������ְ� 2�� ��������.

		return a+b;
	}
	static void bM(){
	// public�� ���� �ʾұ� ������, default Ű���尡 ����
	// a.b.c.d.ch1 ��Ű��(����) �������� ��밡��
	// return ���� ���� ������, void�� ��.
		System.out.println("a.b.c.d.ch1.Method_Practice_2�� bM�Լ� \n");
	}

	static int cM(){
		int sum=Method_Practice_2.aM();
		// aM�Լ����� ���� �޾ƿ´��� 
		int c=3;
		// cM �Լ� ������ c�� int�� �����ϰ�, 3�� �����غ���

		return sum+c;
		// ����غ���
	}

	static int dM(){
		int sum_3=Method_Practice_2.cM();
		int d=4;
		int e=5;

		return sum_3+d+e;
	}

	static int eM(){
		int sum_5=Method_Practice_2.dM();
		int f=6;
		int g=7;
		int h=8;
		int i=9;
		int j=10;

		return sum_5+f+g+h+i+j;

	}

	public static void main(String args[]){
		System.out.println("a.b.c.d.ch1.Method_Practice_2�� main�Լ� \n");
		System.out.println("bM �Լ� ��� \n");
		Method_Practice_2.bM();
		int sum=Method_Practice_2.aM();
		System.out.println("Method_Practice_2 Ŭ������ �ִ� aM �Լ��� ���� \n");
		System.out.println("int sum="+sum+"\n");
		System.out.println("Method_Practice_2 Ŭ������ �ִ� cM �Լ��� ���� \n");
		int sum_2=Method_Practice_2.cM();
		System.out.println("int sum_2="+sum_2+"\n");
		int sum_4=Method_Practice_2.dM();
		System.out.println("1���� 5������ �� : "+sum_4+"\n");
		int sum_6=Method_Practice_2.eM();
		System.out.println("1���� 10������ �� : "+sum_6+"\n");
	}
}//end of Mehod_Practice_2 class