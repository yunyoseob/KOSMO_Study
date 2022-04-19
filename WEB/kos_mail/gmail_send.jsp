<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!-- mail 객체 import  -->    
<%@ page import="a.b.c.test.mail.GmailSend"%>

<%@ page import="a.b.c.test.mail.GmailVO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GMAIL SEND</title>
</head>
<body>
<h3>GMAIL SEND</h3>
<hr>

<%
	String mailsubject = request.getParameter("mailsubject");
	String sendmail = request.getParameter("sendmail");
	String mailpw = request.getParameter("mailpw");
	String resivemail = request.getParameter("resivemail");
	String sendmsg = request.getParameter("sendmsg");
	
	System.out.println("mailsubject >>> : " + mailsubject);
	System.out.println("sendmail >>> : " + sendmail);
	System.out.println("mailpw >>> : " + mailpw);
	System.out.println("resivemail >>> : " + resivemail);
	System.out.println("sendmsg >>> : " + sendmsg);
	
	GmailVO gvo = null;
	gvo = new GmailVO();
	gvo.setMailsubject(mailsubject);
	gvo.setSendmail(sendmail);
	gvo.setMailpw(mailpw);
	gvo.setResivemail(resivemail);
	gvo.setSendmsg(sendmsg);
	
	GmailSend gms = new GmailSend();
	gms.gmaillSend(gvo);
%>
</body>
</html>