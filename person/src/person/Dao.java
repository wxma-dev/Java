package person;
import java.util.Date;
import java.text.SimpleDateFormat;

import person.GetDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

import person.User;

/*
创建对应的表
create table user(
id int primary key auto_increment,
user varchar(50) not null,
pwd varchar(50) not null,
name varchar(50) not null,
sex varchar(50) not null,
age int(50) not null
);
*/

public class Dao {
	private Connection conn;
	private PreparedStatement pstat;
	String sql="";

	/*
	* 用户登录
	*/
	public boolean checkUser(User user) throws SQLException
	{
		conn = GetDbConnection.getConnection();
		boolean i = false;
		sql = "select * from user where user=? and pwd=?";

		pstat = conn.prepareStatement(sql);

		pstat.setString( 1, user.getUser());
		pstat.setString( 2, user.getPwd());

		ResultSet rs1 = (ResultSet) pstat.executeQuery();
		if (rs1.next())
		{
			i = true;
			rs1.close();
			pstat.close();
		}
		else 
		{
			i = false ;
			rs1.close();
			pstat.close();
		}
		conn.close();
		return i;
	}

	/*
	* 用户注册
	*/
	public void addUser(User user)
	{
		conn = GetDbConnection.getConnection();
		sql = "insert into user(user,pwd,name,sex,age) values(?,?,?,?,?)";

		try
		{
			pstat = conn.prepareStatement(sql);
			pstat.setString( 1, user.getUser());
			pstat.setString( 2, user.getPwd());
			pstat.setString( 3, user.getName());
			pstat.setString( 4, user.getsex());
			pstat.setInt(    5, user.getAge());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

	/*
	 * 更新plan表中的完成情况字段
	 */
	public void updateFinishFlag(Plan plan)
	{
		conn = GetDbConnection.getConnection();
		sql = "update plan set complete_flag=? where id=?;";

		try
		{
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,plan.getcomplete_flag());
			pstat.setInt(2,plan.getid());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/*
	* 增加规划、计划
	*/
	public void InsertPlan(Plan plan)
	{
		conn = GetDbConnection.getConnection();
		sql = "insert into plan(plan_name,datenum_consuming,datenum_interval,nextdate_review,byy,importance,emergency,complete_flag) values(?,?,?,?,?,?,?,?)";
		
		//当天日期
		Date dt=new Date();
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
		String rq=matter1.format(dt);
		
		try
		{
			pstat = conn.prepareStatement(sql);
			pstat.setString( 1, plan.getplan_name()        );
			pstat.setInt(    2, plan.getdatenum_consuming());
			pstat.setInt(    3, plan.getdatenum_interval() );
			pstat.setString( 4, rq );
			pstat.setString( 5, plan.getbyy()              );
			pstat.setInt(    6, plan.getimportance()       );
			pstat.setInt(    7, plan.getemergency()       );
			pstat.setInt(    8, plan.getcomplete_flag()    );
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	* 修改规划、计划
	*/
	public void UpdatePlan(Plan plan)
	{
		conn = GetDbConnection.getConnection();
		sql = "update plan set plan_name=?,datenum_consuming=?,datenum_interval=?,byy=?,importance=?,complete_flag=?,emergency=? where id=?";

		try
		{
			pstat = conn.prepareStatement(sql);
			pstat.setString( 1, plan.getplan_name()        );
			pstat.setInt(    2, plan.getdatenum_consuming());
			pstat.setInt(    3, plan.getdatenum_interval() );
			pstat.setString( 4, plan.getbyy()              );
			pstat.setInt(    5, plan.getimportance()       );
			pstat.setInt(    6, plan.getcomplete_flag()    );
			pstat.setInt(    7, plan.getemergency()        );
			pstat.setInt(    8, plan.getid()    );
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/*
	* 删除某一计划
	*/
	public void DeltePlan(Plan plan)
	{
		conn = GetDbConnection.getConnection();
		sql = "delete from plan where id=?";

		try
		{
			pstat = conn.prepareStatement(sql);
			pstat.setInt(    1, plan.getid()    );
			pstat.executeUpdate();
			pstat.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
