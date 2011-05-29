package CSE135S.Struts.dataentry.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.sql.rowset.*;

import com.sun.rowset.CachedRowSetImpl;

public class ApplicantsModel 
{
	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private static String selectUnassignedApplicants = "select id from applicants where reviewerid = 0";
	private static String selectApplicants = "select * from applicants";
	private static String selectApplicantByReviewer = "select applicants.id AS id, applicants.firstname, applicants.lastname, applicants.statusid, applicant_status.name AS status from applicants INNER JOIN applicant_status ON applicants.statusid = applicant_status.id where applicants.reviewerid = (select user_ref from user_roles where user_name= ?)";
		
	public static ArrayList<Integer> getUnassignedApplicants()
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectUnassignedApplicants);
			
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

	public static CachedRowSet getApplicants()
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectApplicants);
			
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
	
	public static CachedRowSet getApplicants(String reviewer)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectApplicantByReviewer);
			
			statement.setString(1, reviewer);
			
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
