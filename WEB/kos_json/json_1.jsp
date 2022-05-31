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
		alert(">>");
		$.ajax({
			url: "/kosmoSpring/kos_json/ju.json",
			dataType: "json",
			success: function(resData){
				alert(resData);				
				var t_ju =  $("<table />");
				var row = 	$('<tr />').append(
							$('<td />').text(resData.name),
							$('<td />').text(resData.age),
							$('<td />').text(resData.gender),
							$('<td />').text(resData.visual)
				);
				$('#div_3').append(t_ju).append(row);				
			}
		})
	});
</script>
</head>
<body>
<div id="div_3"></div>
<div id="div_4"></div>
</body>
</html>