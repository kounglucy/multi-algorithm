<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dept Insertion</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/layout.css" rel="stylesheet" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 
</head>
<body>

<%@ include file="header.jsp" %>

<!-- action, method -->
<form action="/dept" method="POST" enctype="multipart/form-data">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336699">
	            <p align="center">
	            	<font color="white" size="3">
	            		<b>새로운 부서 생성</b>
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
	        		<span style="font-size:12pt;">
	        			<input id="deptno" type="text" name="deptno" size="30">
	        		</span>
	        		<br/>
	        		<span id="deptnoMsg" style="font-size:8pt;"></span>
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
	        			<!-- input 박스 -->
	        			<input type="text" name="dname" size="30">
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
	        			<!-- input 박스 -->
	        			<input type="text" name="loc" size="30">
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
	        			<!-- input 박스 -->
	        			<input type="file" name="file" size="30">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
						<input type="submit" value="부서생성">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>
<hr>
<div align=center>
	<span style="font-size:12pt;"><input type="button" value="메인으로" onclick="location.href='/main'"></span>
</div>

<%@ include file="footer.jsp" %>

<script type="text/javascript">
	/* 시나리오
		1) deptno를 입력하는 input태그에 addEventListener('blur', () => {})
		2) blur(unfocus)가 되면 axios 비동기 요청을 서버(http://localhost:8082/api/dept/{deptno}로 보냄
		3) deptno를 @PathVariable로 받아서 -> 해당 부서 유무 확인 
										-> 해당 부서가 존재한다면! : '이미 존재하는 부서번호 입니다.'예외 메세지 출력
										-> 해당 부서가 존재X않는다면 !: '사용가능한 부서번호입니다.' 결과 메세지 출력
	*/
	const inputDeptno = document.getElementById('deptno');
	const deptnoMsg = document.getElementById('deptnoMsg');
		
	inputDeptno.addEventListener('blur', () => {
		axios.get('http://localhost:8082/api/dept/'+inputDeptno.value)
			.then(response => {
				if(response.data == '') {
					deptnoMsg.innerHTML = '새로운 부서 번호로 사용 할 수 있습니다.';
				}
			})
			.catch(error => {
				deptnoMsg.innerHTML = error.response.data;
			})
	});

</script>
</body>
</html>