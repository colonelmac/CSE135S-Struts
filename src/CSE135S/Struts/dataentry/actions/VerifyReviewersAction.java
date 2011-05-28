package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.ReviewersModel;

public class VerifyReviewersAction extends Action 
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{
		
		DynaActionForm daf = (DynaActionForm)form;
		
		ActionErrors errors = new ActionErrors(); 
		
		if(daf.get("username").toString().isEmpty())
			errors.add("username", new ActionMessage("errors.required", "username"));
		
		if(daf.get("password").toString().isEmpty())
			errors.add("password", new ActionMessage("errors.required", "password"));
			
		saveErrors(request, errors);
		
		if(errors.isEmpty())
		{
			ReviewersModel.createReviewer(daf.get("username").toString(), daf.get("password").toString());
			
			return mapping.findForward("success");
		}
		else
		{
			return mapping.findForward("failure");
		}
	}
}
