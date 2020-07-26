<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
    
    <p><a href="/FirstRestAPIProject?siteTheme=green">Green</a></p>
    <p><a href="/FirstRestAPIProject?siteTheme=red">Red</a></p>
    
    <h1>${headerMessage}</h1>
    <h2><spring:message code="label.admissionForm" /></h2>
	<form action="submission" method="post">
		<spring:message code="label.studentName"></spring:message><input type="text" name="studentName" /></br></br>
		<spring:message code="label.studentMobileNo"></spring:message><input type="text" name="studentMobileNo" /></br></br> 
		<input type="submit" value="<spring:message code="label.submit.admissionform"/>"/>
	</form>
</body>
</html>