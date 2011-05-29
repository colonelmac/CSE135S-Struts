package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;

import java.sql.SQLException;
import java.util.*;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class BeginReviewAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws SQLException
	{
		
		ArrayList<Integer> applicants = ApplicantsModel.getUnassignedApplicants();
		ArrayList<Integer> reviewers = new ArrayList<Integer>();
		
		RowSet rs = (RowSet)ReviewersModel.getReviewers();
		
		while(rs.next())
		{
			reviewers.add(rs.getInt("id"));
		}
		
		int r = 0;
		
		for(int a : applicants)
		{
			if(r == reviewers.size())
				r = 0;
			
			ReviewersModel.assignReviewer(reviewers.get(r), a);
			
			r++;
		}
		
		ReviewersModel.startReview();
		
		return mapping.findForward("success");
	}
}
