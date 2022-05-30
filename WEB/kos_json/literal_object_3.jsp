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

	var keywordLank = {
		"r1" : {"k": "HTML5", "s": "+", "v" : 178}
       ,"r2" : {"k": "CSS3", "s": "new", "v" : 150}
       ,"r3" : {"k": "jQuery", "s": "+", "v" : 135}
	}

	var tag = "<h1>인기 검색어 순위</h1><ul>";
	tag += "<li>"+ keywordLank.r1.k + "("
			     + keywordLank.r1.s 
			     + keywordLank.r1.v + ")";
	tag += "<li>"+ keywordLank.r2.k + "("
     			 + keywordLank.r2.s 
     			 + keywordLank.r2.v + ")";
	tag += "<li>"+ keywordLank.r3.k + "("
     			 + keywordLank.r3.s 
    			 + keywordLank.r3.v + ")";
	
	document.write(tag);
</script>
</head>
<body>
</body>
</html>