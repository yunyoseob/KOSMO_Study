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
<h3>spring_hello_return.jsp</h3>
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("spring_hello_return.jsp >>> : ");

	String mgsV = (String)request.getAttribute("msg");
	logger.info("mgsV >>> : " + mgsV);
	out.println("mgsV >>> : " + mgsV);
%><br>
\${msg } --> ${msg }<br>
</body>
</html>