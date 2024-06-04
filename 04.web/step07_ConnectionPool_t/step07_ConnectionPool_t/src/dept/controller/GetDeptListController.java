package dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDAO;
import dept.dto.Dept;

@WebServlet("/getDeptList.do")
public class GetDeptListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		ArrayList<Dept> deptList = null;
		try {
			deptList = DeptDAO.getDeptList();
			
			if(deptList == null) {
				// option1
//				response.sendRedirect(url);
				
				// option2
				request.setAttribute("error", "모든 부서 정보 미존재");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}else {
				request.setAttribute("deptList", deptList);
				url = "dept/getDeptList.jsp";
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			request.setAttribute("error", "모든 부서 정보 출력 실패");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
	}
}

