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
<title>아이디 체크</title>
<script type="text/javascript">

	function sendID(){
		// 부모창 
		window.parent.opener.document.kmemForm.kid.value =
		// 자식창
		document.idform.id.value;
				
		// 자식창을 스스로 닫는다.		
		window.self.close();		
	}
</script>
</head>
<body>
<%
	String _kid =  request.getParameter("kid");	
  	System.out.println("mid >>>> : " + _kid); 
	out.println("_kid >>> : " + _kid);
	
	MemVO mvo = null;
	mvo = new MemVO();
	mvo.setMid(_kid);
  	
  	boolean bool = false;
  	
 	// jdbc 연결 및 sql 사용하기 
 	Connection conn = null;
 	PreparedStatement pstmt = null;
 	ResultSet rsRs = null;
 	int nCnt = 0;

 	conn = KosConnectivity.getConnection();
 	String sqls = "SELECT COUNT(A.MNUM) NCNT FROM KOS_MEMBER A WHERE A.DELETEYN='Y' AND A.MID=?";
 	pstmt = conn.prepareStatement(sqls);
 	
 	pstmt.clearParameters();
 	pstmt.setString(1, mvo.getMid()); 	
 	rsRs = pstmt.executeQuery();
 	
 	if (rsRs !=null){
 		while (rsRs.next()){
 			nCnt = rsRs.getInt(1);
 			// nCnt = rsRs.getInt("NCNT"); // 컬럼 명,  컬럼 명 앨리어스
 		}
 	}
 	
 	if (nCnt == 1){
 		bool = true;
 	}

 	String returnMsg = "";
	String returnKid = "";	
	if (!bool){
		returnMsg = "사용가능한  아이디 입니당 ....";		
		returnKid = _kid;
	}else{
		returnMsg = "사용중인 아이디 입니당 ....";
		returnKid = "";
	}
%>
<form name="idform" method="POST" action="<%= request.getRequestURI()%>">
	<h4> <%= returnMsg %> </h4>
	<%= returnKid %><br>
	
	<input type="hidden" name="id" value="<%= returnKid %>"><br>
	<input type="submit" value="확인" onClick="sendID()">
</form>
</body>
</html>