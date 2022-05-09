<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>  

<%@ page import="a.b.c.com.vo.FormDataVO" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("autowired_test_get_return.jsp >>> : ");
%>
<h3>autowired_test_get_return</h3>
<hr>
<%

	Object obj = request.getAttribute("list");	
	if (obj == null) return;
		
	List<FormDataVO> list = (List)obj;		
	if (list.size() > 0){
		
		FormDataVO fdvo = list.get(0);
		out.println("fdvo.getDatanum() >>> : " + fdvo.getDatanum() + "<br>");
		out.println("fdvo.getDataid() >>> : " + fdvo.getDataid() + "<br>");
		out.println("fdvo.getDatapw() >>> : " + fdvo.getDatapw() + "<br>");
		out.println("fdvo.getDataname() >>> : " + fdvo.getDataname() + "<br>");
		
		pageContext.setAttribute("aaa", fdvo);
	}	
%>
<p>
<h3>el로 출력하기 </h3>
<hr>
\${aaa.datanum } >>> : ${aaa.datanum }
\${aaa.dataid } >>> : ${aaa.dataid }
\${aaa.datapw } >>> : ${aaa.datapw }
\${aaa.dataname } >>> : ${aaa.dataname }
</body>
</html>