<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.com.kosmo.board.vo.BoardVO" %>    
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 디바이스에 최적화된 크기로 출력됨 ------------------------------------->
<meta name="viweport" content="width=device-width, iitail-scale=1">
<!--  jQuery CDN 불러오기 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){	
		//  type="button" id="update_btn" value="수정"
		//  type="button" id="insert_btn" value="글쓰기"
		//  type="button" id="selectAllBtn" value="목록"
		
		// 글쓰기 on(매개변수 3개) :: 글쓰기 버튼
		$(document).on("click", "#insert_btn", function(){
			alert("글쓰기 버튼(insert_btn) 클릭 >>> : ");
			alert("board.html으로 이동 >>> : ");
			location.href="/kosServlet_YYS/kosmo/board/board.html";
		});
		
		// 글목록 on(매개변수 3개) :: 
		$(document).on("click", "#selectAllBtn", function(){
			alert("글목록 버튼(selectAllBtn) 클릭 >>> : ");
			alert("콘트롤러로 이동 >>> : ");
			location.href="/kosServlet_YYS/board?isudType=SALL";
		});
		
		// 수정하기
		$(document).on("click", "#update_btn", function(){
			alert("수정하기(update_btn) 버튼 클릭 >>> : ");
			alert("콘트롤러로 이동 >>> : ");
			$("#f1").attr({
				"action":"/kosServlet_YYS/board",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
		
	});
</script>
</head>
<body>
<h1>boardSelect.jsp 페이지입니다.</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger=LogManager.getLogger(this.getClass()); 

	Object obj=request.getAttribute("aList_select");
	if(obj==null) return;
	
	ArrayList<BoardVO> aList=(ArrayList<BoardVO>) obj;
	logger.info("aList.size() >>> : "+aList.size());
	logger.info("aList.get(0) >>> : "+aList.get(0));
	/*
	BNUM       NOT NULL VARCHAR2(20)   
    BSUBJECT   NOT NULL VARCHAR2(100)  
    BWRITER             VARCHAR2(30)   
    BPW                 VARCHAR2(300)  
    BMEMO               VARCHAR2(2000) 
    DELETEYN   NOT NULL VARCHAR2(1)    
    INSERTDATE          DATE           
    UPDATEDATE          DATE           
	
	*/
	
	
	if(aList!=null && aList.size()>0){
	// 짧게 쓰는 로직 : if(!(aList!=null && aList.size()>0)) return;
%>
<!-- 
글 제목			길이 100
BSUBJECT		VARCHAR2(100)
글쓴이			길이 50
BWRITER		VARCHAR2(30)
글 쓸때 사용한 패스워드	길이 300 8자리 이상 : 단방향 암호화
BPW			VARCHAR2(300)
글 내용			길이 2000자
BMEMO			VARCHAR2(2000)
 -->
<table>
<%
		BoardVO _bvo=aList.get(0);
		logger.info("글번호 >>> : "+_bvo.getBnum());
		logger.info("글제목 >>> : "+_bvo.getBsubject());
		logger.info("글쓴이 >>> : "+_bvo.getBwriter());
		logger.info("글내용 >>> : "+_bvo.getBmemo());
		logger.info("회원여부 >>> : "+_bvo.getDeleteyn());
		logger.info("수정일 >>> : "+_bvo.getUpdatedate());
%>				
<!-- 
 수정이 가능한 목록
  BSUBJECT :: 글 제목
BMEMO    :: 글 내용
 -->	
<form class="f1" id="f1" name="f1">
		<table>
			<!--  글번호 -->
			<tr>
			<td style="background-color:#e6ffe6">글번호(수정불가)</td>
			<td><input style="width:170%;" type="text" class="bnum" id="bnum" name="bnum" required maxlength="100" placeholder="글 번호" value="<%= _bvo.getBnum() %>" readonly></td>
			</tr>		
			<tr>
			<!--  글제목 -->
			<td style="background-color:#e6ffe6">글제목(수정가능)</td>
			<td><input style="width:170%;" type="text" class="bsubject" id="bsubject" name="bsubject" maxlength="30" placeholder="수정할 글제목" value="<%=_bvo.getBsubject() %>"></td>
			</tr>
			<tr>
			<!--  글쓴이 -->
			<td style="background-color:#e6ffe6">글쓴이(수정불가)</td>
			<td><input style="width:170%;" type="text" class="bwriter" id="bwriter" name="bwriter" maxlength="30" placeholder="글쓴이 수정" value="<%=_bvo.getBwriter() %>"></td>
			</tr>	
			<tr>
			<!--  비밀번호 -->
			<td style="background-color:#e6ffe6">비밀번호(수정불가)</td>
			<td><input type="text" style="width:100%; background-color:#e6e6e6;" class="bpw" name="bpw" id="bpw"
				placeholder="비밀번호는 8자리로" maxlength="8" />	
				<input style="width:70%;" type="button" name="bpwChk" id="bpwChk" value="비밀번호확인">
			</td>	
			</tr>
			<tr>
			<!--  글내용 -->
			<td style="background-color:#e6ffe6">글내용(수정가능)</td>
			<td><textarea style="width:170%; height:200%;" class="bmemo" id="bmemo" name="bmemo" maxlength="2000" width="500px" height="500px" value="<%= _bvo.getBmemo() %>" placeholder="수정할 글내용" value="<%= _bvo.getBmemo()  %>"></textarea></td>
			</tr>
			<tr>
			<!--  회원여부 -->
			<td style="background-color:#e6ffe6">회원여부(수정불가)</td>
			<td><input style="width:170%;" type="text" class="deleteyn" id="deleteyn" name="deleteyn" maxlength="30" placeholder="회원여부" value="<%=_bvo.getDeleteyn() %>"></td>
			</tr>
			<tr>
			<!--  등록일 -->
			<td style="background-color:#e6ffe6">등록일(수정불가)</td>
			<td><input style="width:170%;" type="text" style="width:250px;" value="<%= _bvo.getInsertdate() %>"></td>
			</tr>
			<tr>
			<!--  수정일 -->
			<td style="background-color:#e6ffe6">수정일(수정불가)</td>
			<td><input style="width:170%;" type="text" class="updatedate" id="updatedate" name="updatedate" maxlength="30" placeholder="수정일" value="<%=_bvo.getUpdatedate() %>"></td>
			</tr>
			<hr>
			<!-- 버튼 -->
			<input type="hidden" name="isudType" id="isudType" name="isudType" value="UOK" />
			<tr>
			<td><input style="width:170%; background-color:#e6f2ff;" type="button" id="update_btn" value="수정"></td>
			</tr>
			<tr>
			<td><input style="width:170%; background-color:#e6f2ff;" type="button" id="insert_btn" value="글쓰기"></td>
			</tr>
			<tr>
			<td><input style="width:170%; background-color:#e6f2ff;" type="button" id="selectAllBtn" value="목록"></td>
			</tr>
			<tr>
			<td><input style="width:170%; background-color:#e6f2ff;" type="reset"  value="취소"></td>
			</tr>
		</table>
</form>
<%			
	}
%>
</table>
</body>
</html>