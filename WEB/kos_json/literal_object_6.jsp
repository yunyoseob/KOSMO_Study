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
	
</script>
</head>
<body>
<h3>
JSON.stringify() 메소드는 인수로 전달받은<br> 
자바스크립트 객체를 문자열로 변환하여 반환한다.
</h3>
<hr>
<p id="json"></p>
<script>
	//자바스크립트 객체
	var dog = {name: "식빵", family: "웰시코기", age: 1, weight: 2.14};	
	
	var data = JSON.stringify(dog);	// 자바스크립트 객체를 문자열로 변환함.
	document.getElementById("json").innerHTML = data;
</script>
<p><p>

<h3>
JSON.parse() 메소드는 JSON.stringify() 메소드와는<br> 
반대로 인수로 전달받은 문자열을 자바스크립트 객체로 변환하여 반환합니다.
</h3>
<hr>
<p id="json1"></p>
<script>
	// JSON 형식의 문자열
	var data1 = '{"name": "식빵", "family": "웰시코기", "age": 1, "weight": 2.14}';
	
	var dog1 = JSON.parse(data1);	// JSON 형식의 문자열을 자바스크립트 객체로 변환함.
	document.getElementById("json1").innerHTML = dog1 + "<br>";
	document.getElementById("json1").innerHTML += dog1.name + ", " + dog1.family;
</script>

<h3>
자바스크립트의 toJSON() 메소드는 자바스크립트의 Date 객체의 데이터를 <br>
JSON 형식의 문자열로 변환하여 반환합니다.
</h3>
<hr>
<p id="json2"></p>
<script>
	var date = new Date();		// 자바스크립트 Date 객체
	var str = date.toJSON();	// Date 객체를 JSON 형식의 문자열로 변환함.

	document.getElementById("json2").innerHTML = date + "<br>";
	document.getElementById("json2").innerHTML += str;
</script>
</body>
</html>