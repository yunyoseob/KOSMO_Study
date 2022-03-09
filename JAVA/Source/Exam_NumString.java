package a.b.c.ch1;

public class Exam_NumString {

	public static void main(String args[]) {
	
		// ���� ���� : ���ڸ� ���ڿ��� ǥ���� �� : ���ڸ� ���� �����̼����� ���� �� 
		String sX = "1";
		String sY = "2";

		System.out.println(sX + sY);

		int iX = Integer.parseInt(sX);
		int iY = Integer.parseInt(sY);
		System.out.println(iX + iY);
		System.out.println("���ڿ� ���ϱ� �ϸ� ���ڵ� ���ڿ��� �ȴ�. >>> : ");
		System.out.println("" + (iX + iY));
		System.out.println("" + iX + iY);

		// ���� ���ڸ� ���ڷ� ��ȯ : parse
		String sI = "1";
		String sL = "11";
		String sF = "1.123";
		String sD = "1.1";
		
		int iVal = Integer.parseInt(sI);
		long lVal = Long.parseLong(sL);
		float fVal = Float.parseFloat(sF);
		double dVal = Double.parseDouble(sD);
		
		System.out.println("iVal >>> : " + iVal);
		System.out.println("lVal >>> : " + lVal);
		System.out.println("fVal >>> : " + fVal);
		System.out.println("dVal >>> : " + dVal);

		// ���ڸ� ���ڷ� ��ȯ
		
		int nInt = 100;
		long nLong = 101L;
		float nFloat = 1.01F;
		double nDouble = 1.001D;

		String sInt = Integer.toString(nInt); 
		String sLong = Long.toString(nLong); 
		String sFloat = Float.toString(nFloat); 
		String sDouble = Double.toString(nDouble); 
		
		System.out.println("sInt >>> : " + sInt);
		System.out.println("nLong >>> : " + nLong);
		System.out.println("nFloat >>> : " + nFloat);
		System.out.println("nDouble >>> : " + nDouble);

		String s0 = String.valueOf(nInt);
		String s1 = String.valueOf(nLong);
		String s2 = String.valueOf(nFloat);
		String s3 = String.valueOf(nDouble);

		System.out.println("s0 >>> : " + s0);
		System.out.println("s1 >>> : " + s1);
		System.out.println("s2 >>> : " + s2);
		System.out.println("s3 >>> : " + s3);

		String ss = nInt + "";  // ����� �������� 
		System.out.println("ss >>> : " + ss);
	}
}