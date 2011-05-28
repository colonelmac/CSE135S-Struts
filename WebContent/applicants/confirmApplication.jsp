<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="CSE135S.*" %>
<%@page import="java.util.*"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Application Confirmation</h2>

<%
	UUID uuid = (UUID)session.getAttribute("uuid");
%>

<p>
<%= uuid.toString() %>
</p>

</body>
</html:html>