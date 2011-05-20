package CSE135S.Struts.dataentry.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.RowSet;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.*;

public class ProvideDegreeMajorAction extends Action
{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		session.setAttribute("universityID", request.getParameter("universityID"));
		session.setAttribute("universityName", request.getParameter("universityName"));
		
		RowSet majors = MajorsModel.getMajors();
		
		request.setAttribute("majors", majors);
		
		return mapping.findForward("success");
	}
}
