package a.b.c.ch1;

public class Str_practice{
	public void str_prac(){
		String velog="velog is good"+null;
		System.out.println("velog.length() >>> "+velog.length());
		// java se 8 api : public int length()
		// 13 
		// velog is good�� 11�����ε�, length()�� �� ��, 13�����̴�.
		// ���⵵ ���ڷ� �����Ѵٴ� �ǹ̷� �ؼ��� �� �ִ�.

		// �߰������� null�� �ٿ��ִϱ�
		// 17���ڷ� ������ ���´�. null�� ���ڷ� ����ϴ� ���̴�.
		System.out.println("velog.charAt(0) >>> "+velog.charAt(0));
		// v
		System.out.println("velog.charAt(1) >>> "+velog.charAt(1));
		// e
		System.out.println("velog.charAt(2) >>> "+velog.charAt(2));
		// l
		System.out.println("velog.charAt(3) >>> "+velog.charAt(3));
		// o
		System.out.println("velog.charAt(4) >>> "+velog.charAt(4));
		// g
		System.out.println("velog.charAt(5) >>> "+velog.charAt(5));
		// null space
		System.out.println("velog.charAt(6) >>> "+velog.charAt(6));
		// i
		System.out.println("velog.charAt(7) >>> "+velog.charAt(7));
		// s
		System.out.println("velog.charAt(8) >>> "+velog.charAt(8));
		// null space
		System.out.println("velog.charAt(9) >>> "+velog.charAt(9));
		// g
		System.out.println("velog.charAt(10) >>> "+velog.charAt(10));
		// o
		System.out.println("velog.charAt(11) >>> "+velog.charAt(11));
		// o
		System.out.println("velog.charAt(12) >>> "+velog.charAt(12));
		// d
		System.out.println("velog.charAt(13) >>> "+velog.charAt(13));
		// null�� ���ڷ� ����Ͽ� n�� ����Ѵ�.
	} // end of str_prac method

	public static void main(String args[]){
		// str_prac() method�� static ������ Ű���尡 �����Ƿ�, new Ű���带 ���
		new Str_practice().str_prac();
		// Str_practice() : ������ 
	} // end of main method
} // end of Str_practice class