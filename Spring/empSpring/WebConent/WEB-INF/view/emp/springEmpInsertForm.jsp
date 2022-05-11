<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>springEmpInsertForm</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){							
		
		$(document).on("click", "#insertBtn", function(){
			console.log("insertBtn >>> : ");	
							
			$('#springEmpInsert').attr({
				'action':'springEmpInsert.h',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
	});
</script>
</head>
<body>
<h3>springEmpInsertForm.jsp</h3>
<hr>
<form name="springEmpInsert" id="springEmpInsert">
<table border="1" class="align">
	<tr>
		<td colspan="2" class="align">EMP 입력</td>				
	</tr>
	<tr>
		<td class="align">사원번호</td>		
		<td><input type="text" name="empno" id="empno" size="20"></td>
	</tr>
	<tr>
		<td class="align">사원이름</td>
		<td><input type="text" name="ename" id="ename" size="20"></td>
	</tr>
	<tr>
		<td  class="align">입사일</td>.
		<td><input type="text" name="hiredate" id="hiredate" size="20"></td>
	</tr>	
	<tr>
		<td colspan="2" class="align">				
		<input type="button" value="EMP_입력" id="insertBtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>