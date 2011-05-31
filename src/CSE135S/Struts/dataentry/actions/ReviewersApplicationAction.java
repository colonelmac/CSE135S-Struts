package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.ApplicantsModel;

public class ReviewersApplicationAction  extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{ 
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.getSession().setAttribute("applicantid", id);
		
		request.setAttribute("applicant", ApplicantsModel.getApplicantById(id));
		
		request.setAttribute("degrees", ApplicantsModel.getApplicantDegrees(id));
		
		return mapping.findForward("success");
	}
}
