<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

	<h3>Verify Residence Type</h3>

	<form id="form1" name="form1" method="post" action="provideDegreeLocation.do">
		
		<ul>
			<li><label>I am a...</label><br />
				<input type="radio" id="nametrue" name="domesticApplicant" value="true" /><label for="nametrue">US Permanent Resident</label>
				<input type="radio" id="namefalse" name="domesticApplicant" value="false" checked="false" /><label for="namefalse">Non-Resident</label>
			</li>
			<li> </li>
			<li><input type="submit" value="Submit" /></li>
		</ul>
		
	</form>

</body>
</html>