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
			dataType: "text",
			success: function(resData){
				alert("resData >>> : " + resData);
				
				var vv = JSON.parse(resData);
				alert("vv >>> : "+ vv);
				
				var t_ju =  $("<table border='1' />");
				var row = 	$('<tr />').append(
							$('<td />').text(vv.name),
							$('<td />').text(vv.age),
							$('<td />').text(vv.gender),
							$('<td />').text(vv.visual)
				);
				t_ju.append(row);
				$('#div_3').append(t_ju);				
			}
		})
	});
</script>
</head>
<body>
<div id="div_3"></div>
</body>
</html>