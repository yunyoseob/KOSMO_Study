<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="a.b.c.kos.mem.service.MemSerivce"%>    
<%@page import="a.b.c.kos.mem.service.MemSerivceImpl"%>    
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>
<%@ page import="a.b.c.common.CodeUtil" %>

<%@ page import="java.util.ArrayList" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<h3>회원정보 수정</h3>
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	
	logger.info("memUpdateOk.jsp 페이지 >>> : ");
	
	// 회원번호	
	String mnum = request.getParameter("mnum");
	
	// 이메일
	String memail = request.getParameter("memail");
	String memail1 = request.getParameter("memail1");						
	memail = memail.concat("@").concat(memail1);	

	// 취미 
	String[] hobby = request.getParameterValues("mhobby");
	String mhobby = "";
	for (int i=0; i < hobby.length; i++){
		mhobby += hobby[i] + ",";
	}		

	// 주소 : 우편번호
	String mzone = request.getParameter("mzone");	
	// 주소 : 도로명 주소						
	String mroad = request.getParameter("mroad");
	String mroaddetail = request.getParameter("mroaddetail");						
	mroad = mroad.concat("@").concat(mroaddetail);
	// 주소 : 지번 주소 
	String mjibun = request.getParameter("mjibun");	
	
	// vo 세팅
	MemVO mvo = null;
	mvo = new MemVO();	
	mvo.setMnum(mnum);
	mvo.setMemail(memail);	
	mvo.setMhobby(mhobby);
	mvo.setMzone(mzone);
	mvo.setMroad(mroad);	
	mvo.setMjibun(mjibun);
	
	logger.info("mnum >>> : " + mvo.getMnum());
	logger.info("memail >>> : " + mvo.getMemail());
	logger.info("mhobby >>> : " + mvo.getMhobby());
	logger.info("mzone >>> : " + mvo.getMzone());
	logger.info("mroad >>> : " + mvo.getMroad());
	logger.info("mjibun >>> : " + mvo.getMjibun());
	
	MemSerivce ms = new MemSerivceImpl();
	boolean bool = ms.memUpdate(mvo);		
	if (bool) {
%>
		<script>
			alert("수정 성공");
			location.href="/kosMember/kosmem/memSelectAll.jsp";
		</script>
<%		
	}else{
%>
		<script>
			alert("수정 실패");
			history.go(-1);
		</script>

<%
	}
%>
</body>