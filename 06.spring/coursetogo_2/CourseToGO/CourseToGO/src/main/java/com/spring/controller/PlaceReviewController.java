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
import com.spring.service.PlaceReviewService;

@Controller
public class PlaceReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(PlaceReviewController.class);
	
	@Autowired
	private PlaceReviewService service;
	
	

}
