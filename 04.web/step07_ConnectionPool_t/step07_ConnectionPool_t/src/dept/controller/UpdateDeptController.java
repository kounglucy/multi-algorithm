package dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDAO;
import dept.dto.Dept;

@WebServlet("/updateDept.do")
public class UpdateDeptController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		/*
		 * 시나리오
		 * 1) 화면으로부터 전달받은 3개 정보 유무 판단
		 * 2) 전달받은 deptno를 가지고 해당 부서 존재 유무 판단
		 * 3) 해당 부서 O -> 전달받은 나머지 dname, loc 수정 -> 상세 페이지로 이동
		 * 	  		X -> 에러 페이지 이동
		 * 4) 이동 결과 확인
		 * 
		 */
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		if(deptno == null || dname == null || loc == null) {
			return;
		}
		
		boolean result = false;
		Dept dept = null;
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept == null) {
				request.setAttribute("error", "해당 부서 미존재");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			} else {
				dept.setDname(dname);
				dept.setLoc(loc);
				
				result = DeptDAO.updateDept(dept);
			}
			
			if(result) {
				url = "/getDept.do?deptno=" + deptno;
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "부서 정보 수정 실패");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("error", "부서 정보 수정 실패");
			request.getRequestDispatcher(url).forward(request, response);
		} 
	}
}