<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="javax.sql.RowSet" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<%
		RowSet applicants = (RowSet)request.getAttribute("applicants");
	%>

	<h2>Your Workload</h2>

	<ul>
	<%
		while(applicants.next())
		{
			out.println("<li>");
				out.println("<a href='application.do?id=" + applicants.getInt("id") + "'>");
				out.println(applicants.getString("firstname") + " " + applicants.getString("lastname") +"</a>");
			out.println("</li>");			
		}
	%>
	</ul>
</body>
</html:html>