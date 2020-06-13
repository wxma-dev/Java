package testweb;

/*
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
*/
import javax.servlet.GenericServlet;
import javax.servlet.*;
import java.io.*;

public class HelloServlet extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res)
	{
		//返回hello world！genricse    
		try
		{
			PrintWriter pw = res.getWriter();
			pw.print("Hello,wrold!Generic");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
