<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="javax.sql.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Select Country of Residence</h2>

<ul>
<% 
	RowSet locations = (RowSet)request.getAttribute("locations");

	while(locations.next())
	{
		out.println("<li><a href='processResidence.do?residenceID=" + locations.getInt("id") + 
					"&residenceName=" + locations.getString("name") + "' >");
		out.println(locations.getString("name"));
		out.println("</a></li>");
	}
%>
</ul>
	
</body>
</html:html>