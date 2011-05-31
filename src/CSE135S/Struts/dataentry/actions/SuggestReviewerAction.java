package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.ReviewersModel;

public class SuggestReviewerAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{ 
		int applicant = Integer.parseInt(request.getSession().getAttribute("applicantid").toString());
		
		request.setAttribute("reviewers", ReviewersModel.getSuggestedReviewers(applicant));
		
		return mapping.findForward("success");
	}
}
