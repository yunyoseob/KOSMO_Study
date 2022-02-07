package a.b.c.ch1;


public class Var_practice{
	void charMethod(){
		System.out.println("Character char 2byte(양의 정수 16bit, 문자를 다루기 때문에 음수를 가질 수 없다. \n");
		// BYTES, MAX_VALUE, MIN_VALUE, SIZE 콘솔에 출력하기
		int bytes=Character.BYTES;
		char max=Character.MAX_VALUE;
		char min=Character.MIN_VALUE;
		int size=Character.SIZE;
	
		System.out.println("Character.BYTES (int)>>> "+bytes+"\n");
		System.out.println("Character.MAX_VALUE (char)>>> "+max+"\n");
		System.out.println("Character.MIN_VALUE (char)>>> "+min+"\n");
		System.out.println("Character.SIZE >>> (int)"+size+"\n");
	} // end of void method

	public static void main(String args[]){
		
		// 1st 방법
		Var_practice ec=new Var_practice();
		ec.charMethod();

		int intbytes=ec.intMethod(bytes);
		char charMethod=ec.charMethod();

		System.out.println("ec.intMethod() >>> :"+);
		System.out.println("ec.charMethod() >>> :"+charbytes);

		// 2nd 방법
		//new Var_practice().charMethod();

	} // end of main method

}// end of Var_practice class