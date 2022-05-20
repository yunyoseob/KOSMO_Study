<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="a.b.c.com.kosmo.mem.vo.KosmoMemberVO"%>  
<%@page import="java.util.List"%> 

<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>
    
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("kosmoMainPage.jsp 진입 >>> : ");
		
	boolean popState = true;

	Cookie[] ck = request.getCookies();
	if (ck !=null){
		logger.info("ck >>> : " + ck);
		for (Cookie c : ck){
			String ckName = c.getName();
			String ckValue = c.getValue();
			logger.info("ckName >>> : " + ckName);
			logger.info("ckValue >>> : " + ckValue);
			if (ckName.equals("onedayPopup") && ckValue.equals("off")){
				popState = false;
			}
		}				
	}
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN PAGE</title>
<!-- 뷰포트 : device에 맞게 화면 크기 조정 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script type="text/javascript" src="/kosmoSpring/js/common.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
			
		var popB = eval("<%= popState %>");
		//alert("popB >>> : " + popB);
		// popB = true;
		
		if (popB){
			
			// 팝업
			var win = window.open(	"kosmoPopup.h", 
									"_blank" ,
									"left=150,top=150,width=300,height=300", 
									false);	
			function popup_close(){
				// alert('3초 후 팝업 자동으로 닫기.');	
				win.close();
			}
			// setTimeout(popup_close, 30000);
			
		}
			
		$(function(){
			// 현재 시간 
			function printTime(){
				let days = ["일", "월", "화", "수", "목", "금", "토"];
				let md = new Date();
				
				let yy = md.getFullYear();
				let mm = md.getMonth() + 1;
				let dd = md.getDate();
				let ii = md.getDay();
				let di = days[ii];
				let hh = md.getHours();
				let mi = md.getMinutes();
				let ss = md.getSeconds();
				
				let time = 	yy + "년" +
							numpad(mm) + "월" +
							numpad(dd) + "일" +
							di + "요일" +
							numpad(hh) + ":" +
							numpad(mi) + ":" +
							numpad(ss);
				document.getElementById("timer").innerHTML=time;
			}
			setInterval(printTime, 1000);
			
			
			
			// 수료일	
			function getDay(y, m, d) {
				let today = new Date();
				let dday = new Date(y, m-1, d);
				let cnt = dday.getTime() - today.getTime();
				let n = Math.ceil(cnt / (24 * 60 * 60 * 1000));
				return n;
			}			
			let date = new Date();
			let y = date.getFullYear();
			let dday = getDay(y, 7, 20);			
			console.log("dday >>> : " + dday);
			document.getElementById("dday").innerHTML=dday;
		});

		// 상품 이벤트 
		$(document).on('click', '#img_1', function(){
			alert("#상품아이디가지고 상품검색하기");			
		});
	});
	
</script>
<link rel="stylesheet" href="/kosmoSpring/css/main.css">
<style type="text/css">
	
	.m {
		text-align: center;
	}
	
	table{
		margin : auto;
		border-collapse: separate;
		border-spacing: 20px 40px;
	}
	
	img {
		width:200px;
		height:250px;
	}
	
	a {
	  	text-decoration-line: none;
		/*   text-decoration-line: underline; */
		/*   text-decoration-line: overline; */
		/*   text-decoration-line: line-through; */
		/*   text-decoration-line: underline line-through overline; */
	}	
	
	/*
	#map {
		width:500px;
		height: 400px;
		margin: 100px auto;
		border: 1px solid red;
	}
	*/	
	#map {		
		margin: 10px auto;
		border: 1px solid red;
	}
</style>
</head>
<body>
<%
	String kmid = "";
	Object obj = request.getAttribute("listLogin");
	
	if (obj !=null) {
		List<KosmoMemberVO> list = (List<KosmoMemberVO>)obj;
		int nCnt = list.size();			
		if (nCnt == 1) {
			kmid = list.get(0).getKmid();	
		}	
%>
		<p align="right">
			<%= kmid %> 님 로그인 중 <a href="kosmoLogout.h">로그아웃</a>
		</p>
<%
	}else{
%>
		<p align="right">
			<a href="kosmoLoginForm.h">로그인</a>
		</p>	
<%
	}		
%>

<h3 class="m">MAIN PAGE :   
	<span style="color:red">수료일 D-</span><span id="dday" style="color:red">
	</span> : <span id="timer"></span>
</h3>
<hr>
<div class="container">
<nav class="navi">
  <ul>
    <li><a href="kosmoProductInsertForm.h">상품등록</a></li>
    <li><a href="kosmoProductSelectAll.h">상품조회</a></li>
    <li><a href="javascript:alert('준비중입니다.');" onfocus="this.blur()">게시판</a></li>
    <li><a href="kosmoMemberInsertForm.h">회원가입</a></li>
     <li><a href="#">매장정보</a></li>
  </ul>
</nav>  
</div>
<div id="contents">
  <h1>KOSMO 108기</h1>      
</div>
<div id="noticePop">
<div>

</div>
<table>
<tr>
<td><img src="/kosmoSpring/img/img_book/book0.jpg" id="img_1"><br>
	<a href="void(0);" onclick="alert('상품아이디가지고 상품검색하기');return false;">책 1</a>
</td>
<td><img src="/kosmoSpring/img/img_book/book1.jpg"><br><a href="#">책 2</a></td>
<td><img src="/kosmoSpring/img/img_book/book2.jpg"><br><a href="#">책 3</a></td>
<td><img src="/kosmoSpring/img/img_book/book3.jpg"><br><a href="#">책 4</a></td>
</tr>
<tr>
<td><img src="/kosmoSpring/img/img_kakaofriends/04 (2).png"><br><a href="#">친구 1</a></td>
<td><img src="/kosmoSpring/img/img_kakaofriends/08.png"><br><a href="#">친구 2</a></td>
<td><img src="/kosmoSpring/img/img_kakaofriends/1__(3).png"><br><a href="#">친구 3</a></td>
<td><img src="/kosmoSpring/img/img_kakaofriends/2 (3).png"><br><a href="#">친구 4</a></td>
</tr>
<tr>
<td><img src="/kosmoSpring/img/img_css/bear.jpg"><br><a href="#">이미지 1</a></td>
<td><img src="/kosmoSpring/img/img_css/guitar-bg.jpg"><br><a href="#">이미지 2</a></td>
<td><img src="/kosmoSpring/img/img_css/cat.jpg"><br><a href="#">이미지 3</a></td>
<td><img src="/kosmoSpring/img/img_css/photo.jpg"><br><a href="#">이미지 4</a></td>
</tr>
</table>
</div>
<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:5	0%;height:350px;"></div>
<!-- // : http, https 둘다 허용  -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7ba50d45d025f6f02a5ac1b2483828c8"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        // center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      	center: new kakao.maps.LatLng(37.478853, 126.879367), // 가산 월드메르디앙
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});
</script>
<hr>
<div>
	<h2>footer</h2>
</div>
</body>
</html>