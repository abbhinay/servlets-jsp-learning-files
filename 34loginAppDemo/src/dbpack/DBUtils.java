package dbpack;
import java.sql.*;
public class DBUtils {

	static Connection con=null;
	public static Connection getConnection()throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","abc123");
		return con;
	}
}
