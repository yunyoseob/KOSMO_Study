<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ID CHECK</h3>
<hr>
<%
	String mpw = request.getParameter("mpw");
	String ISUD_TYPE = request.getParameter("ISUD_TYPE");
	
	String sVal = "";
	
	if ("PWCHECK".equals(ISUD_TYPE)){
		
		if ("test00".equals(mpw)){
			sVal = "PW_GOOD";	
		}
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= sVal %></result>	
</login>
</body>
</html>