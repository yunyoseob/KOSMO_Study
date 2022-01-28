package a.b.c.d.ch1;

public class HELLOHELLO{
	static byte b;
	// 값을 따로 지정안하면 default 값이 나옴.
	// byte의 default == 0
	static void aM(){
		System.out.println("aM() 함수");
	} // aM() 함수 블록 닫기

	public static void main(String args[]){
		System.out.println("안녕하세요 반가워요 잘있어요 다시 만나요");
		System.out.println("b >>> :"+HELLOHELLO.b);
		// class + dot연산자 + 지정한값
		// HELLOHELLO 앞에 package 안 붙여주는 이유
		// java package.파일이름으로 이미 들어왔기 때문에
		// 클래스와 클래스 내에 있는 값만 입력해주면 됨.
		// 따라서, a.b.c.d.HELLOHELLO.b 이렇게 쓸 필요가 없음.
		System.out.println("b >>> 이것도 되는데 이건 사용하지 말기 :"+b);

		HELLOHELLO.aM();
		// class와 dot연산자와 안에 있는 함수
	} // main() 함수 블록 닫기
} // HELLOHELLO 클래스 블록 닫기