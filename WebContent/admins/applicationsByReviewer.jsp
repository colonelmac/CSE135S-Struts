<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="java.util.*"%>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<h2>Applications by Reviewer</h2>

	<table>
		<thead>
			<th>Reviewer</th>
			<th>Applicant Count</th>
		</thead>
		<tbody>
		<%
			HashMap<String, String> map = (HashMap<String, String>)request.getAttribute("reviewers");
		
			Set<String> reviewers = map.keySet();
			
			for(String s : reviewers)
			{
				out.println("<tr>");
					out.println("<td>");
						out.println(s);
					out.println("</td>");
					out.println("<td>");
						out.println("<a href='applications.do?reviewer=" + s + "' >" + map.get(s) + "</a>");
					out.println("</td>");
				out.println("</tr>");
			}
		%>
		</tbody>
	</table>

</body>
</html:html>