package a.b.c.ch1;

public class Var_practice_3{
	public void stringTest(){
	
	String str="abc";
	System.out.println("str >>> : "+str);

	char ch0=str.charAt(0);
	char ch1=str.charAt(1);
	char ch2=str.charAt(2);

	System.out.println("ch0 >>> : "+ch0);
	System.out.println("ch1 >>> : "+ch1);
	System.out.println("ch2 >>> : "+ch2);
	} // end of stringTest method

	public static void main(String args[]){
		new Var_practice_3().stringTest();
	} // end of main method

} // end of Var_practice class