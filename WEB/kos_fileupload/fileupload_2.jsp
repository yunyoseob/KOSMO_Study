<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="a.b.c.common.CommonUtils" %>
<%@ page import="a.b.c.common.FileUploadUtil" %>

<%@ page import="java.util.ArrayList" %>

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
	logger.info("fileupload_2.jsp 페이지 >>> :");

	String filePaths = CommonUtils.TEST_IMG_UPLOAD_PATH;
	int size_limit = CommonUtils.TEST_IMG_FILE_SIZE;
	String encode_type = CommonUtils.TEST_IMG_ENCODE;
	String filename1 = "";
	
	FileUploadUtil fu = new FileUploadUtil();
	boolean bool = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
	
	
	if (bool){
		String name = fu.getFileName("name");
		ArrayList<String> aListFile = fu.getFileNames();
		filename1 = aListFile.get(0);
	}else{
		System.out.println("업로드 실패 !!!");
	}
	
%>
<!-- html img 태그의 src 경로 속성은 웹 경로를 사용한다.  -->	
<table border="1">
<tr align="center">
<td>
	<img id="circle" src="/kosMember/upload/aaaa/<%= filename1%>" width="100" height="100"><br>
	<%= filename1 %>
</td>
</tr>
</table>
</body>
</html>