<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 커넥션 클래스 import -->
<%@ page import="a.b.c.common.KosConnectivity" %>

<!-- java.sql.* JDBC 클래스 import -->    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<!-- 깡통 클래스 import -->
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_LOGIN JSP</title>
</head>
<body>
<h3>KOS_LOGIN JSP</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	
	System.out.println("mid >>> : " + mid);
	System.out.println("mpw >>> : " + mpw);
	
	out.println("mid >>> : " + mid);
	out.println("mpw >>> : " + mpw);
	
	MemVO mvo = null;
	mvo = new MemVO();
	mvo.setMid(mid);
	mvo.setMpw(mpw);
%>
<%
	// jdbc 연결 및 sql 사용하기 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rsRs = null;
	int nCnt = 0;

	conn = KosConnectivity.getConnection();
	String sqls = "SELECT COUNT(A.MNUM) NCNT FROM KOS_MEMBER A WHERE A.DELETEYN='Y' AND A.MID=? AND A.MPW=?";
	pstmt = conn.prepareStatement(sqls);
	
	pstmt.clearParameters();
	pstmt.setString(1, mvo.getMid());
	pstmt.setString(2, mvo.getMpw());	
	rsRs = pstmt.executeQuery();
	
	if (rsRs !=null){
		while (rsRs.next()){
			nCnt = rsRs.getInt(1);
			// nCnt = rsRs.getInt("NCNT"); // 컬럼 명,  컬럼 명 앨리어스
		}
	}
	
	if (nCnt == 1){
		
		request.setAttribute("nCnt", new Integer(nCnt));
		RequestDispatcher rd = request.getRequestDispatcher("/koslogin/kos_login_ok.jsp");
		rd.forward(request, response);
		
	}else {
%>
		<script>
			alert("로그인 실패 !!!");
			// history.go(-1);
			location.href="/kosMember/koslogin/kos_login.html";
		</script>
<% 		
	}

%>
</body>
</html>






