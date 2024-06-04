<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
	<!-- https://getbootstrap.com/docs/5.3/forms/form-control/ -->
	<div>
		<form id="mainForm" class="row justify-content-center g-3" action="/main" method="GET">
			<div class="col-auto">
				<label for="keyword" class="visually-hidden">Search</label> 
					<input	
						type="text" 
						class="form-control" 
						id="keyword"
						placeholder="Keyword" 
						name="keyword"
						<%-- value를 넣어주면 이전에 검색했던 키워드가 남아있음. --%>
						value="${pageInfo.pageRequest.keyword}">
			</div>
			<div class="col-auto">
			        <input type="hidden" name="pageNum" value="${pageInfo.pageRequest.pageNum}">
			        <input type="hidden" name="amount" value="${pageInfo.pageRequest.amount}">
					<input type="submit" class="btn btn-primary mb-3" value="Search" />
			</div>
		</form>
	</div>
	<!-- https://getbootstrap.com/docs/5.3/components/list-group/ -->
	<div class="row justify-content-center">
		<div class="col-6">
			<ul class="list-group">
				<c:if test="${not empty noticeList}">
					<c:forEach var="notice" items="${noticeList}">
						<li class="list-group-item d-flex justify-content-between align-items-start">
							<div class="ms-2 me-auto">
								<div class="fw-bold">${notice.title}</div>
								${notice.content}
							</div> <span class="badge bg-primary rounded-pill">${notice.hit}</span>
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
	<!-- Paging -->
	<!-- https://getbootstrap.com/docs/5.3/layout/columns/#alignment -->
	<!-- https://getbootstrap.com/docs/5.3/components/pagination/#disabled-and-active-states -->
 	<div class="row justify-content-center">
		<div class="col-6">
			<nav class="page navigation">
				<ul class="pagination">
					<c:if test="${pageInfo.prev}">
						<li class="page-item">
							<a class="page-link" aria-label="Previous" 
								<%--href="/main?pageNum=${pageInfo.startPage - 1}&amount=${pageInfo.pageRequest.amount}">Prev</a> --%>
								href="#">Prev</a>
						</li>
					</c:if>
					<c:forEach var="num" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
						<li class="page-item ${pageInfo.pageRequest.pageNum == num ? "active" : "" } ">
							<a class="page-link" 
							<%-- href="/main?pageNum=${num}&amount=${pageInfo.pageRequest.amount}&keyword=${pageInfo.pageRequest.keyword}">${num}</a> --%>
							href="#">${num}</a>
						</li>
					</c:forEach>
					<c:if test="${pageInfo.next}">
						<li class="page-item next">
							<a class="page-link" aria-label="next" 
								<%--href="/main?pageNum=${pageInfo.endPage + 1}&amount=${pageInfo.pageRequest.amount}">Next</a> --%>
								href="#">Next</a>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>
<!-- 페이징 버튼 클릭시 => pageNum, amount, keyword -->
	<script type="text/javascript">
	
	// step01 : 페이징 버튼 클릭시 지정 url 요청 갈수 있도록 이벤트 등록
	Array.from(document.getElementsByClassName('page-link'))
		.forEach((pagingButton) => {
			pagingButton.addEventListener('click', function(e) {
				e.preventDefault();
				// step02 : 등록 후, action : '/main' 으로 요청 시, keyword 값 유무에 따라 queryString 변경
				// step03 : 요청
				let mainForm = document.getElementById('mainForm');
				
				// 현재 페이지 값으로 변경하여 /main 요청하도록 지정
				mainForm.pageNum.value = e.target.innerHTML; 
				
				if(mainForm.keyword.value == '') {
					mainForm.keyword.remove();
				}
				
				mainForm.action = '/main';
				mainForm.method = 'GET';
				mainForm.submit();
			})
	})

</script>
</body>
</html>