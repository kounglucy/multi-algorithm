<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <div class="container">
        <!-- 사이드바 -->
        <div class="sidebar">
            <%@ include file="sidebar.jsp" %>
        </div>
        <!-- 메인 상단부(검색바 + 로그인버튼 + 회원가입 버튼) // class 및 include file(jsp) 변경-->
        <div class="main-top">
            <%@ include file="search.jsp" %>
            <%@ include file="loginAndSignup.jsp" %>
        </div>
        <!-- 메인 중단부(광고 및 이벤트 배너) -->
        <div class="main-middle">
        	<%@ include file="banner.jsp" %>
        </div>
    </div>
</body>
</html>