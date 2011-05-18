<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<html:errors/>

	<html:form action="/name">
		<ul>
			<li>First name: <html:text property="firstName" /></li>
			<li>Last name:<html:text property="lastName" /></li>
			<li>Middle initial: <html:text property="middleInitial" /></li>
			<li></li>
			<li><html:submit value="Submit" /></li>
		</ul>
	</html:form>
	
</body>
</html:html>