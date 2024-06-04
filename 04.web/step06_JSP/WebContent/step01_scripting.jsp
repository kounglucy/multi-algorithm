<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step01</title>
</head>
<body>
<!-- HTML 주석 -->
<%-- JSP 주석 --%>
<%! String name = "dev"; %>
<h3>step01 : scripting tag</h3>
1. <%= name %> <br/>
2. <% out.println(name); %> <br/>
<% int age = 28; %>
3. <%= age %>

<h3>step02 : EL</h3>
1. 2 + 3 = ${2 + 3} <br/>
2. 2 > 3 = ${2 > 3} <br/>
3. 'a' == 'a' = ${'a' == 'a'} <br/>
4. 'a' != 'a' = ${'a' != 'a'} <br/>
5. param = ${param.id}

<hr/>

<%-- java data 출력 --%>
<%
	// Scope : 범위

	// pageContext
	pageContext.setAttribute("pageData", "현재 페이지에서만 사용 가능");

	// request
	request.setAttribute("reqData", "요청 객체 데이터");
	
	// session 
	session.setAttribute("sessData", "세션 객체 데이터");
%>

6.현재 페이지에서만 출력 가능 데이터 : ${pageScope.pageData}
<br/>
7.요청 객체 데이터 : ${requestScope.reqData}
<br/>
8.세션 객체 데이터 : ${sessionScope.sessData}

</body>
</html>