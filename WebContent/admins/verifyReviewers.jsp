<%@page import="javax.sql.RowSet"%>
<%@page import="java.util.*, javax.sql.rowset.*"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Verify Reviewers</h2>

<ul>
<% 
	int reviewerCount = 0;

	if(request.getAttribute("reviewers") != null)
	{
	 	RowSet reviewers = (RowSet)request.getAttribute("reviewers");
	
		while(reviewers.next())
		{
			out.println("<li>");
			out.println(reviewers.getString(2) + " <a href='deleteReviewer.do?id=" + 
						reviewers.getInt(1) + "'>Delete</a>");
			out.println("</li>");
			
			reviewerCount++;
		}
	}
%>
</ul>

<html:errors />

Add a new reviewer:
<html:form action="/admins/verifyReviewers">
	Username: <html:text property="username"></html:text> <br />
	Password: <html:password property="password"></html:password>
	<html:submit></html:submit>
</html:form>

<% 
	if(reviewerCount > 1)
		out.println("<a href='/admins/beginReview.do'>Begin Review Process</a>");
%>

</body>
</html:html>