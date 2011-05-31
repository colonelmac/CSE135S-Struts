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
	private static String selectSpecializations = "select * from specializations";
	private static String selectMajors = "select * from majors";
	private static String selectApplicants = "select applicants.id AS id, applicants.firstname, applicants.lastname, applicants.statusid, applicant_status.name AS status from applicants INNER JOIN applicant_status ON applicants.statusid = applicant_status.id";
	private static String selectApplicationById = "select * from applicants where id = ?";
	private static String selectApplicantsBySpecialization = "select applicants.id AS id, applicants.firstname, applicants.lastname, applicants.statusid, applicant_status.name AS status from applicants INNER JOIN applicant_status ON applicants.statusid = applicant_status.id where applicants.id in (select applicantid from degrees where specializationid= ?)";
	private static String selectApplicantsByMajor = "select applicants.id AS id, applicants.firstname, applicants.lastname, applicants.statusid, applicant_status.name AS status from applicants INNER JOIN applicant_status ON applicants.statusid = applicant_status.id where applicants.id in (select applicantid from degrees where majorid = ?)";
	private static String selectApplicantByReviewer = "select applicants.id AS id, applicants.firstname, applicants.lastname, applicants.statusid, applicant_status.name AS status from applicants INNER JOIN applicant_status ON applicants.statusid = applicant_status.id where applicants.reviewerid = (select user_ref from user_roles where user_name= ?)";
	private static String selectApplicantDegrees = "select * from degrees where applicantid = ?";
	private static String selectApplicantAvgGrade = "select COUNT(grade), SUM(grade) from review_comments where applicantid = ?";
	private static String updateApplicantStatus = "update applicants set statusid = ? where id = ?";	
	
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
	
	public static CachedRowSet getApplicantById(int id)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectApplicationById);
			
			statement.setInt(1, id);
			
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

	public static CachedRowSet getApplicantDegrees(int applicant)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectApplicantDegrees);
			
			statement.setInt(1, applicant);
			
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
	
	public static CachedRowSet getApplicantAvgGrade(int applicant)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectApplicantAvgGrade);
			
			statement.setInt(1, applicant);
			
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

	public static CachedRowSet getApplicantsBySpecialization(int specialization)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectApplicantsBySpecialization);
			
			statement.setInt(1, specialization);
			
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

	public static CachedRowSet getApplicantsByMajor(int major)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectApplicantsByMajor);
			
			statement.setInt(1, major);
			
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
	
	public static void updateApplicantStatus(int applicant, String action)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(updateApplicantStatus);
			
			statement.setInt(2, applicant);
			
			if(action.equalsIgnoreCase("accept"))
			{
				statement.setInt(1, 4);
			}
			else if(action.equalsIgnoreCase("reject"))
			{
				statement.setInt(1, 5);	
			}
			else if(action.equalsIgnoreCase("cancel"))
			{
				statement.setInt(1, 2);
			}
			else 
			{
				throw new Exception(); 
			}
			
			statement.executeQuery();
						
			statement.close();
		}
		catch(Exception ex)
		{
			//do something
		}	
	}

	public static CachedRowSet getSecializations()
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectSpecializations);
			
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
