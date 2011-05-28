package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;
import java.util.*;
import CSE135S.Degree;

public class ProcessDegreeAction extends Action
{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		DynaActionForm daf = (DynaActionForm)form;
		ActionErrors errors = new ActionErrors();
		
		int major = 0;
		int year = 0;
		int gpa = 0;
		int month = 0;
		int university = Integer.parseInt(session.getAttribute("universityID").toString());
		String title = null;
		
		if(((String)daf.get("major")).isEmpty())
			errors.add("major", new ActionMessage("major is required"));
		else
			major = Integer.parseInt(daf.get("major").toString());
			
		if(daf.get("title").toString().isEmpty())
			errors.add("title", new ActionMessage("title is required"));
		else
			title = daf.get("title").toString();
			
		if(daf.get("gpa").toString().isEmpty())
			errors.add("gpa", new ActionMessage("gpa is required"));
		else
			gpa = Integer.parseInt(daf.get("gpa").toString());
		
		if(daf.get("month").toString().isEmpty())
			errors.add("month", new ActionMessage("month is required"));
		else
			month = Integer.parseInt(daf.get("month").toString());
			
		if(daf.get("year").toString().isEmpty())
			errors.add("year", new ActionMessage("year is required"));
		
		saveErrors(request, errors);
		
		if(errors.isEmpty())
		{
			Degree degree = new Degree(major, month, year, title, university, gpa);
			
			ArrayList<Degree> degrees;
			
			if( session.getAttribute("degrees") == null)
			{
				degrees = new ArrayList<Degree>();
			}
			else
			{
				degrees = (ArrayList<Degree>)session.getAttribute("degrees");
			}
	
			degrees.add(degree);
			
			session.setAttribute("degrees", degrees);
		
			return mapping.findForward("success");
		}
		else
			return mapping.findForward("failure");
	}
}
