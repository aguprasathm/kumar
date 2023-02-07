package com.techpalle;

import java.sql.*;

public class A 
{
	Connection con=null;
	Statement s=null;                                                        
	PreparedStatement ps=null;
	
	public static String url="jdbc:mysql://localhost:3306/jdbc";
	public static String username="root";
	public static String password="admin";
	
	public void creating()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			s=con.createStatement();
			s.executeUpdate("create table emp(eid int primary key auto_increment"
					+ ",ename varchar(40) not null,esal int,email varchar(50) unique)");
			//s.executeUpdate("insert into emp values('agu',30000)");
			s.close();  
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
												
			 catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void inserting(String name,int sal,String mail)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement("insert into emp(ename,esal,email) values(?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, sal);
			ps.setString(3, mail);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updating(int id,String name,int sal,String mail)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement("update emp set ename=?,esal=?,email=? where eid=?");
			ps.setString(1, name);
			ps.setInt(2, sal);
			ps.setString(3, mail);
			ps.setInt(4,id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleting(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement("delete from emp where eid=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}






