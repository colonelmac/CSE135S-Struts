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
	private static String selectReviewerApplicants = "select * from applicants where reviewerid = (select user_ref from user_roles where user_name= ?)";
	private static String insertReviewerComment = "insert into review_comments (grade, comment, applicantid, reviewerid) values (?, ?, ?, (select user_id from users where user_name = ?))";
	private static String selectSuggestedReviewers = "select * from user_roles where role = 'reviewer' AND user_ref NOT IN(select reviewerid  from review_comments where applicantid = ?)";
	private static String selectReviewerCommentCount = "select count(*) from review_comments where applicantid = ?";
	
	public static boolean hasReviewStarted()
	{	
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			Statement statement = connection.createStatement();
			
			ResultSet results = statement.executeQuery(selectReviewStatus);
			
			results.next();
			
			return results.getBoolean(1);
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

	public static int getApplicantReviewCount(int applicant)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectReviewerCommentCount);
			
			statement.setInt(1, applicant);
			
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
	
	public static CachedRowSet getApplicantsByReviewer(String reviewer)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectReviewerApplicants);
			
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

	public static void createReviewerComment(int grade, String comment, int applicantid, String reviewer)
	{	
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(insertReviewerComment);
			
			statement.setInt(1, grade);
			statement.setString(2, comment);
			statement.setInt(3, applicantid);
			statement.setString(4, reviewer);
			
			statement.executeQuery();
		}
		catch(Exception ex)
		{
			//do something
		}
	}

	public static CachedRowSet getSuggestedReviewers(int applicant)
	{
		try
		{	
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(connectionString);
			
			PreparedStatement statement = connection.prepareStatement(selectSuggestedReviewers);
			
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
}
