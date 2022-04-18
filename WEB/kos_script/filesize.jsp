<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 썸네일 객체 import --%>      
<%@ page import="java.awt.Graphics2D"%>
<%@ page import="java.awt.image.renderable.ParameterBlock"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.media.jai.JAI"%>
<%@ page import="javax.media.jai.RenderedOp"%>
<%@ page import="javax.imageio.ImageIO"%>


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
<title>FILE SIZE JSP</title>
</head>
<body>
<h3>FILE SIZE JSP : Thumbnail image : 썸네일 이미지</h3>
<h3>JAI(Java Advanced Imaging) API </h3>
<h2>Thumbnail image 썸네일 이미지 : jai_codec.jar, jai_core.jar </h3> 
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("filesize.jsp 페이지 >>> :");

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
		
		logger.info("name >>> : " + name);		
		logger.info("filename1 >>> : " + filename1);
			
		out.println("name >>> : " + name + "<br>");		
		out.println("filename1 >>> : " + filename1 + "<br>");		
		
	}catch(Exception e){
		logger.info("에러가 >>> : " + e.getMessage());
	}
	
	ParameterBlock pb = new ParameterBlock();
	pb.add(saveDirectory+"/"+filename1);
	RenderedOp rOp = JAI.create("fileload", pb);
	BufferedImage bi = rOp.getAsBufferedImage();
	// 사이즈 조정하기 
	BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics();
	// 사이즈 조정하기
	g.drawImage(bi, 0, 0, 100, 100, null);
	// 변경되는 파일 이름만 바꾸기
	File file = new File(saveDirectory+"/sm_"+filename1);
	ImageIO.write(thumb, "jpg", file);
%>
<h3>이미지 썸네일</h3>
<hr>
-원본 이미지-<br>
<img src="/kosMember/upload/aaaa/<%= filename1%>"><br>
-썸네일 이미지-<br>
<img src="/kosMember/upload/aaaa/sm_<%= filename1%>"><br>
</body>
</html>
</body>
</html>
