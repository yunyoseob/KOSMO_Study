package a.b.c.ch4;

/*
�Լ� �ȿ� �ִ� ���� : ��������
Ŭ���� �ȿ� �ִ� ���� : �������

���� : �����͸� ��� ���� 

�����ڷ����� ������ ���ͷ�(��)�� �����. 
�����ڷ����� ������ �ּҰ��� ��´�.
	�����ڷ������� ���� ����Ű���� �ּҰ��� ����ؼ� �����Ѿ� �Ѵ�.
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Variable_Case {

	public void varialbeCaseTest( int i
		                         ,String s
								 ,int iv[]
		                         ,ArrayList aList
		                         ,Date d
		                         ,Calendar c
								 ,VariableVO vo){

		System.out.println("varialbeCaseTest() ::: i >>> : " + i);
		System.out.println("varialbeCaseTest() ::: s >>> : " + s);
		System.out.println("varialbeCaseTest() ::: iv >>> : " + iv);
		System.out.println("varialbeCaseTest() ::: aList >>> : " + aList);
		System.out.println("varialbeCaseTest() ::: d >>> : " + d);
		System.out.println("varialbeCaseTest() ::: c >>> : " + c);
		System.out.println("varialbeCaseTest() ::: vo >>> : " + vo);		
	}

	public ArrayList varialbeCaseTest_1(ArrayList aList){

		if (aList !=null && aList.size() > 0){

			for (int i=0; i < aList.size(); i++) {
				System.out.println("varialbeCaseTest_1() ::: aList.get(" + i + ") >>> : " 
									+ aList.get(i));
			}
		}
	
		return aList;
	}


	public static void main(String args[]) {
		/*
		1. ��������
		2. �����ڷ���
		3. ���ͷ�(��) : ����, �Ǽ�, ��
		*/
		int i = 0;

		/*
		1. ��������
		2. �����ڷ���
		3. �ּҰ� : ��ü�� ����Ű�� ��ġ �� : ��Ű����.Ŭ�����̸�@16������
		4. �����ڷ����� ��(���ͷ�)�� ���� ����Ű�� �ʰ� 
		   �ּҰ��� ���ؼ� �����Ѿ� �Ѵ�. 
		*/
		String s = "abc";
		int iv[] = new int[]{1, 2, 3};
		ArrayList aList = new ArrayList();
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		VariableVO vo = new VariableVO();

		System.out.println("main() ::: i >>> : " + i);
		System.out.println("main() ::: s >>> : " + s);
		System.out.println("main() ::: iv >>> : " + iv);
		System.out.println("main() ::: aList >>> : " + aList);
		System.out.println("main() ::: d >>> : " + d);
		System.out.println("main() ::: c >>> : " + c);
		System.out.println("main() ::: vo >>> : " + vo);

		Variable_Case vc = new Variable_Case();
		
		vc.varialbeCaseTest(i, s, iv, aList, d, c, vo); 

		ArrayList aList_1 = new ArrayList();
		aList_1.add(i);
		aList_1.add(s);
		aList_1.add(iv);
		aList_1.add(aList);
		aList_1.add(d);
		aList_1.add(c);
		aList_1.add(vo);
		
		ArrayList aList_2 = vc.varialbeCaseTest_1(aList_1);

		if (aList_2 !=null && aList_2.size() > 0){

			for (int n=0; n < aList_2.size(); n++) {
				System.out.println("main() ::: aList_2.get(" + n + ") >>> : " 
									+ aList_2.get(n));
			}
		}
	}
}

class VariableVO{

	String s;
	int i;
}