<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/review.css">
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <form action="/review" method="POST">
    		
    <div class = "coursereview">
    	<div>
    	    <h1>코스 리뷰 </h1>
    	    <span class="text-bold">별점을 선택해주세요</span>
    	    <div class="starsscore">
    	    <input type="radio" id="stars5" name="score" value="5" />
            <label for ="stars5" title = "5" class="half">★</label>
            <input type="radio" id="stars4" name="score" value="4" />
            <label for ="stars4" title = "4" class="half">★</label>
            <input type="radio" id="stars3" name="score" value="3" />
            <label for ="stars3" title = "3" class="half">★</label>
            <input type="radio" id="stars2" name="score" value="2" />
            <label for ="stars2" title = "2" class="half">★</label>
            <input type="radio" id="stars1" name="score" value="1" />
            <label for ="stars1" title = "1" class="half">★</label>
            </div>
        <div> 
  	<textarea class = "text" name = "content" required> 코스 서비스에 대한 리뷰를 입력해주세요. </textarea>
	</div>
		   
	    <div>
	    	<input type = "submit" value ="등록" class = "insert-button">
	    </div>
	   
	
</div>
</div>
	    
</form>
<script type="text/javascript">
      var radioVal;
      $(document).ready(function () {
        $('#stars5').click(function () {
          // getter
         radioVal = $('input[name="score"]:checked').val();
          alert(radioVal);
        });
        $('#stars4').click(function () {
            // getter
             radioVal = $('input[name="score"]:checked').val();
            alert(radioVal);
          }); 
          $('#stars3').click(function () {
              // getter
              radioVal = $('input[name="score"]:checked').val();
              alert(radioVal);
            });
          $('#stars2').click(function () {
              // getter
               radioVal = $('input[name="score"]:checked').val();
              alert(radioVal);
            });
          $('#stars1').click(function () {
              // getter
              radioVal = $('input[name="score"]:checked').val();
              alert(radioVal);
            });
      });
    </script>
</body>
</html>