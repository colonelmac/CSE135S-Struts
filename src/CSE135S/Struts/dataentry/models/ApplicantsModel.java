package CSE135S.Struts.dataentry.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ApplicantsModel 
{
	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private final static String selectApplicants = "select id from applicants where reviewerid = 0";
	
	public static ArrayList<Integer> getUnassignedApplicants()
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectApplicants);
			
			ArrayList<Integer> apps = new ArrayList<Integer>();
			
			while(results.next())
			{
				apps.add(results.getInt(1));
			}
			
			return apps;
		}
		catch(Exception ex)
		{
			//do something
		}
		
		return null;	
	}
}
