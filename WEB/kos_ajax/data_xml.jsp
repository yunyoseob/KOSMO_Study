<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	String id = request.getParameter("id");	
	System.out.println("jqueryIdCheck :: id >>> " + id);	
	
	int idNcnt = 0;	
	boolean bool = false;
	
	if (idNcnt == 0){
		bool = true;
	}else{
	}
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax XML</title>
</head>
<body>
<?xml version='1.0' encoding='UTF-8'?>
	<login>
		<result><%= bool %></result>	
	</login>	
</body>
</html>