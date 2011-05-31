package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class ReviewersDefaultAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{
		
		String reviewer = request.getRemoteUser();
		
		request.setAttribute("applicants", ReviewersModel.getApplicantsByReviewer(reviewer));
		
		return mapping.findForward("success");
	}
}
