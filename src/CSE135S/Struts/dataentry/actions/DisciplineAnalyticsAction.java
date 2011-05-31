package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class DisciplineAnalyticsAction extends Action 
{

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		
		request.setAttribute("disciplines", ApplicantsModel.getMajors());
		
		return mapping.findForward("success");
	}
}
