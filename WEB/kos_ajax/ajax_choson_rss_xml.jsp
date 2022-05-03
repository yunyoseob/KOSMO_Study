<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>
<%@ page import = "java.io.File" %>
<%@ page import = "java.io.FileWriter" %>

<%	
	String strLine = "";
	try {
		String strUrl = "https://myhome.chosun.com/rss/www_section_rss.xml";
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader((new URL(strUrl))
			.openConnection().getInputStream(),"UTF-8"));

		
		String filePath = "C:\\00.KOSMO\\30.Web\\el_web_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosMember\\kos_ajax";
		String fileName = "ajax_chosun_rss.xml";
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