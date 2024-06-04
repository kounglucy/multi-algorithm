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
    	<div>
   			<div class="sidebar">
    			<%@include file="sidebar.jsp" %>
    		</div>
    		
     <div class = "placereview">
        <div  class = "place1">
	    	<div>
	    		<img src="https://cdn.pixabay.com/photo/2022/10/15/16/44/night-view-7523474_1280.jpg" alt="남산 서울타워" ></div>
	    	<div class="starsscore1">
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
   		</div>

    	<div  class = place2>
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2018/11/09/11/00/seoul-3804293_1280.jpg" alt="청계천" ></div>
   			<div class="starsscore2">
	      		<input type="radio" id="stars25" name="score" value="5" />
				<label for ="stars5" title = "5" class="half">★</label>
				<input type="radio" id="stars24" name="score" value="4" />
				<label for ="stars4" title = "4" class="half">★</label>
				<input type="radio" id="stars23" name="score" value="3" />
				<label for ="stars3" title = "3" class="half">★</label>
				<input type="radio" id="stars22" name="score" value="2" />
				<label for ="stars2" title = "2" class="half">★</label>
				<input type="radio" id="stars21" name="score" value="1" />
				<label for ="stars1" title = "1" class="half">★</label>	
        	</div>
    	</div>

    	 <div  class = place3>
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2014/05/02/18/07/seoul-336169_1280.jpg" alt="인사동" ></div>
    		<div class="starsscore3">
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
    	</div>

    	 <div  class = place4>
    		<div>
		    	<img src="https://cdn.pixabay.com/photo/2015/05/02/11/39/faux-wood-749803_1280.jpg" alt="합정동" ></div>
	    	<div class="starsscore4" >
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
    	</div>

    	 <div  class = place5>
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2017/10/01/13/35/bridge-2805540_1280.jpg" alt="한강" ></div>
    		<div class="starsscore5">
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
        </div> 
   </div>
   
    	<div class = "coursereview">
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