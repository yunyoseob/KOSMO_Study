<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- log4 객체 import  --> 
<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
    
<!-- PasswordUtil 객체 import  -->    
<%@ page import="a.b.c.common.PasswordUtil" %> 
<%@ page import="a.b.c.common.EncryptAES" %> 
<%@ page import="a.b.c.common.EncryptSHA" %>  

<!-- mail 객체 import  -->    
<%@ page import="a.b.c.test.mail.GmailSend"%>
<%@ page import="a.b.c.test.mail.GmailVO"%>

<!-- 커넥션 클래스 import -->
<%@ page import="a.b.c.common.KosConnectivity" %>

<!-- java.sql.* JDBC 클래스 import -->    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<!-- 깡통 클래스 import -->
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>
<%@ page import="a.b.c.test.mail.TpwVO" %>

<%@ page import="java.util.ArrayList" %>

<% request.setCharacterEncoding("UTF-8"); %>     
<%
    Logger logger = LogManager.getLogger(this.getClass());
   	logger.info("pwTempSend.jsp 페이지 >>> : ");
   	
   	String mhp = request.getParameter("mhp");
   	String memail = request.getParameter("memail");
   	
   	MemVO mvo = null;
	mvo = new MemVO();
	mvo.setMhp(mhp);
	mvo.setMemail(memail);
   	
   	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rsRs = null;
	int nCnt = 0;
	boolean bool= false;
	
	conn = KosConnectivity.getConnection();
	String sqls = "SELECT COUNT(A.MNUM) NCNT FROM KOS_MEMBER A WHERE A.DELETEYN='Y' AND A.MHP=? AND A.MEMAIL=?";
	pstmt = conn.prepareStatement(sqls);
	
	pstmt.clearParameters();
	pstmt.setString(1, mvo.getMhp());
	pstmt.setString(2, mvo.getMemail());	
	rsRs = pstmt.executeQuery();
	
	if (rsRs !=null){
		while (rsRs.next()){
			nCnt = rsRs.getInt(1);
			// nCnt = rsRs.getInt("NCNT"); // 컬럼 명,  컬럼 명 앨리어스
		}
	}
	
	if (nCnt == 1) bool = true;   	
   	// 임시 비밀번호를 보내기위해 회원 정보에서 핸드폰 과 이메일 확인
   	
   	ArrayList<TpwVO> aList = null;
   	
   	if (bool) {
   		
   		// 임시 패스워드 불러오기 
   		String tempPw = PasswordUtil.randomPW(8);
   		logger.info("tempPw >>> : " + tempPw);
   	
   		//  패스워드 DB에 저장하기 : 암호화 할 것인가 고민해 볼 것 
   		EncryptAES ase = EncryptAES.getInstance();
   		String encryptTempPw = ase.aesEncode(tempPw);
   		logger.info("encryptTempPw >>> : " + encryptTempPw);
   		// 디비에 저장하기 
   		
   		Connection conn_1 = null;
		PreparedStatement pstmt_1 = null;
		int nCnt_1 = 0;
		
		conn_1 = KosConnectivity.getConnection();
		String sqls_1 = "INSERT INTO TEMP_PW (TNUM, THP, TEMAIL, TPW, INSERTDATE) VALUES (TEMP_PWSEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		logger.info("INSERT >>> :" + sqls_1);
		pstmt_1 = conn_1.prepareStatement(sqls_1);
		
		pstmt_1.clearParameters();	
		pstmt_1.setString(1, mvo.getMhp());
		pstmt_1.setString(2, mvo.getMemail());
		pstmt_1.setString(3, encryptTempPw);		
		
		nCnt = pstmt.executeUpdate();
		
		if (nCnt == 0) {
			
			Connection conn_s = null;
			PreparedStatement pstmt_s = null;
			ResultSet rsRs_s = null;
			
			conn_s = KosConnectivity.getConnection();
			String sqls_s = "SELECT * FROM TEMP_PW WHERE THP = ? AND TEMAIL = ?";
			logger.info("SELECT >>> :" + sqls_s);
			pstmt_s = conn_s.prepareStatement(sqls_s);
			
			pstmt_s.clearParameters();	
			pstmt_s.setString(1, mvo.getMhp());
			pstmt_s.setString(2, mvo.getMemail());
			rsRs_s = pstmt_s.executeQuery();
			
			if (rsRs_s !=null){
				
				aList = new ArrayList<TpwVO>();
				
				while (rsRs_s.next()){
					TpwVO tvo = new TpwVO();
					tvo.setThp(rsRs_s.getString(1));
					tvo.setTemail(rsRs_s.getString(2));
					tvo.setTpw(rsRs.getString(3));
					aList.add(tvo);
				}	
			}
		}
   		
		
		String tpw = (String)aList.get(0).getTpw();
   		// 디비에 저장된 암호화된 임시 비밀번호를 복호화 해서 메일 보내기 
   		String decryptTempPw = ase.aesDecode(tpw);
   		logger.info("decryptTempPw >>> : " + decryptTempPw);
   		
   		if (nCnt_1 == 1) {
   			
   			// 메일 보내기
   	   		String mailsubject = "임시 비밀번호 보내기";
   	   		String sendmail = "보내는사람 메일주소";
   	   		String mailpw = "보내는사람 메일주소 비밀번호";
   	   		String resivemail = "받는사람 메일 주소";
   	   		String sendmsg = "임시비밀번호 및 메시지 " + decryptTempPw;
   	   		
   	   		GmailVO gvo = null;
   	   		gvo = new GmailVO();
   	   		gvo.setMailsubject(mailsubject);
   	   		gvo.setSendmail(sendmail);
   	   		gvo.setMailpw(mailpw);
   	   		gvo.setResivemail(resivemail);
   	   		gvo.setSendmsg(sendmsg);
   	   		
   	   		GmailSend gms = new GmailSend();
   	   		gms.gmaillSend(gvo);
   		}    		
   	}
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>pwTempSend</h3>
<hr>
</body>
</html>