<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="a.b.c.kos.mem.service.MemSerivce"%>    
<%@page import="a.b.c.kos.mem.service.MemSerivceImpl"%>    
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>
<%@ page import="a.b.c.common.ChabunUtil" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 화면</title>
</head>
<body>
<h3>회원 가입</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger = LogManager.getLogger(this.getClass());

	logger.info("memInsert.jsp 페이지 >>> : ");

	//회원번호
	String mnum = ChabunUtil.getMemChabun("d");	
	// 회원이름
	String mname = request.getParameter("mname");	
	// 아이디
	String mid = request.getParameter("mid");	
	// 패스워드
	String mpw = request.getParameter("mpw");	
	// 핸드폰
	String mhp = request.getParameter("mhp");
	String mhp1 = request.getParameter("mhp1");
	String mhp2 = request.getParameter("mhp2");
	mhp = mhp.concat(mhp1).concat(mhp2);
	// 이메일
	String memail = request.getParameter("memail");
	String memail1 = request.getParameter("memail1");						
	memail = memail.concat("@").concat(memail1);	
	// 성별
	String mgender = request.getParameter("mgender");	
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
	// 내소개
	String mmsg = request.getParameter("mmsg");	
	
	MemVO mvo = null;
	mvo = new MemVO();
	mvo.setMnum(mnum);
	mvo.setMname(mname);
	mvo.setMid(mid);
	mvo.setMpw(mpw);
	mvo.setMhp(mhp);
	mvo.setMemail(memail);
	mvo.setMgender(mgender);
	mvo.setMhobby(mhobby);
	mvo.setMzone(mzone);
	mvo.setMroad(mroad);	
	mvo.setMjibun(mjibun);
	mvo.setMmsg(mmsg);
	
	MemSerivce ms = new MemSerivceImpl();
	boolean bool = ms.memInsert(mvo);
	
	if (bool){
%>
		<script>
			alert("회원가입 성공 >>> :");
			location.href="/kosMember/kosmem/memSelectAll.jsp";
		</script>
<%		
	}else{
%>
		<script>
			alert("회원가입 실패 >>> :");
			history.go(-1);
		</script>
<%		
	}
	
%>
</body>
</html>