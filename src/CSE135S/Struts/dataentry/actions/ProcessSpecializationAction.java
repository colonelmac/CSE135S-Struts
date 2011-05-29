package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

public class ProcessSpecializationAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(); 
		
		session.setAttribute("specializationid", request.getParameter("specialization"));
		
		return mapping.findForward("success");
	}
}
