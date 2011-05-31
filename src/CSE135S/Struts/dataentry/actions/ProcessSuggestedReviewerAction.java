package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class ProcessSuggestedReviewerAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{ 
		DynaActionForm daf = (DynaActionForm)form;
		
		int reviewer = Integer.parseInt(daf.get("suggestedReviewer").toString());
		int applicant = Integer.parseInt((request.getSession().getAttribute("applicantid").toString()));
		
		ReviewersModel.assignReviewer(reviewer, applicant);
		
		return mapping.findForward("success");
	}
}
