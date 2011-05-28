<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html>
<head>
	<title></title>
	<html:base/>
</head>
<body>

	<html:errors/>

	<html:form action="/register">
		Username: <html:text property="username" /><br />
		Password: <html:text property="password1" /><br />
		Confirm: <html:text property="password2" /><br />
		<html:submit value="Submit" />
	</html:form>
	
</body>
</html:html>