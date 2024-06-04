package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionFinal")
public class SessionFinal extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session1 = request.getSession();
		
		out.println(session1.getAttribute("sessionId") + "<br/>");
		out.println(session1.getAttribute("sessionGrade") + "<br/>");
		
		/*
		 * 세션의 경우 서비스가 지속되는 이상 세션 객체는 계속해서 존재
		 * -> 서비스 정책상 알맞지 않으므로 해당 세션 객체는 삭제(로그아웃)
		 * 
		 * 실습) 
		 * 로그아웃 버튼 생성
		 * 
		 */
		
		out.println("<button onclick='location.href = \"invalid\"'>logout</button>");
	}
}
