<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
    <%  
        /* Cookie */
        Cookie cookie1 = new Cookie("id","dev");
        cookie1.setMaxAge(60*60*24);
        
        response.addCookie(cookie1);
        
        /* Session */
        session.setAttribute("name","dev");
        session.setAttribute("age",28);
        
    %>
    <h1>Cookie,Session</h1>
    
    <a href="cookieTest.do">1. CookieTest.do</a>
    
	<hr>
	
	<a href="sessionTest1.do">2. SessionTest1.do</a>
	
	<hr>
	
	<a href="sessionTest2.do?name=spring&age=26">2. SessionTest2.do</a>
	
</body>
</html>