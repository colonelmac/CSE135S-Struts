<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="CSE135S.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Verify Application</h2>

<%		
	String countryCode = "";
	if(session.getAttribute("countrycode") != null) 
	{
		countryCode = session.getAttribute("countrycode").toString();
	}
%>

<ul>
	<li><%= session.getAttribute("firstName") + " " + session.getAttribute("middleInitial") + " " + session.getAttribute("lastName") %></li>
	<li>Citizen of: <%= session.getAttribute("citizenshipName") %></li>
	<li>Resident of: <%= session.getAttribute("residenceName") %></li>
	<li><%= session.getAttribute("address") %></li>
	<li><%= session.getAttribute("city") + " " + session.getAttribute("state") + " " + session.getAttribute("zipcode") %></li>
	<li><%= countryCode + " " + session.getAttribute("areacode") + " " + session.getAttribute("phoneNumber") %></li>
</ul>

<ul>
<% 
 	ArrayList<Degree> degrees = (ArrayList<Degree>)session.getAttribute("degrees");

	for(Degree d : degrees)
	{
		out.println(d.toHTMLString());
	}
%>
</ul>

<p>
	<html:link action="/cancelApplication.do">Cancel</html:link>
	<html:link action="/submitApplication.do">Submit</html:link>
</p>

</body>
</html:html>