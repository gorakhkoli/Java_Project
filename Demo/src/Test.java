import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test {

	public static void main(String[] args) 
	{
		Connection conn = null;
		try {
			conn  = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/local1", "root", "root");
			if(conn !=null)
			{
				System.out.println("connection establish");
				Statement  statement  =  (Statement) conn.createStatement();
				ResultSet set =  statement.executeQuery("select * from employee");
				while(set.next())
				{
					System.out.println(set.getInt(1));
					System.out.println(set.getString(2) );
		  			System.out.println(set.getString(3));
				}
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
