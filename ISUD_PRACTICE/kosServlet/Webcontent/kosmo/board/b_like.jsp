<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String count_1 = "409";
	String count_2 = "43";
	String count_3 = "23";
	String count_4 = "15";
	String count_5 = "31";
	String count_6 = "44";

%>
<form>
<table>
<tr>
<td>
	<img src="/kosServlet/img/img_like/1.png">
	<br><span>좋아요</span><br><span><%= count_1 %></span>
</td>
<td>
	<img src="/kosServlet/img/img_like/2.png">	
	<br><span>응원해요</span><br><span><%= count_2 %></span>
</td>
<td>
	<img src="/kosServlet/img/img_like/3.png">	
	<br><span>축하해요</span><br><span><%= count_3 %></span>
</td>
<td>
	<img src="/kosServlet/img/img_like/4.png">	
	<br><span>기대해요</span><br><span><%= count_4 %></span>
</td>
<td>
	<img src="/kosServlet/img/img_like/5.png">	
	<br><span>놀랐어요</span><br><span><%= count_5 %></span>
</td>
<td>
	<img src="/kosServlet/img/img_like/6.png">
	<br><span>슬퍼요</span><br><span><%= count_6 %></span>
</td>

</tr>
</table>
</form>
</body>
</html>