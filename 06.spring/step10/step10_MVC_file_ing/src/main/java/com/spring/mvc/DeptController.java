package com.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.AttachmentFile;
import com.spring.dto.Dept;
import com.spring.service.AttachmentFileService;
import com.spring.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Controller
public class DeptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptService service;
        // 추가
		@Autowired
		private AttachmentFileService fileService;
		
		// http://localhost:8082/dept/10
		@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.GET)
		public String getDeptByDeptno(@PathVariable int deptno, 
									  Model model) throws Exception {
			Dept dept = service.getDeptByDeptno(deptno);
			
			// 해당 부서의 파일 출력 로직 추가!!!
			AttachmentFile attachmentFile = fileService.getAttachmentFileByDeptno(deptno);
			
			model.addAttribute("dept", dept);
	        model.addAttribute("file", attachmentFile);
	        
			return "deptDetail";
		}
		
		// 보조강사
		@RequestMapping(value = "/dept", method = RequestMethod.GET)
		public String insertDeptForm() {
			return "registerDept";
		}
		
	  // 변경
		
		@RequestMapping(value = "/dept", method = RequestMethod.POST)
		public String insertDept(@ModelAttribute Dept newDept,
								 @RequestParam("file") MultipartFile file,
								 Model model) {
			String view = "error";
			
			boolean deptResult = false;
			boolean fileResult = false;
			
			try {
				deptResult = service.insertDept(newDept);
				
				// step01 : 파일 저장 로직도 추가 생성!!!
				/*
				 고려사항) 논리적인 흐름 : dept 저장 + file 저장 => insertDept 한번에 같이 개발	
				 				-> 추후 발생할 수 있는 문제 : file만 저장하고 싶은데 반드시 + dept 함께 저장해야만 함
				 		=> 확장성을 고려하여 fileService 별도의 로직을 구성하는 것이 합당
				 */
				
				int deptno = newDept.getDeptno();
				
				fileResult = fileService.insertAttachmentFile(file, deptno);
				
				if(deptResult && fileResult) {
					view = "redirect:/main";
					return view;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return view;
			}
			
			return view;
		}
	
	// http://localhost:8082/modify/dept/10
	@RequestMapping(value = "/modify/dept/{deptno}", method = RequestMethod.GET)
	public String updateDeptForm(@PathVariable int deptno,
								Model model) throws Exception {
		Dept dept = service.getDeptByDeptno(deptno);
		
		model.addAttribute("dept", dept);
		
		return "updateDept";
	}
	
	// http://localhost:8082/dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.PUT)
	public String updateDept(@PathVariable int deptno,
							@ModelAttribute("dname") String dname,
							@ModelAttribute("loc") String loc) throws Exception {
		String view = "error";
		// dname, loc 확인 O
		// deptno로 기존 dept 객체 확인 -> 위에서 확인한 dname, loc 해당 객체 setter
		// 제대로 update가 되었다고 한다면 -> dept/{deptno} detail 페이지로 이동
		boolean result = false;
		
		Dept dept = service.getDeptByDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		
		try {
			 result = service.updateDnameAndLoc(dept);
			 
			 if(result) {
//				 view = "redirect:/dept/" + deptno;
				 return "redirect:/dept/" + deptno;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		
		return view;
	}
	
	// http://localhost:8082/dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.DELETE)
	public String deleteDept(@PathVariable int deptno) {
		String view = "error";
		
		System.out.println(deptno);
		
		boolean result = false;
		
		try {
			// deleteDeptByDeptno(int deptno)
			result = service.deleteDeptByDeptno(deptno);
			
			if(result) {
				view = "redirect:/main";
				return view;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		
		return view;
	}
	
//	// 예외 step02 : LoginController 내부에서 발행하는 모든 NPE 처리
//	@ExceptionHandler({Exception.class})
//	public ModelAndView nullPointerExceptionHandler(Exception exception) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("exception", exception);
//		mv.setViewName("error");
//		return mv;
//	}
	
	// http://localhost:8082/api/dept/{deptno}
		@CrossOrigin(origins = {"*"})
		@RequestMapping(value = "/api/dept/{deptno}", 
						method = RequestMethod.GET,
						produces = {MediaType.APPLICATION_JSON_VALUE})
		public Dept getDeptByDeptno(@PathVariable int deptno) {
			
			/* 시나리오
			 	@PathVariable int deptno 값으로 
			 	db까지 가서 해당 부서가 있는지 존재 여부 확인 api 메소드
			 	-> 현재 전달된 deptno 해당 부서가 존재하지 않는다는 예외 발생
			 */
			Dept dept = null;
			
			if(dept == null) {
				throw new NullPointerException("해당 부서가 존재하지 않습니다.");
			}
			
			return dept;
		}
	  
	 	@ExceptionHandler(value = {NullPointerException.class})
		public ResponseEntity<String> handleNullPointerException(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
}
