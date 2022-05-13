<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(document).on("click", "#kpbtn", function(){
			console.log("kpbtn >>> : ");								
			$('#boardForm').attr({
				'action':'kosmoProductInsert.h',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		});
	});	
</script>
</head>
<body>
<h3>kosmoProductInsertForm.jsp</h3>
<hr>	
<form name="productForm" id="productForm">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">상품등록</td>				
	</tr>
	<tr>
		<td align="center">상품번호</td>		
		<td><input type="text" name="kpnum" id="kpnum" size="20" readonly></td>
	</tr>
	<tr>
		<td  align="center">상품아이디</td>.
		<td><input type="text" name="kpid" id="kpid" size="20"></td>
	</tr>
	<tr>
		<td  align="center">상품이름</td>
		<td><input type="text" name="kpname" id="kpname" size="20"></td>
	</tr>
	<tr>
		<td  align="center">제조사</td>
		<td><input type="text" name="kpcompany" id="kpcompany" size="20"></td>
	</tr>
	<tr>
		<td  align="center">상품이미지</td>
		<td>
		<input type="file" name="kpfile" id="kpfile">
	</td>
	</tr>
	<tr>
		<td  align="center">상품수량</td>
		<td><input type="text" name="kpcnt" id="kpcnt" size="20"></td>
	</tr>
	<tr>
		<td  align="center">상품가격</td>
		<td><input type="text" name="kpprice" id="kpprice" size="20"></td>
	</tr>	
	<tr>
		<td  align="center">상품설명</td>
		<td>
		<textarea name="kpdesc" id="kpdesc" cols="50" rows="10"></textarea>
	</td>
	</tr>	
	<tr>
		<td colspan="2" align="right">				
		<input type="button" value="상품등록" id="kpbtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>