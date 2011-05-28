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
			errors.add("address", new ActionMessage("errors.required", "Address"));
		
		if(daf.get("city").toString().isEmpty())
			errors.add("city", new ActionMessage("errors.required", "City"));
			
		try 
		{
			int z = Integer.parseInt(daf.get("zipcode").toString());
		}
		catch(Exception ex)
		{
			errors.add("zipcode", new ActionMessage("errors.required", "Zipcode"));
		}
	
		try 
		{
			int a = Integer.parseInt(daf.get("areacode").toString());
		}
		catch(Exception ex)
		{
			errors.add("areacode", new ActionMessage("errors.required", "Areacode"));
		}
		
		try 
		{
			int p = Integer.parseInt(daf.get("phoneNumber").toString());
		}
		catch(Exception ex)
		{
			errors.add("phoneNumber", new ActionMessage("errors.required", "Phone number"));
		}
		
		saveErrors(request, errors);
		
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
