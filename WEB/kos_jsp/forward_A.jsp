<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORWARD_A</title>
</head>
<body>
<h3>FORWARD_A JSP</h3>
<hr>
<%
	String mid = request.getParameter("mid");;
	String mpw = request.getParameter("mpw");
	out.println("forward_A mid >>> : " + mid + "<br>");
	out.println("forward_A mpw  >>> : " + mpw + "<br>");
	System.out.println("forward_A mid >>> : " + mid);
	System.out.println("forward_A mpw  >>> : " + mpw);
	
	String param_3 = "param_3";
	String param_4 = "param_4";
	
	pageContext.forward("/kos_jsp/forward_B.jsp");
%>
<%--
<jsp:forward page="/kos_jsp/forward_B.jsp" />
--%>
<%-- 
<jsp:forward page="/kos_jsp/forward_B.jsp">
	<jsp:param name="param_1" value="<%= mid %>" />
	<jsp:param name="param_2" value="<%= mpw %>" />
	<jsp:param name="param_3" value="<%= param_3 %>" />
	<jsp:param name="param_4" value="<%= param_4 %>" />
</jsp:forward>
--%>
</body>
</html>