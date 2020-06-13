package person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePlanFinishFlagServlet extends HttpServlet {

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
		
		String sTmp = new String (request.getParameter("finishflag").getBytes("ISO8859_1"),"UTF-8");
		
		String sid = sTmp.substring(2);
		String sfinishflag = sTmp.substring(0,1);
		
		int iid=Integer.parseInt(sid);
		int ifinishflag=Integer.parseInt(sfinishflag);
		
		Plan plan = new Plan();
		plan.setid( iid );
		plan.setcomplete_flag( ifinishflag );

		Dao dao = new Dao();
		dao.updateFinishFlag(plan);
		response.sendRedirect("showplan.jsp");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		doPost(request,response);
	}

	public void init() throws ServletException {
	}
	
}
