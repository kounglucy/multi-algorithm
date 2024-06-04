package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet()");
		
		// step01 : 요청
		// http://localhost:8081/step01_basic/check?id=it&pw=28
		System.out.println(request.getQueryString());
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// step02 : 응답
		// 문제점 : 한글은 화면에 출력 X --> ??
		// 키워드 : response객체, 한글 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>id 출력</h1>");
		out.println("환영합니다 : <b>" + id + "</b>님");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		
		// step01 : 요청
		// http://localhost:8081/step01_basic/check
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// step02 : 응답
		// 문제점 : 한글은 화면에 출력 X --> ??
		// 키워드 : response객체, 한글 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>id 출력</h1>");
		out.println("환영합니다 : <b>" + id + "</b>님");
	}
}

