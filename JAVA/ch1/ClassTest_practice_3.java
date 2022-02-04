package a.b.c.ch1;

public class ClassTest_practice_3{
	//멤버 변수
	// 상수
	public static final int ID_NUM=1;

	// 스태틱 변수, 클래스 변수
	static int id_val=11;
	// public이라는 외부에서 사용할 수 있는
	// 접근제한자 키워드가 없다.
	
	// 전역 변수
	public int iVal_G;

	// static이라는 메모리에 할당하는 수정자 키워드가 빠져있다.

	// 멤버 변수
	int iVal;
	// public이라는 접근제한자 키워드도 없고,
	// static이라는 수정자 키워드 없다.

	//사용자 정의 함수
	public void aMethod(){
		System.out.println("aMethod() 등장 두둥");
	} // end of aMethod method
	// return이 없다. 따라서, 리턴형 키워드인 void를 사용했다.
	// static이라는 수정자 키워드가 없다.

	public static void aaMethod(){
		System.out.println("aaMethod() 등장 두둥");
	} // end of aaMethod method
	// return이 없다. 따라서, 리턴형 키워드인 void를 사용했다.

	public int bMethod(){
		System.out.println("bMethod() 돌아가는 중~");
		return 1+1;
	} // end of bMethod method
	// return이 있다.
	// 유의해야 할 점은 bMethod 앞에 있는 int와
	// return으로 출력되는 1+1의 데이터 타입이
	// 모두 int로 동일해야 한다.
	// static이라는 수정자 키워드가 없다.

	public static int bbMethod(){
		System.out.println("bbMethod() 돌아가는 중~");
		return 10+10;
	} // end of bbMethod method
	// return이 있다.
	// bbMethod앞에 int와 return으로 출력되는 10+10의
	// 데이터 타입이 모두 int로 동일해야 한다.

	// main 함수 등장
	public static void main(String args[]){
		// static이 있는 착한 친구들
		// 멤버변수 중에 상수 불러오기 (static 있음)
		System.out.println("ClassTest_practice_3.ID_NUM >>> "+ClassTest_practice_3.ID_NUM+"\n");
		// 스태틱 변수 불러오기
		System.out.println("ClassTest_practice_3.id_val >>> "+ClassTest_practice_3.id_val+"\n");
		// aaMethod 불러오기(return이 없어서 println안에 가져다 못 씀)
		System.out.println("ClassTest_practice_3.aaMethod는 리턴이 없어서 println에 가져다 못 씀. 불러오기 \n");
		ClassTest_practice_3.aaMethod();
		// bbMethod 불러오기
		int x=ClassTest_practice_3.bbMethod();	
		System.out.println("ClassTest_practice_3.bbMethod >>> "+x+"\n");

		// static이 없는 바보들을 위해 객체 생성해주기 (인스턴스 생성)
		ClassTest_practice_3 ec=new ClassTest_practice_3();
		System.out.println("ClassTest_practice_3 ec 주소 >>> "+ec+"\n");
		// 전역 변수 불러오기 (static 없음)
		System.out.println("ClassTest_practice_3 ec.iVal_G >>> "+ec.iVal_G+"\n");
		// 멤버 변수 불러오기 (static 없음)
		System.out.println("ClassTest_practice_3 ec.iVal >>> "+ec.iVal+"\n");
		// aMethod 불러오기 (static 없음, return도 없음)
		System.out.println("ClassTest_practice_3 ec.aMethod는 리턴이 없어서 println에 가져다 못 씀. 불러오기 \n");
		ec.aMethod();
		// bMethod 불러오기 (static 없음, 근데 return은 있음)
		int y=ec.bMethod();
		// bMethod 리턴값이 int형이므로 동일하게 x도 int라는 데이터를 담는 변수라는 상자에 할당하여 준다.
		System.out.println("ClassTest_practice_3 ec.bMethod는 리턴이 없어서 println에 가져다 못 씀. 불러오기 \n");
		System.out.println("ClassTest_practice_3 ec.bMethod >>> "+y+"\n");
	}
	
} // end of ClassTest_practice_3 class 
