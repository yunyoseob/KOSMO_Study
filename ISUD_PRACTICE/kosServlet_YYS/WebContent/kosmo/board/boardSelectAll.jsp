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
<!-- 디바이스에 최적화된 크기로 출력됨 -->
<meta name="viewport" content="width-device-width, initial-scale=1" >
<!--  jQuery CDN 불러오기 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
/*
  // 체크박스 체크 확인하기
  function checkOnly(chk){
	// alert(" >>>> : "+chk);
	console.log("chk >>> : "+chk);
	var chkObj=document.getElementByName("bnumCheck");
	console.log("chkObj >>> : "+chkObj);
	for (var i=0; i<chkObj.length; i++){
		if(chkObj[i]!=chk){
			chkObj[i].checked=false;
		}	
	}
}
 */
	$(document).ready(function(){
		// 등록하기
		$("#I").on("click", function(){
			alert("등록 버튼을 클릭하셨습니다. ");
			alert("board.html으로 이동 >>>> : ");
			location.href="/kosServlet_YYS/kosmo/board/board.html";
		});
		
		// 조회하기
		$("#SALL").on("click", function(){
			alert("조회 버튼을 클릭하셨습니다.");
			alert("콘트롤러로 이동 >>> : ");
			location.href="/kosServlet_YYS/board?isudType=SALL";
		});
		
		// 체크박스 하나만 체크 되게 하기 bnumChk
		/* <input type="checkBox" class="bnumChk" id="bnumChk" name="bnumChk" value="< _bvo.getBnum() %>" /> */
		$(document).on("click", "#bnumChk", function(){
			if($(this).prop("checked")){
				const c=$(this).prop("checked");
				console.log("checked 된 this >>> : "+this);
				console.log("checked 된 this.val >>> : "+$(this).val());
				console.log("checked 된 this.prop >>> : "+c);
				console.log("checked 된 this >>> : "+JSON.stringify(c));
				$(".bnumChk").prop('checked', false);
				$(this).prop('checked', true);
				
			}
		});
		
		// 수정하기
		$("#U").on("click", function(){
			alert("수정 버튼을 클릭하셨습니다.");
			if($('.bnumChk:checked').length==0){
				alert("하나도 체크가 되지 않았습니다. 한 개 이상 체크하세요.");
				
				return;
			}
			$("#boardSelectAll").attr({
				"action":"/kosServlet_YYS/board",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
		
		// 삭제하기
		// <input type="button" value="삭제" id="D">
		$(document).on("click", '#D', function(){
			// <input type="checkBox" class="bnumChk" id="bnumChk" name="bnumChk" value="< _bvo.getBnum() %>" />
			if($('.bnumChk:checked').length==0){
				alert("수정할 글 번호 하나를 선택하시오!!!");
				return;
			}
			alert("콘트롤러로 이동합니다.");
			$("#isudType").val('D');
			$("#boardSelectAll").attr({
				"action":"/kosServlet_YYS/board",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
			
		});
		
	}); // end of $(document).ready(function()
</script>
</head>
<body>
<h1>boardSelectAll.jsp 페이지입니다.</h1>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<!-- 
// String bsubject=request.getParameter("bsubject");
//String bwriter=request.getParameter("bwriter");
// String bpw=request.getParameter("bpw");
//String bmemo=request.getParameter("bmemo");
---------------------------------------------------
글 제목			길이 100
BSUBJECT		VARCHAR2(100)
글쓴이			길이 50
BWRITER		VARCHAR2(30)
글 쓸때 사용한 패스워드	길이 300 8자리 이상 : 단방향 암호화
BPW			VARCHAR2(300)
글 내용			길이 2000자
BMEMO			VARCHAR2(2000)
 -->
<form id="boardSelectAll" name="boardSelectAll">
<table border="1">
	<input type="hidden" id="isudType" name="isudType" value="U" >
	<tr>
	<td class="tt" style="background-color:#e6ffe6">
		<!-- <input type="checkbox" class="chkAll" name="chkAll" id="chkAll"/> -->
	</td>
	<td class="tt" style="background-color:#e6ffe6">순번</td>
	<td class="tt" style="background-color:#e6ffe6">글번호</td>
	<td class="tt" style="background-color:#e6ffe6">글제목</td>
	<td class="tt" style="background-color:#e6ffe6">글쓴이</td>
	<td class="tt" style="background-color:#e6ffe6">글내용</td>
	<td class="tt" style="background-color:#e6ffe6">등록일</td>
	</tr>
<%
	Logger logger=LogManager.getLogger(this.getClass());
	Object obj=request.getAttribute("aList");
	if(obj==null) return;
	
	ArrayList<BoardVO> aList= (ArrayList<BoardVO>) obj;
	int nCnt=aList.size();
	logger.info("nCnt :: aList.size() >>> : "+nCnt);
	
	if (aList!=null && nCnt>0){
		logger.info("aList 출력 로직 >>> : ");
		for(int i=0; i<nCnt; i++){
			BoardVO _bvo=aList.get(i);
%>			
<!-- 
		         BNUM		    
		         BSUBJECT	        
		         BWRITER		        
		         // BPW 보여주면 안 됨 			        
		         BMEMO		        
		         // DELETEYN  보여주면 안 됨       
		         INSERTDATE          
		         // UPDATEDATE   보여줄 필요 X       
 -->
 		<tr>
 		<td class="tt">
 			<input type="checkBox" class="bnumChk" id="bnumChk" name="bnumChk" value="<%= _bvo.getBnum() %>" />
 			<!--  _bvo.getBnum() -->
 		</td>
 		<td class="tt" id="num"><%= i+1 %></td>
		<td class="tt"><%= _bvo.getBnum() %></td>
		<td class="tt"><%= _bvo.getBsubject() %></td>
		<td class="tt"><%= _bvo.getBwriter() %></td>
		<td class="tt"><%= _bvo.getBmemo() %></td>
		<td class="tt"><%= _bvo.getInsertdate() %></td>
		</tr>
<%
		}	
%>
	<tr>
		<td colspan="7" align="right">
			<input type="button" value="등록" id="I">
			<input type="button" value="조회" id="SALL">
			<input type="button" value="수정" id="U">
			<input type="button" value="삭제" id="D">
		</td>
	</tr>
<%
	}
%>
</table>
</form>
</body>
</html>