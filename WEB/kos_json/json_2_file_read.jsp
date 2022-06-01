<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>
<%@ page import = "java.io.File" %>
<%@ page import = "java.io.FileWriter" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%	
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("json_2_file_read.jsp 페이지 >>> : ");

	String strLine = "";
	try {
		// http://localhost:8088/kosMember/kos_json/ju.json
		String strUrl = "http://localhost:8088/kosmoSpring/kos_json/ju.json";
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader((new URL(strUrl))
			.openConnection().getInputStream(),"UTF-8"));

		
		String filePath = "C:\\00.KOSMO108\\30.Web\\el_spring4_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosmoSpring\\kos_json";
		String fileName = "ju_json.json";
		File xmlFile = new File(filePath +"/"+ fileName);

		FileWriter fw = new FileWriter(xmlFile);
		while ((strLine = br.readLine()) != null){
			System.out.println(strLine);
			fw.write(strLine);
		}
						
		fw.flush();
		fw.close();
		
	} catch(Exception e) {		
		throw e;
	}
%>    

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>