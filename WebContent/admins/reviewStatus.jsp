<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<h2>Review Status</h2>

	<ul>
		<li><html:link action="/admins/applicationsByReviewer">Applications by Reviewer</html:link>
		<li><html:link action="/admins/specializationAnalytics">Specialization Analytics</html:link>
		<li><html:link action="/admins/disciplineAnalytics">Discipline Analytics</html:link>
	</ul>
	
</body>
</html:html>