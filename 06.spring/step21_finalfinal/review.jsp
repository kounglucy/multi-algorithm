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
    		
  <div class = "placereview" id = "placereview">
         <div> 
         	<!-- 장소1 -->
	    	<div class = "place1">
	    		<img src="https://cdn.pixabay.com/photo/2022/10/15/16/44/night-view-7523474_1280.jpg" alt="남산 서울타워" ></div>
	    	<div class="starsscore1">
		        <input type="radio" id="stars15" name="score1" value="5" />
				<label for ="stars15" title = "5" class="half">★</label>
				<input type="radio" id="stars14" name="score1" value="4" />
				<label for ="stars14" title = "4" class="half">★</label>
				<input type="radio" id="stars13" name="score1" value="3" />
				<label for ="stars13" title = "3" class="half">★</label>
				<input type="radio" id="stars12" name="score1" value="2" />
				<label for ="stars12" title = "2" class="half">★</label>
				<input type="radio" id="stars11" name="score1" value="1" />
				<label for ="stars11" title = "1" class="half">★</label>	
	        </div>
   		</div>
		
		<!-- 장소2 -->
    	<div class = "place2">
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2018/11/09/11/00/seoul-3804293_1280.jpg" alt="청계천" ></div>
   			<div class="starsscore2">
	      		<input type="radio" id="stars25" name="score2" value="5" />
				<label for ="stars25" title = "5" class="half">★</label>
				<input type="radio" id="stars24" name="score2" value="4" />
				<label for ="stars24" title = "4" class="half">★</label>
				<input type="radio" id="stars23" name="score2" value="3" />
				<label for ="stars23" title = "3" class="half">★</label>
				<input type="radio" id="stars22" name="score2" value="2" />
				<label for ="stars22" title = "2" class="half">★</label>
				<input type="radio" id="stars21" name="score2" value="1" />
				<label for ="stars21" title = "1" class="half">★</label>	
        	</div>
    	</div>
		
		<!-- 장소3 -->
    	 <div  class = "place3">
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2014/05/02/18/07/seoul-336169_1280.jpg" alt="인사동" ></div>
    		<div class="starsscore3">
	      		<input type="radio" id="stars35" name="score3" value="5" />
				<label for ="stars35" title = "5" class="half">★</label>
				<input type="radio" id="stars34" name="score3" value="4" />
				<label for ="stars34" title = "4" class="half">★</label>
				<input type="radio" id="stars33" name="score3" value="3" />
				<label for ="stars33" title = "3" class="half">★</label>
				<input type="radio" id="stars32" name="score3" value="2" />
				<label for ="stars32" title = "2" class="half">★</label>
				<input type="radio" id="stars31" name="score3" value="1" />
				<label for ="stars31" title = "1" class="half">★</label>	
           	</div>
    	</div>
			
		<!-- 장소4 -->	
    	 <div  class = "place4">
    		<div>
		    	<img src="https://cdn.pixabay.com/photo/2015/05/02/11/39/faux-wood-749803_1280.jpg" alt="합정동" ></div>
	    	<div class="starsscore4" >
	     		<input type="radio" id="stars45" name="score4" value="5" />
				<label for ="stars45" title = "5" class="half">★</label>
				<input type="radio" id="stars44" name="score4" value="4" />
				<label for ="stars44" title = "4" class="half">★</label>
				<input type="radio" id="stars43" name="score4" value="3" />
				<label for ="stars43" title = "3" class="half">★</label>
				<input type="radio" id="stars42" name="score4" value="2" />
				<label for ="stars42" title = "2" class="half">★</label>
				<input type="radio" id="stars41" name="score4" value="1" />
				<label for ="stars41" title = "1" class="half">★</label>	
           	</div>
    	</div>
		 
		 <!-- 장소5 -->
    	 <div  class = "place5">
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2017/10/01/13/35/bridge-2805540_1280.jpg" alt="한강" ></div>
    		<div class="starsscore5">
	     		<input type="radio" id="stars55" name="score5" value="5" />
				<label for ="stars55" title = "5" class="half">★</label>
				<input type="radio" id="stars54" name="score5" value="4" />
				<label for ="stars54" title = "4" class="half">★</label>
				<input type="radio" id="stars53" name="score5" value="3" />
				<label for ="stars53" title = "3" class="half">★</label>
				<input type="radio" id="stars52" name="score5" value="2" />
				<label for ="stars52" title = "2" class="half">★</label>
				<input type="radio" id="stars51" name="score5" value="1" />
				<label for ="stars51" title = "1" class="half">★</label>	
           	</div>
        </div>
   </div>
   		<!-- 코스 -->
   		<!-- 학습의 의미로써 의도적으로 여기에 있는 별점 입력 시 첫 번째 장소의 별점이 매기도록 작성하였습니다. 
   			  위에서 작성한 장소 리뷰 코드와 review.css를 이해하면 동작하도록 충분히 수정할 수 있습니다. 
   		-->
    	<div class = "coursereview">
    	    <h1>코스 리뷰 </h1>
    	    <span class="text-bold">별점을 선택해주세요</span>
    	    <div class="starsscore">
				<input type="radio" id="stars15" name="score1" value="5" />
				<label for ="stars15" title = "5" class="half">★</label>
				<input type="radio" id="stars14" name="score1" value="4" />
				<label for ="stars14" title = "4" class="half">★</label>
				<input type="radio" id="stars13" name="score1" value="3" />
				<label for ="stars13" title = "3" class="half">★</label>
				<input type="radio" id="stars12" name="score1" value="2" />
				<label for ="stars12" title = "2" class="half">★</label>
				<input type="radio" id="stars11" name="score1" value="1" />
				<label for ="stars11" title = "1" class="half">★</label>	
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
</body>
</html> 

<!-- 
기존 코드 (변경 사항과 비교할 때 참고하세요!)
<div class = "placereview" id = "placereview">
         <div>
	    	<div class = "place1">
	    		<img src="https://cdn.pixabay.com/photo/2022/10/15/16/44/night-view-7523474_1280.jpg" alt="남산 서울타워" ></div>
	    	<div class="starsscore1">
		        <input type="radio" id="stars5" name="score1" value="5" />
				<label for ="stars5" title = "5" class="half">★</label>
				<input type="radio" id="stars4" name="score1" value="4" />
				<label for ="stars4" title = "4" class="half">★</label>
				<input type="radio" id="stars3" name="score1" value="3" />
				<label for ="stars3" title = "3" class="half">★</label>
				<input type="radio" id="stars2" name="score1" value="2" />
				<label for ="stars2" title = "2" class="half">★</label>
				<input type="radio" id="stars1" name="score1" value="1" />
				<label for ="stars1" title = "1" class="half">★</label>	
	        </div>
   		</div>

    	<div  class = "place2">
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2018/11/09/11/00/seoul-3804293_1280.jpg" alt="청계천" ></div>
   			<div class="starsscore2">
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

    	 <div  class = "place3">
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

    	 <div  class = "place4">
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

    	 <div  class = "place5">
    		<div>
    			<img src="https://cdn.pixabay.com/photo/2017/10/01/13/35/bridge-2805540_1280.jpg" alt="한강" ></div>
    		<div class="starsscore5">
	     		<input type="radio" id="stars" name="score" value="5" />
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


 -->