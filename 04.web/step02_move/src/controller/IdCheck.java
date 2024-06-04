package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.html - id : dev 로그인 성공 / 실패 페이지로 이동
		String id = request.getParameter("id");
		System.out.println(id);
		
		// forward(상태 데이터값 유지) vs redirect (상태 유지 불필요)
		
		
		
	}
}