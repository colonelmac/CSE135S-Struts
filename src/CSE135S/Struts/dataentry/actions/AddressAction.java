package CSE135S.Struts.dataentry.actions;


import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

public class AddressAction extends Action 
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		DynaActionForm daf = (DynaActionForm)form;
		
		ActionMessages errors = new ActionMessages();
		
		if(daf.get("address").toString().isEmpty())
			errors.add("address", new ActionMessage("address is required"));
		
		if(daf.get("city").toString().isEmpty())
			errors.add("city", new ActionMessage("city is required"));
			
		if(daf.get("zipcode").toString().isEmpty())
			errors.add("zipcode", new ActionMessage("zipcode is required"));
		
		if(daf.get("areacode").toString().isEmpty())
			errors.add("areacode", new ActionMessage("areacode is required"));
		
		if(daf.get("phoneNumber").toString().isEmpty())
			errors.add("phoneNumber", new ActionMessage("areacode is required"));
		
		Set<String> params = daf.getMap().keySet();
		
		for(String k : params)
		{
			session.setAttribute(k, daf.get(k));
		}
		
		if(errors.isEmpty())
			return mapping.findForward("success");
		else
			return mapping.findForward("failure");
	}
}
