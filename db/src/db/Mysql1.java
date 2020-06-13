package db;

import java.sql.*;

public class Mysql1{
	public static void main(String[] args){
		String dbUrl = "jdbc:mysql://localhost:3306/person";
		String user = "root";
		String password = "q";
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection c = DriverManager.getConnection(dbUrl,user,password);
			Statement s = c.createStatement();

			ResultSet r = s.executeQuery("SELECT id,plan_name FROM plan");
			while(r.next()){
				System.out.println(r.getString("id")+" "+r.getString("plan_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}



