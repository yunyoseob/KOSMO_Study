package a.b.c.ch2;

public class Exam_Final {

	public static final String FILE_UPLOAD_PATH = "C:\\00.KOSMO108\\30.Web\\fileUpload";

	// �Ű������� final 
	void examMethod(final String s) {
		// s = "����";
		String ss = s;
		System.out.println("ss >>> : " + ss);
	}


	public static void main(String args[]) {
		
		// ������ final 
		// Exam_Final.FILE_UPLOAD_PATH = "11";

		String s = Exam_Final.FILE_UPLOAD_PATH;
		System.out.println("s >>> : " + s);

		Exam_Final ef = new Exam_Final();
		ef.examMethod("������");
	}
}