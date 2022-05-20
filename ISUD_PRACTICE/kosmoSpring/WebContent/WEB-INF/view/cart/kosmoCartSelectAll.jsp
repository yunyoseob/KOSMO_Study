<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="a.b.c.com.kosmo.cart.vo.KosmoCartVO" %> 
<%@ page import="java.util.List" %>  

<%@ page import="a.b.c.com.kosmo.common.NumUtil" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%

	Object obj = request.getAttribute("listAll");
	List<KosmoCartVO> list = (List<KosmoCartVO>)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);	
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
		
		$(document).on("click", "#chek", function(){				
			if($(this).prop('checked')){			 			
				$('.kcnum').prop('checked',true);				
			}else{
				$('.kcnum').prop('checked',false);
			}
		});
		
		$(document).on('click', '.delBtn', function(){
			alert("delBtn >>> : ");
			let kcnumV = $(this).val();
			alert("kcnumV >>> : " + kcnumV);
			
			location.href="kosmoCartDelete.h?kcnumV="+kcnumV;
			location.reload;
		});
		
		$(document).on('click', '#delsBtn', function(){
					
			if ($('.kcnum:checked').length == 0){
				alert("삭제할 상품 하나 이상을  선택하세요!!");
				return;
			}
			
		 	var kcnum = []; 
		  	$("input:checkbox[name='kcnum']:checked").each(function() {
		  		kcnum.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
			  	console.log(kcnum);
		  	});
		  	
		  	$('#productList').attr({"action":"kosmoCartDeleteArray.h", "method":"GET"}).submit();
			
		});
		
	});	

</script>
</head>
<body>
<h3 align="center">장바구니</h3>
<hr>
<form name="productList" id="productList">
<table border="1" align="center">
<thead>
<tr>
	<td align="center">
		<input type="checkbox" name="chek" id="chek" class="chek">
	</td>
	<td align="center">상품명</td>
	<td align="center">가격</td>
	<td align="center">수량</td>
	<td align="center">합계</td>	
	<td align="center">적립금</td>	
	<td align="center">배송비</td>
	<td align="center">관심상품/삭제</td>		
</tr>
</thead>
<%
String kpnum = "";
String kpprice = "";
String kppricesum = "";
for(int i=0; i<nCnt; i++){		
	KosmoCartVO _kcvo = list.get(i);
	kpprice = NumUtil.comma(_kcvo.getKpprice());
	kppricesum = NumUtil.comma(_kcvo.getKppricesum());
%>
<tbody>
<tr>
	<td align="center">
		<input type="checkbox" name="kcnum" id="kcnum" class="kcnum" value=<%= _kcvo.getKcnum() %> >
	</td>		
	<td class="tt">
		<img src="/kosmoSpring/fileupload/product/<%= _kcvo.getKpfile() %>" width="50" height="50">
		<%= _kcvo.getKpid() %> 
	</td>
	<td class="tt"><%= kpprice %> </td>
	<td class="tt"><%= _kcvo.getKpcnt() %> </td>
	<td class="tt"><%= kppricesum %> </td>
	<td class="tt">적립금</td>
	<td class="tt">배송비</td>
	<td class="tt" align="center">		
		<input type="button" value="관심상품" /><br>
		<button type="button" class="delBtn" name="delBtn" id="delBtn" value=<%= _kcvo.getKcnum() %> >삭제</button><br>
	</td>	
</tr>	
<%
}//end of for
%>	
<tr>
<td colspan="8" align="right">총 구매 금액 000,000원</td>
</tr>
<tr>
<td colspan="8" align="right">
	결제 예정금액 <font size="5" style="color:red;">000,000</font>원
</td>
</tr>
<tr>
	<td colspan="8" align="left">		
		<input type="button" value="선택삭제" id='delsBtn'>	
		<input type="button" value="장바구니 비우기" id='delAllBtn'>
		 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		<input type="button" value="쇼핑하기" id='shopingBtn'>							
		<input type="button" value="주문하기" id='buyBtn'>							
	</td>
</tr>					
</tbody>			
</table>
</form>	
</body>
</html>