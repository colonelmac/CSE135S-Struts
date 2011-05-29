package CSE135S.Struts.dataentry.models;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class ReviewersModel 
{

	private static String connectionString = "jdbc:postgresql://localhost/CSE135S?user=postgres&password=postgrespass";
	private static String selectReviewStatus = "select inreview from review_status";
	private static String updateReviewStatus = "update review_status set inreview='1'";
	private static String selectReviewers = "select user_ref AS id, user_name from user_roles where role='reviewer'";
	private static String deleteReviewer = "delete from user_roles where user_ref = ?; delete from users where user_id = ?;"; 
	private static String updateApplicant = "update applicants set reviewerid = ?, statusid = '2' where id = ?";
	private static String selectReviewerCount = "select COUNT(*) from applicants where reviewerid = ?";
	
	public static boolean hasReviewStarted()
	{	
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectReviewStatus);
			
			results.next();
			
			return results.getBoolean(0);
		}
		catch(Exception ex)
		{
			//do something
		}
		
		return false;	
	}

	public static void startReview()
	{	
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			statement.executeQuery(updateReviewStatus);
		}
		catch(Exception ex)
		{
			//do something
		}
	}
	
	public static CachedRowSet getReviewers()
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectReviewers);
			
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
	
	public static void createReviewer(String username, String password)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement createUser = connection.prepareStatement("INSERT INTO users (user_name, password) VALUES (?, md5(?))", Statement.RETURN_GENERATED_KEYS);
		
			createUser.setString(1, username);
			createUser.setString(2, password);
			
			createUser.execute();
			
			ResultSet results = createUser.getGeneratedKeys();
			
			results.next();
			
			createUser = connection.prepareStatement("INSERT INTO user_roles (user_ref, user_name, role) VALUES (?, ?, ?)");
			
			createUser.setInt(1, results.getInt(1));
			createUser.setString(2, username);
			createUser.setString(3, "reviewer");
			
			createUser.execute();	
		}
		catch(Exception ex)
		{
			//do something
		}
	}
	
	public static void deleteReviewer(int id)
	{	
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(deleteReviewer);
			
			statement.setInt(1, id);
			statement.setInt(2, id);
			
			statement.executeQuery();
		}
		catch(Exception ex)
		{
			//do something
		}
	}

	public static void assignReviewer(int reviewer, int applicant)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(updateApplicant);
			
			statement.setInt(1, reviewer);
			statement.setInt(2, applicant);
			
			statement.executeQuery();
		}
		catch(Exception ex)
		{
			//do something
		}
	}

	public static int getApplicantCountByReviewer(int reviewer)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectReviewerCount);
			
			statement.setInt(1, reviewer);
			
			ResultSet results = statement.executeQuery();
			
			results.next();
			
			return results.getInt(1);
		}
		catch(Exception ex)
		{
			//do something
		}
		
		return 0;	
	}
}
