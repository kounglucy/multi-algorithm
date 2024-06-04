package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class StateView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step01 : cookie 확인
//		System.out.println(request.getCookies());
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			if("junior".equals(cookie.getValue())) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
			}
		}
	}
}