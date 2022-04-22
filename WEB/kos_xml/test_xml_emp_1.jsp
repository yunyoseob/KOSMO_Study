<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>

<%@ page import = "a.b.c.test.xml.OracleXmlTest_1" %>
<%

	String strHtml = "";
	String strLine = "";

	try {
		String strUrl = "http://localhost:8088/kosMember/kos_xml/emp.xml";
		BufferedReader br = new BufferedReader(
			new InputStreamReader((new URL(strUrl))
			.openConnection().getInputStream(),"UTF-8"));
		
		while ((strLine = br.readLine()) != null){
			strHtml += strLine;
		}
		
		System.out.println(strHtml);
		br.close();
	} catch(Exception e) {
		throw e;
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML PARSING</title>
<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		var xmlText, xmlParser, xmlDoc;
		
		xmlText = "<%= strHtml %>";
		alert(xmlText);
		
		xmlParser = new DOMParser();
		xmlDoc = xmlParser.parseFromString(xmlText, "text/xml");
		alert(xmlDoc);
		
		$("#parseText").click(function(){
			
			document.getElementById("text").innerHTML = xmlDoc;	
			
			var empno, ename, job, mar, hiredate, sal, comm, deptno			
			
			var nlist = xmlDoc.getElementsByTagName("EMPNO").length;
			
			for(i=0; i < nlist; i++){

				empno = xmlDoc.getElementsByTagName("EMPNO")[i].childNodes[0].nodeValue;
				ename = xmlDoc.getElementsByTagName("ENAME")[i].childNodes[0].nodeValue;
				job = xmlDoc.getElementsByTagName("JOB")[i].childNodes[0].nodeValue;
				mgr = xmlDoc.getElementsByTagName("MGR")[i].childNodes[0].nodeValue;
				hiredate = xmlDoc.getElementsByTagName("HIREDATE")[i].childNodes[0].nodeValue;
				sal = xmlDoc.getElementsByTagName("SAL")[i].childNodes[0].nodeValue;
				comm = xmlDoc.getElementsByTagName("COMM")[i].childNodes[0].nodeValue;
				deptno = xmlDoc.getElementsByTagName("DEPTNO")[i].childNodes[0].nodeValue;
				
				console.log(			empno 
								+ "," + ename
								+ "," + job
								+ "," + mgr
								+ "," + hiredate
								+ "," + sal
								+ "," + comm
								+ "," + deptno);
			}			
		});
		
		$("#parseFind").click(function(){
			$(xmlText).each(function(){
				var empno = $(this).find("EMPNO").text();
				var ename = $(this).find("ENAME").text();
				$("#text").append(empno).append(ename);
			});
			
		});
	});
</script>
</head>
<body>
<h3>XML 데이터 파싱하기</h3>
<hr>
<button id="parseText">DOM Parser로 XML 파싱하기 </button>
<button id="parseFind">find() 함수로 파싱하기 </button> 
<p id="text"></p> 
</body>
</html>