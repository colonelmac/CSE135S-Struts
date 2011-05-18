package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.forms.NameForm;

public class NameAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
									HttpServletRequest request, HttpServletResponse response)
	{
		NameForm nf = (NameForm)form;
		HttpSession session = request.getSession();
		
		session.setAttribute("firstName", nf.getFirstName());
		session.setAttribute("lastName", nf.getLastName());
		session.setAttribute("middleIntial", nf.getMiddleInitial());
		
		return mapping.findForward("success");
	}	
}
