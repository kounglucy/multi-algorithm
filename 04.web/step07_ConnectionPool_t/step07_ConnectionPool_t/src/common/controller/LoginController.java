package common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors/error.jsp";
		
		/* 
		 * 시나리오
		 * 1) empno, ename 값이 프론트로 부터 서버로 전송 확인
		 * 			전송 X -> 에러 페이지 이동
		 * 			전송 O -> 로그인 기능 수행
		 * 2) EmpDAO, Emp 생성 -> db 접근 
		 * 			해당 사원 X -> 에러 페이지 이동
		 * 			해당 사원 O -> 메인 페이지 이동
		 * 
		 */
			
    String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		
		if(empno == null || empno == "" || ename == null || ename == "") {
			request.setAttribute("error", "사원번호, 사원명 재확인");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
     
     
     
	}
}