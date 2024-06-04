package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/invalid")
public class SessionInvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 세션 무효화
		 * -> login.html 이동
		 */
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("sessionId"));
		
		// 세션 무효화
		session.invalidate();
		session = null;
		
		response.sendRedirect("login.html");
	}
}
