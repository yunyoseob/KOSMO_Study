package a.b.c.ch4;

public class Exam_ToString extends Object{

	@Override
	public String toString() {
		// getClass().getName() + '@' + Integer.toHexString(hashCode())
		return "java.lang.Object 클래스에서 오버라이딩한 toString() 함수이다.";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exam_ToString et = new Exam_ToString();
		System.out.println("et 참조변수 주소값  >>> : " + et);
		//                     getClass().getName() + '@' + Integer.toHexString(hashCode())
		// et 참조변수 주소값  >>> : a.b.c.ch4.Exam_ToString@15db9742
		System.out.println("et.toString() 참조변수 주소값  >>> : " + et.toString());
		System.out.println("et.getClass().getName()  >>> : " + et.getClass().getName());
		
		// Exam_ToStringVO 호출하기 
		Exam_ToStringVO etvo = new Exam_ToStringVO("박건원", 30);
		System.out.println("etvo >>> : " + etvo);
		System.out.println("etvo.toString() >>> : " + etvo.toString());		
	}
}
