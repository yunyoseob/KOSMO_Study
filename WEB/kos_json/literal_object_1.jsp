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

	/*
		JSON : JavaScript Object Notation
		1. 경량의 테이터 교환형식 (xml 보다 경량)
		2. 다른 프로그래밍언어간에 데이터 교환에 사용
		3. jQuery에서는 기본 문법 체계가 JSON 이다.
		4. JSON 자체가 하나의 데이터로 사용
		5. Ajax 에서는 JSON을 통신시 데이터규격으로 사용
			: JSON 데이터를 서버에 데이터를 전송한다. 
			  {"key":"value", "key":"value", .....}
			  QueryString 처럼 보낸다. 
		사용예)
		var literal = {"key":"value", "key":"value", .....};
		var literal = '{"key":"value", "key":"value", .....}';
	*/	

	$(document).ready(function(){
		
		document.body.mydata = { title: '리터럴 객체 ' };
		alert(document.body.mydata.title); 
		
		var ju = {
				"name" : "전건희"
			   ,"age" : 27
			   ,"gender" : "남자"
			   ,"visual" : "멋짐"
		};
		
		alert("ju >>> : " + ju);
		
		$('#div_1_btn').click(function(){
			
			document.getElementById('div_1').innerHTML = ju.name;
			document.getElementById('div_1').innerHTML = ju.age;
			document.getElementById('div_1').innerHTML = ju.gender;
			document.getElementById('div_1').innerHTML = ju.visual;
		});
		
		$('#div_2_btn').on('click', function(){
			
			const aa_1 = document.getElementById('div_2');
			aa_1.innerHTML += ju.name;
			const aa_2 = document.getElementById('div_2');
			aa_2.innerHTML += ju.age;
			const aa_3 = document.getElementById('div_2');
			aa_3.innerHTML += ju.gender;
			const aa_4 = document.getElementById('div_2');
			aa_4.innerHTML += ju.visual;
		});
		
		$(document).on('click', '#div_3_btn', function(){
			
			var t_ju =  $("<table border='1' />");
			var row = 	$('<tr />').append(
						$('<td />').text(ju.name),
						$('<td />').text(ju.age),
						$('<td />').text(ju.gender),
						$('<td />').text(ju.visual)
			);
			$('#div_3').append(t_ju).append(row);
		});
	});

</script>
</head>
<body>

<div id="div_1"></div>
<button id='div_1_btn'>div_1</button><br>

<div id="div_2"></div>
<button id='div_2_btn'>div_2</button><br>

<div id="div_3"></div>
<button id='div_3_btn'>div_3</button><br>
</body>
</html>