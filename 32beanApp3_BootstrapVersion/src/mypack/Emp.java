package mypack;
import java.sql.*;
public class Emp {

	private String name,mail,pass;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean register()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			PreparedStatement psmt=con.prepareStatement("insert into user9 values(?,?,?)");
			psmt.setString(1,name);
			psmt.setString(2,mail);
			psmt.setString(3,pass);
			int a=psmt.executeUpdate();
			if(a>0)
				return true;
			else
				return false;
		}catch(Exception e)
		{
			return false;
		}
	}
}
