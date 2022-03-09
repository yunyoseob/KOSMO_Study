package a.b.c.ch6;

import java.text.SimpleDateFormat;

public class Exam_Time_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
			System.currentTimeMillis()�� 
			���� �ð��� 1970�� 1�� 1�� 00:00:00 �ÿ��� ���̸� long������ �����Ѵ�.						  
		 */
		
		//���� ���� �ð��� long Ÿ������ ��������
		long start = System.currentTimeMillis();
		System.out.println("start >>> : " + start); 		
		System.out.println("start >>> : " 
							+ new SimpleDateFormat ("yyyy�� MM��dd�� HH��mm��ss��").format(start));
		System.out.println("start >>> : " 
							+ new SimpleDateFormat ("HH��mm��ss��").format(start));	
		System.out.println("start >>> : " 
							+ new SimpleDateFormat ("ss��").format(start));	
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("end >>> : " + end);
		System.out.println("end >>> : " 
				+ new SimpleDateFormat ("yyyy�� MM��dd�� HH��mm��ss��").format(end));

		
		long idle_second = (end - start)/1000;
		long idle_minute = (end - start)/(1000 * 60);
		long idle_hour = (end - start)/(1000 * 60 * 60);
		System.out.println("����ð� >>> : " + idle_second + "��");
		System.out.println("����ð� >>> : " + idle_minute + "��");
		System.out.println("����ð� >>> : " + idle_hour + "��");
	}
}
