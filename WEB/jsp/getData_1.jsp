<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getData_1 jsp</title>
</head>
<body>
<h3>getData_1 jsp</h3>
<hr>

<%	
	// java.servlet.http 
	// Interface ServletRequest
	// Subinterfaces : HttpServletRequest
	// java.lang.String : 	getParameter(java.lang.String name)
	// Returns the value of a request parameter as a String, or null 
	// if the parameter does not exist.
	String mname = request.getParameter("mname");
	String maddr = request.getParameter("maddr");
	
	System.out.println("mname >>> : " + mname);
	// 이클립스 콘솔창 :: mname >>> : 바이
	System.out.println("maddr >>> : " + maddr);
	// 이클립스 콘솔창 :: maddr >>> : 부산
%>
	<%= "이름 : "+mname %><br>
	<!-- 화면 출력 결과 :: 이름 : 바이 -->
	<%= "주소 : "+maddr %>
	<!-- 화면 출력 결과 :: 주소 : 부산 -->
	<hr>
	<a href="https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html">Servlet 3.1 - Apache Tomcat 8.0.53 API 보기</a>
</body>
</html>