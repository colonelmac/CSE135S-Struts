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
	RowSet disciplines = (RowSet)request.getAttribute("disciplines");
%>

	<h2>Discipline Analytics</h2>

	<table>
		<thead>
			<th>Specialization</th>
			<th>Applicant Count</th>
		</thead>
		<tbody>
		<%
			while(disciplines.next())
			{
				out.println("<tr>");
					out.println("<td>");
						out.println(disciplines.getString("name"));
					out.println("</td>");
					out.println("<td>");
						out.println("<a href='applications.do?majorid=" + disciplines.getInt("id") + "'>" + 
								disciplines.getInt("applicantcount") + "</a>");
					out.println("</td>");
				out.println("</tr>");
				
			}
		%>
		</tbody>
	</table>

</body>
</html:html>