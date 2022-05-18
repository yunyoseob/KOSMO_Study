<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN FORM</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#kmid").attr('placeholder', '아이디 ');
		$("#kmpw").attr('placeholder', '비밀번호 ');
		
		$("#loginBtn").click(function(){
			console.log("loginBtn >>> : ");
			
			$('#loginForm').attr({
				'action':"kosmoLoginCheck.h",
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
	});
	
</script>
<style type="text/css">
	
	.div1{
		background: cyan;
		border: 1px solid red;
		width: 300px;
		height: 300px;
		margin: 100px auto;	
	}
		
</style>
</head>
<body>
<div class="div1">
<h1 align="center">Login Test</h1>
<hr>
<form name="loginForm" id="loginForm">
<table border="1" align="center">
<tr>
<td><input type="text" name="kmid" id="kmid" style="width:200px;"></td>
</tr>
<tr>
<td><input type="password" name="kmpw" id="kmpw" style="width:200px;"></td>
</tr>
<tr>
<td>
<button type="button" id="loginBtn" style="width:208px; background-color: yellow;">로그인</button>
</td>
</tr>
<tr>
<td align="right">
<a href="#idFindForm.h"><font size="2">아이디찾기</font></a> | 
<a href="#pwFindForm.h"><font size="2">비밀번호찾기<font></a>
</td>
</tr>
</table> 
</form>
</div>
</body>
</html>