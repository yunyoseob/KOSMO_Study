package a.b.c.t6.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.ChabunUtil;
import a.b.c.common.DateUtil;
import a.b.c.t6.servie.T6Service;
import a.b.c.t6.servie.T6ServiceImpl;
import a.b.c.t6.vo.T6VO;

public class T6Scr {

	// ��ü ��ȸ
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("T6Scr.t6SelectAll >>> :");
		
		T6Service ts = new T6ServiceImpl();
		return ts.t6SelectAll();
	}
	
	// �̸� ��ȸ
	public ArrayList<T6VO> t6SelectName(String t2){
		System.out.println("T6Scr.t6SelectName >>> :");
		
		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();		
		tvo.setT2(t2);
		
		return ts.t6SelectName(tvo);
	}
	
	// ��¥ ��ȸ
	public ArrayList<T6VO> t6SelectDate(String fromdate, String todate){
		System.out.println("T6Scr.t6SelectDate >>> :");
		
		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();		
		tvo.setFromdate(fromdate);
		tvo.setTodate(todate);
		
		return ts.t6SelectDate(tvo);
	}

	// �Է� 
	public boolean t6Insert(String t1, String t2, String t3){
		System.out.println("T6Scr.t6Insert >>> :");
		
		boolean bool = false;
		
		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();
		tvo.setT1(t1);
		tvo.setT2(t2);
		tvo.setT3(t3);
		
		bool = ts.t6Insert(tvo);
		
		return bool;
	}
	
	// ����
	public boolean t6Update(String t1, String t2, String t3){
		System.out.println("T6Scr.t6Update >>> :");
		
		boolean bool = false;

		T6Service ts = new T6ServiceImpl();
		T6VO tvo = null;
		tvo = new T6VO();
		tvo.setT1(t1);
		tvo.setT2(t2);
		tvo.setT3(t3);
		
		bool = ts.t6Update(tvo);
		
		return bool;
	}
	
	// ����
	public boolean t6Delete(String t1){
		System.out.println("T6Scr.t6Delete >>> :");
		
		boolean bool = false;
		
		T6VO tvo = null;
		tvo = new T6VO();
		tvo.setT1(t1);

		T6Service ts = new T6ServiceImpl();
		bool = ts.t6Delete(tvo);
		
		return bool;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("T6Scr.main ����  >>> :");
		
		String t1 = "";
		String t2 = "";
		String t3 = "";
		String fromdate = "";
		String todate = "";
		
		System.out.println("ȸ�� ISUD, CRUD ������ �Է��Ͻÿ� >>> : ");
		System.out.println(   "ȸ�� ���� ��ü ��ȸ 			: SA 	\n"
				            + "ȸ�� ���� �̸����� ��ȸ 		: SN 	\n"
				            + "ȸ�� ���� ��¥�� ��ȸ		: SD 	\n"
				            + "ȸ�� ���� �Է�			 	: I 	\n"
				            + "ȸ�� ���� ���� 			: U 	\n"
				            + "ȸ�� ���� ���� 			: D 	\n");
		
		Scanner sc0 = new Scanner(System.in);
		
		String isudtype = sc0.next();
		if (isudtype !=null) isudtype = isudtype.toUpperCase(); 
		
		// ��ü ��ȸ
		if ("SA".equals(isudtype)) {
			System.out.println("ȸ�� ������ ��ȸ�մϴ�. >>> : ");
			
			T6Scr  t6 = new T6Scr();
			ArrayList<T6VO> aList = t6.t6SelectAll();
			
			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {
					T6VO _tvo = aList.get(i);
					T6VO.printT6VO(_tvo);
				}
			}
		}
		
		// �̸� ��ȸ
		if ("SN".equals(isudtype)) {
			System.out.println("ȸ�� ��ȸ�� �̸��� �Է��Ͻÿ� >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("�̸� �Է��ϱ� >>> : ");
			t2 = sc.next();
			System.out.println("�Է��� �̸�  >>> : " + t2);
			
			T6Scr  t6 = new T6Scr();
			ArrayList<T6VO> aList = t6.t6SelectName(t2);
			
			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {
					T6VO _tvo = aList.get(i);
					T6VO.printT6VO(_tvo);
				}
			}			
		}
		
		// ��¥ ��ȸ
		if ("SD".equals(isudtype)) {
			
			System.out.println("��¦ �˻� ������ �Է��Ͻÿ� >>> : ");
			System.out.println("��¦������ YYYYMMDD �Դϴ�. >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("from ��¥ �Է��ϱ� >>> : ");
			fromdate = sc.next();
			System.out.println("�Է��� from ��¥  >>> : " + fromdate);
			
			System.out.println("to ��¥ �Է��ϱ� >>> : ");
			todate = sc.next();
			System.out.println("�Է��� to ��¥  >>> : " + todate);
			
			if (DateUtil.fromtoDate(fromdate, todate)) return;
			
			T6Scr  t6 = new T6Scr();
			ArrayList<T6VO> aList = t6.t6SelectDate(fromdate, todate);
			
			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {
					T6VO _tvo = aList.get(i);
					T6VO.printT6VO(_tvo);
				}
			}			
			
		}
		
		// �Է�
		if ("I".equals(isudtype)) {
			
			System.out.println("ȸ�� ������ �����͸� �Է��Ͻÿ� >>> : ");
			Scanner sc = new Scanner(System.in);
			// �μ�Ʈ�� �� 
			// ä������ �Լ��� ȣ���ؼ� ä���� �Ѵ�. 
			// ����� main() �Լ����� �ϴ� �� 
			// �����δ� ��Ʈ�ѷ�, ������, �ٿ����� �Ѵ�. <-- ä���Լ��� ȣ���ϴ� ������ ���α׷� ���� �� �ٸ���. 
			
			// ���� ���� ä������������ getT6Chabun �Լ��� ȣ�� �� ��  �ƽ����� ������ ä�� ������ ���Ѵ�. 
			// �Ű����� d : YYYYMMDD, m : YYYYMM, y : YYYY, n : 
			
			// ChabunUtil.getT6Chabun("d");
			// ChabunUtil Ŭ������ �߻� Ŭ���� (abstract class) �� ����� ����
			// �����ڰ� new �ϴ� ���� �������� 
			// getT6Chabun() �Լ��� static �Լ��̴�. �� �Լ��� new �� �ϸ� �ʵȴ�. Ŭ�����̸����� �ҷ��� ����Ѵ�.
			
			// t1 = T202203180005;
			t1 = ChabunUtil.getT6Chabun("d");
			
			System.out.println("�̸� �Է��ϱ� >>> : ");
			t2 = sc.next();
			System.out.println("�Է��� �̸�  >>> : " + t2);
			
			System.out.println("���� �Է��ϱ� >>> : ");
			t3 = sc.next();
			System.out.println("�Է��� ����  >>> : " + t3);
			
			
			T6Scr  t6 = new T6Scr();		
			boolean bool = t6.t6Insert(t1, t2, t3);
			
			if (bool) {
				System.out.println("�Է� ���� >>> : " + bool);
				ArrayList<T6VO> aList = t6.t6SelectAll();
				
				if (aList !=null && aList.size() > 0) {
					for (int i=0; i < aList.size(); i++) {
						T6VO _tvo = aList.get(i);
						T6VO.printT6VO(_tvo);
					}
				}
				
			}else {
				System.out.println("�Է� ���� >>> : " + bool);
			}
		}
		
		// ���� 
		if ("U".equals(isudtype)) {
			System.out.println("ȸ�� ������ �����͸� �Է��Ͻÿ� >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("ȸ�� ��ȣ �Է��ϱ� >>> : ");
			t1 = sc.next();
			System.out.println("�Է��� ȸ����ȣ  >>> : " + t1);
			
			System.out.println("�̸� �Է��ϱ� >>> : ");
			t2 = sc.next();
			System.out.println("�Է��� �̸�  >>> : " + t2);
			
			System.out.println("���� �Է��ϱ� >>> : ");
			t3 = sc.next();
			System.out.println("�Է��� ����  >>> : " + t3);

			T6Scr  t6 = new T6Scr();		
			boolean bool = t6.t6Update(t1, t2, t3);
			
			if (bool) {
				System.out.println("���� ���� >>> : " + bool);
			}else {
				System.out.println("���� ���� >>> : " + bool);
			}
		}
		
		// ���� 
		if ("D".equals(isudtype)) {
			System.out.println("ȸ�� ������ �����͸� �Է��Ͻÿ� >>> : ");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("ȸ�� ��ȣ �Է��ϱ� >>> : ");
			t1 = sc.next();
			System.out.println("�Է��� ȸ����ȣ  >>> : " + t1);
			
			
			T6Scr  t6 = new T6Scr();		
			boolean bool = t6.t6Delete(t1);
			
			if (bool) {
				System.out.println("���� ���� >>> : " + bool);
			}else {
				System.out.println("���� ���� >>> : " + bool);
			}
		}		
	}
}
