package a.b.c.ch1;

public class Str_practice_2{
	public void stringTest(){
		System.out.println("\n stringTest method ���� \n");
		// String �� ���� ����
		// ���ڿ��� �ʱ�ȭ �ϴ� ���
		
		// ù ��° ���
		String str0="";
		// �����ؾ� �� ���� char���� ���ڷ� �ʱ�ȭ �� ����
		// char str=' '; ���� �� ĭ �� ������
		// String������ null space�� ���ڷ� ����ϱ� ������
		// String str0="";���� ���ڿ��� �ʱ�ȭ �Ѵ�.
		// str0�̶�� ������ String�̶�� �����ڷ����� �Ҵ��� ����
		// ���� �����ڸ� ���� ""�� �����Ѵ�.
		// �� �� ""�� ���ڿ� �ʱ�ȭ�� �ǹ��Ѵ�.


		// �� ���� ���
		String str1=null;
		// default ������
		// �����Ͱ� ���ٴ� �ǹ��̹Ƿ� �����͸� �ʱ�ȭ (������ ��) �ؼ� ����ؾ� �Ѵ�.
		// str1�̶�� ������ String�̶�� �����ڷ����� �Ҵ��� ����
		// ���� �����ڸ� ���� null���� �����Ѵ�.
		// null�� �ʱ�ȭ �ϴ� ����̴�.

		// ����� ���� ��� ����
		String str2=" ve l og";

		System.out.println("str0.length() >>> "+str0.length()+"\n");
		// ""���� �ʱ�ȭ �ϴϱ� 0�� ��� ��
		// System.out.println("str1.length() >>> "+str1.length()+"\n");
		// null�� �ʱ�ȭ �ϴϱ� NullPointerException ������ ����
		System.out.println("str2.length() >>> "+str2.length()+"\n");
		// 8�� ��� ��. ���� ���� 5��������, ���⵵ ���ڷ� �����ϱ� ������
		// 8�� ������ ���̴�

		// ���Ĺ����� ���� length()�� public int length()��.
		// ����, int ���� = ����.length();�� �������� ���� ����.
		int str0_0=str0.length();
		//int str1_0=str1.length();
		// null���� �ʱ�ȭ �� ��� �ش� ��ɾ� NullPointerException ������ ���� �Ұ�
		int str2_0=str2.length();

		System.out.println("int ���� = ����.length() ���� str0.length() >>> "+str0_0+"\n");
		// ""���� �ʱ�ȭ �� ���� 0�� ����
		//System.out.println("int ���� = ����.length() ���� str1.length() >>> "+str1_0+"\n");
		// null���� �ʱ�ȭ �� ���� NullPointerException ������ ����
		System.out.println("int ���� = ����.length() ���� str2.length() >>> "+str2_0+"\n");
		// 8�� ����
		
		// length() �����ʰ� �׳� ����غ���
		System.out.println(" ū ����ǥ �ʱ�ȭ >>> "+str0+"\n");
		// �ƹ� �͵� ������ ����.
		System.out.println(" null �ʱ�ȭ >>> "+str1+"\n");
		// ""���� �ʱ�ȭ �� ���� null�� ��µȴ�.
		System.out.println("ve l og >>> "+str2+"\n");
		// ve l og���� ��µ�.

		// ���������� charAt�� �� ���ھ� �и��ؼ� ���캸��
		// System.out.println("null �ʱ�ȭ �и��ؼ� ���� >>> "+str1.charAt(0)+"\n");
		// null���� �ʱ�ȭ �� ���� NullPointerException���� ������ ��µ��� ����.
		System.out.println("ve l og  �и��ؼ� ���� >>> "+str2.charAt(1)+"\n");
		// v�� �� ��� ��.

	} // end of stringTest method
	public static void main(String args[]){
		new Str_practice_2().stringTest();
	} // end of main method

} // end of Str_practice_2 class