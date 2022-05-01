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
<h1>BoardDelete.jsp  페이지 입니다.</h1>
<%
Logger logger = LogManager.getLogger(this.getClass());
logger.info("boardDelete.jsp 진입 >>> : ");

Object obj = request.getAttribute("bool");
if (obj == null)  return;

boolean bool = ((Boolean)obj).booleanValue();

if (bool){
%>
	<script>
			location.href="/kosServlet_YYS/board?isudType=SALL";
	</script>
<%
}
%>	
</body>
</html>