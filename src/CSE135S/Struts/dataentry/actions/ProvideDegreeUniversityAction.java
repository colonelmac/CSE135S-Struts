package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class ProvideDegreeUniversityAction extends Action
{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{		
		int locationid = Integer.parseInt(request.getParameter("universityLocationID"));
		
		RowSet universities = UniversitiesModel.getUniversitiesById(locationid);
		
		request.setAttribute("universities", universities);
		
		return mapping.findForward("success");
	}
}
