<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.kosmo.board.vo.KosmoBoardVO" %> 
<%@ page import="a.b.c.com.kosmo.rboard.vo.KosmoRboardVO" %> 
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		//rkbcontent 길이 제한 200byte
		$("#rkbcontent").keyup(function(){
			cut_200(this);
		});
		
		// 댓글 전체 불러오기 
		selectAll();
		
		// 댓글 등록
		$(document).on("click", "#insertBtn", function(){
			console.log("insertBtn >>> : ");
			
			let insertURL = "kosmoRboardInsert.h";		
			let method = "POST";
			let dataParam = {
				kbnum: $("#kbnum").val(),
				ksbname: $("#rkbname").val(),
				ksbcontent: $("#rskcontent").val(),
			};
			dataParam = $("#rboardForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: insertURL,
				type: method,
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				alert("resData >>> : " + resData);	
				if ("GOOD" == resData){
					// 입력데이터 초기화 함수호출 
					rboardFormData();
					location.reload();
				}
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
			
			selectAll();
		});
		
		// 댓글 삭제		
		$(document).on("click", ".deleteBtn", function(){
			console.log("D >>> : ");
			
			var rkbnumV = $(this).parents("li").attr("dataNum");
			alert("rkbnumV >>> : " + rkbnumV);
			var target = $(this).parents(".rbmemoItem");
			console.log("target >>> : " + target);
			
			let deleteURL = "kosmoRboardDelete.h";
			let method = "POST";
			let dataParam = {
				rkbnum: $('#rkbnum').val(rkbnumV),				
			};		
			dataParam = $("#rboardForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: deleteURL,
				type: method,
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){					
				console.log("resData >>> : " + resData);				
				if ("GOOD" == resData){
					alert("댓글이 삭제되었습니다.");
					target.remove();
				}	
			}
			function whenError(e){
				console.log("e >>> : " + e.responseText);
			}
		});
	});
	
	
	// 게시글 번호로 댓글 전체조회 ============================================
	function selectAll(){
					
		console.log("SALL >>> : ");
		
		let selectAllURL = "kosmoRboardSelectAll.h";
		let method = "POST";
		let dataParam = {
			kbnum: $("#kbnum").val(),				
		};		
		dataParam = $("#rboardForm").serialize();
		console.log("dataParam >>> : " + dataParam);
		
		$.ajax({
			url: selectAllURL,
			type: method,
			data: dataParam,
			success: whenSuccess,
			error: whenError
		});
		
		function whenSuccess(resData){	
			console.log("resData >>> : " + resData);
			console.log("whenSuccess kosmoRboardSelectAll resData >>> : " + resData);
			
			if(isEmpty(resData)){
				return false;
			}
			
			let v = resData.split("&");
			for(let i=0; i < v.length; i++){
				console.log(v[i]);
				let vv = v[i].split(",");
				let j=0
				for (; j < vv.length-1; j++){
					console.log("vv[0] >>> : " + vv[0]);
					console.log("vv[1] >>> : " + vv[1]);
					console.log("vv[2] >>> : " + vv[2]);
					console.log("vv[3] >>> : " + vv[3]);					
				}
				addNewItem(vv[0], vv[1], vv[2], vv[3]);
			}
		}
		function whenError(e){
			console.log("e >>> : " + e.responseText);
		}	
	}
	// 게시글 번호로 댓글 전체조회 ============================================
		
	//새로운 글 화면에 추가	=================================================
	function addNewItem(num, writer, content, datetime){
		
		//데이터 체크
		if(isEmpty(num)) return false;
		
		// 새로운 글이 추가될 li태그 
		var newLi = $("<li>");
		newLi.attr("dataNum", num);
		newLi.addClass("rbmemoItem");
		// 작성자 정보가 지정될 <p> 태그 
		var writerP = $("<p>");
		writerP.addClass("writer");
		// 작성자 정보의 이름 
		var nameSpan = $("<span>");
		nameSpan.addClass("name");
		nameSpan.html(decodeURIComponent(writer) + "님");
		// 작성일시 
		var dateSpan = $("<span>");
		dateSpan.html(" / " + datetime + " ");
		// 삭제 버튼 
		var delInput = $("<input>");
		delInput.attr({"type":"button", "value":"삭제하기"});
		delInput.addClass("deleteBtn");
		// 내용
		var contentP = $("<p>");
		contentP.html(decodeURIComponent(content));
		
		// 조립하기
		writerP.append(nameSpan).append(dateSpan).append(delInput);
		newLi.append(writerP).append(contentP);
		$("#rboardlist").append(newLi);
	}
	// 새로운 글 화면에 추가	=================================================
	
	// 댓글 길이 체크  ========================================================
	//한글 포함 문자열 길이
	function getTextLength(s){
		var len = 0;
		for(var i=0; i < s.length; i++){
			if(escape(s.charAt(i)).length == 6){
				len++;
			}
			len++;
		}
		return len;
	}
	function cut_200(obj){
		var t = $(obj).val();
		var l = t.length;
		while(getTextLength(t) > 200){
			l--;
			t= t.substring(0, l);
		}
		$(obj).val(t);
		$('.bytes').text(getTextLength(t));
	}
	// 댓글 길이 체크  ========================================================
	
	//댓글 등록 후 입력창 초기화
	function rboardFormData(){
		$("#rkbname").val("");
		$("#rkbcontent").val("");
	}
	
	//데이터 체크
	function isEmpty(val){
		if(typeof val=="undefined" || val==null || val==""){
			return true;
		}else{
			return false;
		}
	}

</script>
</head>
<body>
<h3>댓글</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("kosmoRboardForm.jsp 페이지 >>> : ");

	String kbnum = request.getParameter("kbnum");
	logger.info("kosmoRboardForm.jsp kbnum >>> : " + kbnum);
%>
<div id="rbwriterdiv">
<form name="rboardForm" id="rboardForm">
<table>
<tr>
	<td>작성자</td>
	<td>
		<input type="text" name="rkbname" id="rkbname"/>
		<input type="hidden" name="kbnum" id="kbnum" value="<%=kbnum%>">
		<input type="hidden" name="rkbnum" id="rkbnum">
	    <input type="button" value="저장하기" id="insertBtn">
	</td>
</tr>
<tr>
	<td>덧글 내용</td>
	<td>
		<textarea name="rkbcontent" id="rkbcontent" rows="5" cols="50" style="resize: none"></textarea>	
		<div><span class="bytes">0</span>bytes</div>
	</td>	
</tr>
</table>
<hr>
<ul name="rboardlist" id="rboardlist">
	<!-- 여기에 동적 생성 요소가 들어온다. -->
</ul>
</form>
</div>
</body>
</html>