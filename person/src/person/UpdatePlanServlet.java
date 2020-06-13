package person;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdatePlanServlet extends HttpServlet {

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

		String sId                = new String ( request.getParameter("button_id").getBytes("ISO8859_1"),"UTF-8");
		String sPlan_name         = new String ( request.getParameter("textarea_sPlan_name").getBytes("ISO8859_1"),"UTF-8");
		String sDatenum_consuming = new String ( request.getParameter("textarea_sDatenum_consuming").getBytes("ISO8859_1"),"UTF-8");
		String sDatenum_interval  = new String ( request.getParameter("textarea_sDatenum_interval").getBytes("ISO8859_1"),"UTF-8");
		String sByy               = new String ( request.getParameter("textarea_sByy").getBytes("ISO8859_1"),"UTF-8");
		String sImportance        = new String ( request.getParameter("textarea_sImportance").getBytes("ISO8859_1"),"UTF-8");
		String sEmergency         = new String ( request.getParameter("textarea_sEmergency").getBytes("ISO8859_1"),"UTF-8");
		String sComplete_flag     = new String ( request.getParameter("textarea_sComplete_flag").getBytes("ISO8859_1"),"UTF-8");
		String sFlag_del_an_plan = "";
		
		try
		{
			sFlag_del_an_plan = new String( request.getParameter("flag_del_an_plan").getBytes("ISO8859_1"),"UTF-8");
		}
		catch (NullPointerException e)
		{
			sFlag_del_an_plan = "0";
		}
		
		Plan plan = new Plan();
		plan.setid               ( Integer.parseInt(sId) );
		plan.setplan_name        ( sPlan_name );
		plan.setdatenum_consuming( Integer.parseInt(sDatenum_consuming) );
		plan.setdatenum_interval ( Integer.parseInt(sDatenum_interval) );
		plan.setbyy              ( sByy );
		plan.setimportance       ( Integer.parseInt(sImportance) );
		plan.setemergency        ( Integer.parseInt(sEmergency) );
		plan.setcomplete_flag    ( Integer.parseInt(sComplete_flag) );
		plan.setflag_del_an_plan ( Integer.parseInt(sFlag_del_an_plan) );

		if( 1 == Integer.parseInt(sFlag_del_an_plan) )
		{
			Dao dao = new Dao();
			dao.DeltePlan(plan);
		}
		else
		{
			Dao dao = new Dao();
			dao.UpdatePlan(plan);
		}
		
		PrintWriter out = response.getWriter();
		if( 1 == Integer.parseInt(sFlag_del_an_plan) )
		{
			out.print("<script language=javascript>alert(\"delete success\");");
		}
		else
		{
			out.print("<script language=javascript>alert(\"update success\");");
		}
		out.print("</script>");
		out.print("<script language=javascript>window.close();");
		out.print("</script>");

		//response.sendRedirect("showplan.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		doPost(request,response);
	}

	public void init() throws ServletException {
	}

}
