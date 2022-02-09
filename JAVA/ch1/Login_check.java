package velog.homepage.login;

import java.util.Scanner;
// java 1.8.0 version 인데
// java 8 api에 java.util.Scanner의
// since는 1.5임 J2SE 5.0 이상에서 쓸 수 있고,
// 현재 java 8로 작업중이기 때문에 쓸 수 있음


public class Login_check{
	public boolean idcheck(String id, String pw){
		System.out.println("\n idcheck 시작 >>>>> \n");
		System.out.println("\n 입력하신 아이디는 "+id+" 입니다.\n");
		System.out.println("\n 입력하신 비밀번호는 "+pw+" 입니다. \n");
		boolean bool=false;
		// 지역변수는 그 자료형의 default 값으로 초기화 해서 사용한다.
		System.out.println("\n 지역변수의 bool 연산자의 default 값 >>> : "+bool);
		
		/*
		논리 곱 (&&) 
		&& 연산
		T AND T = T
		T AND F = F
		F AND T = F
		F AND F = F

		둘 중 하나라도 False면 False 출력
		*/

		if ( id!=null && id.length() >0)
		{
			System.out.println("\n idcheck 에서 다시 확인한 id >>> : "+id);
			System.out.println("\n idcheck 에서 다시 확인한 password >>> : "+pw);
			
			if("velog".equals(id)&&"@yunyoseob".equals(pw)){
				System.out.println("\n 아이디가 맞는지 확인이 되었습니다. \n");
				System.out.println("\n 비밀번호가 맞는지 확인이 되었습니다. \n");
				bool=true;
			} // end of if 안에 if
			else{
				System.out.println("\n 아이디 혹은 비밀번호가 틀립니다. \n");
			} // end of if 안에 else
		} // end of if
		// id!=null && id.length()는 id가 null값인지 확인하고
		// id의 배열의 길이가 아니라, 문자열 길이가 0보다 큰지 확인한다. 
		System.out.println("\n 아이디와 비밀번호 둘 다 맞으면 true 아니면 false >>> : "+bool);
		return bool;
	} // end of idcheck method


	public static void main(String args[]){
		System.out.println("\n main method 시작 >>>> \n");
		
		
		/* java.util.Scanner 모듈을 쓰지 않고
		// 하는 방법
		int argsLength=args.length;
		// length는 다른 말로 
		// length 필드라고 부르며, 문자열의 길이가 아닌
		// 배열의 길이를 셀 수 있게 해준다.
		System.out.println("\n 들어온 String 배열의 길이 >>> : "+argsLength);

		boolean aBool=argsLength ==2;
		// 배열의 길이가 2인지 아닌지 boolean으로 체크하기
		System.out.println("\n 배열의 길이가 맞으면 true 아니면 false >>> :"+aBool);

		 if else 문 사용해서 구별하기
		if (aBool){
			String id=args[0];
			String password=args[1];
			System.out.println("\n 첫 번째 배열 >>> : "+id);
			System.out.println("\n 두 번째 배열 >>> : "+password);
			Login_check lc=new Login_check();
			// idcheck는 static이 없으므로, 객체로 올려준다.
			System.out.println("\n 객체 생성하였으니 idcheck로 id, password 넘겨주기 \n");

			boolean finalbool=lc.idcheck(id, password);
			// idcheck에 id, password 입력해서 결과 출력하기
			System.out.println("\n 마지막으로 체크해서 아이디와 패스워드를 모두 잘 입력했다면 true, 아니면 false >>> :"+finalbool);

			// public boolean idCheck(String id, String pw)
			// boolean bool=lc.idcheck(id, password);
		} // end of if
		else{
			System.out.println("다시 입력하세요.");
		} // end of else
		*/

		// scanner 사용해서 간단하게 구현하기
		Scanner sc=new Scanner(System.in);

		// public String nextLine()
		System.out.println("\n 아이디를 입력하세요 :     ");
		String x=sc.nextLine();
		System.out.println("\n 비밀번호를 입력하세요 :     ");
		String y=sc.nextLine();

		System.out.println("\n Scanner를 통해 입력한 아이디 >>> :"+x);
		System.out.println("\n Scanner를 통해 입력한 비밀번호 >>> :"+y);

		boolean aBool= x.length()>0 && y.length()>0;
		System.out.println("\n 아이디와 비밀번호의 길이가 둘 다 0이 아니면 true, 둘 중 하나라도 0이면 false >>> : "+aBool);

		// if else 문 사용해서 구별하기
		if (aBool){
			Login_check lc=new Login_check();
			// idcheck는 static이 없으므로, 객체로 올려준다.
			System.out.println("\n 객체 생성하였으니 idcheck로 id, password 넘겨주기 \n");

			boolean finalbool=lc.idcheck(x, y);
			// idcheck에 id, password 입력해서 결과 출력하기
			System.out.println("\n 마지막으로 체크해서 아이디와 패스워드를 모두 잘 입력했다면 true, 아니면 false >>> :"+finalbool);

			// public boolean idCheck(String id, String pw)
			// boolean bool=lc.idcheck(id, password);
		} // end of if
		else{
			System.out.println("다시 입력하세요.");
		} // end of else
	} // end of main method
} // end of Login_check class