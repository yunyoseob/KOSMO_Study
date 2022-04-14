<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.DataInputStream" %>
<%@ page import="java.util.Enumeration" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD JSP</title>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<hr>
<h3>enctype="multipart/form-data"</h3> 
<h3>file 업로드 데이터는 request.getParameter() 받을 수 없다.</h3>
<hr>
<%
	String name = request.getParameter("name");
	String fileupload = request.getParameter("fileupload");
	out.println("name >>> : " + name + "<br>");
	out.println("fileupload >>> : " + fileupload + "<br>");
	out.println("<p>");
%>

<h3>스트림 방식으로 받기</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Enumeration<String> en = request.getHeaderNames();
	out.println("<h4>전송받은 헤더 정보 출력</h4>");
	while (en.hasMoreElements()){
		String headerName = en.nextElement();
		String headerValue = request.getHeader(headerName);
		out.println(headerName+ " : " +headerValue + "<br>");
	}
	
	out.println("<br> <h4>전송받은 데이터 출력 출력</h4>");
	
	ServletInputStream sis = request.getInputStream();	
	DataInputStream dis = new DataInputStream(sis);	
	String line = "";
	
	while ((line = dis.readLine()) !=null){
		out.println(new String(line.getBytes("ISO-8859-1"), "UTF-8") + "<br>");
	}
%>
</body>
</html>