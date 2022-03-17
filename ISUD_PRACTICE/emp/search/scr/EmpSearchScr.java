package a.b.c.emp.search.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.DateUtil;
import a.b.c.emp.search.service.EmpSearchService;
import a.b.c.emp.search.service.EmpSearchServiceImpl;
import a.b.c.emp.search.vo.EmpSearchVO;

public class EmpSearchScr {
	
	// ȭ��� ���񽺸� �����ϴ� �Լ��ϴ� �Լ��� <-- ��Ʈ�ѷ� 
	
	// ��ü �˻�
	public ArrayList<EmpSearchVO> empSelectAll() {
		System.out.println("EmpSearchScr.empSelectAll() �Լ� ���� >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		ArrayList<EmpSearchVO> aList = es.empSelectAll();
		
		return aList;
	}
	
	// ��� �˻�
	public ArrayList<EmpSearchVO> empSelectEmpno(String empno) {
		System.out.println("EmpSearchScr.empSelectEmpno() �Լ� ���� >>> : ");

		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO �� �˻� Ű���� ����� �����Ѵ�. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setEmpno(empno);
		
		ArrayList<EmpSearchVO> aList = es.empSelectEmpno(evo);
		
		return aList;
	}

	// �̸� �˻�
	public ArrayList<EmpSearchVO> empSelectEname(String ename){
		System.out.println("EmpSearchScr.empSelectEname() �Լ� ���� >>> : ");
		System.out.println("EmpSearchScr.empSelectEname() ename >>> : " + ename);
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO �� �˻� Ű���� ����� �����Ѵ�. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setEname(ename);
		System.out.println("EmpSearchScr.empSelectEname() evo.getEname() >>> : " + evo.getEname());
		
		ArrayList<EmpSearchVO> aList = es.empSelectEname(evo);
		
		return aList;
	}
	
	// ��� �̸� �˻�
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(String empno, String ename) {		
		System.out.println("EmpSearchScr.empSelectEmpnoEname() �Լ� ���� >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO �� �˻� Ű���� ����� �����Ѵ�. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setEmpno(empno);
		evo.setEname(ename);
		
		ArrayList<EmpSearchVO> aList = es.empSelectEmpnoEname(evo);
		
		return aList;
	}
	
	// ��å �˻�
	public ArrayList<EmpSearchVO> empSelectJob(String job) {	
		System.out.println("EmpSearchScr.empSelectJob() �Լ� ���� >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO �� �˻� Ű���� ����� �����Ѵ�. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setJob(job);
		
		ArrayList<EmpSearchVO> aList = es.empSelectJob(evo);
		
		return aList;
	}
	
	// ��¥ �˻� 
	public ArrayList<EmpSearchVO> empSelectHiredate(String fromdate, String todate) {
		System.out.println("EmpSearchScr.empSelectHiredate() �Լ� ���� >>> : ");
		
		EmpSearchService es = new EmpSearchServiceImpl();
		
		// VO �� �˻� Ű���� ����� �����Ѵ�. 
		EmpSearchVO evo = null;
		evo = new EmpSearchVO();
		evo.setFromdate(fromdate);
		evo.setTodate(todate);
		
		ArrayList<EmpSearchVO> aList = es.empSelectHiredate(evo);
		
		return aList;
	}
	
	
	// ���� �Լ��� ȭ�� ��Ȱ�� �Ѵ�. 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchScr.main() �Լ� ���� >>> : ");
		
		Scanner sc = null;
		
		try {
			
			while (true) {
				
				System.out.println("�˻��� ��ȣ�� 			\n"
						+ "1. ��ü�˻� 		\n"
						+ "2. ��� �˻� 		\n"
						+ "3. �̸� �˻� 		\n"
						+ "4. ���, �̸� �˻� 	\n"
						+ "5. ��å �˻� 		\n"
						+ "6. ��¥ �˻� 		\n");
				
				sc = new Scanner(System.in);
				int n = sc.nextInt();
				
				if (9 == n) {
					System.out.println("���α׷��� �����մϴ�. >>> :");
					System.exit(0);
				}
				
				while (true) {
					
					if (1 == n) {
						System.out.println(n + " ��ü �˻��� ���� �߽��ϴ� >>> : ");
					
						EmpSearchScr es1 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es1.empSelectAll();
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");
								System.out.print(esvo.getMgr() + " : ");
								System.out.print(esvo.getHiredate() + " : ");
								System.out.print(esvo.getSal() + " : ");
								System.out.print(esvo.getComm() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (2 == n) {
						System.out.println(n + " ��� �˻��� ���� �߽��ϴ� >>> : ");
						
						Scanner sc2 = new Scanner(System.in);
						String empno = sc2.next();
						
						EmpSearchScr es2 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es2.empSelectEmpno(empno);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (3 == n) {
						System.out.println(n + " �̸� �˻��� ���� �߽��ϴ� >>> : ");
						
						System.out.println("�̸��� �Է��Ͻÿ� >>> : " );
						Scanner sc3 = new Scanner(System.in);
						String ename = sc3.next();
						System.out.println("�Է��� �̸��� >>> : " + ename);
						
						EmpSearchScr es3 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es3.empSelectEname(ename);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (4 == n) {
						System.out.println(n + " ��� �̸� �˻��� ���� �߽��ϴ�  >>> : ");
						
						Scanner sc4= new Scanner(System.in);
						String empno = sc4.next();
						String ename = sc4.next();
						
						EmpSearchScr es4 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es4.empSelectEmpnoEname(empno, ename);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					}
					
					if (5 == n) {
						System.out.println(n + " ��å �˻��� ���� �߽��ϴ� >>> : ");
						
						Scanner sc5 = new Scanner(System.in);
						String job = sc5.next();
						
						EmpSearchScr es5 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es5.empSelectJob(job);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
					}
					
					if (6 == n) {
						System.out.println(n + " ��¥ �˻��� ���� �߽��ϴ� >>> : ");
						System.out.println("��¥ ������ YYYYMMDD �Դϴ�. >>> : ");
						
						Scanner sc6 = new Scanner(System.in);
						String fromdate = sc6.next();
						System.out.println("�˻��� from ��¥ >>> : " + fromdate);
						String todate = sc6.next();
						System.out.println("�˻��� to ��¥ >>> : " + todate);
						
						// from > to ��
						if (DateUtil.fromtoDate(fromdate, todate)) return;
						
						EmpSearchScr es6 = new EmpSearchScr();
						ArrayList<EmpSearchVO> aList = es6.empSelectHiredate(fromdate, todate);
						
						if (aList !=null && aList.size() > 0) {

							for (int i=0; i < aList.size(); i++) {
								EmpSearchVO esvo = aList.get(i);					
								System.out.print(esvo.getEmpno() + " : ");
								System.out.print(esvo.getEname() + " : ");
								System.out.print(esvo.getJob() + " : ");					
								System.out.print(esvo.getHiredate() + " : ");
								System.out.println(esvo.getDeptno());			
							}		
						}
						
						break;
					} // end of if (6 == n)
				} // end of while()
			} // end of while()			
			
		}catch(Exception e) {
			System.out.println("������ >>> : " + e);
		}finally {
			if (sc !=null) sc.close();
		}
	} // end of main()
} // end of EmpSearchScr Class
