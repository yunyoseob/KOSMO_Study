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
	
	ParameterBlock pb = new ParameterBlock();
	pb.add(saveDirectory+"/"+filename1);
	RenderedOp rOp = JAI.create("fileload", pb);
	BufferedImage bi = rOp.getAsBufferedImage();
	// 사이즈 조정하기 
	BufferedImage thumb = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics();
	// 사이즈 조정하기
	g.drawImage(bi, 0, 0, 400, 400, null);
	// 변경되는 파일 이름만 바꾸기
	File file = new File(saveDirectory+"/sm_"+filename1);
	ImageIO.write(thumb, "jpg", file);
	
	ParameterBlock pb_1 = new ParameterBlock();
	pb_1.add(saveDirectory+"/"+filename1);
	RenderedOp rOp_1 = JAI.create("fileload", pb_1);
	BufferedImage bi_1 = rOp_1.getAsBufferedImage();
	// 사이즈 조정하기 
	BufferedImage thumb_1 = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
	Graphics2D g_1 = thumb_1.createGraphics();
	// 사이즈 조정하기
	g_1.drawImage(bi_1, 0, 0, 300, 300, null);
	// 변경되는 파일 이름만 바꾸기
	File file_1 = new File(saveDirectory+"/sm_"+filename2);
	ImageIO.write(thumb_1, "jpg", file_1);
%>
<h3>이미지 썸네일</h3>
<hr>
-원본 이미지-<br>
<img src="/kosMember/upload/aaaa/<%= filename1%>"><br>
<img src="/kosMember/upload/aaaa/<%= filename2%>"><br>

</body>
</html>
</body>
</html>
