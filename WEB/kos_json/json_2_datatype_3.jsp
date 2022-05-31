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
				
				var v = JSON.stringify(resData);
				alert("v >>> : "+ v);
				document.getElementById("div_3").innerHTML = v;
				
				var t_ju =  $("<table border='1' />");
				var row = 	$('<tr />').append(
							$('<td />').text(v.name),
							$('<td />').text(v.age),
							$('<td />').text(v.gender),
							$('<td />').text(v.visual)
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