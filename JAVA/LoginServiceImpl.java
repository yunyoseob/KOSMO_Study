package a.b.c.ch4;
//package�� Ŭ������ ��θ� �ǹ��Ѵ�.
//a.b.c.ch4�� Ŭ������ �ִ�.

import java.util.ArrayList;
//java.lang�� �ڹٿ� �⺻������ ������ �Ǿ�������
//java.util�� �ڹٿ� �⺻������ ������ �Ǿ����� �����Ƿ� import Ű����� �ҷ��´�.
//import ��Ű��.Ŭ�����̸�;

import a.b.c.ch3.HelloVO;
// LoginServiceImpl Ŭ������ a.b.c.ch4 ��Ű���� ������,
// HelloVO Ŭ������ a.b.c.ch3 ��Ű���� �ִ�.
// ����, import Ű����� ȣ���Ͽ� �ش�.

public class LoginServiceImpl implements LoginService {
// LoginService �������̽� Ŭ������ ����� ����  LoginServiceImpl Ŭ�����̴�.
// �θ� Ŭ������ �Լ��� �����ΰ� ���� �߻��Լ� ����, @Override ������ Annotation�� ����
// loginTest �Լ��� �����θ� �������־�� �Ѵ�.

	@Override
	public ArrayList<HelloVO> loginTest(HelloVO hvo) {
		//  �Ű��������� ������ HelloVO Ŭ������ �μ� �迭��
		//  �Ű������� hvo�� �ʱ�ȭ ���ش�.
		
		
		// ����Ͻ� ������ ���ļ� �����ͺ��̽��� �ٳ���� ������ ���� �����̴�.
		ArrayList<HelloVO> aList = null;
		// ArrayList<HelloVO> Ŭ������ aList ���������� �ʱ�ȭ���ش�. 
		aList = new ArrayList<HelloVO>();
		// new Ű����� ArrayList<HelloVO> Ŭ���� �����ڸ� ����� 
		// �ν��Ͻ��Ѵ�. �̸�  aList�� �����Ѵ�. 
		
		aList.add(hvo);
		// aList�� �Ű����� hvo�� �߰��Ѵ�.
		
		return aList;
		// aList�� �����Ͽ� �ش�.
		
	}

}
