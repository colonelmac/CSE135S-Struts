<%@page import="javax.sql.RowSet"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="javax.sql.rowset.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>
	<% 
		RowSet appstatus = (RowSet)request.getAttribute("appstatus");
		
		appstatus.next();
	%>

	<h2>My Application</h2>
	
	<table>
		<tbody>
			<tr>
				<td>Your application id:</td>
				<td style="padding-left: 20px;"><%= appstatus.getObject("uuid") %></td>
			</tr>
			<tr>
				<td>Your application status:</td>
				<td style="padding-left: 20px;"><%= appstatus.getString("status") %></td>
			</tr>	
		</tbody>
	</table>
	
	<% session.invalidate(); %>
	
</body>
</html:html>