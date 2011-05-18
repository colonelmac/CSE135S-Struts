package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.RowSet;

import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.LocationsModel;

public class ResidenceAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		session.setAttribute("citizenshipID", request.getParameter("citizenshipID"));
		session.setAttribute("citizenshipName", request.getParameter("citizenshipName"));
		
		boolean inUS = request.getParameter("citizenshipName").equalsIgnoreCase("united states") ? true : false ; 
		
		RowSet locations = null;
		
		if(!inUS)
		{
			locations = LocationsModel.getAllCountries(false);
		}
		else
		{
			locations = LocationsModel.getAllStates();
		}
		
		request.setAttribute("locations", locations);
		
		return mapping.findForward("success");
	}
}
