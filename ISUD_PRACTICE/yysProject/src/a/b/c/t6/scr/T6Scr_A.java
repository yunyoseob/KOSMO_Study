package a.b.c.t6.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.DateUtil;
import a.b.c.t6.service.T6Service_A;
import a.b.c.t6.service.T6Service_AImpl;
import a.b.c.t6.vo.T6VO;


//A : Actual Practice
public class T6Scr_A {
	// ��ü ��ȸ
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("T6Scr_A :: t6SelectAll()  :: ���� ");
		
		T6Service_A ts = new T6Service_AImpl();
		return ts.t6SelectAll();
	} //t6SelectAll()
	
	
	// �̸� ��ȸ
	public ArrayList<T6VO> t6SelectName(String t2){
		System.out.println("T6Scr_A :: toSelectName(String name) :: ���� ");
		System.out.println("name >>> : "+t2);
		
		T6Service_A ts= new T6Service_AImpl();
		T6VO tvo=null;
		tvo=new T6VO();
		tvo.setT2(t2);
		
		return ts.t6SelectName(tvo);
	}

	// ��¥ ��ȸ
	public ArrayList<T6VO> t6SelectDate(String fromdate, String todate){
		System.out.println("T6Scr_A :: toSelectDate(String fromdate, String todate)  :: ���� ");
		
		T6Service_A ts= new T6Service_AImpl();
		T6VO tvo=null;
		tvo=new T6VO();
		tvo.setFromdate(fromdate);
		tvo.setTodate(todate);
		
		return ts.t6SelectDate(tvo);
	}
	
	// �Է�
	public boolean t6Insert(String t1, String t2, String t3){
		System.out.println("T6Scr_A :: String t1, String t2, String t3) :: ���� ");
	}
	
	// ����
	public boolean t6Update(String t1, String t2, String t3){
		System.out.println("T6Scr_A :: t6Update(String t1, String t2, String t3) :: ���� ");
	}
	
	// ����
	public boolean t6Delete(String t1){
		System.out.println("T6Scr_A :: t6Delete(String t1)  :: ���� ");
	}
	
	public static void main(String[] args) {
		System.out.println("<<< T6Scr_A.main ���� >>>");
		
		String t1="";
		String t2="";
		String t3="";
		String fromdate="";
		String todate="";
		
		System.out.println("\n ȸ�� ISUD, CRUD ������ �Է��ϼ���");
		System.out.println("ȸ�� ���� ��ü ��ȸ 		   		: SA 	\n"
						       + "ȸ�� ���� �̸����� ��ȸ 		: SN 	\n"
							   + "ȸ�� ���� ��¥�� ��ȸ 		: SD 	\n"
						   	   + "ȸ�� ���� �Է� 			: I 	\n"
							   + "ȸ�� ���� ���� 			: U 	\n"
							   + "ȸ�� ���� ���� 			: D 	\n");
		
		Scanner sc0 = new Scanner(System.in);
		String isudtype=sc0.next();
		
		if (isudtype !=null) isudtype = isudtype.toUpperCase();
		System.out.println("�Է��� ���� (�빮�� ��ȯ) >>> : "+isudtype);
		
		// ��ü ��ȸ
		// ���ڿ� �񱳴� �ڹٿ��� equals�� ����.
		if("SA".equals(isudtype)){
			System.out.println("�Է��� ������ SA >>> : "+isudtype);
			
			T6Scr_A t6=new T6Scr_A();
			ArrayList<T6VO> aList=t6.t6SelectAll();
			
			if (aList!=null&&aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					T6VO _tvo=aList.get(i);
					T6VO.printmethod(_tvo);
				}
			}else{
				System.out.println("aList�� ������ �ֽ��ϴ�. aList >> : "+aList);
				System.out.println("Ȥ�� aList.size()�� 0���� ũ�� �ʽ��ϴ�. aList.size() >> : "+aList.size());
			}
		}
		
		// �̸� ��ȸ
		if ("SN".equals(isudtype)){
			System.out.println("�Է��� ���� (�빮�� ��ȯ) >>> : "+isudtype);
			Scanner sc=new Scanner(System.in);
			String name="";
			
			System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
			t2=sc.next();
			System.out.println("�Է��� �̸� >>> : "+t2);
			
			T6Scr_A t6=new T6Scr_A();
			ArrayList<T6VO> aList=t6.t6SelectName(t2);
			
			if (aList!=null && aList.size() >0){
				for (int i=0; i< aList.size(); i++){
					T6VO _tvo=aList.get(i);
					T6VO.printmethod(_tvo);
					
				}
			}else{
				System.out.println("aList�� ������ �ֽ��ϴ�. aList >> : "+aList);
				System.out.println("Ȥ�� aList.size()�� 0���� ũ�� �ʽ��ϴ�. aList.size() >> : "+aList.size());
			}
		}
		
		// ��¥ ��ȸ
		if ("SD".equals(isudtype)){
			System.out.println("��¥ �˻� ������ �Է��Ͻÿ� >>> : ");
			System.out.println("��¥ ������ YYYMMDD �Դϴ�. >>> : ");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("from ��¥ �Է��ϱ� >> : ");
			fromdate=sc.next();
			System.out.println("�Է���  from ��¥ >>> : "+fromdate);
			
			System.out.println("to ��¥ �Է��ϱ� >>> : ");
			todate=sc.next();
			System.out.println("�Է��� to ��¥ >>> : "+todate);
			
			if (DateUtil.fromtoDate(fromdate, todate)) return;
			//  fromDate���� toDate�� �� Ŀ�� ��. �̸� Ȯ��
			
			T6Scr_A t6=new T6Scr_A();
			ArrayList<T6VO> aList=t6.t6SelectDate(fromdate, todate);
			
			if(aList!=null&&aList.size()>0){
				for (int i=0; i<aList.size(); i++){
					T6VO _tvo = aList.get(i);
					T6VO.printmethod(_tvo);
				}
			}else{
				System.out.println("aList�� ������ �ֽ��ϴ�. aList >> : "+aList);
				System.out.println("Ȥ�� aList.size()�� 0���� ũ�� �ʽ��ϴ�. aList.size() >> : "+aList.size());
			}
		}
		
		//�Է�
		if ("I".equals(isudtype)){
			
		}
		
		// ����
		if ("U".equals(isudtype)){
			
		}
		
		// ����
		if ("D".equals(isudtype)){
			
		}
		
		// ����ó���� ���� ���� �ʴ´�.
		// ���� : if���� () �Ұ�ȣ ���� ������
		// true �� ���� ����Ǳ� �����̴�.
		
		
		
	} // main method

} // T6Scr_A class
