package a.b.c.ch1;

public class ClassTest_practice_4{
	public static int aMethod(){
		System.out.println("���� aMethod �Լ� �Դϴ�. ���� ���� �������� �۾��ҰŴϱ� �ǵ��� ������. \n");
		// aMethod ����
		System.out.println("1 ���ϱ� 2�� �غ����� �ϰڽ��ϴ�. \n");
		int x=1;
		// ���� x�� int��� ���ڿ� �ְ� ���Կ����ڸ� ���� 1�� �����մϴ�.
		int y=2;
		// ���� y�� int��� ���ڿ� �ְ� ���Կ����ڸ� ���� 2�� �����մϴ�.
		int xy=x+y;
		// ���� xy�� int��� ���ڿ� �ְ� ������ ����� ���� x�� y�� ��Ĩ�ϴ�.
		System.out.println(x+" ���ϱ� "+y+" �� "+xy+" �Դϴ�. aMethod �� �� ��!! \n");
		return xy;
		// ���� ���� return �մϴ�.
	} // end of aMethod method
	public int bMethod(){
		System.out.println("���� bMethod �Լ� �Դϴ�. aMethod ȣ��!! \n");
		//int z=ClassTest_practice_4.aMethod();
		// aMethod �� ���� static�� ��� ���� ���� ����
		// aMethod�� static �߰����ְ� �ٽ� �������ֱ�

		int z=ClassTest_practice_4.aMethod();
		System.out.println("���� �ܻ����� aMethod���� �Ͻ�Ű�� ����� ������ �Ծ��. \n");
		return z;
	} // end of bMethod method
	public static void main(String args[]){
		System.out.println("���� main �Լ��Դϴ�. �������� ����� ���� �Լ��� �޾� ����غ��Կ�. \n");
		System.out.println("����� ���� �Լ� bMethod�� static�� ���Ծ��׿�. �� �� ���� ��ü�� �������� �ϰڽ��ϴ�. \n");
		ClassTest_practice_4 ec= new ClassTest_practice_4();
		// new Ű����� ��ü �������ֱ�
		System.out.println("��ü �ּ� : >>>"+ec);
		System.out.println("aMethod�� ���� ����غ����� �ϰڽ��ϴ�. \n");
		int a=ClassTest_practice_4.aMethod();
		System.out.println("main �Լ� : aMethod�� ����ߴ�. \n");
		int b=ec.bMethod();
		System.out.println("main �Լ� : bMehtod�� ����ߴ�. \n");
		System.out.println("\n main �Լ� �� �� ��!!");
	}// end of main method

} // end of ClassTest_practice_4 class