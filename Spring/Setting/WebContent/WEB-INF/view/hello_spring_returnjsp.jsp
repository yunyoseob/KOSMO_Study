<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3></h3>
<hr>
\${msg }-->${msg }<br>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	logger.info("hello_spring_return.jsp 페이지 시작 ~!!");
	
	String msgV=String.valueOf(request.getAttribute("msg"));
	logger.info("msgV >>> : "+msgV);
	out.println("msgV >>> : "+msgV);	
%>
</body>
</html>