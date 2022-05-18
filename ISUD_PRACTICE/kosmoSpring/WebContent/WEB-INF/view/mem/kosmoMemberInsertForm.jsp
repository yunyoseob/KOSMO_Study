<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		// 아이디 중복체크 시작  ================================================= 		
		$("#midbtn").click(function(){				
			console.log("idCheck >>> : ");
			
			let midVal = $("#kmid").val();
			if (midVal == '') {
				alert("중복 체크할 아이디를 입력하세요 >>> : ");
				$("#kmid").focus();
				return false;
			}
		});
				
		// 아이디 중복체크 Ajax 비동기 방식		
		$(document).on("click", "#kmidbtn", function(){
			alert("kmidbtn >>> : ");

			let idCheckURL = "kosmoIdCheck.h";
			let reqType = "POST";
			let dataParam = { kmid: $("#kmid").val(), };
			
			$.ajax({
				url: idCheckURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				if ("ID_YES" == resData){
					alert("아이디 사용가능 : ID_YES.");														
					$("#kmid").css('background-color','yellow');	
					$("#kmid").attr("readonly", true);
					$("#kmpw").focus();	
				}else if ("ID_NO" == resData){
					alert("이미 아이디 사용중 : ID_NO.");
					$("#kmid").val('');
					$("#kmid").focus();
				};				
			}
			function whenError(e){
				alert("e >>> : " + e.responseText);
			}
		});
		
		
		// 비밀번호 체크 
		$("#pwCheck").click(function(){
			console.log(" pwCheck 함수 진입");
			var pw = $("#kmpw").val();
			var pw_r = $("#kmpw_r").val();	
			if(pw == pw_r) {
				alert("비밀번호가 같습니다.");
				 pw_r.val('');				
				$("#kmname").focus();						
				return true;
			} else {
				alert("비밀번호가 다릅니다.");
				pw.val('');
				pw_r.val('');			
				pw.focus();							
				return false;
			}
		});		
		
		// 핸드폰 
		
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
			console.log("zonecode >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#kmzone").val(data.zonecode); //5자리 새우편번호 사용
				    $("#kmroad").val(data.roadAddress); //도로명 주소
				    $("#kmjibun").val(data.jibunAddress); //지번주소			
				}
			}).open();
		});
		
		
		$(document).on('click', '#insertBtn', function(){
			
			$("#memForm").attr({"action":"kosmoMemberInsert.h","method":"POST","enctype":"multipart/form-data"}).submit();	
		});
	});
	
</script>
</head>
<body>
<h3 align="center">회원가입</h3>
<hr>
<form name="memForm" id="memForm">
<table border="1" align="center">
<tr>
	<td colspan="2" align="center">					
		<font size="4" style="color:blue;">KOSMO 103기</font> 
		<img src="/kosmoSpring/img/img_mandu/ase.gif" width="25" height="25" alt="image">
	</td>
</tr>
<tr>
	<td>회원번호</td>
	<td><input type="text" name="kmnum" id="kmnum" readonly/></td>
 </tr>
<tr>
	<td>아이디</td>
	<td>		
		<input type="text" name="kmid" id="kmid" placeholder="아이디 체크" />
		<input type="button" name="kmidbtn" id="kmidbtn" value="아이디중복확인"  />
	</td>
</tr>
</div>
<tr>
	<td>패스워드</td>
	<td>
		<input type="text" name="kmpw" id="kmpw" /><br/>	
		<input type="text" name="kmpw_r" id="kmpw_r" placeholder="비밀번호확인" />
		<input type="button" value="비밀번호확인" id="pwCheck"/><br/>
	</td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="kmname" id="kmname"/></td>
</tr>
<tr>
	<td>핸드폰</td>
	<td>
		<select name="kmhp" id="kmhp">
        	<option value="010">010</option>
        	<option value="011">011</option>
        	<option value="016">016</option>
        	<option value="017">017</option>		        	
         </select>
         - <input type="text" name="kmhp1" id="kmhp1" size="2" maxlength="4" />
         - <input type="text" name="kmhp2" id="kmhp2" size="2" maxlength="4" />
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td>		
		<input type="text" name="kmemail"  id="kmemail" style="width:100px"/>
		@ <input type="text" name="kmemail1" id="kmemail1" style="width:100px" placeholder="직접입력" />
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
 	<td>
 		<input type="text" name="kmzone" id="kmzone" placeholder="우편번호" style="width:50px" maxlength="6" >
 		<input type="button" name="zoneBtn" id="zoneBtn" value="우편번호 찾기"><br>	 	
 		<input type="text" name="kmroad" id="kmroad" placeholder="도로명주소" style="width:250px"><br>	 	
 		<input type="text" name="kmroad2" id="kmroad2" placeholder="도로명주소 상세주소" style="width:250px"><br>	 	
 		<input type="text" name="kmjibun" id="kmjibun" placeholder="지번주소" style="width:250px">
 	</td>
</tr>	 
 <tr>
	<td>사진</td>
	<td> 
		<input type="file" name="kmimage"  /><br>
    </td>
</tr>
<tr>
	<td colspan="2"> 			
		<button type="button" id="insertBtn">보내기</button>
		<button type="reset">다시 </button>	
	</td>				
</tr>
</table>				 		        		     
</form>	

</body>
</html>