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

<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		// 글쓰기 on(매개변수 3개)
		$(document).on('click', '#insertBtn', function(){
			location.href="/kosServlet/kosmo/board/board.html";
		});
		
		// 글목록 on(매개변수 3개)
		$(document).on("click", "#selectAllBtn", function(){
			location.href="/kosServlet/board?isudType=SALL";
		});
		
		// 수정하기
		$(document).on('click', '#updateBtn', function(){
			alert("updateBtn >>> : ");
			
			$("#boardSelectForm").attr({
				"action":"/kosServlet/board",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}); // end of updateBtn
		
	});

</script>
</head>
<body>
<h3>boardSelect.jsp</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("boardSelect.jsp 진입 >>> : ");

	Object obj = request.getAttribute("aList_select");
	if (obj == null) return;
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	
	if (aList !=null && aList.size() > 0) {
		BoardVO _bvo = aList.get(0);
%>
<form name="boardSelectForm" id="boardSelectForm">
<table>
	<tr>
		<td>글번호</td>
		<td>
			<input type="text" class="bnum" name="bnum" id="bnum" 
				placeholder="글번호" style="width:100px;" value="<%= _bvo.getBnum() %>" readonly/>
		</td>
	</tr>
	<tr>
		<td>글제목</td>
		<td>
			<input type="text" class="bsubject" name="bsubject" id="bsubject" 
				placeholder="글제목" style="width:250px;"  value="<%= _bvo.getBsubject() %>" />
		</td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>
			<input type="text" class="bwriter" name="bwriter" id="bwriter" 
				placeholder="글쓴이" style="width:250px;" value="<%= _bvo.getBwriter() %>" />
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="text" class="bpw" name="bpw" id="bpw" 
				placeholder="비밀번호 8자리" maxlength="8" 
				style="width:100px; background-color:#e6e6e6;"/>
			<input type="button" name="bpwChk" id="bpwChk" value="비밀번호확인">
		</td>
	</tr>
	<tr>
		<td>글내용</td>
		<td>
			<textarea class="bmemo" name="bmemo" id="bmemo" cols="32" rows="5"><%= _bvo.getBmemo() %></textarea>
		</td>
	</tr>
	<tr>
		<td>삭제여부</td>
		<td>
			<input type="text" style="width:100px;"  value="<%= _bvo.getDeleteyn() %>" desubled/>
		</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>
			<input type="text" style="width:100px;"  value="<%= _bvo.getInsertdate() %>" desubled/>
		</td>
	</tr>
	<tr>
		<td>수정일</td>
		<td>
			<input type="text" style="width:100px;"  value="<%= _bvo.getUpdatedate() %>" desubled/>
		</td>
	</tr>
	<tr>		
		<td colspan="2">
			<!-- hidden flag : 히든 플래그 -->
			<input type="hidden" name="isudType" id="isudType" value="UOK"/>	
			<input type="button" id="insertBtn" value="글쓰기" >
			<input type="button" id="selectAllBtn" value="목록" >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
			<input type="button" id="updateBtn" value="수정"/>
		</td>
	</tr>
</table>
</form>
<hr>
<%		
	}
%>
</body>
</html>











