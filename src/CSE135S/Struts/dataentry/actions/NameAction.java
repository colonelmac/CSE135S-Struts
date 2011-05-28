package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

public class NameAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
									HttpServletRequest request, HttpServletResponse response)
	{
		DynaActionForm daf = (DynaActionForm)form;
		HttpSession session = request.getSession();
		
		ActionMessages errors = new ActionMessages();
		
		if(daf.get("firstName").toString().isEmpty())
			errors.add("firstName", new ActionMessage("errors.required", "First name"));
		else
			session.setAttribute("firstName", daf.get("firstName").toString());

		if(daf.get("lastName").toString().isEmpty())
			errors.add("lastName", new ActionMessage("errors.required", "Last name"));
		else
			session.setAttribute("lastName", daf.get("lastName").toString());

		if(daf.get("middleInitial").toString().isEmpty())
			errors.add("middleInitial", new ActionMessage("errors.required", "Middle initial"));
		else
			session.setAttribute("middleInitial", daf.get("middleInitial").toString());
		
		saveErrors(request, errors);
		
		if(errors.isEmpty())		
			return mapping.findForward("success");
		else
			return mapping.findForward("failure");
	}	
}
