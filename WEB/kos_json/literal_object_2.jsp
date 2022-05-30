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

	function initCompany(){
		var company = {
						"name":"(주)은비컴퍼티"
					   ,"since": 2022
					   ,"department": ["기획팀","영업팀","디자인팀","개발팀"]
					   ,"biz": ["소프트웨어개발팀","통신판매업","위치정보서비스"]
					  };
		
		alert(company);
		document.getElementById("name").innerHTML = company.name;
		document.getElementById("since").innerHTML = company.since;
		
		var deptLi = "";
		for (var i=0; i < company.department.length; i++ ){
			deptLi += "<li>" + company.department[i] + "</li>";
		}
		document.getElementById("department").innerHTML = deptLi;
		
		var bizLi = "";
		for (var i=0; i < company.biz.length; i++ ){
			bizLi += "<li>" + company.biz[i] + "</li>";
		}
		document.getElementById("biz").innerHTML = bizLi;
	}
</script>
</head>
<body onload="initCompany()">
<h1 id="name"></h1>
<p>
<strong>설립년도 : </strong><span id="since"></span>
</p>
<h2>주요 사업 부서</h2>
<ul id="department"></ul>
<h2>주요 사업 분야</h2>
<ul id="biz"></ul>	
</body>
</html>