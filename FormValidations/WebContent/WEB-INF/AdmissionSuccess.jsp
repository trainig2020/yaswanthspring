<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>

	<h1>Congraulations Your records Has been Submitted Successfuly</h1>



	<table>
		<tr>
			<td>Student Name</td>
			<td>${student1.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby</td>
			<td>${student1.studentHobby}</td>
		</tr>
		<tr>
			<td>Student Mobile</td>
			<td>${student1.studentMobile}</td>
		</tr>
		<tr>
			<td>Student DOB</td>
			<td>${student1.studentDOB}</td>
		</tr>
		<tr>
			<td>Student Skills</td>
			<td>${student1.studentSkills}</td>
		</tr>
		<tr>
		    <td>Student Address :</td>
		    <td>${student1.studentaddress.country}</td>
		     <td>${student1.studentaddress.city}</td>
		      <td>${student1.studentaddress.street}</td>
		       <td>${student1.studentaddress.pincode}</td>
		</tr>
	</table>
</body>
</html>