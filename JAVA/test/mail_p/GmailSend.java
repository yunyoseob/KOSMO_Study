package a.b.c.test.mail_p;

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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GmailSend {
	public void gmailSend(GmailVO gvo){
		Logger logger = LogManager.getLogger(GmailSend.class);
		System.out.println("gmailSend mailsubject >>> : "+gvo.getMailsubject());
		System.out.println("gmailSend sendmail >>> : "+gvo.getSendmail());
		System.out.println("gmailSend mailpw >>> : "+gvo.getMailpw());
		System.out.println("gmailSend resivemail >>> : "+gvo.getResivemail());
		System.out.println("gmailSend sendmsg >>> : "+gvo.getSendmsg());
		
		
		// mail을 처리하는 환경 세팅하기
		Properties prop=System.getProperties();
		
		// 로그인시 TLS를 사용할 것인지 설정
		// prop.put("mail.smtp.startls.enable","false");
		
		// 이메일 발송을 처리해줄 SMTP 서버
		// prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// SMTP 서버의 인증을 사용한다는 의미
		prop.put("mail.smtp.auth","true");
		
		// TLS 포트 번호 587, SSL 포트번호 465
		prop.put("mail.smtp.port","587");
				
		prop.put("mail.smtp.starttls.required",true);
		prop.put("mail.smtp.starttls.enable",true);		
		// prop.put("mail.smtp.port",465);
		
		
		// prop.put("mail.smtp.socketFactory.class",javax.net.ssl.SSLSocketFactory);
		// prop.put("mail.smtp.socketFactory.fallback",true);
		// prop.put("mail.smtp.socketFactory.port",465);
				
		// gmail password check
		Authenticator auth=new GmailAuth(gvo);
		
		// GmailAuth 클래스로 사용자가 인증이되면 메일을 사용할 세션을 생성한다.
		// Session session=Session.getDefaultInstance(prop, auth);
		Session session=Session.getDefaultInstance(prop, auth);
		
		// msg 메시지 객체 생성
		MimeMessage msg=new MimeMessage(session);
		
		try{
			logger.info("1");
			// 보내는 날짜 지정
			msg.setSentDate(new Date());
			logger.info("2");
			
			// 발송자
			msg.setFrom(new InternetAddress(gvo.getSendmail(), gvo.getMailsubject()));
			logger.info("3");
			// 수신자와 메일을 생성
			// google, naver, daum 등 가능
			InternetAddress to=new InternetAddress(gvo.getResivemail());
			logger.info("4");
			// Message 클래스의 setRecipient() 함수를 사용하여 수신자를 설정
			// setRecipient() 메소드로 수신자, 참조, 숨은참조 설정 가능
			//  Message.RecipientType.TO : 받는사람
			//  Message.RecipientType.CC : 참조
			//  Message.RecipientType.BCC : 숨은 참조
			msg.setRecipient(Message.RecipientType.TO, to);
			logger.info("5");
			// 메일 제못 및 encoding 타입 설정
			msg.setSubject(gvo.getMailsubject(), "UTF-8");
			logger.info("6");
			// 메일 내용 및 encoding 타입 설정
			msg.setText(gvo.getSendmsg(), "UTF-8");
			logger.info("7");
			// 메일 전송
			Transport.send(msg);
			logger.info("8");
		}catch(AddressException ae){
			System.out.println("AddressException : "+ae.getMessage());
		}catch(MessagingException me){
			// // 메일 계정인증 관련 에러
			System.out.println("MessagingException : "+me.getMessage());
		}catch(UnsupportedEncodingException e){
			// // 지원되지 않는 인코딩을 사용할 경우 예외 처리 
			System.out.println("UnsupportedEncodingException : "+e.getMessage());
		}
		
	}
	
	
} // end of public class GmailSend
