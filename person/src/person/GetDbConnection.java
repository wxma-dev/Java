package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* 
* 用JDBC的方法获得数据库的连接
*
*/
public class GetDbConnection 
{
	//通过静态方法注册驱动，获得连接

	public static Connection getConnection()
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/person";

		Connection con = null;
		try
		{
			Class.forName(driver);
			try
			{
				con = DriverManager.getConnection(url,"root","q");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		System.out.println("已获得数据库的连接");
		return con;
	}
}
