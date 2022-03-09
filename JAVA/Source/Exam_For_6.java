package a.b.c.ch1;

/*
�ϱ�	main() �Լ��� �ʱ�ȭ �� �������� 5���� 16������ �ֿܼ� ����Ͻÿ� 
��:	�Լ��� ���� main() �Լ����� �� �Լ��� ȣ���ؼ� ���� ��Ű�ÿ�
	�ֿܼ� 16������ ����� ���� 0x �� �ٿ��� ����Ͻÿ�
�Լ� �̸� toHex_S0(), toHex_S1(), toHex_S2(), toHex_S3(), toHex_S4()

16:45 ���� �ϱ� 
*/
public class Exam_For_6 {

	// toHex_S0 �Լ��� �����Ѵ�.
	// �Ű������� String ���ڿ��� �޴´�.
	public void toHex_S0(String str) {
		// toHex_S0 �Լ��� ȣ���ϸ� ���� ���� �ϱ� �αװ� �ֿܼ� ��µȴ�.
		System.out.println("Exam_For_6.toHex_S0() �Լ� ���� >>> : ");

		// toHex_S0 �Լ� ������ �Ű����� ������  String Ŭ���� str ������ 
		// toHex_S0 �Լ� ������ ����� �����ϴ�.

		// ���� �Լ��� new Exam_For_6().toHex_S0(s0); �̷��� 
		// toHex_S0(s0) �Լ��� ȣ���ϸ� 
		// �μ��� �Ѿ�� s0 ������ ����
		// str ������ ������ �ȴ�. String str = s0
		// String s0 = "abcdefghijklmnopqrstuvwxyz"; �ʱ�ȭ �� ����
		// str = "abcdefghijklmnopqrstuvwxyz"; ���� ���Եȴ�.

		// �̻��¿��� str ���� "abcdefghijklmnopqrstuvwxyz" �̷��� ������ �ҹ��� 26�� ���ԵǾ� �ִ�.

		// if  ������ 
		// str �� ���� null �� �ƴϰ� ���̰� 0 ���� Ŭ ���� if  ���� ����ȴ�.
		// str �� "abcdefghijklmnopqrstuvwxyz" ���� �ֱ� ������
		// if  �� ���� ����� �� �ִ�. 
		if (str !=null && str.length() > 0){
			// if �� ���� ������ �Ǹ� 
			
			// ���� ���� char ������ Ÿ���� c �������� ����Ǿ ' ' �ʱ�ȭ �ȴ�.
			char c = ' ';

			// for  ���� str ���ڿ� ���� ��ŭ(������ �ҹ��� 26�� ��ŭ) �ݺ� ����(���� �� ����)�ȴ�.
			for (int i=0; i < str.length(); i++ ){

				// for �� ù��° ���ο��� 
				// ���� c �� str �� ���� �� ������ �ҹ��� 26���� ���������� ������ �ȴ�.
				// str.charAt(int index) �Լ��� ���ؼ� 
				c = str.charAt(i);

				// �ֿܼ� c ������ ���Ե� ������ �ҹ��ڸ�  ����Ѵ�.
				System.out.print(c + " ");

				// �ֿܼ� ���ڿ� 0x �� ������ �ҹ��ڸ� 16���� ��ȯ ���� ���ؼ� ����Ѵ�.
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S1(String str) {
		System.out.println("Exam_For_6.toHex_S1() �Լ� ���� >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S2(String str) {
		System.out.println("Exam_For_6.toHex_S2() �Լ� ���� >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S3(String str) {
		System.out.println("Exam_For_6.toHex_S3() �Լ� ���� >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public void toHex_S4(String str) {
		System.out.println("Exam_For_6.toHex_S4() �Լ� ���� >>> : ");

		if (str !=null && str.length() > 0){
			char c = ' ';
			for (int i=0; i < str.length(); i++ ){
				c = str.charAt(i);
				System.out.print(c + " ");
				System.out.print("0x" + Integer.toHexString(c) + " ");
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {
		
		// String Ŭ������ ���������� ���� �ʱ�ȭ �ߴ�.
		// �������� s0, s1, s2, s3, s4 �� �����ߴ�.
		// �� ������ ���ڿ��� �ʱ�ȭ �Ѵ�.
		// ���ڿ��� ������ �ҹ���
		// ������ �ҹ��ڸ� String Ŭ������ toUpperCase() �Լ��� �빮�ڷ� �����.
		// ���� 0 ~ 9
		// ������ : ��Ģ������ 
		// Ư�� ���� 8��

		// ������ �ҹ���
		String s0 = "abcdefghijklmnopqrstuvwxyz";
		// ������ �빮�� 
		String s1 = s0.toUpperCase();
		// ���� 
		String s2 = "0123456789";
		// �����ȣ
		String s3 = "*+-/";
		// Ư�� ����
		String s4 = "!@#%%^&*";


		//  ����� ���� Exam_For_6() Ŭ������ �ν��Ͻ� �ؼ� 
		//	toHex_S0() �Լ��� ȣ���Ѵ�.
		//	�μ�(�ƱԸ�Ʈ��) s0 ���������� �Ѱ��ش�. 
		//	s0 ������������ ������ �ҹ��� �ʱ�ȭ �Ǿ��ִ�.
		new Exam_For_6().toHex_S0(s0);

		//  ����� ���� Exam_For_6() Ŭ������ �ν��Ͻ� �ؼ� 
		//	toHex_S1() �Լ��� ȣ���Ѵ�.
		//	�μ�(�ƱԸ�Ʈ��) s1 ���������� �Ѱ��ش�. 
		//	s1 ������������ ������ �빮�ڰ� �ʱ�ȭ �Ǿ��ִ�.
		new Exam_For_6().toHex_S1(s1);

		//  ����� ���� Exam_For_6() Ŭ������ �ν��Ͻ� �ؼ� 
		//	toHex_S2() �Լ��� ȣ���Ѵ�.
		//	�μ�(�ƱԸ�Ʈ��) s2 ���������� �Ѱ��ش�. 
		//	s2 ������������ ���� 0 ~ 9 �ʱ�ȭ �Ǿ��ִ�.
		new Exam_For_6().toHex_S2(s2);

		//  ����� ���� Exam_For_6() Ŭ������ �ν��Ͻ� �ؼ� 
		//	toHex_S3() �Լ��� ȣ���Ѵ�.
		//	�μ�(�ƱԸ�Ʈ��) s3 ���������� �Ѱ��ش�. 
		//	s3 ������������ ��Ģ�����ڰ� �ʱ�ȭ �Ǿ��ִ�.
		new Exam_For_6().toHex_S3(s3);

		//  ����� ���� Exam_For_6() Ŭ������ �ν��Ͻ� �ؼ� 
		//	toHex_S4() �Լ��� ȣ���Ѵ�.
		//	�μ�(�ƱԸ�Ʈ��) s4 ���������� �Ѱ��ش�. 
		//	s4 ������������ Ư�� ���ڰ� �ʱ�ȭ �Ǿ��ִ�.
		new Exam_For_6().toHex_S4(s4);

	}
}
