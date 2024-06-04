package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/save")
public class StateSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // step02 : session
		HttpSession session1 = request.getSession();
		System.out.println(session1.getAttribute("sessionId"));
		
		session1.setAttribute("sessionGrade", "junior");
		
		response.sendRedirect("sessionFinal");
  
  	// ste01 : cookie
		// 추가 쿠키 생성, 저장
		
		Cookie cookie2 = new Cookie("cookieGrade", "junior");
		cookie2.setMaxAge(60 * 60 * 24 * 365); // 1년
		response.addCookie(cookie2);
		
	}
}