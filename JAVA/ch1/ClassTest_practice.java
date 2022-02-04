package a.b.c.ch1;


public class ClassTest_practice{
	// ��� ����
	int iVal;
	
	// ����ƽ ����, Ŭ���� ����
	// static Ű���尡 ���� ������
	// ������ �� �ڹ� ��ö�ӽ�(JVM)�� �ش� ������ ���� �ʱ�ȭ ���ش�.
	static int iValStatic;

	// void : ���ϰ��� ���� : return Ű���带 ����� �� ����.
	public static void main(String args[]){
		System.out.println("main()�Լ��� �ܼ� ���ø����̼� �������̴�.");
		System.out.println("�Լ� ���ȿ����� ��������Ʈ ������� ����ȴ�.");

		// �Լ� �� ���ο��� ������ ���� �����̴�.
		// ���� ������ ����ϱ� ���� ������ �ʱ�ȭ�� �Ǿ� �־�� �Ѵ�.
		int i=10;
		System.out.println("i>>>:"+i);

		// static ���� ȣ���ϱ�
		//System.out.println("iValStatic >>> :"+iVal);
		// ����������� iVal�� int ������ ����� static�� ���� �ʾұ� ������
		// ������ ����. (�޸𸮿� �ø��� �ʾ���.)
		
		// static Ű���尡 ���� ���� iVal ��� ���� ����
		// iVal ��������� �޸𸮿� �÷��� �Ѵ�.
		ClassTest_practice ec=new ClassTest_practice();
		System.out.println("ClassTest_practice ����� ���� Ŭ������ ����(��������) ec >>> : \n"+ec);
		System.out.println("ec.iVal >>> : "+ec.iVal);

		ClassTest_practice ec_1=new ClassTest_practice();
		System.out.println("ClassTest_practice ����� ���� Ŭ������ ����(��������) ec >>> : \n"+ec_1);
		System.out.println("ec.iVal >>> : "+ec_1.iVal);
		//System.out.println("ClassTest_practice ����� ���� Ŭ������ ����(��������) ec >>> : \n"+ec_1.iValStatic);
	} // end of main

} // end of class

/*
iVal�� static���� �ʾ��� �� ����� ����
ClassTest_practice.java:24: error: non-static variable iVal cannot be referenced from a static context
                System.out.println("iValStatic >>> :"+iVal);
1 error
*/

/*
�޸��� ������ ũ�� �ڵ念��, �����Ϳ���, ���ÿ���, ���������ִ�.

�ڵ念���� ������ ���α׷��� �ڵ尡 ����Ǵ� ����

�����Ϳ����� ���� ������ ����(static) ������ ����Ǵ� ����

����(stack)������ �Լ��� ȣ��� ����Ǵ� ���������� �Ű������� ����Ǵ� ����

�������� ����ڰ� ���� ������ �� �ִ� �޸� ����. ����ڿ� �Ǹ� �޸� ������ �������� �Ҵ�ǰ� ������.

���� ���ϸ� Class_Test_practice���� static�� ����
main �Լ��� �޸𸮿� �Ҵ��� �ߴµ�, 

int iVal�� ��� �Ҵ��� ���� �ʾҴµ� println���� ����� �õ��ϴϱ�

�޸𸮿��� ���� ���⶧���� ����� ���� �ʴ´�.

�׷���, ClassTest_practice ec=new ClassTest_practice();

��ɾ ����, main�Լ��� ���ÿ��� ������ ��ü�� �����ϸ� ��ü ��ü�� ���� �޸𸮿� �Ҵ��� �Ǽ�

�ش� ��ü���� iVal ����� ���������� ���̴�.
*/

/*
�� �� ��ü������ ����ϸ� ���� class������
static int iVal; �� �Ѵٸ�
main() �Լ��� �Բ� static�� �Ǳ� ������,
Ŭ���� ����(����ƽ ����)�� static int iVal��
���� �������� ����� ���������ٴ� ���̴�.

��ü�� �����ؼ� ���ư��� ������
ClassTest_practice ec=new ClassTest_practice();
��ɾ ���� ���Կ����ڷ� new Ű���带 �����������ν�,
main �Լ��� ���ÿ�������
ClassTest_practice@15db9742 ��� �ּҷ�
��ü�� ������ ���� ������־��� ������
ec.iVal�� ����� ���������� ���̴�.

�ٸ� ���÷� ����
ClassTest_practice ec_1=new ClassTest_practice();
��ɾ ���� ���Կ����ڷ� new Ű���带 �������ָ�,
main �Լ��� ���ÿ������� 
ClassTest_practice@6d06d69c ��� �ּҷ�
��ü�� ������ ���� ������� �� �ִ�.

�� �� �����ؾ� �ϴ� ������ �տ��� ������ ��ü�� ec1�̶�� �̸����� ���� ��ü�� �ּҴ�
���� �ٸ���. ��, ec�� ec_1 ������ü�� �ٸ��� �ȴٴ� ���̴�.

����, ec��� ��ü�� ������ �Ŀ�
ec_1�� �ּҿ��� ����� �õ��ϸ�

ClassTest_practice.java:34: error: cannot find symbol
                System.out.println("ClassTest_practice ����� ���� Ŭ������ ����(��������) ec >>> : \n"+ec_1);
                                                                                         ^
  symbol:   variable ec_1
  location: class ClassTest_practice
1 error

�̶�� ������ ��µȴ�.

*/

/*
����������

System.out.println("ClassTest_practice ����� ���� Ŭ������ ����(��������) ec >>> : \n"+ec_1.iValStatic);

������ static�� �̹� �� ������ ���� ���� ��ü���� ����ϴ� ���� ���߿� ���α׷����� �� ��, ������ ���� �� �����Ƿ�
�ϸ� �� �ȴ�.
*/