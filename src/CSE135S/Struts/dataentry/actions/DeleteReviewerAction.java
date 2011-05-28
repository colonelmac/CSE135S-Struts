package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class DeleteReviewerAction extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("id").toString());
		
		ReviewersModel.deleteReviewer(id);
		
		return mapping.findForward("success");
	}
}
