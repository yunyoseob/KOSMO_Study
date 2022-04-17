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
<%
	String getMethod = request.getMethod();
	System.out.println("getMethod >>> : " + getMethod);
	out.println("getMethod >>> : " + getMethod + "<br>");
	
	if ("POST".equals(request.getMethod().toUpperCase())) {		
		
		String type = request.getHeader("Content-Type");
		System.out.println("type >>> : " + type);
		out.println("type >>> : " + type + "<br>");
		// content-type : multipart/form-data; boundary=----WebKitFormBoundaryNAIVARJ9koqvONCi
				
		boolean bool = type.startsWith("multipart/form-data");
		System.out.println("bool >>> : " + bool);
		out.println("bool >>> : " + bool + "<br>");
		
		if (type !=null && type.startsWith("multipart/form-data")) {
			System.out.println("파일 업로드 시작 루틴");
			out.println("파일 업로드 시작 루틴");
			
			String saveDirectory  pageContext.getServletContext().getRealPath("/test/testdir/");
			System.out.println("saveDirectory >>> : " + saveDirectory);
			out.println("saveDirectory >>> : " + saveDirectory + "<br>");
			
			File saveDir = new File(saveDirectory);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
		}else{
			System.out.println("multipart/form-data에 오타가 있서요.");
			out.println("multipart/form-data에 오타가 있서요.");
		}
		
	}else{
		System.out.println("파일 업로드는 POST 방식으로 요청해야 합니다.");
		out.println("파일 업로드는 POST 방식으로 요청해야 합니다.");
	}
%>	
</body>
</html>