package a.b.c.ch2;

public class Exam_Final {

	public static final String FILE_UPLOAD_PATH = "C:\\00.KOSMO108\\30.Web\\fileUpload";

	// 매개변수에 final 
	void examMethod(final String s) {
		// s = "강민";
		String ss = s;
		System.out.println("ss >>> : " + ss);
	}


	public static void main(String args[]) {
		
		// 변수에 final 
		// Exam_Final.FILE_UPLOAD_PATH = "11";

		String s = Exam_Final.FILE_UPLOAD_PATH;
		System.out.println("s >>> : " + s);

		Exam_Final ef = new Exam_Final();
		ef.examMethod("성연제");
	}
}