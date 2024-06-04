<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionDTOView</title>
</head>
<body>
    <h1>SessionDTOView</h1>
    name : ${sessionScope.student.name} <br/>
    age  : ${sessionScope.student.age} <br/>
    
    <hr/>
    <a href="sessionDTODelete.do">sessionDTO 삭제</a>
</body>
</html>