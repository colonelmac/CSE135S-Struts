package CSE135S.AJAX;

import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.RowSet;

import CSE135S.Degree;
import CSE135S.Struts.dataentry.models.ApplicantsModel;

public class ApplicationServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		PrintWriter out = null;
		
		try
		{
			out = response.getWriter();
		}
		catch(Exception ex)
		{
			//do something
		}
		
		if(request.getParameter("id") != null)
		{
			try
			{
				int id = Integer.parseInt(request.getParameter("id"));
				RowSet applicant = ApplicantsModel.getApplicantById(id);
				RowSet degrees = ApplicantsModel.getApplicantDegrees(id);
				
				applicant.next();
				
				out.println("<h2>" + applicant.getString("firstname") + " " + applicant.getString("lastname") + "</h2>");
				
				out.println("<ul>");
				out.println("<li>Citizenship: " + applicant.getInt("citizenshipid") + "</li>");
				out.println("<li>Residence: " + applicant.getInt("residenceid") + "</li>");
				out.println("<li>" + applicant.getString("address") + "</li>");
				out.println("<li>" + applicant.getString("city") + ", " + applicant.getString("state") + "</li>");
				out.println("<li>" + applicant.getInt("zipcode") + "</li>");
				out.println("<li>" + applicant.getInt("countrycode") + " " + applicant.getInt("areacode") + " " + applicant.getInt("phonenumber") + "</li>");
				out.println("</ul>");
				
				while(degrees.next())
				{
					Degree d = new Degree();
					d.university = degrees.getInt("universityid");
					d.major = degrees.getInt("majorid");
					d.title = degrees.getString("title");
					d.graduationDate = degrees.getDate("graduationdate");
					d.gpa = degrees.getInt("gpa");
					
					out.println("<li>");
						out.println(d.toHTMLString());
						out.println(" - <i>graduating gpa of: </i>" + d.gpa);
					out.println("</li>");
				}
			}
			catch(Exception ex)
			{
				// do something
			}
		}
		else
		{
			out.println("sucks to you!");
		}
	}
}
