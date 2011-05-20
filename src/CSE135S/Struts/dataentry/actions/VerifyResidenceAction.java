package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

public class VerifyResidenceAction extends Action 
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
	
		boolean isUSResident = session.getAttribute("residenceName").toString().equalsIgnoreCase("united states") ? true : false;
		
		if(isUSResident)
			return mapping.findForward("verify");
		else
			return mapping.findForward("success");
	}
}
