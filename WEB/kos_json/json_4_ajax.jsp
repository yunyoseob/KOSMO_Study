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
		
		$("#btn").click(function(){
			alert(">>> : btn.click() OK");
			
			var jsonUrl = "/kosmoSpring/kos_json/json_barchart.json";
			
			$.ajax({
				url : jsonUrl,
				type: "POST",			
				dataType: "text",
				success: function(data){									
					var vv = JSON.parse(data);	// JSON 형식의 문자열을 자바스크립트 객체로 변환함.					
					for (var i=0; i < vv.length; i++){
						document.getElementById("json_3").innerHTML 
					 	 += vv[i].YYYY + ", " 
						 + vv[i].SALES + ", "
						 + vv[i].COSTS +  "<br>";
					}
					
				}
			});
		});
	});
</script>
</head>
<body>
<h3>json 파일 보기</h3>
<button type="button" id="btn">json보기</button><br>
<hr>
<div id="json_3"></div>
<p>
</body>
</html>