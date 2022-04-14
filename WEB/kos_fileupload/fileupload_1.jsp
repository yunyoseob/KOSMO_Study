<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- cos 파일업로드 라이브러리 객체 import --%>    
<%@ page import="com.oreilly.servlet.MultipartRequest" %>   
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    

<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>

<%@ page import="a.b.c.common.CommonUtils" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD JSP</title>
<style type="text/css">

	#circle {border-radius: 50%;}
	
</style>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("fileupload_1.jsp 페이지 >>> :");

	String saveDirectory = CommonUtils.TEST_IMG_UPLOAD_PATH;
	logger.info("saveDirectory >>> : " + saveDirectory);
	out.println("saveDirectory >>> : " + saveDirectory + "<br>");
	
	int maxPostSize = CommonUtils.TEST_IMG_FILE_SIZE; // 10MB : byte 단위
	String encoding = CommonUtils.TEST_IMG_ENCODE;
	String filename1 = "";
	String filename2 = "";
	
	try {
		
		MultipartRequest mr = new MultipartRequest(  request  
		        									,saveDirectory
											        ,maxPostSize
											        ,encoding
											        ,new DefaultFileRenamePolicy()); 
		// name
		String name = mr.getParameter("name");
		
		// file
		Enumeration<String> files = mr.getFileNames();
		
		String file1 = String.valueOf(files.nextElement());		
		filename1 = mr.getFilesystemName(file1);
		
		String file2 = String.valueOf(files.nextElement());
		filename2 = mr.getFilesystemName(file2);
		
		logger.info("name >>> : " + name);		
		logger.info("filename1 >>> : " + filename1);
		logger.info("filename2 >>> : " + filename2);
		
		out.println("name >>> : " + name + "<br>");		
		out.println("filename1 >>> : " + filename1 + "<br>");		
		out.println("filename2 >>> : " + filename2 + "<br>");
		
	}catch(Exception e){
		logger.info("에러가 >>> : " + e.getMessage());
	}
%>
<h3>File Upload Testing </h3>
<hr>
<!-- html img 태그의 src 경로 속성은 웹 경로를 사용한다.  -->	
<table border="1">
<tr align="center">
<td><%= filename1%></td>
<td>
	<img id="circle" src="/kosMember/upload/aaaa/<%= filename1%>" width="100" height="100"><br>
</td>
</tr>
<tr>
<td><%= filename2%></td>
<td>
	 <img src="/kosMember/upload/aaaa/<%= filename2%>" width="50" height="50"><br>
</td>
</tr>
</table>
</body>
</html>
</body>
</html>