package dao;

import java.sql.*;

import javax.servlet.http.HttpSession;

import dbpack.DBUtils;
import entity.User;

public class UserDao {

	/*public String login(User user)throws Exception
	{
		Connection con=DBUtils.getConnection();
		PreparedStatement psmt=con.prepareStatement("select * from user9 where mail=? and pass=?");
		psmt.setString(1, user.getMail());
		psmt.setString(2, user.getPassword());
		ResultSet rs=psmt.executeQuery();
		if(rs.next())
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}*/
	public ResultSet login(User user)throws Exception
	{
		Connection con=DBUtils.getConnection();
		PreparedStatement psmt=con.prepareStatement("select * from user9 where mail=? and pass=?");
		psmt.setString(1, user.getMail());
		psmt.setString(2, user.getPassword());
		ResultSet rs=psmt.executeQuery();
		return rs;
	}
	
}
