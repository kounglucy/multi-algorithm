package com.spring.mongodb;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.spring.mongodb.dto.Rating;


@Controller
public class MongoController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MongoController.class);

	@RequestMapping(value = "/connectionTest", method = RequestMethod.GET)
	public String connectionTest() {
		
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		System.out.println(mongoClient);
		
		// dev 콘솔 출력
		System.out.println(mongoTemplate.getDb().getName());
		
		return "home";
	}
	
	
	    // db.rating.find()
		@RequestMapping(value = "/find-all/rating", method = RequestMethod.GET)
		public String findAllRating() {
			
			// findAll메소드 
			List<Rating> ratingAllList = mongoTemplate.findAll(Rating.class, "rating");
			ratingAllList.forEach((rating) -> {System.out.println(rating);}); // foreach(배열 반복) 
			return "home";
		}
		
		
		// db.rating.find({rating : 4})
		@RequestMapping(value = "/find/rating4", method = RequestMethod.GET)
		public String findRating4() {
			
			List<Rating> ratingValue4List 
			= mongoTemplate.find(new Query(Criteria.where("rating").is(4)), 
												Rating.class, "rating");
//          ratingValue4List.forEach((rating) -> {System.out.println(rating);});
			
			
//			 find
//			 {} 			<--> new Query();
//			 {rating : 4} <--> new Query(Criteria.where("rating").is(4))

			
			// db.rating.find({rating : {$gte : 4}})
			// find and where 사용해서 mongodb 조회하기 
			List<Rating> ratingValueOver4List 
					     = mongoTemplate.find(new Query(Criteria.where("rating").gte(4)), 
									     Rating.class, "rating");
			
	
		   // ratingValueOver4List.forEach((rating) -> {System.out.println(rating);});
			
			
			return "home";
		}
		
		
	
            // [insert rating]
			@RequestMapping(value = "/insert/rating", method = RequestMethod.GET)
			public String insertRating() {

				List<Rating> newRatings = new ArrayList<Rating>();
				
				newRatings.add(new Rating(12.0, 2.0, 12.0));
				newRatings.add(new Rating(13.0, 1.0, 13.0));
				
			// mongoTemplate.insertAll(newRatings);
				
				mongoTemplate.insert(new Rating(14.0, 2.0, 14.0), "rating");
	      
				return "home";
			}
			

		  
		   // [update rating] db.rating.update()
		   @RequestMapping(value = "/update/rating", method = RequestMethod.GET)
		   public String updateRating() {
			
			// updateone (단일 데이터 수정 :update와 사용법은 동일 단, 단일 데이터만 수정) 
			// db.rating.updateOne({})
			// mongoTemplate.updateFirst(query, update, entityClass)
			
			// updateMany (다수 데이터 수정)
			// db.rating.updateMany({_id : 14}, {$set : {rating : 5}})
			   
			Query query = new Query();
			Criteria criteria = Criteria.where("_id").is(14);
			query.addCriteria(criteria);
			
			Update update = Update.update("rating", 5);
			
			mongoTemplate.updateMulti(query, update, Rating.class);
			
			return "home";
		}



		// [deleteRating] db.rating.delete()
		@RequestMapping(value = "/delete/rating", method = RequestMethod.GET)
		public String deleteRating() {
			
			// db.rating.remove({}) 
			// _id : 11인 하나의 값만 삭제하는 Query
//								Query query = new Query();
//								Criteria criteria = Criteria.where("_id").is(11);
//								query.addCriteria(criteria);
			
			// _id : 12 또는 13 두개 이상의 값을 삭제하는 Query
			Query query = new Query();
			Criteria criteria = new Criteria();
			criteria.orOperator(
								Criteria.where("_id").is(12),
								Criteria.where("_id").is(13)
								);
			query.addCriteria(criteria);
			
			mongoTemplate.remove(query, Rating.class);
			
			return "home";
		}
		

							      							
}
