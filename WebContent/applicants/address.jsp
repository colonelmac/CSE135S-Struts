<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<h2>Enter your Address</h2>

	<html:errors />
	
	<html:form action="/applicants/address">
		<ul>
			<li><label for="address">Address</label><br /><html:text property="address" /></li>
			<li><label for="city">City</label><br /><html:text property="city" /></li>
			
			<logic:equal parameter="residenceName" value="United States">
				<li><label for='state'>State</label><br /><html:text property="state" /></li>
			</logic:equal>
			 
			 
			<li><label for="zip">ZipCode</label><br /><html:text property="zipcode" /></li>
			<li>
				<label for="phoneNumber">Phone</label><br />
			
				<logic:notEqual parameter="residenceName" value="United States">
					<html:text size='2' maxlength='2' property="countrycode" />
			 	</logic:notEqual>
			 	
				<html:text size="3" maxlength="3" property="areacode" />
				<html:text size="7" maxlength="7" property="phoneNumber" />
			</li>
			<li> </li>
			<li><html:submit/></li>
		</ul>
	</html:form>
	
</body>
</html:html>