package a.b.c.test.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSend {

	public void gmaillSend(GmailVO gvo) {
		
		System.out.println("gmaillSend mailsubject >>> : " 	+ gvo.getMailsubject());
		System.out.println("gmaillSend sendmail >>> : " 	+ gvo.getSendmail());
		System.out.println("gmaillSend mailpw >>> : " 		+ gvo.getMailpw());
		System.out.println("gmaillSend resivemail >>> "	 	+ gvo.getResivemail());
		System.out.println("gmaillSend sendmsg >>> : " 		+ gvo.getSendmsg());
		
		
		// mail을 처리하는 환경 세팅하기
		Properties prop = System.getProperties();
		
		// 로그인시 TLS를 사용할 것인지 설정 
		// prop.put("mail.smtp.starttls.enable","false");	
		// 이메일 발송을 처리해줄 SMTP 서버
		prop.put("mail.smtp.host","smtp.gmail.com");	
		// SMTP 서버의 인증을 사용한다는 의미
		prop.put("mail.smtp.auth","true");	
		// TLS 포트 번호 587, SSL 포트번호 465
		prop.put("mail.smtp.port","587");

		prop.put("mail.smtp.starttls.required",true);
		prop.put("mail.smtp.starttls.enable",true);		
		prop.put("mail.smtp.port",465);
		
		// prop.put("mail.smtp.socketFactory.class",javax.net.ssl.SSLSocketFactory);
		// prop.put("mail.smtp.socketFactory.fallback",true);
		// prop.put("mail.smtp.socketFactory.port",465);
		
		
		// gmail password check
		Authenticator auth = new GmailAuth(gvo);
		
		// GmailAuth 클래스로 사용자가 인증이되면 메일을 사용할 세션을 생성한다.
		Session session = Session.getDefaultInstance(prop, auth);
		
		// msg 메시지 객체 생성
		MimeMessage msg = new MimeMessage(session);
		
		try {
			// 보내는 날짜 지정
			msg.setSentDate(new Date());
			
			// 발송자
			msg.setFrom(new InternetAddress(gvo.getSendmail(), gvo.getMailsubject()));
			
			// 수신자의 메일을 생성
			// google, naver, daum 등 가능 
			InternetAddress to = new InternetAddress(gvo.getResivemail());	
			
			// Message 클래스의 setRecipient() 함수를 사용하여 수신자를 설정
			// setRecipient() 메소드로 수신자, 참조, 숨은참조 설정 가능
			//  Message.RecipientType.TO : 받는사람
			//  Message.RecipientType.CC : 참조
			//  Message.RecipientType.BCC : 숨은 참조
			msg.setRecipient(Message.RecipientType.TO, to);
			
			// 메일 제목 및 encoding 타입 설정
            msg.setSubject(gvo.getMailsubject(), "UTF-8");
            
            // 메일 내용 및 encoding 타입 설정
            msg.setText(gvo.getSendmsg(), "UTF-8");
            
            // 메일 전송
            Transport.send(msg);
            
        } catch(AddressException ae) {  
            System.out.println("AddressException : " + ae.getMessage());           
        } catch(MessagingException me) {
        	// 메일 계정인증 관련 에러
            System.out.println("MessagingException : " + me.getMessage());
        } catch(UnsupportedEncodingException e) {
        	// 지원되지 않는 인코딩을 사용할 경우 예외 처리 
            System.out.println("UnsupportedEncodingException : " + e.getMessage());			
        }           
    }
}

