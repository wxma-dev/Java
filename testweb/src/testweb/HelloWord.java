package testweb;
/*
import javax.servlet.http.HttpServlet;

public class HelloWord extends HttpServlet {

}
*/

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

public class HelloWord extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, 
		ServletException {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("Hello Servlet!");
		}
}

