package naver.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import naver.dto.Book;
import naver.dto.NaverResult;
import naver.dto.Post;
import naver.dto.User;

@Controller
public class BookController {
	
	// Naver Search API-Book
	@Value("${naver.search.api.book.client.id}")
	private String clientId;
	
	@Value("${naver.search.api.book.client.secret}")
	private String clientSecret;
	
	@GetMapping("/api/search/book")
	public String naverSearchBookAPI(@RequestParam String query,
									  Model model) {
		
		// url
		String url = "https://openapi.naver.com/v1/search/book.json?query=" + query;
		
		// requestEntity : header에 id, secret 지정하여 요청을 보내야 하기 때문!
		RequestEntity<Void> requestEntity = RequestEntity
											.get(url)
											.header("X-Naver-Client-Id", clientId)
											.header("X-Naver-Client-Secret", clientSecret)
											.build();
		
		
		// restTemplate
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		
		// ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		NaverResult naverResult = null;
		
		try {
			naverResult = objectMapper.readValue(responseEntity.getBody(), NaverResult.class);
		}catch(JsonMappingException e) {
			e.printStackTrace();
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		List<Book> bookList = naverResult.getItems();
		model.addAttribute("bookList", bookList);
		
		return "book";
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/rest-template")
	public void getRestTemplate() {
		// https://jsonplaceholder.typicode.com/posts
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		// RestTemplate 객체 생성
		RestTemplate restTemplate = new RestTemplate();
		
		// ResponseEntity
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		
//		System.out.println(responseEntity);
		
		// statusCode
//		System.out.println(responseEntity.getStatusCode());
		
		// headers
//		System.out.println(responseEntity.getHeaders());
		
		// body 
//		System.out.println(responseEntity.getBody());
		
		// ObjectMapper
		// step01 ObjectMapper 사용 방법
		// 생성
		ObjectMapper objectMapper = new ObjectMapper();
		
		// writeValue : java -> json
		// writeValue(결과 파일, java객체)
		
		// readValue : json -> java
		// readValue(대상 파일, java 객체)
//		User user = new User("dev", 27);
		
		try {
//			objectMapper.writeValue(new File("user.json"), user);
			// {"name":"dev","age":27}
//			User convertedUser = objectMapper.readValue(new File("user.json"), User.class);
			
//			String jsonObject = "{\"name\":\"dev\",\"age\":27}";
//			
//			User convertedUser = objectMapper.readValue(jsonObject, User.class);
//			System.out.println(convertedUser);
//
//			String jsonArrayObject = "[{\"name\":\"dev\",\"age\":27}, {\"name\":\"devops\",\"age\":30}]";
//			
//			List<User> userList = objectMapper.readValue(jsonArrayObject, new TypeReference<List<User>>() {});
//			System.out.println(userList);
			
			// responseEntity.getBody() -> java 객체로 바꾸려면?
			
			List<Post> userList = objectMapper.readValue(responseEntity.getBody(), new TypeReference<List<Post>>() {});
			System.out.println(userList.size());
			
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}