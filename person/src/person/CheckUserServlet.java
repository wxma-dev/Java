package person;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import bean.User;
import person.User;
import person.Dao;

public class CheckUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() 
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String name = new String (request.getParameter("user").getBytes("ISO8859_1"), "GBK");
		String pwd = new String (request.getParameter("pwd").getBytes("ISO8859_1"),"UTF-8");
		User user = new User();
		user.setUser(name);
		user.setPwd(pwd);
		Dao dao = new Dao();
		boolean isLogin;
		try
		{
			isLogin = dao.checkUser(user);
			if(isLogin)
			{
				response.sendRedirect("showplan.jsp");
			}
			else
			{ 
				response.sendRedirect("index.jsp");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		doPost(request,response);
	}

	public void init() throws ServletException {
	}

}


