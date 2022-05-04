<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Spring Hello</h3>
<hr>
<a href="hello_spring.yys">Hello Spring 실행하기</a>
<!--  a href="여기에있는 이름이 컨텍스트 내에서 유니크해야한다." -->
<!--  index -> web.xml -> spring-servlet.xml 
->  HelloWorldController.java -> hello_spring_return.jsp -->

<!-- 
index.jsp => server.xml => web.xml(Server에 있는) => context.xml(Server에 있는)
=> web.xml (Context WEB-INF/ 안에 있는) => spring_servlet (Context WEB-INF/ 안에 있는)
=> Controller => hello_return.jsp

 -->
</body>
</html>