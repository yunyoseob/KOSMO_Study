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

	var bbs = {
				"title": "Javascript + jQuery + Ajax"
			   ,"description": "완벽 가이드"
			   ,"total": 4
			   ,"item": 
				   [ 
					 { "no": "공지", "subject": "강의자료 ",		"hit": 4,	"date": "2019.01.29"}
				    ,{ "no": 3,		"subject": "강의자료 ",		"hit": 6,	"date": "2019.02.19"}
				    ,{ "no": 2,		"subject": "강의자료 ",		"hit": 15,	"date": "2019.03.19"}
				    ,{ "no": 1,		"subject": "강의자료 ",		"hit": 19,	"date": "2019.04.19"}
	       		   ]   
    		  };
	
	alert(bbs);
	
	var html = "<h1>" + bbs.title + "</h1>";
		html += "<p>" + bbs.description + "</p>";
		html += "<p>총 게시물 수: " + bbs.total + "</p>";
		html += "<ul>";
		
	for (var i=0; i < bbs.item.length; i++){
		var item = bbs.item[i];
			html += "<li>("
						+ item.no + ")"
						+ item.subject
						+ "(조회수: " 
						+ item.hit
						+ " / 날짜: " 
						+ item.date
					    +")</li>";					
	}
	
	html += "</ul>";
	
	document.write(html);

</script>
</head>
<body>
</body>
</html>