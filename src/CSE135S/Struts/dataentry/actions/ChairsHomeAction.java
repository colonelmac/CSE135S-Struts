package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class ChairsHomeAction extends Action 
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{
	
		if(ReviewersModel.hasReviewStarted())
		{
			return mapping.findForward("started");
		}
		else
		{
			request.setAttribute("reviewers", ReviewersModel.getReviewers());
			
			return mapping.findForward("notstarted");
		}
	}
}
