package a.b.c.ch6;

import java.text.SimpleDateFormat;

public class Exam_Time_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
			System.currentTimeMillis()는 
			현재 시각과 1970년 1월 1일 00:00:00 시와의 차이를 long값으로 전달한다.						  
		 */
		
		//현재 서버 시간을 long 타입으로 가져오기
		long start = System.currentTimeMillis();
		System.out.println("start >>> : " + start); 		
		System.out.println("start >>> : " 
							+ new SimpleDateFormat ("yyyy년 MM월dd일 HH시mm분ss초").format(start));
		System.out.println("start >>> : " 
							+ new SimpleDateFormat ("HH시mm분ss초").format(start));	
		System.out.println("start >>> : " 
							+ new SimpleDateFormat ("ss초").format(start));	
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("end >>> : " + end);
		System.out.println("end >>> : " 
				+ new SimpleDateFormat ("yyyy년 MM월dd일 HH시mm분ss초").format(end));

		
		long idle_second = (end - start)/1000;
		long idle_minute = (end - start)/(1000 * 60);
		long idle_hour = (end - start)/(1000 * 60 * 60);
		System.out.println("실행시간 >>> : " + idle_second + "초");
		System.out.println("실행시간 >>> : " + idle_minute + "분");
		System.out.println("실행시간 >>> : " + idle_hour + "시");
	}
}
