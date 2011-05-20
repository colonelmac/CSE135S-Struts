package CSE135S.Struts.dataentry.models;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class LocationsModel 
{	
	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private static String selectCountries = "SELECT id, name FROM locations WHERE isstate = '0'";
	private static String selectCountriesWithoutUS = "SELECT id, name FROM locations WHERE name != 'United States'";
	private static String selectStates = "SELECT id, name FROM locations WHERE isstate = '1'";
	
	public static CachedRowSet getAllCountries(boolean includeUS) 
	{		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = null;
			
			if(includeUS)
			{
				results = statement.executeQuery(selectCountries);
			}
			else
			{
				results = statement.executeQuery(selectCountriesWithoutUS);
			}
			
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
	
	public static CachedRowSet getAllStates()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectStates);
			
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
