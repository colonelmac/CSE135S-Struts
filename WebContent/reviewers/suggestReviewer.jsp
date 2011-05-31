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
		RowSet reviewers = (RowSet)request.getAttribute("reviewers");
	%>

	<h2>Suggest Reviewer</h2>
	
	<html:form action="/reviewers/processSuggestedReviewer">
		
		Available Reviewers: 
		<html:select property="suggestedReviewer">
		<%
			while(reviewers.next())
			{
				out.println("<option value='" + reviewers.getInt("user_ref") + "'>");
				out.println(reviewers.getString("user_name"));
				out.println("</option>");
			}
		%>
		</html:select>
	
		<html:submit></html:submit>
	
	</html:form>

</body>
</html:html>