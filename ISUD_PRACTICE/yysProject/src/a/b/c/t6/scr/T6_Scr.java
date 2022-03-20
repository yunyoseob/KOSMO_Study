package a.b.c.t6.scr;

import java.util.ArrayList;
import java.util.Scanner;

import a.b.c.common.ChabunUtil;
import a.b.c.common.DateUtil;
import a.b.c.t6.service.T6Service;
import a.b.c.t6.service.T6ServiceImpl;
import a.b.c.t6.vo.T6VO;
import a.b.c.common.DateUtil;


public class T6_Scr {
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("\n T6_Scr :: t6SelectAll() ���� ");
		
		
		T6Service ts=new T6ServiceImpl();
		ArrayList<T6VO> aList=ts.t6SelectAll();
		
		return aList;
	};
	
	public ArrayList<T6VO> t6SelectName(String name){
		System.out.println("\n T6_Scr ::  t6SelectName(T6VO tvo) ���� ");
		System.out.println("�Է��Ͻ� �̸� :: "+name);
		
		T6Service ts=new T6ServiceImpl();
		
		// VO�� �˻��� ȸ�� �̸��� �����Ѵ�.
		T6VO tvo=null;
		// �⺻�����ڸ� �����Ѵ�.
		tvo=new T6VO();
		// ȸ�� �̸��� �����Ѵ�.
		tvo.setT2(name);
		
		ArrayList<T6VO> aList=ts.t6SelectName(tvo);
		
		return aList;
	};
	
	
	
	public ArrayList<T6VO> t6SelectDate(String fromDate, String toDate){
		System.out.println("\n T6_Scr :: t6SelectDate(T6VO tvo) :: ���� ");
		System.out.println("fromDate >>> : "+fromDate);
		System.out.println("toDate >>> : "+toDate);
			
		T6Service ts=new T6ServiceImpl();
		
		T6VO tvo=null;
		tvo=new T6VO();
		tvo.setFromdate(fromDate);
		tvo.setTodate(toDate);

		ArrayList<T6VO> aList=ts.t6SelectDate(tvo);
		return aList;
	};
	
	
	public boolean t6Insert(String name, String age){
		System.out.println("\n T6_Scr :: t6Insert(T6VO tvo) :: ���� ");
		System.out.println("�Է��� ȸ�� �̸� >>> : "+name);
		System.out.println("�Է��� ȸ�� ���� >>> : "+age);
		T6VO tvo=null;
		boolean bool=false;
		
		String t1=ChabunUtil.getT6Chabun("d");
		System.out.println("<<< T6_Scr :: t6Insert(String name, String age) ::t1 >>> : "+t1);
		tvo=new T6VO();
		tvo.setT1(t1);
		tvo.setT2(name);
		tvo.setT3(age);
		
		T6Service ts=new T6ServiceImpl();
		bool=ts.t6Insert(tvo);
		
		if(!bool){
			System.out.println("T6_Scr :: t6Insert(String name, String age) :: bool >>> "+bool);
		}
		
		return bool;
	};
	

	public boolean t6Update(String number, String name, String age){
		System.out.println("\n T6_Scr :: t6Update(T6VO tvo) :: ���� ");
		System.out.println("�Է��� ȸ�� ��ȣ >>> : "+number);
		System.out.println("������ ȸ�� �̸� >>> : "+name);
		System.out.println("������ ȸ�� ���� >>> : "+age);
		T6VO tvo=null;
		boolean bool=false;
		
		tvo=new T6VO();
		tvo.setT1(number); // ȸ����ȣ : T1 
		tvo.setT2(name); // ȸ���̸� : T2 
		tvo.setT3(age); // ȸ������  :T3
		
		T6Service ts=new T6ServiceImpl();
		bool=ts.t6Update(tvo);
		
		if(!bool){
			System.out.println("T6_Scr :: t6Insert(String name, String age) :: bool >>> "+bool);
		}
		
		return bool;
	};

	public boolean t6Delete(String number){
		System.out.println("\n T6_Scr :: t6Delete(T6VO tvo) :: ���� ");
		T6VO tvo=null;
		tvo=new T6VO();
		boolean bool=false;
		
		tvo=new T6VO();
		tvo.setT1(number); // ȸ����ȣ : T1 
		
		T6Service ts=new T6ServiceImpl();
		bool=ts.t6Delete(tvo);
		
		if(!bool){
			System.out.println("T6_Scr :: t6Insert(String name, String age) :: bool >>> "+bool);
		}
		
		return bool;
	};
	

	public static void main(String[] args) {
		System.out.println("<<< T6_Scr :: main�Լ� ���� >>>");
		
		
		System.out.println("ISUD ���񽺸� �����մϴ�. \n");
		Scanner sc=null;
		sc=new Scanner(System.in);
		
		try {
			while(true){
				int ans=0;
				ArrayList<T6VO> aList=null;
				System.out.println("<<< ������ �˻� ��� >>>");
				System.out.println("1 �Է� :: �����͸� �߰��մϴ�.(INSERT)  ");
				System.out.println("2 �Է� :: �����͸� ��ȸ�մϴ�.(SELECT) ");
				System.out.println("3 �Է� :: �����͸� �����մϴ�.(UPDATE) ");
				System.out.println("4 �Է� :: �����͸� �����մϴ�.(DELETE) ");
				System.out.println("0 �Է� :: ISUD ���񽺸� �����մϴ�. ");
				// sc.nextLine();
				ans=sc.nextInt();
					
				// INSERT
				if(ans==1){
					System.out.println(ans+"���� �Է��ϼ̽��ϴ�.");
					T6_Scr ts1=new T6_Scr();
					boolean b1=false;
					String name="";
					String age="";
					
					System.out.println("�Է��� ȸ�� �̸��� �Է��Ͽ� �ֽʽÿ�.");
					Scanner sc2=new Scanner(System.in);
					name=sc2.next();
					sc2.nextLine();
					System.out.println("�Է��� ȸ�� ���̸� �Է��Ͽ� �ֽʽÿ�.");
					age=sc2.next();
				
					b1=ts1.t6Insert(name, age);
					
					if (b1) {
						System.out.println("INSERT �Ϸ�");
					}else {System.out.println("INSERT ���� :: "+b1);}
				} // if(ans==1)

				
				// SELECT
				if (ans==2){
					System.out.println(ans+"���� �Է��ϼ̽��ϴ�.");
					System.out.println("<<< SELECT ��� >>>");
					System.out.println("1 �Է� :: TEST_T6 ���̺� ��ü�� ��ȸ�մϴ�.");
					System.out.println("2 �Է� :: ȸ���̸��� ��ȸ�մϴ�.(Į�� ID : T2) ");
					System.out.println("3 �Է� :: �Ի����� ��ȸ�մϴ�. (Į�� ID : T5) ");
					System.out.println("0 �Է� :: ��ȸ�ϰ� ���� �����Ͱ� �����ϴ�. ���α׷��� �����ҰԿ�.");
					sc.nextLine();
					int sel=0;
					sel=sc.nextInt();
					
					if(sel==1){
						System.out.println(sel+"�� �Է� :: ��ü ��ȸ");
						T6_Scr ts21=new T6_Scr();
						aList=ts21.t6SelectAll();
						// ���⼭ T6_Scr Ŭ������ t6SelectAll() �޼���� �ö󰣴�.
						

						if (aList != null && aList.size()>0){
							System.out.println("\n ======= �˻���� ======= \n");
							for (int i=0; i<aList.size(); i++){
								T6VO tv21=aList.get(i);
								// aList �迭���� ���Ҹ� T6VO Ŭ������ ���������� �����Ѵ�.							
								// tv21.printlnmethod();
								tv21.printmethod();
								System.out.println();
							}
							System.out.println("\n ==================== \n");
						}else {
							System.out.println("T6_Scr :: main :: aList :: "+aList);
							System.out.println("aList.size() :: "+aList.size());
						}
					}
					
					if(sel==2){
						System.out.println(sel+"�� �Է� :: ȸ���̸� ��ȸ");
						System.out.println("�˻��� ȸ�� �̸��� �Է��Ͽ� �ֽʽÿ�.");
						Scanner sc2=new Scanner(System.in);
						String name=sc2.next();
						
						T6_Scr ts22=new T6_Scr();
						aList=ts22.t6SelectName(name);
						
						if (aList != null && aList.size()>0){
							System.out.println("\n ======= �˻���� ======= \n");
							for (int i=0; i<aList.size(); i++){
								T6VO tv22=aList.get(i);
								// tv22.printlnmethod();
								tv22.printmethod();
								System.out.println();
							}
							System.out.println("\n ==================== \n");
						}else {
							System.out.println("T6_Scr :: main :: aList :: "+aList);
							System.out.println("aList.size() :: "+aList.size());
						}
						
					}
					if(sel==3){
						System.out.println(sel+"�� �Է� :: �Ի��� ��ȸ");
						System.out.println("fromDate�� yyyyMMdd �������� �Է��Ͽ� �ֽʽÿ�.");
						String fromDate="";
						String toDate="";
						boolean bool=false;
							
						Scanner sc23=new Scanner(System.in);
						fromDate=sc23.next();
						System.out.println("toDate�� yyyyMMdd �������� �Է��Ͽ� �ֽʽÿ�.");
						sc23.nextLine();
						toDate=sc23.next();
											
						bool=DateUtil.fromtoDate(fromDate, toDate);
							
						// bool = f > t;
							
						if(!bool){
							
							T6_Scr ts23=new T6_Scr();
						
							aList=ts23.t6SelectDate(fromDate, toDate);
							// ���⼭ T6_Scr Ŭ������ t6SelectAll() �޼���� �ö󰣴�.
							

							if (aList != null && aList.size()>0){
								System.out.println("\n ======= �˻���� ======= \n");
								for (int i=0; i<aList.size(); i++){
									T6VO tv23=aList.get(i);
									// aList �迭���� ���Ҹ� T6VO Ŭ������ ���������� �����Ѵ�.
									
									// tv23.printlnmethod();
									tv23.printmethod();
									System.out.println();
									
									}
								System.out.println("\n ======= �˻���� ======= \n");
								}else {
								System.out.println("T6_Scr :: main :: aList :: "+aList);
								System.out.println("aList.size() :: "+aList.size());
								}
							}else{
								System.out.println("bool = f > t >>> : "+bool);
								System.out.println("fromDate�� toDate ���� ũ�Ƿ� ISUD ���񽺸� �����մϴ�.");
								System.exit(0);
							}																													
					}
					
					if(sel==0){
						System.out.println(sel+"�� �Է� :: ��ȸ���� ���� :: ���α׷� ����");
						System.exit(0);
					}
					if (sel>3 || sel<0){
						System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �߸� �Էµ� �� >>> : "+sel);
						System.out.println("ISUD ���α׷��� ���α׷��� �����մϴ�.");
						sc.close();
						System.exit(0);
					}
				} // if(ans==2)
				
				
				// UPDATE
				if(ans==3){
					System.out.println(ans+"���� �Է��ϼ̽��ϴ�.");
					T6_Scr ts3=new T6_Scr();
					boolean b3=false;
					String number="";
					String name="";
					String age="";
					
					System.out.println("�Է��� ȸ�� ��ȣ�� �Է��Ͽ� �ֽʽÿ�.");
					Scanner sc2=new Scanner(System.in);
					number=sc2.next();
					sc2.nextLine();
					System.out.println("������ ȸ�� �̸��� �Է��Ͽ� �ֽʽÿ�.");
					name=sc2.next();
					sc2.nextLine();
					System.out.println("������ ȸ�� ���̸� �Է��Ͽ� �ֽʽÿ�.");
					age=sc2.next();
					
					if (number!=null && name!=null) {
						// ȸ����ȣ�� ȸ���̸��� null���� �� �� ����.
						b3=ts3.t6Update(number, name, age);

						if (b3) {
							System.out.println("UPDATE �Ϸ�");
						}else {
							System.out.println("UPDATE ���� :: "+b3);
						}
						
					}
					else{
						boolean bool1=false;
						boolean bool2=false;
						
						bool1= number==null;
						bool2= name==null;
						System.out.println("UPDATE :: number ==null >>> : "+bool1);
						System.out.println("�Էµ� ȸ����ȣ �� >>> : "+number);
						System.out.println("UPDATE :: name == null >>> : "+bool2);
						System.out.println("������ ȸ���̸��� >>> : "+name);
					}
				} // if(ans==3)
				
				
				// DELETE
				if (ans==4){
					System.out.println(ans+"���� �Է��ϼ̽��ϴ�.");
					T6_Scr ts4=new T6_Scr();
					boolean b4=false;
					String number="";
					
					System.out.println("������ ȸ�� ��ȣ�� �Է��Ͽ� �ֽʽÿ�.");
					Scanner sc2=new Scanner(System.in);
					number=sc2.next();
					
					b4=ts4.t6Delete(number);
					
					if (b4){
						System.out.println("DELETE �Ϸ�");
					}else {System.out.println("DELETE ���� :: "+b4);}
				} // if(ans==4)
				
				
				// EXIT
				if (ans==0){
					System.out.println("�Է��Ͻ� ��ȣ�� "+ans+"�� �Դϴ�.");
					System.out.println("0 �Է� :: ISUD ���α׷��� �����մϴ�. ");
					sc.close();
					System.exit(0);
				}
				
				// ERROR
				if (ans>4 || ans<0){
					System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �߸� �Էµ� �� >>> : "+ans);
					System.out.println("ISUD ���α׷��� ���α׷��� �����մϴ�.");
					sc.close();
					System.exit(0);
				}
			}
		}catch(Exception e){
			System.out.println("T6_Scr :: main :: error >>> "+e.getMessage());
		}finally{
			if (sc!=null){
				try {sc.close(); sc=null;}catch(Exception e1){}
			}
			System.out.println("<<< ISUD ���α׷��� �����մϴ�. >>> ");
		}
	} // main method
} // T6_Scr class
