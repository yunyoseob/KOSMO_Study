<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="a.b.c.com.kosmo.like.vo.KosmoBoardLikeVO" %> 
<%@ page import="a.b.c.com.kosmo.common.CodeUtil" %> 
<%@ page import="a.b.c.com.kosmo.common.NumUtil" %> 
<%@ page import="java.util.List" %> 

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("kosmoBoardLikeForm.jsp 페이지 >>> : ");

	Object obj = request.getAttribute("listAll");
	if (obj == null) return;

	List<KosmoBoardLikeVO> list = (List<KosmoBoardLikeVO>)obj;	
	int nCnt = list.size();
	
	String nCnt_1 = "";
	String nCnt_2 = "";
	String nCnt_3 = "";
	String nCnt_4 = "";
	String nCnt_5 = "";
	String nCnt_6 = "";
	KosmoBoardLikeVO _kblvo = null;
	if (nCnt == 1){
		_kblvo = list.get(0);
		
		nCnt_1 = _kblvo.getKblike_cnt_1();
		nCnt_2 = _kblvo.getKblike_cnt_2();
		nCnt_3 = _kblvo.getKblike_cnt_3();
		nCnt_4 = _kblvo.getKblike_cnt_4();
		nCnt_5 = _kblvo.getKblike_cnt_5();
		nCnt_6 = _kblvo.getKblike_cnt_6();
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
		
		//  kblike_cnt_1
		$(document).on("click", "#kblike_cnt_1", function(e){
			alert("kblike_cnt_1 >>> : " + $(this).val());
			e.preventDefault();    
		
			let boardLikeURL = "kosmoLikeInsert_1.h";
			let reqType = "POST";
			let dataParam = {
				kblike_cnt_1: $(this).val(),
				kmnum: $("#kmnum").val(),
				kbnum: $("#kbnum").val(),
			};
			//dataParam = $("#likeForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#like_1").text(resData).val();				
			}					
		});
		//  kblike_cnt_2
		$(document).on("click", "#kblike_cnt_2", function(e){
			alert("kblike_cnt_2 >>> : ");	
			e.preventDefault();
			
			let boardLikeURL = "kosmoLikeInsert_2.h";
			let reqType = "POST";
			let dataParam = {
				kblike_cnt_2: $(this).val(),
				kmnum: $("#kmnum").val(),
				kbnum: $("#kbnum").val(),
			};
			//dataParam = $("#likeForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#like_2").text(resData).val();				
			}
		});
		//  kblike_cnt_3
		$(document).on("click", "#kblike_cnt_3", function(e){
			alert("kblike_cnt_3 >>> : ");
			e.preventDefault();
			
			let boardLikeURL = "kosmoLikeInsert_3.h";
			let reqType = "POST";
			let dataParam = {
				kblike_cnt_3: $(this).val(),
				kmnum: $("#kmnum").val(),
				kbnum: $("#kbnum").val(),
			};
			//dataParam = $("#likeForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#like_3").text(resData).val();				
			}
		});
		
		//  kblike_cnt_4
		$(document).on("click", "#kblike_cnt_4", function(e){
			alert("kblike_cnt_4 >>> : ");
			e.preventDefault();
			
			let boardLikeURL = "kosmoLikeInsert_4.h";
			let reqType = "POST";
			let dataParam = {
				kblike_cnt_4: $(this).val(),
				kmnum: $("#kmnum").val(),
				kbnum: $("#kbnum").val(),
			};
			//dataParam = $("#likeForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#like_4").text(resData).val();				
			}
		});
		
		//  kblike_cnt_5
		$(document).on("click", "#kblike_cnt_5", function(e){
			alert("kblike_cnt_5 >>> : ");	
			e.preventDefault();
			
			let boardLikeURL = "kosmoLikeInsert_5.h";
			let reqType = "POST";
			let dataParam = {
				kblike_cnt_5: $(this).val(),
				kmnum: $("#kmnum").val(),
				kbnum: $("#kbnum").val(),
			};
			//dataParam = $("#likeForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#like_5").text(resData).val();				
			}
		});
		
		//  kblike_cnt_6
		$(document).on("click", "#kblike_cnt_6", function(e){
			alert("kblike_cnt_6 >>> : ");	
			e.preventDefault();
			
			let boardLikeURL = "kosmoLikeInsert_6.h";
			let reqType = "POST";
			let dataParam = {
				kblike_cnt_6: $(this).val(),
				kmnum: $("#kmnum").val(),
				kbnum: $("#kbnum").val(),
			};
			//dataParam = $("#likeForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#like_6").text(resData).val();				
			}
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
		
	a {
	  text-decoration-line: none;
		/*   text-decoration-line: underline; */
		/*   text-decoration-line: overline; */
		/*   text-decoration-line: line-through; */
		/*   text-decoration-line: underline line-through overline; */
	}		
</style>
</head>
<body>
<h3>좋아요</h3>
<hr>
<div>
<form name="likeForm" id="likeForm">
<table border=1>
<tr>
<td>
<input type="hidden" name="kmnum" id="kmnum" value="<%= "M202205230005" %>" />
<input type="hidden" name="kbnum" id="kbnum" value="<%= "B0001" %>" />
<input 	type="image" src="/kosmoSpring/img/img_like/1.png" width="35px" height="35px" 
		class="kblike_cnt_1" name="kblike_cnt_1"  id="kblike_cnt_1" value="01" />
</td>
<td>
<input 	type="image" src="/kosmoSpring/img/img_like/2.png" width="35px" height="35px" 
		class="kblike_cnt_2" name="kblike_cnt_2" id="kblike_cnt_2" value="02" />
</td>
<td>
<input 	type="image" src="/kosmoSpring/img/img_like/3.png" width="35px" height="35px" 
		class="kblike_cnt_3" name="kblike_cnt_3" id="kblike_cnt_3" value="03" />
</td>
<td>
<input 	type="image" src="/kosmoSpring/img/img_like/4.png" width="35px" height="35px" 
		class="kblike_cnt_4" name="kblike_cnt_4" id="kblike_cnt_4" value="04" />
</td>
<td>
<input 	type="image" src="/kosmoSpring/img/img_like/5.png" width="35px" height="35px" 
		class="kblike_cnt_5" name="kblike_cnt_5" id="kblike_cnt_5" value="05" />
</td>
<td>
<input 	type="image" src="/kosmoSpring/img/img_like/6.png" width="35px" height="35px" 
		class="kblike_cnt_6" name="kblike_cnt_6" id="kblike_cnt_6" value="06" />
</td>
</tr>
<tr>
<td align="center">
<font size="1" style="color:gray;">좋아요</font><br>
<span id="like_1"><%= nCnt_1 %></span>
</td>
<td  align="center">
<font size="1" style="color:gray;">응원해요</font><br>
<span id="like_2"><%= nCnt_2 %></span>
</td>
<td align="center">
<font size="1" style="color:gray;">축하해요</font><br>
<span id="like_3"><%= nCnt_3 %></span>
</td>
<td align="center">
<font size="1" style="color:gray;">기대해요</font><br>
<span id="like_4"><%= nCnt_4 %></span>
</td>
<td align="center">
<font size="1" style="color:gray;">놀랐어요</font><br>
<span id="like_5"><%= nCnt_5 %></span>
</td>
<td align="center">
<font size="1" style="color:gray;">슬퍼요</font><br>
<span id="like_6"><%= nCnt_6 %></span>
</td>
</tr>
<tr>
<td colspan="6" align="center">
<a href="#">
<span class="u_ico"></span>
<em class="u_txt _label">이 기사를 추천합니다</em>
<em class="u_cnt _count">1</em>
</a>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>
