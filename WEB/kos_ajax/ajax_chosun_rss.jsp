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
		
		$(function(){
			// http://localhost:8088/kosMember/kos_ajax/choson_rss_xml.jsp
			let urlV = "ajax_chosun_rss.xml";
			let dtV = "xml";
			$.ajax({
				url: urlV,
				dataType: dtV,
				success: function(data){
					
					alert("data >>> : " + data);
					console.log("data >>> : " + data);
					
					var $items = $(data).find("item");
					alert("$items >>> : " + $items);
					
					if ($items.length > 0) {
						$items = $items.slice(0, 10);
						var $ulTag = $("<ul />");
						$.each($items, function(i, item_data){
							var $title = $(item_data).find('title').text();
							var $link = $(item_data).find('link').text();
							
							var $aTag = $("<a />").attr({
								"href":$link,
								"target":"_blank"
							}).text($title);
							
							var $liTag = $("<li />").append($aTag);
							
							$ulTag.append($liTag);
						});
						$('.wrap').append($ulTag);
					}
				},
				error: function(e){
					alert(e.responseText);
				}
			});
		});
	});

</script>
</head>
<body>
<h3>조선닷컴 오늘의 주요뉴스 RSS 읽기</h3>
<hr>
<div class="wrap"></div>
</body>
</html>