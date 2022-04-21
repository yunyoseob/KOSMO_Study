package a.b.c.test.mail;

public class GmailVO {

	private String mailsubject;
	private String sendmail;
	private String mailpw;
	private String resivemail;
	private String sendmsg;
	
	// 생성자
	public GmailVO() {
		
	}
			
	public GmailVO(String mailsubject, String sendmail, String mailpw, String resivemail, String sendmsg) {
		super();
		this.mailsubject = mailsubject;
		this.sendmail = sendmail;
		this.mailpw = mailpw;
		this.resivemail = resivemail;
		this.sendmsg = sendmsg;
	}
	
	// getter()
	public String getMailsubject() {
		return mailsubject;
	}
	public String getSendmail() {
		return sendmail;
	}
	public String getMailpw() {
		return mailpw;
	}
	public String getResivemail() {
		return resivemail;
	}
	public String getSendmsg() {
		return sendmsg;
	}
	
	// setter()
	public void setMailsubject(String mailsubject) {
		this.mailsubject = mailsubject;
	}
	public void setSendmail(String sendmail) {
		this.sendmail = sendmail;
	}
	public void setMailpw(String mailpw) {
		this.mailpw = mailpw;
	}
	public void setResivemail(String resivemail) {
		this.resivemail = resivemail;
	}
	public void setSendmsg(String sendmsg) {
		this.sendmsg = sendmsg;
	}
	
	
}
