package a.b.c.ch1;

public class Str_practice{
	public void str_prac(){
		String velog="velog is good"+null;
		System.out.println("velog.length() >>> "+velog.length());
		// java se 8 api : public int length()
		// 13 
		// velog is good은 11글자인데, length()로 볼 때, 13글자이다.
		// 띄어쓰기도 글자로 포함한다는 의미로 해석할 수 있다.

		// 추가적으로 null을 붙여주니까
		// 17글자로 직혀서 나온다. null도 글자로 취급하는 것이다.
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
		// null도 글자로 취급하여 n을 출력한다.
	} // end of str_prac method

	public static void main(String args[]){
		// str_prac() method가 static 수정자 키워드가 없으므로, new 키워드를 사용
		new Str_practice().str_prac();
		// Str_practice() : 생성자 
	} // end of main method
} // end of Str_practice class