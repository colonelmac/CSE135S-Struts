package CSE135S.Struts.dataentry.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class MyApplicationModel 
{
	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private static String selectMajors = "SELECT * FROM applicants WHERE user_name = ?";
	private static String selectStatus = "SELECT applicants.user_name, applicants.uuid, applicant_status.name AS status FROM applicants INNER JOIN applicant_status ON applicants.statusid = applicant_status.id  WHERE applicants.user_name = ?";
	
	public static boolean findApplicant(String user_name)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectMajors);
			
			statement.setString(1, user_name);
			
			ResultSet results = statement.executeQuery();
			
			if(results.next())
			{
				return true;
			}
			
			results.close();
			statement.close();
			
			return false;
		}
		catch(Exception ex)
		{
			//do something
		}
		
		return false;
	}
	
	public static RowSet getAppStatus(String user_name)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectStatus);
			
			statement.setString(1, user_name);
			
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
