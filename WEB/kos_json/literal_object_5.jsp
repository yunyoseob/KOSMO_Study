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
	var sayHello = {
						 "name": "javaScript"
						,"eng": function(){
									var console = document.getElementById("console");
									console.innerHTML = "Hello " + this.name;
									console.style.color = "#ff0000";
							   }
						,"kor": function(){
									var console = document.getElementById("console");
									console.innerHTML = "안녕하세요 " + this.name;
									console.style.color = "#0000ff";
				  				}	
					}
</script>
</head>
<body>
<h1>리터럴객체  그룹화된 함수 호출</h1>
<input type="button" value="sayEng" onclick="sayHello.eng()" />
<input type="button" value="sayKor" onclick="sayHello.kor()" />
<h1 id="console"></h1></body>
</html>