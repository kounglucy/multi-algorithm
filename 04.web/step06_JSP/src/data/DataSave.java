package data;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class DataSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오
		 * 1) 쿠키 객체 생성/설정/저장
		 * 2) 페이지 이동(step02_EL.jsp)
		 */
		
		Cookie cookie = new Cookie("id", "dev");
		cookie.setMaxAge(60 * 60);
		
		response.addCookie(cookie);
		
		response.sendRedirect("step02_EL.jsp");
		
		// 세션, 요청객체, ...
		
	}
}