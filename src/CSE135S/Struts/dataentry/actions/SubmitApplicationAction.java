package CSE135S.Struts.dataentry.actions;

import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import CSE135S.Degree;
import CSE135S.SQL;

public class SubmitApplicationAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
									HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		UUID uuid = UUID.randomUUID();
		
		try
		{
			Class.forName("org.postgresql.Driver");
		
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/CSE135S?" + 
										"user=postgres&password=postgrespass");
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO Applicants (firstname, lastname, middleinitial, countrycode, areacode, phonenumber, " +
																	  "citizenshipid, residenceid, state, address, city, zipcode, uuid) " + 
																      "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ); ", Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, (String)session.getAttribute("firstName"));
			statement.setString(2, (String)session.getAttribute("lastName"));
			statement.setString(3, (String)session.getAttribute("middleInitial"));
			
			if( session.getAttribute("countrycode") != null )
			{
				if( !session.getAttribute("countrycode").toString().equals("null") )
					statement.setInt(4, Integer.parseInt(session.getAttribute("countrycode").toString()));
			}
			else
			{
				statement.setNull(4, Types.INTEGER);
			}
			
			statement.setInt(5, Integer.parseInt((String)session.getAttribute("areacode")));
			statement.setInt(6, Integer.parseInt((String)session.getAttribute("phoneNumber")));
			
			statement.setInt(7, Integer.parseInt(session.getAttribute("citizenship").toString()));
			statement.setInt(8, Integer.parseInt(session.getAttribute("residence").toString()));
			statement.setInt(9, Integer.parseInt(session.getAttribute("state").toString()));
			
			statement.setString(10, (String)session.getAttribute("address"));
			statement.setString(11, (String)session.getAttribute("city"));
			statement.setInt(12, Integer.parseInt((String)session.getAttribute("zipcode")));
			
			statement.setObject(13, uuid); 
			
			statement.execute();
			
			ResultSet results = statement.getGeneratedKeys();
			results.next();
			
			for(Degree d : (ArrayList<Degree>)session.getAttribute("degrees"))
			{
				statement = connection.prepareStatement("INSERT INTO degrees (applicantid, title, majorid, specializationid, universityid, graduationdate, gpa)" + 
														"VALUES (?, ?, ?, ?, ?, ?, ?)");
				
				statement.setInt(1, results.getInt(1));
				statement.setString(2, d.title);
				statement.setInt(3, d.major);
				
				int spec = d.specialization;
				if( spec == 0 )
					statement.setNull(4, Types.INTEGER);
				else
					statement.setInt(4, spec);
				
				statement.setInt(5, d.university);
				statement.setDate(6, d.graduationDate);
				statement.setInt(7, d.gpa);
				
				statement.execute();
				
				SQL.incrementApplicantCount("specializations", d.specialization);
				SQL.incrementApplicantCount("majors", d.major);
			}
		}
		catch(Exception ex) 
		{ 
			//do something 
		}
		
		return mapping.findForward("success");
	}
}
