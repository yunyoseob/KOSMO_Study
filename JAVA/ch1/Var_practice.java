package a.b.c.ch1;

public class Var_practice{
	void charMethod(){
		// public�̶�� ���� ������ Ű���尡 ����
		// static�̶�� ������ Ű���尡 ����
		// void��� ������ Ű���带 ����߱� ������
		// return ���� ������ method �տ� int�� string�� ������ �ʾƵ� �ȴ�.
		System.out.println("Var_practice.charMethod() ���� \n");
		char c1='A';
		System.out.println("c1 >>> :"+c1);
		// �̷��� ����ϸ� �Ƹ� A�� ���� ���̴�.
		int c2=(int)c1;
		// ���Ĺ����� ���� java.lang.Integer �ȿ�
		// static String�� ���ִ�.
		// java.lang�� ��Ű���ε�, ����Ǿ� �ֱ� ������
		// ��Ű���� ���� �տ� ���� �ʰ� �����ص� �ȴ�.
		// Integer�� java.lang �ڿ� �ִ� Ŭ���� �̸��̴�.
		// java.lang.Integer�� Name Space��� �θ���.
		System.out.println("int(c1) >>> :"+c2);

		// toBinaryString(int i)�� 2����
		String s_1=Integer.toBinaryString(c2);
		System.out.println("Integer.toBinaryString(c2) ��� >>> :"+s_1);
		// 1000001�� ����� ��µȴ�.
		String s_2=Integer.toHexString(c2);
		System.out.println("Integer.toHexStrring(c2) ��� >>>"+s_2);
		// 41
		String s_3=Integer.toOctalString(c2);
		System.out.println("Integer.toOctalStrring(c2) ��� >>>"+s_3);
		// 65
		System.out.println("(int)c1 >>> :"+c2);	
		// 65

		System.out.println("\n �� �������� �Ȱ��� ���ڸ� �ǹ��ϴ��� Ȯ���ϱ� \n");
		int n_1=Integer.parseInt(s_1, 2);
		System.out.println("�ٲٱ� ���� : "+s_1+" Binary -> Octal >>>"+n_1+'\n');
		int n_2=Integer.parseInt(s_2, 16);
		System.out.println("�ٲٱ� ���� : "+s_2+" Hex -> Octal >>>"+n_2+'\n');
		// Integer.parseInt(String s, ����)
		// String Ÿ���� ������ Int ������ �ٲپ���.
		// n_1�� n_2�� int ������ �������� ������, Integer.parseInt()�� �Ű������� String Ÿ������
		// ���� ��, int�� �����ؾ��ϱ� �����̴�.
		// ���Ĺ����� ���� static int�� Modifier and Type�� ����Ǿ� ����.

		int n_3=Integer.parseInt(s_3, 8);
		String ss_1=Character.toString((char) n_1); 
		String ss_2=Character.toString((char) n_2);
		String ss_3=Character.toString((char) n_3);
		// Character.toString�� 
		// String�� �ְ�, �������� ������ �ϴ� ��
		// toString()���� �޴´�.
		// static String�� �ִ�. �������� ������ �ʾƵ� �Ǵ� ��
		// toString(char c)�� �޴´�.
		// ���� �� ��°�Ÿ� ���µ�, 
		// api�� ����, Returns a String object
		// representing the specified char.�̶�� �����ִ�.
		// ��, String ��ü�� ��ȯ�ϴ� ��Ű���� Ŭ������ ���̴�.

		System.out.println(" Binary -> Octal -> String >>>"+ss_1+'\n');
		System.out.println(" Hex -> Octal -> String >>>"+ss_2+'\n');
		System.out.println(" Octal -> String >>>"+ss_3+'\n');
	} // end of charMethod method

	public static void main(String args[]){
		System.out.println("���� main �Լ� �Դϴ�. \n");
		Var_practice abc=new Var_practice();
		System.out.println("�������� �ּ� ��(abc) :"+abc);
		System.out.println("Integer.toBinaryString(c2) ����� c1 ��� A�� ���غ���");
		abc.charMethod();
	} // end of main method

} // end of Var_practice class