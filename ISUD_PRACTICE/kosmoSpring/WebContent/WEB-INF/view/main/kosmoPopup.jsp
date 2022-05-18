<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 팝업</title>
<!-- 뷰포트 : device에 맞게 화면 크기 조정 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$('#popBtn').on('click', function(){
		
			let chkVal = $("#chkpop").is(":checked");	
			
			if (chkVal){			
				// Ajax 처리 루틴
				let urlV = "#/kosMember/kos_script/popup_cookie.jsp";
				let typeV = 'GET';
				let dataV = $("#chkpop").val();
				
				if (chkVal){
					$.ajax({
						url: urlV,
						type: typeV,
						data: { "chkpop": dataV },					
						success : whenSuccess,					
						error : whenError
					});				
				}
				
				function whenSuccess(resData){
					var bool = $(resData).find('result').text();
					console.log("bool >>> : " + bool);
				}				
				function whenError(){
					console.log("에러가 >>> : ");
				}
			}
		});	
	});

</script>
</head>
<body>
<%
	boolean popState = true;
%> 
<h2>NOTICE POPUP</h2>
<hr>
<%
	if (popState){
%>
	<div id="noticePop">
		<form name="noticePopForm" id="noticePopForm">
			<img class="img_1" src="/kosmoSpring/img/img_kakaofriends/08.png"><br>										
			<input type="checkbox" class="chkpop" name="chkpop" id="chkpop" value="01" />
			하루 동안 열지 않음 
			<input type="button" id="popBtn" value="닫기" />
		</form>	
	</div>		
<%		
	}else{
%>
		<%= "공지사항 팝업 없음" %>
<%		
	}
%>

</body>
</html>