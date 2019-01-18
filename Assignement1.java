
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Assignement1 {
	public static Connection getConnetction() throws Exception{
		try {
		String url = "jdbc:mysql://localhost:3306/sqlandjava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "user";
		String password = "password";
		
		Connection conn = DriverManager.getConnection(url,username,password);
		System.out.println("Connected to database!");
			return conn;
			
		}	catch (Exception e) {System.out.println(e);}
		return null;
				
	}

public static void main (String[] args) throws Exception{
	
	Connection conn = getConnetction();
	Statement statement = conn.createStatement();
	
	ResultSet res = statement.executeQuery("select * from people");
	while (res.next()) {
		System.out.println(res.getString("person_id")+": "+
							res.getString("firstname")+" "+
							res.getString("lastname"));
	}
}
}
