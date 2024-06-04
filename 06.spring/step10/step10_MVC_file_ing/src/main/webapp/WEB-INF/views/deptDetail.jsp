<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Detail</title>
<link href="/resources/css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="header.jsp" %>

<!-- action, method -->
<form action="/modify/dept/${dept.deptno}" method="GET" name="detailForm" id="detailForm">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>부서 상세 정보</b>
	            	</font>
	            </p>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부서번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span id="deptno" style="font-size:12pt;">
	        			${dept.deptno}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부 서 명</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${dept.dname}
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부서위치</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			${dept.loc}
	        		</span>
	        	</b>
	        </td>
	    </tr>
   	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">부서파일</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<a href="http://localhost:8082/download/file/${file.attachmentFileNo}">${file.attachmentOriginalFileName}</a>
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
						<input type="submit" value="부서수정">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/main'"></span>
	<span style="font-size:12pt;"><input type="button" value="부서생성" onclick="location.href='/dept'"></span>
	<!-- 부서 삭제 로직 -->
	<span style="font-size:12pt;"><input type="button" value="부서삭제" onclick="deleteDept()"></span>
</div>

<%@ include file="footer.jsp" %>

<script type="text/javascript">
		
	/* https://developer.mozilla.org/en-US/docs/Learn/Forms/Sending_forms_through_JavaScript */
	/* https://www.javascripttutorial.net/javascript-dom/javascript-form/ */
	
	function deleteDept(){
	  let detailForm = document.getElementById("detailForm");
	  let deptno = document.getElementById("deptno").innerText;
	  
	  // type:hidden, 
	  // name:_method, 
	  // value:'DELETE' 값을 가지는 input 태그 내부에서 생성!
  	  let input = document.createElement('input'); 
	  input.type = 'hidden'; 
	  input.name = '_method'; 
	  input.value  = 'DELETE'; 
	  detailForm.appendChild(input); 
	  
	  detailForm.action = '/dept/' + deptno;
	  detailForm.method = 'POST';
	  detailForm.submit();
	}
</script>
</body>
</html>
