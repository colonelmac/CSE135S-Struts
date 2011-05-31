package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import CSE135S.Struts.dataentry.models.ReviewersModel;

public class ProcessReviewAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{ 
		int grade = 0;
		String comment = null;
		int applicantid = Integer.parseInt(request.getSession().getAttribute("applicantid").toString());
		String reviewer = request.getRemoteUser();
		
		DynaActionForm daf = (DynaActionForm)form;
		
		ActionErrors errors = new ActionErrors();
		
		if(daf.get("grade").toString().isEmpty())
			errors.add("", new ActionMessage("errors.required", "grade"));
		else 
			grade = Integer.parseInt(daf.get("grade").toString());
		
		if(daf.get("comments").toString().isEmpty())
			errors.add("", new ActionMessage("errors.required", "comments")); 
		else
			comment = daf.get("comments").toString();
			
		saveErrors(request, errors);
		
		if(errors.isEmpty())
		{
			ReviewersModel.createReviewerComment(grade, comment, applicantid, reviewer);
			
			if(ReviewersModel.getApplicantReviewCount(applicantid) >= 3)
			{
				ReviewersModel.assignReviewer(0, applicantid);
				return mapping.findForward("complete");
			}
			
			return mapping.findForward("suggest");
		}
		else
		{
			return mapping.getInputForward();
		}
	}
}
