<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie View</title>
</head>
<body>
	<h1>Cookie View</h1>
	<!-- 쿠키 출력 코드(index.jsp -> cookieTest.do -> cookieView.jsp) -->
	${cookie.id} - ${cookie.id.name} - ${cookie.id.value}
	
</body>
</html>