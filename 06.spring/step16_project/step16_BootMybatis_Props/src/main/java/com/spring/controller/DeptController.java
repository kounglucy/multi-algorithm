package com.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.AttachmentFile;
import com.spring.dto.Dept;
import com.spring.service.AttachmentFileService;
import com.spring.service.DeptService;

@Controller
public class DeptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptService service;
		
	@Autowired
	private AttachmentFileService fileService;
	
	// http://localhost:8081/dept/10
	@RequestMapping(value = "/find/{deptno}", method = RequestMethod.GET)
	public String getDeptno(@PathVariable int deptno, 
								  Model model) throws Exception {
		Dept dept = service.getDeptByDeptno(deptno);
		
		// 해당 부서의 파일 출력 로직 추가!!!
		
		model.addAttribute("dept", dept);
		
		return "home";
	}
		
	// http://localhost:8082/dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.GET)
	public String getDeptByDeptno(@PathVariable int deptno, 
									  Model model) {
			Dept dept = null;
			try {
				dept = service.getDeptByDeptno(deptno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 해당 부서의 파일 출력 로직 추가!!!
			AttachmentFile attachmentFile = fileService.getAttachmentFileByDeptno(deptno);
			
			model.addAttribute("dept", dept);
			model.addAttribute("file", attachmentFile);
			
			
			return "deptDetail";
		}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		List<Dept> deptList = service.getAllDepts();
		
		model.addAttribute("deptList", deptList);
		
		return "main";
	}
	

	// http://localhost:8081/dept
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public String insertDeptForm() {
		return "registerDept";
	}
	
	// http://localhost:8081/dept
	
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public String insertDept(@ModelAttribute Dept newDept,
							 @RequestParam("file") MultipartFile file,
							 Model model) {
		String view = "error";
		
		System.out.println(newDept);
		System.out.println(file.getOriginalFilename());
		
		// service.inserDept 성공하면 -> main, 실패하면 -> error
		boolean deptResult = false;
		boolean fileResult = false;
		
		try {
			deptResult = service.insertDept(newDept);
			
			// step01 : 파일 저장 로직도 추가 생성!!!
			/*
			 고려사항) 논리적인 흐름 : dept 저장 + file 저장 -> insertDept 한번에 같이 개발
			 -> 추후 발생할 수 있는 문제 : file만 저장하고 싶은데 반드시 dept 함께 저장해야함!!
			 => 확장성을 고려하여 fileService라는 별도의 로직을 구성하는 것이 합당
			 dept는 dept대로 file은 file대로 넘겨줘야
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
								Model model) {
		Dept dept = null;
		try {
			dept = service.getDeptByDeptno(deptno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("dept", dept);
		
		return "updateDept";
	}
	
	// http://localhost:8082/dept/10
		@RequestMapping(value = "/dept/{deptno}")
		public String updateDept(@PathVariable int deptno,
								@ModelAttribute("dname") String dname,
								@ModelAttribute("loc") String loc) {
			String view = "error";
			// dname, loc 확인 O
			// deptno로 기존 dept 객체 확인 -> 위에서 확인한 dname, loc 해당 객체 setter
			// 제대로 update가 되었다고 한다면 -> dept/{deptno} detail 페이지로 이동
			boolean result = false;
			
			Dept dept = null;
			try {
				dept = service.getDeptByDeptno(deptno);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dept.setDname(dname);
			dept.setLoc(loc);
			
			try {
				 result = service.updateDnameAndLoc(dept);
				 
				 if(result) {
//					 view = "redirect:/dept/" + deptno;
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
	
	
}
