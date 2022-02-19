package a.b.c.ch4;
// a.b.c.ch4�� Ŭ������ ��� 

import java.util.ArrayList;
// java.lang ��Ű���� �ƴϹǷ� import Ű����
// import�� ��Ű���� �ٸ� ���, ����Ѵ�. (import ��Ű��.Ŭ�����̸�;)
// ArrayList �迭Ŭ������ �ҷ��´�. (������ Ÿ�԰� ���þ��� ��� Ÿ���� �����͵� ������� �� ����).
import java.util.Scanner;
// java.lang ��Ű���� �ƴϹǷ� import Ű����
// Scanner Ŭ������ �ҷ��´�. 
// A Scanner breaks its input into tokens using 
// a delimiter pattern, 
// which by default matches whitespace.

import a.b.c.ch3.HelloVO;
// a.b.c.ch3 ��Ű���� �ִ� HelloVO ũ������ ȣ���Ѵ�.
// ���� ��Ű���� a.b.c.ch4�̹Ƿ�, ��Ű���� �ٸ��� ������ ȣ���ؾ��Ѵ�.

public class LoginTest {
	// LoginTest�� Ŭ���� �̸�
	
	public int loginTest(HelloVO hvo) {
		// loginTest�� LoginTest Ŭ���� �ȿ� �ִ� �Լ� �̸�
		// ������ Ű���尡 int��  �μ��� int, �Ű������� int,
		// ���ϰ��� int���� �Ѵ�.
		// �����ΰ�  �ִ� �Լ��̴�.
		
		int nCnt = 0;
		// int ������ Ÿ��(�����ڷ��� 4byte)�� nCt��� ������ 0���� �ʱ�ȭ�Ѵ�.
		
		LoginService ls = new LoginServiceImpl();		
		// LoginSerivce �������̽� Ŭ����(LoginServiceImplŬ������ �θ� Ŭ����)
		// �� �������� ls�� �����Ѵ�.
		// �����ڴ� LoginServiceImplŬ������ �⺻�����ڷ� new Ű���带 ���� �ν��Ͻ��Ѵ�.
		// JVM�� new Ű���带 ���� �����ڸ� �����Ѵ�.
		// �����ڴ� ��������� �ʱ�ȭ �Ѵ�.
		
		ArrayList<HelloVO> aList = ls.loginTest(hvo);
		// ArrayList<HelloVO> �迭Ŭ������ aList ����������
		// ls ���������� loginTest �Լ��� hvo�μ��� �ִ´�.
		
		if (aList !=null && aList.size() > 0) {
		// ���� aList�� null�� �ƴϸ鼭 ���ÿ�
		// aList�� size (�迭�� ����)�� 0���� Ŭ���� �����ϵ��� �Ѵ�.
			
			for (int i=0; i < aList.size(); i++) {
				// int i�� for�� �ȿ��� �������ְ�, 0���� �ʱ�ȭ �Ѵ�.
				// �� �� , i�� List �迭�� ���̺��� ������
				// i�� �ϳ��� �����ϰ�, �׷��� ������  �ݺ����� �ߴ��Ѵ�.
				// ��<aList.size()�� ������ �迭�� �ε����� 0���� �����Ѵ�.
				// ����, i<=aList.size()�� �ƴ� i<aList.size()�� ���ǽ��� �����Ѵ�.
				
				HelloVO _hvo = aList.get(i);
				// for�� ������ ������ aList�� i��° ���Ҹ� HelloVO Ŭ������ _hvo ���������� ��������.
				
				if (   "KID".equals(_hvo.getMid().toUpperCase()) 
					&& "KPW".equals(_hvo.getMpw().toUpperCase())) {
					// ����, "KID"�� _hvo ���������� getMid()�� ��� �빮�ڷ� ��ȯ�Ѱ� ���ٸ�
					// �׸��� ���ÿ� "KPW"�� _hvo.getMpw()�� ��� �빮�ڷ� ��ȯ�Ѱ� ���ٸ�
					// �������� �����ϵ��� �Ѵ�.
					// �� ��, _hvo.getMid�� HelloVO Ŭ������  this.mid�̰�,
					// _hvo.getMpw�� HelloVO Ŭ������ this.mpw �̴�.
					
					nCnt++;
					// �ش� ���ǹ��� True�� ���, nCnt ������ �ϳ� �����Ѵ�.
				}
			}			
		}
		
		return nCnt;
		// public int loginTest(HelloVO hvo)�� ���ϰ�����
		// nCnt�� ��ȯ�ȴ�.
		// ����  aList !=null && aList.size() > 0 �� True�̰�
		// "KID".equals(_hvo.getMid().toUpperCase()) 
		// && "KPW".equals(_hvo.getMpw().toUpperCase()))�� Ture�̸�
		// nCnt�� 0���� ���ϵǾ� �������ʴ´�. �׷��� ���� ���ǹ� �Ұ�ȣ ���� ������ �ϳ��� False���
		// nCnt�� 0���� ���ϵǾ� ���´�.
	}
	
	
	public static void main(String[] args) {
		
		String mid = "";
		// mid ���ڿ��� ������ �ʱ�ȭ �Ѵ�.
		String mpw = "";
		// mpw ���ڿ��� ������ �ʱ�ȭ �Ѵ�.
		
		System.out.println("�����͸� �Է��Ͻÿ� >>> : ");
		// "�����͸� �Է��Ͻÿ� >>> : "�� ��½��� �����ش�.
		Scanner sc = new Scanner(System.in);
		// �Էµ� ���� Scanner Ŭ������ �Է� ��, new Ű���带 ����
		// JVM�� �����ڸ� �ν��Ͻ��ϰ� �����.
		// �� ��, Scanner Ŭ������ sc ���������� �ش� ������ �����Ѵ�.
		
		System.out.println("���̵� >>> : ");
		// "���̵�  >>> : "�� ��½�Ų��.
		mid = sc.next();
		// sc ���������� �Էµ� ���� String mid������ �����Ѵ�. 
		// String : next()
		// Finds and returns the next complete token from this scanner.
		// public String next()
		
		System.out.println("�н����� >>> : ");
		// "�н����� >>> : "�� ��½�Ų��.
		mpw = sc.next();
		// sc ���������� �Էµ� ���� ���� String mpw ������ �����Ѵ�.
		
		
		HelloVO hvo = new HelloVO();
		// HelloVO Ŭ������ �⺻ �����ڸ� �ν��Ͻ� �Ѵ���, HelloVO Ŭ������ hvo ���������� �����Ѵ�.
		// JVM�� newŰ���带 ���� �ν��Ͻ��Ѵ�.
		hvo.setMid(mid);
		// �������� hvo�� �Ű������� ���� �����ڱ� ������, 
		// �ش� Ŭ������ setMid �޼��忡 mid�� �μ��� �־��־�
		// HelloVO Ŭ������ this.mid�� �μ����� �����Ѵ�.
		hvo.setMpw(mpw);
		// �������� hvo�� �Ű������� ���� �����ڱ� ������,
		// �ش� Ŭ������ setMpw �޼��忡 mpw�� �μ��� �־��־�
		// HelloVO Ŭ������ this.mpw�� �μ����� �����Ѵ�.
			
		LoginTest lt = new LoginTest();
		// ����, LoginTest�� �⺻ �����ڸ� new Ű����� �ν��Ͻ� �Ѵ�.
		// JVM�� new Ű���带 ���� �����ڸ� �ν��Ͻ��Ѵ�.
		// LoginTest Ŭ������ lt ���������� ������ �⺻�����ڸ� �����Ѵ�.
		
		// public int loginTest(HelloVO hvo)
		int nCnt = lt.loginTest(hvo);
		// ���� Ŭ�������� ������ lt ���������� loginTest �޼��忡
		// HelloVO Ŭ�������� ������ �⺻ �����ڰ� ���Ե� ���������� 
		// �μ��� ������ ��, int nCnt�� �̸� �����Ѵ�.
		System.out.println("nCnt >>> : " + nCnt);
		// nCnt�� ��½��� �α׸� ��� Ȯ���Ѵ�.
		
		if (nCnt == 1) {
			// nCnt�� 1�� ���, if ���ǹ��� �����ϵ��� �Ѵ�.
			System.out.println("�α��� ���� >>> : ");
			// nCnt�� 1�� ���, �α��� ������ ��½�Ų��.
		}else {
			System.out.println("�α��� ���� >>> : ");
			// nCnt�� 1�� �ƴ� ���, �α��� ���и� ��½�Ų��.
		}
			
	}
}
