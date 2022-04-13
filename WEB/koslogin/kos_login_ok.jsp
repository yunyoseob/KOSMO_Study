<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Date 관련 클래스 import -->    
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOS_LOING_OK JSP</title>
</head>
<body>
<%@ include file="/kos_jsp/include_header.html" %>
<h3>KOS_LOING_OK JSP</h3>
<hr>
<%
	String browser = "";
	String uagent = request.getHeader("User-Agent");
	
	//"-Djava.net.preferIPv4Stack"=true
	// ip : 32bit, 128bit
	String raddr = request.getRemoteAddr();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
	String dtime = sdf.format(new Date()).toString();
	
	System.out.println("userAgent >>> : " + uagent);
	System.out.println("remoteAddr >>> : " + raddr);
	System.out.println("dtime >>> : " + dtime);
	
	if (uagent.indexOf("Chrome") > 0) {
		browser = "Chrome";
%>
		<script>
			var b = '<%= browser %>'
			var r = '<%= raddr %>'
			var d = '<%= dtime %>'
			alert(b + ' : ' + r + ' : ' + d + "\n로그인 성공");
		</script>
<%		
	}
%>
<jsp:include page="/kosmem/memSelectAll.jsp" />

<%@ include file="/kos_jsp/include_footer.html" %>
</body>
</html>








