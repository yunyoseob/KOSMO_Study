<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 체크</title>
<script type="text/javascript">

	function sendID(){
		// 부모창 
		window.parent.opener.document.kmemForm.kid.value=
		// 자식창
		document.idform.id.value;
				
		// 자식창을 스스로 닫는다.		
		window.self.close();		
	}
</script>
</head>
<body>
<%
	String _kid =  request.getParameter("kid");	
  	System.out.println("_kid >>>> : " + _kid);
  	
  	boolean bool = false;
  	
  	if ("1234".equals(_kid)){
  		bool = true;
  	}
  	
	String returnMsg = "";
	String returnKid = "";	
	if (!bool){
		returnMsg = "사용가능한  아이디 입니당 ....";		
		returnKid = _kid;
	}else{
		returnMsg = "사용중인 아이디 입니당 ....";
		returnKid = "";
	}
%>
<form name="idform" method="POST" action="<%= request.getRequestURI()%>">
	<h4> <%= returnMsg %> </h4>
	<%= returnKid %><br>
	
	<input type="hidden" name="id" value="<%= returnKid %>"><br>
	<input type="submit" value="확인" onClick="sendID()">
</form>
</body>
</html>