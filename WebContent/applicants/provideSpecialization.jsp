<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="javax.sql.RowSet"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<h2>Select Your Desired Specialization</h2>

	<html:form action="/applicants/processSpecialization">
	
		<select name="specialization">
			<%
				RowSet specializations = (RowSet)request.getAttribute("specializations");
			
				while(specializations.next())
				{
					out.println("<option value='" + specializations.getInt(1) + "'>");
					out.println(specializations.getString(2));
					out.println("</option>");
				}
			%>
		</select>
		
		<html:submit />
	</html:form>

</body>
</html:html>