<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("formdata_post_valueobject_return.jsp >>> : ");
	// FormDataVO formDataVO = new FormDataVO();
%>
<h3>formdata_post_valueobject_return</h3>
<hr>
EL 표현식으로 데이터 추출하기 : <br>
${formDataVO.datanum } <br>
${formDataVO.dataid } <br>
${formDataVO.datapw } <br>
${formDataVO.dataname } <br>
<hr>
EL 표현식 및 객체함수로 데이터 추출하기 : <br>
${formDataVO.getDatanum() } <br>
${formDataVO.getDataid() } <br>
${formDataVO.getDatapw() } <br>
${formDataVO.getDataname() } <br>
</body>
</html>