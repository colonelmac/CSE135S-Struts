package CSE135S.Struts.dataentry.models;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class MajorsModel 
{
	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private static String selectMajors = "SELECT id, name FROM majors";
	
	public static CachedRowSet getMajors()
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectMajors);
			
			CachedRowSet crs = new CachedRowSetImpl();
			
			crs.populate(results);
			
			results.close();
			statement.close();
			
			return crs;
		}
		catch(Exception ex)
		{
			//do something
		}
		
		return null;
		
	}
}
