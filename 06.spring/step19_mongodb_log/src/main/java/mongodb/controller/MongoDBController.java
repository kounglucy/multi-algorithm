package mongodb.controller;

import java.util.List;

import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MongoDBController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping("/mongo")
	public void mongoTest() {
		System.out.println("---");
		System.out.println(mongoTemplate.getDb().getName());
		
		// boot <-> spring-data-mongodb
		List<Document> ratingList = mongoTemplate.find(new Query(), Document.class, "rating");
		
		System.out.println(ratingList);
		
	}
	
}
