<%@page import="a.b.c.common.CodeUtil"%>
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
<!-- 디바이스에 최적화된 크기로 출력됨 -->
<meta name="viweport" content="width=device-width, iitail-scale=1">
<title>회원 전체 조회</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%	
	Logger logger = LogManager.getLogger(this.getClass());

	logger.info("memSelectAll.jsp 페이지 >>> : ");

	String searchFilter =  request.getParameter("searchFilter");	
	String keyword =  request.getParameter("keyword");	
	String fromdate =  request.getParameter("fromdate");	
	String todate =  request.getParameter("todate");	

	MemVO mvo = null;
	mvo = new MemVO();
	
	mvo.setSearchFilter(searchFilter);
	mvo.setKeyword(keyword);
	mvo.setFromdate(fromdate);
	mvo.setTodate(todate);
	
	MemSerivce ms = new MemSerivceImpl();
	ArrayList<MemVO> aList = ms.memSelectAll(mvo);
	if (aList == null) return;
	
	int nCnt = aList.size();
	out.println(":::: 전체 조회 건수  " + nCnt + " 건<br>");	
%>
<h3>회원 전체 조회</h3>
<hr>
<form name="memSelectAllForm" id="memSelectAllForm">
<table border="1">
<thead>

<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">순번</td>
	<td class="tt">회원번호</td>
	<td class="tt">이름</td>
	<td class="tt">아이디</td>
	<td class="tt">패스워드</td>
	<td class="tt">핸드폰</td>
	<td class="tt">이메일</td>
	<td class="tt">성별</td>	
	<td class="tt">취미</td>
	<td class="tt">우편번호</td>
	<td class="tt">도로명주소</td>
	<td class="tt">지번주소</td>
	<td class="tt">내용</td>	
	<td class="tt">수정일</td>
</tr>
</thead>
<%	
	String hp = "";
	String email = "";
	String gender = "";
	String hobby = "";
	String addr = "";
	
	for(int i=0; i<nCnt; i++){		
		MemVO _mvo = aList.get(i);
				
		gender = CodeUtil.gender(_mvo.getMgender());			
		hobby = CodeUtil.hobbys(_mvo.getMhobby());		
		addr = _mvo.getMroad().replace("@", " ");
		
		logger.info("gender >>> : " + gender);
		logger.info("hobby >>> : " + hobby);
		logger.info("addr >>> : " + addr);
%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="mnumCheck" name="mnumCheck" value=<%= _mvo.getMnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= _mvo.getMnum() %> </td>
	<td class="tt"><%= _mvo.getMname() %> </td>
	<td class="tt"><%= _mvo.getMid() %> </td>
	<td class="tt"><%= _mvo.getMpw() %> </td>
	<td class="tt"><%= _mvo.getMhp() %> </td>
	<td class="tt"><%= _mvo.getMemail() %> </td>
	<td class="tt"><%= gender %> </td>
	<td class="tt"><%= hobby %> </td>
	<td class="tt"><%= _mvo.getMzone() %> </td>
	<td class="tt"><%= addr %> </td>
	<td class="tt"><%= _mvo.getMjibun() %> </td>
	<td class="tt"><%= _mvo.getMmsg() %> </td>	
	<td class="tt"><%= _mvo.getUpdatedate() %> </td>			
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="20" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="등록" id="I">
		<input type="button" value="조회" id="SALL">
		<input type="button" value="수정" id="U">
		<input type="button" value="삭제" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>