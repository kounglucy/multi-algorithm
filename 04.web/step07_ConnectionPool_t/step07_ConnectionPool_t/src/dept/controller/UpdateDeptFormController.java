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

@WebServlet("/updateDeptForm.do")
public class UpdateDeptFormController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		String deptno = request.getParameter("deptno");
		
		if(deptno == null) {
			return;
		}
		
		Dept dept = null;
		try {
			dept = DeptDAO.getDeptByDeptno(Integer.parseInt(deptno));
			
			if(dept == null) {
				request.setAttribute("error", "해당 부서 미존재");
				request.getRequestDispatcher(url).forward(request, response);
			} else {
				request.setAttribute("dept", dept);
				url = "dept/updateDept.jsp";
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("error", "해당 부서 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
