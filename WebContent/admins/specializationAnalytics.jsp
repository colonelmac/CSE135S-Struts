<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="javax.sql.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<% 
	RowSet specializations = (RowSet)request.getAttribute("specializations");
%>

	<h2>Specialization Analytics</h2>

	<table>
		<thead>
			<th>Specialization</th>
			<th>Applicant Count</th>
		</thead>
		<tbody>
		<%
			while(specializations.next())
			{
				out.println("<tr>");
					out.println("<td>");
						out.println(specializations.getString("name"));
					out.println("</td>");
					out.println("<td>");
						out.println("<a href='applications.do?specializationid=" + specializations.getInt("id") + "'>" 
								+ specializations.getInt("applicantcount") + "</a>");
					out.println("</td>");
				out.println("</tr>");
				
			}
		%>
		</tbody>
	</table>

</body>
</html:html>