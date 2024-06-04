<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Detail</title>
<link href="../css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- <%@ include file="../layout/header.jsp" %> -->

<!-- action, method -->
<form action="/updateDeptForm.do" method="POST" name="detailForm" id="detailForm">
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
	            <p align="center"><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<!-- 수정할 부서번호 서버로 전달 -->
	        			<input type="hidden" name="deptno" value="${dept.deptno}">
						<input type="submit" value="부서수정">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/getDeptList.do'"></span>
	<span style="font-size:12pt;"><input type="button" value="부서생성" onclick="location.href='/insertDeptForm.do'"></span>
	<!-- 부서 삭제 로직 -->
	<span style="font-size:12pt;"><input type="button" value="부서삭제" onclick="deleteDept(${dept.deptno})"></span>
</div>

<!-- <%@ include file="../layout/footer.jsp" %> -->

<script type="text/javascript">
		
	/* https://developer.mozilla.org/en-US/docs/Learn/Forms/Sending_forms_through_JavaScript */
	/* https://www.javascripttutorial.net/javascript-dom/javascript-form/ */
	
	function deleteDept(deptno){
	  let detailForm = document.getElementById("detailForm");
	  detailForm.deptno = deptno;
	  detailForm.action = '/deleteDept.do';
	  detailForm.method = 'POST';
	  detailForm.submit();
	}
		
	
</script>
</body>
</html>
