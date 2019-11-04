package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDao 
{
	public List<Users>  getAllUser ()
	{
		List<Users> plist = new ArrayList<Users>();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql="Select * from employee";
			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				Users p = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				plist.add(p);
			}
			con.close();
		} 
		catch (Exception s)
		{	
			System.out.println(s); 
		}		
		return plist;
	}
	
	
	
	
	
	public boolean registerUser(Users users)
	{
		boolean result = false;
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement pst=connection.prepareStatement("Insert INTO employee Values(?,?,?,?,?)");
			pst.setString(1 , users.getEid());
			pst.setString(2, users.getFname());
			pst.setString(3, users.getLname());
			pst.setString(4, users.getDoj());
			pst.setString(5, users.getDept());
			int rs = pst.executeUpdate();
			if (rs>0) 
				result=true;
		} 
		catch (Exception s)
		{
			System.out.println(s);
		}
		finally
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean removeUser(String eid)
	{
		boolean result = false;
		Connection connection=null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement pst=connection.prepareStatement("delete from employee where eid=?");
			pst.setString(1 , eid);
			int rs = pst.executeUpdate();
			if (rs>0) 
				result=true;
		} 
		catch (Exception s)
		{
			System.out.println(s);
		}
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}
}
