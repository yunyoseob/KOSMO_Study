<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager" %>

<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.IOException" %> 

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>   

<% request.setCharacterEncoding("UTF-8"); %>    
<%
	
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("json_3_barChart.jsp 페이지 >>> : ");
	
	Context ct = new InitialContext();			
	DataSource ds = (DataSource) ct.lookup("java:comp/env/jdbc/jndi_spring_orclHBE00");
	Connection conn = ds.getConnection();
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BAR_CHART");
	ResultSet rsRs = stmt.executeQuery();
	
	ResultSetMetaData resultMeta = rsRs.getMetaData();
	int colCount = resultMeta.getColumnCount();
	String jArrStr = "";	
						
	JSONArray jArr = new JSONArray();
	JSONObject jObj = null;
	
	while (rsRs.next()){
		
		jObj = new JSONObject();
		
		for (int i=0; i < colCount; i++){
			String columnName = resultMeta.getColumnName(i+1);
			String dataName = rsRs.getString(i+1);
		
			jObj.put(columnName, dataName);
		}
		
		if (jObj !=null){
			jArr.add(jObj);
			jArrStr = jArr.toString();
		}
	}
	
	String json_file_path = "C:\\00.KOSMO108\\30.Web\\el_spring4_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosmoSpring\\kos_json";
	String jsonFileName = "json_".concat("barchart").concat(".json").toLowerCase();
	logger.info("jsonFileName >>> : " + jsonFileName);
	File jsonFile = new File(json_file_path + "/" + jsonFileName);
	BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile));
	bw.write(jArrStr);
	bw.flush();
	bw.close(); 
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON FILE</title>
</head>
<body>
<h3>DB 데이터 json 파일 만들기</h3>
<hr>
</body>
</html>