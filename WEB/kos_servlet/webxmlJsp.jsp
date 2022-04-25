<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>webxmlJsp.jsp</h3>
<hr>
<%
	Object obj = request.getAttribute("aList");
	if (obj == null) return;
	
	ArrayList<String> aList = (ArrayList<String>)obj;
	System.out.println(aList);
	String mid = aList.get(0);
	String mpw = aList.get(1);
	String s = "";
	
	for (int i=0; i < aList.size(); i++){
		System.out.println("aList.get(" + i + ") >>> : " + aList.get(i));
		s += aList.get(i) +",";
	}
	pageContext.setAttribute("mid", mid);
	pageContext.setAttribute("mpw", mpw);
	pageContext.setAttribute("s", s);
%>
&lt;%= mid %&gt; --> <%= mid %><br>
&lt;%= mpw %&gt; --> <%= mpw %><br>
&lt;%= s %&gt; --> <%= s %><br>
\${mid } --> ${mid }<br>
\${mpw } --> ${mpw }<br>
\${s } --> ${s }<br>
\${aList.get(0) } --> ${aList.get(0) }<br>
\${aList.get(1) } --> ${aList.get(1) }<br>
</body>
</html>
</body>
</html>