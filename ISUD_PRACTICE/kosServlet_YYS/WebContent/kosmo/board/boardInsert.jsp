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
<% request.setCharacterEncoding("UTF-8"); %>
<h1>boardInsert.jsp >>> INSERT 페이지입니당~!!</h1>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("boardInsert.jsp 진입  >>> : ");
	
	Object obj=request.getAttribute("bool");
	if(obj == null) return;
	boolean bool=((Boolean)obj).booleanValue();
	logger.info("bool >>> : "+bool);
	if(bool){
%>
	<script>
		location.href="/kosServlet_YYS/board?isudType=SALL";
	</script>
<%
	}
%>
</body>
</html>