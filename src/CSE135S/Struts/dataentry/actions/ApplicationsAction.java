package CSE135S.Struts.dataentry.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.ApplicantsModel;


public class ApplicationsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws SQLException
	{
		RowSet applicants = null;
		
		if(request.getParameter("reviewer") != null)
		{
			applicants = ApplicantsModel.getApplicants(request.getParameter("reviewer"));
			
			while(applicants.next())
			{
				int id = Integer.parseInt(applicants.getString("id").toString());
				
				RowSet grades = ApplicantsModel.getApplicantAvgGrade(id); 
				grades.next();
				
				int count = grades.getInt("count");
				int sum = grades.getInt("sum");
				
				double avg = (double)sum / count; 
				
				request.setAttribute(""+id, avg);
			}
			
			request.setAttribute("reviewer", request.getParameter("reviewer"));
		}
		else if(request.getParameter("specializationid") != null)
		{
			int specialization = Integer.parseInt(request.getParameter("specializationid"));
			applicants = ApplicantsModel.getApplicantsBySpecialization(specialization);
			
			while(applicants.next())
			{
				int id = Integer.parseInt(applicants.getString("id").toString());
				
				RowSet grades = ApplicantsModel.getApplicantAvgGrade(id); 
				grades.next();
				
				int count = grades.getInt("count");
				int sum = grades.getInt("sum");
				
				double avg = (double)sum / count; 
				
				request.setAttribute(""+id, avg);
			}
		}
		else if(request.getParameter("majorid") != null)
		{
			int major = Integer.parseInt(request.getParameter("majorid"));
			applicants = ApplicantsModel.getApplicantsByMajor(major);
			
			while(applicants.next())
			{
				int id = Integer.parseInt(applicants.getString("id").toString());
				
				RowSet grades = ApplicantsModel.getApplicantAvgGrade(id); 
				grades.next();
				
				int count = grades.getInt("count");
				int sum = grades.getInt("sum");
				
				double avg = (double)sum / count; 
				
				request.setAttribute(""+id, avg);
			}
		}
		else
		{
			applicants = ApplicantsModel.getApplicants();
			
			while(applicants.next())
			{
				int id = Integer.parseInt(applicants.getString("id").toString());
				
				RowSet grades = ApplicantsModel.getApplicantAvgGrade(id); 
				grades.next();
				
				int count = grades.getInt("count");
				int sum = grades.getInt("sum");
				
				double avg = (double)sum / count; 
				
				request.setAttribute(""+id, avg);
			}
		}
		
		applicants.beforeFirst();
		
		request.setAttribute("applicants", applicants);
		
		return mapping.findForward("success");
	}
}
