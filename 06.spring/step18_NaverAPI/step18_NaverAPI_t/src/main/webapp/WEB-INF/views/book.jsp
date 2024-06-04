<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Book List</title>
	</head>
	<body>
		<h1>Naver Search API : Book</h1>
		
		<table border="1">
            <tr>
                <th>ISBN</td>
                <th>이미지</td>
                <th>도서명</td>
                <th>저자/출판사</td>
                <th>출판일</td>
            </tr> 
            <c:forEach var="book" items="${bookList}">
	            <tr>
	                <td>${book.isbn}</td>
	                <td><img src="${book.image}" alt="${book.title}" width="80"></td>
	                <td><a href="${book.link}">${book.title}</a></td>
	                <td>${book.author} / ${book.publisher}</td>
	                <td>${book.pubdate}</td>
	            </tr>
            </c:forEach>
		</table>

	</body>
</html>