<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page import="javax.sql.*" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

<h2>Select Degree Major</h2>

	<html:form action="/processDegree">
	
		Major
		<ul>
		<% 
			RowSet majors = (RowSet)request.getAttribute("majors");
		
			while(majors.next())
			{
				out.println("<li>");
				out.println("<input type='radio' id='" + majors.getString("name") + "' name='major' value='" + majors.getInt("id") + "' />");
				out.println("<label for='" + majors.getString("name") + "' >" + majors.getString("name") + "</label>");
				out.println("</li>");
			}
		%>
		</ul>
		
		Degree Title
		<div>
			<select id="title" name="title">
				<option>BS</option>
				<option>BA</option>
				<option>MS</option>
				<option>PhD</option>
			</select>
		</div>
		
		GPA
		<div>
			<select id="gpa" name="gpa">
				<option>4</option>
				<option>3.7</option>
				<option>3.3</option>
				<option>3</option>
				<option>2.7</option>
				<option>2.3</option>
				<option>2</option>
				<option>1.7</option>
			</select>
		</div>
			
		Graduation Date
		<div>
		    <select id="month" name="month">
		           <option value="1">January</option>
		           <option value="2">February</option>
		           <option value="3">March</option>
		           <option value="4">April</option>
		           <option value="5">May</option>
		           <option value="6">June</option>
		           <option value="7">July</option>
		           <option value="8">August</option>
		           <option value="9">September</option>
		           <option value="10">October</option>
		           <option value="11">November</option>
		           <option value="12">December</option>
		    </select>
		    <select id="year" name="year">
	    	<%
	    		for(int i = 1970; i < 2020; i++) {
	    			
	    			out.println("<option>" + i + "</option>");
	    		}
	    	%>
		    </select>
		</div>
	
		<html:submit value="Submit" />
		
	</html:form>
	
</body>
</html:html>