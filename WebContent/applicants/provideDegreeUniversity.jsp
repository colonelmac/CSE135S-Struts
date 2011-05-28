<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="javax.sql.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Select University</h2>

<ul>
<% 
	RowSet universities = (RowSet)request.getAttribute("universities");

	while(universities.next())
	{
		out.println("<li><a href='provideDegreeMajor.do?universityID=" + universities.getInt("id") + 
					"&universityName=" + universities.getString("name") + "' >");
		out.println(universities.getString("name"));
		out.println("</a></li>");
	}
%>
</ul>
	
</body>
</html:html>