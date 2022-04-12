<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestDispatcher</title>
</head>
<body>
<h3 style="background-color:yellow;">RequestDispatcher.forward :: request_C.jsp</h3>
<hr>
<%
	response.sendRedirect("/kosMember/kos_jsp/request_D_1.jsp");
%>
<h3 style="background-color:yellow;">RequestDispatcher.forward :: request_C.jsp</h3>
</body>
</html>