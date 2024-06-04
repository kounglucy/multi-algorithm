<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step05_JSTL</title>
</head>
<body>
	<h3>JSTL 반복</h3>
	<!-- 1 ~ 5 출력 -->
	<c:forEach begin="1" end="5" var="i">
		${i}
	</c:forEach>
	
	<hr/>
	
	<c:forEach begin="1" end="5" var="i" varStatus="loop">
		${loop.index} - ${i} <br/>
	</c:forEach>
	
	<hr/>
	
	<h4>ArrayList</h4>
	<%
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		session.setAttribute("strList", strList);
	%>
	
	<!-- 
		1번 데이터 : a
		2번 데이터 : b
		3번 데이터 : c
	 -->
		<c:forEach 
			items="${sessionScope.strList}" 
			var="list"
			varStatus="loop">
		
			<div>${loop.count}번 데이터 : ${list}</div>
			
		</c:forEach>
	
  	<%-- 
  		user.dto.User 클래스를 활용하여 3개 이상 데이터 저장후, 개수, 이름, 나이
		1번 데이터 - 이름 : it 나이 : 26
		2번 데이터 - 이름 : dev 나이 : 28
		3번 데이터 - 이름 : server 나이 : 30
	 --%>
<%
		//ArrayList<User> users = new ArrayList<User>();
		//users.add(new User("it", 26));
		//users.add(new User("dev", 28));
		//users.add(new User("server", 30));
		// session.setAttribute("users", users);
	%>
	
	<c:forEach 
		items="${sessionScope.users}"
		var="user"
		varStatus="loop">
		
		<div>${loop.count}번 데이터 - 이름 : ${user.name} 나이 : ${user.age}</div>
	
	</c:forEach>
</body>
</html>l>