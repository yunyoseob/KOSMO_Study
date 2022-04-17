<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- log4j 관련 객체 import --%> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="a.b.c.common.CommonUtils" %>
<%@ page import="a.b.c.common.FileUploadUtil" %>

<%@ page import="java.util.ArrayList" %>

<!-- 커넥션 클래스 import -->
<%@ page import="a.b.c.common.KosConnectivity" %>

<!-- java.sql.* JDBC 클래스 import -->    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page import="a.b.c.test.vo.FileVO" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILEUPLOAD IMG</title>
<script type="text/javascript">
</script>
<style type="text/css">
	
	.wrap {
		width: 300px;
		height: 100px;
		margin: 100px auto;
	}

	#circle {border-radius: 50%;}
	
</style>
</head>
<body>

<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("fileupload_img.jsp 페이지 >>> :");

	String fnumChk = request.getParameter("fnumChk");
	
	FileVO fvo = null;
	fvo = new FileVO();
	fvo.setFnum(fnumChk);

	Connection conn_s = null;
	PreparedStatement pstmt_s = null;
	ResultSet rsRs_s = null;
	ArrayList<FileVO> aList = null;
	
	conn_s = KosConnectivity.getConnection();
	String sqls_s = "SELECT * FROM KOS_FILE_IMAGE WHERE FNUM = ? ";
	logger.info("SELECT >>> :" + sqls_s);
		
	pstmt_s = conn_s.prepareStatement(sqls_s);
	pstmt_s.clearParameters();	
	pstmt_s.setString(1, fvo.getFnum());
	
	rsRs_s = pstmt_s.executeQuery();
	
	if (rsRs_s !=null){
		
		aList = new ArrayList<FileVO>();
		
		while (rsRs_s.next()){
			FileVO _fvo = new FileVO();
			_fvo.setFnum(rsRs_s.getString(1));
			_fvo.setFname(rsRs_s.getString(2));
			_fvo.setFpath(rsRs_s.getString(3));
			aList.add(_fvo);
		}	
	}
	
	FileVO __fvo = aList.get(0);
	logger.info("__fvo.getFpath() >>> :" + __fvo.getFpath());
	// out.println("__fvo.getFpath() >>> :" + __fvo.getFpath());
%>
<div class="wrap">
	<h3>fileupload_img</h3>
	디비 조회해서 사진 정중앙에 디피하기 
	<hr>
	<img id="circle" src="/kosMember/upload/aaaa/<%= __fvo.getFpath() %>" >
</div>

</body>
</html>