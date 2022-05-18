<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.kosmo.mem.vo.KosmoMemberVO" %> 
<%@ page import="a.b.c.com.kosmo.common.CodeUtil" %> 
<%@ page import="java.util.List" %>

 <% request.setCharacterEncoding("UTF-8");%> 
<%	
	Object obj = request.getAttribute("listS");
	if (obj == null) return;

	List<KosmoMemberVO> list = (List<KosmoMemberVO>)obj;	
	int nCnt = list.size();
	
	String kmhp = "";
	String kmhp0 = "";
	String kmhp1 = "";
	String kmhp2 = "";
	String kmemail = "";	
	String kmemails[] = null;
	KosmoMemberVO _kmvo = null;
	if (nCnt == 1){
		_kmvo = list.get(0);

		// 핸드폰
		kmhp = CodeUtil.hp(_kmvo.getKmhp());
		String hp[] = kmhp.split("-");
		kmhp0 = hp[0];
		kmhp1 = hp[1];
		kmhp2 = hp[2];
		// 이메일
		kmemail = _kmvo.getKmemail();
		kmemails = kmemail.split("@");		
	}	
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

	$(document).ready(function(){	
		
		// 이메일 
		$('#kmemail2').change(function(){	
			$("#kmemail2 option:selected").each(function () {
				if($(this).val()== '1'){ //직접입력일 경우 
						var aa = $("#kmemail1").val();						
						$("#kmemail1").val(''); //값 초기화 
						$("#kmemail1").attr("readonly",false); //활성화 				
				}else{ //직접입력이 아닐경우 
						$("#kmemail1").val($(this).text()); //선택값 입력 
						$("#kmemail1").attr("readonly",true); //비활성화 
				}
			}); 
		}); 	
		
		// 우편번호	
		$("#zoneBtn").click(function(){
			console.log("zoneBtn >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#kmzone").val(data.zonecode); 		//5자리 새우편번호 사용
				    $("#kmroad").val(data.roadAddress); 	//도로명 주소
				    $("#kmroad2").val(''); 					// 도로명 상세주소
				    $("#kmjibun").val(data.jibunAddress); 	//지번주소			
				}
			}).open();
		});
	});

	//  updateBtn
	$(document).on("click", "#updateBtn", function(){
		//alert("U >>> : ");		
		$("#memUpdateForm").attr({ "method":"GET"
			                      ,"action":"#kosmoMemberUpdate.h"}).submit();
	});
	//  deleteBtn
	$(document).on("click", "#deleteBtn", function(){
		//alert("D >>> : ");
		$("#memUpdateForm").attr({ "method":"GET"
			                      ,"action":"#kosmoMemberDelete.h"}).submit();
	});
	
	//  insertBtn
	$(document).on("click", "#insertBtn", function(){
		location.href="kosmoMemberInsertForm.h";
	});
	
	// selectBtn
	$(document).on("click", "#selectBtn", function(){		
		$("#memUpdateForm").attr({"method":"GET", "action":"kosmoMemberSelect.h"}).submit();		
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

	.tt {
		text-align: center;
	}
	
	.photo {
		border:1px solid red;
		width: 160px;
		height: 180px;
		display: block;
		margin-reft: auto;
		margin-rigth; auto;
	}
</style>
</head>
<body onload="compCheck()">  
<script>
function compCheck(){
	console.log("compCheck >>> 진입 >>> : ");
	
	// 핸드폰 
	var hp0 = "<%= kmhp0 %>";
	if ('010' == hp0){		
		document.memSelectForm.mhp.options[0].selected = true;
	}
	if ('011' == hp0){		
		document.memSelectForm.mhp.options[1].selected = true;
	}
	if ('016' == hp0){		
		document.memSelectForm.mhp.options[2].selected = true;
	}
	if ('017' == hp0){		
		document.memSelectForm.mhp.options[3].selected = true;
	}	
}

</script>
<h3>회원정보</h3>
<hr>
<div>
<form name="memUpdateForm" id="memUpdateForm">
<table border="1">
<tr>	
	<td colspan="3" align="center">						
		<font size="4" style="color:blue;">수정 && 삭제</font> 
		<img src="/kosmoSpring/img/img_mandu/ase.gif" width="25" height="25" alt="image">		
	</td>				
</tr>
<tr>
	<td>회원번호</td>
	<td>
		<input type="text" name="kmnum" id="kmnum"  value="<%= _kmvo.getKmnum() %>" readonly />
	</td>
	<td rowspan="5">
		<img class="photo" src="/kosmoSpring/fileupload/mem/<%= _kmvo.getKmimage() %>" alt="image">
	</td>	
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="kmname" id="kmname" value="<%= _kmvo.getKmname() %>" readonly /></td>
</tr>
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="kmid" id="kmid" style="width:100px" value="<%= _kmvo.getKmid() %>" readonly />	
	</td>
</tr>
<tr>
	<td>패스워드</td>
	<td>
		<input type="text" name="kmpw" id="kmpw" style="width:100px" value="<%= _kmvo.getKmpw() %>" readonly /><br/>		
	</td>
</tr>
<tr>
	<td>핸드폰</td>
	<td>
		<select name="kmhp" id="kmhp" style="width:50px;">
        	<option value="010">010</option>
        	<option value="011">011</option>
        	<option value="016">016</option>
        	<option value="017">017</option>		        	
         </select>
         - <input type="text" name="kmhp1" id="kmhp1" value="<%= kmhp1 %>" maxlength="4" style="width:50px;"/>
         - <input type="text" name="kmhp2" id="kmhp2" value="<%= kmhp2 %>" maxlength="4" style="width:50px;"/>
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td  colspan="2">		
		<input type="text" name="kmemail"  id="kmemail"  value="<%= kmemails[0] %>" style="width:100px"  />
		@ <input type="text" name="kmemail1" id="kmemail1"  value="<%= kmemails[0] %>" style="width:100px" 
			placeholder="직접입력" />
		<select name="kmemail2" id="kmemail2">
        	 <option value="1" selected>직접입력</option>
       		 <option value="naver.com">naver.com</option>	       	   
      		 <option value="gmail.com">gmail.com</option>
      		 <option value="daum.net">daum.net</option>	       	   
         </select>
	</td>
</tr>
<tr>
 	<td>주소</td>
 	<td   colspan="2">
 		<input type="text" name="kmzone" id="kmzone" 
 			placeholder="우편번호" style="width:50px" value="<%= _kmvo.getKmzone() %>" >
 		<input type="button" name="zoneBtn" id="zoneBtn" value="우편번호 찾기"><br>	 	
 		<input type="text" name="kmroad" id="kmroad" 
 			placeholder="도로명주소" style="width:250px" value="<%= _kmvo.getKmroad() %>" ><br>	 	
 		<input type="text" name="kmroad2" id="kmroad2" 
 			placeholder="도로명주소 상세주소" style="width:250px" value="<%= _kmvo.getKmroad2() %>" ><br>	 	
 		<input type="text" name="mjibun" id="mjibun"
 			 placeholder="지번주소" style="width:250px" value="<%= _kmvo.getKmjibun() %>">
 	</td>
</tr>	 
<tr>
	<td colspan="3" align="center">		
	<input type="button" value="수정" id='updateBtn' />
	<input type="button" value="삭제"  id='deleteBtn' />
    <input type="reset" value="취소" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="입력"  id='insertBtn' />
	<input type="button" value="목록"  id='selectBtn' />
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>