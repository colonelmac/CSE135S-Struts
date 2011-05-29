package CSE135S.Struts.dataentry.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class ApplicationsByReviewerAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{
		RowSet reviewers = ReviewersModel.getReviewers();
		
		HashMap<String, String> map = new HashMap<String, String>(); 
		
		try
		{
			while(reviewers.next())
			{
				int id = reviewers.getInt("id");
				String count = "" + ReviewersModel.getApplicantCountByReviewer(id);
				
				map.put(reviewers.getString("user_name"), count);
			}
		}
		catch(Exception ex)
		{
			//do something
		}
		
		request.setAttribute("reviewers", map);
		
		return mapping.findForward("success");
	}
}
