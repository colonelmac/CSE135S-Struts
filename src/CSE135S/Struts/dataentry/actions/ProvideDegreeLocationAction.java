package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.RowSet;
import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.LocationsModel;


public class ProvideDegreeLocationAction extends Action
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{
		
		HttpSession session = request.getSession();
		
		session.setAttribute("domesticApplicant", request.getParameter("domesticApplicant"));
		
		boolean isUSCitizen = session.getAttribute("citizenshipName").toString().equalsIgnoreCase("united states") ? true : false ;
		boolean isUSResident = session.getAttribute("residenceName").toString().equalsIgnoreCase("united states") ? true : false;
		
		RowSet locations = null;
		
		if(!isUSCitizen && !isUSResident)
		{
			locations = LocationsModel.getAllCountries(true);
		}
		else
		{
			locations = LocationsModel.getAllStates();
		}
		
		request.setAttribute("locations", locations);
		
		return mapping.findForward("success");
	}
}
