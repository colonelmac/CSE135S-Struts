package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class MyApplicationAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		
		String user_name = request.getRemoteUser().toString();
		
		boolean hasApplication = MyApplicationModel.findApplicant(user_name);
		
		if(hasApplication)
		{
			request.setAttribute("appstatus", MyApplicationModel.getAppStatus(user_name));
			
			return mapping.findForward("success");
		}
		else
		{
			return mapping.findForward("failure");
		}
	}
}
