package CSE135S.Struts.dataentry.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class NameForm extends ActionForm 
{
	private String firstName;
	private String lastName;
	private String middleInitial;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	/*
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
	{
		ActionErrors errors = new ActionErrors();
		
		if( firstName.isEmpty() )
		{
			errors.add("firstNameMessage", new ActionMessage("errors.required", firstName));
		}
		
		if( lastName.isEmpty() )
		{
			errors.add("lasteNameMessage", new ActionMessage("errors.required", lastName));
		}
		
		if( middleInitial.isEmpty() )
		{
			errors.add("middleInitialMessage", new ActionMessage("errors.required", middleInitial));
		}
		
		return errors;
	}*/
}
