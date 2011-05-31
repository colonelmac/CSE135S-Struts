<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>	

	<%
		String accept = "acceptApplicant.do?id=" + session.getAttribute("applicantid").toString();
		String reject = "rejectApplicant.do?id=" + session.getAttribute("applicantid").toString();
	%>

	<h2>Decide Applicant Status</h2>

	<a href=<%= accept %>>Accept</a>
	<a href=<%= reject %>>Reject</a>
	<a href=reviewerDefault.do>Undecided</a>
	
</body>
</html:html>