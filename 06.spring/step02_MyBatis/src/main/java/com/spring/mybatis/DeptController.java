package com.spring.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Dept;
import com.spring.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	@RequestMapping(value = "/mybatis", method = RequestMethod.GET)
	public void dept(Locale locale, Model model) {
		
		// 1. getAllDepts()
		List<Dept> deptList = deptService.getAllDepts(); 
//		System.out.println(deptList);
		
		// 2. getDeptByDeptno(int deptno)
		Dept dept = deptService.getDeptByDeptno(10);
//		System.out.println(dept);
    
        // 3. getDnameByDeptno(int deptno)
		String dname = deptService.getDnameByDeptno(10);		
//		System.out.println(dname);
		
		// 4. getDnameByDeptnoAndLoc(int deptno, String loc) 
		String dname2 = deptService.getDnameByDeptnoAndLoc(10,"NEW YORK");
//		System.out.println(dname2);
		
		// 5. getDnameByDeptnoAndLocMap(HashMap<String, Object> hashmap)
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("deptno", 10);
		hashmap.put("loc", "NEW YORK");
			
		String dname3 = deptService.getDnameByDeptnoAndLocMap(hashmap);
//		System.out.println(dname3);
		
		// 6. getAllDeptsHashMap()
//		System.out.println(deptService.getAllDeptsHashMap());
		
				
}

}