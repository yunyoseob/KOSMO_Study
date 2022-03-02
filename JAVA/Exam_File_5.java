package a.b.c.ch6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam_File_5{
	
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int cnt=0;
	// 재귀함수 호출 횟수를 0으로 초기화 합니다.
	
	public static void printFileList(File dir){
		cnt++;
		System.out.println("printFileList 호출 횟수 (cnt) >>> : "+cnt);
		// 6. cnt는 0이었으나, printFileList 함수에 들어오면서 1이 증가하여 1이 출력됩니다.
		// printFileList 호출 횟수 (cnt) >>> : 1
		
		System.out.println("" + dir.getAbsolutePath());
		// 7. dir의 절대경로를 확인 합니다.
		// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work
		
		File[] files = dir.listFiles();
		// 8. File배열을 만들어, 해당하는 dir에 있는 파일을 배열에 입력합니다.
		
		/* cnt :1 일때 상황
		System.out.println("File[0] >>> : "+files[0]);
		>>> .metadata가 제일 먼저 들어갔습니다.
		
		int t=0;
		t=files.length;
		System.out.println("files[t-1] >>> : "+files[t-1]); //인덱스는 0부터 시작하기 때문에 t-1
		>>> firstProject
		 */

		ArrayList subDir = new ArrayList();
		// 9. ArrayList 배열을 하나 만들어줍니다. (참조변수 : subDir)
		
		System.out.println("files.length >>> : "+files.length);
		// 10. files.length >>> : 2
		
		//=================for문 시작===================================
		for (int i=0; i < files.length; i++){
			// int i가 0부터 files.length까지 i를 하나씩 증가하여 반복시켜줍니다.
			String fileName = files[i].getName();
			// files 배열의 i번째 이름을 fileName으로 대입합니다.
			
			//------files[i]가 디렉토리일 때만 실행 됩니다.(if문시작)-------------
			if (files[i].isDirectory())
			{	
				System.out.println("files[i]는 디렉토리 >>> : "+files[i]);
				fileName = "디렉토리 >>> : [" + fileName + "]";
				// i가 0일 때 files[0],
				// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\.metadata
				
				// i가 1일 때, files[1]
				// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\firstProject
				subDir.add(i + "");
				
			}
			//--------------------if문 끝-------------------------------
			System.out.println("파일 >>> : " +  fileName);
			// i가 0일 때, 파일 >>> : 디렉토리 >>> : [.metadata]
			// i가 1일 때, 파일 >>> : 디렉토리 >>> : [firstProject]
		}
		//==================for문  끝====================================

		int dirNum = subDir.size();
		System.out.println("int dirNum >>> : "+dirNum);
		// 11. int dirNum >>> : 2
		int fileNum = files.length - dirNum;
		System.out.println("files.length >>> "+files.length);
		// 12. files.length >>> 2
		System.out.println("fileNum >>> "+fileNum);
		// 2-2==0 
		// 13. fileNum >>> 0

		totalFiles += fileNum;
		// 14. totalFiles에 fileNum만큼 증가시켜줍니다. 0 => 0
		totalDirs += dirNum;
		// 15. totalDirs에 dirNum만큼 증가시켜줍니다. 0 => 2

		System.out.println(fileNum + " 개의 파일, " + dirNum + " 개의 디렉토리");
		// 16. 0 개의 파일, 2 개의 디렉토리
		System.out.println();

		System.out.println("subDir >>> :" +  subDir);
		// 17. subDir >>> :[0, 1]
		// files[i].isDirectory()가 참일 때, subDir.add(i + ""); 
		// 명령어를 실행했기 때문에 i=0, i=1에서 0과 1이
		// ArrayList subDir 배열에 들어왔습니다.
		
		
		System.out.println("subDir.size() >>> : "+subDir.size());
		// 18. subDir.size() >>> : 2
		
		//=====================for문 시작=============================
		for (int i=0; i < subDir.size(); i++){
			// i=0일 때 한 번, i=1일 때 한 번 돕니다.
			
			System.out.println("subDir.get("+i+") >>> : " + subDir.get(i));
			// subDir.get(0) >>> : 0
			// subDir 배열의 첫 번째 값은 0입니다.
			
			// 1. subDir.get(i)
			// 2. (String)subDir.get(i)
			// 3. Integer.parseInt() 
			int index = Integer.parseInt((String)subDir.get(i));
			// subDir는 ArrayList 클래스의 참조변수입니다.
			// String 으로 클래스 형변환을 한 뒤, 정수로 바꾸어서, i번째 값을
			/// index에 대입합니다.
			System.out.println("Integer.parseInt((String)subDir.get(i)) >>> : "+index);
			// 0
			System.out.println("files[index] >>> : "+files[index]);
			// printFileList 함수에는 File 배열과 ArrayList 배열이 있습니다.
			// 현재 File 배열 참조변수 files의 0번째 값은
			// files[index] >>> : C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\.metadata
			printFileList(files[index]); 
			// 해당 주소를 다시 한 번 printFileList 함수에 입력하여 줍니다.
			// i < subDir.size() 인 이상 해당 작업이 반복됩니다.
		}
		//=====================for문 끝==============================
		
		// 무려, 394번이나 printFileList가 호출 된 뒤 for문이 종료 되었습니다. (사람마다 다름)
		// printFileList 호출 횟수 (cnt) >>> : 394
		// subDir >>> :[]
		// subDir.size() >>> : 0
		// for문이 돌아가지 않으므로 종료합니다.
		// 19. 다시 main 함수로
		
	}

	public static void main(String args[]){	
		// 0. 입력값 : String args="C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work";
		//  \, \\, /  셋 다 실행 가능합니다. ( /를 지향하는 편)
		
		if (args.length != 1){
			System.out.println(" USAGE : java FileTest_5 DIRECTORY");
			System.exit(0);
			// 만약, 아무 값도 입력하지 않으면, USAGE : java FileTest_5 DIRECTORY 
			// 출력하고 끝
		}
		
		// 1. args.length는 args 배열의 길이를 의미합니다.
		// 2. 배열의 길이는 현재 1입니다. 따라서, if문은 실행되지 않습니다.
		
		System.out.println("args[0] >>> "+args[0]);
		// args[0] >>> C:/00.KOSMO108_YYS/10.JExam/eclipse_java_work

		
		File dir = new File(args[0]);
		System.out.println("dir >>>> : "+dir);
		// 3. dir >>>> : C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work
		
		boolean bool=!dir.exists();
		System.out.println("bool >>>> : "+bool);
		// bool >>>> : false
		
		if (!dir.exists() || !dir.isDirectory()){
			System.out.println(" 유효하지 않은 디렉토리입니다.");
			System.exit(0);
			// 디렉토리가 존재하지 않으면, 유효하지 않은 디렉토리입니다. 출력
			// 궁금한 사람은 Run configurations Arguments에
			// "집에가고싶다" 입력하면 유효하지 않은 디렉토리입니다가 출력됩니다. 
		}
		
		
		// 4. if문 내의 조건문은 논리곱으로 둘 중 하나만 조건에 만족하지 않아도 실행되지 않습니다.
		// !dir.exists();이 현재 false이므로, if문은 실행되지 않습니다.

	
		// 메소드 
		printFileList(dir);
		// 5. printFileList 매개변수에  dir 인수를 입력합니다.
		// (printFileList 함수로  ㄱ ㄱ)
		
		System.out.println();
		System.out.println(" 총 : " + totalFiles + " 개의 파일");
		// 20. totalFiles += fileNum;의 최종 결과를 출력합니다.
		System.out.println(" 총 : " + totalDirs + " 개의 디렉토리");
		// 21. totalDirs += dirNum;의 최종 결과를 출력합니다.
		
		// System.out.println("총 호출 횟수는 :"+cnt+" 번");
		// 총 호출 횟수는 :394 번
	}
}