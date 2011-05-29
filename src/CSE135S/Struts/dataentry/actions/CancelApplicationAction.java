package CSE135S.Struts.dataentry.actions;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

public class CancelApplicationAction extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		Enumeration<String> params = session.getAttributeNames();
		
		while(params.hasMoreElements())
		{
			String key = params.nextElement();
			session.setAttribute(key, null);
		}
		
		session.invalidate();
				
		return mapping.findForward("success");
	}
}
