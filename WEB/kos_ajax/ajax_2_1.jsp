<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$('#button').click(function(){
			alert(">>>");
			
			let urlV = "data_2.jsp";
			let typeV = "POST";
			let dataV = $('#id').val();
			
			console.log("urlV >>> : " + urlV);
			console.log("typeV >>> : " + typeV);
			console.log("dataV >>> : " + dataV);
			
			$.ajax({
				url : urlV,
				type : typeV,				
				data : {					
					id : dataV,	// data 는 쿼리 스트링 	data_2.jsp?id=값			
				},				
				success : whenSuccess,
				error : whenError
			});
			
			function whenSuccess(resData){
				alert("리턴 데이터 >>> : " + resData);
				$('#ajaxResData').html("화면에 리턴 데이터 출력 : "  + resData);
				console.log("콘솔에 리턴 데이터 출력 : " + resData);
			}			
			function whenError(e){
				alert("error \n" + e);
			}	
		});
	});
</script>
</head>
<body>
<form id="frm">			
	<label>아이디</label>
	<input name="id" id="id">
	<input id="button" type="button" value="버튼">			
</form>
<div id="ajaxResData">리턴 데이터</div>	
</body>
</html>
















