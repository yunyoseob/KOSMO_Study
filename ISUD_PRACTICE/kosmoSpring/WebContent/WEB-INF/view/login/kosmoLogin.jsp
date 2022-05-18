<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="a.b.c.com.kosmo.mem.vo.KosmoMemberVO"%>  
<%@page import="java.util.List"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Login Session Testing :: LOGIN SUCCESS</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listLogin");
	if (obj == null) return;
	
	List<KosmoMemberVO> list = (List<KosmoMemberVO>)obj;
	int nCnt = list.size();
	
	if (nCnt == 1){
		String kmid = list.get(0).getKmid();
%>
		<script>
			alert("<%= kmid %> 님 로그인 성공");
		</script>
		<div>
  			<a href="logout.h?kmid=<%= kmid %>">로그아웃 하기</a>
		</div>
<% 		
	}
%>
</body>
</html>