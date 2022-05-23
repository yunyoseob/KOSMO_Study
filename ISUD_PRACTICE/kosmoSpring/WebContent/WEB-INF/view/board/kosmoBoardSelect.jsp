<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="a.b.c.com.kosmo.board.vo.KosmoBoardVO" %> 
<%@ page import="a.b.c.com.kosmo.common.CodeUtil" %> 
<%@ page import="java.util.List" %> 

<% request.setCharacterEncoding("UTF-8");%> 
<%	
	Object obj = request.getAttribute("listS");
	if (obj == null) return;

	List<KosmoBoardVO> list = (List<KosmoBoardVO>)obj;	
	int nCnt = list.size();
	
	KosmoBoardVO _kbvo = null;
	if (nCnt == 1){
		_kbvo = list.get(0);
	}	
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){	
		
		//  pwBtn : 비밀번호 확인 
		$(document).on("click", "#pwBtn", function(){
			let input_kbpw = prompt('비밀번호를 입려하세요', 'aaa');			
			
			if (input_kbpw.length > 0){
				console.log(input_kbpw);
				
				let pwcheckURL = "kosmoBoardPwCheck.h";
				let reqType = "POST";
				let dataParam = {
					kbnum: $("#kbnum").val(),
					kbpw: input_kbpw,
				};
				//dataParam = $("#boardUpdateForm").serialize();
				console.log("dataParam >>> : " + dataParam);
				
				$.ajax({
					url: pwcheckURL,
					type: reqType,								
					data: dataParam,	            
					success: whenSuccess,
					error: whenError
				});
				
				function whenSuccess(resData){	
					console.log("resData >>> : " + resData);					
					if ("ID_YES" == resData){					
						alert("비밀번호 GOOD.");												
						$("#updateBtn").css('background-color','yellow');	
						if($("#updateBtn").prop("disabled")==true){
							  $("#updateBtn").attr("disabled", false);
						}
					}else if ("ID_NO" == resDataFlag){
						alert("비밀번호 BAD.");
						return;
					};				
				}
				function whenError(e){
					console.log("e >>> : " + e.responseText);
				}
			}						
		});
	
		
		//  insertBtn
		$(document).on("click", "#insertBtn", function(){
			location.href="kosmoBoardInsertForm.h";
		});
		
		// selectBtn
		$(document).on("click", "#selectAllBtn", function(){		
			$("#boardUpdateForm").attr({"method":"GET", "action":"kosmoBoardSelectAll.h"}).submit();		
		});
		
		//  updateBtn
		$(document).on("click", "#updateBtn", function(){
			alert("updateBtn");
			$("#boardUpdateForm").attr({ "method":"GET", "action":"#kosmoBoardUpdate.h"}).submit();
		});
		
	});		
		
</script>
<style type="text/css">
	
	div {		 
		margin: 0 auto; 		
		border:1px solid #6d82f3;
		display:table;
	}			

	td, th {
		 padding: 5px;
	}

	h3 {
		text-align: center;
	}

	.mem {
		text-align: center;
	}
		
</style>
</head>
<body>
<h3>게시글 내용</h3>
<hr>
<div>
<form name="boardUpdateForm" id="boardUpdateForm">
<table border=1>
<td align="center">
<font size="4" style="color:black;"><%= _kbvo.getKbsubject() %></font>
<input type="hidden" name="kmnum" id="kmnum" value="<%= "M202205140001" %>" />
<input type="hidden" name="kbnum" id="kbnum" value="<%= _kbvo.getKbnum() %>" />
</td>
</tr>
<tr>
<td align="left">
<font size="1" style="color:gray;">
최초작성일 : <%= _kbvo.getInsertdate() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
최종수정일 : <%= _kbvo.getUpdatedate() %>
</font>
</td>
</tr>
<tr>
<td align="center"> 
<img src="/kosmoSpring/fileupload/board/<%= _kbvo.getKbfile() %>" border="1" width="380" height="100" alt="image">
</td>
</tr>
<tr>
<td align="center">
<textarea name="kbcontent" id="kbcontent" rows="5" cols="50"><%= _kbvo.getKbcontent() %>					
</textarea>
</td>
</tr>
<tr>
<td align="left">
<font size="1" style="color:gray;">
작성자 : <%=  _kbvo.getKbname() %>
</font>
</td>
</tr>
<!-- 
<tr>
<td>패스워드
<input type="text" name="kbpw" id="kbpw"  />
<button type="button" id="pwBtn">비밀번호</button>
</td>	 	 
 -->
<tr>
<td colspan="2" align="left"> 
<button type="button" id="insertBtn">글쓰기</button>
<button type="button" id="selectAllBtn">글목록</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
<button type="button" id="updateBtn" disabled >수정</button>
<button type="button" id="pwBtn">비밀번호확인</button>
</td>				
</tr>
</table>
</form>
</div>
<p>
<!-- 댓글 처리 하는 루틴  --> 
<jsp:include page="/kosmoRboardForm.h">
	<jsp:param value="<%=_kbvo.getKbnum()%>" name="kbnum"/>
</jsp:include>	
</body>
</html>
