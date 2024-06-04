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

@WebServlet("/getDept.do")
public class GetDeptController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		String deptno = request.getParameter("deptno");
		
		if(deptno == null) {
			return;
		}
		
		Dept dept = null;
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept == null) {
				request.setAttribute("error", "존재 하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}else {
				request.setAttribute("dept", dept);
				url = "dept/getDept.jsp";
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("error", "부서 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		} 
	}
}