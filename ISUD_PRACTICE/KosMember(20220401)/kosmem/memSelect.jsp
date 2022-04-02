<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="a.b.c.kos.mem.service.MemSerivce"%>    
<%@page import="a.b.c.kos.mem.service.MemSerivceImpl"%>    
<%@ page import="a.b.c.kos.mem.vo.MemVO" %>
<%@ page import="a.b.c.common.CodeUtil" %>

<%@ page import="java.util.ArrayList" %>

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 조회</title>
<!-- 디바이스에 최적화된 크기로 출력됨 -->
<meta name="viweport" content="width=device-width, iitail-scale=1">

<!-- jQuery CDN 불러오기  -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- 다음 주소록 OPEN API CDN 불러오기  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
	
	//jQuery 는 스크립트 블럭 ready 함수 블럭에 만들어야 한다.
	$(document).ready(function(){
		
		// 이메일 		
		$('#memail2').change(function(){	
			$("#memail2 option:selected").each(function () {
				if($(this).val()== '1'){ //직접입력일 경우 
						var aa = $("#memail1").val();
						//alert("aa >>> : " + aa);
						$("#memail1").val(''); //값 초기화 
						$("#memail1").attr("readonly",false); //활성화 				
				}else{ //직접입력이 아닐경우 
						$("#memail1").val($(this).text()); //선택값 입력 
						$("#memail1").attr("readonly",true); //비활성화 
				}
			}); 
		}); 
		
		// 우편번호	
		$("#mzone_btn").click(function(){
			console.log("mzone_btn >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#mzone").val(data.zonecode); // 5자리 새우편번호 사용
				    $("#mroad").val(data.roadAddress); // 도로명 주소
				    $("#mroaddetail").val(''); // 도로명 상세주소
				    $("#mjibun").val(data.jibunAddress); // 지번주소			
				}
			}).open();
		});
		// 수정
		$("#memUpdateBtn").click(function(){
			alert("memUpdateBtn 버튼 클릭 성공 >>> : ");
			
			$("#memSelectForm").attr(
				{
					"action":"/kosMember/kosmem/memUpdateOk.jsp",
					"method":"GET"
				}
			).submit();
		});
		
		// 삭제
		$("#memDeleteBtn").click(function(){
			alert("memDeleteBtn 버튼 클릭 성공 >>> : ");
						
			$("#memSelectForm").attr(
				{
					"action":"/kosMember/kosmem/memDeleteOk.jsp",
					"method":"GET"
				}
			).submit();
		});
	});

</script>
</head>
<body onload="compCheck()">
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%	
	Logger logger = LogManager.getLogger(this.getClass());

	logger.info("memSelect.jsp 페이지 >>> : ");

	String mnum = request.getParameter("mnum");
	MemVO mvo = null;
	mvo = new MemVO();
	mvo.setMnum(mnum);
	logger.info("mnum >>> : " + mvo.getMnum());
	
	MemSerivce ms = new MemSerivceImpl();
	ArrayList<MemVO> aList = ms.memSelect(mvo);
	if(aList == null) return;
	
	String mhp = "";
	String memail = "";
	String mgender = "";
	String mhobby = "";
	String mzone = "";
	String mroad = "";	
	String mroaddetail = "";
	String mjibun = "";

	MemVO _mvo = aList.get(0);
	
	// 핸드폰
	mhp = CodeUtil.hp(_mvo.getMhp());
	logger.info("mhp >>> : " + mhp);
	String hp[] = mhp.split("-");
	String mhp0 = hp[0];
	String mhp1 = hp[1];
	String mhp2 = hp[2];
	
	// 이메일
	memail = _mvo.getMemail();
	logger.info("memail >>> : " + memail);
	
	// 성별
	mgender = CodeUtil.gender(_mvo.getMgender());
	logger.info("mgender >>> : " + mgender);
	
	// 취미
	mhobby = _mvo.getMhobby();
	logger.info("mhobby >>> : " + mhobby);
	
	// 우편번호, 도로명 주소, 지번 주소
	mzone = _mvo.getMzone();
	logger.info("mzone >>> : " + mzone);
	
	mroad = _mvo.getMroad();
	logger.info("mroad >>> : " + mroad);
	
	String addr[] = mroad.split("@");
	mroad = addr[0];
	logger.info("mroad >>> : " + mroad);
	mroaddetail = addr[1];
	logger.info("mroaddetail >>> : " + mroaddetail);
	
	mjibun = _mvo.getMjibun();
	logger.info("mjibun >>> : " + mjibun);
%>
<div>
<h3>회원 정보 수정 삭제</h3>
<hr>
<form name="memSelectForm" id="memSelectForm">
<table border="1">
<script>
function compCheck(){
	console.log("compCheck >>> 진입 >>> : ");
	
	// 핸드폰 
	var hp0 = '<%= mhp0 %>';
	// hp0 = '017';
	// alert("hp0 >>> : " + hp0);
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
	
	// 성별
	var gen = '<%= mgender %>';
	console.log("gen >>> : "  + gen);
	if ('여자' == gen){
		document.getElementsByName("mgender")[0].checked = true;
	}
	if ('남자' == gen){
		document.getElementsByName("mgender")[1].checked = true;
	}
	
	// 이메일 
	var email = '<%= memail %>';	
	var emails = email.split('@');
	document.getElementById("memail").value = emails[0];
	document.getElementById("memail1").value = emails[1];
	
	// 취미
	var hobs = '<%= mhobby %>';
	console.log("hobs >>> : "  + hobs);
	var hob = hobs.split(',');
	for (var m=0; m < hob.length; m++){
		var hobValue = hob[m];
		console.log("hobValue >>> : " + hobValue);
		if ('01' == hobValue){
			document.getElementsByName("mhobby")[0].checked = true;
		}
		if ('02' == hobValue){
			document.getElementsByName("mhobby")[1].checked = true;
		}
		if ('03' == hobValue){
			document.getElementsByName("mhobby")[2].checked = true;
		}
		if ('04' == hobValue){
			document.getElementsByName("mhobby")[3].checked = true;
		}	
	}
}
</script>
<tr>
	<td colspan="2">회원 정보</td>	
</tr>
<tr>
	<td>회원번호</td>
	<td><input type="text" name="mnum"  id="mnum" value="<%= _mvo.getMnum() %>" readonly /></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="mname" id="mname" value="<%= _mvo.getMname() %>"/></td>
</tr>
<tr>
	<td>아이디</td>
	<td>	
		<input type="text" name="mid" mid="mid" value="<%= _mvo.getMid() %>"/>		
	</td>
</tr>
<tr>
	<td>패스워드</td>
	<td>
		<input type="text" name="mpw" id="mpw" value="<%= _mvo.getMpw() %>" style="width:100px"/><br>
	</td>
</tr>
<tr>
	<td>핸드폰</td>
	<td>
		<select name="mhp" id="mhp" style="width:50px;">
        	<option value="010">010</option>
        	<option value="011">011</option>
        	<option value="016">016</option>
        	<option value="017">017</option>		        	
         </select>
         - <input type="text" name="mhp1" id="mhp1" value="<%= mhp1 %>" maxlength="4" style="width:50px;"/>
         - <input type="text" name="mhp2" id="mhp2" value="<%= mhp1 %>" maxlength="4" style="width:50px;"/>
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td>		
		<input type="text" name="memail"  id="memail" style="width:100px"/>
		@ <input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력" />
		<select name="memail2" id="memail2">
        	 <option value="1" selected>직접입력</option>
       		 <option value="naver.com">naver.com</option>	       	   
      		 <option value="gmail.com">gmail.com</option>
      		 <option value="daum.net">daum.net</option>	       	   
         </select>
	</td>
</tr>
<tr>
	<td>성별</td>
	<td> 
		<input type="radio" name="mgender" value="01" checked="checked" />여자
		<input type="radio" name="mgender" value="02" /> 남자
	</td>
</tr>
<tr>
	<td>취미</td>
	<td> 
		<input type="checkbox" name="mhobby" value="01" />독서		      
		<input type="checkbox" name="mhobby" value="02" />운동
		<input type="checkbox" name="mhobby" value="03" />음악감상
		<input type="checkbox" name="mhobby" value="04" />여행
	</td>
</tr>
<tr>
	<td>주소</td>
 	<td>
 		<input type="text" name="mzone" id="mzone" placeholder="우편번호" value="<%= mzone %>" style="width:70px" maxlength="6" >
 		<input type="button" name="mzone_btn" id="mzone_btn" value="우편번호 찾기"><br>	 	
 		<input type="text" name="mroad" id="mroad" placeholder="도로명주소" value="<%= mroad %>" style="width:250px"><br>	 	
 		<input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소" value="<%= mroaddetail %>" style="width:250px"><br>	 	
 		<input type="text" name="mjibun" id="mjibun" placeholder="지번주소" value="<%= mjibun %>" style="width:250px">
 	</td>
</tr>
<tr>
	<td>소개글</td>
	<td>
		<textarea name="mmsg" id="mmsg" rows="5" cols="50"><%= _mvo.getMmsg() %></textarea>
	</td>
</tr>
<tr>
	<td colspan="2"> 	
		<input type="button" value="회원정보수정" id="memUpdateBtn" />
		<input type="button" value="회원정보삭제" id="memDeleteBtn" />	
		<input type="reset" value="취소" />
	</td>				
</tr>
</table>				 		        		     
</form>	
</div>		
</body>
</html>
