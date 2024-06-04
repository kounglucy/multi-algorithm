package step02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/print")
public class Choice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(request.getParameterValues("like"));
		// System.out.println(request.getParameter("like"));
		String[] values = request.getParameterValues("like");
		
		for(String value : values) {
			System.out.println(value);
		}
			
	}

}
