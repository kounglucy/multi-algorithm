package com.spring.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.dto.CourseReview;
import com.spring.service.CourseReviewService;

@Controller
public class CourseReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseReviewController.class);
	
	@Autowired
	private CourseReviewService service;
	
	/* http://localhost:8090/review  */
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String insertCourseReviewForm() {
		
		return "review";
	}
	
	
	/* 리뷰 작성  */ // http://localhost:8090/review 
	@RequestMapping(value = "/review", method= RequestMethod.POST)
	public String insertCourseReview(@ModelAttribute CourseReview coursereview, @RequestParam(value="score" , required=false) int star) throws Exception { 
		
		System.out.println(star);
		System.out.println(coursereview);
		coursereview.setUserId(1); // 임의로 userID 값을 지정 
		coursereview.setCourseId(1); // 임의로 courseId 값을 지정
		coursereview.setCourseScore(star);
		
		service.insertCourseReview(coursereview);
		
		
		return "review";
		
	}

	/* 코스 리뷰 아이디 검색 */ // http://localhost:8090/review/21
	@RequestMapping(value = "/review/{course_review_id}", method = RequestMethod.GET)
	public String updateCourseForm(@PathVariable("course_review_id") int courseReviewId,
								Model model) throws Exception {
		
		// db값에 설정된 코스 리뷰 아이디를 가져오기
		CourseReview coursereview = service.getCourseReviewByReviewId(courseReviewId);
		model.addAttribute("coursereview", coursereview);
		
		return "updatereview";
	}
		
	/* 리뷰 수정 */ // http://localhost:8090/review/21
	@RequestMapping(value = "/review/{course_review_id}", method= RequestMethod.PUT)
	public String updateCourseReview(@PathVariable("course_review_id") int courseReviewId,
			                         @ModelAttribute("content") String content,
			                         @ModelAttribute("score") int courseScore) throws Exception { 
		
		// 코스 리뷰 아이디를 통해서 수정하기 
		CourseReview coursereview = service.getCourseReviewByReviewId(courseReviewId);
		System.out.println(coursereview);
		coursereview.setContent(content);
		coursereview.setCourseScore(courseScore);

		service.updateCourseReview(coursereview);
		
		return "redirect:/review";
		
	}
	
	/* 리뷰 삭제  */ 
	@RequestMapping(value = "/review/{course_review_id}", method= RequestMethod.DELETE)
	public String deleteCourse(@PathVariable("course_review_id") int courseReviewId) throws Exception { 
        
		System.out.println(courseReviewId);
		service.deleteCourseReviewByReviewId(courseReviewId);
		
		
		return "redirect:/review";
		
	}

}

