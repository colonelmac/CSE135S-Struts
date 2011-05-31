package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.ApplicantsModel;

public class AcceptApplicantAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{
		int applicant = Integer.parseInt(request.getParameter("id"));
		
		ApplicantsModel.updateApplicantStatus(applicant, "accept");

		return mapping.findForward("success");
	}
}
