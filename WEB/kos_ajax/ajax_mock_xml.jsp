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
		
		$(document).on('click', '#btn', function(){
			
			alert(">>");
			
			let urlV = 'ajax_mock_dataset.xml';
			let dtV = "xml";
			$.ajax({
				url: urlV,
				dataType: dtV,
				
				success: function(data){
					
					var $data = $(data).find("record");
					
					if ($data.length > 0) {
						var dataTable = $("<table border='1' />");
						
						$.each($data, function(i, item){
							
							var $id 		= $(item).find("id").text();
							var $first_name = $(item).find("first_name").text();
							var $last_name 	= $(item).find("last_name").text();
							var $email 		= $(item).find("email").text();
							var $gender 	= $(item).find("gender").text();
							var $ip_address = $(item).find("ip_address").text();
							
							var row = $("<tr />").append(
														  $('<td />').text($id),
														  $('<td />').text($first_name),
														  $('<td />').text($last_name),
														  $('<td />').text($email),
														  $('<td />').text($gender),	
														  $('<td />').text($ip_address)	
														);
							
							dataTable.append(row);
						});
						
						$('.wrap').append(dataTable);
					}
				}
			});
		});
	});
	
</script>
</head>
<body>
<h3>mockaroo.com MOCK_DATA XML </h3>
<hr>
<button type="button" id="btn">xml 데이터</button>
<div class="wrap"></div>
</body>
</html>