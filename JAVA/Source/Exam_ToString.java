package a.b.c.ch4;

public class Exam_ToString extends Object{

	@Override
	public String toString() {
		// getClass().getName() + '@' + Integer.toHexString(hashCode())
		return "java.lang.Object Ŭ�������� �������̵��� toString() �Լ��̴�.";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exam_ToString et = new Exam_ToString();
		System.out.println("et �������� �ּҰ�  >>> : " + et);
		//                     getClass().getName() + '@' + Integer.toHexString(hashCode())
		// et �������� �ּҰ�  >>> : a.b.c.ch4.Exam_ToString@15db9742
		System.out.println("et.toString() �������� �ּҰ�  >>> : " + et.toString());
		System.out.println("et.getClass().getName()  >>> : " + et.getClass().getName());
		
		// Exam_ToStringVO ȣ���ϱ� 
		Exam_ToStringVO etvo = new Exam_ToStringVO("�ڰǿ�", 30);
		System.out.println("etvo >>> : " + etvo);
		System.out.println("etvo.toString() >>> : " + etvo.toString());		
	}
}
