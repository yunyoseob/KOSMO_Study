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
			//-------------------------------------------------
			/*
			$.ajax({
				url: 요청할 페이지 url 주소 : action,
				type: GET, POST : method,
				data: ?key=value&key=value$key=value,
						
				success: function(resData){}, : resData : 매개변수 : 변수이름은 가변적이다. 	
				error: function(e){}
			});
			*/
			//-------------------------------------------------
			
			$.ajax({
				url : "data_21.jsp",
				type : "POST",				
				data : {					
					id : $('#id').val(),	// data 는 쿼리 스트링 	data_2.jsp?id=값			
				},
				
				success : function (resData){
					alert("리턴 데이터 >>> : " + resData);
					$('#ajaxResData').html("화면에 리턴 데이터 출력 : "  + resData);
					console.log("콘솔에 리턴 데이터 출력 : " + resData);
				},
				error : function (e){
					alert("error \n" + e);
				}	
			});
			
			//-------------------------------------------------
			/*
			$("#frm").attr({
				"action":"data_2.jsp",
				"mehtod":"GET"
			}).submit();
			*/
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
















