<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.kosmo.product.vo.KosmoProductVO" %> 
<%@ page import="java.util.List" %>  

<%@ page import="a.b.c.com.kosmo.common.NumUtil" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%

	//페이징 변수 세팅
	int pageSize = 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;

	Object objPaging = request.getAttribute("pagingKPVO");
	KosmoProductVO pagingKPVO = (KosmoProductVO)objPaging;
	
	Object obj = request.getAttribute("listAll");
	List<KosmoProductVO> list = (List<KosmoProductVO>)obj;
	
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
		
		
	});	

</script>
<style type="text/css">

	th {
		text-align: center;
	}
</style>
</head>
<body>
<h3 align="center">상품목록</h3>
<hr>
<form name="productList" id="productList">
<table border="1" align="center">
<thead>
<tr>
	<th>사진</td>
	<th>내용</td>
	<th>가격</td>	
</tr>
</thead>
<%
String kpnum = "";
String kpprice = "";
for(int i=0; i<nCnt; i++){		
	KosmoProductVO _kpvo = list.get(i);		
	kpnum = _kpvo.getKpnum();
	kpprice = _kpvo.getKpprice();
	kpprice = NumUtil.comma(kpprice);
	
	// 페이징 세팅
	pageSize = Integer.parseInt(pagingKPVO.getPageSize());
	groupSize = Integer.parseInt(pagingKPVO.getGroupSize());
	curPage = Integer.parseInt(pagingKPVO.getCurPage());
	totalCount = Integer.parseInt(_kpvo.getTotalCount());
%>
<tbody>
<tr>
	<td rowspan="4" align="center" style="width:100px;">
		<img src="/kosmoSpring/fileupload/product/<%= _kpvo.getKpfile() %>" width="50" height="50"><br>
		<%= _kpvo.getKpid() %>
	</td>
	<td align="left" style="width:300px;">상품번호 : <%= kpnum %></td>
	<td rowspan="4" align="center" vertical-align="middle" style="width:150px;">
		<%= kpprice %>&nbsp;&nbsp;
		<a href="kosmoProductSelect.h?kpnum=<%= kpnum %>">
			<img src="/kosmoSpring/img/img_mandu/ase.gif" width="25" height="25" alt="image">
		</a>
	</td>
</tr>
<tr><td><%= _kpvo.getKpdesc() %></td></tr>
<tr><td><%= _kpvo.getKpcompany() %></td></tr>
<tr><td>상품 등록일 : <%= _kpvo.getInsertdate() %></td></tr>
<%
}//end of for
%>	
</tbody>
<tfoot>
<tr>
<td colspan="3">
<jsp:include page="productPaging.jsp" flush="true">
	<jsp:param name="url" value="kosmoProductSelectAll.h"/>
	<jsp:param name="str" value=""/>
	<jsp:param name="pageSize" value="<%=pageSize%>"/>
	<jsp:param name="groupSize" value="<%=groupSize%>"/>
	<jsp:param name="curPage" value="<%=curPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
</jsp:include>
</td>
</tr>							
</tfoot>			
</table>
</form>	
</body>
</html>