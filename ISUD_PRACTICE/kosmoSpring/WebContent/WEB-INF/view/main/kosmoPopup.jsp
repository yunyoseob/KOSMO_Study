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
		
			window.self.close();
			let chkVal = $("#chkpop").is(":checked");	
			
			if (chkVal){			
				// Ajax 처리 루틴
				let urlV = "kosmoPopupCookie.h";
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
					alert(resData);
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
<h2>NOTICE POPUP</h2>
<hr>
	<div id="noticePop">
		<form name="noticePopForm" id="noticePopForm">
			<img class="img_1" src="/kosmoSpring/img/img_kakaofriends/08.png"><br>										
			<input type="checkbox" class="chkpop" name="chkpop" id="chkpop" value="01" />
			하루 동안 열지 않음 
			<input type="button" id="popBtn" value="닫기" />
		</form>	
	</div>		

</body>
</html>