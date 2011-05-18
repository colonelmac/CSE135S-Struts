package app;
import org.apache.struts.action.*;
import org.apache.tomcat.jni.Directory;

import javax.servlet.http.*;
import java.io.*;

public class RegisterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
									HttpServletRequest request, HttpServletResponse response) {
		
		RegisterForm rf = (RegisterForm)form;
		
		String username = rf.getUsername();
		String password1 = rf.getPassword1();
		String password2 = rf.getPassword2();
		
		if(password1.equals(password2)) {
			
			return mapping.findForward("success");
		}
		else
		{
			return mapping.findForward("failure");
		}
	}
	
	
}
