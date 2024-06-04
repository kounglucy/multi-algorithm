<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/updatereview.css">
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <form action="/review/${course_review_id}" method="POST" id = "reviewForm">
      <input type="hidden" name="_method" value="PUT" id="hiddenMethod" />
    <div class = "coursereview">
    	<div>
    	    <h1>코스 리뷰 </h1>
    	    <span class="text-bold">별점을 선택해주세요</span>
    	    <div class="starsscore">
    	    <input type="radio" id="stars5" name="score" value="5" />
            <label for ="stars5" title = "5" class="half">★</label>
            <input type="radio" id="stars4" name="score" value="4"/>
            <label for ="stars4" title = "4" class="half">★</label>
            <input type="radio" id="stars3" name="score" value="3" />
            <label for ="stars3" title = "3" class="half">★</label>
            <input type="radio" id="stars2" name="score" value="2" />
            <label for ="stars2" title = "2" class="half">★</label>
            <input type="radio" id="stars1" name="score" value="1" />
            <label for ="stars1" title = "1" class="half">★</label>
            </div>
        <div>    
  	<textarea class = "text" name = "content" required> ${coursereview.content} </textarea>
	</div>
		   
	    <div>
	    	<input type="button" value="수정" class = "update-button" onclick ="updateCourse()">
	    	<input type="button" value="삭제" class = "delete-button" onclick ="deleteCourse()">
	    </div>
	   
	   
	 </div>
</div>
</form>
<script type="text/javascript">
     
      // db값에 있는 별점을 가져오기 위해 제이쿼리 사용 
      $(document).ready(function () {
    	  
    	  if(1 <=  ${coursereview.courseScore} && ${coursereview.courseScore} <= 5){
      		var starId = '#stars' + ${coursereview.courseScore};     		
      		$(starId).attr("checked", true)	
      	  }
      })

      function deleteCourse(){
  	      
  	  	  let reviewForm = document.getElementById("reviewForm");
  	  	  let hiddenMethod = document.getElementById("hiddenMethod");
   	  
  	   	  hiddenMethod.value = 'DELETE';
   	  	  reviewForm.submit();
    	}
      
       function updateCourse(){
  	      
  	  	  let reviewForm = document.getElementById("reviewForm");
  	  	  let hiddenMethod = document.getElementById("hiddenMethod");
   	  
  	   	  hiddenMethod.value = 'PUT';
   	  	  reviewForm.submit();
    	}
    </script>
</body>
</html>