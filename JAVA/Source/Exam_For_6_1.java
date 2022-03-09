package a.b.c.ch1;

/*
�ϱ�	main() �Լ��� �ʱ�ȭ �� �������� 5���� 16������ �ֿܼ� ����Ͻÿ� 
��:	�Լ��� ���� main() �Լ����� �� �Լ��� ȣ���ؼ� ���� ��Ű�ÿ�
	�ֿܼ� 16������ ����� ���� 0x �� �ٿ��� ����Ͻÿ�
�Լ� �̸� toHex_S0(), toHex_S1(), toHex_S2(), toHex_S3(), toHex_S4()

16:45 ���� �ϱ� 
*/
public class Exam_For_6_1 {

	public void toHex_Str(String str) {
		System.out.println("Exam_For_6.toHex_S0() �Լ� ���� >>> : ");

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

		if (args.length == 1){

			String s = args[0];
			s = s.toUpperCase();

			if ("A".equals(s)){
				new Exam_For_6_1().toHex_Str(s0);
			}
			if ("B".equals(s)){
				new Exam_For_6_1().toHex_Str(s1);
			}
			if ("C".equals(s)){
				new Exam_For_6_1().toHex_Str(s2);
			}
			if ("D".equals(s)){
				new Exam_For_6_1().toHex_Str(s3);
			}
			if ("E".equals(s)){
				new Exam_For_6_1().toHex_Str(s4);
			}
		}else{
			System.out.println(   "A : ������ �ҹ��� \n"
								+ "B : ������ �빮�� \n"
								+ "C : ���� \n"
								+ "D : ���� ��ȣ \n"
								+ "E : Ư�� ���� \n"
								+ "�� �Է��Ͻÿ� ");

		}
	}
}
