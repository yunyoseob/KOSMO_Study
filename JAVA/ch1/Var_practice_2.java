package a.b.c.ch1;

public class Var_practice_2{
	void charMethod(){
		System.out.println("기초자료형 char 의 Wrapper 클래스 Character");
        System.out.println("char 2byte(양의정수 16bit, 문자를 다루기 때문에 음수를 가질 수 없다.)");

        // BYTES, MAX_VALUE, MIN_VALEU, SIZE 콘솔에 출력하기
        // public static final int      BYTES
        // int charBytes = java.lang.Character.BYTES;
        int charBytes = Character.BYTES;
        // public static final char MAX_VALUE
        // char charMaxValue = java.lang.Character.MAX_VALUE;
        char charMaxValue = Character.MAX_VALUE;
        // public static final char MIN_VALUE   l
        // char charMinValue = java.lang.Character.MIN_VALUE;
        char charMinValue = Character.MIN_VALUE;
        // public static final int      SIZE
        // int charSize = java.lang.Character.SIZE;
        int charSize = Character.SIZE;

        System.out.println("charBytes >>> : " + charBytes);
		// 2
        System.out.println("charMaxValue >>> : " + charMaxValue);
		// ?으로 출력됨. 이유는 '(\)uFFF'으로 나와야 하는데
		// MS DOS(콘솔창)이 '(\)uFFF'를 읽지를 못해서 ?으로 출력됨.
        System.out.println("charMinValue >>> : " + charMinValue);
		// 아무 것도 출력되지 않음. 이유는 '\u0000'으로 나와야 하는데
		// MS DOS(콘솔창)이 '\u0000'를 읽지를 못해서 아무것도 출력되지 않음.
        System.out.println("charSize >>> : " + charSize);
		// 16이 나오는데, char는 16비트(2바이트)이기 때문

        int charMaxValue_1 = Character.MAX_VALUE;
        int charMinValue_1 = Character.MIN_VALUE;
        System.out.println("charMaxValue_1 >>> : " + charMaxValue_1);
		// int형으로 선언해주면 65535로 출력됨.
        System.out.println("charMinValue_1 >>> : " + charMinValue_1);
		// int형으로 선언해주면 0이 출력됨.

		char charMin = '\u0000'; // 유니코드
        char charMax = '\uFFFF'; // 유니코드
        System.out.println("charMin >>> : " + charMin);
		// 유니코드로 출력하면 마찬가지로 아무것도 출력되지 않음.
        System.out.println("charMax >>> : " + charMax);
		// 유니코드로 출력하면 마찬가지로 ?으로 출력됨.
        char charinitialization  = ' '; // char 데이터 타입은 빈 문자열, 싱글 쿼테이션으로 초기화 한다.
        System.out.println("charinitialization >>> : " + charinitialization);
		// ' '의 의미는 비우라는 뜻이다.
	}

		public static void main(String args[]){
			new Var_practice_2().charMethod();
		}
} // end of Var_practice_2

/*
cmd(ms dos)와 window powershell 모두 같은 결과가 나옴.

기초자료형 char 의 Wrapper 클래스 Character
char 2byte(양의정수 16bit, 문자를 다루기 때문에 음수를 가질 수 없다.)
charBytes >>> : 2
charMaxValue >>> : ?
charMinValue >>> :
charSize >>> : 16
charMaxValue_1 >>> : 65535
charMinValue_1 >>> : 0
charMin >>> :
charMax >>> : ?
charinitialization >>> :
*/