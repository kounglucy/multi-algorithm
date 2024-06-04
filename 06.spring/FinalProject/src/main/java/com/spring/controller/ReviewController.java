package com.spring.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Review;
import com.spring.service.ReviewService;

@Controller
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewService service;
	
	@GetMapping(value="/review")
	public String hom2() {
		return "review";
	}
	
	
	
//	/* 리뷰 작성 */
//	@RequestMapping(value = "/reviewenroll/{userId}", method = RequestMethod.GET)
//	public String revieweEnrollWindow(@PathVariable String userId, int courseId,
//								      Model model) throws Exception {
//		
//		Course course = courseService.getCourseIdName(courseId);
//		
//		
//		model.addAttribute("courseInfo", course);
//		model.addAttribute("userId", userId);
//		
//		return "reviewenroll";
//	}
//	
//	/* 리뷰 수정  */
//	@RequestMapping(value = "/updatereivew", method = RequestMethod.POST)
//	public String reviewupdateWindow(Review review,  Model model) throws Exception {
//		
//		Course course = courseService.getCourseIdName(courseId);
//		
//		model.addAttribute("courseInfo", course);
//		model.addAttribute("reviewInfo", ReviewService.updateReview((review.getReviewId()));
//		model.addAttribute("userId",review.getUserId());
//		
//		return "updatereview";
//	}
//	
//	
	
	
}
