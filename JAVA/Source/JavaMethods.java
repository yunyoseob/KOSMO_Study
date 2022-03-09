package a.b.c;

public class JavaMethods{
	public void integer_methods(String s){
		System.out.println("\n java.lang.Integer�� �ִ� method >>> \n");
		
		boolean iBool="INTEGER".equals(s);
		System.out.println("\n Integer method�� �˸°� �������� true, �ƴϸ� false >>> : "+iBool);

		if (iBool){
			System.out.println("\n String : Integer.toHexString (16����)");
			System.out.println("public static String toHexString(int i) \n");
			System.out.println("\n String : Integer.toBinaryString (2����)");
			System.out.println("public static String toBinaryString(int i) \n");
			System.out.println("\n String : Integer.toOctalString (8����)");
			System.out.println("public static String toOctalString(int i) \n");
			System.out.println("\n String : Integer.toString()");
			System.out.println("public String toString() \n");
		}
		else{
			System.out.println("\n �߸��� �޼���� ���Խ��ϴ�. \n");
		}
	} // end of integer_methods

	public void string_methods(String s){
		System.out.println("\n <<< java.lang.String�� �ִ� method >>> \n");
		boolean sBool="STRING".equals(s);
		System.out.println("\n String method�� �˸°� �������� true, �ƴϸ� false >>> : "+sBool);
	
		if (sBool){
			System.out.println("String : String.valueOf()");
			System.out.println("public static String valueOf(boolean b)");
			System.out.println("public static String valueOf(char c)");
			System.out.println("public static String valueOf(int i)");
			System.out.println("public static String valueOf(long l)");
			System.out.println("public static String valueOf(float f)");
			System.out.println("public static String valueOf(double d)");
			System.out.println("\n char : String.charAt() \n");
			System.out.println("public char charAt(int index)");
			System.out.println("\n boolean : String.equals()");
			System.out.println("public boolean equals(Object anObject) \n");
		}
		else{
			System.out.println("\n �߸��� �޼���� ���Խ��ϴ�. \n");
		}
	} // end of string_methods
	public static void main(String args[]){
		// ù ��° ��� : �迭�� �Է¹޾�
		// ������ java.lang������ �Լ� ã�� ����
		System.out.println("��ɾ� ���� \n");
		System.out.println(" String \n");
		System.out.println(" Integer \n");
		System.out.println(" Boolean \n");

		String str1=args[0];
		String str=str1.toUpperCase();
		// �빮�ڷ� ��ȯ

		int argsLength=args.length;
		boolean aBool=argsLength==1;
		System.out.println("���� �迭�� ���̰� 1�̸� true, �ƴϸ� false >>> : "+aBool);

		if (aBool){
			System.out.println("\n �Է��� ��ɾ� >>> : "+args[0]);
			if("STRING".equals(str)){
				new JavaMethods().string_methods(str);
			}
			if("INTEGER".equals(str)){
				new JavaMethods().integer_methods(str);		
			}
		}
		else{
			System.out.println("\n �ٽ� �Է��� �ֽʽÿ�. \n");	
		}	
	} // end of main method
} // end of JavaKeywords class