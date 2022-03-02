package a.b.c.ch6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam_File_5{
	
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int cnt=0;
	// ����Լ� ȣ�� Ƚ���� 0���� �ʱ�ȭ �մϴ�.
	
	public static void printFileList(File dir){
		cnt++;
		System.out.println("printFileList ȣ�� Ƚ�� (cnt) >>> : "+cnt);
		// 6. cnt�� 0�̾�����, printFileList �Լ��� �����鼭 1�� �����Ͽ� 1�� ��µ˴ϴ�.
		// printFileList ȣ�� Ƚ�� (cnt) >>> : 1
		
		System.out.println("" + dir.getAbsolutePath());
		// 7. dir�� �����θ� Ȯ�� �մϴ�.
		// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work
		
		File[] files = dir.listFiles();
		// 8. File�迭�� �����, �ش��ϴ� dir�� �ִ� ������ �迭�� �Է��մϴ�.
		
		/* cnt :1 �϶� ��Ȳ
		System.out.println("File[0] >>> : "+files[0]);
		>>> .metadata�� ���� ���� �����ϴ�.
		
		int t=0;
		t=files.length;
		System.out.println("files[t-1] >>> : "+files[t-1]); //�ε����� 0���� �����ϱ� ������ t-1
		>>> firstProject
		 */

		ArrayList subDir = new ArrayList();
		// 9. ArrayList �迭�� �ϳ� ������ݴϴ�. (�������� : subDir)
		
		System.out.println("files.length >>> : "+files.length);
		// 10. files.length >>> : 2
		
		//=================for�� ����===================================
		for (int i=0; i < files.length; i++){
			// int i�� 0���� files.length���� i�� �ϳ��� �����Ͽ� �ݺ������ݴϴ�.
			String fileName = files[i].getName();
			// files �迭�� i��° �̸��� fileName���� �����մϴ�.
			
			//------files[i]�� ���丮�� ���� ���� �˴ϴ�.(if������)-------------
			if (files[i].isDirectory())
			{	
				System.out.println("files[i]�� ���丮 >>> : "+files[i]);
				fileName = "���丮 >>> : [" + fileName + "]";
				// i�� 0�� �� files[0],
				// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\.metadata
				
				// i�� 1�� ��, files[1]
				// C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\firstProject
				subDir.add(i + "");
				
			}
			//--------------------if�� ��-------------------------------
			System.out.println("���� >>> : " +  fileName);
			// i�� 0�� ��, ���� >>> : ���丮 >>> : [.metadata]
			// i�� 1�� ��, ���� >>> : ���丮 >>> : [firstProject]
		}
		//==================for��  ��====================================

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
		// 14. totalFiles�� fileNum��ŭ ���������ݴϴ�. 0 => 0
		totalDirs += dirNum;
		// 15. totalDirs�� dirNum��ŭ ���������ݴϴ�. 0 => 2

		System.out.println(fileNum + " ���� ����, " + dirNum + " ���� ���丮");
		// 16. 0 ���� ����, 2 ���� ���丮
		System.out.println();

		System.out.println("subDir >>> :" +  subDir);
		// 17. subDir >>> :[0, 1]
		// files[i].isDirectory()�� ���� ��, subDir.add(i + ""); 
		// ��ɾ �����߱� ������ i=0, i=1���� 0�� 1��
		// ArrayList subDir �迭�� ���Խ��ϴ�.
		
		
		System.out.println("subDir.size() >>> : "+subDir.size());
		// 18. subDir.size() >>> : 2
		
		//=====================for�� ����=============================
		for (int i=0; i < subDir.size(); i++){
			// i=0�� �� �� ��, i=1�� �� �� �� ���ϴ�.
			
			System.out.println("subDir.get("+i+") >>> : " + subDir.get(i));
			// subDir.get(0) >>> : 0
			// subDir �迭�� ù ��° ���� 0�Դϴ�.
			
			// 1. subDir.get(i)
			// 2. (String)subDir.get(i)
			// 3. Integer.parseInt() 
			int index = Integer.parseInt((String)subDir.get(i));
			// subDir�� ArrayList Ŭ������ ���������Դϴ�.
			// String ���� Ŭ���� ����ȯ�� �� ��, ������ �ٲپ, i��° ����
			/// index�� �����մϴ�.
			System.out.println("Integer.parseInt((String)subDir.get(i)) >>> : "+index);
			// 0
			System.out.println("files[index] >>> : "+files[index]);
			// printFileList �Լ����� File �迭�� ArrayList �迭�� �ֽ��ϴ�.
			// ���� File �迭 �������� files�� 0��° ����
			// files[index] >>> : C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work\.metadata
			printFileList(files[index]); 
			// �ش� �ּҸ� �ٽ� �� �� printFileList �Լ��� �Է��Ͽ� �ݴϴ�.
			// i < subDir.size() �� �̻� �ش� �۾��� �ݺ��˴ϴ�.
		}
		//=====================for�� ��==============================
		
		// ����, 394���̳� printFileList�� ȣ�� �� �� for���� ���� �Ǿ����ϴ�. (������� �ٸ�)
		// printFileList ȣ�� Ƚ�� (cnt) >>> : 394
		// subDir >>> :[]
		// subDir.size() >>> : 0
		// for���� ���ư��� �����Ƿ� �����մϴ�.
		// 19. �ٽ� main �Լ���
		
	}

	public static void main(String args[]){	
		// 0. �Է°� : String args="C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work";
		//  \, \\, /  �� �� ���� �����մϴ�. ( /�� �����ϴ� ��)
		
		if (args.length != 1){
			System.out.println(" USAGE : java FileTest_5 DIRECTORY");
			System.exit(0);
			// ����, �ƹ� ���� �Է����� ������, USAGE : java FileTest_5 DIRECTORY 
			// ����ϰ� ��
		}
		
		// 1. args.length�� args �迭�� ���̸� �ǹ��մϴ�.
		// 2. �迭�� ���̴� ���� 1�Դϴ�. ����, if���� ������� �ʽ��ϴ�.
		
		System.out.println("args[0] >>> "+args[0]);
		// args[0] >>> C:/00.KOSMO108_YYS/10.JExam/eclipse_java_work

		
		File dir = new File(args[0]);
		System.out.println("dir >>>> : "+dir);
		// 3. dir >>>> : C:\00.KOSMO108_YYS\10.JExam\eclipse_java_work
		
		boolean bool=!dir.exists();
		System.out.println("bool >>>> : "+bool);
		// bool >>>> : false
		
		if (!dir.exists() || !dir.isDirectory()){
			System.out.println(" ��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
			// ���丮�� �������� ������, ��ȿ���� ���� ���丮�Դϴ�. ���
			// �ñ��� ����� Run configurations Arguments��
			// "��������ʹ�" �Է��ϸ� ��ȿ���� ���� ���丮�Դϴٰ� ��µ˴ϴ�. 
		}
		
		
		// 4. if�� ���� ���ǹ��� �������� �� �� �ϳ��� ���ǿ� �������� �ʾƵ� ������� �ʽ��ϴ�.
		// !dir.exists();�� ���� false�̹Ƿ�, if���� ������� �ʽ��ϴ�.

	
		// �޼ҵ� 
		printFileList(dir);
		// 5. printFileList �Ű�������  dir �μ��� �Է��մϴ�.
		// (printFileList �Լ���  �� ��)
		
		System.out.println();
		System.out.println(" �� : " + totalFiles + " ���� ����");
		// 20. totalFiles += fileNum;�� ���� ����� ����մϴ�.
		System.out.println(" �� : " + totalDirs + " ���� ���丮");
		// 21. totalDirs += dirNum;�� ���� ����� ����մϴ�.
		
		// System.out.println("�� ȣ�� Ƚ���� :"+cnt+" ��");
		// �� ȣ�� Ƚ���� :394 ��
	}
}