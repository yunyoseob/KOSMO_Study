package a.b.c.ch1;

public class Exam_FlowControl_4 {

	public int add(int x, int y) {		
		return x + y;
	}

	public int subtract(int x, int y) {		
		return x - y;
	}

	public int multiply(int x, int y) {		
		return x * y;
	}

	public int divide(int x, int y) {		
		return x / y;
	}

	public static void main(String args[]) {

		// String args[] = new String[];
		// String args[] = new String[2];
		// C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_4 1 2
		// String args[] = new String[]{"1", "2"};
		// String args[] = {"1", "2"};

		// length() : String Ŭ������ ���ڿ��� ���̸� ���ϴ� �Լ� 
		// length �ʵ� : �迭�� ���̸� ���ϴ� �Լ�
		int argsLength = args.length;
		boolean aBool = argsLength == 2;
		System.out.println("aBool >>> : " + aBool);
		
		// ���� �Լ��� �Ķ������ String args[] �迭�� ����� �μ� ��� �θ���.
		// ����� �μ���, String �迭�� ������ 2�� �� ���� if ���� ����ȴ�.
		// if (args.length == 2){
		if (aBool){

			// String ���ڿ� Ŭ������ �������� s0 �� ����� �μ� ù ��° ���� �Ҵ��Ѵ�.
			String s0 = args[0]; // "1"
			// String ���ڿ� Ŭ������ �������� s1 �� ����� �μ� �� ��° ���� �Ҵ��Ѵ�.
			String s1 = args[1]; // "2"
			
			// public static int parseInt(String s)
			// parseInt(String s) : ���� ���ڸ� ���ڷ� �ٲٴ� �Լ� 
			// ���� ���� : "1" "2",  
			// "��" : ����
			int x = Integer.parseInt(s0);
			int y = Integer.parseInt(s1);

			Exam_FlowControl_4 ef4 = new Exam_FlowControl_4();
			System.out.println("ef4 �������� �ּҰ� >>> : " + ef4);
			
			int add = ef4.add(x, y);
			System.out.println("add >>> : " + add);
			
			int subtract = ef4.subtract(x, y);
			System.out.println("subtract >>> : " + subtract);
			
			int multiply = ef4.multiply(x, y);
			System.out.println("multiply >>> : " + multiply);
			
			int divide = ef4.divide(x, y);
			System.out.println("divide >>> : " + divide);

		}else{
			System.out.println("������ ���� �� �Է��Ͻÿ� >>> : ");
		}
	}
}

/*
C:\00.KOSMO108\10.JExam\ch1>javac -d . Exam_FlowControl_4.java

C:\00.KOSMO108\10.JExam\ch1>java a.b.c.ch1.Exam_FlowControl_4 1 2
ef4 �������� �ּҰ� >>> : a.b.c.ch1.Exam_FlowControl_4@15db9742
add >>> : 3
subtract >>> : -1
multiply >>> : 2
divide >>> : 0
*/