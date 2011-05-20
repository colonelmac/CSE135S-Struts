package CSE135S.Struts.dataentry.models;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class UniversitiesModel 
{
	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private static String selectUniversitiesById = "SELECT id, name FROM universities WHERE locationid = ? ORDER BY name ASC";

	public static CachedRowSet getUniversitiesById(int locationid)
	{	
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectUniversitiesById);
			
			statement.setInt(1, locationid);
			
			ResultSet results = statement.executeQuery();
			
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
