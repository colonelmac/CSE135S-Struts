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
		String reviewer = request.getParameter("reviewer");
		RowSet applicants = (RowSet)request.getAttribute("applicants");
	%>

	<h2><% if(reviewer != null) out.println(reviewer + "'s "); %> Applications</h2>

	<table>
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Average Grade</th>
			<th>Status</th>
			<th>Actions</th>
		<thead>
		<tbody>
		<%
			while(applicants.next())
			{
				int id = applicants.getInt("id"); 
				
				out.println("<tr>");
					out.println("<td>");
						out.println(applicants.getString("firstname"));
					out.println("</td>");
					out.println("<td>");
						out.println(applicants.getString("lastname"));
					out.println("</td>");
					out.println("<td>");
						//put grade here
					out.println("</td>");
					out.println("<td>");
						out.println(applicants.getString("status"));
					out.println("</td>");
					switch(applicants.getInt("statusid"))
					{
						case 2:
							out.println("<td>");
								out.println("<a href='acceptApplicant.do?id=" + id + "'>Accept</a>");
							out.println("</td>");
							out.println("<td>");
								out.println("<a href='rejectApplicant.do?id=" + id + "'>Reject</a>");
							out.println("</td>");
							break;
						case 4:
							out.println("<td>");
							out.println("<a href='rejectApplicant.do?id=" + id + "'>Reject</a>");
						out.println("</td>");
							out.println("<td>");
								out.println("<a href='cancelApplicant.do?id=" + id + "'>Cancel Decision</a>");
							out.println("</td>");
							break;
						case 5:
							out.println("<td>");
								out.println("<a href='acceptApplicant.do?id=" + id + "'>Accept</a>");
							out.println("</td>");
							out.println("<td>");
							out.println("<td>");
								out.println("<a href='cancelApplicant.do?id=" + id + "'>Cancel Decision</a>");
							out.println("</td>");
							break;
					}
					
				out.println("</tr>");
			}
		%>
		</tbody>
	</table>

</body>
</html:html>