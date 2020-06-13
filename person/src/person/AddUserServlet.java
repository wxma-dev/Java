package person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.Dao;
import person.User;

public class AddUserServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	* Destruction of the servlet. <br>
	*/
	public void destroy() 
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		response.setContentType("text/html");
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String user1 = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"),"utf-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO8859_1"),"utf-8");
		String age1 = request.getParameter("age");
		User user = new User();
		user.setUser(user1);
		user.setPwd(pwd);
		user.setName(name);
		user.setsex(sex);
		int age;

		if(age1!=null)
		{
			age = Integer.parseInt(age1);
			user.setAge(age);
		}
		Dao dao = new Dao();
		dao.addUser(user);

		request.getRequestDispatcher("checkuser.jsp").forward(request,response);
	}

	public void init() throws ServletException 
	{
		// Put your code here
	}
}


