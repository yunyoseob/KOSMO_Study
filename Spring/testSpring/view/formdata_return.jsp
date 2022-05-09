<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.apache.log4j.LogManager" %>  
<%@ page import="org.apache.log4j.Logger" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM DATA</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		// alert("ready >>> : ");
		
		// GET 방식
		$(document).on("click", "#getbtn", function(){
			alert("getbtn >>> : 진입 ");
			
			$("#formData").attr({
				"action":"formdata_get_servlet.hbe",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
		
		// 스프링 GET 방식
		$(document).on("click", "#get_spring_btn", function(){
			alert("get_spring_btn >>> : 진입 ");
			
			$("#formData").attr({
				"action":"formdata_get_spring.hbe",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();				
		});
		
		// POST 방식
		$(document).on("click", "#post_spring_btn", function(){
			alert("post_spring_btn >>> : 진입 ");
			
			$("#formData").attr({
				"action":"formdata_post_spring.hbe",
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();					
		});
		
		// POST 방식
		$(document).on("click", "#post_spring_btn_111", function(){
			alert("post_spring_btn_111 >>> : 진입 ");
			
			$("#formData").attr({
				"action":"formdata_post_valueobject.hbe",
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();			
		});
	})

</script>
</head>
<body>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("formdata_return.jsp >>> : ");
%>
<h3 align="center">FORM DATA</h3>
<hr>
<form name="formData" id="formData">
	<table border="1" align="center">
		<tr>
			<td>회원번호 : </td>
			<td><input type="text" name="datanum" id="datanum"></td>			
		</tr>
		<tr>
			<td>아이디 : </td>
			<td><input type="text" name="dataid" id="dataid"></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="text" name="datapw" id="datapw"></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="dataname" id="dataname"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="getbtn">GET</button>
				<button type="button" id="get_spring_btn">GET SPRING</button>
				<button type="button" id="post_spring_btn">POST SPRING</button>
				<button type="button" id="post_spring_btn_111">POST SPRING 111</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>