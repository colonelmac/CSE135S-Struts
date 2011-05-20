<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<% boolean isUSResident = session.getAttribute("residenceName").toString().equalsIgnoreCase("united states") ? true : false; %>
	<% boolean isUSCitizen = session.getAttribute("citizenshipName").toString().equalsIgnoreCase("united states") ? true : false; %>

	<h2>Enter your Address</h2>

	<html:errors />
	
	<html:form action="/address">
		<ul>
			<li><label for="address">Address</label><br /><html:text property="address" /></li>
			<li><label for="city">City</label><br /><html:text property="city" /></li>
			
			<% 
				if(isUSResident || isUSCitizen) 
				{
					out.println("<li><label for='state'>State</label><br />"+
						"<input type='text' id='state' name='state' /></li>"); 
				} 
			%>
			
			<li><label for="zip">ZipCode</label><br /><html:text property="zipcode" /></li>
			<li><label for="phoneNumber">Phone</label><br />
			
			<% 
				if(!isUSResident && !isUSCitizen) 
				{ 
					out.println("<input type='text' size='2' maxlength='2' id='countrycode' name='countrycode' />"); 
				} 
			%>
				<input type="text" size="3" maxlength="3" id="areacode" name="areacode" />
				<input type="text" size="7" maxlength="7" id="phoneNumber" name="phoneNumber" />
			</li>
			<li> </li>
			<li><html:submit/></li>
		</ul>
	</html:form>
	
</body>
</html:html>