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

	/*
		//체크박스 체크 확인하기 
		function checkOnly(chk){
			// alert(">>> : " + chk);
			var chkObj = document.getElementsByName("bnumChk");
			console.log("chkObj >>> : " + chkObj);
			for (var i=0; i < chkObj.length; i++){
				if (chkObj[i] != chk){
					chkObj[i].checked = false;
				}
			}
		}
		
		// 체크박스 체크 카운트
		function chkInfo(){			
			var obj = document.getElementsByName("bnumChk");
			var nCnt = 0;			
			for(var i=0; i < obj.length; i++){ 
	          	if (obj[i].checked == true){ 
	          		nCnt++;
	          	}		          			            
	        }			
			console.log('nCnt >>> : ' + nCnt);			
			return nCnt;
		}
	*/
	
	$(document).ready(function(){
		
		// 등록하기
		$("#I").on('click', function(){
			location.href="/kosServlet/kosmo/board/board.html";
		});
		
		// 조회하기 
		$("#SALL").on('click', function(){
			location.href="/kosServlet/board?isudType=SALL";
		});
		
		// 체크박스 하나만 체크 되게 하기 bnumChk
		$(document).on('click', '#bnumChk', function(){
			// var b = $(this).prop('checked');
			// console.log("b >>> : " + b);
			// alert("b >>> : " + b);
			if ($(this).prop('checked')){
				$('.bnumChk').prop('checked', false);
				$(this).prop('checked', true);
			}
		});
		
		// 수정하기 
		$(document).on('click', '#U', function(){			
			if ($('.bnumChk:checked').length == 0 ){
				alert("수정할 글번호 하나를 선택하시오 !!!");
				return;
			}
			
			$('#isudType').val('U');
			$('#boardSelectAll').attr({
				"action":"/kosServlet/board",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();			
		});		
	});

</script>
<style type="text/css">

	.tt{
		text-align: center;
	}
	
	a{ text-decoration-line: none;}
</style>
</head>
<body>
<h3>boardSelectAll.jsp</h3>
<hr>
<form name="boardSelectAll" id="boardSelectAll">
<table border="1">
  <tr>
  	<td class="tt">
		<input type="checkbox" class="chkAll" name="chkAll" id="chkAll"/>
	</td>
	<td class="tt">순번</td>
	<td class="tt">글번호</td>
	<td class="tt">글제목</td>
	<td class="tt">글쓴이</td>
	<td class="tt">글내용</td>
	<td class="tt">등록일</td>
  </tr>  
<% request.setCharacterEncoding("UTF-8"); %>  
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("boardSelectAll.jsp 진입 >>> : ");

	Object obj = request.getAttribute("aList_selectALL");
	if (obj == null) return;

	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	logger.info("boardSelectAll.jsp 전체조회 건수 >>> : " + nCnt);
	
	for (int i=0; i < nCnt; i++){
		BoardVO _bvo = aList.get(i);
%>
	<tr>
		<td class="tt">
			<input type="checkbox" class="bnumChk" name="bnumChk" id="bnumChk" value="<%= _bvo.getBnum() %>" />
		</td>
		<td class="tt"><%= i + 1 %></td>
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
			<input type="hidden" name="isudType" id="isudType" value="" />
			<input type="button" value="등록" id="I">
			<input type="button" value="조회" id="SALL">
			<input type="button" value="수정" id="U">
			<input type="button" value="삭제" id="D">			
		</td>
	</tr>	
</table>
</body>
</html>