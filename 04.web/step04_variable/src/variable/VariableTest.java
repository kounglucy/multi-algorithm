package variable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// initParam : p181
//@WebServlet("/var")
@WebServlet(urlPatterns = {"/var"},
			initParams = {@WebInitParam(name="charset", value="UTF-8")})
public class VariableTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 전역 변수 : 전체 시스템(서블릿 객체)에서 공유하는 변수
    //		 : 서블릿 변수, 컨텍스트 변수, ...
	// context : 서블릿 컨테이너가 관리하는 모든 영역
	String charset = "UTF-8";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로컬 변수 : 각각의 작업 단위에서 사용되어지는 변수
		int i = 0;
		/* 
		 * 시나리오
		 * 2명의 user가 현재 프로젝트 접속 가정
		 * 서비스 : user : 1 ~ 100 출력
		 * 쿼리 스트링 userId = user1, userId = user2 
		 */
		
		// 초기 설정된 값을 불러오는 메소드
		String charset = getInitParameter("charset");
		System.out.println(charset);
		
		String userId = request.getParameter("userId");
		
		response.setContentType("text/html;charset="+charset);
		PrintWriter out = response.getWriter();
		
		while(i++ < 100) {
			out.println(userId + " : " + i + "<br/>");
			out.flush();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}
}
