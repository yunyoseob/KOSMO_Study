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
	console.log(">>> : ");
	
	$("#btn").click(function(){
		console.log(">>> : btn.click() OK");
		alert(">>> : btn.click() OK");
		
		var jsonUrl = "/kosmoSpring/kos_json/json_emp.json";
		
		$.ajax({
			url : jsonUrl,
			type: "POST",			
			dataType: "text",
			success: function(data){				
				console.log(data);	
				var v = JSON.stringify(data);	// 자바스크립트 객체를 문자열로 변환함.
				// json_1
				document.getElementById("json_1").innerHTML = v;
				
				
				var vv = JSON.parse(data);	// JSON 형식의 문자열을 자바스크립트 객체로 변환함.
				console.log(vv);
				console.log(vv.length);
				console.log(vv[0]);									
				
				document.getElementById("json_2").innerHTML = vv + "<br>";				
				// json_2
				document.getElementById("json_2").innerHTML 
				 	+= vv[0].EMPNO + ", " 
					 + vv[0].ENAME + ", "
					 + vv[0].JOB + ", "
					 + vv[0].MGR + ", "
					 + vv[0].HIREDATE + ", "
					 + vv[0].SAL + ", "
					 + vv[0].COMM + ", "
					 + vv[0].DEPTNO + "<br>";
				
				// json_3
				for (var i=0; i < vv.length; i++){
					document.getElementById("json_3").innerHTML 
				 	+= vv[i].EMPNO + ", " 
					 + vv[i].ENAME + ", "
					 + vv[i].JOB + ", "
					 + vv[i].MGR + ", "
					 + vv[i].HIREDATE + ", "
					 + vv[i].SAL + ", "
					 + vv[i].COMM + ", "
					 + vv[i].DEPTNO + "<br>";
				}
				
			}
		});
	});
});



</script>
</head>
<body>
<h3>json 파일 보기</h3>
<button type="button" id="btn">json보기</button>
<hr>

json_1
<hr>
<div id="json_1"></div>
<p>
json_2
<hr>
<div id="json_2"></div>
<p>
json_3
<hr>
<div id="json_3"></div>
<p>
</body>
</html>