package velog.homepage.login;

import java.util.Scanner;
// java 1.8.0 version �ε�
// java 8 api�� java.util.Scanner��
// since�� 1.5�� J2SE 5.0 �̻󿡼� �� �� �ְ�,
// ���� java 8�� �۾����̱� ������ �� �� ����


public class Login_check{
	public boolean idcheck(String id, String pw){
		System.out.println("\n idcheck ���� >>>>> \n");
		System.out.println("\n �Է��Ͻ� ���̵�� "+id+" �Դϴ�.\n");
		System.out.println("\n �Է��Ͻ� ��й�ȣ�� "+pw+" �Դϴ�. \n");
		boolean bool=false;
		// ���������� �� �ڷ����� default ������ �ʱ�ȭ �ؼ� ����Ѵ�.
		System.out.println("\n ���������� bool �������� default �� >>> : "+bool);
		
		/*
		�� �� (&&) 
		&& ����
		T AND T = T
		T AND F = F
		F AND T = F
		F AND F = F

		�� �� �ϳ��� False�� False ���
		*/

		if ( id!=null && id.length() >0)
		{
			System.out.println("\n idcheck ���� �ٽ� Ȯ���� id >>> : "+id);
			System.out.println("\n idcheck ���� �ٽ� Ȯ���� password >>> : "+pw);
			
			if("velog".equals(id)&&"@yunyoseob".equals(pw)){
				System.out.println("\n ���̵� �´��� Ȯ���� �Ǿ����ϴ�. \n");
				System.out.println("\n ��й�ȣ�� �´��� Ȯ���� �Ǿ����ϴ�. \n");
				bool=true;
			} // end of if �ȿ� if
			else{
				System.out.println("\n ���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�. \n");
			} // end of if �ȿ� else
		} // end of if
		// id!=null && id.length()�� id�� null������ Ȯ���ϰ�
		// id�� �迭�� ���̰� �ƴ϶�, ���ڿ� ���̰� 0���� ū�� Ȯ���Ѵ�. 
		System.out.println("\n ���̵�� ��й�ȣ �� �� ������ true �ƴϸ� false >>> : "+bool);
		return bool;
	} // end of idcheck method


	public static void main(String args[]){
		System.out.println("\n main method ���� >>>> \n");
		
		
		/* java.util.Scanner ����� ���� �ʰ�
		// �ϴ� ���
		int argsLength=args.length;
		// length�� �ٸ� ���� 
		// length �ʵ��� �θ���, ���ڿ��� ���̰� �ƴ�
		// �迭�� ���̸� �� �� �ְ� ���ش�.
		System.out.println("\n ���� String �迭�� ���� >>> : "+argsLength);

		boolean aBool=argsLength ==2;
		// �迭�� ���̰� 2���� �ƴ��� boolean���� üũ�ϱ�
		System.out.println("\n �迭�� ���̰� ������ true �ƴϸ� false >>> :"+aBool);

		 if else �� ����ؼ� �����ϱ�
		if (aBool){
			String id=args[0];
			String password=args[1];
			System.out.println("\n ù ��° �迭 >>> : "+id);
			System.out.println("\n �� ��° �迭 >>> : "+password);
			Login_check lc=new Login_check();
			// idcheck�� static�� �����Ƿ�, ��ü�� �÷��ش�.
			System.out.println("\n ��ü �����Ͽ����� idcheck�� id, password �Ѱ��ֱ� \n");

			boolean finalbool=lc.idcheck(id, password);
			// idcheck�� id, password �Է��ؼ� ��� ����ϱ�
			System.out.println("\n ���������� üũ�ؼ� ���̵�� �н����带 ��� �� �Է��ߴٸ� true, �ƴϸ� false >>> :"+finalbool);

			// public boolean idCheck(String id, String pw)
			// boolean bool=lc.idcheck(id, password);
		} // end of if
		else{
			System.out.println("�ٽ� �Է��ϼ���.");
		} // end of else
		*/

		// scanner ����ؼ� �����ϰ� �����ϱ�
		Scanner sc=new Scanner(System.in);

		// public String nextLine()
		System.out.println("\n ���̵� �Է��ϼ��� :     ");
		String x=sc.nextLine();
		System.out.println("\n ��й�ȣ�� �Է��ϼ��� :     ");
		String y=sc.nextLine();

		System.out.println("\n Scanner�� ���� �Է��� ���̵� >>> :"+x);
		System.out.println("\n Scanner�� ���� �Է��� ��й�ȣ >>> :"+y);

		boolean aBool= x.length()>0 && y.length()>0;
		System.out.println("\n ���̵�� ��й�ȣ�� ���̰� �� �� 0�� �ƴϸ� true, �� �� �ϳ��� 0�̸� false >>> : "+aBool);

		// if else �� ����ؼ� �����ϱ�
		if (aBool){
			Login_check lc=new Login_check();
			// idcheck�� static�� �����Ƿ�, ��ü�� �÷��ش�.
			System.out.println("\n ��ü �����Ͽ����� idcheck�� id, password �Ѱ��ֱ� \n");

			boolean finalbool=lc.idcheck(x, y);
			// idcheck�� id, password �Է��ؼ� ��� ����ϱ�
			System.out.println("\n ���������� üũ�ؼ� ���̵�� �н����带 ��� �� �Է��ߴٸ� true, �ƴϸ� false >>> :"+finalbool);

			// public boolean idCheck(String id, String pw)
			// boolean bool=lc.idcheck(id, password);
		} // end of if
		else{
			System.out.println("�ٽ� �Է��ϼ���.");
		} // end of else
	} // end of main method
} // end of Login_check class