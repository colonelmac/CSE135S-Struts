package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.ApplicantsModel;


public class ApplicationsAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{
		RowSet applicants = null;
		
		if(request.getParameter("reviewer") != null)
		{
			applicants = ApplicantsModel.getApplicants(request.getParameter("reviewer"));
			request.setAttribute("reviewer", request.getParameter("reviewer"));
		}
		else
		{
			applicants = ApplicantsModel.getApplicants();
		}
		
		request.setAttribute("applicants", applicants);
		
		return mapping.findForward("success");
	}
}
