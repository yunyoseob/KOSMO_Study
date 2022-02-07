package a.b.c.ch1;

public class Array_practice{
	/*
	String�� char�� �������� �迭
	�迭�̶� �����͸� ������(index)���� �����ϴ� ��ü
	�迭 ������ [] ���ȣ
	�迭 ���� : 1���� �迭, 2���� �迭, ... ���� �迭
	1���� �迭 3���� ��¹��
	�������� ��������[] �迭������ = new �������� [�迭�� �� ����] �迭������;
	�������� ��������[] = new ��������[]{};
	�������� ��������[]={};
	*/

	public void array_test(){
		// 1��° ���
		char cArray[]={'v','e','l','o','g'};
		// char ������ Ÿ�� �迭 �����
		// [] ������ �ƴ϶� {} �������� �� ����
		// cArray[n]�� ȣ���ϸ� n �ε����� �ش��ϴ� value�� ��µȴ�.
		System.out.println("cArray[0] : >>> "+cArray[0]+"\n");
		System.out.println("cArray[1] : >>> "+cArray[1]+"\n");
		System.out.println("cArray[2] : >>> "+cArray[2]+"\n");
		System.out.println("cArray[3] : >>> "+cArray[3]+"\n");
		System.out.println("cArray[4] : >>> "+cArray[4]+"\n");
		// �迭���� �ε����� ���� []�� ����Ѵ�.
		
		// 2��° ���
		String velog=new String(cArray);
		// cArray �迭�� String ��ü�� ���� []�� �ƴ� ()���� ����.
		System.out.println("velog.charAt(0) : >>> "+velog.charAt(0)+"\n");
		System.out.println("velog.charAt(1) : >>> "+velog.charAt(1)+"\n");
		System.out.println("velog.charAt(2) : >>> "+velog.charAt(2)+"\n");
		System.out.println("velog.charAt(3) : >>> "+velog.charAt(3)+"\n");
		System.out.println("velog.charAt(4) : >>> "+velog.charAt(4)+"\n");
		// velog�� String ���� �̹Ƿ�, charAt(int)�� ����
		// ����Ѵ�. 
		// String���� �ε��� �� ���� ()�� ����Ѵ�.
		
		// 3��° ���
		String velog_2=new String("velog");
		// String�ȿ� �迭�� ����ִ°� �ƴ϶� velog��� ���� ��ü�� ���� �ִ´�.
		System.out.println("velog_2.charAt(0) : >>> "+velog_2.charAt(0)+"\n");
		System.out.println("velog_2.charAt(1) : >>> "+velog_2.charAt(1)+"\n");
		System.out.println("velog_2.charAt(2) : >>> "+velog_2.charAt(2)+"\n");
		System.out.println("velog_2.charAt(3) : >>> "+velog_2.charAt(3)+"\n");
		System.out.println("velog_2.charAt(4) : >>> "+velog_2.charAt(4)+"\n");
		
		// 4��° ���
		String velog_3="velog";
		// new String�� �ƴ� ���� ��ü�� String ������ �Ҵ��ϴ� ���
		System.out.println("velog_3.charAt(0) : >>> "+velog_3.charAt(0)+"\n");
		System.out.println("velog_3.charAt(1) : >>> "+velog_3.charAt(1)+"\n");
		System.out.println("velog_3.charAt(2) : >>> "+velog_3.charAt(2)+"\n");
		System.out.println("velog_3.charAt(3) : >>> "+velog_3.charAt(3)+"\n");
		System.out.println("velog_3.charAt(4) : >>> "+velog_3.charAt(4)+"\n");
	} // end of array_test method
	public static void main(String args[]){
		// �Լ��� static ������ Ű���尡 �����Ƿ� ��ü�� �����Ͽ� ���
		new Array_practice().array_test();
		
	} // end of main method
} // end of Array_practice class