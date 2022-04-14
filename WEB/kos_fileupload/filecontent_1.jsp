<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.File" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Content-type 분기</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	/*
	GET방식일 때 : Query String Parameters
	POST방식일 때 : Form Data
	*/
	
	String getMethod = request.getMethod();
	System.out.println("getMethod >>> : " + getMethod);
	out.println("getMethod >>> : " + getMethod + "<br>");
	// GET방식일 때 : getMethod >>> : GET
	// POST방식일 때 : getMethod >>> : POST
	
	String name = request.getParameter("name");
	String fileupload = request.getParameter("fileupload");
		
	System.out.println("name >>> : " + name);
	System.out.println("fileupload >>> : " + fileupload);

	out.println("name >>> : " + name + "<br>");
	// GET방식일 때 : name >>> : 집에가고싶다
	// POST방식일 때 : name >>> : 집에가고싶다
	out.println("fileupload >>> : " + fileupload + "<br>");
	// GET방식일 때 : fileupload >>> : photo.jpg
	// POST방식 일 때 ; fileupload >>> : photo.jpg
%>	
</body>
</html>