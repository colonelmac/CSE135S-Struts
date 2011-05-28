<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="javax.sql.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Select Country of Citizenship</h2>

<ul>
<% 
	RowSet countries = (RowSet)request.getAttribute("countries");

	while(countries.next())
	{
		out.println("<li><a href='countryOfResidence.do?citizenshipID="+ countries.getInt("id") + 
					"&citizenshipName=" + countries.getString("name") + "' >");
		out.println(countries.getString("name"));
		out.println("</a></li>");
	}
%>
</ul>
	
</body>
</html:html>