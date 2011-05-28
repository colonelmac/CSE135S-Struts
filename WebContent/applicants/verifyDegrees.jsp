<%@page import="java.util.*"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="CSE135S.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Verify Degrees</h2>

<ul>
<% 
 	ArrayList<Degree> degrees = (ArrayList<Degree>)session.getAttribute("degrees");

	for(Degree d : degrees)
	{
		out.println(d.toHTMLString());
	}
%>
</ul>

<html:link action="/applicants/provideDegreeLocation.do">Add another Degree</html:link>

<p>
	<html:link action="/applicants/cancelApplication.do">Cancel</html:link>
	<html:link href="verifyApplication.jsp">Continue</html:link>
</p>

</body>
</html:html>