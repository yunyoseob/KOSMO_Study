package a.b.c.ch1;

public class ClassTest_practice_3{
	//��� ����
	// ���
	public static final int ID_NUM=1;

	// ����ƽ ����, Ŭ���� ����
	static int id_val=11;
	// public�̶�� �ܺο��� ����� �� �ִ�
	// ���������� Ű���尡 ����.
	
	// ���� ����
	public int iVal_G;

	// static�̶�� �޸𸮿� �Ҵ��ϴ� ������ Ű���尡 �����ִ�.

	// ��� ����
	int iVal;
	// public�̶�� ���������� Ű���嵵 ����,
	// static�̶�� ������ Ű���� ����.

	//����� ���� �Լ�
	public void aMethod(){
		System.out.println("aMethod() ���� �ε�");
	} // end of aMethod method
	// return�� ����. ����, ������ Ű������ void�� ����ߴ�.
	// static�̶�� ������ Ű���尡 ����.

	public static void aaMethod(){
		System.out.println("aaMethod() ���� �ε�");
	} // end of aaMethod method
	// return�� ����. ����, ������ Ű������ void�� ����ߴ�.

	public int bMethod(){
		System.out.println("bMethod() ���ư��� ��~");
		return 1+1;
	} // end of bMethod method
	// return�� �ִ�.
	// �����ؾ� �� ���� bMethod �տ� �ִ� int��
	// return���� ��µǴ� 1+1�� ������ Ÿ����
	// ��� int�� �����ؾ� �Ѵ�.
	// static�̶�� ������ Ű���尡 ����.

	public static int bbMethod(){
		System.out.println("bbMethod() ���ư��� ��~");
		return 10+10;
	} // end of bbMethod method
	// return�� �ִ�.
	// bbMethod�տ� int�� return���� ��µǴ� 10+10��
	// ������ Ÿ���� ��� int�� �����ؾ� �Ѵ�.

	// main �Լ� ����
	public static void main(String args[]){
		// static�� �ִ� ���� ģ����
		// ������� �߿� ��� �ҷ����� (static ����)
		System.out.println("ClassTest_practice_3.ID_NUM >>> "+ClassTest_practice_3.ID_NUM+"\n");
		// ����ƽ ���� �ҷ�����
		System.out.println("ClassTest_practice_3.id_val >>> "+ClassTest_practice_3.id_val+"\n");
		// aaMethod �ҷ�����(return�� ��� println�ȿ� ������ �� ��)
		System.out.println("ClassTest_practice_3.aaMethod�� ������ ��� println�� ������ �� ��. �ҷ����� \n");
		ClassTest_practice_3.aaMethod();
		// bbMethod �ҷ�����
		int x=ClassTest_practice_3.bbMethod();	
		System.out.println("ClassTest_practice_3.bbMethod >>> "+x+"\n");

		// static�� ���� �ٺ����� ���� ��ü �������ֱ� (�ν��Ͻ� ����)
		ClassTest_practice_3 ec=new ClassTest_practice_3();
		System.out.println("ClassTest_practice_3 ec �ּ� >>> "+ec+"\n");
		// ���� ���� �ҷ����� (static ����)
		System.out.println("ClassTest_practice_3 ec.iVal_G >>> "+ec.iVal_G+"\n");
		// ��� ���� �ҷ����� (static ����)
		System.out.println("ClassTest_practice_3 ec.iVal >>> "+ec.iVal+"\n");
		// aMethod �ҷ����� (static ����, return�� ����)
		System.out.println("ClassTest_practice_3 ec.aMethod�� ������ ��� println�� ������ �� ��. �ҷ����� \n");
		ec.aMethod();
		// bMethod �ҷ����� (static ����, �ٵ� return�� ����)
		int y=ec.bMethod();
		// bMethod ���ϰ��� int���̹Ƿ� �����ϰ� x�� int��� �����͸� ��� ������� ���ڿ� �Ҵ��Ͽ� �ش�.
		System.out.println("ClassTest_practice_3 ec.bMethod�� ������ ��� println�� ������ �� ��. �ҷ����� \n");
		System.out.println("ClassTest_practice_3 ec.bMethod >>> "+y+"\n");
	}
	
} // end of ClassTest_practice_3 class 
