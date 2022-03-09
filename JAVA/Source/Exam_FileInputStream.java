package a.b.c.ch6;

import java.io.File;
import java.io.FileInputStream;

import a.b.c.common.FilePath;

/*
�ڹ� ���α׷������� �޸𸮰����� ���α׷����� ���� �ʴ´�.
�ҽ����� �����ڰ� �޸𸮸� ����� ������ �� ���� ����.
�ڹٿ��� �޸𸮸� ����� ��ȭ�� ����ϴ� ���� ������ �÷��� ��� �Ѵ�. 
�ڹٿ��� �޸𸮸� ����ٴ� ���� 
������ �÷��Ϳ��� ��û�ϴ� �Ͱ� ���� ���̴�.
���α׷� ���忡���� �޸𸮰� ���� ���������� �� �� �� ����.
*/

/*
�ڹٿ��� null Ű���尡 �ִ�.
null Ű���尡 �ǹ��ϴ� ���� �����͸� ����Ű�� �ʴ´�.
���� ���� �� ���������� �����Ͱ� ����. 
*/

public class Exam_FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		�������� ����ϴ� ���
		
		1. ���������� �Լ����� �¾�� �Լ����� �״´�.
			�� : ���̴� ���� GC(������ �÷���)�� �Ѵ�. 
		2. ���������� ������� ����� �� ���� ����.
		3. ���������� ������ �÷��Ͱ� �� ���α׷��� �޸� ��Ȳ�� ����
		4. ���α׷��� ������� ���� �����ٸ��� ���ؼ� �޸𸮿��� ���� �ȴ�. 
		*/
		
		/*
		���������� ����ϴ� ��Ģ
		
		1. ���������� ����� ���ÿ� ����Ʈ ������ �ʱ�ȭ �Ѵ�.
			��ü �������� = null;
			�����ڷ��� �������� = ����Ʈ��; 0, 0.0, '\u0000', false
			String s = "";
			String s1 = null;
		2. ��� ����, I/O �� �߻��ϴ� ��ü�� ����� ��
			flush(), close(), null ó���� �ؾ� �Ѵ�. 
			
			��) 	FileInputStream fis = null; //  null �ʱ�ȭ 
				// ��ü ���� 
				fis = new FileInputStream(filePath + "/" + file);
				
				// ��ü �ݱ�
				fis.close();
				// ����� ���� ��ü null �ʱ�ȭ 
				fis = null;
		*/
		
		// ��������, ��ü, �������� 
		// ��ü null �ʱ�ȭ 
		FileInputStream fis = null;
				
		try {
			
			String filePath = FilePath.FILE_PATH_CH6;			
			filePath = filePath + "/" + "Exam_FileInputStream.java";
			System.out.println("filePath >>> : " + filePath);
			
			File f = new File(filePath);
			
			boolean bFile = f.exists();
			System.out.println("bFile >>> : " + bFile);
			
			if(bFile) {
				fis = new FileInputStream(f);				
				System.out.println("fis >>> : " + fis);
				
				// public int read() throws IOException
				int data = 0;
				while((data = fis.read()) !=-1) {
					System.out.print((char)data);
				}
				
				// ���������� ������ �Ǿ��� �� ����Ǵ� ��ƾ
				// FileInputStream I/O ��ü�� �ݴ´�.
				fis.close();				
			}else {
				System.out.println("������ �����ϴ�. >>> : ");
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("������ >>> : " + e.getMessage());
		}finally {
			
			if (fis !=null) {
				try {
					fis.close(); fis=null;
				}catch(Exception e) {}
			}
		}
	}
}
