package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 시나리오
		 * login.html -> id 전달
		 * -> controller(/check) : id null?! -> 쿠키 생성 / 저장
		 * -> service(/save) : 추가 쿠키 생성 / 저장
		 * -> view(/cookieFinal) : 쿠키 획득
		 * 
		 */
		
		String id = request.getParameter("id");
		
		// step01 : cookie
		if(id != null) {
			// cookie 객체 생성
			Cookie cookie1 = new Cookie("cookieId", id);

			// cookie 시간 설정 : 클라이언트에 저장되어 존재하는 시간(초)
			cookie1.setMaxAge(60 * 60 * 24); // 1일
			
			// 클라이언트에 저장
			response.addCookie(cookie1);
			
			response.sendRedirect("save");
		}
	}
}