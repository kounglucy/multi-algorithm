<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionView</title>
</head>
<body>
    <h1>SessionView</h1>
    name : ${sessionScope.name}<br/>
	age : ${sessionScope.age}<br/>
	grade : ${sessionScope.grade}<br/>
	
	<hr/>
	
	<a href="gradeDelete.do">grade 삭제</a>
	
	<hr/>
	
	<a href="sessionDelete.do">name,age 삭제</a>
  
  
</body>
</html>