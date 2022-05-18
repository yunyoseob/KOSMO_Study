<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="a.b.c.com.kosmo.mem.vo.KosmoMemberVO" %> 
<%@ page import="a.b.c.com.kosmo.common.CodeUtil" %> 
<%@ page import="java.util.List" %> 

<% request.setCharacterEncoding("UTF-8");%> 
<%	
	Object obj = request.getAttribute("listAll");
	List<KosmoMemberVO> list = (List<KosmoMemberVO>)obj;
	
	int nCnt = list.size();
	String nCntS = ":::: 전체 조회 건수  " + nCnt + " 건";	
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/kosmoSpring/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		// kmnum 체크박스 체크 확인하기
		$(document).on("click", "#kmnum", function(){				
			if($(this).prop('checked')){			 			
				$('.kmnum').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
		
		//  I
		$(document).on("click", "#insertBtn", function(){
			location.href="kosmoMemberInsertForm.h";
		});
		
		// SALL
		$(document).on("click", "#selectBtn", function(){		
			$("#memSelectAllForm").attr({"method":"GET", "action":"kosmoMemberSelectAll.h"}).submit();		
		});
				
		//  U
		$(document).on("click", "#updateBtn", function(){	
			if ($('.kmnum:checked').length == 0){
				alert("수정할 글번호 하나를 선택하세요!!");
				return;
			}
			$("#memberList").attr({ "method":"GET","action":"kosmoMemberSelect.h"}).submit();
		});
		//  D
		$(document).on("click", "#deleteBtn", function(){	
			if ($('.kmnum:checked').length == 0){
				alert("삭제할 글번호 하나를 선택하세요!!");
				return;
			}
			$("#memberList").attr({ "method":"GET", "action":"kosmoMemberSelect.h"}).submit();
		});
		
	});	

</script>
<style type="text/css">

	td, th {
		 padding: 5px;
	}

	h3, th {
		text-align: center;
	}
	.tt {
		text-align: center;
	}

</style>
</head>
<body>
<h3>회원목록</h3>
<hr>

<form name="memberList" id="memberList">
<table border="1" align="center">
<thead>
<tr>
<td colspan="9" ><%= nCntS %></td>
</tr>
<tr>
	<th><input type="checkbox" name="chkAll" id="chkAll"></td>
	<th>순번</td>
	<th>회원번호</td>
	<th>아이디</td>
	<th>이름</td>
	<th>핸드폰</td>
	<th>이메일</td>
	<th>주소</td>	
	<th>사진</td>		
</tr>
</thead>
<%
String hp = "";
String addr = "";
for(int i=0; i<nCnt; i++){		
	KosmoMemberVO _kmvo = list.get(i);	
	hp = CodeUtil.hp(_kmvo.getKmhp());
	addr = _kmvo.getKmzone().concat(" " + _kmvo.getKmroad()).concat(" " + _kmvo.getKmroad2());
%>
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="kmnum" name="kmnum" class="kmnum" value=<%= _kmvo.getKmnum() %> >
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= _kmvo.getKmnum() %> </td>
	<td class="tt"><%= _kmvo.getKmid() %> </td>
	<td class="tt"><%= _kmvo.getKmname() %> </td>
	<td class="tt"><%= hp %> </td>	
	<td class="tt"><%= _kmvo.getKmemail() %> </td>
	<td class="tt"><%= addr %> </td>
	<td class="tt"><img src="/kosmoSpring/fileupload/mem/<%= _kmvo.getKmimage() %> " border="1" width="25" height="25" alt="image"></td>				
</tr>	
<%
}//end of for
%>	
<tr>
	<td colspan="9" align="right">				
		<input type="button" value="등록" id="insertBtn">
		<input type="button" value="조회" id="selectBtn">
		<input type="button" value="수정" id="updateBtn">
		<input type="button" value="삭제" id="deleteBtn">									
	</td>
</tr>	
</tbody>	
</table>
</form>	
</body>
</html>