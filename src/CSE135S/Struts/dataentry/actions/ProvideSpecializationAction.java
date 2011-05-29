package CSE135S.Struts.dataentry.actions;

import javax.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import CSE135S.Struts.dataentry.models.MajorsModel;

public class ProvideSpecializationAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
	{
		
		request.setAttribute("specializations", MajorsModel.getSpecialization());
		
		return mapping.findForward("success");
	}
}
