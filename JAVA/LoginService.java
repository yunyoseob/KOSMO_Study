package a.b.c.ch4;
// package�� Ŭ������ ��θ� �ǹ��Ѵ�.
// a.b.c.ch4�� Ŭ������ �ִ�.

import java.util.ArrayList;

import a.b.c.ch3.HelloVO;
// java.lang�� �ڹٿ� �⺻������ ������ �Ǿ�������
// java.util�� �ڹٿ� �⺻������ ������ �Ǿ����� �����Ƿ� import Ű����� �ҷ��´�.
// import ��Ű��.Ŭ�����̸�;

public interface LoginService {
	// interface Ŭ���� 
	// interface Ŭ������ ���ο� �߻��Լ��θ� �̷���� �ִ�. (�����ΰ� ���� �Լ� )
	// �����ڸ� ������ �� ����, new Ű����� �����ڸ� ������ �� ����.
	// implements�� ��ӹ޴� �ڽ� Ŭ������ �� ��Ʈ�̴�.

	public ArrayList<HelloVO> loginTest(HelloVO hvo);
	// public ����������
	// ArrayList<HelloVO> ������Ű����
	// ArrayList �����ʹ� HelloVO �� ����϶�� ���ʷ��̼��� �����ߴ�.
	// hvo�� ArrayList<HelloVO>�� ������ Ÿ���� ���ƾ� �Ѵ�.
}
