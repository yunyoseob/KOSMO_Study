// ��Ű���� �ڹټҽ� �� ��ܿ� ����ϱ� 
// �б��� Ű���� ��Ű������ ����ϰ� �������� �����ڷ� ; (�����ݷ�) ������ �����ؾ� �Ѵ�.
package a.b.c.d;

// �ڹٿ��� ����ϴ� ���� �ּ� 
/*
	�ڹٿ��� ����ϴ� ������ �ּ� 
	�ּ��� ������ �� ���࿡ �ƹ� ������ ���� �ʴ´�.
	�ּ� �뵵�� 
	�� ������ ������ �ϴ���
	�ش� ����� ������ �ϴ��� ����ϴ� ���̴�.
*/

/*
�ܼ� ���ø����̼� HelloPack_1.java �� 
	public static void main(String args[]){} 
	main() �Լ��� �����϶�� �ϴ� ���̱� 
�ֿܼ� "��Ű���� ���丮�̴�" ���ڿ��� ��� �Ͻÿ� 
	System.out.println("��Ű���� ���丮�̴�");
�� ��Ű���� a.b.c.d �� ����Ѵ�.
	��Ű���� �ڹټҽ� �� ��ܿ� ����.
*/


public class HelloPack_1{

	public static void main(String args[]){
		
		System.out.println("��Ű���� ���丮�̴�");
	}
}

/*
C:\00.KOSMO108\10.JExam>javac -d "C:\00.KOSMO108\10.JExam" HelloPack_1.java

C:\00.KOSMO108\10.JExam>javap a.b.c.d.HelloPack_1
Compiled from "HelloPack_1.java"
public class a.b.c.d.HelloPack_1 {
  public a.b.c.d.HelloPack_1();
  public static void main(java.lang.String[]);
}

C:\00.KOSMO108\10.JExam>java a.b.c.d.HelloPack_1
��Ű���� ���丮�̴�
*/