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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD JSP</title>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
Context Root 컨텍스트 루트 : /kosMember<br>
pageContext.getServletContext().getRealPath() ==> <br>
C:\00.KOSMO\30.Web\el_web_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("fileupload.jsp 페이지 >>> :");

	String saveDirectory = pageContext.getServletContext().getRealPath("/upload/aaaa/");
	logger.info("saveDirectory >>> : " + saveDirectory);
	out.println("saveDirectory >>> : " + saveDirectory + "<br>");
	
	File saveDir = new File(saveDirectory);
	if (!saveDir.exists()) {
		saveDir.mkdirs();
	}
		
	int maxPostSize = 1024 * 1024 * 5; // 5MB : byte 단위
	String encoding = "UTF-8";
	String filename1 = "";
	String filename2 = "";
	
	try {
		out.println("request 내장형 오브젝트로 받아온 스트림을 <br>" );
		out.println("MultipartRequest 클래스 생성자 매개변수로 바인딩 한다. <br>");
		out.println("MultipartRequest mr = new MultipartRequest(request," + "<br>");
		out.println("이후에는 MultipartRequest 클래스 mr 참조변수를 이용해서 사용한다. <br>");
		
		MultipartRequest mr = new MultipartRequest(  request  
		        									,saveDirectory
											        ,maxPostSize
											        ,encoding
											        ,new DefaultFileRenamePolicy()); 
		logger.info("mr >>> : " + mr + "mr 참조변수가 출력되면 인스턴스가 완료되었다. 파일업로드가 완료 되었다. <br>");
		out.println("mr >>> : " + mr + "mr 참조변수가 출력되면 인스턴스가 완료되었다. 파일업로드가 완료 되었다. <br>");
		
		out.println("mr 참조변수 가지고 서버에 업로드된 파일 정보. <br>");
		
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
	<img src="/kosMember/upload/aaaa/<%= filename1%>" width="30" height="30"><br>
</td>
</tr>
<tr>
<td><%= filename2%></td>
<td>
	 <img src="/kosMember/upload/aaaa/<%= filename2%>" width="30" height="30"><br>
</td>
</tr>
</table>
</body>
</html>
</body>
</html>