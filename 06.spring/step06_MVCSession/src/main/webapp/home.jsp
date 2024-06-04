<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<div align="center">
	<c:if test="${empty sessionScope.userId}">	
		<input type="button" value="로그인" onclick="location.href='/login.do'">
	</c:if>
	<c:if test="${not empty sessionScope.userId}">
  	<!-- 로그인 버튼 클릭 시, login.jsp -->
		${sessionScope.userId}님 &nbsp;&nbsp; 
		<input type="button" value="로그아웃" onclick="location.href='/logout.do'">
	</c:if>
</div>
<c:if test="${not empty sessionScope.userId}">
	<P align="center">  The time on the server. </P>
</c:if>
</body>
</html>