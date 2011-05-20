package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

public class ProcessResidenceAction extends Action
{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		session.setAttribute("residenceID", request.getParameter("residenceID"));
		session.setAttribute("residenceName", request.getParameter("residenceName"));
	
		if(session.getAttribute("residenceName").toString().equalsIgnoreCase("united states"))
			session.setAttribute("domesticApplicant", true);
		else
			session.setAttribute("domesticApplicant", false);
			
		return mapping.findForward("success");
	}
}
