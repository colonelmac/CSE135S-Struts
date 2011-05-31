<%@page import="CSE135S.Degree"%>
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
		RowSet applicant = (RowSet)request.getAttribute("applicant");
		RowSet degrees = (RowSet)request.getAttribute("degrees");
		
		if(applicant != null)
			applicant.next();
	%>

	<%
		if(applicant != null)
		{
			out.println("<h2>" + applicant.getString("firstname") + " " + applicant.getString("lastname") + "</h2>");
		
			out.println("<ul>");
			out.println("<li>Citizenship: " + applicant.getInt("citizenshipid") + "</li>");
			out.println("<li>Residence: " + applicant.getInt("residenceid") + "</li>");
			out.println("<li>" + applicant.getString("address") + "</li>");
			out.println("<li>" + applicant.getString("city") + ", " + applicant.getString("state") + "</li>");
			out.println("<li>" + applicant.getInt("zipcode") + "</li>");
			out.println("<li>" + applicant.getInt("countrycode") + " " + applicant.getInt("areacode") + " " + applicant.getInt("phonenumber") + "</li>");
			out.println("</ul>");
		}
	 %>
	
	<ul>
	<%
		if(degrees != null)
		{
			while(degrees.next())
			{
				Degree d = new Degree();
				d.university = degrees.getInt("universityid");
				d.major = degrees.getInt("majorid");
				d.title = degrees.getString("title");
				d.graduationDate = degrees.getDate("graduationdate");
				d.gpa = degrees.getInt("gpa");
				
				out.println("<li>");
					out.println(d.toHTMLString());
					out.println(" - <i>graduating gpa of: </i>" + d.gpa);
				out.println("</li>");
			}
		}
	%>
	</ul>
	
	<html:errors />
	
	<html:form action="/reviewers/processReview">
		<ul>
			<li>
				<label for="grade">Applicant Grade</label><br />
				<html:select property="grade">
					<html:option value="1">1</html:option>
					<html:option value="2">2</html:option>
					<html:option value="3">3</html:option>
					<html:option value="4">4</html:option>
				</html:select>
			</li>
			<li>
				<label for="comments">Reviewer Comments</label><br />
				<html:textarea property="comments" style="width: 300px; height: 200px"></html:textarea>
			</li>
			<li><html:submit></html:submit></li>
		</ul>
	</html:form>
	
</body>
</html:html>