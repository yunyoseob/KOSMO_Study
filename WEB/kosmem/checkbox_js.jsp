<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHECKBOX TAG</title>

<!-- CDN -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	//체크박스 체크 함수
	function checkOnly(chk){
		
		alert("checkOnly chk >>> : " + chk);
		
		var chkObj = document.getElementsByName("mnumCheck");
		alert("chkObj >>> : " + chkObj);
		console.log("chkObj >>> : " + chkObj);
		
		for (var i=0; i < chkObj.length; i++){
			
			if (chkObj[i] != chk){
				chkObj[i].checked = false;
			}
		}
	}
	
	$(document).ready(function(){
		
		// 체크박스 
		function chkInfo(){			
			
			var obj = document.getElementsByName("mnumCheck");
			var nCnt = 0;			
			
			for(var i=0; i < obj.length; i++){ 
	          	
				if (obj[i].checked == true){ 
	          		nCnt++;
	          	}		          			            
	        }			
			console.log('nCnt >>> : ' + nCnt);			
			
			return nCnt;
		}
		
		// 수정 		
		$("#U").click(function(){			
			
			alert("U");
			
			var nCnt = chkInfo();			
			
			if (nCnt == 0){	
				alert("체크박스 체크하세요");
			}else{				
				alert("어디로 보낼까요 ");
			}		
		});
		
		// 삭제 
		$("#D").click(function(){			
			
			alert("D");
			
			var nCnt = chkInfo();
			
			if (nCnt == 0){	
				alert("체크박스 체크하세요");
			}else{	
				alert("어디로 보낼까요 ");
			}					
		});		
	});
</script>
<style type="text/css">

	table {
		border: 1px solid blue;
		width: 300px;
		height: 50px;
		margin: 5px auto;
		text-align: center;
	}
	
	h3,hr {
		text-align: center;
	}
</style>
</head>
	<body>
		<div class="wrap">
			<h3>CHECKBOX TAG</h3>
			<hr>	
			<form name="check_form_1" id="check_form_1">
				<table>
					<thead>
						<tr>
							<td class="tt">
								<input type="checkbox" class="chkAll" name="chkAll" id="chkAll">
							</td>
							<td class="tt">순번</td>
							<td class="tt">회원번호</td>
							<td class="tt">이름</td>
						</tr>
					</thead>
						<%	
							for(int i=0; i<5; i++){	
						%>					
					<tbody>
						<tr>
							<td class="tt">
								<input 	type="checkbox" class="numCheck"  name="mnumCheck" id="mnumCheck" 
										value=<%= i %>  onclick="checkOnly(this)">
							</td>		
							<td class="tt"><%= i + "_순번" %></td>
							<td class="tt"><%= i + "_회원번호" %> </td>
							<td class="tt"><%= i + "_이름" %> </td>		
						</tr>	
						<%
							}//end of if
						%>						
						<tr>
							<td colspan="5" align="right">
								<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
								<input type="button" value="등록" id="I">
								<input type="button" value="조회" id="SALL">
								<input type="button" value="수정" id="U">
								<input type="button" value="삭제" id="D">									
							</td>
						</tr>	
					</tbody>			
				</table>
			</form>	
		</div>	
	</body>
</html>