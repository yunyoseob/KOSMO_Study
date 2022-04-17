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
<title>FILE UPLOAD JSP</title>
<!-- CDN -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">	
	
	$(document).ready(function(){
				
		// fnumChk
		$(document).on("click", "#fnumChk", function(){
			
			alert("fnumChk >>> : ");		
			
			if($(this).prop('checked')){			 				
				$('.fnumChk').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
		
		
		//  U
		$(document).on("click", "#U", function(){
			// alert("U >>> : ");	
			
			if ($('.fnumChk:checked').length == 0){
				alert("이미지 하나를 선택하세요!!");
				return;
			}
		});
		
		//  U
		$(document).on("click", "#U", function(){	
			if ($('.fnumChk:checked').length == 0){
				alert("이미지 하나 하나를 선택하세요!!");
				return;
			}
			$("#checkForm").attr({ 
				"action":"/kosMember/kos_fileupload/fileupload_img.jsp",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"}).submit();
		});
	
	});
</script>
<style type="text/css">

	#circle {border-radius: 50%;}
	
</style>
</head>
<body>
<h3>FILE UPLOAD JSP</h3>
<hr>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("fileupload_3.jsp 페이지 >>> :");

	String filePaths = CommonUtils.TEST_IMG_UPLOAD_PATH;
	int size_limit = CommonUtils.TEST_IMG_FILE_SIZE;
	String encode_type = CommonUtils.TEST_IMG_ENCODE;
	String filename1 = "";
	
	FileUploadUtil fu = new FileUploadUtil();
	boolean bool = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
	
	ArrayList<FileVO> aList = null;
	
	if (bool){
		String name = fu.getParameter("name");
		ArrayList<String> aListFile = fu.getFileNames();
		filename1 = aListFile.get(0);
		
		logger.info("name >>> :" + name);
		logger.info("filename1 >>> :" + filename1);
		
		// 파일 이름 테이블에 적재하기 --------------------
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		conn = KosConnectivity.getConnection();
		String sqls = "INSERT INTO KOS_FILE_IMAGE (FNUM, FNAME, FPATH, INSERTDATE, UPDATEDATE) VALUES (KOS_FILE_IMAGE_SEQ.NEXTVAL, ?, ?, SYSDATE, SYSDATE)";
		logger.info("INSERT >>> :" + sqls);
		pstmt = conn.prepareStatement(sqls);
		
		pstmt.clearParameters();	
		pstmt.setString(1, name);
		pstmt.setString(2, filename1);
		
		nCnt = pstmt.executeUpdate();
		
		if (nCnt > 0) {
			
			Connection conn_s = null;
			PreparedStatement pstmt_s = null;
			ResultSet rsRs_s = null;
			
			conn_s = KosConnectivity.getConnection();
			String sqls_s = "SELECT * FROM KOS_FILE_IMAGE ORDER BY 1";
			logger.info("SELECT >>> :" + sqls_s);
			pstmt_s = conn_s.prepareStatement(sqls_s);
			
			rsRs_s = pstmt_s.executeQuery();
			
			if (rsRs_s !=null){
				
				aList = new ArrayList<FileVO>();
				
				while (rsRs_s.next()){
					FileVO fvo = new FileVO();
					fvo.setFnum(rsRs_s.getString(1));
					fvo.setFname(rsRs_s.getString(2));
					fvo.setFpath(rsRs_s.getString(3));
					aList.add(fvo);
				}	
			}
		}
	}else{
		System.out.println("업로드 실패 !!!");
	}
	
%>
<!-- html img 태그의 src 경로 속성은 웹 경로를 사용한다.  -->	
<form name="checkForm" id="checkForm">
<table border="1">
		<tr>
			<td><input type="checkbox" class="chkAll" name="chkAll" id="chkAll"></td>
			<td>순번</td>
			<td>이름</td>			
			<td>파일</td>
		</tr>

<%
	if (aList !=null && aList.size() > 0){
		
		for (int i=0; i < aList.size(); i++){
			FileVO _fvo = aList.get(i);
%>
		<tr>
			<td>
				<input type="checkbox" class="fnumChk"  name="fnumChk" id="fnumChk" value=<%= _fvo.getFnum() %> >
			</td>	
			<td>
				<%= _fvo.getFnum() %>	
			</td>
			<td>
				<%= _fvo.getFname() %>				
			</td>			
			<td>
				<img id="circle" src="/kosMember/upload/aaaa/<%= _fvo.getFpath() %>" width="50" height="50"><br>				
			</td>
		</tr>

<%			
		}
	}
%>
		<td colspan="5" align="right">
			<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
			<input type="button" value="이미지보기" id="U">								
		</td>
</table>
</form>	
</body>
</html>