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

@WebServlet("/deleteDept.do")
public class DeleteDeptController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		String deptno = request.getParameter("deptno");
		
		if(deptno == null) {
			return;
		}
		
		boolean result = false;
		
		Dept dept = null;
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept == null) {
				request.setAttribute("error", "존재 하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			} else {
				result = DeptDAO.deleteDeptByDeptno(dept.getDeptno());
			}
			
			if(result) {
				url = "/getDeptList.do";
				response.sendRedirect(url);
				return;
			}else {
				request.setAttribute("error", "부서 삭제 실패");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("error", "부서 삭제 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
