package com.spring.mongodb;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AddFieldsOperation;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.MonoToListenableFutureAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.spring.mongodb.dto.Orders;
import com.spring.mongodb.dto.Rating;


@Controller
public class MongoController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MongoController.class);

	@RequestMapping(value = "/connectionTest", method = RequestMethod.GET)
	public String connectionTest() {
		// mongodb://[username:password@]host1[:port1]
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		System.out.println(mongoClient);
		
		// dev
		System.out.println(mongoTemplate.getDb().getName());
		
		return "home";
	}
	
	// db: dev, collection : rating 의 모든 다큐먼를 반환하는 메소드
	// db.rating.find()
		@RequestMapping(value = "/find-all/rating", method = RequestMethod.GET)
		public String findAllRating() {
			
			// findAll(몽고디비에서 데이터를 가져오는 메소드)
			List<Rating> ratingAllList = mongoTemplate.findAll(Rating.class, "rating");
			ratingAllList.forEach((rating) -> {System.out.println(rating);});
			return "home";
		}
		
		// db.rating.find({rating : 4})
			@RequestMapping(value = "/find/rating4", method = RequestMethod.GET)
			public String findRating4() {
				
				// find
				// {} 			<--> new Query();
				// {rating : 4} <--> new Query(Criteria.where("rating").is(4))
				
				List<Rating> ratingValue4List 
									= mongoTemplate.find(new Query(Criteria.where("rating").is(4)), 
																		Rating.class, "rating");
//				ratingValue4List.forEach((rating) -> {System.out.println(rating);});
				
				// db.rating.find({rating : {$gte : 4}})
				List<Rating> ratingValueOver4List 
								= mongoTemplate.find(new Query(Criteria.where("rating").gte(4)), 
										Rating.class, "rating");
//				ratingValueOver4List.forEach((rating) -> {System.out.println(rating);});
				
				
				return "home";
			}
	
			//[insertRating]
			// db.rating.insert()
			// http://localhost:8082/mongodb/insert/rating
			// db.rating.insert({ _id : 11, rating : 3, user_id : 11 })
			// http://localhost:8082/mongodb/insert/rating
			@RequestMapping(value = "/insert/rating", method = RequestMethod.GET)
			public String insertRating() {
				
				// db.rating.insertOne({ _id : 11, rating : 3, user_id : 11 })
//				mongoTemplate.insert(new Rating(11.0, 3.0, 11.0), "rating"); // ==> 스프링 콘솔에는 정답이 안 나오지만 cmd 몽고디비에는 1개가 추가 됨.
				
				// db.rating.insertMany([{ _id : 12, rating : 2, user_id : 12 },
				// 						 { _id : 13, rating : 1, user_id : 13 }
				// ])
				List<Rating> newRatings = new ArrayList<Rating>();
				newRatings.add(new Rating(12.0, 2.0, 12.0));
				newRatings.add(new Rating(13.0, 1.0, 13.0));
				
//				mongoTemplate.insertAll(newRatings);
				
				mongoTemplate.insert(new Rating(14.0, 2.0, 14.0), "rating");
	      
				return "home";
			}
			
			        //[findRating]


					// db.rating.find()
					// http://localhost:8082/mongodb/find/rating
					@RequestMapping(value = "/find/rating", method = RequestMethod.GET)
					public String findRating() {
								// count
						// long count = mongoTemplate.count(new Query(), Rating.class);
						// System.out.println(count);
						
				    // limit
						// db.rating.find().limit(4)
						// List<Rating> ratingLimitList = mongoTemplate.find(new Query().limit(4), Rating.class);
						// ratingLimitList.forEach((rating) -> {System.out.println(rating);});
				    
				    	// distinct
						// db.rating.distinct("rating")
						// List<Double> ratingDistinctList = mongoTemplate.findDistinct("rating", Rating.class, Double.class);
						// ratingDistinctList.forEach((rating) -> {System.out.println(rating);});
				    
				  		// sort
						// db.rating.find().sort({ user_id : 1})
						// List<Rating> ratingSortedList = mongoTemplate.find(new Query()
						//													.with(Sort.by(Sort.Direction.ASC, "user_id")), Rating.class);
						// ratingSortedList.forEach((rating) -> {System.out.println(rating);});
						
				    // rating 컬렉션에서 rating값이 3 또는 4인 다큐먼트를 출력하려면?
				    // db.rating.find({ $or : [{rating : 3}, {rating : 4}]})
						// hint : orOperator
						/*
					 		Query query = new Query();
							Criteria criteria = new Criteria();
							criteria.orOperator(
												Criteria.where("_id").is(12),
												Criteria.where("_id").is(13)
												);
							query.addCriteria(criteria);
						 */
//				 		Query orOperatorQuery = new Query();
//						Criteria orOperatorCriteria = new Criteria();
//						orOperatorCriteria.orOperator(
//											Criteria.where("rating").is(3),
//											Criteria.where("rating").is(4)
//											);
//						orOperatorQuery.addCriteria(orOperatorCriteria);
//						List<Rating> ratingOrOperatorList = mongoTemplate.find(orOperatorQuery, Rating.class);
//						
//						ratingOrOperatorList.forEach((rating) -> {System.out.println(rating);});
						
				        // regex(Criteria)
						// db.orders.find({order_user : {$regex : /^m/}})
						// db.orders.find({order_user : {$regex : /^m/}}, {id : 0})
						Query regexQuery = new Query();
																		
						Criteria regexCriteria = Criteria.where("order_user").regex("^m");
						regexQuery.addCriteria(regexCriteria);
						
						// db.orders.find({order_user : {$regex : /^m/}}, {_id : 0})
						// 출력하고싶은 필드 선정하는 것 : query.fields()
						// 출력하고 싶은 필드 : include
						// 출력하고 싶지 않은 필드 : exclude
						// 결과 : Orders [_id=null, order_id=999.0, order_user=matt, product_id=123.0]
//						regexQuery.fields().exclude("_id");
//						
//						List<Orders> regexList = mongoTemplate.find(regexQuery, Orders.class);
//						regexList.forEach((orders) -> {System.out.println(orders);});
				    
						// exclude를 사용하면 제외되는 필드가 많아질 수 있음
						// dto객체와 연결시 null 표현이 많아질 수 밖에 없음
						// 이를 해결하기 위해 Document 타입을 사용 할 수 있음
						// 결과 : Document{{order_id=999.0, order_user=matt, product_id=123.0}} ==> orders와 다르게 null이 출력되지 않음.
						
						List<Document> regexDocumentList = mongoTemplate.find(regexQuery, Document.class,"orders");
//						regexDocumentList.forEach((document) -> {System.out.println(document);}); 
						
						// pagination : 페이지당 출력할 객체 개수 지정 및 반환
						// db.zip 컬렌션에서 10개씩만 출력하려면?
						Query paginationQuery = new Query();
						paginationQuery.with(PageRequest.of(0, 10)); // ex) 게시글 목록을 한페이지당 10개만 노출되게 하는 것.
						                                             // (0, 10) 한페이지 게시글 1번부터 10번 출력
						                                             // (1, 10) 그 다음 페이지 게시글 11번부터 20번 출력 ...
						
						List<Document> zipList = mongoTemplate.find(paginationQuery, Document.class, "zip");
						zipList.forEach((document) -> {System.out.println(document);});
						
						return "home";
					}
					
					// [updateRating] -> 리턴타입 자체가 updateResult

					// db.rating.update()
					// http://localhost:8082/mongodb/update/rating
					@RequestMapping(value = "/update/rating", method = RequestMethod.GET)
					public String updateRating() {
						
						// db.rating.updateOne({})
//						mongoTemplate.updateFirst(query, update, entityClass)
						
						// db.rating.updateMany({_id : 14}, {$set : {rating : 5}})
						Query query = new Query();
						Criteria criteria = Criteria.where("_id").is(14);
						query.addCriteria(criteria);
						
						Update update = Update.update("rating", 5);
						
						mongoTemplate.updateMulti(query, update, Rating.class);
						
						return "home";
					}
			
					       //[deleteRating]

							// db.rating.delete()
							// http://localhost:8082/mongodb/delete/rating
							@RequestMapping(value = "/delete/rating", method = RequestMethod.GET)
							public String deleteRating() {
								
								// db.rating.remove({})
								// _id : 11인 하나의 값만 삭제하는 Query
//								Query query = new Query();
//								Criteria criteria = Criteria.where("_id").is(11);
//								query.addCriteria(criteria);
								
								// _id : 12 or 13 두개 이상의 값을 삭제하는 Query
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
							
							 //[deleteRating]

							// db.rating.delete()
							// http://localhost:8082/mongodb/aggregate
							// http://localhost:8082/mongodb/aggregate
						@RequestMapping(value = "/aggregate", method = RequestMethod.GET)
						public String aggregateionMethod() {
								
								// spring-data-mongodb 집계 메소드의 형태
								// aggregation : 집계 객체
								// collectionName : 대상 컬렉션명
								// outputType : 출력 객체 클래스
//								mongoTemplate.aggregate(aggregation, collectionName, outputType)
								
								// $project
								/*
								 db.rating.aggregate([
									{$project : {_id : 0, rating : 1}},
									{$limit :3}
								])
								 */
							ProjectionOperation project = Aggregation.project("rating");
							
							LimitOperation limit = Aggregation.limit(3);
							
					    // $match
							/*
							 db.rating.aggregate([
								{$match : {rating : 3}}
							])
							 */
							MatchOperation match = Aggregation.match(
									Criteria.where("rating").is(3)
							);
							
							// $group
							/*
							 ver1
							 db.rating.aggregate([
								{$group : {rating : 3}}
							])
							
							ver2
							db.rating.aggregate([
								{$group : {_id : "$rating", count : {$sum : 1}}}
							])
							 */
							
//							GroupOperation group = Aggregation.group("rating");
							GroupOperation group = Aggregation.group("rating")
																	.count()
																	.as("count");
							
							 // $group $sort
							/*
							 db.rating.aggregate([
								{$group : {rating : 3}}, {$sort : {_id : 1}
							])
							 */
							SortOperation sort = Aggregation.sort(Sort.Direction.ASC,"_id");
							
							 /*
							 db.items.aggregate([
					                	{$unwind : "$sizes"}
							])
							 */
							UnwindOperation unwind = Aggregation.unwind("sizes");
							
							/*db.scores.aggregate([
	                         {$addFields : {totalHomework : {$sum : "$homework"}}}
                              ])
                              */
							
							// 수치연산 : ArithmeticOperators
							// 누적연산 : count()
							AggregationExpression homeworkSumExpression = ArithmeticOperators.valueOf("homework").sum();
							
							AddFieldsOperation addFields = Aggregation.addFields()
									                                  .addField("totalHomwork")
									                                  .withValueOf(homeworkSumExpression)
									                                  .build();
							
								/*db.orders.aggregate(
		                     [
			                 {
						     $lookup : {
							  from : "products"
			                , localField : "product_id"
			                , foreignField : "product_id"
				            , as : "order_product"
								}
						     	}
						     ]
					         ).pretty()
							  */
							LookupOperation lookup = Aggregation.lookup("products", "product_id", "product_id", "order_product");
							
							Aggregation aggregation = Aggregation.newAggregation(lookup); // ==> 몽고디비에 새로운 필드 추가하는 코드
							
							
							AggregationResults<Document> projectList = mongoTemplate.aggregate(aggregation, "orders", Document.class);
							
							projectList.forEach((document) -> {System.out.println(document);});

							return "home";
						}
					  
							      							
}
