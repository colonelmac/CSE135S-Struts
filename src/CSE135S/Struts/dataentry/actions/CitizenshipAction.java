package CSE135S.Struts.dataentry.actions;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;

import org.apache.struts.action.ActionMapping;

import CSE135S.Struts.dataentry.models.LocationsModel;

public class CitizenshipAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		RowSet rs = LocationsModel.getAllCountries(true);
		
		request.setAttribute("countries", rs);
		
		return mapping.findForward("success");
	}
}
