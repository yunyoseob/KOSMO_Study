<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST TEST</title>
</head>
<body>
<h3>REQUEST TEST</h3>
<hr>
<%

	String context_path = pageContext.getServletContext().getRealPath("/");
	out.println("context_path >>> : " + context_path + "<br>");
	String method = request.getMethod();
	out.println("method >>> : " + method + "<br>");
	String content_type = request.getHeader("Content-Type");
	out.println("content_type >>> : " + content_type + "<br>");
	/*
	context_path >>> :
	C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work
	\.metadata\.plugins\org.eclipse.wst.server.core
	\tmp0\wtpwebapps\kosMember_YYS2\
	
	method >>> : GET
	
	content_type >>> : null
	*/
%>
<form 	action="request_test.jsp"
		method="POST"
		enctype="multipart/form-data">
<input type="submit" value="보내기" />
</form>
</body>
</html>