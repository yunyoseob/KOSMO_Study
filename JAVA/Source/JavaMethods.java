package a.b.c;

public class JavaMethods{
	public void integer_methods(String s){
		System.out.println("\n java.lang.Integer에 있는 method >>> \n");
		
		boolean iBool="INTEGER".equals(s);
		System.out.println("\n Integer method로 알맞게 들어왔으면 true, 아니면 false >>> : "+iBool);

		if (iBool){
			System.out.println("\n String : Integer.toHexString (16진수)");
			System.out.println("public static String toHexString(int i) \n");
			System.out.println("\n String : Integer.toBinaryString (2진수)");
			System.out.println("public static String toBinaryString(int i) \n");
			System.out.println("\n String : Integer.toOctalString (8진수)");
			System.out.println("public static String toOctalString(int i) \n");
			System.out.println("\n String : Integer.toString()");
			System.out.println("public String toString() \n");
		}
		else{
			System.out.println("\n 잘못된 메서드로 들어왔습니다. \n");
		}
	} // end of integer_methods

	public void string_methods(String s){
		System.out.println("\n <<< java.lang.String에 있는 method >>> \n");
		boolean sBool="STRING".equals(s);
		System.out.println("\n String method로 알맞게 들어왔으면 true, 아니면 false >>> : "+sBool);
	
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
			System.out.println("\n 잘못된 메서드로 들어왔습니다. \n");
		}
	} // end of string_methods
	public static void main(String args[]){
		// 첫 번째 방법 : 배열을 입력받아
		// 오로지 java.lang만으로 함수 찾아 들어가기
		System.out.println("명령어 모음 \n");
		System.out.println(" String \n");
		System.out.println(" Integer \n");
		System.out.println(" Boolean \n");

		String str1=args[0];
		String str=str1.toUpperCase();
		// 대문자로 변환

		int argsLength=args.length;
		boolean aBool=argsLength==1;
		System.out.println("들어온 배열의 길이가 1이면 true, 아니면 false >>> : "+aBool);

		if (aBool){
			System.out.println("\n 입력한 명령어 >>> : "+args[0]);
			if("STRING".equals(str)){
				new JavaMethods().string_methods(str);
			}
			if("INTEGER".equals(str)){
				new JavaMethods().integer_methods(str);		
			}
		}
		else{
			System.out.println("\n 다시 입력해 주십시오. \n");	
		}	
	} // end of main method
} // end of JavaKeywords class