package com.spring.pagination.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.pagination.dto.Notice;
import com.spring.pagination.dto.PageRequestDTO;
import com.spring.pagination.dto.PageResponseDTO;
import com.spring.pagination.dto.SearchKeyword;
import com.spring.pagination.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	final NoticeMapper noticeMapper;
	
	@GetMapping("/insert-notice")
	public void insertNotice() {
		
		IntStream.rangeClosed(1, 200)
					.forEach(i -> {
						Notice notice = Notice.builder()
												.no(i)
												.userId("userId : " + i)
												.userName("userName : " + i)
												.title("title : " + i)
												.content("content : " + i)
												.hit(i)
												.build();
						
						noticeMapper.insertNotice(notice);
					});
		
	}
	
	@GetMapping("/search")
	public String moveSearch() {
		return "search";
	}
	
	@GetMapping("/search/keyword")
	public String searchKeyword(@ModelAttribute SearchKeyword searchKeyword,
								Model model) {
		
		System.out.println(searchKeyword);
		
		List<Notice> noticeList = noticeMapper.getNoticeBySearchKeyword(searchKeyword);
		System.out.println(noticeList);
		
		model.addAttribute("noticeList", noticeList);
		
		return "search";
	}
	
	
	@GetMapping("/paging")
	public String paging(@ModelAttribute PageRequestDTO pageRequest,
						 Model model) {
		
		List<Notice> noticeList = noticeMapper.getNoticeByPagination(pageRequest);
		System.out.println(noticeList);
		
		int total = noticeMapper.getTotalCount(pageRequest);
		
		PageResponseDTO pageResponse = new PageResponseDTO(total, 10, pageRequest);
		System.out.println(pageResponse);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageInfo", pageResponse);
		
		return "pagination";
	}

	@GetMapping("/main")
	public String mainMethod(@ModelAttribute PageRequestDTO pageRequest,
							Model model) {
		
		List<Notice> noticeList = noticeMapper.getNoticeWithPageRequest(pageRequest);
		int total = noticeMapper.getTotalCount(pageRequest);
		PageResponseDTO pageResponse = new PageResponseDTO(total, 10, pageRequest);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageInfo", pageResponse);
		
		return "main";
	}


	
}











