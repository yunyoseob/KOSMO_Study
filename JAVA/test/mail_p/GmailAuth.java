package a.b.c.test.mail_p;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class GmailAuth extends Authenticator {
	PasswordAuthentication pa;
	
	public GmailAuth(GmailVO gvo){
		System.out.println("GmailAuth sendMail >>> : "+gvo.getSendmail());
		System.out.println("GmailAuth sendPw >>> : "+gvo.getMailpw());
		
		// gmail 아이디, gmail 비밀번호		
		pa = new PasswordAuthentication(gvo.getSendmail(), gvo.getMailpw());
		
	}
	
	public PasswordAuthentication getPasswordAuthentication(){
		return pa;
	}
	
}
